package com.example.spring_aop_assignment.aspect;

import com.example.spring_aop_assignment.entities.Resume;
import jakarta.validation.constraints.AssertFalse;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class ResumeAspect {

    @Pointcut("execution(* com.example.spring_aop_assignment.service.ResumeService.*(..))")
    public void resumeServiceMethods(){}

    @AfterReturning(pointcut = "resumeServiceMethods()", returning = "result")
    public void resumeServiceAfterReturning(Object result){
        Resume resume = (Resume) result;
        System.out.println("FILE NAME: "+ resume.getFilepath());
        System.out.println("FILE NAME: "+ resume.getFileName());
    }

    @AfterThrowing(value = "resumeServiceMethods()",throwing = "ex")
    public void resumeServiceAfterThrowing(Exception ex){

        System.out.println("Exception Occurred"+ex.getClass().getName()+"-"+ex.getMessage());
    }

}
