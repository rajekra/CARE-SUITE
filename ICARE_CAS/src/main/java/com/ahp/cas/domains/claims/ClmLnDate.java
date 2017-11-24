package com.ahp.cas.domains.claims;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

// TODO: Auto-generated Javadoc
/**
 * The Class ClmLnDate.
 */
public class ClmLnDate implements Serializable {
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;
	
	/** The clm ln date sid. */
	private long clmLnDateSid;
	
	/** The clm date. */
	private Date clmDate;
	
	/** The created by. */
	private BigDecimal createdBy;
	
	/** The created date. */
	private Date createdDate;
	
	/** The date type lkpcd. */
	private String dateTypeLkpcd;
	
	/** The modified by. */
	private BigDecimal modifiedBy;
	
	/** The modified date. */
	private Date modifiedDate;
	
	/** The claim line. */
	private ClaimLine claimLine;

	/**
	 * Instantiates a new clm ln date.
	 */
	public ClmLnDate() {
	}

	/**
	 * Gets the clm ln date sid.
	 *
	 * @return the clm ln date sid
	 */
	public long getClmLnDateSid() {
		return clmLnDateSid;
	}

	/**
	 * Sets the clm ln date sid.
	 *
	 * @param clmLnDateSid the new clm ln date sid
	 */
	public void setClmLnDateSid(long clmLnDateSid) {
		this.clmLnDateSid = clmLnDateSid;
	}

	/**
	 * Gets the clm date.
	 *
	 * @return the clm date
	 */
	public Date getClmDate() {
		return clmDate;
	}

	/**
	 * Sets the clm date.
	 *
	 * @param clmDate the new clm date
	 */
	public void setClmDate(Date clmDate) {
		this.clmDate = clmDate;
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
	 * Gets the date type lkpcd.
	 *
	 * @return the date type lkpcd
	 */
	public String getDateTypeLkpcd() {
		return dateTypeLkpcd;
	}

	/**
	 * Sets the date type lkpcd.
	 *
	 * @param dateTypeLkpcd the new date type lkpcd
	 */
	public void setDateTypeLkpcd(String dateTypeLkpcd) {
		this.dateTypeLkpcd = dateTypeLkpcd;
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