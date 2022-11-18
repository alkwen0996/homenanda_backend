package com.home.nanda.user.service;

import com.home.nanda.user.model.dto.User;
import java.util.List;

public interface UserService {
//    boolean login(String userId, String password);
    List<User> findAllUsers();
    User findUserById(String userId);
//    void joinUser(User user);
//    void updateUser(User user);
//    void deleteUser(String userId);
//    void searchPassword(User user);
//    void updatePassword(User user);
}
