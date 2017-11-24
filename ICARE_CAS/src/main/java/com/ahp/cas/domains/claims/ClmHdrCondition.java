package com.ahp.cas.domains.claims;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonProperty;

// TODO: Auto-generated Javadoc
/**
 * The Class ClmHdrCondition.
 */
public class ClmHdrCondition implements Serializable {
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The clm hdr condition sid. */
	private long clmHdrConditionSid;

	/** The clm condition cid. */
	@JsonProperty("ClaimConditionCode")
	private String clmConditionCid;

	/** The claim header. */
	@JsonBackReference
	private ClaimHeader claimHeader;

	/**
	 * Instantiates a new clm hdr condition.
	 */
	public ClmHdrCondition() {
	}

	/**
	 * Gets the clm condition cid.
	 *
	 * @return the clm condition cid
	 */
	public String getClmConditionCid() {
		return clmConditionCid;
	}

	/**
	 * Sets the clm condition cid.
	 *
	 * @param clmConditionCid the new clm condition cid
	 */
	public void setClmConditionCid(String clmConditionCid) {
		this.clmConditionCid = clmConditionCid;
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
	 * Gets the clm hdr condition sid.
	 *
	 * @return the clm hdr condition sid
	 */
	public long getClmHdrConditionSid() {
		return clmHdrConditionSid;
	}

	/**
	 * Sets the clm hdr condition sid.
	 *
	 * @param clmHdrConditionSid the new clm hdr condition sid
	 */
	public void setClmHdrConditionSid(long clmHdrConditionSid) {
		this.clmHdrConditionSid = clmHdrConditionSid;
	}

}