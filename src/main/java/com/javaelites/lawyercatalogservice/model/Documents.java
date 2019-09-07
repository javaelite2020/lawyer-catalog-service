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
@Table(name="DOCUMENTS")
public class Documents implements Serializable {

	private static final long serialVersionUID = 5992479810901472619L;

	@Id
	@SequenceGenerator(name="DOCUMENT_ID", sequenceName="SEQ_DOCUMENT_ID", allocationSize=1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator="DOCUMENT_ID")
	@Column(name = "DOCUMENT_ID")
	private Long consultationCostId;
	
	@Column(name = "DOCUMENT_TYPE_ID")
	private Long documentTypeId;
	
	@Column(name = "LAWYER_ID")
	private Long lawyerId;
	
	@Column(name = "USER_ID")
	private Long userId;
	
	@Column(name = "DOCUMENT_NAME")
	private String documentName;
	
	@Column(name = "DESCRIPTION")
	private String description;
	
	@Column(name = "DOWNLOAD_LINK")
	private String downloadLink;
	
	@Column(name = "DOCUMENT_DATE")
	private Date documentDate;
	
	@Column(name = "CREATED_BY")
	private String createdBy;
	
	@Column(name = "CREATED_DATE")
	private Date createdDate;
	
	@Column(name = "MODIFIED_BY")
	private String modifiedBy;
	
	@Column(name = "MODIFIED_DATE")
	private Date modifiedDate;
	
	
	
}
