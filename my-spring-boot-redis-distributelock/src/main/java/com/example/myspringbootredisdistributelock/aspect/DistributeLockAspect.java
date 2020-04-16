package com.example.myspringbootredisdistributelock.aspect;

import com.example.myspringbootredisdistributelock.annotation.DistributeLock;
import com.example.myspringbootredisdistributelock.redis.DistributeLockService;
import io.netty.util.internal.StringUtil;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

/*分布式锁*/
@Aspect
@Component
public class DistributeLockAspect {
    private DistributeLockService distributeLockService;

    @Autowired
    public DistributeLockAspect(DistributeLockService distributeLockService) {
        this.distributeLockService = distributeLockService;
    }

    @Around(value = "@annotation(distributeLock)")
    public Object doAround(ProceedingJoinPoint joinPoint, DistributeLock distributeLock) throws InterruptedException {
        System.out.println("distribute lock key:" + distributeLock.key());
        String value = distributeLockService.getLock(distributeLock.key(), distributeLock.timeout(), distributeLock.timeUnit());
        //String value = distributeLockService.getLock("test", 30, TimeUnit.SECONDS);
        if (StringUtil.isNullOrEmpty(value)) {
            return "请稍等";
        }
        try {
            Object obj = joinPoint.proceed();
            return obj;

        } catch (Throwable throwable) {
            throwable.printStackTrace();
            return "系统异常";
        } finally {
            distributeLockService.unLock(distributeLock.key(), value);
        }


    }
}
