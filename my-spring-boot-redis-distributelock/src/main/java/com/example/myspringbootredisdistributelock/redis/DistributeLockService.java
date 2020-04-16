package com.example.myspringbootredisdistributelock.redis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.connection.RedisStringCommands;
import org.springframework.data.redis.connection.ReturnType;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.types.Expiration;
import org.springframework.stereotype.Service;

import java.nio.charset.Charset;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

@Service
public class DistributeLockService {
    private StringRedisTemplate stringRedisTemplate;

    @Autowired
    public DistributeLockService(StringRedisTemplate stringRedisTemplate) {
        this.stringRedisTemplate = stringRedisTemplate;
    }

    public String getLock(String key, long timeout, TimeUnit timeUnit) {
        try {
            String value = UUID.randomUUID().toString();
            Boolean lockStat = stringRedisTemplate.execute((RedisCallback<Boolean>) connection ->
                    connection.set(key.getBytes(Charset.forName("UTF-8")), value.getBytes(Charset.forName("UTF-8")),
                            Expiration.from(timeout, timeUnit), RedisStringCommands.SetOption.SET_IF_ABSENT));
            if (!lockStat) {
                System.out.println("获取分布式锁失败");
                return null;
            }
            return value;
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            return null;
        }
    }

    public void unLock(String key, String value) {
        try {
            String script = "if redis.call('get', KEYS[1]) == ARGV[1] then return redis.call('del', KEYS[1]) else return 0 end";
            boolean unLockStat = stringRedisTemplate.execute((RedisCallback<Boolean>) connection ->
                    connection.eval(script.getBytes(), ReturnType.BOOLEAN, 1,
                            key.getBytes(Charset.forName("UTF-8")), value.getBytes(Charset.forName("UTF-8"))));
            if (!unLockStat) {
                System.out.println("释放分布式锁失败");
            }
        } catch (Exception ex) {
            System.out.println("释放分布式锁失败");
            System.out.println(ex.getMessage());
        }
    }

}
