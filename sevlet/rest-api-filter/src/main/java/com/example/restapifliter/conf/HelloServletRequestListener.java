package com.example.restapifliter.conf;

import org.springframework.context.annotation.Configuration;

import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;

@Configuration
public class HelloServletRequestListener implements ServletRequestListener {
    @Override
    public void requestDestroyed(ServletRequestEvent sre) {
        System.out.println("destroy request");
    }

    @Override
    public void requestInitialized(ServletRequestEvent sre) {
        System.out.println("init request");
    }
}
