package com.example.spring_aop_assignment.repository;

import com.example.spring_aop_assignment.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product,Long> {

}
