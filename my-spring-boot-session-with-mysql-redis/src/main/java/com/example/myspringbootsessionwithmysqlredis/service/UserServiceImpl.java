package com.example.myspringbootsessionwithmysqlredis.service;

import com.example.myspringbootsessionwithmysqlredis.common.BaseResponse;
import com.example.myspringbootsessionwithmysqlredis.model.User;
import com.example.myspringbootsessionwithmysqlredis.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;

@Service
public class UserServiceImpl implements UserService {
    private UserRepository repository;

    @Autowired
    public UserServiceImpl(UserRepository repository) {
        this.repository = repository;
    }

    @Override
    public User saveUser(User user) {
        return repository.save(user);
    }

    @Override
    public User findByAccount(String account) {
        return repository.findByAccount(account);
    }

    @Override
    public BaseResponse login(String account, String password) {
        BaseResponse response = new BaseResponse(-1, "error");
        User user = this.findByAccount(account);
        if (user != null) {
            if (user.getPassword().equals(password)) {
                response.setCode(0);
                response.setMessage("success");
                return response;
            }
        }
        return response;
    }
}
