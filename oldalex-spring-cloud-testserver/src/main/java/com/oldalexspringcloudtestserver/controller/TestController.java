package com.oldalexspringcloudtestserver.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class TestController {
    @Value("${spring.application.name}")
    private String serverName;

    @GetMapping("/")
    public String test() {
        return this.serverName;
    }
}
