package com.javaelites.lawyercatalogservice.domain.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.javaelites.lawyercatalogservice.domain.dto.LawyerDetailsApiData;
import com.javaelites.lawyercatalogservice.domain.dto.LawyerDetailsDTO;
import com.javaelites.lawyercatalogservice.domain.dto.LawyerListApiData;
import com.javaelites.lawyercatalogservice.model.LawyerDetails;
import com.javaelites.lawyercatalogservice.model.LawyerListApiModel;

@Mapper
public interface LawyerDetailsMapper {

	LawyerDetailsMapper mapper = Mappers.getMapper(LawyerDetailsMapper.class);
	
	List<LawyerListApiData> lawyerListModelToLawyerDataList(List<LawyerListApiModel> lawyerModelList);
	LawyerListApiData lawyerModelToLawyerData(LawyerListApiModel lawyerModel);
	List<LawyerDetailsApiData> LawyerDetailsListToLawyerDetailsApiDataList(List<LawyerDetails> lawyerModelList);
	LawyerDetailsApiData LawyerDetailsToLawyerDetailsApiData(LawyerDetails lawyerModel);
	

	LawyerDetails lawyerDetailsDTOToLawyerDetails(LawyerDetailsDTO lawyerDetailsDTO);
}
