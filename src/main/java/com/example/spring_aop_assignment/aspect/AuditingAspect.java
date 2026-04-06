package com.example.spring_aop_assignment.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Aspect
@Component
public class AuditingAspect {


    @Pointcut("execution(* com.example.spring_aop_assignment.controller..*.*(..))")
    public void applyToMethods(){}


    @Before("applyToMethods()")
    public void logBeforeMethod(JoinPoint joinPoint){
    String methodName = joinPoint.getSignature().getName();
    String args = Arrays.toString(joinPoint.getArgs());
        System.out.println("API CALLED"+methodName+args);
    }

    @AfterReturning("applyToMethods()")
    public void logAfterMethod(JoinPoint joinPoint){
        String methodName = joinPoint.getSignature().getName();
        String args = Arrays.toString(joinPoint.getArgs());
        System.out.println("API Completed"+methodName+args);

    }
}
