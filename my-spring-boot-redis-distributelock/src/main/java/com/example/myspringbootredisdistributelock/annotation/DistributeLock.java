package com.example.myspringbootredisdistributelock.annotation;

import java.lang.annotation.*;
import java.util.concurrent.TimeUnit;

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface DistributeLock {
    String key();

    long timeout() default 5;

    TimeUnit timeUnit() default TimeUnit.SECONDS;
}
