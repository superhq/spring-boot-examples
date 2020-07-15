package com.example.myspringbootredisdistributelock;

import com.example.myspringbootredisdistributelock.redis.DistributeLockService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.concurrent.TimeUnit;

@SpringBootTest
class MySpringBootRedisDistributelockApplicationTests {
    @Autowired
    private DistributeLockService distributeLockService;

    @Test
    void contextLoads() {
    }

    @Test
    void getLock() {
        String value = distributeLockService.getLock("test", 30, TimeUnit.SECONDS);
        if (value != null) {
            System.out.println("成功获取分布式锁，value=" + value);
        }
    }

    @Test
    void unLock() {
        distributeLockService.unLock("test", "5d3baa10-57e9-4d18-8a70-b4a1c790fdfc");
    }

}
