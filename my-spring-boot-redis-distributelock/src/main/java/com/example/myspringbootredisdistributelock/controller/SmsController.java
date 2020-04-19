package com.example.myspringbootredisdistributelock.controller;

import com.example.myspringbootredisdistributelock.annotation.DistributeLock;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.concurrent.TimeUnit;

@RestController
@RequestMapping("/")
public class SmsController {
    @DistributeLock(key = "SEND-SMS", timeout = 30, timeUnit = TimeUnit.SECONDS)
    @GetMapping("/sendSMS")
    public String sendSMS(HttpServletRequest request){
        return "send sms";
    }
}
