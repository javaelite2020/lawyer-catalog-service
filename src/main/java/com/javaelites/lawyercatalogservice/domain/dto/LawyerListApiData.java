package com.javaelites.lawyercatalogservice.domain.dto;

import java.sql.Date;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonFilter("lawyerListFilter")
public class LawyerListApiData {

	@JsonProperty("LAWYER_ID")
	private Long lawyerId;
	
	@JsonProperty("FIRST_NAME")
	private String firstName;
	
	@JsonProperty("MIDDLE_NAME")
	private String middleName;
	
	@JsonProperty("LAST_NAME")
	private String lastName;
	
	@JsonProperty("DESCRIPTION")
	private String description;
	
	@JsonProperty("LONG_DESCRIPTION")
	private String longDescription;
	
	@JsonProperty("CELLPHONE")
	private String cellPhone;
	
	@JsonProperty("OFFICE_PHONE")
	private String officePhone;
	
	@JsonProperty("AVG_USER_RATING")
	private Long averageRating;
	
	@JsonProperty("AVG_LAWYER_RATING")
	private Long averageLawyerRating;
	
	@JsonProperty("WEBSITE")
	private String website;
	
	@JsonProperty("LAWFIRM_NAME")
	private String lawfirmName;
	
	@JsonProperty("LANGUAGES")
	private String languages;
	
	@JsonProperty("CREATED_BY")
	private String createdBy;
	
	@JsonProperty("CREATED_DATE")
	private Date createdDate;
	
	@JsonProperty("MODIFIED_BY")
	private String modifiedBy;
	
	@JsonProperty("MODIFIED_DATE")
	private Date modifiedDate;

	public Long getLawyerId() {
		return lawyerId;
	}

	public void setLawyerId(Long lawyerId) {
		this.lawyerId = lawyerId;
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
