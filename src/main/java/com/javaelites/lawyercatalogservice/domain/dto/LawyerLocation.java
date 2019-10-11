package com.javaelites.lawyercatalogservice.domain.dto;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonProperty;

public class LawyerLocation {

	@JsonProperty("LAWYER_LOCATION_ID")
	private Long lawyerLocationId;
	
	@JsonProperty("lawyer_code")
	private String lawyerCode;
	
	@JsonProperty("ADDRESS1")
	private String address1;
	
	@JsonProperty("ADDRESS2")
	private String address2;
	
	@JsonProperty("CITY")
	private String city;
	
	@JsonProperty("DISTRICT")
	private String district;
	
	@JsonProperty("STATE")
	private String state;
	
	@JsonProperty("COUNTRY")
	private String country;
	
	@JsonProperty("ZIPCODE")
	private String zipCode;
	
	@JsonProperty("CREATED_BY")
	private String createdBy;
	
	@JsonProperty("CREATED_DATE")
	private Date createdDate;
	
	@JsonProperty("MODIFIED_BY")
	private String modifiedBy;
	
	@JsonProperty("MODIFIED_DATE")
	private Date modifiedDate;

	public Long getLawyerLocationId() {
		return lawyerLocationId;
	}

	public void setLawyerLocationId(Long lawyerLocationId) {
		this.lawyerLocationId = lawyerLocationId;
	}

	public String getAddress1() {
		return address1;
	}

	public void setAddress1(String address1) {
		this.address1 = address1;
	}

	public String getAddress2() {
		return address2;
	}

	public void setAddress2(String address2) {
		this.address2 = address2;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getDistrict() {
		return district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public String getModifiedBy() {
		return modifiedBy;
	}

	public void setModifiedBy(String modifiedBy) {
		this.modifiedBy = modifiedBy;
	}

	public Date getModifiedDate() {
		return modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		this.modifiedDate = modifiedDate;
	}
	
}
