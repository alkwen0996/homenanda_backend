package com.home.nanda.user.service;

import com.home.nanda.user.model.dto.User;
import com.home.nanda.user.model.mapper.UserMapper;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{
    private UserMapper userMapper;

    @Autowired
    public UserServiceImpl(final UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    @Override
    public List<User> findAllUsers() {
        return userMapper.findAllUsers();
    }

}
