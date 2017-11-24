package com.ahp.cas.domains.claims;

import java.math.BigDecimal;
import java.util.Date;

public class Diagnosis {
	private long diagnosisIid;
	private BigDecimal createdBy;

	private Date createdDate;


	public long getDiagnosisIid() {
		return diagnosisIid;
	}

	public void setDiagnosisIid(long diagnosisIid) {
		this.diagnosisIid = diagnosisIid;
	}

	public BigDecimal getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(BigDecimal createdBy) {
		this.createdBy = createdBy;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public String getDiagCtgryLkpcd() {
		return diagCtgryLkpcd;
	}

	public void setDiagCtgryLkpcd(String diagCtgryLkpcd) {
		this.diagCtgryLkpcd = diagCtgryLkpcd;
	}

	public String getDiagShortDesc() {
		return diagShortDesc;
	}

	public void setDiagShortDesc(String diagShortDesc) {
		this.diagShortDesc = diagShortDesc;
	}

	public String getDiagnosisCode() {
		return diagnosisCode;
	}

	public void setDiagnosisCode(String diagnosisCode) {
		this.diagnosisCode = diagnosisCode;
	}

	public String getIcd9FormatDiagnosisCode() {
		return icd9FormatDiagnosisCode;
	}

	public void setIcd9FormatDiagnosisCode(String icd9FormatDiagnosisCode) {
		this.icd9FormatDiagnosisCode = icd9FormatDiagnosisCode;
	}

	public BigDecimal getModifiedBy() {
		return modifiedBy;
	}

	public void setModifiedBy(BigDecimal modifiedBy) {
		this.modifiedBy = modifiedBy;
	}

	public Date getModifiedDate() {
		return modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		this.modifiedDate = modifiedDate;
	}

	private String diagCtgryLkpcd;

	private String diagShortDesc;

	private String diagnosisCode;

	private String icd9FormatDiagnosisCode;

	private BigDecimal modifiedBy;

	private Date modifiedDate;
}
