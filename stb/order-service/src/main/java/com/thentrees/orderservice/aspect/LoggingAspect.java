package com.thentrees.orderservice.aspect;


import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

@Component
@Aspect
@Slf4j
public class Logging {

    // chi dinh method can theo doi
    @Pointcut("execution(* com.thentrees.orderservice.controller.OrderController.createOrder(..))")
    public void loggingMethodCreateOrder(){}

//    @Before("loggingMethodCreateOrder()")
//    public void logCreateOrder(){
//        log.info("=========Log Aspect=========");
//        log.info("=========Create order=========");
//    }
//
//    @Around("within(com.thentrees.orderservice.service.ExampleLogService*)")
//    public Object LogAroundMethodTest(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
//
//        String methodName = this.getMethodName(proceedingJoinPoint);
//
//        log.info("=========Log Aspect - {} begin =========", methodName);
//        Object result = proceedingJoinPoint.proceed();
//        log.info("=========Log Aspect - {} end =========", methodName);
//        return result;
//    }
//    private String getMethodName(ProceedingJoinPoint joinPoint) {
//        return joinPoint.getSignature().getName();
//    }

    @AfterReturning("within(com.thentrees.orderservice.controller.LogExample)")
    public void logAfterReturning(JoinPoint joinPoint){
        log.info("=========Log Aspect - {} after returning =========", joinPoint.getSignature().getName());
    }

    @AfterThrowing("@within(org.springframework.stereotype.Service)")
    public void logAfterThrowing(JoinPoint joinPoint){
        log.info("=========Log Aspect - {} after throwing =========", joinPoint.getSignature().getName());
    }

    // log details
    @Around("within(com.thentrees.orderservice.controller.*)")
    public Object logAround(ProceedingJoinPoint joinPoint) throws Throwable {
        String methodName = joinPoint.getSignature().getName();
        String ipAddress = ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes()).getRequest().getRemoteAddr();
        log.info("=========Log Aspect - {} begin =========", methodName);
        log.info("IP Address: {}", ipAddress);
        Object result = joinPoint.proceed();
        log.info("=========Log Aspect - {} end =========", methodName);
        return result;
    }

}
