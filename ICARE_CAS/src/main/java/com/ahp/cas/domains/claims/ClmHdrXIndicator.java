package com.ahp.cas.domains.claims;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigDecimal;

// TODO: Auto-generated Javadoc
/**
 * The Class ClmHdrXIndicator.
 */
public class ClmHdrXIndicator implements Serializable {
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The derived qlfr. */
	@JsonProperty("IndicatorDerivedQualifierCode")
	private String derivedQlfr;

	/** The indctr option code. */
	@JsonProperty("IndicatorValue")
	private String indctrOptionCode;

	/** The indctr type cid. */
	@JsonProperty("IndicatorTypeCode")
	private BigDecimal indctrTypeCid;

	/** The claim header. */
	@JsonBackReference
	private ClaimHeader claimHeader;

	/** The clm hdr X indicator sid. */
	private long clmHdrXIndicatorSid;

	/**
	 * Instantiates a new clm hdr X indicator.
	 */
	public ClmHdrXIndicator() {
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
	 * Gets the serialversionuid.
	 *
	 * @return the serialversionuid
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	/**
	 * Gets the clm hdr X indicator sid.
	 *
	 * @return the clm hdr X indicator sid
	 */
	public long getClmHdrXIndicatorSid() {
		return clmHdrXIndicatorSid;
	}

	/**
	 * Sets the clm hdr X indicator sid.
	 *
	 * @param clmHdrXIndicatorSid the new clm hdr X indicator sid
	 */
	public void setClmHdrXIndicatorSid(long clmHdrXIndicatorSid) {
		this.clmHdrXIndicatorSid = clmHdrXIndicatorSid;
	}

}