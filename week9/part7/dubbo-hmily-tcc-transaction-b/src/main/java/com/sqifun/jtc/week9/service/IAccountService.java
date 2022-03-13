package com.sqifun.jtc.week9.service;

/**
 * @program: week9-part7
 * @className: IAccountService
 * @description:
 * @author: sqi
 * @date: 2022-03-13 18:36
 * @version: 1.0
 **/
public interface IAccountService {

    void forExchangeDollar(String userName, Double amount);

    void forExchangeRmbByDollar(String userName, Double amount);

}