package com.home.nanda.user.service;

import com.home.nanda.user.model.dto.User;
import com.home.nanda.user.model.mapper.UserMapper;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import org.mindrot.jbcrypt.BCrypt;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserServiceImpl implements UserService {
    private UserMapper userMapper;
    private SqlSession sqlSession;

    @Autowired
    public UserServiceImpl(final UserMapper userMapper, final SqlSession sqlSession) {
        this.userMapper = userMapper;
        this.sqlSession = sqlSession;
    }

    @Override
    public User loginUser(User user) {
        if (user.getUserId() == null || user.getUserPassword() == null) {
            return null;
        }

        final User userById = userMapper.findUserById(user.getUserId());
        System.out.println("로그인 유저: "+user.toString());
        System.out.println("찾은유저 유저: "+userById.toString());

        if(user.getUserId().equals(userById.getUserId()) && BCrypt.checkpw(user.getUserPassword(), userById.getUserPassword())){
            return sqlSession.getMapper(UserMapper.class).loginUser(user);
        }

        return null;
    }

    @Override
    public List<User> findAllUsers() {
        // 관리자 확인로직 추가.
        return userMapper.findAllUsers();
    }

    @Override
    public User findUserById(final String userId) {
        return userMapper.findUserById(userId);
    }

    @Override
    @Transactional
    public void joinUser(final User user) {
        user.setUserPassword((BCrypt.hashpw(user.getUserPassword(), BCrypt.gensalt()))); // 비밀번호 암호화
        System.out.println(user.toString());
        userMapper.joinUser(user);
    }

    @Override
    public void updateUser(final User user) {
        user.setUserPassword((BCrypt.hashpw(user.getUserPassword(), BCrypt.gensalt()))); // 비밀번호 암호화
        userMapper.updateUser(user);
    }

    @Override
    @Transactional
    public void deleteUser(final String userId) {
        userMapper.deleteUser(userId);
    }

    @Override
    public User userInfo(final String userId) {
        return sqlSession.getMapper(UserMapper.class).userInfo(userId);
    }

    @Override
    public void saveRefreshToken(final String userid, final String refreshToken) {
        Map<String, String> map = new HashMap<>();

        map.put("userid", userid);
        map.put("token", refreshToken);

        sqlSession.getMapper(UserMapper.class).saveRefreshToken(map);
    }

    @Override
    public Object getRefreshToken(final String userId) {
        return sqlSession.getMapper(UserMapper.class).getRefreshToken(userId);
    }

    @Override
    public void deleteRefreshToken(final String userId) {
        Map<String, String> map = new HashMap<>();

        map.put("userId", userId);
        map.put("token", null);

        sqlSession.getMapper(UserMapper.class).deleteRefreshToken(map);
    }

}
