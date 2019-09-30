package com.javaelites.lawyercatalogservice.util;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ResponseApiData<T> implements Serializable {

	private static final long serialVersionUID = -1179109373435193364L;
	
	private Metadata metadata;
	
	@JsonProperty(value = "data")
	private List<T> result;
	
	@JsonProperty(value = "error")
	private Object[] error = {};

	public Metadata getMetadata() {
		return metadata;
	}

	public void setMetadata(Metadata metadata) {
		this.metadata = metadata;
	}

	public List<T> getResult() {
		return result;
	}

	public void setResult(List<T> result) {
		this.result = result;
	}

	public Object[] getError() {
		return error;
	}

	public void setError(Object[] error) {
		this.error = error;
	}
	
}
