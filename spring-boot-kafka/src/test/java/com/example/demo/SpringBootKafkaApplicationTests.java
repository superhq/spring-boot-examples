package com.example.demo;

import com.example.demo.comsumer.KafkaComsumer;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.kafka.core.KafkaTemplate;

@SpringBootTest
class SpringBootKafkaApplicationTests {
    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;
    @Autowired
    private KafkaComsumer comsumer;

    @Test
    void contextLoads() {
    }

    @Test
    void sendMsg() {
        kafkaTemplate.send("test001", "mytest");
    }

    @Test
    void recvMsg() throws InterruptedException {
        Thread thread = new Thread(comsumer);
        thread.start();
        thread.join();
    }

}
