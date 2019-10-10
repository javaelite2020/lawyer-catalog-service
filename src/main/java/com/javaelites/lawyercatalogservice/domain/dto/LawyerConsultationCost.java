package com.javaelites.lawyercatalogservice.domain.dto;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonProperty;

public class LawyerConsultationCost {

	@JsonProperty("LAWYER_CONSULTATION_ID")
	public Long consultationCostId;
	
	@JsonProperty("LAWYER_ID")
	public Long lawyerId;
	
	@JsonProperty("HOURLY_RATE")
	public String hourlyRate;
	
	@JsonProperty("PAYMENT_METHODS")
	public String paymentMethods;
	
	@JsonProperty("FREECONSULTATION")
	public String freeConsultation;
	
	@JsonProperty("CONTINGENCY_RATE")
	public String contingencyRate;
	
	@JsonProperty("CREATED_by")
	public String createdBy;
	
	@JsonProperty("CREATED_DATE")
	public Date createdDate;
	
	@JsonProperty("MODIFIED_BY")
	public String modifiedBy;
	
	@JsonProperty("MODIFIED_DATE")
	public Date modifiedDate;
	
	

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
