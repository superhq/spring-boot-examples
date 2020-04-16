package com.example.myspringbootredisdistributelock.controller;

import com.example.myspringbootredisdistributelock.annotation.DistributeLock;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

@RestController
@RequestMapping("/")
public class TestController {
    @DistributeLock(key = "test", timeout = 30, timeUnit = TimeUnit.SECONDS)
    @GetMapping("/test")
    public String test() throws InterruptedException {
        return "test";
    }
}
