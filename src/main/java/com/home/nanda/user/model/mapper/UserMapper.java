package com.home.nanda.user.model.mapper;

import com.home.nanda.user.model.dto.User;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {
    //    boolean login(String userId, String password);
    List<User> findAllUsers();
//    User findUserById(String userId);
//    void joinUser(User user);
//    void updateUser(User user);
//    void deleteUser(String userId);
//    void searchPassword(User user);
//    void updatePassword(User user);
}
