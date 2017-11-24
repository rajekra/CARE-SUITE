package com.ahp.cas.domains.claims;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonProperty;

// TODO: Auto-generated Javadoc
/**
 * The Class ClmLnReferenceInfo.
 */
public class ClmLnReferenceInfo implements Serializable {
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The clm ln rfrnc info sid. */
	private long clmLnRfrncInfoSid;

	/** The reference identification. */
	@JsonProperty("ReferenceID")
	private String referenceIdentification;

	/** The reference info lkpcd. */
	@JsonProperty("ReferenceIDQualifier")
	private String referenceInfoLkpcd;

	/** The claim line. */
	@JsonBackReference
	private ClaimLine claimLine;

	/**
	 * Instantiates a new clm ln reference info.
	 */
	public ClmLnReferenceInfo() {
	}

	/**
	 * Gets the reference identification.
	 *
	 * @return the reference identification
	 */
	public String getReferenceIdentification() {
		return referenceIdentification;
	}

	/**
	 * Sets the reference identification.
	 *
	 * @param referenceIdentification the new reference identification
	 */
	public void setReferenceIdentification(String referenceIdentification) {
		this.referenceIdentification = referenceIdentification;
	}

	/**
	 * Gets the reference info lkpcd.
	 *
	 * @return the reference info lkpcd
	 */
	public String getReferenceInfoLkpcd() {
		return referenceInfoLkpcd;
	}

	/**
	 * Sets the reference info lkpcd.
	 *
	 * @param referenceInfoLkpcd the new reference info lkpcd
	 */
	public void setReferenceInfoLkpcd(String referenceInfoLkpcd) {
		this.referenceInfoLkpcd = referenceInfoLkpcd;
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
	 * Gets the clm ln rfrnc info sid.
	 *
	 * @return the clm ln rfrnc info sid
	 */
	public long getClmLnRfrncInfoSid() {
		return clmLnRfrncInfoSid;
	}

	/**
	 * Sets the clm ln rfrnc info sid.
	 *
	 * @param clmLnRfrncInfoSid the new clm ln rfrnc info sid
	 */
	public void setClmLnRfrncInfoSid(long clmLnRfrncInfoSid) {
		this.clmLnRfrncInfoSid = clmLnRfrncInfoSid;
	}

}