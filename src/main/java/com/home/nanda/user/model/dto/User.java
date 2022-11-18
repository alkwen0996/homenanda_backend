package com.home.nanda.user.model.dto;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.Getter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class User {
    private String userId;
    private String userPassword;
    private String userName;
    private String phoneNumber;
    private String joinDate;
    private String token;
}
