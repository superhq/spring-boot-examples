package com.test;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.*;

class ForTestTest {
    @BeforeEach
    void before(){
        System.out.println("Before");
    }
    @AfterEach
    void after(){
        System.out.println("After");
    }
    @Test
    void test(){
        ForTest forTest = new ForTest();
        forTest.output();
    }

}