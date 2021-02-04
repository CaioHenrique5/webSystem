package com.example.team.exampleproject3.security;


import java.util.Set;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.example.team.exampleproject3.model.Role;

@Repository
public interface RoleRepository extends PagingAndSortingRepository<Role, Integer>  {
    /**
     * Gets all roles for the specified user id.
     *
     * @param id Role ID.
     * @return User's roles
     */
    @Cacheable("db-user-roles")
    @Query(value = "select r.* from role_user rp inner join role r on r.id = rp.idrole where rp.iduser = ?1", nativeQuery = true)
    public Set<Role> findAllByUserId(Integer id);

}
