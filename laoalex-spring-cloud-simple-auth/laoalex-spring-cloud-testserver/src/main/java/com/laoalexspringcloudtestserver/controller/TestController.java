package com.laoalexspringcloudtestserver.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("/test")
public class TestController {
    @Value("${spring.application.name}")
    private String serverName;
    @Value("${server.port}")
    private int port;

    @GetMapping("/")
    public String test(HttpServletResponse response) {
        Cookie cookie = new Cookie("TestServer", "I-am-a-TestServer");
        response.addCookie(cookie);
        return this.serverName + " :" + this.port;
    }
}
