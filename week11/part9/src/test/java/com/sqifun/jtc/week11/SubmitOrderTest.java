package com.sqifun.jtc.week11;

import com.sqifun.jtc.week11.service.OrderService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@SpringBootTest
class SubmitOrderTest {

    @Resource
    private OrderService service;

    @Test
    void test() {
        service.submit();
    }

}
