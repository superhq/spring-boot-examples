package com.laoalexspringcloudeureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class LaoAlexSpringCloudEurekaApplication {

    public static void main(String[] args) {
        SpringApplication.run(LaoAlexSpringCloudEurekaApplication.class, args);
    }

}
