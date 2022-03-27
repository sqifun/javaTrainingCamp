package com.sqifun.jtc.week11.counter;

import lombok.extern.java.Log;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @program: week11-part8
 * @className: DistributedCounterTest
 * @description:
 * @author: sqi
 * @date: 2022-03-27 13:25
 * @version: 1.0
 **/
@Log
@SpringBootTest
public class DistributedCounterTest {

    @Resource
    private DistributedCounter counter;

    private final ExecutorService executorService = Executors.newFixedThreadPool(5);

    @Test
    public void testCounter() {
        for (int i = 0; i < 5; i++) {
            executorService.submit(new Thread(() -> {
                log.info(Thread.currentThread().getName() + counter.decreaseInventory());
            }));
        }
        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}