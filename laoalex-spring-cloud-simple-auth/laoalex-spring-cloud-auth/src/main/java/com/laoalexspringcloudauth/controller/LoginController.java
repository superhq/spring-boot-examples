package com.laoalexspringcloudauth.controller;


import com.laoalexspringcloudauth.model.User;
import com.laoalexspringcloudauth.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

@RestController
@RequestMapping("/")
public class LoginController {
    private UserService userService;

    @Autowired
    public LoginController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/login")
    public String login(@RequestBody User user, HttpSession session) {
        if (userService.checkPassword(user.getName(), user.getPassword())) {
            if (session.isNew())
                return "login success";
            else
                return "login already";
        }
        session.invalidate();
        return "login unsucceful";
    }

    @GetMapping("/logout")
    public String logout(HttpSession session) {
        if (session.isNew()) {
            session.invalidate();
            return "didn't login";
        } else {
            session.invalidate();
            return "logout success";
        }
    }
}
