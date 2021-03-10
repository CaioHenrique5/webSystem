package com.example.team.exampleproject3.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.example.team.exampleproject3.model.User;


public interface UserRepository extends JpaRepository<User, Long> {
    User findByEmail(String email);
}
