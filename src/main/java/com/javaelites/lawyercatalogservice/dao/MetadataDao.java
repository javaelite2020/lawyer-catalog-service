package com.javaelites.lawyercatalogservice.dao;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import com.javaelites.lawyercatalogservice.util.Metadata;
import com.javaelites.lawyercatalogservice.util.StatusMessage;

@Component
public class MetadataDao {
	
	private Metadata metadata;

	public Metadata setMetadataModel (StatusMessage message, HttpStatus httpStatus, String totalCount) {
		metadata = new Metadata();
		metadata.setVersion("1.0");
		metadata.setHttpStatusCode(httpStatus.toString());
		metadata.setTotalResultCount(totalCount);
		if (StatusMessage.success.toString().equalsIgnoreCase(message.toString())) {
			metadata.setStatus(StatusMessage.success.toString());
		} else {
			metadata.setStatus(StatusMessage.error.toString());
		}
		return metadata;
	}
}
