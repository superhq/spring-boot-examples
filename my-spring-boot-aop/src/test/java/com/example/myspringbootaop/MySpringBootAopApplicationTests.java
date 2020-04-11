package com.example.myspringbootaop;

import com.example.myspringbootaop.controller.WebController;
import com.example.myspringbootaop.services.TestServices;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class MySpringBootAopApplicationTests {
    @Autowired
    private TestServices testServices;
    @Autowired
    private WebController webController;
    @Test
    void contextLoads() {
    }
    @Test
    void test(){
        try {
            testServices.test();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    @Test
    void testWebLog1(){
        webController.testWebLog1();
    }
    @Test
    void testWebLog2(){
        webController.testWebLog2();
    }
    @Test
    void testWebLog3() throws InterruptedException {
        webController.testWebLog3();
    }

}
