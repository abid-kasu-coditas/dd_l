package com.example.spring_aop_assignment.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "resumes")
@Builder
public class Resume {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String email;

    private String phoneNumber;

    private String experience;

    private String education;

    private String fileName;

    private String filepath;

    private Integer fileSize;

    private String fileType;

    private List<String> skills;

}
