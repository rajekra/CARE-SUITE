package com.ahp.cas.domains.reference;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;


/**
 * The persistent class for the DIAGNOSIS database table.
 * 
 */
@Entity
@NamedQuery(name="Diagnosis.findAll", query="SELECT d FROM Diagnosis d")
public class Diagnosis implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	//@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="DIAGNOSIS_IID")
	private long diagnosisIid;

	@Column(name="CREATED_BY")
	private BigDecimal createdBy;

	@Temporal(TemporalType.DATE)
	@Column(name="CREATED_DATE")
	private Date createdDate;

	@Column(name="DATA_SOURCE_LKPCD")
	private String dataSourceLkpcd;

	@Column(name="DIAG_CTGRY_LKPCD")
	private String diagCtgryLkpcd;

	@Column(name="DIAG_SHORT_DESC")
	private String diagShortDesc;

	@Column(name="DIAGNOSIS_CODE")
	private String diagnosisCode;

	@Column(name="ICD9_FORMAT_DIAGNOSIS_CODE")
	private String icd9FormatDiagnosisCode;

	@Column(name="MODIFIED_BY")
	private BigDecimal modifiedBy;

	@Temporal(TemporalType.DATE)
	@Column(name="MODIFIED_DATE")
	private Date modifiedDate;

	public Diagnosis() {
	}

	public long getDiagnosisIid() {
		return this.diagnosisIid;
	}

	public void setDiagnosisIid(long diagnosisIid) {
		this.diagnosisIid = diagnosisIid;
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

	public String getDiagCtgryLkpcd() {
		return this.diagCtgryLkpcd;
	}

	public void setDiagCtgryLkpcd(String diagCtgryLkpcd) {
		this.diagCtgryLkpcd = diagCtgryLkpcd;
	}

	public String getDiagShortDesc() {
		return this.diagShortDesc;
	}

	public void setDiagShortDesc(String diagShortDesc) {
		this.diagShortDesc = diagShortDesc;
	}

	public String getDiagnosisCode() {
		return this.diagnosisCode;
	}

	public void setDiagnosisCode(String diagnosisCode) {
		this.diagnosisCode = diagnosisCode;
	}

	public String getIcd9FormatDiagnosisCode() {
		return this.icd9FormatDiagnosisCode;
	}

	public void setIcd9FormatDiagnosisCode(String icd9FormatDiagnosisCode) {
		this.icd9FormatDiagnosisCode = icd9FormatDiagnosisCode;
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