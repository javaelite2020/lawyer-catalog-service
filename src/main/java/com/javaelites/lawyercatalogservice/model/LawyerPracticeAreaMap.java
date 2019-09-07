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
@Table(name="LAWYER_PRACTICE_AREA_MAP")
public class LawyerPracticeAreaMap implements Serializable {

	private static final long serialVersionUID = -4688300311563680419L;

	@Id
	@SequenceGenerator(name="LAWYER_PRACTICE_AREA_MAP_ID", sequenceName="SEQ_LAWYER_PRACTICE_AREA_MAP_ID", allocationSize=1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator="LAWYER_PRACTICE_AREA_MAP_ID")
	@Column(name = "LAWYER_PRACTICE_AREA_MAP_ID")
	private Long lawyerPracticeAreaMapId;
	
	@Column(name = "LAWYER_ID")
	private Long lawyerId;
	
	@Column(name = "PRACTICE_AREA_ID")
	private Long practiceAreaId;
	
	@Column(name = "ACTIVE")
	private String active;
	
	@Column(name = "PRIMARY_PRACTICE_AREA")
	private String primaryPracticeArea;
	
	@Column(name = "CREATED_BY")
	private String createdBy;
	
	@Column(name = "CREATED_DATE")
	private Date createdDate;
	
	@Column(name = "MODIFIED_BY")
	private String modifiedBy;
	
	@Column(name = "MODIFIED_DATE")
	private Date modifiedDate;

	public Long getLawyerPracticeAreaMapId() {
		return lawyerPracticeAreaMapId;
	}

	public void setLawyerPracticeAreaMapId(Long lawyerPracticeAreaMapId) {
		this.lawyerPracticeAreaMapId = lawyerPracticeAreaMapId;
	}

	public Long getLawyerId() {
		return lawyerId;
	}

	public void setLawyerId(Long lawyerId) {
		this.lawyerId = lawyerId;
	}

	public Long getPracticeAreaId() {
		return practiceAreaId;
	}

	public void setPracticeAreaId(Long practiceAreaId) {
		this.practiceAreaId = practiceAreaId;
	}

	public String getActive() {
		return active;
	}

	public void setActive(String active) {
		this.active = active;
	}

	public String getPrimaryPracticeArea() {
		return primaryPracticeArea;
	}

	public void setPrimaryPracticeArea(String primaryPracticeArea) {
		this.primaryPracticeArea = primaryPracticeArea;
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
