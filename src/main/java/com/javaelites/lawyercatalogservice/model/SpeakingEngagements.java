package com.javaelites.lawyercatalogservice.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="SPEAKING_ENGAGEMENTS")
public class SpeakingEngagements implements Serializable {

	private static final long serialVersionUID = -2277592355016807213L;

	@Id
	@SequenceGenerator(name="SPEAKING_ENGAGEMENT_ID", sequenceName="SEQ_SPEAKING_ENGAGEMENT_ID", allocationSize=1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator="SPEAKING_ENGAGEMENT_ID")
	@Column(name = "SPEAKING_ENGAGEMENT_ID")
	private Long speakingEngagementId;
	
	@Column(name = "LAWYER_CODE")
	private String lawyerCode;
	
	@Column(name = "CONFERENCE_NAME")
	private String conferenceName;
	
	@Column(name = "TITLE")
	private String title;
	
	@Column(name = "CONFERENCE_DATE")
	private Date conferenceDate;
	
	@Column(name = "CREATED_BY")
	private String createdBy;
	
	@Column(name = "CREATED_DATE")
	private Date createdDate;
	
	@Column(name = "MODIFIED_BY")
	private String modifiedBy;
	
	@Column(name = "MODIFIED_DATE")
	private Date modifiedDate;

	public Long getSpeakingEngagementId() {
		return speakingEngagementId;
	}

	public void setSpeakingEngagementId(Long speakingEngagementId) {
		this.speakingEngagementId = speakingEngagementId;
	}

	public String getLawyerCode() {
		return lawyerCode;
	}

	public void setLawyerCode(String lawyerCode) {
		this.lawyerCode = lawyerCode;
	}

	public String getConferenceName() {
		return conferenceName;
	}

	public void setConferenceName(String conferenceName) {
		this.conferenceName = conferenceName;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Date getConferenceDate() {
		return conferenceDate;
	}

	public void setConferenceDate(Date conferenceDate) {
		this.conferenceDate = conferenceDate;
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
