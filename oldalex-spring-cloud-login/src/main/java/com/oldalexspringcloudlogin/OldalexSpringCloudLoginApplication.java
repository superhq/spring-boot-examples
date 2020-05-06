package com.oldalexspringcloudlogin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class OldalexSpringCloudLoginApplication {

    public static void main(String[] args) {
        SpringApplication.run(OldalexSpringCloudLoginApplication.class, args);
    }

}
