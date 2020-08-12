package com.example.laoalexmockmvctest.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
    @GetMapping("/getTest")
    public String getTest(){
        return "Hello World";
    }
    @PostMapping("/postTest")
    public Object postTest(@RequestBody Object body){
        System.out.println("body = " + body);
        return body;
    }
}
