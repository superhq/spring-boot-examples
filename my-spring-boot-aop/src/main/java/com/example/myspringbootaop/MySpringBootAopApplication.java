package com.example.myspringbootaop;

import com.example.myspringbootaop.services.TestServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.security.Provider;




@SpringBootApplication
public class MySpringBootAopApplication {
    public static void main(String[] args) {
        SpringApplication.run(MySpringBootAopApplication.class, args);
    }

}
