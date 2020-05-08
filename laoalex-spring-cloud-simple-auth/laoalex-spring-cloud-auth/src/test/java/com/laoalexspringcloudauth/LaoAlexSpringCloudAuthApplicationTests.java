package com.laoalexspringcloudauth;

import com.laoalexspringcloudauth.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class OldalexSpringCloudLoginApplicationTests {

    @Autowired
    private UserService userService;
    @Test
    void contextLoads() {
    }
    @Test
    void getAll(){
        System.out.println(userService.getAll());
    }
    @Test
    void getPassword(){
        System.out.println(userService.getPassword("alex"));
    }

}
