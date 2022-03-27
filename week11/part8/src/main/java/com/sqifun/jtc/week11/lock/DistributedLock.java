package com.sqifun.jtc.week11.lock;

import com.sqifun.jtc.week11.common.LuaScript;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.script.DefaultRedisScript;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.util.Collections;

/**
 * @program: week11-part8
 * @className: DistributedLock
 * @description:
 * @author: sqi
 * @date: 2022-03-27 13:18
 * @version: 1.0
 **/
@Component
public class DistributedLock {

    @Resource
    private RedisTemplate<String, Object> redisTemplate;

    /**
     * 锁的 key 和 value
     */
    private static final String LOCK_KEY_VALUE = "lock";

    /**
     * 锁默认失效时间
     */
    private static final int EXPIRE_SECONDS = 10;


    /**
     * 获取锁脚本
     */
    private DefaultRedisScript<Long> lockScript;

    /**
     * 释放锁脚本
     */
    private DefaultRedisScript<Long> releaseLockScript;

    @PostConstruct
    private void init() {
        initLockScript();
        initReleaseLockScript();
    }

    private void initLockScript() {
        this.lockScript = new DefaultRedisScript<>();
        this.lockScript.setResultType(Long.class);
        this.lockScript.setScriptText(LuaScript.LOCK_SCRIPT);
    }

    private void initReleaseLockScript() {
        this.releaseLockScript = new DefaultRedisScript<>();
        this.releaseLockScript.setResultType(Long.class);
        this.releaseLockScript.setScriptText(LuaScript.RELEASE_LOCK_SCRIPT);
    }

    /**
     * 获取锁
     */
    public void lock() {
        boolean isLocked = isLocked();
        while (isLocked) {
            isLocked = isLocked();
        }
    }

    private boolean isLocked() {
        Long execute = this.redisTemplate.execute(lockScript, Collections.singletonList(LOCK_KEY_VALUE), LOCK_KEY_VALUE, String.valueOf(EXPIRE_SECONDS));
        if (execute == null) {
            return false;
        }
        return 0 == execute;
    }

    /**
     * 释放锁
     */
    public void unlock() {
        this.redisTemplate.execute(releaseLockScript, Collections.singletonList(LOCK_KEY_VALUE), LOCK_KEY_VALUE);
    }

}