package com.sqifun.jtc.week11.receiver;

import lombok.extern.java.Log;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @program: week11-part9
 * @className: RedisReceiver
 * @description:
 * @author: sqi
 * @date: 2022-03-27 17:00
 * @version: 1.0
 **/
@Log
@Component
public class OrderReceiver {

    public void dealOrder(String message){
        log.info("收到订单：" + message + "，时间：" + new Date());
    }
}