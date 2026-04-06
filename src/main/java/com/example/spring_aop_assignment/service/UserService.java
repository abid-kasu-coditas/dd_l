package com.example.spring_aop_assignment.service;

import com.example.spring_aop_assignment.entities.User;
import com.example.spring_aop_assignment.exception.UserAlreadyExist;
import com.example.spring_aop_assignment.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public User createUser(User user) {
        User user1 = userRepository.findById(user.getId()).orElseThrow(()-> new RuntimeException("User not found"));
         if(userRepository.findByUsername(user.getUsername()).isPresent()){
             throw new UserAlreadyExist("Username already exist with "+ user.getUsername());
         }
         if(user1.getPassword().equals(user.getPassword())){
             throw new RuntimeException("Username Password is invalid");
         }
          return userRepository.save(user);
     }

}
