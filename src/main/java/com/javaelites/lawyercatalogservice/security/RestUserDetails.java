package com.javaelites.lawyercatalogservice.security;

import java.util.Collection;
import java.util.Set;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

public class RestUserDetails extends User {

	private static final long serialVersionUID = 1303677171647559426L;
	private String username;
	private String authentication;
	private String authenticationToken;

	public RestUserDetails(String username, String password, String authentication,
			Collection<? extends GrantedAuthority> authorities) {
		super(username, password, authorities);
		this.username = username;
		this.authentication = authentication;
	}

	public RestUserDetails(String username, String password, Set<GrantedAuthority> authorities) {
		super(username, password, authorities);
	}

	@Override
	public String getUsername() {
		return username;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}

	public String getAuthentication() {
		return authentication;
	}

	public void setAuthentication(String authentication) {
		this.authentication = authentication;
	}
	
	public String getAuthenticationToken() {
		return authenticationToken;
	}

	public void setAuthenticationToken(String authenticationToken) {
		this.authenticationToken = authenticationToken;
	}

	@Override
	public boolean equals(Object rhs) {
		if (rhs instanceof RestUserDetails) {
			return username.equals(((RestUserDetails) rhs).username);
		}
		return false;
	}

	
	@Override
	public int hashCode() {
		return username.hashCode();
	}
	

}
