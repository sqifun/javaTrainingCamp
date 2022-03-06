package com.sqifun.jtc.week8.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.sqifun.jtc.week8.entity.OrderInfo;
import com.sqifun.jtc.week8.mapper.OrderInfoMapper;
import com.sqifun.jtc.week8.service.IOrderInfoService;
import org.apache.shardingsphere.transaction.annotation.ShardingTransactionType;
import org.apache.shardingsphere.transaction.core.TransactionType;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * @program: week8-part6
 * @className: OrderInfoServiceImpl
 * @description:
 * @author: sqi
 * @date: 2022-03-06 20:46
 * @version: 1.0
 **/
@Service
public class OrderInfoServiceImpl implements IOrderInfoService {

    @Resource
    private OrderInfoMapper orderInfoMapper;

    @Override
    @Transactional(rollbackFor = Exception.class)
    @ShardingTransactionType(TransactionType.XA)
    public void insertBatch(List<OrderInfo> orderInfoList) {
        for (OrderInfo orderInfo : orderInfoList) {
            orderInfoMapper.insert(orderInfo);
        }
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    @ShardingTransactionType(TransactionType.XA)
    public void insertRollback(List<OrderInfo> orderInfoList) throws Exception {
        for (OrderInfo orderInfo : orderInfoList) {
            orderInfoMapper.insert(orderInfo);
        }
        throw new Exception("回滚");
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    @ShardingTransactionType(TransactionType.XA)
    public void delete() {
        QueryWrapper<OrderInfo> queryWrapper = new QueryWrapper<>();
        orderInfoMapper.delete(queryWrapper);
    }
}