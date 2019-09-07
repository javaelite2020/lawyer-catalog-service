package com.javaelites.lawyercatalogservice.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.stereotype.Component;

import com.javaelites.lawyercatalogservice.model.LawyerDetails;
import com.javaelites.lawyercatalogservice.repository.LawyerDetailsRepository;

@Component
public class LawyerCatalogDaoImpl implements LawyerCatalogDao {
	
	@Autowired
	private LawyerDetailsRepository lawyerRepository;
	
	
	/* (non-Javadoc)
	 * @see com.javaelites.lawyercatalogservice.dao.LawyerCatalogDao#getLawyerDetails()
	 */
	public Page<LawyerDetails> getLawyerDetails() {
		/*
		 * List<LawyerDetails> lawyerList = new ArrayList<LawyerDetails>();
		 * LawyerDetails lawyerDetails = new LawyerDetails();
		 * lawyerDetails.setFirstName("David"); lawyerDetails.setLastName("Miller");
		 * lawyerDetails.setDescription("Family Lawyer"); lawyerList.add(lawyerDetails);
		 * return new PageImpl<LawyerDetails>(lawyerList);
		 */
		
		List<LawyerDetails> lawyerList = lawyerRepository.findAll();
		return new PageImpl<LawyerDetails>(lawyerList);
	}
}
