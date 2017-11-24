package com.ahp.cas.domains.claims;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigDecimal;

// TODO: Auto-generated Javadoc
/**
 * The Class ClmHdrValueAmount.
 */
public class ClmHdrValueAmount implements Serializable {
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The clm hdr value amount sid. */
	private long clmHdrValueAmountSid;

	/** The amount type lkpcd. */
	@JsonProperty("ClaimValueCode")
	private String amountTypeLkpcd;

	/** The clm amount value. */
	@JsonProperty("ClaimValueAmount")
	private BigDecimal clmAmountValue;

	/** The claim header. */
	@JsonBackReference
	private ClaimHeader claimHeader;

	/**
	 * Instantiates a new clm hdr value amount.
	 */
	public ClmHdrValueAmount() {
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
	 * Gets the clm hdr value amount sid.
	 *
	 * @return the clm hdr value amount sid
	 */
	public long getClmHdrValueAmountSid() {
		return clmHdrValueAmountSid;
	}

	/**
	 * Sets the clm hdr value amount sid.
	 *
	 * @param clmHdrValueAmountSid the new clm hdr value amount sid
	 */
	public void setClmHdrValueAmountSid(long clmHdrValueAmountSid) {
		this.clmHdrValueAmountSid = clmHdrValueAmountSid;
	}

}