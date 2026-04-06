package com.example.spring_aop_assignment.repository;

import com.example.spring_aop_assignment.entities.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {

}
