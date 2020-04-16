package com.example.myspringbootsession.Controller;

import org.springframework.http.HttpRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@RestController
@RequestMapping("/")
public class TestController {
    @GetMapping("/test")
    public String test(HttpSession session, HttpServletRequest request, HttpServletResponse response) {
        System.out.println("session id" + session.getId());
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie i : cookies) {
                System.out.println("name :" + i.getName() + " value:" + i.getValue());

            }
        }
        Cookie cookie = new Cookie("test", "test-value");
        cookie.setMaxAge(10);
        response.addCookie(cookie);
        return "Session Test";
    }
}
