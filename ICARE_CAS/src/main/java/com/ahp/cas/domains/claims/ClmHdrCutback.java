package com.ahp.cas.domains.claims;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

// TODO: Auto-generated Javadoc
/**
 * The Class ClmHdrCutback.
 */
public class ClmHdrCutback implements Serializable {
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;
	
	/** The clm hdr cutback sid. */
	private long clmHdrCutbackSid;
	
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
	
	/** The claim header. */
	private ClaimHeader claimHeader;

	/**
	 * Instantiates a new clm hdr cutback.
	 */
	public ClmHdrCutback() {
	}

	/**
	 * Gets the clm hdr cutback sid.
	 *
	 * @return the clm hdr cutback sid
	 */
	public long getClmHdrCutbackSid() {
		return clmHdrCutbackSid;
	}

	/**
	 * Sets the clm hdr cutback sid.
	 *
	 * @param clmHdrCutbackSid the new clm hdr cutback sid
	 */
	public void setClmHdrCutbackSid(long clmHdrCutbackSid) {
		this.clmHdrCutbackSid = clmHdrCutbackSid;
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