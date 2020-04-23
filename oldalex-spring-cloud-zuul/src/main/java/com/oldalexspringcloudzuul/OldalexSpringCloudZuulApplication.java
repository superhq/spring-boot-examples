package com.oldalexspringcloudzuul;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@SpringBootApplication
@EnableDiscoveryClient
@EnableZuulProxy
public class OldalexSpringCloudZuulApplication {

    public static void main(String[] args) {
        SpringApplication.run(OldalexSpringCloudZuulApplication.class, args);
    }

}
