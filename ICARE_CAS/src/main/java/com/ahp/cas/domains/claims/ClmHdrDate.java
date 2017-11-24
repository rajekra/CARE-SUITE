package com.ahp.cas.domains.claims;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;

// TODO: Auto-generated Javadoc
/**
 * The Class ClmHdrDate.
 */
public class ClmHdrDate implements Serializable {
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;
	
	/** The clm hdr date sid. */
	private long clmHdrDateSid;

	/** The clm date. */
	@JsonProperty("ClaimDate")
	private Date clmDate;
	
	/** The date type lkpcd. */
	@JsonProperty("ClaimDateQualifier")
	private String dateTypeLkpcd;

	/** The claim header. */
	@JsonBackReference
	private ClaimHeader claimHeader;

	/**
	 * Instantiates a new clm hdr date.
	 */
	public ClmHdrDate() {
	}

	/**
	 * Gets the clm hdr date sid.
	 *
	 * @return the clm hdr date sid
	 */
	public long getClmHdrDateSid() {
		return clmHdrDateSid;
	}

	/**
	 * Sets the clm hdr date sid.
	 *
	 * @param clmHdrDateSid the new clm hdr date sid
	 */
	public void setClmHdrDateSid(long clmHdrDateSid) {
		this.clmHdrDateSid = clmHdrDateSid;
	}

	/**
	 * Gets the clm date.
	 *
	 * @return the clm date
	 */
	public Date getClmDate() {
		return clmDate;
	}

	/**
	 * Sets the clm date.
	 *
	 * @param clmDate the new clm date
	 */
	public void setClmDate(Date clmDate) {
		this.clmDate = clmDate;
	}

	/**
	 * Gets the date type lkpcd.
	 *
	 * @return the date type lkpcd
	 */
	public String getDateTypeLkpcd() {
		return dateTypeLkpcd;
	}

	/**
	 * Sets the date type lkpcd.
	 *
	 * @param dateTypeLkpcd the new date type lkpcd
	 */
	public void setDateTypeLkpcd(String dateTypeLkpcd) {
		this.dateTypeLkpcd = dateTypeLkpcd;
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