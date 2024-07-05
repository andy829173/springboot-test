package com.test.andy.springboottest.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Slf4j
@Aspect
@Component
public class EmailServiceAspect {

    @Before("execution(* com.test.andy.springboottest.service.EmailService.sendOrderNotification(..))")
    public void EmailNotifyBegin(JoinPoint joinPoint) {
        log.info("AOP: Email Notify Begin...");
        Object[] args = joinPoint.getArgs();

        log.info("EmailNotifyBegin: " + Arrays.toString(args));
    }
}
