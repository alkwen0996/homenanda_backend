package com.home.nanda.user.controller;

import com.home.nanda.user.model.dto.User;
import com.home.nanda.user.service.JwtService;
import com.home.nanda.user.service.UserService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin("*")
@RestController
public class UserController {
    public static final Logger logger = LoggerFactory.getLogger(UserController.class);
    private static final String SUCCESS = "SUCCESS";
    private static final String FAIL = "FAIL";
    private final UserService userService;
    private final JwtService jwtService;

    @Autowired
    public UserController(final UserService userService, final JwtService jwtService) {
        this.userService = userService;
        this.jwtService = jwtService;
    }

    @GetMapping("/users/admin")
    private ResponseEntity<List<User>> findAllUsers(final HttpServletRequest request) {
        final List<User> allUsers = userService.findAllUsers();

        return new ResponseEntity<>(allUsers, HttpStatus.OK);
    } // 전체회원목록 검색.

    @GetMapping("/users/{userId}")
    private ResponseEntity<User> findUserById(@PathVariable final String userId) {
        final User userById = userService.findUserById(userId);

        return new ResponseEntity<>(userById, HttpStatus.OK);
    } // 특정유저 조회.

    @PostMapping("/users")
    private ResponseEntity<Void> joinUser(@RequestBody final User user) {
        System.out.println(user.toString());
        userService.joinUser(user);

        return new ResponseEntity<>(HttpStatus.OK);
    } // 회원가입

    @PutMapping("/users")
    private ResponseEntity<Void> updateUser(@RequestBody final User user) {
        userService.updateUser(user);

        return new ResponseEntity<>(HttpStatus.OK);
    } // 회원정보 수정

    @DeleteMapping("/users/{userId}")
    private ResponseEntity<Void> deleteUser(@PathVariable final String userId) {
        userService.deleteUser(userId);

        return new ResponseEntity<>(HttpStatus.OK);
    } // 회원삭제

    @PostMapping("/users/login")
    public ResponseEntity<Map<String, Object>> login(
            @RequestBody @ApiParam(value = "로그인 시 필요한 회원정보(아이디, 비밀번호).", required = true) User user) {
        final Map<String, Object> resultMap = new HashMap<>();
        HttpStatus status;

        try {
            final User loginUser = userService.loginUser(user);

            final String accessToken = jwtService.createAccessToken("userId", loginUser.getUserId());// key, data
            final String refreshToken = jwtService.createRefreshToken("userId", loginUser.getUserId());// key, data

            userService.saveRefreshToken(user.getUserId(), refreshToken);

            logger.debug("로그인 accessToken 정보 : {}", accessToken);
            logger.debug("로그인 refreshToken 정보 : {}", refreshToken);

            resultMap.put("access-token", accessToken);
            resultMap.put("refresh-token", refreshToken);
            resultMap.put("message", SUCCESS);

            status = HttpStatus.ACCEPTED;
        } catch (Exception e) {
            logger.error("로그인 실패 : {}", e);
            resultMap.put("message", e.getMessage());
            status = HttpStatus.INTERNAL_SERVER_ERROR;
        }

        return new ResponseEntity<>(resultMap, status);
    }

    @ApiOperation(value = "회원인증", notes = "회원 정보를 담은 토큰을 반환한다.", response = Map.class)
    @GetMapping("/users/info/{userId}")
    public ResponseEntity<Map<String, Object>> getInfo(
            @PathVariable @ApiParam(value = "인증할 회원의 아이디.", required = true) String userId,
            HttpServletRequest request) {
        logger.debug("userId : {} ", userId);

        final Map<String, Object> resultMap = new HashMap<>();
        HttpStatus status;

        if (jwtService.checkToken(request.getHeader("access-token"))) {
            logger.info("사용 가능한 토큰!!!");
            try {
                // 로그인 사용자 정보.
                final User user = userService.userInfo(userId);

                resultMap.put("userInfo", user);
                resultMap.put("message", SUCCESS);

                status = HttpStatus.ACCEPTED;
            } catch (Exception e) {
                logger.error("정보조회 실패 : {}", e);
                resultMap.put("message", e.getMessage());
                status = HttpStatus.INTERNAL_SERVER_ERROR;
            }
        } else {
            logger.error("사용 불가능 토큰!!!");
            resultMap.put("message", FAIL);
            status = HttpStatus.UNAUTHORIZED;
        }
        return new ResponseEntity<>(resultMap, status);
    }

    @ApiOperation(value = "로그아웃", notes = "회원 정보를 담은 토큰을 제거한다.", response = Map.class)
    @GetMapping("/users/logout/{userId}")
    public ResponseEntity<?> removeToken(@PathVariable("userId") String userId) {
        final Map<String, Object> resultMap = new HashMap<>();
        HttpStatus status;

        try {
            userService.deleteRefreshToken(userId);
            resultMap.put("message", SUCCESS);
            status = HttpStatus.ACCEPTED;
        } catch (Exception e) {
            logger.error("로그아웃 실패 : {}", e);
            resultMap.put("message", e.getMessage());
            status = HttpStatus.INTERNAL_SERVER_ERROR;
        }

        return new ResponseEntity<>(resultMap, status);
    }

    @ApiOperation(value = "Access Token 재발급", notes = "만료된 access token을 재발급받는다.", response = Map.class)
    @PostMapping("/users/refresh")
    public ResponseEntity<?> refreshToken(@RequestBody User user, HttpServletRequest request) {
        final Map<String, Object> resultMap = new HashMap<>();
        HttpStatus status = HttpStatus.ACCEPTED;
        final String token = request.getHeader("refresh-token");

        logger.debug("token : {}, memberDto : {}", token, user);

        if (jwtService.checkToken(token)) {
            if (token.equals(userService.getRefreshToken(user.getUserId()))) {
                String accessToken = jwtService.createAccessToken("userid", user.getUserId());

                logger.debug("token : {}", accessToken);
                logger.debug("정상적으로 액세스토큰 재발급!!!");

                resultMap.put("access-token", accessToken);
                resultMap.put("message", SUCCESS);

                status = HttpStatus.ACCEPTED;
            }
        } else {
            logger.debug("리프레쉬토큰 사용불가!!!!!!!");
            status = HttpStatus.UNAUTHORIZED;
        }

        return new ResponseEntity<>(resultMap, status);
    }

    @PostMapping("/users/password")
    private ResponseEntity<Void> findUserPassword(@RequestBody User user) {
        userService.findUserPassword(user);

        return new ResponseEntity<>(HttpStatus.OK);
    } // 전체회원목록 검색.

}
