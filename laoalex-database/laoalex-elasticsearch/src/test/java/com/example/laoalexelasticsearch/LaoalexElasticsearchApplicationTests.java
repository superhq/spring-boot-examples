package com.example.laoalexelasticsearch;

import com.example.laoalexelasticsearch.controller.EsController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class LaoalexElasticsearchApplicationTests {
    @Autowired
    private EsController controller;
    @Test
    void contextLoads() {
    }
    @Test
    void testEsTemplate(){
        System.out.println(controller.test());
    }
}
