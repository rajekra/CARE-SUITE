package com.ahp.cas.domains.claims;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

// TODO: Auto-generated Javadoc
/**
 * The Class ClmHdrQuantity.
 */
public class ClmHdrQuantity implements Serializable {
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;
	
	/** The clm hdr quantity sid. */
	private long clmHdrQuantitySid;
	
	/** The created by. */
	private BigDecimal createdBy;
	
	/** The created date. */
	private Date createdDate;
	
	/** The modified by. */
	private BigDecimal modifiedBy;
	
	/** The modified date. */
	private Date modifiedDate;
	
	/** The quantity amount. */
	private BigDecimal quantityAmount;
	
	/** The quantity type lkpcd. */
	private String quantityTypeLkpcd;
	
	/** The uom code. */
	private String uomCode;
	
	/** The claim header. */
	private ClaimHeader claimHeader;

	/**
	 * Instantiates a new clm hdr quantity.
	 */
	public ClmHdrQuantity() {
	}

	/**
	 * Gets the clm hdr quantity sid.
	 *
	 * @return the clm hdr quantity sid
	 */
	public long getClmHdrQuantitySid() {
		return clmHdrQuantitySid;
	}

	/**
	 * Sets the clm hdr quantity sid.
	 *
	 * @param clmHdrQuantitySid the new clm hdr quantity sid
	 */
	public void setClmHdrQuantitySid(long clmHdrQuantitySid) {
		this.clmHdrQuantitySid = clmHdrQuantitySid;
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
	 * Gets the quantity amount.
	 *
	 * @return the quantity amount
	 */
	public BigDecimal getQuantityAmount() {
		return quantityAmount;
	}

	/**
	 * Sets the quantity amount.
	 *
	 * @param quantityAmount the new quantity amount
	 */
	public void setQuantityAmount(BigDecimal quantityAmount) {
		this.quantityAmount = quantityAmount;
	}

	/**
	 * Gets the quantity type lkpcd.
	 *
	 * @return the quantity type lkpcd
	 */
	public String getQuantityTypeLkpcd() {
		return quantityTypeLkpcd;
	}

	/**
	 * Sets the quantity type lkpcd.
	 *
	 * @param quantityTypeLkpcd the new quantity type lkpcd
	 */
	public void setQuantityTypeLkpcd(String quantityTypeLkpcd) {
		this.quantityTypeLkpcd = quantityTypeLkpcd;
	}

	/**
	 * Gets the uom code.
	 *
	 * @return the uom code
	 */
	public String getUomCode() {
		return uomCode;
	}

	/**
	 * Sets the uom code.
	 *
	 * @param uomCode the new uom code
	 */
	public void setUomCode(String uomCode) {
		this.uomCode = uomCode;
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