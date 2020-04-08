package com.example.myspringbootredis.com.example.myspringbootredis.services;

import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.stereotype.Service;

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

    public void testStringRedisTemplate(){
        ValueOperations<String, String> ops = stringRedisTemplate.opsForValue();
        ops.set("Hello","World");
        System.out.println(ops.get("Hello"));
    }
    public void testRedisTemplate(){
        /*如果指定了序列化方法，则redisTemplate跟stringRedisTemplate的效果一样*/
        redisTemplate.setKeySerializer(new StringRedisSerializer());
        redisTemplate.setValueSerializer(new StringRedisSerializer());
        ValueOperations ops = redisTemplate.opsForValue();
        ops.set("Hello","World");
        System.out.println(ops.get("Hello"));
    }
}
