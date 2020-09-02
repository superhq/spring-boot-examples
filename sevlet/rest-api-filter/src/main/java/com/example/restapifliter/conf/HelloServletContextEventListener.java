package com.example.restapifliter.conf;

import org.springframework.context.annotation.Configuration;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
@Configuration
public class HelloServletContextEventListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        System.out.println("init context");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        System.out.println("destroy context");
    }
}
