package com.javaelites.lawyercatalogservice.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;

/**
 * 
 * Converts Json to Object and vice versa.
 * 
 * 
 * @param <T>
 */
@Component
public class JsonToObjectMapper<T> {

	private static final Logger LOG = LoggerFactory.getLogger(JsonToObjectMapper.class);
	
	/**
	 * Deserializes the specified Json into an object of the specified class.
	 * 
	 * @param json The json string
	 * @param entity The Entity class 
	 * @return An Object
	 */
	public Object convertJsonToObject(String json, Class<T> entity) {
		Object dataObject = null;
		if (!StringUtils.isEmpty(json) && entity != null) {
			try {
				dataObject = new Gson().fromJson(json, entity);
			} catch (JsonSyntaxException jse) {
				// Invalid json property received.
				LOG.debug("Invalid search data");
				throw new IllegalArgumentException("Unable to parse JSON object: ", jse);
			}	
		}
		return dataObject;
	}

	
	/**
	 * Serializes the specified object into its equivalent Json representation.
	 * 
	 * @param json The Json Object
	 * @return The json representation of the source
	 */
	public String convertObjectToJson(Object json) {
		return new Gson().toJson(json);
	}
}