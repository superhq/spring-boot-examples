package com.example.myspringbootsessionwithmysqlredis.service;

import com.example.myspringbootsessionwithmysqlredis.common.BaseResponse;
import com.example.myspringbootsessionwithmysqlredis.model.User;

public interface UserService {
    User saveUser(User user);

    User findByAccount(String account);

    BaseResponse login(String account, String password);
}
