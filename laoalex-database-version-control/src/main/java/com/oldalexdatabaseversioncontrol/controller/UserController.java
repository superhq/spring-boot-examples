package com.oldalexdatabaseversioncontrol.controller;

import com.oldalexdatabaseversioncontrol.mapper.UserMapper;
import com.oldalexdatabaseversioncontrol.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("user/")
public class UserController {
    private UserMapper mapper;

    @Autowired
    public UserController(UserMapper mapper) {
        this.mapper = mapper;
    }

    @GetMapping("/")
    public List<User> getAll() {
        return mapper.getAll();
    }
}
