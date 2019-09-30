package com.javaelites.lawyercatalogservice.controller;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.javaelites.lawyercatalogservice.model.LawyerDetails;
import com.javaelites.lawyercatalogservice.model.LawyerListApiModel;
import com.javaelites.lawyercatalogservice.service.LawyerCatalogService;
import com.javaelites.lawyercatalogservice.util.LawyerDetailsConstants;
import com.javaelites.lawyercatalogservice.util.PageRequestUtil;
import com.javaelites.lawyercatalogservice.util.ResponseApiData;
import com.javaelites.lawyercatalogservice.util.SearchApiData;

import io.swagger.annotations.Api;

@Configuration
@RestController
@RequestMapping(value= {"/lawyers"}, produces=MediaType.APPLICATION_JSON_VALUE)
@Api(value="Lawyer Catalog API")
public class LawyerCatalogController {
	
	private static final Logger logger = LoggerFactory.getLogger(LawyerCatalogController.class);
	
	@Autowired
	private LawyerCatalogService lawyerCatalogService;
	
	/**
	 * Find and List all Laywers based on Page criteria
	 * 
	 * @param fields Fields to be returned
	 * @param sorts Columns of sort
	 * @param limit Number of results to limit
	 * @param pageNumber The page number
	 * @param search THe Search Api Data
	 * @return ResponseApiData<LawyerListApiModel>
	 * @throws Exception 
	 */
	@RequestMapping(method=RequestMethod.GET)
	public ResponseApiData<LawyerListApiModel> findAndListAllLawyers(
			@RequestParam(value = "fields", required = false) String fields,
			@RequestParam(value = "sorts", required = false, defaultValue = "") String sorts,
			@RequestParam(value = "limit", required = false) Integer limit,
			@RequestParam(value = "page_number", required = false, defaultValue = "1") Integer pageNumber,
			@RequestParam(value = "search", required = false) String search
			) throws Exception {
		logger.debug("Inside Lawyer Catalog Controller {} findAndListAllLawyers", this.getClass());
		PageRequest pageRequest = PageRequestUtil.getPageRequest(pageNumber, limit, sorts, LawyerDetailsConstants.fist_name.getValue());
		SearchApiData searchData = new Gson().fromJson(search, SearchApiData.class);
		ResponseApiData<LawyerListApiModel> lawyerList = lawyerCatalogService.getAllLawyerList(fields, pageRequest, searchData);
		return lawyerList;
		
	}

	/*
	 * @RequestMapping("/{lawyerId}") public LawyerDetails
	 * getLawyerInfo(@PathVariable("lawyerId") String lawyerId) { return new
	 * LawyerDetails();
	 * 
	 * }
	 * 
	 */
	
	/**
	 * This method retrieves the Lawyer details(Location, consultation cost, personal information)
	 * based on the lawyerid.
	 * @param lawyerId
	 * @return LawyerDetails
	 */
	@RequestMapping(value= "/{lawyerId}", method = RequestMethod.GET, produces = "application/json")
	public LawyerDetails getLawyerDetails(@PathVariable("lawyerId") String lawyerId) {
		logger.debug("Going to retrieve Lawyer details for id - ", lawyerId);
		return new LawyerDetails();
//		return lawyerCatalogService.getLawyerDetails(lawyerId);
	}
	
	
	
	
}
