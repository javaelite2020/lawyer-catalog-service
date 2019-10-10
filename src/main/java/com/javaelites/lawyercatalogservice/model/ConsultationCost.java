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
@Table(name="CONSULTATION_COST")
public class ConsultationCost implements Serializable {

	private static final long serialVersionUID = -4906215034176404200L;

	@Id
	@SequenceGenerator(name="CONSULTATION_COST_ID", sequenceName="SEQ_CONSULTATION_COST_ID", allocationSize=1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator="CONSULTATION_COST_ID")
	@Column(name = "CONSULTATION_COST_ID")
	private Long consultationCostId;
	
	@Column(name = "LAWYER_CODE")
	private String lawyerCode;
	
	@Column(name = "HOURLY_RATE")
	private String hourlyRate;
	
	@Column(name = "PAYMENT_METHODS")
	private String paymentMethods;
	
	@Column(name = "FREE_CONSULTATION")
	private String freeConsultation;
	
	@Column(name = "CONTINGENCY_RATE")
	private String contingencyRate;
	
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

	public String getLawyerCode() {
		return lawyerCode;
	}

	public void setLawyerCode(String lawyerCode) {
		this.lawyerCode = lawyerCode;
	}
	
	public String getHourlyRate() {
		return hourlyRate;
	}

	public void setHourlyRate(String hourlyRate) {
		this.hourlyRate = hourlyRate;
	}

	public String getPaymentMethods() {
		return paymentMethods;
	}

	public void setPaymentMethods(String paymentMethods) {
		this.paymentMethods = paymentMethods;
	}

	public String getFreeConsultation() {
		return freeConsultation;
	}

	public void setFreeConsultation(String freeConsultation) {
		this.freeConsultation = freeConsultation;
	}

	public String getContingencyRate() {
		return contingencyRate;
	}

	public void setContingencyRate(String contingencyRate) {
		this.contingencyRate = contingencyRate;
	}

}
