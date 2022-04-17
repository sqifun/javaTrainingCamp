package io.kimmking.kmq.core;

/**
 * @author da
 * @version 1.0
 * @description: TODO
 * @date 2022年04月09日 17:35
 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;


public class CustomQueue {

    /**
     * 各个分组的读取位置记录
     *
     * group --> index
     */
    private Map<String, AtomicInteger> offset = new HashMap<>();

    /**
     * 写位置记录
     */
    private int writeIndex = 0;

    /**
     * 存储队列
     */
    private List<String> queue = new ArrayList<>();

    public void put(String message) {
        // TODO
        // 为啥函数锁没有用？
        synchronized (Constants.WRITE_LOCK) {
            queue.add(message);
            writeIndex += 1;
        }
    }

    public String get(String group) {
        int index = offset.getOrDefault(group, new AtomicInteger(-1)).incrementAndGet();
        if (writeIndex == 0 || index >= queue.size()) {
            return null;
        }
        return queue.get(index);
    }

    public boolean isEmpty() {
        return writeIndex == 0 || writeIndex >= queue.size();
    }

    public int size() {
        return writeIndex;
    }
}
