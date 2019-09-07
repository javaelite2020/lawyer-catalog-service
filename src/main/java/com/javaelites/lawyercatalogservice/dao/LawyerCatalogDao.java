package com.javaelites.lawyercatalogservice.dao;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import com.javaelites.lawyercatalogservice.model.LawyerDetails;

@Service
public interface LawyerCatalogDao {
	public Page<LawyerDetails> getLawyerDetails();
}
