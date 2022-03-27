package com.sqifun.jtc.week11.service;

import lombok.extern.java.Log;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;

/**
 * @program: week11-part9
 * @className: OrderService
 * @description:
 * @author: sqi
 * @date: 2022-03-27 17:33
 * @version: 1.0
 **/
@Log
@Service
public class OrderService {

    @Resource
    private RedisTemplate<String,Object> template;

    public void submit() {
        long orderId = System.currentTimeMillis();
        log.info("收到订单：" + orderId + "，时间：" + new Date());
        template.convertAndSend("order", String.valueOf(orderId));
    }
}