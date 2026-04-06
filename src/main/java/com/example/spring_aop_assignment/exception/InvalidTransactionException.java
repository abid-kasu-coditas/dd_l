package com.example.spring_aop_assignment.exception;

public class InvalidTransactionException extends RuntimeException {

    public InvalidTransactionException(String message) {

        super(message);
    }
}
