package com.example.render.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.render.models.User;

public interface UserRepo extends JpaRepository<User, Long> {
    
}
