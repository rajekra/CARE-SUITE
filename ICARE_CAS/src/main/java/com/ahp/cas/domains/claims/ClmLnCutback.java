package com.ahp.cas.domains.claims;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

// TODO: Auto-generated Javadoc
/**
 * The Class ClmLnCutback.
 */
public class ClmLnCutback implements Serializable {
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;
	
	/** The clm ln cutback sid. */
	private long clmLnCutbackSid;
	
	/** The created by. */
	private BigDecimal createdBy;
	
	/** The created date. */
	private Date createdDate;
	
	/** The cutback qlfr. */
	private String cutbackQlfr;
	
	/** The cutback qlfr sid. */
	private BigDecimal cutbackQlfrSid;
	
	/** The cutback type lkpcd. */
	private String cutbackTypeLkpcd;
	
	/** The cutback value. */
	private BigDecimal cutbackValue;
	
	/** The modified by. */
	private BigDecimal modifiedBy;
	
	/** The modified date. */
	private Date modifiedDate;
	
	/** The claim line. */
	private ClaimLine claimLine;

	/**
	 * Instantiates a new clm ln cutback.
	 */
	public ClmLnCutback() {
	}

	/**
	 * Gets the clm ln cutback sid.
	 *
	 * @return the clm ln cutback sid
	 */
	public long getClmLnCutbackSid() {
		return clmLnCutbackSid;
	}

	/**
	 * Sets the clm ln cutback sid.
	 *
	 * @param clmLnCutbackSid the new clm ln cutback sid
	 */
	public void setClmLnCutbackSid(long clmLnCutbackSid) {
		this.clmLnCutbackSid = clmLnCutbackSid;
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
	 * Gets the cutback qlfr.
	 *
	 * @return the cutback qlfr
	 */
	public String getCutbackQlfr() {
		return cutbackQlfr;
	}

	/**
	 * Sets the cutback qlfr.
	 *
	 * @param cutbackQlfr the new cutback qlfr
	 */
	public void setCutbackQlfr(String cutbackQlfr) {
		this.cutbackQlfr = cutbackQlfr;
	}

	/**
	 * Gets the cutback qlfr sid.
	 *
	 * @return the cutback qlfr sid
	 */
	public BigDecimal getCutbackQlfrSid() {
		return cutbackQlfrSid;
	}

	/**
	 * Sets the cutback qlfr sid.
	 *
	 * @param cutbackQlfrSid the new cutback qlfr sid
	 */
	public void setCutbackQlfrSid(BigDecimal cutbackQlfrSid) {
		this.cutbackQlfrSid = cutbackQlfrSid;
	}

	/**
	 * Gets the cutback type lkpcd.
	 *
	 * @return the cutback type lkpcd
	 */
	public String getCutbackTypeLkpcd() {
		return cutbackTypeLkpcd;
	}

	/**
	 * Sets the cutback type lkpcd.
	 *
	 * @param cutbackTypeLkpcd the new cutback type lkpcd
	 */
	public void setCutbackTypeLkpcd(String cutbackTypeLkpcd) {
		this.cutbackTypeLkpcd = cutbackTypeLkpcd;
	}

	/**
	 * Gets the cutback value.
	 *
	 * @return the cutback value
	 */
	public BigDecimal getCutbackValue() {
		return cutbackValue;
	}

	/**
	 * Sets the cutback value.
	 *
	 * @param cutbackValue the new cutback value
	 */
	public void setCutbackValue(BigDecimal cutbackValue) {
		this.cutbackValue = cutbackValue;
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