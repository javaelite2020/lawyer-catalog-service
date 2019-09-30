package com.javaelites.lawyercatalogservice.validator;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import com.javaelites.lawyercatalogservice.dao.MetadataDao;
import com.javaelites.lawyercatalogservice.error.exception.ResourceNotFoundException;
import com.javaelites.lawyercatalogservice.util.LawyerConstants;
import com.javaelites.lawyercatalogservice.util.StatusMessage;

@Component
public class ResponseValidator {

	@Autowired
	private MetadataDao metadataDao;
	
	public boolean validateEmptyResponse (List<?> response) throws IOException {
		if (response.isEmpty()) {
			throw new ResourceNotFoundException("Lawyer Catalog API", metadataDao.setMetadataModel(StatusMessage.error, HttpStatus.NOT_FOUND, LawyerConstants._0));
		}
		return true;
	}
}
