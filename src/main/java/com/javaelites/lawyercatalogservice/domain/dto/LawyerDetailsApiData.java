package com.javaelites.lawyercatalogservice.domain.dto;

import java.sql.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.javaelites.lawyercatalogservice.model.Associations;
import com.javaelites.lawyercatalogservice.model.Awards;
import com.javaelites.lawyercatalogservice.model.Documents;
import com.javaelites.lawyercatalogservice.model.Education;
import com.javaelites.lawyercatalogservice.model.Endorsements;
import com.javaelites.lawyercatalogservice.model.LawyerLocation;
import com.javaelites.lawyercatalogservice.model.PracticeArea;
import com.javaelites.lawyercatalogservice.model.Publications;
import com.javaelites.lawyercatalogservice.model.SpeakingEngagements;

public class LawyerDetailsApiData {

	@JsonProperty("lawyer_id")
	private Long lawyerId;
	
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
	
	@JsonProperty("awards")
	private List<Awards> awardsList;
	@JsonProperty("associations")
	private List<Associations> associationList;
	@JsonProperty("documents")
	private List<Documents> documentList;
	@JsonProperty("education")
	private List<Education> educationList;
	@JsonProperty("endorsements")
	private List<Endorsements> endorsementList;
	@JsonProperty("practice_areas")
	private List<PracticeArea> practiceAreaList;
	@JsonProperty("publications")
	private List<Publications> publicationList;
	@JsonProperty("speaking_engagments")
	private List<SpeakingEngagements> speakingEngagementList;

	@JsonProperty("locations")
	private List<LawyerLocation> lawyerLocation;

	@JsonProperty("consultation_cost")
	private List<LawyerConsultationCost> lawyerConsultationCost;

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

	public List<LawyerLocation> getLawyerLocation() {
		return lawyerLocation;
	}

	public void setLawyerLocation(List<LawyerLocation> lawyerLocation) {
		this.lawyerLocation = lawyerLocation;
	}

	public List<LawyerConsultationCost> getLawyerConsultationCost() {
		return lawyerConsultationCost;
	}

	public void setLawyerConsultationCost(List<LawyerConsultationCost> lawyerConsultationCost) {
		this.lawyerConsultationCost = lawyerConsultationCost;
	}

	public List<Awards> getAwardsList() {
		return awardsList;
	}

	public void setAwardsList(List<Awards> awardsList) {
		this.awardsList = awardsList;
	}

	public List<Associations> getAssociationList() {
		return associationList;
	}

	public void setAssociationList(List<Associations> associationList) {
		this.associationList = associationList;
	}

	public List<Documents> getDocumentList() {
		return documentList;
	}

	public void setDocumentList(List<Documents> documentList) {
		this.documentList = documentList;
	}

	public List<Education> getEducationList() {
		return educationList;
	}

	public void setEducationList(List<Education> educationList) {
		this.educationList = educationList;
	}

	public List<Endorsements> getEndorsementList() {
		return endorsementList;
	}

	public void setEndorsementList(List<Endorsements> endorsementList) {
		this.endorsementList = endorsementList;
	}

	public List<PracticeArea> getPracticeAreaList() {
		return practiceAreaList;
	}

	public void setPracticeAreaList(List<PracticeArea> practiceAreaList) {
		this.practiceAreaList = practiceAreaList;
	}

	public List<Publications> getPublicationList() {
		return publicationList;
	}

	public void setPublicationList(List<Publications> publicationList) {
		this.publicationList = publicationList;
	}

	public List<SpeakingEngagements> getSpeakingEngagementList() {
		return speakingEngagementList;
	}

	public void setSpeakingEngagementList(List<SpeakingEngagements> speakingEngagementList) {
		this.speakingEngagementList = speakingEngagementList;
	}
	
	
	/*
	 * public Lawyer(Long lawyerId, String name, String description) { super();
	 * this.lawyerId = lawyerId; this.name = name; this.description = description; }
	 */
	
	
}
