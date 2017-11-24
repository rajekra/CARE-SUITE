package com.ahp.cas.domains.claims;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

// TODO: Auto-generated Javadoc
/**
 * The Class ClmHdrConflict.
 */
public class ClmHdrConflict implements Serializable {
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;
	
	/** The clm hdr conflict sid. */
	private long clmHdrConflictSid;
	
	/** The clm error sid. */
	private BigDecimal clmErrorSid;
	
	/** The conflict claim header sid. */
	private BigDecimal conflictClaimHeaderSid;
	
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
	
	/** The claim header. */
	private ClaimHeader claimHeader;

	/**
	 * Instantiates a new clm hdr conflict.
	 */
	public ClmHdrConflict() {
	}

	/**
	 * Gets the clm hdr conflict sid.
	 *
	 * @return the clm hdr conflict sid
	 */
	public long getClmHdrConflictSid() {
		return clmHdrConflictSid;
	}

	/**
	 * Sets the clm hdr conflict sid.
	 *
	 * @param clmHdrConflictSid the new clm hdr conflict sid
	 */
	public void setClmHdrConflictSid(long clmHdrConflictSid) {
		this.clmHdrConflictSid = clmHdrConflictSid;
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
	 * Gets the conflict claim header sid.
	 *
	 * @return the conflict claim header sid
	 */
	public BigDecimal getConflictClaimHeaderSid() {
		return conflictClaimHeaderSid;
	}

	/**
	 * Sets the conflict claim header sid.
	 *
	 * @param conflictClaimHeaderSid the new conflict claim header sid
	 */
	public void setConflictClaimHeaderSid(BigDecimal conflictClaimHeaderSid) {
		this.conflictClaimHeaderSid = conflictClaimHeaderSid;
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

}