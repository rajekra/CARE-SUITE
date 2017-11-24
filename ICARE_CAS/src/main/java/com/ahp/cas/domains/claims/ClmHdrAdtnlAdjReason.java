package com.ahp.cas.domains.claims;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

// TODO: Auto-generated Javadoc
/**
 * The Class ClmHdrAdtnlAdjReason.
 */
public class ClmHdrAdtnlAdjReason implements Serializable {
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;
	
	/** The clm hdr adtnl adj rsn sid. */
	private long clmHdrAdtnlAdjRsnSid;
	
	/** The clm adjustment reason sid. */
	private BigDecimal clmAdjustmentReasonSid;
	
	/** The created by. */
	private BigDecimal createdBy;
	
	/** The created date. */
	private Date createdDate;
	
	/** The modified by. */
	private BigDecimal modifiedBy;
	
	/** The modified date. */
	private Date modifiedDate;
	
	/** The oprtnl flag. */
	private String oprtnlFlag;
	
	/** The run nmbr. */
	private BigDecimal runNmbr;
	
	/** The claim header. */
	private ClaimHeader claimHeader;

	/**
	 * Instantiates a new clm hdr adtnl adj reason.
	 */
	public ClmHdrAdtnlAdjReason() {
	}

	/**
	 * Gets the clm hdr adtnl adj rsn sid.
	 *
	 * @return the clm hdr adtnl adj rsn sid
	 */
	public long getClmHdrAdtnlAdjRsnSid() {
		return clmHdrAdtnlAdjRsnSid;
	}

	/**
	 * Sets the clm hdr adtnl adj rsn sid.
	 *
	 * @param clmHdrAdtnlAdjRsnSid the new clm hdr adtnl adj rsn sid
	 */
	public void setClmHdrAdtnlAdjRsnSid(long clmHdrAdtnlAdjRsnSid) {
		this.clmHdrAdtnlAdjRsnSid = clmHdrAdtnlAdjRsnSid;
	}

	/**
	 * Gets the clm adjustment reason sid.
	 *
	 * @return the clm adjustment reason sid
	 */
	public BigDecimal getClmAdjustmentReasonSid() {
		return clmAdjustmentReasonSid;
	}

	/**
	 * Sets the clm adjustment reason sid.
	 *
	 * @param clmAdjustmentReasonSid the new clm adjustment reason sid
	 */
	public void setClmAdjustmentReasonSid(BigDecimal clmAdjustmentReasonSid) {
		this.clmAdjustmentReasonSid = clmAdjustmentReasonSid;
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
	 * Gets the oprtnl flag.
	 *
	 * @return the oprtnl flag
	 */
	public String getOprtnlFlag() {
		return oprtnlFlag;
	}

	/**
	 * Sets the oprtnl flag.
	 *
	 * @param oprtnlFlag the new oprtnl flag
	 */
	public void setOprtnlFlag(String oprtnlFlag) {
		this.oprtnlFlag = oprtnlFlag;
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