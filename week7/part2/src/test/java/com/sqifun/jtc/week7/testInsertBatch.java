package com.sqifun.jtc.week7;

import cn.hutool.core.lang.Snowflake;
import cn.hutool.core.util.IdUtil;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @program: part2
 * @className: testInsertBatch
 * @description:
 * @author: sqi
 * @date: 2022-02-27 19:38
 * @version: 1.0
 **/
public class testInsertBatch {

    @Test
    public void demo1() {
        InsertDemo1 insertDemo1 = new InsertDemo1();
        insertDemo1.insertData(getOrderInfoList());
    }

    @Test
    public void demo2() {
        long start = System.currentTimeMillis();
        InsertDemo2 insertDemo2 = new InsertDemo2();
        insertDemo2.insertData(getOrderInfoList());
        System.out.println(System.currentTimeMillis() - start);
    }

    /**
     * 速度最快：90s
     */
    @Test
    public void demo3() {
        long start = System.currentTimeMillis();
        InsertDemo3 insertDemo3 = new InsertDemo3();
        insertDemo3.insertData(getOrderInfoList());
        System.out.println(System.currentTimeMillis() - start);
    }

    private List<OrderInfo> getOrderInfoList() {
        List<OrderInfo> list = new ArrayList<>();
        for (int i = 0; i < 1000000; i++) {
            OrderInfo orderInfo = OrderInfo.builder().id(getId())
                    .number(getId())
                    .userId(getId())
                    .userAddressId(getId())
                    .productId(getId())
                    .paymentMethod(1)
                    .originMoney(100.00)
                    .districtMoney(1.00)
                    .expressMoney(10.00)
                    .paymentMoney(109.00)
                    .expressCompany("顺丰快递")
                    .expressNumber(getId())
                    .payTime(new Date())
                    .sendTime(new Date())
                    .receiveTime(new Date())
                    .status(2)
                    .createTime(new Date())
                    .updateTime(new Date())
                    .isValid(1)
                    .remark(null).build();
            list.add(orderInfo);
        }
        return list;
    }

    private final Snowflake SNOWFLAKE  = IdUtil.createSnowflake(1, 1);

    public Long getId(){
        return SNOWFLAKE.nextId();
    }

}