package com.example.myspringbootredis;

import com.example.myspringbootredis.com.example.myspringbootredis.services.MyRedisService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class MySpringBootRedisApplicationTests {
    @Autowired
    private MyRedisService service;
    @Test
    void contextLoads() {
    }
    @Test
    void testStringRedisTemplate(){
        service.testStringRedisTemplate();
    }
    @Test
    void testRedisTemplate(){
        service.testRedisTemplate();
    }

}
