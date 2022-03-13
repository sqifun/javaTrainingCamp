package com.sqifun.jtc.week9.api;

import org.dromara.hmily.annotation.Hmily;

/**
 * @program: week9-part7
 * @className: OrderService
 * @description:
 * @author: sqi
 * @date: 2022-03-13 14:30
 * @version: 1.0
 **/
public interface TransactionAService {

    @Hmily
    Boolean exchangeDollar(String userName, String targetUserName, Double amount);

}