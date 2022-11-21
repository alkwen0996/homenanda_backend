package com.home.nanda.user.service;

import java.util.Map;

public interface JwtService {
    <T> String createAccessToken(String key, T data);

    <T> String createRefreshToken(String key, T data);

    <T> String create(String key, T data, String subject, long expire);

    Map<String, Object> getKey(String key);

    String getUserId();

    boolean checkToken(String jwt);

}
