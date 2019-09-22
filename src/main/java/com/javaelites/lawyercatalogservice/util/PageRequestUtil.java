package com.javaelites.lawyercatalogservice.util;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Order;
import org.springframework.util.StringUtils;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.javaelites.lawyercatalogservice.domain.dto.SortData;
import com.javaelites.lawyercatalogservice.domain.dto.SortsData;

public class PageRequestUtil {

	public static final Logger log = LoggerFactory.getLogger(PageRequestUtil.class);
	
	/**
	 * Create a new PageRequest with default values
	 * 
	 * @param pageNumber Zero based page index
	 * @param pageLimit The size of the page to be returned
	 * @return The PageRequest
	 */
	public static PageRequest getPageRequest (final Integer pageNumber, final Integer pageLimit) {
		Integer size = pageLimit != null ? pageLimit: 50;
		// Page is zero based index so 0 return first page
		Integer page = pageNumber != null ? (pageNumber-1): 0;
		
		return PageRequest.of(page, size);
	}
	
	
	/**
	 * Create a new PageRequest with sort parameters
	 * 
	 * @param pageNumber Zero based page index
	 * @param pageLimit The size of the page to be returned
	 * @param sorts The Sorts data
	 * @param defaultSort The default sort property
	 * @return the PageRequest
	 * 
	 */
	public static PageRequest getPageRequest (final Integer pageNumber, final Integer pageLimit, final String sorts, final String defaultSort) {
		log.debug("Inside Lawyer Catalog Page Request method getPageRequest()");
		Integer size = pageLimit != null ? pageLimit: 50;
		// Page is zero based index so 0 return first page
		Integer page = pageNumber != null ? (pageNumber-1): 0;
		PageRequest pageRequest = null;
		if (StringUtils.isEmpty(sorts)) {
			pageRequest = PageRequest.of(page, size, Sort.DEFAULT_DIRECTION, defaultSort);
		} else {
			SortsData sortsData = null;
			try {
				sortsData = new Gson().fromJson(sorts, SortsData.class);
			} catch (JsonSyntaxException jse) {
				log.debug("Invalid Sort property: {}. Continue with default sort: {}", sorts, defaultSort);
			}
			
			if (sortsData != null) {
				List<Order> sortOrderList = new ArrayList<Order> ();
				for (SortData sortData : sortsData.getSorts()) {
					String sortProperty = LawyerDetailsConstants.valueOf(sortData.getProperty()).getValue();
					if (StringUtils.isEmpty(sortProperty)) {
						if (LawyerConstants.DESC.equalsIgnoreCase(sortProperty)) {
							sortOrderList.add(new Order(Sort.Direction.DESC, sortProperty));
						} else {
							sortOrderList.add(new Order(Sort.Direction.ASC, sortProperty));
						}
					}
				}
				Sort sort = Sort.by(sortOrderList);
				pageRequest = PageRequest.of(page, size, sort);
			}
		}
		return pageRequest;
	}
}
