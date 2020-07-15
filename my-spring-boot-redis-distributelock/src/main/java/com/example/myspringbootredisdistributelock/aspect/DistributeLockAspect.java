package com.example.myspringbootredisdistributelock.aspect;

import com.example.myspringbootredisdistributelock.annotation.DistributeLock;
import com.example.myspringbootredisdistributelock.redis.DistributeLockService;
import io.netty.util.internal.StringUtil;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
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
    public Object doAround(ProceedingJoinPoint joinPoint, DistributeLock distributeLock) throws Exception {
        Object[] args = joinPoint.getArgs();
        HttpSession session = null;
        for (Object obj : args) {
            if (obj instanceof HttpServletRequest) {
                session = ((HttpServletRequest) obj).getSession();
                break;
            }
        }
        if (session == null) {
            throw new Exception("no HttpServletRequest argument in method:" + joinPoint.getSignature() + "  Stop!");
        }
        String key = String.format("%s-%s", distributeLock.key(), session.getId());
        String value = distributeLockService.getLock(key, distributeLock.timeout(), distributeLock.timeUnit());

        if (StringUtil.isNullOrEmpty(value)) {
            return "please wait a moment...";
        }
        try {
            Object obj = joinPoint.proceed();
            return obj;

        } catch (Throwable throwable) {
            throwable.printStackTrace();
            return "System error";
        } finally {
            //这里不可以释放分布式锁。我们在等分布式锁超时后自动解锁，才能达到限制短信发送频率的作用。
            //distributeLockService.unLock(distributeLock.key(), value);
        }
    }
}
