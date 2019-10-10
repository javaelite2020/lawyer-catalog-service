package com.javaelites.lawyercatalogservice.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="VIEW_LAWYER_RESUME_API_MODEL ")
public class LawyerResumeApiModel implements Serializable {

	private static final long serialVersionUID = -1479159133849421630L;

	@Id
	@Column(name = "ID")
	private Long id;
	
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
	
	@Column(name = "EDUCATION_ID")
	private Long educationId;
	
	@Column(name = "DEGREE")
	private String degree;
	
	@Column(name = "GRADUATED_YEAR")
	private String graduatedYear;
	
	@Column(name = "SCHOOL_NAME")
	private String schoolName;

	@Column(name = "ENDORSEMENT_ID")
	private Long endorsementId;
	
	@Column(name = "ED_DESCRIPTION")
	private String educationDescription;
	
	@Column(name = "ENDORSEMENT_DATE")
	private Date endorsementDate;

	@Column(name = "RELATIONSHIP")
	private String relationship;
	
	@Column(name = "LICENSE_ID")
	private Long licenseId;
	@Column(name = "ACQUIRED_DATE")
	private Date acquiredDate;
	@Column(name = "EXPIRED_DATE")
	private String expiredDate;
	@Column(name = "STATE")
	private String state;
	@Column(name = "STATUS")
	private String status;

	@Column(name = "PUBLICATION_ID")
	private Long publicationId;
	@Column(name = "NAME")
	private String name;
	@Column(name = "PUBLICATION_DATE")
	private String publicationDate;
	@Column(name = "P_TITLE")
	private String publicationTitle;

	@Column(name = "SPEAKING_ENGAGEMENT_ID")
	private Long speakingEngagementId;
	@Column(name = "CONFERENCE_DATE")
	private Date conferenceDate;
	@Column(name = "CONFERENCE_NAME")
	private String conferenceName;
	@Column(name = "SE_TITLE")
	private String seTitle;
	@Column(name = "WORK_EXPERIENCE_ID")
	private Long workExperienceId;
	@Column(name = "DURATION")
	private String duration;
	@Column(name = "WE_TITLE")
	private String weTitle;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
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
	public Long getEducationId() {
		return educationId;
	}
	public void setEducationId(Long educationId) {
		this.educationId = educationId;
	}
	public String getDegree() {
		return degree;
	}
	public void setDegree(String degree) {
		this.degree = degree;
	}
	public String getGraduatedYear() {
		return graduatedYear;
	}
	public void setGraduatedYear(String graduatedYear) {
		this.graduatedYear = graduatedYear;
	}
	public String getSchoolName() {
		return schoolName;
	}
	public void setSchoolName(String schoolName) {
		this.schoolName = schoolName;
	}
	public Long getEndorsementId() {
		return endorsementId;
	}
	public void setEndorsementId(Long endorsementId) {
		this.endorsementId = endorsementId;
	}
	public String getEducationDescription() {
		return educationDescription;
	}
	public void setEducationDescription(String educationDescription) {
		this.educationDescription = educationDescription;
	}
	public Date getEndorsementDate() {
		return endorsementDate;
	}
	public void setEndorsementDate(Date endorsementDate) {
		this.endorsementDate = endorsementDate;
	}
	public String getRelationship() {
		return relationship;
	}
	public void setRelationship(String relationship) {
		this.relationship = relationship;
	}
	public Long getLicenseId() {
		return licenseId;
	}
	public void setLicenseId(Long licenseId) {
		this.licenseId = licenseId;
	}
	public Date getAcquiredDate() {
		return acquiredDate;
	}
	public void setAcquiredDate(Date acquiredDate) {
		this.acquiredDate = acquiredDate;
	}
	public String getExpiredDate() {
		return expiredDate;
	}
	public void setExpiredDate(String expiredDate) {
		this.expiredDate = expiredDate;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Long getPublicationId() {
		return publicationId;
	}
	public void setPublicationId(Long publicationId) {
		this.publicationId = publicationId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPublicationDate() {
		return publicationDate;
	}
	public void setPublicationDate(String publicationDate) {
		this.publicationDate = publicationDate;
	}
	public String getPublicationTitle() {
		return publicationTitle;
	}
	public void setPublicationTitle(String publicationTitle) {
		this.publicationTitle = publicationTitle;
	}
	public Long getSpeakingEngagementId() {
		return speakingEngagementId;
	}
	public void setSpeakingEngagementId(Long speakingEngagementId) {
		this.speakingEngagementId = speakingEngagementId;
	}
	public Date getConferenceDate() {
		return conferenceDate;
	}
	public void setConferenceDate(Date conferenceDate) {
		this.conferenceDate = conferenceDate;
	}
	public String getConferenceName() {
		return conferenceName;
	}
	public void setConferenceName(String conferenceName) {
		this.conferenceName = conferenceName;
	}
	public String getSeTitle() {
		return seTitle;
	}
	public void setSeTitle(String seTitle) {
		this.seTitle = seTitle;
	}
	public Long getWorkExperienceId() {
		return workExperienceId;
	}
	public void setWorkExperienceId(Long workExperienceId) {
		this.workExperienceId = workExperienceId;
	}
	public String getDuration() {
		return duration;
	}
	public void setDuration(String duration) {
		this.duration = duration;
	}
	public String getWeTitle() {
		return weTitle;
	}
	public void setWeTitle(String weTitle) {
		this.weTitle = weTitle;
	}


}
