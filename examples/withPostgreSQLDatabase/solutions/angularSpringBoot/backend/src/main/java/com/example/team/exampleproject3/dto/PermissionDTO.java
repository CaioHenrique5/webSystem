package com.example.team.exampleproject3.dto;

import com.example.team.exampleproject3.dto.ModelDTO;

public class PermissionDTO extends ModelDTO {
    /**
     * Permission ID
     */
    private Integer id;
    /**
     * Permission name
     */
    private String name;
    /**
     * Permission description
     */
    private String description;

    /**
     * Gets the ID
     * @return id
     */
    public Integer getId() {
        return id;
    }

    /**
     * Sets the ID
     * @param id Permission id
     */
    public void setId(Integer id) {
        this.id = id;
    }
    /**
     * Gets the name.
     *
     * @return name.
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name.
     *
     * @param name name.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets the description.
     *
     * @return description.
     */
    public String getDescription() {
        return description;
    }

    /**
     * Sets the description.
     *
     * @param description description.
     */
    public void setDescription(String description) {
        this.description = description;
    }
}
