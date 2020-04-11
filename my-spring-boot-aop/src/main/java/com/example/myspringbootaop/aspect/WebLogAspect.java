package com.example.myspringbootaop.aspect;

import com.example.myspringbootaop.annotation.ControllerWebLog;
import com.example.myspringbootaop.annotation.LogExecutionTime;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class WebLogAspect {
    @Pointcut("execution(* com.example.myspringbootaop.controller..*.*(..))")//切点
    public void webLog(){
    }
    //通知，增强处理
    @Before(value = "webLog() && @annotation(controllerWebLog)")
    public void doBefore(JoinPoint joinPoint, ControllerWebLog controllerWebLog){
        System.out.println("开始调用 " + joinPoint.getSignature());
        System.out.println("注解的名称：" + controllerWebLog.name());
        System.out.println("是否写数据库：" + controllerWebLog.intoDb());
    }

    //环绕通知，注意参数要用ProceedingJoinPoint，才能运行方法。
    @Around(value = "webLog() && @annotation(logExecutionTime)")
    public Object doAround(ProceedingJoinPoint joinPoint, LogExecutionTime logExecutionTime) throws Throwable {
        long start = System.currentTimeMillis();
        Object object = joinPoint.proceed();
        long end = System.currentTimeMillis();
        System.out.println(joinPoint.getSignature() + "运行时长为:" + (end-start) + " ms");
        return object;
    }

}
