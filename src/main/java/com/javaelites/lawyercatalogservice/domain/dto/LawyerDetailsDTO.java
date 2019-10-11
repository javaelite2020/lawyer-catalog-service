package com.javaelites.lawyercatalogservice.domain.dto;

import java.sql.Date;

import com.fasterxml.jackson.annotation.JsonProperty;

public class LawyerDetailsDTO {

	@JsonProperty("lawyer_code")
	private String lawyerCode;
	
	@JsonProperty("first_name")
	private String firstName;
	
	@JsonProperty("middle_name")
	private String middleName;
	
	@JsonProperty("last_name")
	private String lastName;
	
	@JsonProperty("description")
	private String description;
	
	@JsonProperty("long_description")
	private String longDescription;
	
	@JsonProperty("cell_phone")
	private String cellPhone;
	
	@JsonProperty("office_phone")
	private String officePhone;
	
	@JsonProperty("average_rating")
	private Long averageRating;
	
	@JsonProperty("average_lawyer_rating")
	private Long averageLawyerRating;
	
	@JsonProperty("website")
	private String website;
	
	@JsonProperty("lawfirm_name")
	private String lawfirmName;
	
	@JsonProperty("languages")
	private String languages;
	
	@JsonProperty("created_by")
	private String createdBy;
	
	@JsonProperty("created_date")
	private Date createdDate; 
	
	@JsonProperty("modified_by")
	private String modifiedBy;
	
	@JsonProperty("modified_date")
	private Date modifiedDate;

	public String getLawyerCode() {
		return lawyerCode;
	}

	public void setLawyerCode(String lawyerCode) {
		this.lawyerCode = lawyerCode;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getMiddleName() {
		return middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getLongDescription() {
		return longDescription;
	}

	public void setLongDescription(String longDescription) {
		this.longDescription = longDescription;
	}

	public String getCellPhone() {
		return cellPhone;
	}

	public void setCellPhone(String cellPhone) {
		this.cellPhone = cellPhone;
	}

	public String getOfficePhone() {
		return officePhone;
	}

	public void setOfficePhone(String officePhone) {
		this.officePhone = officePhone;
	}

	public Long getAverageRating() {
		return averageRating;
	}

	public void setAverageRating(Long averageRating) {
		this.averageRating = averageRating;
	}

	public Long getAverageLawyerRating() {
		return averageLawyerRating;
	}

	public void setAverageLawyerRating(Long averageLawyerRating) {
		this.averageLawyerRating = averageLawyerRating;
	}

	public String getWebsite() {
		return website;
	}

	public void setWebsite(String website) {
		this.website = website;
	}

	public String getLawfirmName() {
		return lawfirmName;
	}

	public void setLawfirmName(String lawfirmName) {
		this.lawfirmName = lawfirmName;
	}

	public String getLanguages() {
		return languages;
	}

	public void setLanguages(String languages) {
		this.languages = languages;
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
