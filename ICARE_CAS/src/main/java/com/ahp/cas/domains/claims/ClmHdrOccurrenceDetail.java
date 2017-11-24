package com.ahp.cas.domains.claims;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;

// TODO: Auto-generated Javadoc
/**
 * The Class ClmHdrOccurrenceDetail.
 */
public class ClmHdrOccurrenceDetail implements Serializable {
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;
	
	/** The clm hdr occurrence detail sid. */
	private long clmHdrOccurrenceDetailSid;

	/** The occurrence type qlfr. */
	@JsonProperty("OccuranceType")
	private String occurrenceTypeQlfr;

	/** The clm occurrence and span cid. */
	@JsonProperty("OccuranceSpanCode")
	private String clmOccurrenceAndSpanCid;

	/** The from date. */
	@JsonProperty("OccuranceSpanStartDate")
	private Date fromDate;

	/** The to date. */
	@JsonProperty("OccuranceSpanEndDate")
	private Date toDate;

	/** The claim header. */
	@JsonBackReference
	private ClaimHeader claimHeader;

	/**
	 * Instantiates a new clm hdr occurrence detail.
	 */
	public ClmHdrOccurrenceDetail() {
	}

	/**
	 * Gets the clm hdr occurrence detail sid.
	 *
	 * @return the clm hdr occurrence detail sid
	 */
	public long getClmHdrOccurrenceDetailSid() {
		return clmHdrOccurrenceDetailSid;
	}

	/**
	 * Sets the clm hdr occurrence detail sid.
	 *
	 * @param clmHdrOccurrenceDetailSid the new clm hdr occurrence detail sid
	 */
	public void setClmHdrOccurrenceDetailSid(long clmHdrOccurrenceDetailSid) {
		this.clmHdrOccurrenceDetailSid = clmHdrOccurrenceDetailSid;
	}

	/**
	 * Gets the clm occurrence and span cid.
	 *
	 * @return the clm occurrence and span cid
	 */
	public String getClmOccurrenceAndSpanCid() {
		return clmOccurrenceAndSpanCid;
	}

	/**
	 * Sets the clm occurrence and span cid.
	 *
	 * @param clmOccurrenceAndSpanCid the new clm occurrence and span cid
	 */
	public void setClmOccurrenceAndSpanCid(String clmOccurrenceAndSpanCid) {
		this.clmOccurrenceAndSpanCid = clmOccurrenceAndSpanCid;
	}

	/**
	 * Gets the from date.
	 *
	 * @return the from date
	 */
	public Date getFromDate() {
		return fromDate;
	}

	/**
	 * Sets the from date.
	 *
	 * @param fromDate the new from date
	 */
	public void setFromDate(Date fromDate) {
		this.fromDate = fromDate;
	}

	/**
	 * Gets the to date.
	 *
	 * @return the to date
	 */
	public Date getToDate() {
		return toDate;
	}

	/**
	 * Sets the to date.
	 *
	 * @param toDate the new to date
	 */
	public void setToDate(Date toDate) {
		this.toDate = toDate;
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
	 * Gets the occurrence type qlfr.
	 *
	 * @return the occurrence type qlfr
	 */
	public String getOccurrenceTypeQlfr() {
		return occurrenceTypeQlfr;
	}

	/**
	 * Sets the occurrence type qlfr.
	 *
	 * @param occurrenceTypeQlfr the new occurrence type qlfr
	 */
	public void setOccurrenceTypeQlfr(String occurrenceTypeQlfr) {
		this.occurrenceTypeQlfr = occurrenceTypeQlfr;
	}
}