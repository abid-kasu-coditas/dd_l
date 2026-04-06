package com.example.spring_aop_assignment.service;

import com.example.spring_aop_assignment.entities.Transaction;
import com.example.spring_aop_assignment.exception.InvalidTransactionException;
import com.example.spring_aop_assignment.repository.TransactionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TransactionService {

    private final TransactionRepository transactionRepository;

    public Transaction createTransaction(Transaction transaction) {
        if (transactionRepository.existsById(transaction.getId())) {
            throw new InvalidTransactionException("Transaction already exists");
        }
         return transactionRepository.save(transaction);
    }



}
