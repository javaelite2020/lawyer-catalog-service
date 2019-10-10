package com.javaelites.lawyercatalogservice.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.stereotype.Repository;

import com.javaelites.lawyercatalogservice.model.LawyerLocation;

@Repository
public interface LawyerLocationRepository extends JpaRepository<LawyerLocation, Long>, QuerydslPredicateExecutor<LawyerLocation>{

	List<LawyerLocation> findByLawyerCode(String lawyerCode);

	
}
