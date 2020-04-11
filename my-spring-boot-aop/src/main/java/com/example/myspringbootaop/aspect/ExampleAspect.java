package com.example.myspringbootaop.aspect;

import com.example.myspringbootaop.annotation.LogExecutionTime;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;


/*切面*/
@Aspect
@Component
public class ExampleAspect {
    //基于注解的AOP
    @Around(value = "execution(* com.example.myspringbootaop.services.TestServices.* (..)) && " +
            "@annotation(com.example.myspringbootaop.annotation.LogExecutionTime)")//切点和增强处理（通知）
    public Object logExecutionTime(ProceedingJoinPoint joinPoint) throws Throwable{
        long start = System.currentTimeMillis();
        Object object = joinPoint.proceed();
        long end = System.currentTimeMillis();
        System.out.println(joinPoint.getSignature() + " executed in " + (end - start) + " ms");
        return object;
    }
}
