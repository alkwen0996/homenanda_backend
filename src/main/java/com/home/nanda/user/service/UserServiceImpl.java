package com.home.nanda.user.service;

import com.home.nanda.user.model.dto.User;
import com.home.nanda.user.model.mapper.UserMapper;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import org.mindrot.jbcrypt.BCrypt;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserServiceImpl implements UserService {
    private UserMapper userMapper;
    private SqlSession sqlSession;
    private final JavaMailSender javaMailSender;

    @Autowired
    public UserServiceImpl(final UserMapper userMapper, final SqlSession sqlSession, final JavaMailSender javaMailSender) {
        this.userMapper = userMapper;
        this.sqlSession = sqlSession;
        this.javaMailSender = javaMailSender;
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
        return userMapper.userInfo(userId);
    }

    @Override
    public void saveRefreshToken(final String userId, final String refreshToken) {
        Map<String, String> map = new HashMap<>();

        map.put("userId", userId);
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

    @Override
    public void findUserPassword(final User user) {
        User findUser = userMapper.findUserPassword(user);

        if(user.getUserId().equals(findUser.getUserId()) && user.getUserName().equals(findUser.getUserName())){
            sendMail(user);
        }

    }

    public void sendMail(User user){
        final SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        String tempPassword = generateTempPassword();

        simpleMailMessage.setTo(user.getUserId());
        simpleMailMessage.setSubject("HomeNanda 임시비밀번호 안내 이메일 입니다.");
        simpleMailMessage.setText("안녕하세요. HomeNanda 임시비밀번호 안내 관련 이메일 입니다.\n" + "\n 회원님의 임시 비밀번호는 "
                + tempPassword + " 입니다.\n" + "\n로그인 후에 반드시 비밀번호를 변경을 해주세요!");

        updatePassword(tempPassword, user);
        javaMailSender.send(simpleMailMessage);
    }

    private String generateTempPassword() {
        char[] charSet = new char[] { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F',
                'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z' };

        StringBuilder tempPassword = new StringBuilder();

        int index;

        for (int i = 0; i < 10; i++) {
            index = (int) (charSet.length * Math.random());
            tempPassword.append(charSet[index]);
        }

        return tempPassword.toString();
    }

    private void updatePassword(final String tempPassword, final User user) {
        final User userById = userMapper.findUserById(user.getUserId());
        userById.setUserPassword((BCrypt.hashpw(tempPassword, BCrypt.gensalt()))); // 비밀번호 암호화

        userMapper.updateUserPassword(userById);
    }

}
