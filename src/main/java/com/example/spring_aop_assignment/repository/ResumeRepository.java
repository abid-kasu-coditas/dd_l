package com.example.spring_aop_assignment.repository;

import com.example.spring_aop_assignment.entities.Resume;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ResumeRepository extends JpaRepository<Resume, Integer> {


}
