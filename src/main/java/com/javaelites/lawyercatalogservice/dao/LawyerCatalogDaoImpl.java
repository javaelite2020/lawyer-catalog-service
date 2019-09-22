package com.javaelites.lawyercatalogservice.dao;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Component;

import com.javaelites.lawyercatalogservice.model.ConsultationCost;
import com.javaelites.lawyercatalogservice.model.LawyerListApiModel;
import com.javaelites.lawyercatalogservice.model.LawyerLocation;
import com.javaelites.lawyercatalogservice.repository.LawyerDetailsRepository;
import com.javaelites.lawyercatalogservice.repository.LawyerListApiModelRepository;
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
	public LawyerLocation getLawyerLocation() {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public ConsultationCost getLawywerConsultationDetails() {
		// TODO Auto-generated method stub
		return null;
	}
}
