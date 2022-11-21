package com.home.nanda.user.model.mapper;

import com.home.nanda.user.model.dto.User;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {
    User findUserPassword(User user); // 비밀번호 찾기
    void updateUserPassword(User user);
    void joinUser(User user); // 회원가입
    void updateUser(User user); // 회원정보 수정
    void deleteUser(String userId); // 회원탈퇴
    //    void updatePassword(User user); // 비밀번호 수정
    User findUserById(String userId); // 회원정보 조회
    User loginUser(User user); // 로그인

    List<User> findAllUsers(); // 회원목록 조회

    // JWT 로그인
    User userInfo(String userId);

    void saveRefreshToken(Map<String, String> map);

    Object getRefreshToken(String userId);

    void deleteRefreshToken(Map<String, String> map);
}
