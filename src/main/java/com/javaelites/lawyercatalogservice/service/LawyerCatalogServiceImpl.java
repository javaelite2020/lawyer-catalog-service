package com.javaelites.lawyercatalogservice.service;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Component;

import com.javaelites.lawyercatalogservice.dao.LawyerCatalogDao;
import com.javaelites.lawyercatalogservice.model.LawyerDetails;
import com.javaelites.lawyercatalogservice.model.LawyerListApiModel;
import com.javaelites.lawyercatalogservice.responsehandler.LawyerCatalogResponseHandler;
import com.javaelites.lawyercatalogservice.util.ResponseApiData;
import com.javaelites.lawyercatalogservice.util.SearchApiData;

@Component
public class LawyerCatalogServiceImpl implements LawyerCatalogService {

	private static final Logger logger = LoggerFactory.getLogger(LawyerCatalogServiceImpl.class);
	
	@Autowired
	private LawyerCatalogDao lawyerCatalogDao;
	
	@Autowired
	private LawyerCatalogResponseHandler lawyerCatalogResponseHandler;
	
	@Override
	public ResponseApiData<LawyerListApiModel> getAllLawyerList(String fields, PageRequest pageRequest, SearchApiData searchData) throws IOException {
		logger.debug("{} - Inside getAllLawyerList method", this.getClass());
		Page<LawyerListApiModel> lawyerDetails = lawyerCatalogDao.getAllLawyerList(pageRequest, searchData);
		return lawyerCatalogResponseHandler.handleLawyerCatalogResponse(lawyerDetails.getContent(), lawyerDetails.getTotalElements(), fields);
	}

	@Override 
	public LawyerDetails getLawyerDetails(String lawyerId) {
		
	   LawyerDetails lawDetails = null;
	   if(lawyerId != null) {
		   
		   //1. get lawyer location
//		   LawyerlawyerCatalogDao.getLawyerLocation();
		   
		   //2. get lawyer consultation cost
		   
		   
		   // 3. get other details
		   
		   
		   
		   
	   }
	   else {
		   
		   logger.error("Invalid request for getting lawyer details, lawyerId is null ");
		    lawDetails= new LawyerDetails();
		    return lawDetails;
	   }
	return new LawyerDetails();
	}

}
