package com.fb.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Range;

@Entity(name="compl")
@Table(name="COMPLAINT")
public class Complaint {
	
	@Id
	@SequenceGenerator(name="COMP_GEN", sequenceName="COMPLAINT_SEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="COMP_GEN")
	
	@Range(min = 1, max = 999999)
	private int complaintId;
	
	@Range(min = 1, max = 999999)
	private int accountId;
	
	@Range(min = 1, max = 999999)
	private int branchCode;
	
	@NotNull
	@Size(min = 1, max = 100)
	@Pattern(regexp="^([a-zA-Z0-9\\-\\.\\_]+)'+'(\\@)([a-zA-Z0-9\\-\\.]+)'+'(\\.)([a-zA-Z]{2,4})$")
	private String emialId;
	private String category;
	private String description;
	private String priority;
	private String status;

	
	public Complaint() {
		super();
	}

	@Column(name="COMPLAINTID")
	public int getComplaintId() {
		return complaintId;
	}


	public void setComplaintId(int complaintId) {
		this.complaintId = complaintId;
	}

	@Column(name="ACCOUNTID")
	public int getAccountId() {
		return accountId;
	}

	
	public void setAccountId(int accountId) {
		this.accountId = accountId;
	}

	@Column(name="BRANCHCODE")
	public int getBranchCode() {
		return branchCode;
	}


	public void setBranchCode(int branchCode) {
		this.branchCode = branchCode;
	}

	@Column(name="EMAILID")
	public String getEmialId() {
		return emialId;
	}


	public void setEmialId(String emialId) {
		this.emialId = emialId;
	}

	@Column(name="CATEGORY")
	public String getCategory() {
		return category;
	}


	public void setCategory(String category) {
		this.category = category;
	}

	@Column(name="DESCRIPTION")
	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}

	@Column(name="PRIORITY")
	public String getPriority() {
		return priority;
	}


	public void setPriority(String priority) {
		this.priority = priority;
	}

	@Column(name="STATUS")
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Complaint [complaintId=" + complaintId + ", accountId=" + accountId + ", branchCode=" + branchCode
				+ ", emialId=" + emialId + ", category=" + category + ", description=" + description + ", priority="
				+ priority + ", status=" + status + "]";
	}

	public Complaint(int complaintId, int accountId, int branchCode, String emialId, String category,
			String description, String priority, String status) {
		super();
		this.complaintId = complaintId;
		this.accountId = accountId;
		this.branchCode = branchCode;
		this.emialId = emialId;
		this.category = category;
		this.description = description;
		this.priority = priority;
		this.status = status;
	}
}
