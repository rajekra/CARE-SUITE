package com.ahp.cas.domains.reference;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;


/**
 * The persistent class for the DIAGNOSIS_DETAIL database table.
 * 
 */
@Entity
@Table(name="DIAGNOSIS_DETAIL")
@NamedQuery(name="DiagnosisDetail.findAll", query="SELECT d FROM DiagnosisDetail d")
public class DiagnosisDetail implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="DIAG_DTL_SID")
	private long diagDtlSid;

	@Column(name="CREATED_BY")
	private BigDecimal createdBy;

	@Temporal(TemporalType.DATE)
	@Column(name="CREATED_DATE")
	private Date createdDate;

	@Column(name="DATA_SOURCE_LKPCD")
	private String dataSourceLkpcd;

	@Column(name="DIAG_LONG_DESC")
	private String diagLongDesc;

	@Column(name="DIAG_SHORT_DESC")
	private String diagShortDesc;

	@Column(name="DIAG_STATE_DESC")
	private String diagStateDesc;

	@Column(name="DIAG_SUBCTGRY_LKPCD")
	private String diagSubctgryLkpcd;

	@Column(name="DIAGNOSIS_IID")
	private BigDecimal diagnosisIid;

	@Column(name="GENDER_LKPCD")
	private String genderLkpcd;

	@Column(name="MODIFIED_BY")
	private BigDecimal modifiedBy;

	@Temporal(TemporalType.DATE)
	@Column(name="MODIFIED_DATE")
	private Date modifiedDate;

	public DiagnosisDetail() {
	}

	public long getDiagDtlSid() {
		return this.diagDtlSid;
	}

	public void setDiagDtlSid(long diagDtlSid) {
		this.diagDtlSid = diagDtlSid;
	}

	public BigDecimal getCreatedBy() {
		return this.createdBy;
	}

	public void setCreatedBy(BigDecimal createdBy) {
		this.createdBy = createdBy;
	}

	public Date getCreatedDate() {
		return this.createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public String getDataSourceLkpcd() {
		return this.dataSourceLkpcd;
	}

	public void setDataSourceLkpcd(String dataSourceLkpcd) {
		this.dataSourceLkpcd = dataSourceLkpcd;
	}

	public String getDiagLongDesc() {
		return this.diagLongDesc;
	}

	public void setDiagLongDesc(String diagLongDesc) {
		this.diagLongDesc = diagLongDesc;
	}

	public String getDiagShortDesc() {
		return this.diagShortDesc;
	}

	public void setDiagShortDesc(String diagShortDesc) {
		this.diagShortDesc = diagShortDesc;
	}

	public String getDiagStateDesc() {
		return this.diagStateDesc;
	}

	public void setDiagStateDesc(String diagStateDesc) {
		this.diagStateDesc = diagStateDesc;
	}

	public String getDiagSubctgryLkpcd() {
		return this.diagSubctgryLkpcd;
	}

	public void setDiagSubctgryLkpcd(String diagSubctgryLkpcd) {
		this.diagSubctgryLkpcd = diagSubctgryLkpcd;
	}

	public BigDecimal getDiagnosisIid() {
		return this.diagnosisIid;
	}

	public void setDiagnosisIid(BigDecimal diagnosisIid) {
		this.diagnosisIid = diagnosisIid;
	}

	public String getGenderLkpcd() {
		return this.genderLkpcd;
	}

	public void setGenderLkpcd(String genderLkpcd) {
		this.genderLkpcd = genderLkpcd;
	}

	public BigDecimal getModifiedBy() {
		return this.modifiedBy;
	}

	public void setModifiedBy(BigDecimal modifiedBy) {
		this.modifiedBy = modifiedBy;
	}

	public Date getModifiedDate() {
		return this.modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		this.modifiedDate = modifiedDate;
	}

}