package com.sqifun.jtc.week4;

import java.util.concurrent.CountDownLatch;

/**
 * @program: week4-part2
 * @className: Solution7
 * @description: CountDownLatch
 * @author: sqi
 * @date: 2022-01-25 21:18
 * @version: 1.0
 **/
public class Solution7 {

    public static int result = 0;

    public static void main(String[] args) {
        long start = System.currentTimeMillis();

        CountDownLatch countDownLatch = new CountDownLatch(1);

        Thread thread = new Thread(() -> {
            result = sum();
            countDownLatch.countDown();
        });
        thread.start();

        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("异步计算结果为：" + result);
        System.out.println("使用时间："+ (System.currentTimeMillis()-start) + " ms");
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