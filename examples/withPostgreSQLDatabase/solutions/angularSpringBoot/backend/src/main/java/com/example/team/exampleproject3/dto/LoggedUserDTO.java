package com.example.team.exampleproject3.dto;

import com.example.team.exampleproject3.dto.RoleDTO;

import java.util.List;
import java.util.Set;


public class LoggedUserDTO {

	/**
	 * ID.
	 */
	private Integer id;
	
    /**
     * Name.
     */
    private String name;

    /**
     * Username.
     */
    private String username;

	/**
	 * Sets user roles
	 */
	private Set<RoleDTO> roles;

	/**
     * Token.
     */
    private String token;

    /**
     * Refresh token.
     */
    private String refreshToken;
    
    /**
     * Permissions.
     */
    private List<String> permissions;

    /**
     * Constructor.
     */
    public LoggedUserDTO() {
	}
    
    /**
     * Constructor.
     * 
     * @param id
     * @param username
     */
    public LoggedUserDTO(Integer id, String username) {
		super();
		
		this.id = id;
		this.username = username;
	}

	/**
     * Gets the ID.
     * 
     * @return ID.
     */
	public Integer getId() {
		return id;
	}

	/**
	 * Sets the ID.
	 * 
	 * @param id
	 * 		ID.
	 */
	public void setId(Integer id) {
		this.id = id;
	}
    
    /**
     * Gets the name.
     *
     * @return Name.
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name.
     *
     * @param name Name.
     */
    public void setName(String name) {
        this.name = name;
    }
    
    /**
     * Gets the username.
     * 
     * @return Username.
     */
	public String getUsername() {
		return username;
	}

	/**
	 * Sets the username.
	 * 
	 * @param username
	 * 		Username.
	 */
	public void setUsername(String username) {
		this.username = username;
	}

	/**
	 * Gets user roles
	 * @return Set of Roles
	 */
	public Set<RoleDTO> getRoles() {
		return roles;
	}

	/**
	 * Sets user roles
	 * @param roles Set of roles
	 */
	public void setRoles(Set<RoleDTO> roles) {
		this.roles = roles;
	}

    /**
     * Gets the token.
     *
     * @return Token.
     */
    public String getToken() {
        return token;
    }

    /**
     * Sets the token.
     *
     * @param token Token.
     */
    public void setToken(String token) {
        this.token = token;
    }

    /**
     * Gets the refresh token.
     *
     * @return Refresh token.
     */
    public String getRefreshToken() {
        return refreshToken;
    }

    /**
     * Sets the refresh token.
     *
     * @param refreshToken Refresh token.
     */
    public void setRefreshToken(String refreshToken) {
        this.refreshToken = refreshToken;
    }

    /**
     * Gets the permissions.
     * 
     * @return Permissions.
     */
	public List<String> getPermissions() {
		return permissions;
	}

	/**
	 * Sets the permissions.
	 * 
	 * @param permissions
	 * 		Permissions.
	 */
	public void setPermissions(List<String> permissions) {
		this.permissions = permissions;
	}
}
