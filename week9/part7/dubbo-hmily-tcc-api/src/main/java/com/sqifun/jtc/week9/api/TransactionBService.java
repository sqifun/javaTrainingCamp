package com.sqifun.jtc.week9.api;

import org.dromara.hmily.annotation.Hmily;

/**
 * @program: week9-part7
 * @className: UserService
 * @description:
 * @author: sqi
 * @date: 2022-03-13 14:32
 * @version: 1.0
 **/
public interface TransactionBService {

    @Hmily
    Boolean forExchangeDollar(String userName, Double amount);

}