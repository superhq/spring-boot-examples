package com.example.myspringbootsessionwithmysqlredis.controller;

import com.example.myspringbootsessionwithmysqlredis.common.BaseResponse;
import com.example.myspringbootsessionwithmysqlredis.model.User;
import com.example.myspringbootsessionwithmysqlredis.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@RestController
@RequestMapping("/user")
public class UserController {
    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/save")
    public User save(@RequestBody User user) {
        return userService.saveUser(user);
    }

    @GetMapping("/find/{account}")
    public User find(@PathVariable String account) {
        return userService.findByAccount(account);
    }

    @PostMapping("/login")
    public BaseResponse login(String account, String password, HttpSession session, HttpServletResponse httpServletResponse) {
        BaseResponse response = userService.login(account, password);
        if (response.getCode() == 0) {
//            session.setAttribute(session.getId(),response.getMessage());
        } else {
            session.invalidate();
        }
        return response;
    }

    @RequestMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "logout success";
    }
}
