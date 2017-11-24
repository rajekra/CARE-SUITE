package com.ahp.cas.domains.claims;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

// TODO: Auto-generated Javadoc
/**
 * The Class ClmLnXPaRqst.
 */
public class ClmLnXPaRqst implements Serializable {
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;
	
	/** The clm ln X pa rqst sid. */
	private long clmLnXPaRqstSid;
	
	/** The created by. */
	private BigDecimal createdBy;
	
	/** The created date. */
	private Date createdDate;
	
	/** The modified by. */
	private BigDecimal modifiedBy;
	
	/** The modified date. */
	private Date modifiedDate;
	
	/** The pa rqst identifier. */
	private String paRqstIdentifier;
	
	/** The pa rqst sid. */
	private BigDecimal paRqstSid;
	
	/** The claim line. */
	private ClaimLine claimLine;

	/**
	 * Instantiates a new clm ln X pa rqst.
	 */
	public ClmLnXPaRqst() {
	}

	/**
	 * Gets the clm ln X pa rqst sid.
	 *
	 * @return the clm ln X pa rqst sid
	 */
	public long getClmLnXPaRqstSid() {
		return clmLnXPaRqstSid;
	}

	/**
	 * Sets the clm ln X pa rqst sid.
	 *
	 * @param clmLnXPaRqstSid the new clm ln X pa rqst sid
	 */
	public void setClmLnXPaRqstSid(long clmLnXPaRqstSid) {
		this.clmLnXPaRqstSid = clmLnXPaRqstSid;
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
	 * Gets the pa rqst identifier.
	 *
	 * @return the pa rqst identifier
	 */
	public String getPaRqstIdentifier() {
		return paRqstIdentifier;
	}

	/**
	 * Sets the pa rqst identifier.
	 *
	 * @param paRqstIdentifier the new pa rqst identifier
	 */
	public void setPaRqstIdentifier(String paRqstIdentifier) {
		this.paRqstIdentifier = paRqstIdentifier;
	}

	/**
	 * Gets the pa rqst sid.
	 *
	 * @return the pa rqst sid
	 */
	public BigDecimal getPaRqstSid() {
		return paRqstSid;
	}

	/**
	 * Sets the pa rqst sid.
	 *
	 * @param paRqstSid the new pa rqst sid
	 */
	public void setPaRqstSid(BigDecimal paRqstSid) {
		this.paRqstSid = paRqstSid;
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