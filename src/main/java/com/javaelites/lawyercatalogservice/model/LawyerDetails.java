package com.javaelites.lawyercatalogservice.model;

import java.io.Serializable;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name="LAWYER_DETAILS")
public class LawyerDetails implements Serializable {

	private static final long serialVersionUID = 6895064310603661403L;

	@Id
	@SequenceGenerator(name="LAWYER_ID", sequenceName="SEQ_LAWYER_ID", allocationSize=1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator="LAWYER_ID")
	@Column(name = "LAWYER_ID")
	private Long lawyerId;
	
	@Column(name = "LAWYER_CODE")
	private String lawyerCode;
	
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

	@Transient
	private List<ConsultationCost> consultationCostList = new ArrayList<ConsultationCost>();
	@Transient
	private List<Awards> awardsList = new ArrayList<Awards>();
	@Transient
	private List<Associations> associationList = new ArrayList<Associations>();
	@Transient
	private List<Documents> documentList = new ArrayList<Documents>();
	@Transient
	private List<Education> educationList = new ArrayList<Education>();
	@Transient
	private List<Endorsements> endorsementList = new ArrayList<Endorsements>();
	@Transient
	private List<LawyerLocation> locationList = new ArrayList<LawyerLocation>();
	@Transient
	private List<PracticeArea> practiceAreaList = new ArrayList<PracticeArea>();
	@Transient
	private List<Publications> publicationList = new ArrayList<Publications>();
	@Transient
	private List<SpeakingEngagements> speakingEngagementList = new ArrayList<SpeakingEngagements>();
	
	public Long getLawyerId() {
		return lawyerId;
	}

	public void setLawyerId(Long lawyerId) {
		this.lawyerId = lawyerId;
	}

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

	public List<ConsultationCost> getConsultationCostList() {
		return consultationCostList;
	}

	public void setConsultationCostList(List<ConsultationCost> consultationCostList) {
		this.consultationCostList = consultationCostList;
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

	public List<LawyerLocation> getLocationList() {
		return locationList;
	}

	public void setLocationList(List<LawyerLocation> locationList) {
		this.locationList = locationList;
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
