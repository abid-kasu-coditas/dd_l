package com.example.spring_aop_assignment.controller;

import com.example.spring_aop_assignment.entities.Transaction;
import com.example.spring_aop_assignment.repository.TransactionRepository;
import com.example.spring_aop_assignment.service.TransactionService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/transactions")
public class TransactionController {

    @Autowired
    private TransactionService transactionService;

    @PostMapping
    public ResponseEntity<Transaction> createTransaction(@Valid @RequestBody Transaction transaction) {
    Transaction transaction1 = transactionService.createTransaction(transaction);
    return new ResponseEntity<>(transaction1, HttpStatus.CREATED);

    }

}
