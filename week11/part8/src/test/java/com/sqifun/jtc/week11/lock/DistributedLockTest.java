package com.sqifun.jtc.week11.lock;

import lombok.extern.java.Log;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @program: week11-part8
 * @className: DistributedLockTest
 * @description:
 * @author: sqi
 * @date: 2022-03-27 13:24
 * @version: 1.0
 **/
@Log
@SpringBootTest
public class DistributedLockTest {

    @Resource
    private DistributedLock lock;

    private final ExecutorService executorService = Executors.newFixedThreadPool(5);

    @Test
    public void testLock() {
        lock.lock();
        log.info(Thread.currentThread().getName() + "获得锁");
        for (int i = 0; i < 5; i++) {
            executorService.submit(new Thread(() -> {
                try {
                    lock.lock();
                    log.info(Thread.currentThread().getName() + "获得锁");
                    TimeUnit.SECONDS.sleep(5);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    lock.unlock();
                    log.info(Thread.currentThread().getName() + "释放锁");
                }
            }));
        }
        log.info(Thread.currentThread().getName() + "释放锁");
        lock.unlock();
        try {
            TimeUnit.SECONDS.sleep(30);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}