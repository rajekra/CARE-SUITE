package com.ahp.cas.domains.claims;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import java.math.BigDecimal;
import java.util.Date;

// TODO: Auto-generated Javadoc
/**
 * The Class ClmHdrOthPyrAdjDtl.
 */
@JsonIdentityInfo(generator=ObjectIdGenerators.IntSequenceGenerator.class, property="@id")
public class ClmHdrOthPyrAdjDtl implements Serializable {
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;
	
	/** The adjustment reason code. */
	@JsonProperty("AdjustmentReasonCode")
	private String adjustmentReasonCode;

	/** The clm hdr oth pyr adj sid. */
	private long clmHdrOthPyrAdjSid;

	/** The adjustment group lkpcd. */
	@JsonProperty("AdjustmentGroupCode")
	private String adjustmentGroupLkpcd;

	/**
	 * Gets the clm hdr oth pyr adj sid.
	 *
	 * @return the clm hdr oth pyr adj sid
	 */
	public long getClmHdrOthPyrAdjSid() {
		return clmHdrOthPyrAdjSid;
	}

	/**
	 * Sets the clm hdr oth pyr adj sid.
	 *
	 * @param clmHdrOthPyrAdjSid the new clm hdr oth pyr adj sid
	 */
	public void setClmHdrOthPyrAdjSid(long clmHdrOthPyrAdjSid) {
		this.clmHdrOthPyrAdjSid = clmHdrOthPyrAdjSid;
	}

	/**
	 * Gets the adjustment group lkpcd.
	 *
	 * @return the adjustment group lkpcd
	 */
	public String getAdjustmentGroupLkpcd() {
		return adjustmentGroupLkpcd;
	}

	/**
	 * Sets the adjustment group lkpcd.
	 *
	 * @param adjustmentGroupLkpcd the new adjustment group lkpcd
	 */
	public void setAdjustmentGroupLkpcd(String adjustmentGroupLkpcd) {
		this.adjustmentGroupLkpcd = adjustmentGroupLkpcd;
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
	 * Gets the monetary amount.
	 *
	 * @return the monetary amount
	 */
	public BigDecimal getMonetaryAmount() {
		return monetaryAmount;
	}

	/**
	 * Sets the monetary amount.
	 *
	 * @param monetaryAmount the new monetary amount
	 */
	public void setMonetaryAmount(BigDecimal monetaryAmount) {
		this.monetaryAmount = monetaryAmount;
	}

	/**
	 * Gets the service units.
	 *
	 * @return the service units
	 */
	public BigDecimal getServiceUnits() {
		return serviceUnits;
	}

	/**
	 * Sets the service units.
	 *
	 * @param serviceUnits the new service units
	 */
	public void setServiceUnits(BigDecimal serviceUnits) {
		this.serviceUnits = serviceUnits;
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

	/**
	 * Gets the clm hdr other payer dtl.
	 *
	 * @return the clm hdr other payer dtl
	 */
	public ClmHdrOtherPayerDtl getClmHdrOtherPayerDtl() {
		return clmHdrOtherPayerDtl;
	}

	/**
	 * Sets the clm hdr other payer dtl.
	 *
	 * @param clmHdrOtherPayerDtl the new clm hdr other payer dtl
	 */
	public void setClmHdrOtherPayerDtl(ClmHdrOtherPayerDtl clmHdrOtherPayerDtl) {
		this.clmHdrOtherPayerDtl = clmHdrOtherPayerDtl;
	}

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

	/** The monetary amount. */
	@JsonProperty("AdjustmentAmount")
	private BigDecimal monetaryAmount;

	/** The service units. */
	@JsonProperty("AdjustmentQuantity")
	private BigDecimal serviceUnits;
	
	/** The uom code. */
	private String uomCode;
	
	/** The claim header. */
	private ClaimHeader claimHeader;

	/** The clm hdr other payer dtl. */
	//@JsonBackReference
	private ClmHdrOtherPayerDtl clmHdrOtherPayerDtl;

	/**
	 * Instantiates a new clm hdr oth pyr adj dtl.
	 */
	public ClmHdrOthPyrAdjDtl() {
	}

	/**
	 * Gets the adjustment reason code.
	 *
	 * @return the adjustment reason code
	 */
	public String getAdjustmentReasonCode() {
		return adjustmentReasonCode;
	}

	/**
	 * Sets the adjustment reason code.
	 *
	 * @param adjustmentReasonCode the new adjustment reason code
	 */
	public void setAdjustmentReasonCode(String adjustmentReasonCode) {
		this.adjustmentReasonCode = adjustmentReasonCode;
	}
}