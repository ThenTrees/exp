package com.thentrees.orderservice.aspect;

import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Slf4j
@Order(2)
public class SecurityAspect {

    @Autowired
    private HttpServletRequest request;

    @Value("${API_KEY}")
    private String apiKey;

    // check quyen truy cap vao api

    @Before("within(com.thentrees.orderservice.controller.OrderController)")
    public void checkSecurity() {
        String authHeader = request.getHeader("X-API-KEY");
        if (authHeader == null || !authHeader.equals(apiKey)) {
            throw new RuntimeException("Unauthorized");
        }else{
            log.info("Authorized successfully!!");
        }

    }
}
