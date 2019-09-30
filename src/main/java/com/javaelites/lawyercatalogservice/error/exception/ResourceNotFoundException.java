package com.javaelites.lawyercatalogservice.error.exception;

import com.javaelites.lawyercatalogservice.util.Metadata;

public class ResourceNotFoundException extends ApplicationException {

	private static final long serialVersionUID = 2993652273153614248L;

	public ResourceNotFoundException(String applicationCode, Metadata metadata) {
		super(applicationCode, metadata);
	}

	
}
