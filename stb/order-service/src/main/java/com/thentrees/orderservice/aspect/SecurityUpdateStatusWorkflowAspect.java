package com.thentrees.orderservice.aspect;

import jakarta.annotation.PostConstruct;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Slf4j
@RequiredArgsConstructor
public class SecurityUpdateStatusWorkflowAspect {

    private final HttpServletRequest request;

    @Value("${api_key:2123}")
    private String apiKey;

    @PostConstruct
    public void init() {
        log.info("API_KEY: " + apiKey);
    }

    // check quyen truy cap vao api
    @Around("within(com.thentrees.orderservice.workflow.OrderWorkflowImpl)")
    public Object checkSecurity(ProceedingJoinPoint joinPoint) throws Throwable {
        String authHeader = request.getHeader("X-API-KEY");
        log.info("Auth header: " + authHeader);
        if (authHeader == null || !authHeader.equals(apiKey)) {
            throw new RuntimeException("You are not authorized to access this resource");
        }
        log.info("Security check passed");
        return joinPoint.proceed();
    }
}
