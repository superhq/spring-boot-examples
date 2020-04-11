package com.example.myspringbootaop.services;

import com.example.myspringbootaop.annotation.LogExecutionTime;
import org.springframework.stereotype.Service;

@Service
public class TestServices {

    @LogExecutionTime
    public void test() throws InterruptedException {
        Thread.sleep(1000);
    }
}
