package com.javaelites.lawyercatalogservice.dao;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.javaelites.lawyercatalogservice.model.ConsultationCost;
import com.javaelites.lawyercatalogservice.model.LawyerDetails;
import com.javaelites.lawyercatalogservice.model.LawyerListApiModel;
import com.javaelites.lawyercatalogservice.model.LawyerLocation;
import com.javaelites.lawyercatalogservice.model.LawyerResumeApiModel;
import com.javaelites.lawyercatalogservice.util.SearchApiData;

@Service
public interface LawyerCatalogDao {
	/**
	 * @param pageRequest
	 * @param searchData
	 * @return
	 */
	public Page<LawyerListApiModel> getAllLawyerList(PageRequest pageRequest, SearchApiData searchData);

	public LawyerDetails getLawyerDetails(String lawyerId);
	
	public List<LawyerLocation> getLawyerLocationDetails(String lawyerId);
	
	public List<ConsultationCost> getLawyerConsultationDetails(String lawyerId);
	
	public List<LawyerResumeApiModel> getLawyerResumeDetails(String lawyerId);

	public LawyerDetails saveLawyerDetails(LawyerDetails lawyerDetails);

	public void deleteLawyerDetails(LawyerDetails lawyer);

	
	
}
