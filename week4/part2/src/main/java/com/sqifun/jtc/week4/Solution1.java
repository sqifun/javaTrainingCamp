package com.sqifun.jtc.week4;

/**
 * @program: week4-part2
 * @className: Solution1
 * @description: join
 * @author: sqi
 * @date: 2022-01-25 21:18
 * @version: 1.0
 **/
public class Solution1 {

    public static int result = 0;

    public static void main(String[] args) {
        long start = System.currentTimeMillis();

        Thread thread = new Thread(() -> result = sum());
        thread.start();

        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("异步计算结果为：" + result);
        System.out.println("使用时间：" + (System.currentTimeMillis() - start) + " ms");
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