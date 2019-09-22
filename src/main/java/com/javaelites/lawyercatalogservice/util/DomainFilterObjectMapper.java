package com.javaelites.lawyercatalogservice.util;

import java.io.IOException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;

@Component
public class DomainFilterObjectMapper extends ObjectMapper {

	private static final long serialVersionUID = 7604113461448333950L;

	@SuppressWarnings("deprecation")
	public void mapBeanFilterAndSerialize(String fields, DomainFilter domainFilter) throws IOException {
		String regExp = "[,\\s]+";
		Set<String> columnList = new HashSet<String>();
		FilterProvider filters = new SimpleFilterProvider().addFilter(domainFilter.toString(),
				SimpleBeanPropertyFilter.serializeAllExcept(columnList));
		if (!StringUtils.isEmpty(fields)) {
			columnList = new HashSet<String>(Arrays.asList(fields.split(regExp)));
			filters = new SimpleFilterProvider().addFilter(domainFilter.toString(),
					SimpleBeanPropertyFilter.filterOutAllExcept(columnList));
		}
		this.setFilters(filters);
	}
}
