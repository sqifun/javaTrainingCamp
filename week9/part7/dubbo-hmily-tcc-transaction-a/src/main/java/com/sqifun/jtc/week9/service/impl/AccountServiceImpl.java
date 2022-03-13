package com.sqifun.jtc.week9.service.impl;

import com.sqifun.jtc.week9.api.TransactionBService;
import com.sqifun.jtc.week9.manager.CommonManager;
import com.sqifun.jtc.week9.service.IAccountService;
import org.apache.dubbo.config.annotation.DubboReference;
import org.dromara.hmily.annotation.HmilyTCC;
import org.dromara.hmily.common.exception.HmilyRuntimeException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * @program: week9-part7
 * @className: AccountServiceImpl
 * @description:
 * @author: sqi
 * @date: 2022-03-13 17:09
 * @version: 1.0
 **/
@Service
public class AccountServiceImpl implements IAccountService {

    @Resource
    private CommonManager commonManager;

    @DubboReference(version = "1.0.0")
    TransactionBService transactionBService;


    @Override
    @HmilyTCC(confirmMethod = "confirm", cancelMethod = "cancel")
    public void exchangeDollarByRmb(String userName, String targetUserName, Double amount) {
        commonManager.updateRmbAccount(userName, - amount);
        commonManager.updateFreezeAccount(userName, amount);
        try {
            transactionBService.forExchangeDollar(targetUserName, amount);
        } catch (Exception e) {
            throw new HmilyRuntimeException("远程调用异常！");
        }
    }

    @Transactional(rollbackFor = Exception.class)
    public void confirm(String userName, String targetUserName, Double amount) {
        commonManager.updateDollarAccount(userName, amount / 7);
        commonManager.updateFreezeAccount(userName, - amount);
    }

    @Transactional(rollbackFor = Exception.class)
    public void cancel(String userName, String targetUserName, Double amount) {
        commonManager.updateRmbAccount(userName, amount);
        commonManager.updateFreezeAccount(userName, - amount);
    }



    @Override
    public void exchangeRmbByDollar(String userName, String targetUserName, Double amount) {

    }

}
