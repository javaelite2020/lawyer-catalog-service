package com.javaelites.lawyercatalogservice.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.javaelites.lawyercatalogservice.model.ConsultationCost;
import com.javaelites.lawyercatalogservice.model.LawyerListApiModel;
import com.javaelites.lawyercatalogservice.model.LawyerLocation;
import com.javaelites.lawyercatalogservice.util.SearchApiData;

@Service
public interface LawyerCatalogDao {
	/**
	 * @param pageRequest
	 * @param searchData
	 * @return
	 */
	public Page<LawyerListApiModel> getAllLawyerList(PageRequest pageRequest, SearchApiData searchData);
	
	public LawyerLocation getLawyerLocation();
	
	public ConsultationCost getLawywerConsultationDetails();
	
	
	
	
	
}
