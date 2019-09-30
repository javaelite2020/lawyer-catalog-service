package com.javaelites.lawyercatalogservice.util;

import java.io.Serializable;

public class Metadata implements Serializable{

	private static final long serialVersionUID = 2238647125799906452L;
	
	private String version;
	private String status;
	private String httpStatusCode;
	private String totalResultCount;
	
	public String getVersion() {
		return version;
	}
	public void setVersion(String version) {
		this.version = version;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getHttpStatusCode() {
		return httpStatusCode;
	}
	public void setHttpStatusCode(String httpStatusCode) {
		this.httpStatusCode = httpStatusCode;
	}
	public String getTotalResultCount() {
		return totalResultCount;
	}
	public void setTotalResultCount(String totalResultCount) {
		this.totalResultCount = totalResultCount;
	}
	
}
