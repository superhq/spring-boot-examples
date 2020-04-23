package com.oldalexspringcloudeureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class OldalexSpringCloudEurekaApplication {

    public static void main(String[] args) {
        SpringApplication.run(OldalexSpringCloudEurekaApplication.class, args);
    }

}
