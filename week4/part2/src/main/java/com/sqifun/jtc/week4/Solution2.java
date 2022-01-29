package com.sqifun.jtc.week4;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @program: week4-part2
 * @className: Solution2
 * @description: FutureTask
 * @author: sqi
 * @date: 2022-01-25 21:18
 * @version: 1.0
 **/
public class Solution2 {

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        Integer result = null;
        FutureTask<Integer> task = new FutureTask<>(Solution2::sum);
        new Thread(task).start();

        try {
            result = task.get();
        } catch (InterruptedException | ExecutionException e) {
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