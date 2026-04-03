package com.example.spring_aop_assignment.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class PerformanceAspect {

    @Around("execution(* com.example.spring_aop_assignment.service..*(..))")
    public Object measureTime(ProceedingJoinPoint pjp) throws Throwable{
        long start = System.currentTimeMillis();
        Object result = pjp.proceed();
        long end = System.currentTimeMillis()-start;
        System.out.println("Method"+pjp.getSignature()+"executed in "+end);
        return result;
    }


}
