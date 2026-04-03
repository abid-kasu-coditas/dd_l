package com.example.spring_aop_assignment.aspect;

import com.example.spring_aop_assignment.entities.Customer;
import com.example.spring_aop_assignment.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Aspect
@Component
@RequiredArgsConstructor
public class SecurityAspect {
    private final CustomerRepository customerRepository;


    @Before("execution(* com.example.spring_aop_assignment.controller..*.*(..))")
    public void securityCheck(JoinPoint joinPoint){
        Object[] args = joinPoint.getArgs();
        Long userid = (Long) args[0];
         Customer customer = customerRepository.findById(userid).orElseThrow(()-> new RuntimeException("user not found"));

    if(customer.getRole()!="ADMIN"){
        throw new RuntimeException("UNAUTHORIZED");
    }

        System.out.println("SUCESSFULL");
    }
}
