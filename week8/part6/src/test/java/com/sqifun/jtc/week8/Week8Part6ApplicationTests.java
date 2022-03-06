package com.sqifun.jtc.week8;

import cn.hutool.core.lang.Snowflake;
import cn.hutool.core.util.IdUtil;
import com.sqifun.jtc.week8.entity.OrderInfo;
import com.sqifun.jtc.week8.service.IOrderInfoService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Week8Part6ApplicationTests {

    @Resource
    private IOrderInfoService orderService;

    @Test
    public void insertBatch() {
        orderService.insertBatch(getOrderInfoList());
    }


//    @Test
//    public void delete() {
//        orderService.delete();
//    }

    private List<OrderInfo> getOrderInfoList() {
        List<OrderInfo> list = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            OrderInfo orderInfo = OrderInfo.builder().id(getId())
                    .number(getId())
                    .userId(i + 1L)
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
