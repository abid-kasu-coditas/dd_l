package com.example.spring_aop_assignment.repository;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<com.example.spring_aop_assignment.entities.Customer,Long> {

}
