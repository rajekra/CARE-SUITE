package com.ahp.cas.domains.claims;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigDecimal;

// TODO: Auto-generated Javadoc
/**
 * The Class ClmLnXIndicator.
 */
public class ClmLnXIndicator implements Serializable {
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The indctr option code. */
	@JsonProperty("IndicatorValue")
	private String indctrOptionCode;

	/** The indctr type cid. */
	@JsonProperty("IndicatorTypeCode")
	private BigDecimal indctrTypeCid;

	/** The claim line. */
	@JsonBackReference
	private ClaimLine claimLine;

	/** The derived qlfr. */
	private String derivedQlfr;

	/** The clm ln X indicator sid. */
	private long clmLnXIndicatorSid;

	/**
	 * Instantiates a new clm ln X indicator.
	 */
	public ClmLnXIndicator() {
	}

	/**
	 * Gets the indctr option code.
	 *
	 * @return the indctr option code
	 */
	public String getIndctrOptionCode() {
		return indctrOptionCode;
	}

	/**
	 * Sets the indctr option code.
	 *
	 * @param indctrOptionCode the new indctr option code
	 */
	public void setIndctrOptionCode(String indctrOptionCode) {
		this.indctrOptionCode = indctrOptionCode;
	}

	/**
	 * Gets the indctr type cid.
	 *
	 * @return the indctr type cid
	 */
	public BigDecimal getIndctrTypeCid() {
		return indctrTypeCid;
	}

	/**
	 * Sets the indctr type cid.
	 *
	 * @param indctrTypeCid the new indctr type cid
	 */
	public void setIndctrTypeCid(BigDecimal indctrTypeCid) {
		this.indctrTypeCid = indctrTypeCid;
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
	 * Gets the derived qlfr.
	 *
	 * @return the derived qlfr
	 */
	public String getDerivedQlfr() {
		return derivedQlfr;
	}

	/**
	 * Sets the derived qlfr.
	 *
	 * @param derivedQlfr the new derived qlfr
	 */
	public void setDerivedQlfr(String derivedQlfr) {
		this.derivedQlfr = derivedQlfr;
	}

	/**
	 * Gets the clm ln X indicator sid.
	 *
	 * @return the clm ln X indicator sid
	 */
	public long getClmLnXIndicatorSid() {
		return clmLnXIndicatorSid;
	}

	/**
	 * Sets the clm ln X indicator sid.
	 *
	 * @param clmLnXIndicatorSid the new clm ln X indicator sid
	 */
	public void setClmLnXIndicatorSid(long clmLnXIndicatorSid) {
		this.clmLnXIndicatorSid = clmLnXIndicatorSid;
	}

}