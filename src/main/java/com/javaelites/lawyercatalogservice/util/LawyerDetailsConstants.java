package com.javaelites.lawyercatalogservice.util;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public enum LawyerDetailsConstants {

	fist_name("firstName"), last_name("lastName");
	
	private final String value;
	
	private LawyerDetailsConstants (String value) {
		this.value = value;
	}
	
	public String getValue () {
		return this.value;
	}
	
	private static Map<String, String> createMap () {
		Map<String, String> map = new HashMap<String, String> ();
		for (LawyerDetailsConstants con: LawyerDetailsConstants.values()) {
			map.put(con.name(), con.value);
		}
		return Collections.unmodifiableMap(map);
	}
	
	public static Map<String, String> getLawyerDetailsConstantsMap() {
		return createMap();
	}
}
