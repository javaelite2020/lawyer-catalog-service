package com.javaelites.lawyercatalogservice.controller;

import com.google.gson.Gson;
import com.javaelites.lawyercatalogservice.model.LawyerDetails;
import com.javaelites.lawyercatalogservice.model.LawyerListApiModel;
import com.javaelites.lawyercatalogservice.service.LawyerCatalogService;
import com.javaelites.lawyercatalogservice.util.LawyerDetailsConstants;
import com.javaelites.lawyercatalogservice.util.PageRequestUtil;
import com.javaelites.lawyercatalogservice.util.ResponseApiData;
import com.javaelites.lawyercatalogservice.util.SearchApiData;
import io.swagger.annotations.Api;
import lombok.extern.log4j.Log4j2;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Configuration
@RestController
@RequestMapping(value = {"/lawyers"}, produces = MediaType.APPLICATION_JSON_VALUE)
@Api(value = "Lawyer Catalog API")
@Log4j2
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
  @CrossOrigin(origins = "*")
	public ResponseApiData<LawyerListApiData> findAndListAllLawyers(
			@RequestParam(value = "fields", required = false) String fields,
			@RequestParam(value = "sorts", required = false, defaultValue = "") String sorts,
			@RequestParam(value = "limit", required = false) Integer limit,
			@RequestParam(value = "page_number", required = false, defaultValue = "1") Integer pageNumber,
			@RequestParam(value = "search", required = false) String search
			) throws Exception {
		logger.debug("Inside Lawyer Catalog Controller {} findAndListAllLawyers", this.getClass());
		PageRequest pageRequest = PageRequestUtil.getPageRequest(pageNumber, limit, sorts, LawyerDetailsConstants.fist_name.getValue());
		SearchApiData searchData = new Gson().fromJson(search, SearchApiData.class);
		ResponseApiData<LawyerListApiData> lawyerList = lawyerCatalogService.getAllLawyerList(fields, pageRequest, searchData);
		return lawyerList;
		
	}
	
	@RequestMapping(value= "/{lawyer_code}", method = RequestMethod.GET, produces = "application/json")
  @CrossOrigin(origins = "*")
	public ResponseApiData<LawyerDetailsApiData> getLawyerDetails(@PathVariable("lawyer_code") String lawyerCode) throws IOException {
		logger.debug("Going to retrieve Lawyer details for id - ", lawyerCode);
		return lawyerCatalogService.getLawyerDetails(lawyerCode);
	}

	/*
	 * @RequestMapping("/{lawyerCode}") public LawyerDetails
	 * getLawyerInfo(@PathVariable("lawyerCode") String lawyerCode) { return new
	 * LawyerDetails();
	 * 
	 * }
	 * 
	 */
	
	/**
	 * This method retrieves the Lawyer details(Location, consultation cost, personal information)
	 * based on the lawyerCode.
	 * @param lawyerCode
	 * @return LawyerDetails
	 */
	@RequestMapping(value= "/{lawyer_code}/temp", method = RequestMethod.GET, produces = "application/json")
  @CrossOrigin(origins = "*")
	public LawyerDetails getLawyerDetails2(@PathVariable("lawyer_code") String lawyerCode) {
		logger.debug("Going to retrieve Lawyer details for id - ", lawyerCode);
		return new LawyerDetails();
//		return lawyerCatalogService.getLawyerDetails(lawyerCode);
	}
	
	
}
