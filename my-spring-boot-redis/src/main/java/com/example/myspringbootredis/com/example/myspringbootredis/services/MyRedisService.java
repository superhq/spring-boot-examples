package com.example.myspringbootredis.com.example.myspringbootredis.services;

import org.springframework.data.redis.core.*;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

/*
StringRedisTemplate 是 RedisTemplate 的子类，
两个的方法基本一致，不同之处主要体现在操作的数据类型不同，
RedisTemplate 中的两个泛型都是 Object ，意味者存储的 key 和 value 都可以是一个对象，
而 StringRedisTemplate 的 两个泛型都是 String ，意味者 StringRedisTemplate 的 key 和 value 都只能是字符串。
* */

@Service
public class MyRedisService {
    private StringRedisTemplate stringRedisTemplate;
    private RedisTemplate redisTemplate;

    public MyRedisService(StringRedisTemplate stringRedisTemplate, RedisTemplate redisTemplate) {
        this.stringRedisTemplate = stringRedisTemplate;
        this.redisTemplate = redisTemplate;
    }

    public void testStringRedisTemplate() {
        ValueOperations<String, String> ops = stringRedisTemplate.opsForValue();
        ops.set("Hello", "World", 10, TimeUnit.SECONDS);
        System.out.println(ops.get("Hello"));
    }

    public void testRedisTemplate() {
        /*如果指定了序列化方法，则redisTemplate跟stringRedisTemplate的效果一样*/
        redisTemplate.setKeySerializer(new StringRedisSerializer());
        redisTemplate.setValueSerializer(new StringRedisSerializer());
        ValueOperations ops = redisTemplate.opsForValue();
        ops.set("Hello", "World");
        System.out.println(ops.get("Hello"));
    }

    public void testRedisList() {
        ListOperations ops = redisTemplate.opsForList();
        ops.rightPush("list", "a");// a
        ops.leftPush("list", "b");//b,a
        System.out.println(ops.rightPop("list")); //a
        System.out.println(ops.leftPop("list"));//b
    }

    public void testRedisHash() {
        HashOperations ops = redisTemplate.opsForHash();
        ops.put("hash", "id", "123");
        ops.put("hash", "name", "jhon");
        System.out.println(ops.get("hash", "name"));
    }

    public void testRedisSet() {
        SetOperations ops = redisTemplate.opsForSet();
        ops.add("set", "a", "b", "c", "a", "b");
        System.out.println(ops.members("set"));
    }

    /*有序表*/
    public void testRedisZSet() {
        ZSetOperations ops = redisTemplate.opsForZSet();
        ops.add("zset", "a", 2);
        ops.add("zset", "b", 1);
        System.out.println(ops.range("zset", 0, -1));
    }
}
