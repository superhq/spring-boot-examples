package com.laoalex.laoalexspringbootdocker.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    @GetMapping("/hello")
    String hello() {
        return "Hello Spring Boot docker";
    }
}
