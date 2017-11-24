package com.ahp.cas.domains.claims;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

// TODO: Auto-generated Javadoc
/**
 * The Class ClmLnCopayAmount.
 */
public class ClmLnCopayAmount implements Serializable {
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;
	
	/** The clm ln copay amount sid. */
	private long clmLnCopayAmountSid;
	
	/** The amount type lkpcd. */
	private String amountTypeLkpcd;
	
	/** The amount value. */
	private BigDecimal amountValue;
	
	/** The copay date. */
	private Date copayDate;
	
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
	
	/** The claim line. */
	private ClaimLine claimLine;

	/**
	 * Instantiates a new clm ln copay amount.
	 */
	public ClmLnCopayAmount() {
	}

	/**
	 * Gets the clm ln copay amount sid.
	 *
	 * @return the clm ln copay amount sid
	 */
	public long getClmLnCopayAmountSid() {
		return clmLnCopayAmountSid;
	}

	/**
	 * Sets the clm ln copay amount sid.
	 *
	 * @param clmLnCopayAmountSid the new clm ln copay amount sid
	 */
	public void setClmLnCopayAmountSid(long clmLnCopayAmountSid) {
		this.clmLnCopayAmountSid = clmLnCopayAmountSid;
	}

	/**
	 * Gets the amount type lkpcd.
	 *
	 * @return the amount type lkpcd
	 */
	public String getAmountTypeLkpcd() {
		return amountTypeLkpcd;
	}

	/**
	 * Sets the amount type lkpcd.
	 *
	 * @param amountTypeLkpcd the new amount type lkpcd
	 */
	public void setAmountTypeLkpcd(String amountTypeLkpcd) {
		this.amountTypeLkpcd = amountTypeLkpcd;
	}

	/**
	 * Gets the amount value.
	 *
	 * @return the amount value
	 */
	public BigDecimal getAmountValue() {
		return amountValue;
	}

	/**
	 * Sets the amount value.
	 *
	 * @param amountValue the new amount value
	 */
	public void setAmountValue(BigDecimal amountValue) {
		this.amountValue = amountValue;
	}

	/**
	 * Gets the copay date.
	 *
	 * @return the copay date
	 */
	public Date getCopayDate() {
		return copayDate;
	}

	/**
	 * Sets the copay date.
	 *
	 * @param copayDate the new copay date
	 */
	public void setCopayDate(Date copayDate) {
		this.copayDate = copayDate;
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