package com.javaelites.lawyercatalogservice.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.javaelites.lawyercatalogservice.model.LawyerDetails;

@Service
public interface LawyerCatalogService {

	public List<LawyerDetails> getLawyers();

}
