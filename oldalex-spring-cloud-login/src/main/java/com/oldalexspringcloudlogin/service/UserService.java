package com.oldalexspringcloudlogin.service;

import com.oldalexspringcloudlogin.mapper.UserMapper;
import com.oldalexspringcloudlogin.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    private UserMapper userMapper;

    @Autowired
    public UserService(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    public List<User> getAll(){
        return userMapper.getAll();
    }

    public String getPassword(String name){
        return userMapper.getPassword(name);
    }

    public boolean checkPassword(String name, String password){
        String userPassword = getPassword(name);
        if(userPassword.equals(password)){
            return true;
        }else
        {
            return false;
        }
    }

}
