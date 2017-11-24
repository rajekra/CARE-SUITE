package com.ahp.cas.domains.claims;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonProperty;

// TODO: Auto-generated Javadoc
/**
 * The Class ClmHdrXDiagnosis.
 */
public class ClmHdrXDiagnosis implements Serializable {
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;
	
	/** The diag qlfr. */
	@JsonProperty("DiagnosisCodeQualifier")
	private String diagQlfr;

	/** The diagnosis code. */
	@JsonProperty("DiagnosisCode")
	private String diagnosisCode;

	/** The diagnosis order sqnc nmbr. */
	@JsonProperty("DiagnosisSequenceNo")
	private BigDecimal diagnosisOrderSqncNmbr;

	/** The poa lkpcd. */
	@JsonProperty("PresentOnAdmissionIndicator")
	private String poaLkpcd;

	/** The primary qlfr. */
	@JsonProperty("DiagnosisOrdinalCode")
	private String primaryQlfr;

	/** The diagnosis iid. */
	private BigDecimal diagnosisIid;

	/** The modified by. */
	private BigDecimal modifiedBy;

	/** The modified date. */
	private Date modifiedDate;

	/** The clm hdr X diagnosis sid. */
	private long clmHdrXDiagnosisSid;

	/** The created by. */
	private BigDecimal createdBy;

	/** The created date. */
	private Date createdDate;

	/** The claim header. */
	@JsonBackReference
	private ClaimHeader claimHeader;

	// private Set<ClmHdrXDiagnosisXClmLn> clmHdrXDiagnosisXClmLns;

	/**
	 * Instantiates a new clm hdr X diagnosis.
	 */
	public ClmHdrXDiagnosis() {
	}

	/**
	 * Gets the diagnosis code.
	 *
	 * @return the diagnosis code
	 */
	public String getDiagnosisCode() {
		return diagnosisCode;
	}

	/**
	 * Sets the diagnosis code.
	 *
	 * @param diagnosisCode the new diagnosis code
	 */
	public void setDiagnosisCode(String diagnosisCode) {
		this.diagnosisCode = diagnosisCode;
	}

	/**
	 * Gets the diagnosis order sqnc nmbr.
	 *
	 * @return the diagnosis order sqnc nmbr
	 */
	public BigDecimal getDiagnosisOrderSqncNmbr() {
		return diagnosisOrderSqncNmbr;
	}

	/**
	 * Sets the diagnosis order sqnc nmbr.
	 *
	 * @param diagnosisOrderSqncNmbr the new diagnosis order sqnc nmbr
	 */
	public void setDiagnosisOrderSqncNmbr(BigDecimal diagnosisOrderSqncNmbr) {
		this.diagnosisOrderSqncNmbr = diagnosisOrderSqncNmbr;
	}

	/**
	 * Gets the poa lkpcd.
	 *
	 * @return the poa lkpcd
	 */
	public String getPoaLkpcd() {
		return poaLkpcd;
	}

	/**
	 * Sets the poa lkpcd.
	 *
	 * @param poaLkpcd the new poa lkpcd
	 */
	public void setPoaLkpcd(String poaLkpcd) {
		this.poaLkpcd = poaLkpcd;
	}

	/**
	 * Gets the primary qlfr.
	 *
	 * @return the primary qlfr
	 */
	public String getPrimaryQlfr() {
		return primaryQlfr;
	}

	/**
	 * Sets the primary qlfr.
	 *
	 * @param primaryQlfr the new primary qlfr
	 */
	public void setPrimaryQlfr(String primaryQlfr) {
		this.primaryQlfr = primaryQlfr;
	}

	/**
	 * Gets the claim header.
	 *
	 * @return the claim header
	 */
	public ClaimHeader getClaimHeader() {
		return claimHeader;
	}

	/**
	 * Sets the claim header.
	 *
	 * @param claimHeader the new claim header
	 */
	public void setClaimHeader(ClaimHeader claimHeader) {
		this.claimHeader = claimHeader;
	}

	// public Set<ClmHdrXDiagnosisXClmLn> getClmHdrXDiagnosisXClmLns() {
	// return clmHdrXDiagnosisXClmLns;
	// }
	//
	// public void setClmHdrXDiagnosisXClmLns(
	// Set<ClmHdrXDiagnosisXClmLn> clmHdrXDiagnosisXClmLns) {
	// this.clmHdrXDiagnosisXClmLns = clmHdrXDiagnosisXClmLns;
	// }

	/**
	 * Gets the diag qlfr.
	 *
	 * @return the diag qlfr
	 */
	public String getDiagQlfr() {
		return this.diagQlfr;
	}

	/**
	 * Sets the diag qlfr.
	 *
	 * @param diagQlfr the new diag qlfr
	 */
	public void setDiagQlfr(String diagQlfr) {
		this.diagQlfr = diagQlfr;
	}

	/**
	 * Gets the diagnosis iid.
	 *
	 * @return the diagnosis iid
	 */
	public BigDecimal getDiagnosisIid() {
		return diagnosisIid;
	}

	/**
	 * Sets the diagnosis iid.
	 *
	 * @param diagnosisIid the new diagnosis iid
	 */
	public void setDiagnosisIid(BigDecimal diagnosisIid) {
		this.diagnosisIid = diagnosisIid;
	}

	/**
	 * Gets the modified by.
	 *
	 * @return the modified by
	 */
	public BigDecimal getModifiedBy() {
		return modifiedBy;
	}

	/**
	 * Sets the modified by.
	 *
	 * @param modifiedBy the new modified by
	 */
	public void setModifiedBy(BigDecimal modifiedBy) {
		this.modifiedBy = modifiedBy;
	}

	/**
	 * Gets the modified date.
	 *
	 * @return the modified date
	 */
	public Date getModifiedDate() {
		return modifiedDate;
	}

	/**
	 * Sets the modified date.
	 *
	 * @param modifiedDate the new modified date
	 */
	public void setModifiedDate(Date modifiedDate) {
		this.modifiedDate = modifiedDate;
	}

	/**
	 * Gets the clm hdr X diagnosis sid.
	 *
	 * @return the clm hdr X diagnosis sid
	 */
	public long getClmHdrXDiagnosisSid() {
		return clmHdrXDiagnosisSid;
	}

	/**
	 * Sets the clm hdr X diagnosis sid.
	 *
	 * @param clmHdrXDiagnosisSid the new clm hdr X diagnosis sid
	 */
	public void setClmHdrXDiagnosisSid(long clmHdrXDiagnosisSid) {
		this.clmHdrXDiagnosisSid = clmHdrXDiagnosisSid;
	}

	/**
	 * Gets the created by.
	 *
	 * @return the created by
	 */
	public BigDecimal getCreatedBy() {
		return createdBy;
	}

	/**
	 * Sets the created by.
	 *
	 * @param createdBy the new created by
	 */
	public void setCreatedBy(BigDecimal createdBy) {
		this.createdBy = createdBy;
	}

	/**
	 * Gets the created date.
	 *
	 * @return the created date
	 */
	public Date getCreatedDate() {
		return createdDate;
	}

	/**
	 * Sets the created date.
	 *
	 * @param createdDate the new created date
	 */
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

}