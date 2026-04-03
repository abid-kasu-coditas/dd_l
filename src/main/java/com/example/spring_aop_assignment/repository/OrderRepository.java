package com.example.spring_aop_assignment.repository;

import com.example.spring_aop_assignment.entities.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order,Long> {

}
