package com.shop.Lock.impl;

import com.shop.Lock.AquiredLockWorker;
import com.shop.Lock.DistributedLocker;
import com.shop.Lock.RedissonConnector;
import com.shop.exception.UnableToAquireLockException;
import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

/**
 * Created By Lizhengyuan on 19-2-15
 */
@Component
public class RedisLocker implements DistributedLocker {

    private final static String LOCKER_PREFIX = "lock:";

    @Autowired
    RedissonConnector redissonConnector;

    @Override
    public <T> T lock(String resourceName, AquiredLockWorker<T> worker) throws UnableToAquireLockException, Exception {

        return lock(resourceName, worker, 100);
    }

    @Override
    public <T> T lock(String resourceName, AquiredLockWorker<T> worker, int lockTime) throws UnableToAquireLockException, Exception {

        RedissonClient redissonClient = redissonConnector.getClient();
        RLock lock = redissonClient.getLock(LOCKER_PREFIX + resourceName);
        boolean success = lock.tryLock(100, lockTime, TimeUnit.SECONDS);
        if(success){
            try {
                return worker.invokeAfterLockAquire();
            }finally {
                lock.unlock();
            }
        }
        throw new UnableToAquireLockException();
    }
}
