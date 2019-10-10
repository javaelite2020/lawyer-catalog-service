package com.javaelites.lawyercatalogservice.dao;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Component;

import com.javaelites.lawyercatalogservice.model.ConsultationCost;
import com.javaelites.lawyercatalogservice.model.LawyerDetails;
import com.javaelites.lawyercatalogservice.model.LawyerListApiModel;
import com.javaelites.lawyercatalogservice.model.LawyerLocation;
import com.javaelites.lawyercatalogservice.model.LawyerResumeApiModel;
import com.javaelites.lawyercatalogservice.repository.ConsultationCostRepository;
import com.javaelites.lawyercatalogservice.repository.LawyerDetailsRepository;
import com.javaelites.lawyercatalogservice.repository.LawyerListApiModelRepository;
import com.javaelites.lawyercatalogservice.repository.LawyerLocationRepository;
import com.javaelites.lawyercatalogservice.repository.LawyerResumeApiModelRepository;
import com.javaelites.lawyercatalogservice.util.LawyerDetailsConstants;
import com.javaelites.lawyercatalogservice.util.QueryBuilder;
import com.javaelites.lawyercatalogservice.util.SearchApiData;
import com.querydsl.core.types.dsl.BooleanExpression;

@Component
public class LawyerCatalogDaoImpl implements LawyerCatalogDao {

	private static final Logger logger = LoggerFactory.getLogger(LawyerCatalogDaoImpl.class);

	@Autowired
	private LawyerDetailsRepository lawyerRepository;

	@Autowired
	private LawyerListApiModelRepository lawyerListApiModelRepository;
	@Autowired
	private LawyerDetailsRepository lawyerDetailsRepository;
	@Autowired
	private LawyerLocationRepository lawyerLocationRepository;
	@Autowired
	private ConsultationCostRepository consultationCostRepository;
	@Autowired
	private LawyerResumeApiModelRepository lawyerResumeApiModelRepository;
	
	@Autowired
	private QueryBuilder queryBuilder;
	
	
	/* (non-Javadoc)
	 * @see com.javaelites.lawyercatalogservice.dao.LawyerCatalogDao#getAllLawyerList(org.springframework.data.domain.PageRequest, com.javaelites.lawyercatalogservice.util.SearchApiData)
	 */
	@Override
	public Page<LawyerListApiModel> getAllLawyerList(PageRequest pageRequest, SearchApiData searchData) {
		logger.debug("{} - Inside getAllLawyerList method", this.getClass());
		BooleanExpression searchExpression = queryBuilder.buildAndCombinePredicates(searchData, LawyerListApiModel.class, LawyerDetailsConstants.getLawyerDetailsConstantsMap());
		Page<LawyerListApiModel> lawyerList = lawyerListApiModelRepository.findAll(searchExpression, pageRequest);
		return lawyerList;
	}
	
	@Override
	public LawyerDetails getLawyerDetails(String lawyerCode) {
		logger.debug("{} - Inside getLawyerLocation method", this.getClass());
		return lawyerDetailsRepository.findByLawyerCode(lawyerCode);
	}

	@Override
	public List<LawyerLocation> getLawyerLocationDetails(String lawyerCode) {
		logger.debug("{} - Inside getLawyerLocation method", this.getClass());
		return lawyerLocationRepository.findByLawyerCode(lawyerCode);
	}

	@Override
	public List<ConsultationCost> getLawyerConsultationDetails(String lawyerCode) {
		logger.debug("{} - Inside getLawyerConsultationDetails method", this.getClass());
		return consultationCostRepository.findByLawyerCode(lawyerCode);
	}
	
	@Override
	public List<LawyerResumeApiModel> getLawyerResumeDetails(String lawyerCode) {
		logger.debug("{} - Inside getLawyerResumeDetails method", this.getClass());
		return lawyerResumeApiModelRepository.findByLawyerCode(lawyerCode);
	}

}

