package com.ahp.cas.domains.claims;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

// TODO: Auto-generated Javadoc
/**
 * The Class ClmLnConflict.
 */
public class ClmLnConflict implements Serializable {
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;
	
	/** The clm ln conflict sid. */
	private long clmLnConflictSid;
	
	/** The clm error sid. */
	private BigDecimal clmErrorSid;
	
	/** The conflict claim line sid. */
	private BigDecimal conflictClaimLineSid;
	
	/** The conflict type lkpcd. */
	private String conflictTypeLkpcd;
	
	/** The conflict type value. */
	private String conflictTypeValue;
	
	/** The created by. */
	private BigDecimal createdBy;
	
	/** The created date. */
	private Date createdDate;
	
	/** The modified by. */
	private BigDecimal modifiedBy;
	
	/** The modified date. */
	private Date modifiedDate;
	
	/** The run nmbr. */
	private BigDecimal runNmbr;
	
	/** The claim line. */
	private ClaimLine claimLine;

	/**
	 * Instantiates a new clm ln conflict.
	 */
	public ClmLnConflict() {
	}

	/**
	 * Gets the clm ln conflict sid.
	 *
	 * @return the clm ln conflict sid
	 */
	public long getClmLnConflictSid() {
		return clmLnConflictSid;
	}

	/**
	 * Sets the clm ln conflict sid.
	 *
	 * @param clmLnConflictSid the new clm ln conflict sid
	 */
	public void setClmLnConflictSid(long clmLnConflictSid) {
		this.clmLnConflictSid = clmLnConflictSid;
	}

	/**
	 * Gets the clm error sid.
	 *
	 * @return the clm error sid
	 */
	public BigDecimal getClmErrorSid() {
		return clmErrorSid;
	}

	/**
	 * Sets the clm error sid.
	 *
	 * @param clmErrorSid the new clm error sid
	 */
	public void setClmErrorSid(BigDecimal clmErrorSid) {
		this.clmErrorSid = clmErrorSid;
	}

	/**
	 * Gets the conflict claim line sid.
	 *
	 * @return the conflict claim line sid
	 */
	public BigDecimal getConflictClaimLineSid() {
		return conflictClaimLineSid;
	}

	/**
	 * Sets the conflict claim line sid.
	 *
	 * @param conflictClaimLineSid the new conflict claim line sid
	 */
	public void setConflictClaimLineSid(BigDecimal conflictClaimLineSid) {
		this.conflictClaimLineSid = conflictClaimLineSid;
	}

	/**
	 * Gets the conflict type lkpcd.
	 *
	 * @return the conflict type lkpcd
	 */
	public String getConflictTypeLkpcd() {
		return conflictTypeLkpcd;
	}

	/**
	 * Sets the conflict type lkpcd.
	 *
	 * @param conflictTypeLkpcd the new conflict type lkpcd
	 */
	public void setConflictTypeLkpcd(String conflictTypeLkpcd) {
		this.conflictTypeLkpcd = conflictTypeLkpcd;
	}

	/**
	 * Gets the conflict type value.
	 *
	 * @return the conflict type value
	 */
	public String getConflictTypeValue() {
		return conflictTypeValue;
	}

	/**
	 * Sets the conflict type value.
	 *
	 * @param conflictTypeValue the new conflict type value
	 */
	public void setConflictTypeValue(String conflictTypeValue) {
		this.conflictTypeValue = conflictTypeValue;
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
	 * Gets the run nmbr.
	 *
	 * @return the run nmbr
	 */
	public BigDecimal getRunNmbr() {
		return runNmbr;
	}

	/**
	 * Sets the run nmbr.
	 *
	 * @param runNmbr the new run nmbr
	 */
	public void setRunNmbr(BigDecimal runNmbr) {
		this.runNmbr = runNmbr;
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

}