package com.laoalex.laoalexspringbootlogger;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LaoalexSpringBootLoggerApplication {

    public static void main(String[] args) {

        SpringApplication.run(LaoalexSpringBootLoggerApplication.class, args);
        Logger logger = LoggerFactory.getLogger(LaoalexSpringBootLoggerApplication.class);
        logger.error("test test test");
    }

}
