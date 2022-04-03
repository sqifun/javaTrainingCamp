package io.kimmking.cache.component;

import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author da
 * @version 1.0
 * @description: 分布式锁demo
 * @date 2022年03月26日 16:07
 */
public class BusinessTask01 {
    private final static String LOCK_ID = "happyda";
    @Autowired
    DistributedLock distributedLock;

    public void doSomething() {
        boolean lock = distributedLock.getLock(LOCK_ID);
        if (lock) {
            System.out.println("得到锁执行任务");
            distributedLock.releaseLock(LOCK_ID);
        } else {
            System.out.println("没有抢到锁");
        }
    }
}
