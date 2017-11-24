package com.ahp.cas.domains.claims;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

// TODO: Auto-generated Javadoc
/**
 * The Class ClmLnAdtnlAdjReason.
 */
public class ClmLnAdtnlAdjReason implements Serializable {
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;
	
	/** The clm ln adtnl adj rsn sid. */
	private long clmLnAdtnlAdjRsnSid;
	
	/** The clm adjustment reason sid. */
	private BigDecimal clmAdjustmentReasonSid;

	/**
	 * Gets the clm ln adtnl adj rsn sid.
	 *
	 * @return the clm ln adtnl adj rsn sid
	 */
	public long getClmLnAdtnlAdjRsnSid() {
		return clmLnAdtnlAdjRsnSid;
	}

	/**
	 * Sets the clm ln adtnl adj rsn sid.
	 *
	 * @param clmLnAdtnlAdjRsnSid the new clm ln adtnl adj rsn sid
	 */
	public void setClmLnAdtnlAdjRsnSid(long clmLnAdtnlAdjRsnSid) {
		this.clmLnAdtnlAdjRsnSid = clmLnAdtnlAdjRsnSid;
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
	
	/** The claim line. */
	private ClaimLine claimLine;

	/**
	 * Instantiates a new clm ln adtnl adj reason.
	 */
	public ClmLnAdtnlAdjReason() {
	}

}