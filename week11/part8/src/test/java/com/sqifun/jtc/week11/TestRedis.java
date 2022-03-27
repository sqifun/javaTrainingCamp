package com.sqifun.jtc.week11;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;

import javax.annotation.Resource;

/**
 * @program: week11-part8
 * @className: TestRedis
 * @description:
 * @author: sqi
 * @date: 2022-03-27 13:38
 * @version: 1.0
 **/
@SpringBootTest
public class TestRedis {

    @Resource
    private RedisTemplate<String, Object> redisTemplate;

    @Test
    public void test() {
        redisTemplate.opsForValue().set("b", 2);
    }

}