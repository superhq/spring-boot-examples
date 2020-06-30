package com.laoalex.laoalexspringbootlogger.controller;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.logging.Logger;

@RestController
public class TestController {

    public TestController() {
        this.logger = Logger.getLogger(TestController.class.toString());
    }

    private Logger logger;
    @GetMapping("/test")
    public String Test(){
        logger.warning("this is a logger test");
        return "logger test";
    }
}
