package com.ahp.cas.domains.claims;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonProperty;

// TODO: Auto-generated Javadoc
/**
 * The Class ClmHdrOtherPayerRemark.
 */
public class ClmHdrOtherPayerRemark implements Serializable {
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The clm hdr other payer remark sid. */
	private long clmHdrOtherPayerRemarkSid;

	/** The clm remittance advice rmrk code. */
	@JsonProperty("RemarkCode")
	private String clmRemittanceAdviceRmrkCode;

	/** The claim header. */
	@JsonBackReference
	private ClaimHeader claimHeader;
	
	/** The clm hdr other payer dtl. */
	private ClmHdrOtherPayerDtl clmHdrOtherPayerDtl;

	/**
	 * Instantiates a new clm hdr other payer remark.
	 */
	public ClmHdrOtherPayerRemark() {
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
	 * Gets the clm hdr other payer dtl.
	 *
	 * @return the clm hdr other payer dtl
	 */
	public ClmHdrOtherPayerDtl getClmHdrOtherPayerDtl() {
		return clmHdrOtherPayerDtl;
	}

	/**
	 * Sets the clm hdr other payer dtl.
	 *
	 * @param clmHdrOtherPayerDtl the new clm hdr other payer dtl
	 */
	public void setClmHdrOtherPayerDtl(ClmHdrOtherPayerDtl clmHdrOtherPayerDtl) {
		this.clmHdrOtherPayerDtl = clmHdrOtherPayerDtl;
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
	 * Sets the clm remittance advice rmrk code.
	 *
	 * @param clmRemittanceAdviceRmrkCode the new clm remittance advice rmrk code
	 */
	public void setClmRemittanceAdviceRmrkCode(
			String clmRemittanceAdviceRmrkCode) {
		this.clmRemittanceAdviceRmrkCode = clmRemittanceAdviceRmrkCode;
	}

	/**
	 * Gets the clm remittance advice rmrk code.
	 *
	 * @return the clm remittance advice rmrk code
	 */
	public String getClmRemittanceAdviceRmrkCode() {
		return clmRemittanceAdviceRmrkCode;
	}

	/**
	 * Gets the clm hdr other payer remark sid.
	 *
	 * @return the clm hdr other payer remark sid
	 */
	public long getClmHdrOtherPayerRemarkSid() {
		return clmHdrOtherPayerRemarkSid;
	}

	/**
	 * Sets the clm hdr other payer remark sid.
	 *
	 * @param clmHdrOtherPayerRemarkSid the new clm hdr other payer remark sid
	 */
	public void setClmHdrOtherPayerRemarkSid(long clmHdrOtherPayerRemarkSid) {
		this.clmHdrOtherPayerRemarkSid = clmHdrOtherPayerRemarkSid;
	}

}