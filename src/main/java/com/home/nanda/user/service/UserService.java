package com.home.nanda.user.service;

import com.home.nanda.user.model.dto.User;
import java.util.List;

public interface UserService {
    void findUserPassword(User user); // 비밀번호 찾기
    void joinUser(User user); // 회원가입
    void updateUser(User user); // 회원정보 수정
    void deleteUser(String userId); // 회원탈퇴
    //    void updatePassword(User user); // 비밀번호 수정
    User findUserById(String userId); // 회원정보 조인
    User loginUser(User user); // 로그인

    List<User> findAllUsers(); // 회원목록 조회

    // JWT 로그인
    User userInfo(String userId);

    void saveRefreshToken(String userid, String refreshToken);

    Object getRefreshToken(String userId);

    void deleteRefreshToken(String userId);
}
