package com.sqifun.jtc.week9.service.impl;

import com.sqifun.jtc.week9.manager.CommonManager;
import com.sqifun.jtc.week9.service.IAccountService;
import org.dromara.hmily.annotation.HmilyTCC;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * @program: week9-part7
 * @className: AccountServiceImpl
 * @description:
 * @author: sqi
 * @date: 2022-03-13 18:38
 * @version: 1.0
 **/
@Service
public class AccountServiceImpl implements IAccountService {

    @Resource
    private CommonManager commonManager;

    @Override
    @HmilyTCC(confirmMethod = "confirm", cancelMethod = "cancel")
    @Transactional(rollbackFor = Exception.class)
    public void forExchangeDollar(String userName, Double amount) {
        commonManager.updateDollarAccount(userName, - amount / 7);
        commonManager.updateFreezeAccount(userName, amount / 7);
    }

    @Transactional(rollbackFor = Exception.class)
    public void confirm(String userName, Double amount) {
        commonManager.updateRmbAccount(userName, amount);
        commonManager.updateFreezeAccount(userName, - amount / 7);
    }

    @Transactional(rollbackFor = Exception.class)
    public void cancel(String userName, Double amount) {
        commonManager.updateDollarAccount(userName, amount / 7);
        commonManager.updateFreezeAccount(userName, - amount / 7);
    }

    @Override
    public void forExchangeRmbByDollar(String userName, Double amount) {

    }
}