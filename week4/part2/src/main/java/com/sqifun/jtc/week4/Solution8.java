package com.sqifun.jtc.week4;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * @program: week4-part2
 * @className: Solution8
 * @description: BlockingQueue 阻塞队列
 * @author: sqi
 * @date: 2022-01-25 21:18
 * @version: 1.0
 **/
public class Solution8 {


    public static void main(String[] args) {

        long start = System.currentTimeMillis();

        BlockingQueue<Integer> queue = new ArrayBlockingQueue<>(1);

        Thread thread = new Thread(() -> {
            try {
                queue.put(sum());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        thread.start();
        Integer result = null;
        try {
            result = queue.take();
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