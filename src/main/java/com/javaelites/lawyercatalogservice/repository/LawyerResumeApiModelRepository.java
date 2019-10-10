package com.javaelites.lawyercatalogservice.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.stereotype.Repository;

import com.javaelites.lawyercatalogservice.model.LawyerResumeApiModel;

@Repository
public interface LawyerResumeApiModelRepository extends JpaRepository<LawyerResumeApiModel, Long>, QuerydslPredicateExecutor<LawyerResumeApiModel>{

	List<LawyerResumeApiModel> findByLawyerCode(String lawyerCode);

	
}
