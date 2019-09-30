package com.javaelites.lawyercatalogservice.service;

import java.io.IOException;

import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.javaelites.lawyercatalogservice.model.LawyerDetails;
import com.javaelites.lawyercatalogservice.model.LawyerListApiModel;
import com.javaelites.lawyercatalogservice.util.ResponseApiData;
import com.javaelites.lawyercatalogservice.util.SearchApiData;

@Service
public interface LawyerCatalogService {

	public ResponseApiData<LawyerListApiModel> getAllLawyerList(String fields, PageRequest pageRequest, SearchApiData searchData) throws IOException ;
	
	public LawyerDetails getLawyerDetails(String lawyerId);

}
