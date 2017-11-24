package com.ahp.cas.domains.claims;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

// TODO: Auto-generated Javadoc
/**
 * The Class ClmLnPaymentInfo.
 */
public class ClmLnPaymentInfo implements Serializable {
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;
	
	/** The clm ln payment info sid. */
	private long clmLnPaymentInfoSid;
	
	/** The claim invoice number. */
	private String claimInvoiceNumber;
	
	/** The claim payment type lkpcd. */
	private String claimPaymentTypeLkpcd;
	
	/** The created by. */
	private BigDecimal createdBy;
	
	/** The created date. */
	private Date createdDate;
	
	/** The ffp rate amount. */
	private BigDecimal ffpRateAmount;
	
	/** The offset type qlfr. */
	private String offsetTypeQlfr;
	
	/** The paid service units. */
	private BigDecimal paidServiceUnits;
	
	/** The payment amount. */
	private BigDecimal paymentAmount;
	
	/** The payment date. */
	private Date paymentDate;
	
	/** The payment reference nmbr. */
	private String paymentReferenceNmbr;
	
	/** The uom code. */
	private String uomCode;
	
	/** The claim line. */
	private ClaimLine claimLine;

	/**
	 * Instantiates a new clm ln payment info.
	 */
	public ClmLnPaymentInfo() {
	}

	/**
	 * Gets the clm ln payment info sid.
	 *
	 * @return the clm ln payment info sid
	 */
	public long getClmLnPaymentInfoSid() {
		return clmLnPaymentInfoSid;
	}

	/**
	 * Sets the clm ln payment info sid.
	 *
	 * @param clmLnPaymentInfoSid the new clm ln payment info sid
	 */
	public void setClmLnPaymentInfoSid(long clmLnPaymentInfoSid) {
		this.clmLnPaymentInfoSid = clmLnPaymentInfoSid;
	}

	/**
	 * Gets the claim invoice number.
	 *
	 * @return the claim invoice number
	 */
	public String getClaimInvoiceNumber() {
		return claimInvoiceNumber;
	}

	/**
	 * Sets the claim invoice number.
	 *
	 * @param claimInvoiceNumber the new claim invoice number
	 */
	public void setClaimInvoiceNumber(String claimInvoiceNumber) {
		this.claimInvoiceNumber = claimInvoiceNumber;
	}

	/**
	 * Gets the claim payment type lkpcd.
	 *
	 * @return the claim payment type lkpcd
	 */
	public String getClaimPaymentTypeLkpcd() {
		return claimPaymentTypeLkpcd;
	}

	/**
	 * Sets the claim payment type lkpcd.
	 *
	 * @param claimPaymentTypeLkpcd the new claim payment type lkpcd
	 */
	public void setClaimPaymentTypeLkpcd(String claimPaymentTypeLkpcd) {
		this.claimPaymentTypeLkpcd = claimPaymentTypeLkpcd;
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
	 * Gets the ffp rate amount.
	 *
	 * @return the ffp rate amount
	 */
	public BigDecimal getFfpRateAmount() {
		return ffpRateAmount;
	}

	/**
	 * Sets the ffp rate amount.
	 *
	 * @param ffpRateAmount the new ffp rate amount
	 */
	public void setFfpRateAmount(BigDecimal ffpRateAmount) {
		this.ffpRateAmount = ffpRateAmount;
	}

	/**
	 * Gets the offset type qlfr.
	 *
	 * @return the offset type qlfr
	 */
	public String getOffsetTypeQlfr() {
		return offsetTypeQlfr;
	}

	/**
	 * Sets the offset type qlfr.
	 *
	 * @param offsetTypeQlfr the new offset type qlfr
	 */
	public void setOffsetTypeQlfr(String offsetTypeQlfr) {
		this.offsetTypeQlfr = offsetTypeQlfr;
	}

	/**
	 * Gets the paid service units.
	 *
	 * @return the paid service units
	 */
	public BigDecimal getPaidServiceUnits() {
		return paidServiceUnits;
	}

	/**
	 * Sets the paid service units.
	 *
	 * @param paidServiceUnits the new paid service units
	 */
	public void setPaidServiceUnits(BigDecimal paidServiceUnits) {
		this.paidServiceUnits = paidServiceUnits;
	}

	/**
	 * Gets the payment amount.
	 *
	 * @return the payment amount
	 */
	public BigDecimal getPaymentAmount() {
		return paymentAmount;
	}

	/**
	 * Sets the payment amount.
	 *
	 * @param paymentAmount the new payment amount
	 */
	public void setPaymentAmount(BigDecimal paymentAmount) {
		this.paymentAmount = paymentAmount;
	}

	/**
	 * Gets the payment date.
	 *
	 * @return the payment date
	 */
	public Date getPaymentDate() {
		return paymentDate;
	}

	/**
	 * Sets the payment date.
	 *
	 * @param paymentDate the new payment date
	 */
	public void setPaymentDate(Date paymentDate) {
		this.paymentDate = paymentDate;
	}

	/**
	 * Gets the payment reference nmbr.
	 *
	 * @return the payment reference nmbr
	 */
	public String getPaymentReferenceNmbr() {
		return paymentReferenceNmbr;
	}

	/**
	 * Sets the payment reference nmbr.
	 *
	 * @param paymentReferenceNmbr the new payment reference nmbr
	 */
	public void setPaymentReferenceNmbr(String paymentReferenceNmbr) {
		this.paymentReferenceNmbr = paymentReferenceNmbr;
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