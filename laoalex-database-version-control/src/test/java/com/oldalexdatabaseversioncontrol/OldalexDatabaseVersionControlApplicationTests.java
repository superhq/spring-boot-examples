package com.oldalexdatabaseversioncontrol;

import com.oldalexdatabaseversioncontrol.controller.UserController;
import com.oldalexdatabaseversioncontrol.model.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class OldalexDatabaseVersionControlApplicationTests {

    @Autowired
    private UserController userController;

    @Test
    void contextLoads() {
    }

    @Test
    void getAll() {
        System.out.println(userController.getAll());
    }

}
