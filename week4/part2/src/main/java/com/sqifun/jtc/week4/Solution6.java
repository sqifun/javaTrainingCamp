package com.sqifun.jtc.week4;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @program: week4-part2
 * @className: Solution6
 * @description: Lock、Condition
 * @author: sqi
 * @date: 2022-01-25 21:18
 * @version: 1.0
 **/
public class Solution6 {

    public static int result = 0;

    public static void main(String[] args) {
        long start = System.currentTimeMillis();

        final Lock lock = new ReentrantLock();
        final Condition condition  = lock.newCondition();

        Thread thread = new Thread(() -> {
            lock.lock();
            try {
                result = sum();
                condition.signal();
            }
            finally {
                lock.unlock();
            }

        });
        thread.start();

        lock.lock();
        try {
            condition.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }

        System.out.println("异步计算结果为：" + result);

        System.out.println("使用时间："+ (System.currentTimeMillis()-start) + " ms");

        // 然后退出main线程
    }

    private static int sum() {
        return fibo(36);
    }

    private static int fibo(int a) {
        if ( a < 2) {
            return 1;
        }
        return fibo(a-1) + fibo(a-2);
    }

}