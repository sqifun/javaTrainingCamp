package com.sqifun.jtc.week4;

/**
 * @program: week4-part2
 * @className: Solution4
 * @description: 主线程监控工作线程执行情况
 * @author: sqi
 * @date: 2022-01-25 21:18
 * @version: 1.0
 **/
public class Solution4 {

    public static int result = 0;

    public static void main(String[] args) {

        long start = System.currentTimeMillis();

        Thread thread = new Thread(() -> result = sum());
        thread.start();

        while (true) {
            if (thread.isAlive()) {
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e){
                    e.printStackTrace();
                }
            }
            else {
                break;
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