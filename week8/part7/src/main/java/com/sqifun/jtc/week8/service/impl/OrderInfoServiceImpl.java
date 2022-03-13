package com.sqifun.jtc.week8.service.impl;

import com.sqifun.jtc.week8.entity.OrderInfo;
import com.sqifun.jtc.week8.mapper.OrderInfoMapper;
import com.sqifun.jtc.week8.service.IOrderInfoService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * @program: week8-part7
 * @className: OrderInfoServiceImpl
 * @description:
 * @author: sqi
 * @date: 2022-03-06 23:26
 * @version: 1.0
 **/
@Service
public class OrderInfoServiceImpl implements IOrderInfoService {

    @Resource
    private OrderInfoMapper orderInfoMapper;


    @Override
    public List<OrderInfo> queryAll() {
        return orderInfoMapper.selectList(null);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void insertBatch(List<OrderInfo> orderInfos) {
        for (OrderInfo orderInfo : orderInfos) {
            orderInfoMapper.insert(orderInfo);
        }
    }

    @Override
    public void deleteAll() {
        orderInfoMapper.delete(null);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void insertRollback(List<OrderInfo> orderInfos) throws Exception {
        for (int i = 0; i < orderInfos.size(); i++) {
            if (i == 90) {
                throw new Exception("回滚");
            }
            orderInfoMapper.insert(orderInfos.get(i));
        }
    }
}