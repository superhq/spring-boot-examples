package com.example.mysecurity;

import com.example.mysecurity.controller.StudentController;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class MySecurityApplicationTests {

    @Test
    void contextLoads() {
    }

    @Test
    void pojoStudentControllerTest() {
        StudentController studentController = new StudentController();
        System.out.println(studentController.getStudent(1));
        System.out.println(studentController.getStudent(4));
    }
}
