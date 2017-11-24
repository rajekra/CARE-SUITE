package com.ahp.cas.domains.claims;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigDecimal;

// TODO: Auto-generated Javadoc
/**
 * The Class ClmLnAmount.
 */
public class ClmLnAmount implements Serializable {
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;
	
	/** The clm ln amount sid. */
	private long clmLnAmountSid;

	/** The line non covered charge amount. */
	@JsonProperty("LineNonCoveredChargeAmount")
	private String lineNonCoveredChargeAmount;

	/** The amount type lkpcd. */
	@JsonProperty("PricingMethodCode")
	private String amountTypeLkpcd;

	/** The clm amount value. */
	@JsonProperty("MonetaryAmount")
	private BigDecimal clmAmountValue;

	/** The claim line. */
	@JsonBackReference
	private ClaimLine claimLine;

	/**
	 * Instantiates a new clm ln amount.
	 */
	public ClmLnAmount() {
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
	 * Gets the clm amount value.
	 *
	 * @return the clm amount value
	 */
	public BigDecimal getClmAmountValue() {
		return clmAmountValue;
	}

	/**
	 * Sets the clm amount value.
	 *
	 * @param clmAmountValue the new clm amount value
	 */
	public void setClmAmountValue(BigDecimal clmAmountValue) {
		this.clmAmountValue = clmAmountValue;
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

	/**
	 * Gets the line non covered charge amount.
	 *
	 * @return the line non covered charge amount
	 */
	public String getLineNonCoveredChargeAmount() {
		return lineNonCoveredChargeAmount;
	}

	/**
	 * Sets the line non covered charge amount.
	 *
	 * @param lineNonCoveredChargeAmount the new line non covered charge amount
	 */
	public void setLineNonCoveredChargeAmount(String lineNonCoveredChargeAmount) {
		this.lineNonCoveredChargeAmount = lineNonCoveredChargeAmount;
	}

	/**
	 * Gets the clm ln amount sid.
	 *
	 * @return the clm ln amount sid
	 */
	public long getClmLnAmountSid() {
		return clmLnAmountSid;
	}

	/**
	 * Sets the clm ln amount sid.
	 *
	 * @param clmLnAmountSid the new clm ln amount sid
	 */
	public void setClmLnAmountSid(long clmLnAmountSid) {
		this.clmLnAmountSid = clmLnAmountSid;
	}
}