package com.example.spring_aop_assignment.service;

import com.example.spring_aop_assignment.entities.Resume;
import com.example.spring_aop_assignment.repository.ResumeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ResumeService {

    private final ResumeRepository resumeRepository;

    public Resume createResume(Resume resume) {
        if (resumeRepository.existsById(Math.toIntExact(resume.getId()))) {
            throw new IllegalArgumentException("Resume already exists");
        }
        if (resume.getFileSize()>250){
            throw new IllegalArgumentException("Resume file size exceed 250");
        }
        if(resume.getFileType().equalsIgnoreCase("jpg") || resume.getFileType().equalsIgnoreCase("img")){
            throw new IllegalArgumentException("Resume file type not allowed");
        }
        return resumeRepository.save(resume);
    }
}
