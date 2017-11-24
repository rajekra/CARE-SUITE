package com.ahp.cas.domains.claims;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigDecimal;
import java.util.Date;

// TODO: Auto-generated Javadoc
/**
 * The Class ClmHdrXDiagnosisXClmLn.
 */
public class ClmHdrXDiagnosisXClmLn implements Serializable {
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;
	
	/** The diagnosis order sqnc nmbr. */
	@JsonProperty("DiagnosisCodePointerNo")
	private BigDecimal diagnosisOrderSqncNmbr;

	/** The claim line. */
	@JsonBackReference
	private ClaimLine claimLine;

	/** The clm hdr X dgns X clm ln sid. */
	private long clmHdrXDgnsXClmLnSid;

	/** The created by. */
	private BigDecimal createdBy;

	/** The created date. */
	private Date createdDate;

	/**
	 * Gets the clm hdr X dgns X clm ln sid.
	 *
	 * @return the clm hdr X dgns X clm ln sid
	 */
	public long getClmHdrXDgnsXClmLnSid() {
		return clmHdrXDgnsXClmLnSid;
	}

	/**
	 * Sets the clm hdr X dgns X clm ln sid.
	 *
	 * @param clmHdrXDgnsXClmLnSid the new clm hdr X dgns X clm ln sid
	 */
	public void setClmHdrXDgnsXClmLnSid(long clmHdrXDgnsXClmLnSid) {
		this.clmHdrXDgnsXClmLnSid = clmHdrXDgnsXClmLnSid;
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

	/** The modified by. */
	private BigDecimal modifiedBy;

	/** The modified date. */
	private Date modifiedDate;

	/** The primary qlfr. */
	private String primaryQlfr;

	// private ClmHdrXDiagnosis clmHdrXDiagnosis;

	/**
	 * Instantiates a new clm hdr X diagnosis X clm ln.
	 */
	public ClmHdrXDiagnosisXClmLn() {
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
	 * Gets the claim line.
	 *
	 * @return the claim line
	 */
	public ClaimLine getClaimLine() {
		return claimLine;
	}

	/**
	 * Sets the claim line.
	 *
	 * @param claimLine the new claim line
	 */
	public void setClaimLine(ClaimLine claimLine) {
		this.claimLine = claimLine;
	}

	// public ClmHdrXDiagnosis getClmHdrXDiagnosis() {
	// return clmHdrXDiagnosis;
	// }
	//
	// public void setClmHdrXDiagnosis(ClmHdrXDiagnosis clmHdrXDiagnosis) {
	// this.clmHdrXDiagnosis = clmHdrXDiagnosis;
	// }

}