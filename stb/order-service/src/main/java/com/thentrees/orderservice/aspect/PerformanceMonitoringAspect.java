package com.thentrees.orderservice.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Slf4j
public class PerformanceMonitoring {
    @Pointcut("@annotation(com.thentrees.orderservice.utils.TracingTime)")
    public void tracingTime() {
    }

    @Around("tracingTime()")
    public Object logExecutionTime(ProceedingJoinPoint joinPoint) throws Throwable {
        long start = System.currentTimeMillis();
        Object rs =joinPoint.proceed();
        long end = System.currentTimeMillis();
        log.info("Method: " + joinPoint.getSignature().getName() + " executed in " + (end - start) + "ms");
        return rs;
    }

}
