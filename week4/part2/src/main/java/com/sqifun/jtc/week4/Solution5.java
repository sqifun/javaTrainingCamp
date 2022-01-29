package com.sqifun.jtc.week4;

/**
 * @program: week4-part2
 * @className: Solution5
 * @description: wait、notify
 * @author: sqi
 * @date: 2022-01-25 21:18
 * @version: 1.0
 **/
public class Solution5 {

    public static int result = 0;

    public static void main(String[] args) {
        long start=System.currentTimeMillis();

        Object o = new Object();

        Thread thread = new Thread(() -> {
            synchronized (o) {
                result = sum();
                o.notify();
            }
        });
        thread.start();
        synchronized (o) {
            try {
                o.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
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