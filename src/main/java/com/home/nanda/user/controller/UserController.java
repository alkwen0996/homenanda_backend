package com.home.nanda.user.controller;

import com.home.nanda.user.model.dto.User;
import com.home.nanda.user.service.UserService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    private UserService userService;

    @Autowired
    public UserController(final UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/users")
    private ResponseEntity<List<User>> findAllUsers(){
        final List<User> allUsers = userService.findAllUsers();

        return new ResponseEntity<>(allUsers, HttpStatus.OK);
    }

    @GetMapping("/users/{userId}")
    private ResponseEntity<User> findUserById(@PathVariable final String userId){
        final User userById = userService.findUserById(userId);
        System.out.println();

        return new ResponseEntity<>(userById, HttpStatus.OK);
    }

}
