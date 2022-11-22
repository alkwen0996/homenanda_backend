package com.home.nanda.user.model.dto;

import lombok.Data;

@Data
public class User {
    private String userId;
    private String userPassword;
    private String userName;
    private String phoneNumber;
    private String joinDate;
    private String token;
}
