package com.ahp.cas.domains.claims;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonProperty;

// TODO: Auto-generated Javadoc
/**
 * The Class ClmHdrReferenceInfo.
 */
public class ClmHdrReferenceInfo implements Serializable {
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The clm hdr rfrnc info sid. */
	private long clmHdrRfrncInfoSid;

	/** The reference ID qualifier. */
	@JsonProperty("ReferenceIDQualifier")
	private String referenceIDQualifier;

	/** The reference identification. */
	@JsonProperty("ReferenceID")
	private String referenceIdentification;

	/** The claim header. */
	@JsonBackReference
	private ClaimHeader claimHeader;

	/**
	 * Instantiates a new clm hdr reference info.
	 */
	public ClmHdrReferenceInfo() {
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
	 * Gets the reference ID qualifier.
	 *
	 * @return the reference ID qualifier
	 */
	public String getReferenceIDQualifier() {
		return referenceIDQualifier;
	}

	/**
	 * Sets the reference ID qualifier.
	 *
	 * @param referenceIDQualifier the new reference ID qualifier
	 */
	public void setReferenceIDQualifier(String referenceIDQualifier) {
		this.referenceIDQualifier = referenceIDQualifier;
	}

	/**
	 * Gets the clm hdr rfrnc info sid.
	 *
	 * @return the clm hdr rfrnc info sid
	 */
	public long getClmHdrRfrncInfoSid() {
		return clmHdrRfrncInfoSid;
	}

	/**
	 * Sets the clm hdr rfrnc info sid.
	 *
	 * @param clmHdrRfrncInfoSid the new clm hdr rfrnc info sid
	 */
	public void setClmHdrRfrncInfoSid(long clmHdrRfrncInfoSid) {
		this.clmHdrRfrncInfoSid = clmHdrRfrncInfoSid;
	}

}