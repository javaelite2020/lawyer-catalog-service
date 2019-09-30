package com.javaelites.lawyercatalogservice.util;

import java.lang.reflect.Field;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.core.types.dsl.PathBuilder;
import com.querydsl.core.types.dsl.PathBuilderFactory;

/**
 * This class handles converting search data into a QueryDSL predicate, allowing it to be passed 
 * along to Spring Data JPA.
 * <p/>
 * In order to use this functionality, your Repository should be a Spring Data repository and should
 * implement the Query DSL interface referenced above.
 * 
 * @author SunkaC01
 * 
 * @param <T>
 */
@Component
public class QueryBuilder<T> {
	private static final Logger LOG = LoggerFactory.getLogger(QueryBuilder.class);
	 
	@Autowired
	private JsonToObjectMapper jsonMapper;
	
	/**
	 * Builds the QueryDsl predicates to pass to Spring Data JPA in order to filter the resultset. <br/> 
	 * The combining of predicates is assumed to be all ANDs for this method.
	 * <p/>
	 * Use this method if the SearchData's property name needs to be mapped between UI field name and entity field name
	 * 
	 * @param searchApiData The Search Api Data object
	 * @param jpaEntity The JPA Entity that you are trying to build a predicate for
	 * @param fieldsMap The Map that contains the UI field name and its corresponding entity field name 
	 * @return A QueryDsl predicate representing a where clause filter
	 */
	public BooleanExpression buildAndCombinePredicates(SearchApiData searchApiData, Class<T> jpaEntity, Map<String, String> fieldsMap) {
		List<BooleanExpression> searchExpressionList = createSearchExpression(null, searchApiData, jpaEntity, fieldsMap, true);
		BooleanExpression combinedExpression = null;
		for(BooleanExpression booleanExpression : searchExpressionList){
			if(!StringUtils.isEmpty(booleanExpression)) {
				combinedExpression = combinedExpression == null ? booleanExpression : combinedExpression.and(booleanExpression);
			}
		}
		return combinedExpression;
	}
	
	/**
	 * Builds the QueryDsl predicates to pass to Spring Data JPA in order to filter the resultset. <br/> 
	 * The combining of predicates is assumed to be all ANDs for this method.
	 * <p/>
	 * User this method if SearchData contains entity field names.
	 * 
	 * @param searchApiData The Search Api Data object
	 * @param jpaEntity The JPA Entity that you are trying to build a predicate for
	 * @return A QueryDsl predicate representing a where clause filter
	 */
	public BooleanExpression buildAndCombinePredicates(SearchApiData searchApiData, Class<T> jpaEntity) {
		List<BooleanExpression> searchExpressionList = createSearchExpression(null, searchApiData, jpaEntity, null, false);
		BooleanExpression combinedExpression = null;
		for(BooleanExpression booleanExpression : searchExpressionList){
			if(!StringUtils.isEmpty(booleanExpression)) {
				combinedExpression = combinedExpression == null? booleanExpression : combinedExpression.and(booleanExpression);
			}
		}
		return combinedExpression;
	}
	
	/**
	 * Builds the QueryDsl predicates to pass to Spring Data JPA in order to filter the resultset. <br/> 
	 * The combining of predicates is assumed to be all ANDs for this method.
	 * <p/>
	 * Use this method if the JSON string's property name needs to be mapped between UI field name and entity field name.
	 * <p/>
	 * The json format should be: 
	 * 	<i>{ "search": [{"property":"aaa",  "value":"yyy", "operator": "op1"}, {"property":"bbb",  "value":"zzz", "operator": "op2"}]}</i>
	 * <br/>
	 *
	 * @param json The Json Search String
	 * @param jpaEntity The JPA Entity that you are trying to build a predicate for
	 * @param fieldsMap The Map that contains the UI field name and its corresponding entity field name 
	 * @return A QueryDsl predicate representing a where clause filter
	 */
	public BooleanExpression buildAndCombinePredicates(String json, Class<T> jpaEntity, Map<String, String> fieldsMap) {
		LOG.debug("{} {} createCombinedSearchExpression method", ApiConstants.INSIDE, this.getClass());
		List<BooleanExpression> searchExpressionList = createSearchExpression(json, null, jpaEntity, fieldsMap, true);
		BooleanExpression combinedExpression = null;
		for(BooleanExpression booleanExpression : searchExpressionList){
			if(!StringUtils.isEmpty(booleanExpression)) {
				combinedExpression = combinedExpression == null ? booleanExpression : combinedExpression.and(booleanExpression);
			}
		}
		return combinedExpression;
	} 
	
	/**
	 * Builds the QueryDsl predicates to pass to Spring Data JPA in order to filter the resultset. <br/> 
	 * The combining of predicates is assumed to be all ANDs for this method.
	 * <p/>
	 * Use this method if SearchData contains entity field names.
	 * <p/>
	 * The json format should be: 
	 * 	<i>{ "search": [{"property":"aaa",  "value":"yyy", "operator": "op1"}, {"property":"bbb",  "value":"zzz", "operator": "op2"}]}</i>
	 * <br/>
	 *
	 * @param json The Json Search String
	 * @param jpaEntity The JPA Entity that you are trying to build a predicate for
	 * @return A QueryDsl predicate representing a where clause filter
	 */
	public BooleanExpression buildAndCombinePredicates(String json, Class<T> jpaEntity) {
		LOG.debug("{} {} createCombinedSearchExpression method", ApiConstants.INSIDE, this.getClass());
		List<BooleanExpression> searchExpressionList = createSearchExpression(json, null, jpaEntity, null, false);
		BooleanExpression combinedExpression = null;
		for(BooleanExpression booleanExpression : searchExpressionList){
			if(!StringUtils.isEmpty(booleanExpression)) {
				combinedExpression = combinedExpression == null ? booleanExpression : combinedExpression.and(booleanExpression);
			}
		}
		return combinedExpression;
	} 
	
	/**
	 * Builds the QueryDsl predicates to pass to Spring Data JPA in order to filter the resultset. <br/> 
	 * It returns the list of predicates that can be combined as per need basis.<br/>
	 * For example, combine the predicates using AND or OR.
	 * <p/>
	 * Use this method if the JSON string's property name needs to be mapped between UI field name and entity field name.
	 * <p/>
	 * The json format should be: 
	 * 	<i>{ "search": [{"property":"aaa",  "value":"yyy", "operator": "op1"}, {"property":"bbb",  "value":"zzz", "operator": "op2"}]}</i>
	 * <br/>
	 *
	 * @param json The Json Search String
	 * @param jpaEntity The JPA Entity that you are trying to build a predicate for
	 * @param fieldsMap The Map that contains the UI field name and its corresponding entity field name 
	 * @return A list of QueryDsl predicates representing a where clause filter
	 */
	public List<BooleanExpression> createSearchExpression(String json, Class<T> jpaEntity, Map<String, String> fieldsMap) {
		LOG.debug("{} {} createSearchExpression method", ApiConstants.INSIDE, this.getClass());
		return createSearchExpression(json, null, jpaEntity, fieldsMap, true);
	} 

	/**
	 * Builds the QueryDsl predicates to pass to Spring Data JPA in order to filter the resultset. <br/> 
	 * It returns the list of predicates that can be combined as per need basis. <br/>
	 * For example, combine the predicates using AND or OR.
	 * <p/>
	 * Use this method if the JSON string's property name contains entity field name.
	 * <p/>
	 * The json format should be: 
	 * 	<i>{ "search": [{"property":"aaa",  "value":"yyy", "operator": "op1"}, {"property":"bbb",  "value":"zzz", "operator": "op2"}]}</i>
	 * <br/>
	 *
	 * @param json The Json Search String
	 * @param jpaEntity The JPA Entity that you are trying to build a predicate for
	 * @return A list of QueryDsl predicates representing a where clause filter
	 */
	public List<BooleanExpression> createSearchExpression(String json, Class<T> jpaEntity) {
		LOG.debug("{} {} createSearchExpression method", ApiConstants.INSIDE, this.getClass());
		return createSearchExpression(json, null, jpaEntity, null, false);
	}
	
	/**
	 * Builds the QueryDsl predicates to pass to Spring Data JPA in order to filter the resultset. <br/> 
	 * It can handle both Json String and SearchApiData object to build QueryDsl Predicates.
	 * 
	 * <p/>
	 * The json format should be: 
	 * 	<i>{ "search": [{"property":"aaa",  "value":"yyy", "operator": "op1"}, {"property":"bbb",  "value":"zzz", "operator": "op2"}]}</i>
	 * <br/>
	 * 
	 * @param json The Json Search String
	 * @param searchApiData The Search Api Data Object
	 * @param jpaEntity The JPA Entity that you are trying to build a predicate for
	 * @param fieldsMap The Map that contains the UI field name and its corresponding entity field name
	 * @param useMappedFields The useMappedFields indicator to use UI field to Entity field mapping
	 * @return  A list of QueryDsl predicates representing a where clause filter
	 */
	public List<BooleanExpression> createSearchExpression(String json, SearchApiData searchApiData, Class<T> jpaEntity, Map<String, String> fieldsMap, boolean useMappedFields) {
		LOG.debug("{} {} createSearchExpression method", ApiConstants.INSIDE, this.getClass());
		List<BooleanExpression> list = new ArrayList<BooleanExpression>();
		if ((StringUtils.isEmpty(json) && searchApiData == null) || jpaEntity == null) {
			return list;
		}
		SearchApiData searchJsonData = getSearchApiData(json, searchApiData);
		if (searchJsonData != null) {
			final List<SearchData> searchDataList = searchJsonData.getSearch();
			PathBuilder<?> builder = new PathBuilderFactory().create(jpaEntity);
			Field declaredField = null;
			Class<?> type = null;
			String searchProperty;
			for (SearchData searchData: searchDataList) {
				// If Operator is empty or null then proceed. 
				// If Operator is received then check if it is a valid, if not, then throw an exception.
				searchProperty = searchData.getProperty();
				if (useMappedFields) {
					searchProperty = fieldsMap.get(searchData.getProperty());	
				}
				if (StringUtils.isEmpty(searchProperty)) {
					LOG.error("No Entity field found for search property {} in createSearchExpression method: {}", searchData.getProperty());
					throw new IllegalArgumentException("Invalid search property specified: "+ searchData.getProperty());
				}
				declaredField = getDelaredField(jpaEntity, searchProperty);
				if (declaredField != null) {
					type = declaredField.getType();
					if (type.isAssignableFrom(String.class)) {
						list.add(getBooleanExpressionForString(builder, searchData, searchProperty));
					} else if (type.isAssignableFrom(Long.class)) {
						list.add(getBooleanExpressionForLong(builder, searchData, searchProperty));
					} else if (type.isAssignableFrom(BigInteger.class)) {
						list.add(getBooleanExpressionForBigInteger(builder, searchData, searchProperty));
					}
				}
			}
		}
		return list;
	}
	
	/**
	 * Converts json string to SearchApiData object
	 * 
	 * @param json The json string
	 * @param searchApiData The Search Api Data Object
	 * @return The SearchApiData
	 */
	private SearchApiData getSearchApiData(String json, SearchApiData searchApiData) {
		SearchApiData searchJsonData = null; 
		if (!StringUtils.isEmpty(json)) {
			searchJsonData = (SearchApiData) jsonMapper.convertJsonToObject(json, SearchApiData.class);
		} else if (searchApiData != null) {
			searchJsonData = searchApiData;
		}
		return searchJsonData;
	}
	
	/**
	 * Returns the entities declared field for a given property
	 * 
	 * @param jpaEntity The JPA Entity 
	 * @param searchProperty  The search property
	 * @return Field
	 */
	private Field getDelaredField(Class<T> jpaEntity, String searchProperty) {
		Field declaredField = null;
		try {
			if (!StringUtils.isEmpty(searchProperty)) {
				declaredField = jpaEntity.getDeclaredField(searchProperty);
			}
		} catch (NoSuchFieldException | SecurityException e) {
			LOG.error("Failed to find declared field for search property {} in getDelaredField method: {}", searchProperty, e);
			throw new IllegalArgumentException("Failed to find declared field for search property in getDeclaredField: "+ searchProperty, e);
		}
		return declaredField;
	}

	/**
	 * Builds a QueryDsl expression for a String field.
	 * 
	 * @param builder The PathBuilder
	 * @param searchData The SearchData
	 * @param searchProperty The Search Property
	 * @return BooleanExpression
	 */
	private BooleanExpression getBooleanExpressionForString(PathBuilder<?> builder, SearchData searchData, String searchProperty) {
		BooleanExpression expression = null;
		if (searchData != null) {
			String operator = searchData.getOperator();
			// If Operator is empty or null then default to 'containsIgnoreCase'.
			if (StringUtils.isEmpty(operator)) {
				operator = OperationConstants.CONTAINS_IGNORE_CASE;
			}
			 switch(operator) { 
			  	case OperationConstants.EQUALS: expression = builder.getString(searchProperty).eq(searchData.getValue());break; 
			  	case OperationConstants.NOT_EQUALS: expression = builder.getString(searchProperty).ne(searchData.getValue());break; 
			  	case OperationConstants.EQUALS_IGNORE_CASE: expression = builder.getString(searchProperty).equalsIgnoreCase(searchData.getValue());break; 
			  	case OperationConstants.NOT_EQUALS_IGNORE_CASE: expression = builder.getString(searchProperty).notEqualsIgnoreCase(searchData.getValue());break;
			  	case OperationConstants.CONTAINS: expression = builder.getString(searchProperty).contains(searchData.getValue());break; 
			  	case OperationConstants.CONTAINS_IGNORE_CASE: expression = builder.getString(searchProperty).containsIgnoreCase(searchData.getValue());break;
			  	case OperationConstants.STARTS_WITH: expression = builder.getString(searchProperty).startsWith(searchData.getValue());break; 
			  	case OperationConstants.STARTS_WITH_IGNORE_CASE: expression = builder.getString(searchProperty).startsWithIgnoreCase(searchData.getValue());break; 
			  	case OperationConstants.LIKE: expression = builder.getString(searchProperty).like(searchData.getValue());break;
			  	case OperationConstants.IN: 
											List<String> items = Arrays.asList(searchData.getValue().split("\\s*,\\s*"));
											expression = builder.getString(searchProperty).in(items);break;
				case OperationConstants.NOT_IN: 
											List<String> notInItems = Arrays.asList(searchData.getValue().split("\\s*,\\s*"));
											expression = builder.getString(searchProperty).notIn(notInItems);break;
			 	default: throw new IllegalArgumentException("Invalid Operator: " + operator + ", specified for Search property: " + searchProperty); 
			 }
		}
		return expression;
	} 
	
	/**
	 * Builds a QueryDsl expression for a Long field.
	 * 
	 * @param builder The PathBuilder
	 * @param searchData The SearchData
	 * @param searchProperty The Search Property
	 * @return BooleanExpression
	 */
	private BooleanExpression getBooleanExpressionForLong(PathBuilder<?> builder, SearchData searchData, String searchProperty) {
		BooleanExpression expression = null;
		if (searchData != null) {
			String operator = searchData.getOperator();
			// If Operator is empty or null then default to 'eq'.
			if (StringUtils.isEmpty(operator)) {
				operator = OperationConstants.EQUALS;
			}
			final Long longValue = Long.valueOf(searchData.getValue());
			switch(operator){ 
				case OperationConstants.EQUALS: expression = builder.getNumber(searchProperty, Long.class).eq(longValue);break; 
				case OperationConstants.NOT_EQUALS: expression = builder.getNumber(searchProperty, Long.class).ne(longValue);break; 
			 	case OperationConstants.LESS_THAN: expression = builder.getNumber(searchProperty, Long.class).lt(longValue);break; 
			 	case OperationConstants.LESS_OR_EQ: expression = builder.getNumber(searchProperty, Long.class).loe(longValue);break; 
			 	case OperationConstants.GREATER_THAN: expression = builder.getNumber(searchProperty, Long.class).gt(longValue);break; 
			 	case OperationConstants.GREATER_OR_EQ: expression = builder.getNumber(searchProperty, Long.class).goe(longValue);break; 
			 	default: throw new IllegalArgumentException("Invalid Operator: " + operator + ", specified for Search property: " + searchProperty); 
			}
		}
		return expression;
	} 
	
	/**
	 * Builds a QueryDsl expression for a Big Integer field.
	 * 
	 * @param builder The PathBuilder
	 * @param searchData The SearchData
	 * @param searchProperty The Search Property
	 * @return BooleanExpression
	 */
	private BooleanExpression getBooleanExpressionForBigInteger(PathBuilder<?> builder, SearchData searchData, String searchProperty) {
		BooleanExpression expression = null;
		if (searchData != null) {
			String operator = searchData.getOperator();
			// If Operator is empty or null then default to 'eq'.
			if (StringUtils.isEmpty(operator)) {
				operator = OperationConstants.EQUALS;
			}
			final BigInteger bigIntValue = new BigInteger (searchData.getValue());
			switch(operator){ 
				 case OperationConstants.EQUALS: expression = builder.getNumber(searchProperty, BigInteger.class).eq(bigIntValue);break;
				 case OperationConstants.NOT_EQUALS: expression = builder.getNumber(searchProperty, BigInteger.class).ne(bigIntValue);break; 
				 case OperationConstants.LESS_THAN: expression = builder.getNumber(searchProperty, BigInteger.class).lt(bigIntValue);break;
				 case OperationConstants.LESS_OR_EQ: expression = builder.getNumber(searchProperty, BigInteger.class).loe(bigIntValue);break;
				 case OperationConstants.GREATER_THAN: expression = builder.getNumber(searchProperty, BigInteger.class).gt(bigIntValue);break;
				 case OperationConstants.GREATER_OR_EQ: expression = builder.getNumber(searchProperty, BigInteger.class).goe(bigIntValue);break;
				 default: throw new IllegalArgumentException("Invalid Operator: " + operator + ", specified for Search property: " + searchProperty);
			}
		}
		return expression;
	}
	
}
