package com.sqifun.jtc.week9.service;

/**
 * @program: week9-part7
 * @className: AccountService
 * @description:
 * @author: sqi
 * @date: 2022-03-13 17:08
 * @version: 1.0
 **/
public interface IAccountService {

    void exchangeDollarByRmb(String userName, String targetUserName, Double amount);

    void exchangeRmbByDollar(String userName, String targetUserName, Double amount);

}