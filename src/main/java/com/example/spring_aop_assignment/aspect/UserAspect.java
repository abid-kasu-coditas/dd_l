package com.example.spring_aop_assignment.aspect;

import com.example.spring_aop_assignment.entities.User;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Aspect
@Component
public class UserAspect {

    public static  int counter = 0;
    public static LocalDateTime lastLogin ;

    @Pointcut("execution(* com.example.spring_aop_assignment.service.UserService.*(..))")
    public void userServiceMethod(){}

    @AfterReturning(value = "userServiceMethod()",returning = "result")
    public void afterReturningUserServiceMethod(Object result){

        User user = (User) result;
        System.out.println("LOGIN SUCCESS for user: "+((User) result).getId());
        System.out.println("LAST LOGIN TIME: "+ LocalDateTime.now());
     }

     @AfterThrowing(value = "userServiceMethod()",throwing = "ex")
    public void afterThrowingUserServiceMethod(Exception ex){
         System.out.println("LOGIN FAILED: "+ex.getClass().getName()+"-"+ex.getMessage());
         System.out.println("Login Attempt: "+counter++);
         if(counter==10){
         System.out.println("LOGIN Attempt Completed");}
     }

}
