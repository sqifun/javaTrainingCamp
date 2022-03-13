package com.sqifun.jtc.week9.provider;

import com.sqifun.jtc.week9.api.TransactionAService;
import com.sqifun.jtc.week9.service.IAccountService;
import org.apache.dubbo.config.annotation.DubboService;

import javax.annotation.Resource;

/**
 * @program: week9-part7
 * @className: OrderServiceImpl
 * @description:
 * @author: sqi
 * @date: 2022-03-13 14:43
 * @version: 1.0
 **/
@DubboService(version = "1.0.0", tag = "red", weight = 100)
public class TransactionAServiceImpl implements TransactionAService {

    @Resource
    IAccountService accountService;

    @Override
    public Boolean exchangeDollar(String userName, String targetUserName, Double amount) {
        accountService.exchangeDollarByRmb(userName, targetUserName, amount);
        return Boolean.TRUE;
    }

}
