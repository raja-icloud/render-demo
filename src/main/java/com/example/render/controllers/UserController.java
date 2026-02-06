package com.example.render.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.render.models.User;
import com.example.render.repos.UserRepo;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
@RequestMapping("api/v1/users")
@CrossOrigin("*")
public class UserController {
    

    @Autowired
    private UserRepo userRepo;

    @GetMapping
    public ResponseEntity<?> getAllUsers() {
        return ResponseEntity.ok(userRepo.findAll());
    }
    
    @PostMapping
    public ResponseEntity<?> createUser(@RequestBody User userReq) {
        User newUser = new User();
        newUser.setName(userReq.getName());
        newUser.setEmail(userReq.getEmail());
        newUser.setPassword(userReq.getPassword());
        User createdUser = userRepo.save(newUser);
        return ResponseEntity.ok(createdUser);
    }
    
}
