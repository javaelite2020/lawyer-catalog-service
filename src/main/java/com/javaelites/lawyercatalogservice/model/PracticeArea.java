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
@Table(name="PRACTICE_AREA")
public class PracticeArea implements Serializable {

	private static final long serialVersionUID = -8475677856231655322L;

	@Id
	@SequenceGenerator(name="PRACTICE_AREA_ID", sequenceName="SEQ_PRACTICE_AREA_ID", allocationSize=1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator="PRACTICE_AREA_ID")
	@Column(name = "PRACTICE_AREA_ID")
	private Long practiceAreaId;
	
	@Column(name = "PRACTICE_AREA_CATEGORY")
	private String practiceAreaCategory;
	
	@Column(name = "PRACTICE_AREA_SUB_CATEGORY")
	private String practiceAreaSubCategory;
	
	@Column(name = "CREATED_BY")
	private String createdBy;
	
	@Column(name = "CREATED_DATE")
	private Date createdDate;
	
	@Column(name = "MODIFIED_BY")
	private String modifiedBy;
	
	@Column(name = "MODIFIED_DATE")
	private Date modifiedDate;

	public Long getPracticeAreaId() {
		return practiceAreaId;
	}

	public void setPracticeAreaId(Long practiceAreaId) {
		this.practiceAreaId = practiceAreaId;
	}

	public String getPracticeAreaCategory() {
		return practiceAreaCategory;
	}

	public void setPracticeAreaCategory(String practiceAreaCategory) {
		this.practiceAreaCategory = practiceAreaCategory;
	}

	public String getPracticeAreaSubCategory() {
		return practiceAreaSubCategory;
	}

	public void setPracticeAreaSubCategory(String practiceAreaSubCategory) {
		this.practiceAreaSubCategory = practiceAreaSubCategory;
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
