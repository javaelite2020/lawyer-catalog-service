package com.javaelites.lawyercatalogservice.security;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.util.Collection;

public class UserAuthentication implements Authentication {

	private static final long serialVersionUID = 5144772441812976202L;
	private final User user;
	private UsernamePasswordAuthenticationToken userNamePasswordAuthenticationToken;
	private boolean authenticated = true;

	public UserAuthentication(User user) {
		userNamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken("", "");
		this.user = user;
	}

	public UserAuthentication(User user, String casToken) {
		userNamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(casToken, "");
		this.user = user;
	}

	@Override
	public String getName() {
		return user.getUsername();
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return user.getAuthorities();
	}

	@Override
	public Object getCredentials() {
		return user.getPassword();
	}

	@Override
	public User getDetails() {
		return user;
	}

	@Override
	public Object getPrincipal() {
		return user.getUsername();
	}

	@Override
	public boolean isAuthenticated() {
		return authenticated;
	}

	@Override
	public void setAuthenticated(boolean authenticated) {
		this.authenticated = authenticated;
	}

	public UsernamePasswordAuthenticationToken getUserNamePasswordAuthenticationToken() {
		return userNamePasswordAuthenticationToken;
	}

}
