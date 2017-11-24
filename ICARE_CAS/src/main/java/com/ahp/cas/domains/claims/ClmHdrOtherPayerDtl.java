package com.ahp.cas.domains.claims;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import java.math.BigDecimal;
import java.util.Date;
import java.util.LinkedHashSet;
import java.util.Set;

// TODO: Auto-generated Javadoc
/**
 * The Class ClmHdrOtherPayerDtl.
 */
@JsonIdentityInfo(generator=ObjectIdGenerators.IntSequenceGenerator.class, property="@id")
public class ClmHdrOtherPayerDtl implements Serializable {
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;
	
	/** The clm hdr other payer dtl sid. */
	private long clmHdrOtherPayerDtlSid;

	/** The adjudication date. */
	@JsonProperty("OtherPayerAdjudicationDate")
	private Date adjudicationDate;

	/** The claim filing indicator lkpcd. */
	@JsonProperty("ClaimFilingIndicatorCode")
	private String claimFilingIndicatorLkpcd;

	/** The cob payer paid amount. */
	@JsonProperty("COBPayerPaidAmount")
	private BigDecimal cobPayerPaidAmount;

	/** The cob total non covered amount. */
	@JsonProperty("COBTotalNonCoveredChargeAmount")
	private BigDecimal cobTotalNonCoveredAmount;

	/** The corrected payer qlfr. */
	@JsonProperty("IsPayerInfoCorrected")
	private String correctedPayerQlfr;

	/** The other insured group nmbr. */
	@JsonProperty("OtherInsuredGroupOrPolicyNo")
	private String otherInsuredGroupNmbr;

	/** The payer identifier. */
	@JsonProperty("OtherPayerPrimaryID")
	private String payerIdentifier;

	/** The payer identifier lkpcd. */
	@JsonProperty("OtherPayerPrimaryIDQualifier")
	private String payerIdentifierLkpcd;

	/** The payer name. */
	@JsonProperty("OtherPayerLastName")
	private String payerName;

	/** The payer responsibility sqnc nmbr. */
	@JsonProperty("PayerRespSequenceNoCode")
	private String payerResponsibilitySqncNmbr;

	/** The rmng patient liability amount. */
	@JsonProperty("RemainingPatientLiabilityAmount")
	private BigDecimal rmngPatientLiabilityAmount;

	/** The sbmtd insurance type. */
	@JsonProperty("InsuranceTypeCode")
	private String sbmtdInsuranceType;
	
	private String insuranceType;
	
	private BigDecimal cobAllowedAmount;

	public String getInsuranceType() {
		return insuranceType;
	}

	public void setInsuranceType(String insuranceType) {
		this.insuranceType = insuranceType;
	}

	public BigDecimal getCobAllowedAmount() {
		return cobAllowedAmount;
	}

	public void setCobAllowedAmount(BigDecimal cobAllowedAmount) {
		this.cobAllowedAmount = cobAllowedAmount;
	}

	/** The claim header. */
	@JsonBackReference
	private ClaimHeader claimHeader;
	
	/** The clm hdr other payer remarks. */
	private Set<ClmHdrOtherPayerRemark> clmHdrOtherPayerRemarks;

	/** The clm hdr oth pyr adj dtls. */
	@JsonDeserialize(as = LinkedHashSet.class)
	@JsonProperty("HeaderOtherPayerAdjustmentInformation")
	private Set<ClmHdrOthPyrAdjDtl> clmHdrOthPyrAdjDtls;
	
	/** The clm ln other payer details. */
	private Set<ClmLnOtherPayerDetail> clmLnOtherPayerDetails;
	
	/** The clm ln oth pyr adj dtls. */
	private Set<ClmLnOthPyrAdjDtl> clmLnOthPyrAdjDtls;

	/**
	 * Instantiates a new clm hdr other payer dtl.
	 */
	public ClmHdrOtherPayerDtl() {
	}

	/**
	 * Gets the clm hdr other payer dtl sid.
	 *
	 * @return the clm hdr other payer dtl sid
	 */
	public long getClmHdrOtherPayerDtlSid() {
		return clmHdrOtherPayerDtlSid;
	}

	/**
	 * Sets the clm hdr other payer dtl sid.
	 *
	 * @param clmHdrOtherPayerDtlSid the new clm hdr other payer dtl sid
	 */
	public void setClmHdrOtherPayerDtlSid(long clmHdrOtherPayerDtlSid) {
		this.clmHdrOtherPayerDtlSid = clmHdrOtherPayerDtlSid;
	}

	/**
	 * Gets the adjudication date.
	 *
	 * @return the adjudication date
	 */
	public Date getAdjudicationDate() {
		return adjudicationDate;
	}

	/**
	 * Sets the adjudication date.
	 *
	 * @param adjudicationDate the new adjudication date
	 */
	public void setAdjudicationDate(Date adjudicationDate) {
		this.adjudicationDate = adjudicationDate;
	}

	/**
	 * Gets the claim filing indicator lkpcd.
	 *
	 * @return the claim filing indicator lkpcd
	 */
	public String getClaimFilingIndicatorLkpcd() {
		return claimFilingIndicatorLkpcd;
	}

	/**
	 * Sets the claim filing indicator lkpcd.
	 *
	 * @param claimFilingIndicatorLkpcd the new claim filing indicator lkpcd
	 */
	public void setClaimFilingIndicatorLkpcd(String claimFilingIndicatorLkpcd) {
		this.claimFilingIndicatorLkpcd = claimFilingIndicatorLkpcd;
	}

	/**
	 * Gets the cob payer paid amount.
	 *
	 * @return the cob payer paid amount
	 */
	public BigDecimal getCobPayerPaidAmount() {
		return cobPayerPaidAmount;
	}

	/**
	 * Sets the cob payer paid amount.
	 *
	 * @param cobPayerPaidAmount the new cob payer paid amount
	 */
	public void setCobPayerPaidAmount(BigDecimal cobPayerPaidAmount) {
		this.cobPayerPaidAmount = cobPayerPaidAmount;
	}

	/**
	 * Gets the cob total non covered amount.
	 *
	 * @return the cob total non covered amount
	 */
	public BigDecimal getCobTotalNonCoveredAmount() {
		return cobTotalNonCoveredAmount;
	}

	/**
	 * Sets the cob total non covered amount.
	 *
	 * @param cobTotalNonCoveredAmount the new cob total non covered amount
	 */
	public void setCobTotalNonCoveredAmount(BigDecimal cobTotalNonCoveredAmount) {
		this.cobTotalNonCoveredAmount = cobTotalNonCoveredAmount;
	}

	/**
	 * Gets the corrected payer qlfr.
	 *
	 * @return the corrected payer qlfr
	 */
	public String getCorrectedPayerQlfr() {
		return correctedPayerQlfr;
	}

	/**
	 * Sets the corrected payer qlfr.
	 *
	 * @param correctedPayerQlfr the new corrected payer qlfr
	 */
	public void setCorrectedPayerQlfr(String correctedPayerQlfr) {
		this.correctedPayerQlfr = correctedPayerQlfr;
	}

	/**
	 * Gets the other insured group nmbr.
	 *
	 * @return the other insured group nmbr
	 */
	public String getOtherInsuredGroupNmbr() {
		return otherInsuredGroupNmbr;
	}

	/**
	 * Sets the other insured group nmbr.
	 *
	 * @param otherInsuredGroupNmbr the new other insured group nmbr
	 */
	public void setOtherInsuredGroupNmbr(String otherInsuredGroupNmbr) {
		this.otherInsuredGroupNmbr = otherInsuredGroupNmbr;
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
	 * Gets the payer identifier lkpcd.
	 *
	 * @return the payer identifier lkpcd
	 */
	public String getPayerIdentifierLkpcd() {
		return payerIdentifierLkpcd;
	}

	/**
	 * Sets the payer identifier lkpcd.
	 *
	 * @param payerIdentifierLkpcd the new payer identifier lkpcd
	 */
	public void setPayerIdentifierLkpcd(String payerIdentifierLkpcd) {
		this.payerIdentifierLkpcd = payerIdentifierLkpcd;
	}

	/**
	 * Gets the payer name.
	 *
	 * @return the payer name
	 */
	public String getPayerName() {
		return payerName;
	}

	/**
	 * Sets the payer name.
	 *
	 * @param payerName the new payer name
	 */
	public void setPayerName(String payerName) {
		this.payerName = payerName;
	}

	/**
	 * Gets the payer responsibility sqnc nmbr.
	 *
	 * @return the payer responsibility sqnc nmbr
	 */
	public String getPayerResponsibilitySqncNmbr() {
		return payerResponsibilitySqncNmbr;
	}

	/**
	 * Sets the payer responsibility sqnc nmbr.
	 *
	 * @param payerResponsibilitySqncNmbr the new payer responsibility sqnc nmbr
	 */
	public void setPayerResponsibilitySqncNmbr(
			String payerResponsibilitySqncNmbr) {
		this.payerResponsibilitySqncNmbr = payerResponsibilitySqncNmbr;
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
	 * Gets the sbmtd insurance type.
	 *
	 * @return the sbmtd insurance type
	 */
	public String getSbmtdInsuranceType() {
		return sbmtdInsuranceType;
	}

	/**
	 * Sets the sbmtd insurance type.
	 *
	 * @param sbmtdInsuranceType the new sbmtd insurance type
	 */
	public void setSbmtdInsuranceType(String sbmtdInsuranceType) {
		this.sbmtdInsuranceType = sbmtdInsuranceType;
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
	 * Gets the clm hdr other payer remarks.
	 *
	 * @return the clm hdr other payer remarks
	 */
	public Set<ClmHdrOtherPayerRemark> getClmHdrOtherPayerRemarks() {
		return clmHdrOtherPayerRemarks;
	}

	/**
	 * Sets the clm hdr other payer remarks.
	 *
	 * @param clmHdrOtherPayerRemarks the new clm hdr other payer remarks
	 */
	public void setClmHdrOtherPayerRemarks(
			Set<ClmHdrOtherPayerRemark> clmHdrOtherPayerRemarks) {
		this.clmHdrOtherPayerRemarks = clmHdrOtherPayerRemarks;
	}

	/**
	 * Gets the clm hdr oth pyr adj dtls.
	 *
	 * @return the clm hdr oth pyr adj dtls
	 */
	public Set<ClmHdrOthPyrAdjDtl> getClmHdrOthPyrAdjDtls() {
		return clmHdrOthPyrAdjDtls;
	}

	/**
	 * Sets the clm hdr oth pyr adj dtls.
	 *
	 * @param clmHdrOthPyrAdjDtls the new clm hdr oth pyr adj dtls
	 */
	public void setClmHdrOthPyrAdjDtls(
			Set<ClmHdrOthPyrAdjDtl> clmHdrOthPyrAdjDtls) {
		this.clmHdrOthPyrAdjDtls = clmHdrOthPyrAdjDtls;
	}

	/**
	 * Gets the clm ln other payer details.
	 *
	 * @return the clm ln other payer details
	 */
	public Set<ClmLnOtherPayerDetail> getClmLnOtherPayerDetails() {
		return clmLnOtherPayerDetails;
	}

	/**
	 * Sets the clm ln other payer details.
	 *
	 * @param clmLnOtherPayerDetails the new clm ln other payer details
	 */
	public void setClmLnOtherPayerDetails(
			Set<ClmLnOtherPayerDetail> clmLnOtherPayerDetails) {
		this.clmLnOtherPayerDetails = clmLnOtherPayerDetails;
	}

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

}