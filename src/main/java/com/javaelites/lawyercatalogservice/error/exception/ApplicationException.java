package com.javaelites.lawyercatalogservice.error.exception;

import com.javaelites.lawyercatalogservice.util.Metadata;

public class ApplicationException extends RuntimeException {

	private static final long serialVersionUID = -3866183223438906308L;
	
	private final String applicationCode;
	private final transient Metadata metadata;
	
	public ApplicationException(String applicationCode, Metadata metadata) {
		super();
		this.applicationCode = applicationCode;
		this.metadata = metadata;
	}

	public String getApplicationCode() {
		return applicationCode;
	}

	public Metadata getMetadata() {
		return metadata;
	}
	
	
}
