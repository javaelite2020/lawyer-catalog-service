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
@Table(name="LAWYER_RATINGS")
public class LawyerRatings implements Serializable {

	private static final long serialVersionUID = -3800495631051521783L;

	@Id
	@SequenceGenerator(name="LAWYER_RATING_ID", sequenceName="SEQ_LAWYER_RATING_ID", allocationSize=1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator="LAWYER_RATING_ID")
	@Column(name = "LAWYER_RATING_ID")
	private Long lawyerRatingId;
	
	@Column(name = "LAWYER_ID")
	private Long lawyerId;
	
	@Column(name = "USER_ID")
	private Long userId;
	
	@Column(name = "COMMENT")
	private String comment;
	
	@Column(name = "COMMENT_DESCRIPTION")
	private String commentDescription;
	
	@Column(name = "PUBLISHED_DATE")
	private Date publishedDate;
	
	@Column(name = "CREATED_BY")
	private String createdBy;
	
	@Column(name = "CREATED_DATE")
	private Date createdDate;
	
	@Column(name = "MODIFIED_BY")
	private String modifiedBy;
	
	@Column(name = "MODIFIED_DATE")
	private Date modifiedDate;

	public Long getLawyerRatingId() {
		return lawyerRatingId;
	}

	public void setLawyerRatingId(Long lawyerRatingId) {
		this.lawyerRatingId = lawyerRatingId;
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

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public String getCommentDescription() {
		return commentDescription;
	}

	public void setCommentDescription(String commentDescription) {
		this.commentDescription = commentDescription;
	}

	public Date getPublishedDate() {
		return publishedDate;
	}

	public void setPublishedDate(Date publishedDate) {
		this.publishedDate = publishedDate;
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
