package io.kimmking.cache.component;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;


/**
 * @author da
 * @version 1.0
 * @description: TODO
 * @date 2022年03月26日 15:26
 */
@Component
public class DistributedLock {
    @Autowired
    private StringRedisTemplate redisTemplate;

//    /**
//     * 获得锁
//     */
//    public boolean getLock(String lockId, long millisecond) {
//        Boolean success = redisTemplate.opsForValue().setIfAbsent(lockId, "lock",millisecond,TimeUnit.MILLISECONDS);
//        return success != null && success;
//    }

    /**
     * 获得锁
     */
    public boolean getLock(String lockId) {
        Boolean success = redisTemplate.opsForValue().setIfAbsent(lockId, "lock");
        return success != null && success;
    }

    public void releaseLock(String lockId) {
        redisTemplate.delete(lockId);
    }

}
