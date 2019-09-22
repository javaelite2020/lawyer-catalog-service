package com.javaelites.lawyercatalogservice.util;

public enum DomainFilter {

	lawyerListFilter("lawyerListFilter"), LawyerDetailsFilter("lawyerDetailsFilter");
	
	private final String value;
	
	private DomainFilter (String value) {
		this.value = value;
	}
	
	public String getValue () {
		return this.value;
	}
	
}
