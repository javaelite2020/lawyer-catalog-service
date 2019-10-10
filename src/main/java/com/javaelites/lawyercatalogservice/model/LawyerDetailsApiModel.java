package com.javaelites.lawyercatalogservice.model;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="LAWYER_DETAILS_2")
public class LawyerDetailsApiModel implements Serializable {

	private static final long serialVersionUID = 720200293861671680L;

	@Id
	@SequenceGenerator(name="LAWYER_ID", sequenceName="SEQ_LAWYER_ID", allocationSize=1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator="LAWYER_ID")
	@Column(name = "LAWYER_ID")
	private Long lawyerId;
	
	@Column(name = "FIRST_NAME")
	private String firstName;
	
	@Column(name = "MIDDLE_NAME")
	private String middleName;
	
	@Column(name = "LAST_NAME")
	private String lastName;
	
	@Column(name = "DESCRIPTION")
	private String description;
	
	@Column(name = "LONG_DESCRIPTION")
	private String longDescription;
	
	@Column(name = "CELLPHONE")
	private String cellPhone;
	
	@Column(name = "OFFICE_PHONE")
	private String officePhone;
	
	@Column(name = "AVG_USER_RATING")
	private Long averageRating;
	
	@Column(name = "AVG_LAWYER_RATING")
	private Long averageLawyerRating;
	
	@Column(name = "WEBSITE")
	private String website;
	
	@Column(name = "LAWFIRM_NAME")
	private String lawfirmName;
	
	@Column(name = "LANGUAGES")
	private String languages;
	
	@Column(name = "CREATED_BY")
	private String createdBy;
	
	@Column(name = "CREATED_DATE")
	private Date createdDate;
	
	@Column(name = "MODIFIED_BY")
	private String modifiedBy;
	
	@Column(name = "MODIFIED_DATE")
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
	
	/*
	 * public Lawyer(Long lawyerId, String name, String description) { super();
	 * this.lawyerId = lawyerId; this.name = name; this.description = description; }
	 */
	
	
}
