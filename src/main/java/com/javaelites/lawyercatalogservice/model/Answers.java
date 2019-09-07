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
@Table(name="ANSWERS")
public class Answers implements Serializable {

	private static final long serialVersionUID = -1575133492642301583L;

	@Id
	@SequenceGenerator(name="ANSWER_ID", sequenceName="SEQ_ANSWER_ID", allocationSize=1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator="ANSWER_ID")
	@Column(name = "ANSWER_ID")
	private Long consultationCostId;
	
	@Column(name = "LAWYER_ID")
	private Long lawyerId;
	
	@Column(name = "QUESTION_ID")
	private Long questionId;
	
	@Column(name = "USER_ID")
	private Long userId;
	
	@Column(name = "ANSWER")
	private String answer;
	
	@Column(name = "ANSWER_DATE")
	private Date answerDate;
	
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

	public Long getQuestionId() {
		return questionId;
	}

	public void setQuestionId(Long questionId) {
		this.questionId = questionId;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	public Date getAnswerDate() {
		return answerDate;
	}

	public void setAnswerDate(Date answerDate) {
		this.answerDate = answerDate;
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
