package com.javaelites.lawyercatalogservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LawyerCatalogServiceApplication {

	public static void main(String[] args) {
//		System.setProperty("server.servlet.context-path", "/lawyer_catalog");
		SpringApplication.run(LawyerCatalogServiceApplication.class, args);
	}

}
