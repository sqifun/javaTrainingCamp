//package io.kimmking.cache.component;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.scheduling.annotation.Scheduled;
//import org.springframework.stereotype.Component;
//
///**
// * @author da
// * @version 1.0
// * @description: TODO
// * @date 2022年03月26日 15:42
// */
//@Component
//
//public class BusinessTask {​
//    private final static String LOCK_ID = "happyda";
//
//    @Autowired
//    DistributedLock distributedLock;
//
//    @Scheduled(cron = "0/10 * * * * ? ")
//    public void doSomething() {
//        boolean lock = distributedLock.getLock(LOCK_ID);
//        if (lock) {
//            System.out.println("得到锁执行任务");
//            distributedLock.releaseLock(LOCK_ID);
//        } else {
//            System.out.println("没有抢到锁");
//        }
//    }
//
//}

