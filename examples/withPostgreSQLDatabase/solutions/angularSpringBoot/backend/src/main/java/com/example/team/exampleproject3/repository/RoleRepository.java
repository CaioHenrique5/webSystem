package com.example.team.exampleproject3.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.team.exampleproject3.model.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {

    Role findByName(String name);

}
