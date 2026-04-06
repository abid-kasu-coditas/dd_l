package com.example.spring_aop_assignment.controller;

import com.example.spring_aop_assignment.entities.Resume;
import com.example.spring_aop_assignment.service.ResumeService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/resume")
@RequiredArgsConstructor
public class ResumeController {

    private final ResumeService resumeService;

    public ResponseEntity<Resume> createResume(@Valid @RequestBody Resume resume){
        Resume resume1 = resumeService.createResume(resume);
        return new ResponseEntity<>(resume1, HttpStatus.CREATED);
    }
}
