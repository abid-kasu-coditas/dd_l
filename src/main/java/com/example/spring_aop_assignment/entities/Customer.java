package com.example.spring_aop_assignment.entities;

import com.example.spring_aop_assignment.enums.Role;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private Role role;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Order> orders = new ArrayList<>();

}
