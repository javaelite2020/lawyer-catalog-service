package com.javaelites.lawyercatalogservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.javaelites.lawyercatalogservice.model.LawyerDetails;
import com.javaelites.lawyercatalogservice.service.LawyerCatalogService;

@RestController
@RequestMapping(value= {"/lawyers"}, produces=MediaType.APPLICATION_JSON_VALUE)
public class LawyerCatalogController {
	
	@Autowired
	private LawyerCatalogService lawyerCatalogService;
	
	@RequestMapping(method=RequestMethod.GET)
	public List<LawyerDetails> findAndListAllLawyers(
			@RequestParam(value = "lawyerId", required = false) String lawyerId) {
		List<LawyerDetails> lawyerList = lawyerCatalogService.getLawyers();
		return lawyerList;
		
	}

	@RequestMapping("/{lawyerId}")
	public LawyerDetails getLawyerInfo(@PathVariable("lawyerId") String lawyerId) {
		return new LawyerDetails();
		
	}
	
}
