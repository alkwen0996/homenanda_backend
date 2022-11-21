package com.home.nanda.user.model.dto;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.Getter;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class User {
    private String userId;
    private String userPassword;
    private String userName;
    private String phoneNumber;
    private String joinDate;
    private String token;
}
