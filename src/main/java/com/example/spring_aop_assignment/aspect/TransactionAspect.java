package com.example.spring_aop_assignment.aspect;

import com.example.spring_aop_assignment.entities.Transaction;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class TransactionAspect {


    @Pointcut("execution(* com.example.spring_aop_assignment.service.TransactionService.*(..))")
    public void transactionServiceMethods(){}

    @AfterReturning(value = "transactionServiceMethods()",returning = "transaction")
    public void transactionServiceMethodsAfterReturning(Object transaction){
        Transaction transaction1 = (Transaction) transaction;

         System.out.println("Transaction completed Sucessfully with id"+transaction1.getId());
        System.out.println("Transaction completed successfully. Committing transaction.");

    }

    @AfterThrowing(value = "transactionServiceMethods()",throwing = "ex")
    public void transactionServiceMethodsAfterThrowing(Exception ex){
        System.out.println("Transaction Failed with exception"+ex.getClass().getName()+"-"+ex.getMessage());
        System.out.println("Transaction failed. Rolling back transaction.");
    }

}
