package com.laoalex.laoalexspringbootlogger;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class LaoalexSpringBootLoggerApplicationTests {

    @Test
    void contextLoads() {
    }
    @Test
    void logLevelTest(){
        Logger logger = LoggerFactory.getLogger(this.getClass());
        logger.debug("this is a debug message");
        logger.info("this is a info message");
        logger.warn("this is a warn message");
        logger.error("this is a error message");
    }

}
