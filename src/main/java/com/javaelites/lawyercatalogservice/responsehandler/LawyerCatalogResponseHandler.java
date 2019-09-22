package com.javaelites.lawyercatalogservice.responsehandler;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.javaelites.lawyercatalogservice.domain.mapper.LawyerDetailsMapper;
import com.javaelites.lawyercatalogservice.domain.mapper.ResponseMapper;
import com.javaelites.lawyercatalogservice.model.LawyerListApiModel;
import com.javaelites.lawyercatalogservice.util.DomainFilter;
import com.javaelites.lawyercatalogservice.util.DomainFilterObjectMapper;
import com.javaelites.lawyercatalogservice.util.LawyerConstants;
import com.javaelites.lawyercatalogservice.util.Metadata;
import com.javaelites.lawyercatalogservice.util.ResponseApiData;
import com.javaelites.lawyercatalogservice.validator.ResponseValidator;

@Component
public class LawyerCatalogResponseHandler {

	@Autowired
	private ResponseValidator responseValidator;
	
	@Autowired
	private ResponseMapper responseMapper;
	
	@Autowired
	private DomainFilterObjectMapper jsonFilterAwareMapper;
	
	protected Metadata initializeResponse (String fields, DomainFilter domainFilter, String totalCount, String status, String httpStatusCode) throws IOException {
		if (domainFilter != null) {
			jsonFilterAwareMapper.mapBeanFilterAndSerialize(fields, domainFilter);
		}
		Metadata metaData = new Metadata();
		metaData.setTotalResultCount(totalCount);
		metaData.setVersion("1.0");
		metaData.setStatus(status);
		metaData.setHttpStatusCode(httpStatusCode);
		return metaData;
	}
	
	public ResponseApiData handleLawyerCatalogResponse (List<LawyerListApiModel> data, Long size, String fields) throws IOException {
		responseValidator.validateEmptyResponse(data);
		String totalResultsCount = size != null? String.valueOf(size): String.valueOf(data.size());
		Metadata metadata = initializeResponse(fields, DomainFilter.lawyerListFilter, totalResultsCount, LawyerConstants.SUCCESS, LawyerConstants.OK);
		return responseMapper.createResponseApiData(metadata, LawyerDetailsMapper.mapper.lawyerListModelToLawyerDataList(data));
	}
}
