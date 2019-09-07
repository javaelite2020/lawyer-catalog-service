package com.javaelites.lawyercatalogservice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.javaelites.lawyercatalogservice.dao.LawyerCatalogDao;
import com.javaelites.lawyercatalogservice.model.LawyerDetails;

@Component
public class LawyerCatalogServiceImpl implements LawyerCatalogService {

	@Autowired
	private LawyerCatalogDao lawyerCatalogDao;
	
	@Override
	public List<LawyerDetails> getLawyers() {
		// TODO Auto-generated method stub
		return lawyerCatalogDao.getLawyerDetails().getContent();
	}

}
