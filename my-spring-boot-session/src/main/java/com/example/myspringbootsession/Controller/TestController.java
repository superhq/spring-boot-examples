package com.example.myspringbootsession.Controller;

import org.springframework.http.HttpRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Base64;

@RestController
@RequestMapping("/")
public class TestController {
    @GetMapping("/java-base/test")
    public String test(HttpServletRequest request, HttpServletResponse response) {

        HttpSession session = request.getSession();
        System.out.println("session id:" + session.getId());
        System.out.println("session is new:" + session.isNew());

        return "Session Test";
    }
}
