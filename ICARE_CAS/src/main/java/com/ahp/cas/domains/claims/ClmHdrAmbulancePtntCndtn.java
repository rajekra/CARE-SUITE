package com.ahp.cas.domains.claims;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

// TODO: Auto-generated Javadoc
/**
 * The Class ClmHdrAmbulancePtntCndtn.
 */
public class ClmHdrAmbulancePtntCndtn implements Serializable {
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;
	
	/** The clm hdr amblnc ptnt cndtn sid. */
	private long clmHdrAmblncPtntCndtnSid;
	
	/** The clm hdr amblnc dtl sid. */
	private BigDecimal clmHdrAmblncDtlSid;
	
	/** The condition indicator lkpcd. */
	private String conditionIndicatorLkpcd;
	
	/** The created by. */
	private BigDecimal createdBy;
	
	/** The created date. */
	private Date createdDate;
	
	/** The modified by. */
	private BigDecimal modifiedBy;
	
	/** The modified date. */
	private Date modifiedDate;
	
	/** The claim header. */
	private ClaimHeader claimHeader;

	/**
	 * Instantiates a new clm hdr ambulance ptnt cndtn.
	 */
	public ClmHdrAmbulancePtntCndtn() {
	}

	/**
	 * Gets the clm hdr amblnc ptnt cndtn sid.
	 *
	 * @return the clm hdr amblnc ptnt cndtn sid
	 */
	public long getClmHdrAmblncPtntCndtnSid() {
		return clmHdrAmblncPtntCndtnSid;
	}

	/**
	 * Sets the clm hdr amblnc ptnt cndtn sid.
	 *
	 * @param clmHdrAmblncPtntCndtnSid the new clm hdr amblnc ptnt cndtn sid
	 */
	public void setClmHdrAmblncPtntCndtnSid(long clmHdrAmblncPtntCndtnSid) {
		this.clmHdrAmblncPtntCndtnSid = clmHdrAmblncPtntCndtnSid;
	}

	/**
	 * Gets the clm hdr amblnc dtl sid.
	 *
	 * @return the clm hdr amblnc dtl sid
	 */
	public BigDecimal getClmHdrAmblncDtlSid() {
		return clmHdrAmblncDtlSid;
	}

	/**
	 * Sets the clm hdr amblnc dtl sid.
	 *
	 * @param clmHdrAmblncDtlSid the new clm hdr amblnc dtl sid
	 */
	public void setClmHdrAmblncDtlSid(BigDecimal clmHdrAmblncDtlSid) {
		this.clmHdrAmblncDtlSid = clmHdrAmblncDtlSid;
	}

	/**
	 * Gets the condition indicator lkpcd.
	 *
	 * @return the condition indicator lkpcd
	 */
	public String getConditionIndicatorLkpcd() {
		return conditionIndicatorLkpcd;
	}

	/**
	 * Sets the condition indicator lkpcd.
	 *
	 * @param conditionIndicatorLkpcd the new condition indicator lkpcd
	 */
	public void setConditionIndicatorLkpcd(String conditionIndicatorLkpcd) {
		this.conditionIndicatorLkpcd = conditionIndicatorLkpcd;
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