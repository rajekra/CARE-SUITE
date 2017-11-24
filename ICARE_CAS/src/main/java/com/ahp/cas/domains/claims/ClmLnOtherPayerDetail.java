package com.ahp.cas.domains.claims;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import java.math.BigDecimal;
import java.util.Date;
import java.util.LinkedHashSet;
import java.util.Set;

// TODO: Auto-generated Javadoc
/**
 * The Class ClmLnOtherPayerDetail.
 */
@JsonIdentityInfo(generator=ObjectIdGenerators.IntSequenceGenerator.class, property="@id")
public class ClmLnOtherPayerDetail implements Serializable {
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The clm ln other payer dtl sid. */
	private long clmLnOtherPayerDtlSid;

	/** The line adjudication date. */
	@JsonProperty("OtherPayerAdjudicationDate")
	private Date lineAdjudicationDate;

	/** The other payer paid amount. */
	@JsonProperty("OtherPayerPaidAmount")
	private BigDecimal otherPayerPaidAmount;

	/** The other payer primary idntfr. */
	@JsonProperty("OtherPayerPrimaryID")
	private String otherPayerPrimaryIdntfr;

	/** The rmng patient liability amount. */
	@JsonProperty("RemainingPatientLiabilityAmount")
	private BigDecimal rmngPatientLiabilityAmount;

	/** The claim line. */
	private ClaimLine claimLine;
	
	/** The clm hdr other payer dtl. */
	//private ClmHdrOtherPayerDtl clmHdrOtherPayerDtl;

	/** The clm ln oth pyr adj dtls. */
	@JsonDeserialize(as = LinkedHashSet.class)
	@JsonProperty("LineOtherPayerAdjustmentInformation")
	private Set<ClmLnOthPyrAdjDtl> clmLnOthPyrAdjDtls;

	/**
	 * Instantiates a new clm ln other payer detail.
	 */
	public ClmLnOtherPayerDetail() {
	}

	/**
	 * Gets the line adjudication date.
	 *
	 * @return the line adjudication date
	 */
	public Date getLineAdjudicationDate() {
		return lineAdjudicationDate;
	}

	/**
	 * Sets the line adjudication date.
	 *
	 * @param lineAdjudicationDate the new line adjudication date
	 */
	public void setLineAdjudicationDate(Date lineAdjudicationDate) {
		this.lineAdjudicationDate = lineAdjudicationDate;
	}

	/**
	 * Gets the other payer paid amount.
	 *
	 * @return the other payer paid amount
	 */
	public BigDecimal getOtherPayerPaidAmount() {
		return otherPayerPaidAmount;
	}

	/**
	 * Sets the other payer paid amount.
	 *
	 * @param otherPayerPaidAmount the new other payer paid amount
	 */
	public void setOtherPayerPaidAmount(BigDecimal otherPayerPaidAmount) {
		this.otherPayerPaidAmount = otherPayerPaidAmount;
	}

	/**
	 * Gets the other payer primary idntfr.
	 *
	 * @return the other payer primary idntfr
	 */
	public String getOtherPayerPrimaryIdntfr() {
		return otherPayerPrimaryIdntfr;
	}

	/**
	 * Sets the other payer primary idntfr.
	 *
	 * @param otherPayerPrimaryIdntfr the new other payer primary idntfr
	 */
	public void setOtherPayerPrimaryIdntfr(String otherPayerPrimaryIdntfr) {
		this.otherPayerPrimaryIdntfr = otherPayerPrimaryIdntfr;
	}

	/**
	 * Gets the rmng patient liability amount.
	 *
	 * @return the rmng patient liability amount
	 */
	public BigDecimal getRmngPatientLiabilityAmount() {
		return rmngPatientLiabilityAmount;
	}

	/**
	 * Sets the rmng patient liability amount.
	 *
	 * @param rmngPatientLiabilityAmount the new rmng patient liability amount
	 */
	public void setRmngPatientLiabilityAmount(
			BigDecimal rmngPatientLiabilityAmount) {
		this.rmngPatientLiabilityAmount = rmngPatientLiabilityAmount;
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
	 * Gets the clm hdr other payer dtl.
	 *
	 * @return the clm hdr other payer dtl
	 */
	/*public ClmHdrOtherPayerDtl getClmHdrOtherPayerDtl() {
		return clmHdrOtherPayerDtl;
	}*/

	/**
	 * Sets the clm hdr other payer dtl.
	 *
	 * @param clmHdrOtherPayerDtl the new clm hdr other payer dtl
	 */
	/*public void setClmHdrOtherPayerDtl(ClmHdrOtherPayerDtl clmHdrOtherPayerDtl) {
		this.clmHdrOtherPayerDtl = clmHdrOtherPayerDtl;
	}*/

	/**
	 * Gets the clm ln oth pyr adj dtls.
	 *
	 * @return the clm ln oth pyr adj dtls
	 */
	public Set<ClmLnOthPyrAdjDtl> getClmLnOthPyrAdjDtls() {
		return clmLnOthPyrAdjDtls;
	}

	/**
	 * Sets the clm ln oth pyr adj dtls.
	 *
	 * @param clmLnOthPyrAdjDtls the new clm ln oth pyr adj dtls
	 */
	public void setClmLnOthPyrAdjDtls(Set<ClmLnOthPyrAdjDtl> clmLnOthPyrAdjDtls) {
		this.clmLnOthPyrAdjDtls = clmLnOthPyrAdjDtls;
	}

	/**
	 * Gets the clm ln other payer dtl sid.
	 *
	 * @return the clm ln other payer dtl sid
	 */
	public long getClmLnOtherPayerDtlSid() {
		return clmLnOtherPayerDtlSid;
	}

	/**
	 * Sets the clm ln other payer dtl sid.
	 *
	 * @param clmLnOtherPayerDtlSid the new clm ln other payer dtl sid
	 */
	public void setClmLnOtherPayerDtlSid(long clmLnOtherPayerDtlSid) {
		this.clmLnOtherPayerDtlSid = clmLnOtherPayerDtlSid;
	}

}