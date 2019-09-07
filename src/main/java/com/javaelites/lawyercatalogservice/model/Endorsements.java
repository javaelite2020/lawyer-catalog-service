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
@Table(name="ENDORSEMENTS")
public class Endorsements implements Serializable {

	private static final long serialVersionUID = -4956495193907254117L;

	@Id
	@SequenceGenerator(name="ENDORSEMENT_ID", sequenceName="SEQ_ENDORSEMENT_ID", allocationSize=1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator="ENDORSEMENT_ID")
	@Column(name = "ENDORSEMENT_ID")
	private Long consultationCostId;
	
	@Column(name = "LAWYER_ID")
	private Long lawyerId;
	
	@Column(name = "USER_ID")
	private Long userId;
	
	@Column(name = "RELATIONSHIP")
	private String relationship;
	
	@Column(name = "DESCRIPTION")
	private String description;
	
	@Column(name = "ENDORSEMENT_DATE")
	private Date endorsementDate;
	
	@Column(name = "CREATED_BY")
	private String createdBy;
	
	@Column(name = "CREATED_DATE")
	private Date createdDate;
	
	@Column(name = "MODIFIED_BY")
	private String modifiedBy;
	
	@Column(name = "MODIFIED_DATE")
	private Date modifiedDate;

	public Long getConsultationCostId() {
		return consultationCostId;
	}

	public void setConsultationCostId(Long consultationCostId) {
		this.consultationCostId = consultationCostId;
	}

	public Long getLawyerId() {
		return lawyerId;
	}

	public void setLawyerId(Long lawyerId) {
		this.lawyerId = lawyerId;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getRelationship() {
		return relationship;
	}

	public void setRelationship(String relationship) {
		this.relationship = relationship;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getEndorsementDate() {
		return endorsementDate;
	}

	public void setEndorsementDate(Date endorsementDate) {
		this.endorsementDate = endorsementDate;
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
