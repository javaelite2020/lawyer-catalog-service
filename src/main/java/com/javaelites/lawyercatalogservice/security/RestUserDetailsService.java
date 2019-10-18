package com.javaelites.lawyercatalogservice.security;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

import org.springframework.security.authentication.AccountStatusUserDetailsChecker;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service("restUserDetailsService")
public class RestUserDetailsService implements UserDetailsService {

	private final AccountStatusUserDetailsChecker detailsChecker = new AccountStatusUserDetailsChecker();
	private final HashMap<String, User> userMap = new HashMap<String, User>();
	private String userName;

	public RestUserDetailsService() {
	}

	@Override
	public final RestUserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		RestUserDetails user;
		try {
			user = lookupUser(username);
		} catch (IllegalArgumentException e) {
			throw new UsernameNotFoundException("User not found");
		}
		detailsChecker.check(user);
		return user;
	}

	public final RestUserDetails loadUserByUsername(String username, String authentication)
			throws UsernameNotFoundException {
		RestUserDetails user;
		try {
			user = lookupUser(username, authentication);
		} catch (IllegalArgumentException e) {
			throw new UsernameNotFoundException("User not found");
		}
		detailsChecker.check(user);
		return user;
	}

	private RestUserDetails lookupUser(String username) {
		Set<GrantedAuthority> authorities = new HashSet<GrantedAuthority>();
		authorities.add(new SimpleGrantedAuthority("ROLE_USER"));
		return new RestUserDetails(username, "", authorities);
	}

	private RestUserDetails lookupUser(String username, String authentication) {
		Set<GrantedAuthority> authorities = new HashSet<GrantedAuthority>();
		authorities.add(new SimpleGrantedAuthority("ROLE_USER"));
		return new RestUserDetails(username, "", authentication, authorities);
	}

	public void addUser(User user) {
		userMap.put(user.getUsername(), user);
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}
}
