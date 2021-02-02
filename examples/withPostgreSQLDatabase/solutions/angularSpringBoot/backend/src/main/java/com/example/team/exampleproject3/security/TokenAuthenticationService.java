package com.example.team.exampleproject3.security;

import static java.util.Collections.emptyList;

import java.io.IOException;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import com.example.team.exampleproject3.dto.LoggedUserDTO;
import com.example.team.exampleproject3.dto.RoleDTO;
import com.example.team.exampleproject3.dto.TokenDTO;
import com.example.team.exampleproject3.model.Role;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.example.team.exampleproject3.security.*;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

/**
 * Service for Token Authentication.
 *
 * @author Virtus
 *
 */
@Service
public class TokenAuthenticationService {

	private static final String TOKEN_PREFIX = "Bearer";

	public static final String HEADER = "Authorization";

	protected static final String HEADER_REFRESH = "Refresh-Token";


	private RoleService roleService;

	@Autowired
	public TokenAuthenticationService(RoleService roleService) {
		this.roleService = roleService;
	}

	@Value("${app.token.secretkey}")
	private String SECRET_KEY;

	/**
	 * Token Expiration.
	 */
	@Value("${app.token.expiration}")
	private long EXPIRATION_TOKEN;

	/**
	 * Refresh Token Expiration.
	 */
	@Value("${app.refreshtoken.expiration}")
	private long EXPIRATION_REFRESH_TOKEN;

	/**
	 * Adds the authentication in the response.
	 *
	 * @param dto Login DTO.
	 */
	public LoggedUserDTO addAuthentication(LoggedUserDTO dto) {

		String jwt = Jwts.builder().setId(String.valueOf(dto.getId())).setSubject(dto.getUsername())
				.setExpiration(new Date(System.currentTimeMillis() + EXPIRATION_TOKEN))
				.signWith(SignatureAlgorithm.HS512, SECRET_KEY).compact();

		String refresh = Jwts.builder().setId(String.valueOf(dto.getId())).setSubject(dto.getUsername())
				.setExpiration(new Date(System.currentTimeMillis() + EXPIRATION_REFRESH_TOKEN))
				.signWith(SignatureAlgorithm.HS512, SECRET_KEY).compact();
		
		dto.setToken(String.format("%s %s", TOKEN_PREFIX, jwt));
		dto.setRefreshToken(String.format("%s %s", TOKEN_PREFIX, refresh));

		return dto;
	}

	/**
	 * Gets the authentication.
	 *
	 * @param request Request.
	 * @return Authentication.
	 */
	public Authentication getAuthentication(HttpServletRequest request) {

		String token = request.getHeader(HEADER);

		if (token != null) {
			Claims claims = Jwts.parser().setSigningKey(SECRET_KEY)
					.parseClaimsJws(token.replace(TOKEN_PREFIX, "").trim()).getBody();

			if(claims != null) {
				LoggedUserDTO loggedUserDTO = new LoggedUserDTO(Integer.valueOf(claims.getId()), claims.getSubject());
				loggedUserDTO.setRoles(toRoleDTOSet(roleService.getRolesByUserId(loggedUserDTO.getId())));
				return new UsernamePasswordAuthenticationToken(loggedUserDTO, null, emptyList());
			}
			return null;
		}

		return null;
	}

    public static Set<RoleDTO> toRoleDTOSet(Set<Role> roles){
        Set<RoleDTO> newRoles = new HashSet<>();
        roles.forEach(role -> {
            RoleDTO roleDTO = new RoleDTO();
            roleDTO.setId(role.getId());
            roleDTO.setDescription(role.getDescription());
            roleDTO.setName(role.getName());
            newRoles.add(roleDTO);
        });
        return newRoles;
    }

	/**
	 * Generate Token.
	 *
	 * @param username Username.
	 * @return Token.
	 */
	public String generateToken(String id, String username) {

		return Jwts.builder().setId(id).setSubject(username)
				.setExpiration(new Date(System.currentTimeMillis() + EXPIRATION_TOKEN))
				.signWith(SignatureAlgorithm.HS512, SECRET_KEY).compact();
	}

	/**
	 * Gets the refresh authentication.
	 *
	 * @param request Request.
	 * @return Refresh Authentication.
	 */
	public Authentication getRefreshAuthentication(HttpServletRequest request) {
		try {
			String refreshToken = new ObjectMapper().readValue(request.getInputStream(), TokenDTO.class).getToken();
			return getRefreshAuthentication(refreshToken);
		} catch (IOException e) {
			return null;
		}
	}

	/**
	 * Gets the refresh authentication for a String token
	 * @param refreshToken Refresh token
	 * @return Authentication with token user as principal
	 */
	public Authentication getRefreshAuthentication(String refreshToken) {
		if (refreshToken != null) {
			Claims claims = Jwts.parser().setSigningKey(SECRET_KEY)
					.parseClaimsJws(refreshToken.replace(TOKEN_PREFIX, "").trim()).getBody();

			if (claims != null) {
				LoggedUserDTO userDTO = new LoggedUserDTO(Integer.valueOf(claims.getId()), claims.getSubject());
				return new UsernamePasswordAuthenticationToken(userDTO, null, emptyList());
			}
		}
		return null;
		
	}


	
}
