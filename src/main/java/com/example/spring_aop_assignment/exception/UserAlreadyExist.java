package com.example.spring_aop_assignment.exception;

public class UserAlreadyExist extends RuntimeException {

    public UserAlreadyExist(String message) {

        super(message);
    }
}
