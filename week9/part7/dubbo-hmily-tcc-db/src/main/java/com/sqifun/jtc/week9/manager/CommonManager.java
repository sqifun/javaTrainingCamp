package com.sqifun.jtc.week9.manager;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.sqifun.jtc.week9.entity.AccountDollar;
import com.sqifun.jtc.week9.entity.AccountFreeze;
import com.sqifun.jtc.week9.entity.AccountRmb;
import com.sqifun.jtc.week9.mapper.AccountDollarMapper;
import com.sqifun.jtc.week9.mapper.AccountFreezeMapper;
import com.sqifun.jtc.week9.mapper.AccountRmbMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @program: week9-part7
 * @className: CommonManager
 * @description:
 * @author: sqi
 * @date: 2022-03-13 18:49
 * @version: 1.0
 **/
@Service
public class CommonManager {

    @Resource
    private AccountRmbMapper accountRmbMapper;

    @Resource
    private AccountDollarMapper accountDollarMapper;

    @Resource
    private AccountFreezeMapper accountFreezeMapper;

    public void updateRmbAccount(String userName, Double amount) {
        QueryWrapper<AccountRmb> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("user_name", userName);
        AccountRmb accountRmb = accountRmbMapper.selectOne(queryWrapper);
        LambdaUpdateWrapper<AccountRmb> lambdaUpdateWrapper = new LambdaUpdateWrapper<>();
        lambdaUpdateWrapper
                .eq(AccountRmb::getUserName, userName)
                .set(AccountRmb::getBalance, accountRmb.getBalance() + amount);
        accountRmbMapper.update(null, lambdaUpdateWrapper);
    }

    public void updateFreezeAccount(String userName, Double amount) {
        QueryWrapper<AccountFreeze> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("user_name", userName);
        AccountFreeze accountFreeze = accountFreezeMapper.selectOne(queryWrapper);
        LambdaUpdateWrapper<AccountFreeze> lambdaUpdateWrapper = new LambdaUpdateWrapper<>();
        lambdaUpdateWrapper
                .eq(AccountFreeze::getUserName, userName)
                .set(AccountFreeze::getBalance, accountFreeze.getBalance() + amount);
        accountFreezeMapper.update(null, lambdaUpdateWrapper);
    }

    public void updateDollarAccount(String userName, Double amount) {
        QueryWrapper<AccountDollar> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("user_name", userName);
        AccountDollar accountDollar = accountDollarMapper.selectOne(queryWrapper);
        LambdaUpdateWrapper<AccountDollar> lambdaUpdateWrapper = new LambdaUpdateWrapper<>();
        lambdaUpdateWrapper
                .eq(AccountDollar::getUserName, userName)
                .set(AccountDollar::getBalance, accountDollar.getBalance() + amount);
        accountDollarMapper.update(null, lambdaUpdateWrapper);
    }

}