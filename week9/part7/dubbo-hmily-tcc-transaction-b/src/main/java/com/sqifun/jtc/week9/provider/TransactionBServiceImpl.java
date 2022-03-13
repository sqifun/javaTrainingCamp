package com.sqifun.jtc.week9.provider;

import com.sqifun.jtc.week9.api.TransactionBService;
import com.sqifun.jtc.week9.service.IAccountService;
import org.apache.dubbo.config.annotation.DubboService;

import javax.annotation.Resource;

/**
 * @program: week9-part7
 * @className: TransactionBServiceImpl
 * @description:
 * @author: sqi
 * @date: 2022-03-13 18:34
 * @version: 1.0
 **/
@DubboService(version = "1.0.0", tag = "red", weight = 100)
public class TransactionBServiceImpl implements TransactionBService {

    @Resource
    IAccountService accountService;

    @Override
    public Boolean forExchangeDollar(String userName, Double amount) {
        accountService.forExchangeDollar(userName, amount);
        return Boolean.TRUE;
    }
}