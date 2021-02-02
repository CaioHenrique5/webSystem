package com.example.team.exampleproject3.dto;


import com.example.team.exampleproject3.dto.ModelDTO;

import java.util.Set;

/**
 * DTO for the model Role
 */
public class RoleDTO extends ModelDTO {
    /**
     * Role ID
     */
    private Integer id;
    /**
     * Role Name
     */
    private String name;
    /**
     * Role Description
     */
    private String description;
    /**
     * Role Permissions
     */
    private Set<PermissionDTO> permissions;

    /**
     * Gets role ID
     * @return Role ID
     */
    public Integer getId() {
        return id;
    }

    /**
     * Sets role ID
     * @param id Role ID
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * Gets role Name
     * @return Role Name
     */
    public String getName() {
        return name;
    }

    /**
     * Sets name
     * @param name Role name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets role Description
     * @return Role Description
     */
    public String getDescription() {
        return description;
    }

    /**
     * Sets description
     * @param description Role name
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Gets role Permissions
     * @return Role Permissions
     */
    public Set<PermissionDTO> getPermissions() {
        return permissions;
    }

    /**
     * Sets permissions
     * @param permissions Role name
     */
    public void setPermissions(Set<PermissionDTO> permissions) {
        this.permissions = permissions;
    }
}
