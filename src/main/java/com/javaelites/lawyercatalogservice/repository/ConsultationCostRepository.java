package com.javaelites.lawyercatalogservice.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.stereotype.Repository;

import com.javaelites.lawyercatalogservice.model.ConsultationCost;

@Repository
public interface ConsultationCostRepository extends JpaRepository<ConsultationCost, Long>, QuerydslPredicateExecutor<ConsultationCost>{

	List<ConsultationCost> findByLawyerCode(String lawyerCode);

	
}
