package com.javaelites.lawyercatalogservice.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.javaelites.lawyercatalogservice.model.LawyerDetails;

@Controller
//@RequestMapping("/lawyers")
public class HomeController {

//	@RequestMapping("/{lawyerId}")
	public LawyerDetails getLawyerInfo(@PathVariable("lawyerId") String lawyerId) {
		return new LawyerDetails();
		
	}
	
	@RequestMapping("/")
	public String getHomePage() {
		return "home.jsp";
		
	}
}
