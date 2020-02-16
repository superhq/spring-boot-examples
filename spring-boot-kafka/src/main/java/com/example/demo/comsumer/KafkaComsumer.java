package com.example.demo.comsumer;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import java.util.concurrent.CountDownLatch;

@Component
public class KafkaComsumer implements Runnable{

    @KafkaListener(topics = "test001")
    public void listen(String message){
        System.out.println("receive message ---------- " + message);
    }

    @Override
    public void run() {
        while (true) {
            ;
        }
    }
}
