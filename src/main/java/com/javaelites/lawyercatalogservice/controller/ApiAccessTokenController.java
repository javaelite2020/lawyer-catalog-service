package com.javaelites.lawyercatalogservice.controller;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.javaelites.lawyercatalogservice.util.Constants;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.swagger.annotations.Api;

@RestController
@RequestMapping(value = {"/api_access_token"}, produces = MediaType.TEXT_PLAIN_VALUE)
@Api()
public class ApiAccessTokenController {

	private static final Logger logger = LoggerFactory.getLogger(ApiAccessTokenController.class);
	
	@RequestMapping(method = RequestMethod.GET, produces = MediaType.TEXT_PLAIN_VALUE)
	public String getAPIAcessToken() {
		logger.info("Inside " + this.getClass() + " getAPIAcessToken method");
		Date date = new Date();
		long t = date.getTime();
		// 30 min expiration
		Date expirationTime = new Date(t + 1800000);
		String token = Jwts.builder().setSubject("A2APrivateKey")
			.setExpiration(expirationTime)
			.signWith(SignatureAlgorithm.HS512, Constants.A2A_PRIVATE_KEY)
			.compact();
		logger.info("Inside " + this.getClass() + " generated token: " + token);
		return token;
	}
	
	
	/*@RequestMapping("/")
	public String getHomePage() {
		return "home.jsp";
		
	}*/
}
