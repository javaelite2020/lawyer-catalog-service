package com.javaelites.lawyercatalogservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.stereotype.Repository;

import com.javaelites.lawyercatalogservice.model.LawyerDetails;

@Repository
public interface LawyerDetailsRepository extends JpaRepository<LawyerDetails, Long>, QuerydslPredicateExecutor<LawyerDetails>{

	
}
