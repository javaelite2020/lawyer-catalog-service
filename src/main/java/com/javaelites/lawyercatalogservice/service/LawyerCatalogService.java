package com.javaelites.lawyercatalogservice.service;

import java.io.IOException;

import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.javaelites.lawyercatalogservice.domain.dto.LawyerDetailsDTO;
import com.javaelites.lawyercatalogservice.domain.dto.LawyerDetailsApiData;
import com.javaelites.lawyercatalogservice.domain.dto.LawyerListApiData;
import com.javaelites.lawyercatalogservice.util.ResponseApiData;
import com.javaelites.lawyercatalogservice.util.SearchApiData;

@Service
public interface LawyerCatalogService {

	public ResponseApiData<LawyerListApiData> getAllLawyerList(String fields, PageRequest pageRequest, SearchApiData searchData) throws IOException ;
	
	public ResponseApiData<LawyerDetailsApiData> getLawyerDetails(String lawyerCode)  throws IOException;

	public ResponseApiData<LawyerDetailsApiData> addLawyerDetails(LawyerDetailsDTO lawyerDetails) throws IOException;

	public ResponseApiData<LawyerDetailsApiData> updateLawyerDetails(LawyerDetailsDTO lawyerDetails, String lawyerCode) throws IOException;

	public ResponseApiData deleteLawyerDetails(String lawyerDetails) throws IOException;

}
