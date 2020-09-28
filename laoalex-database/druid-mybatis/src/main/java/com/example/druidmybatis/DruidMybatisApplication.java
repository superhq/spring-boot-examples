package com.example.druidmybatis;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.example.druidmybatis.mapper")
public class DruidMybatisApplication {

    public static void main(String[] args) {
        SpringApplication.run(DruidMybatisApplication.class, args);
    }

}
