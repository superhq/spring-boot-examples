package com.laoalex.laoalexspringbootlogger;

import com.alibaba.fastjson.JSON;
import lombok.*;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.autoconfigure.json.JsonTest;
import org.springframework.boot.test.context.SpringBootTest;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
class TestJson {
    private String name;
    private int age;
    private String detail1;
    private String detail2;
    private String detail3;
    private String detail4;
    private String detail5;

}

@SpringBootTest
class LaoalexSpringBootLoggerApplicationTests {


    @Test
    void contextLoads() {
    }

    @Test
    void logLevelTest() {
        Logger logger = LoggerFactory.getLogger(this.getClass());
        logger.debug("this is a debug message");
        logger.info("this is a info message");
        logger.warn("this is a warn message");
        logger.error("this is a error message");
    }

    @Test
    void logJsonTest() {
        TestJson test = new TestJson("laoalex", 11, "this is a datail1", "this is a datail2", "this is a datail3", "this is " + "\n" +
                "a datail4", "this is a datail5");
        String str = JSON.toJSONString(test);
        Logger logger = LoggerFactory.getLogger(this.getClass());
        logger.info(str);
        TestJson test2 = JSON.parseObject(str, TestJson.class);
        System.out.println(test2);
    }

}
