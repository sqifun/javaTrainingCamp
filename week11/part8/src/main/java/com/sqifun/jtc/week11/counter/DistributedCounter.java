package com.sqifun.jtc.week11.counter;

import com.sqifun.jtc.week11.common.LuaScript;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.script.DefaultRedisScript;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.util.Collections;

/**
 * @program: week11-part8
 * @className: DistributedCounter
 * @description:
 * @author: sqi
 * @date: 2022-03-27 13:19
 * @version: 1.0
 **/
@Component
public class DistributedCounter {

    @Resource
    private RedisTemplate<String, Object> redisTemplate;

    /**
     * 初始库存
     */
    private static final int INIT_INVENTORY = 100;

    /**
     * 计数器的名字
     */
    private static final String COUNTER_KEY = "counter";

    /**
     * 获取锁脚本
     */
    private DefaultRedisScript<Long> decreaseInventoryScript;

    /**
     * 初始化库存
     */
    @PostConstruct
    private void init() {
        this.redisTemplate.opsForValue().setIfAbsent(COUNTER_KEY, String.valueOf(INIT_INVENTORY));
        this.decreaseInventoryScript = new DefaultRedisScript<>();
        this.decreaseInventoryScript.setResultType(Long.class);
        this.decreaseInventoryScript.setScriptText(LuaScript.DECREASE_INVENTORY);
    }

    /**
     * 减库存
     * @return 减库存结果
     */
    public String decreaseInventory() {
        Long num = this.redisTemplate.execute(decreaseInventoryScript, Collections.singletonList(COUNTER_KEY));
        if (num == null || num == 0) {
            return "减库存失败，当前无库存";
        }
        return "减库存成功，当前库存为：" + num;
    }


}