package com.sqifun.jtc.week8.service;

import com.sqifun.jtc.week8.entity.OrderInfo;

import java.util.List;

/**
 * @program: week8-part6
 * @className: OrderInfoService
 * @description:
 * @author: sqi
 * @date: 2022-03-06 20:43
 * @version: 1.0
 **/
public interface IOrderInfoService {

    /**
     * 批量插入数据，并提交
     */
    void insertBatch(List<OrderInfo> orderInfoList);

    /**
     * 批量插入数据，并回滚
     */
    void insertRollback(List<OrderInfo> orderInfoList) throws Exception;

    /**
     * 批量删除
     */
    void delete();

}