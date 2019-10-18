package com.javaelites.lawyercatalogservice.security;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Component;

import com.javaelites.lawyercatalogservice.util.Constants;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Component
public class TokenHandler {

	private static final Logger LOGGER = LoggerFactory.getLogger(TokenHandler.class);
	
	private String a2aSecret = Constants.A2A_PRIVATE_KEY;
	private String lawyerSecret = Constants.LAWYERS_PRIVATE_KEY;
	private List<String> appSecretList = new ArrayList<>();

	public TokenHandler() {
		appSecretList.add(a2aSecret);
		appSecretList.add(lawyerSecret);
	}
	
	public void parseUserFromToken(String token) {
		int count = 0;
		int secretCount = appSecretList.size();
		for (String secret : appSecretList) {
			try {
				Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody().getSubject();
				LOGGER.info(this.getClass() + Constants.A2A_TOKEN_SUCCESS);
			}
			catch(Exception e){
				if(++count == secretCount) {
					LOGGER.info(this.getClass() + Constants.A2A_TOKEN_FAIL);
					throw e;
				}
			}
		}
	}

	public String parseAppNameFromToken(String token) {
		String appName = "";
		int count = 0;
		int secretCount = appSecretList.size();
		for (String secret : appSecretList) {
			try {
				Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody().getSubject();
				LOGGER.info(this.getClass() + Constants.A2A_TOKEN_SUCCESS);
				appName = secret;
			}
			catch(Exception e){
				if(++count == secretCount) {
					LOGGER.info(this.getClass() + Constants.A2A_TOKEN_FAIL);
					throw e;
				}
			}
		}

		return appName;
	}

	
	public String createTokenForUser(User user, String secret) {
		return Jwts.builder().setSubject(user.getUsername()).signWith(SignatureAlgorithm.HS512, secret).compact();
	}
}
