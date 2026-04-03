package com.example.spring_aop_assignment.repository;

import com.example.spring_aop_assignment.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {

}
