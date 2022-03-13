package com.sqifun.jtc.week8.service;

import com.sqifun.jtc.week8.entity.OrderInfo;

import java.util.List;

/**
 * @program: week8-part7
 * @className: IOrderInfoService
 * @description:
 * @author: sqi
 * @date: 2022-03-06 23:25
 * @version: 1.0
 **/
public interface IOrderInfoService {

    List<OrderInfo> queryAll();

    void insertBatch(List<OrderInfo> orderInfos);

    void deleteAll();

    void insertRollback(List<OrderInfo> orderInfos) throws Exception;

}