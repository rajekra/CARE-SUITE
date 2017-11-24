package com.ahp.cas.domains.claims;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonProperty;

// TODO: Auto-generated Javadoc
/**
 * The Class ClmLnXPaRqstRfrlNmbr.
 */
public class ClmLnXPaRqstRfrlNmbr implements Serializable {
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The clm ln X pa rqst rfrl nmbr sid. */
	private long clmLnXPaRqstRfrlNmbrSid;

	/** The pa rqst rfrl idntfr nmbr. */
	@JsonProperty("PriorAuthReferralNumber")
	private String paRqstRfrlIdntfrNmbr;

	/** The payer identifier. */
	@JsonProperty("OtherPayerIdentifier")
	private String payerIdentifier;

	/** The claim line. */
	@JsonBackReference
	private ClaimLine claimLine;

	/**
	 * Instantiates a new clm ln X pa rqst rfrl nmbr.
	 */
	public ClmLnXPaRqstRfrlNmbr() {
	}

	/**
	 * Gets the pa rqst rfrl idntfr nmbr.
	 *
	 * @return the pa rqst rfrl idntfr nmbr
	 */
	public String getPaRqstRfrlIdntfrNmbr() {
		return paRqstRfrlIdntfrNmbr;
	}

	/**
	 * Sets the pa rqst rfrl idntfr nmbr.
	 *
	 * @param paRqstRfrlIdntfrNmbr the new pa rqst rfrl idntfr nmbr
	 */
	public void setPaRqstRfrlIdntfrNmbr(String paRqstRfrlIdntfrNmbr) {
		this.paRqstRfrlIdntfrNmbr = paRqstRfrlIdntfrNmbr;
	}

	/**
	 * Gets the payer identifier.
	 *
	 * @return the payer identifier
	 */
	public String getPayerIdentifier() {
		return payerIdentifier;
	}

	/**
	 * Sets the payer identifier.
	 *
	 * @param payerIdentifier the new payer identifier
	 */
	public void setPayerIdentifier(String payerIdentifier) {
		this.payerIdentifier = payerIdentifier;
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
	 * Gets the clm ln X pa rqst rfrl nmbr sid.
	 *
	 * @return the clm ln X pa rqst rfrl nmbr sid
	 */
	public long getClmLnXPaRqstRfrlNmbrSid() {
		return clmLnXPaRqstRfrlNmbrSid;
	}

	/**
	 * Sets the clm ln X pa rqst rfrl nmbr sid.
	 *
	 * @param clmLnXPaRqstRfrlNmbrSid the new clm ln X pa rqst rfrl nmbr sid
	 */
	public void setClmLnXPaRqstRfrlNmbrSid(long clmLnXPaRqstRfrlNmbrSid) {
		this.clmLnXPaRqstRfrlNmbrSid = clmLnXPaRqstRfrlNmbrSid;
	}

}