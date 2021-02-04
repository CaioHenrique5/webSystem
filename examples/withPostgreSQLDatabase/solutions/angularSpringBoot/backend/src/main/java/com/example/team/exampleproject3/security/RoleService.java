package com.example.team.exampleproject3.security;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.example.team.exampleproject3.model.Role;


public class RoleService {

    /**
     * Role repository
     */
    private final RoleRepository repository;

    /**
     * Autowired constructor
     * @param repository Role repository
     */
    @Autowired
    public RoleService(RoleRepository repository) {
        this.repository = repository;
    }

    /**
     * (non-Javadoc)
     *
     * @see br.edu.ufcg.virtus.core.service.CrudService#getRepository()
     */
    public RoleRepository getRepository() {
        return repository;
    }

    /**
     * Return all roles of a User with the specified ID
     * @param userId User id
     * @return Set of the User's roles
     */
    public Set<Role> getRolesByUserId(Integer userId) {
        return getRepository().findAllByUserId(userId);
    }
}
