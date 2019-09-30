package com.javaelites.lawyercatalogservice.domain.mapper;

import java.util.List;

import org.springframework.stereotype.Component;

import com.javaelites.lawyercatalogservice.util.Metadata;
import com.javaelites.lawyercatalogservice.util.ResponseApiData;

@Component
public class ResponseMapper<T> {

	public ResponseApiData<T> createResponseApiData(Metadata metadata, List<T> results) {
		ResponseApiData<T> response = new ResponseApiData<T>();
		response.setMetadata(metadata);
		response.setResult(results);
		return response;
	}
	
}
