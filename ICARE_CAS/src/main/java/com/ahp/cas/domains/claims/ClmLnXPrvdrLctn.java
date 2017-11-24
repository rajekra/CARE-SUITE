package com.ahp.cas.domains.claims;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigDecimal;

// TODO: Auto-generated Javadoc
/**
 * The Class ClmLnXPrvdrLctn.
 */
public class ClmLnXPrvdrLctn implements Serializable {
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;
	
	/** The clm ln X prvdr lctn sid. */
	private long clmLnXPrvdrLctnSid;

	/** The clm prvdr type lkpcd. */
	@JsonProperty("ProviderType")
	private String clmPrvdrTypeLkpcd;

	/** The idntfr type cid. */
	@JsonProperty("ProviderIDQualifier")
	private BigDecimal idntfrTypeCid;

	/** The prvdr first name. */
	@JsonProperty("ProviderFirstName")
	private String prvdrFirstName;

	/** The prvdr last name. */
	@JsonProperty("ProviderLastName")
	private String prvdrLastName;

	/** The prvdr lctn identifier. */
	@JsonProperty("ProviderNPI")
	private String prvdrLctnIdentifier;

	/** The prvdr middle name. */
	@JsonProperty("ProviderMiddleName")
	private String prvdrMiddleName;

	/** The prvdr suffix lkpcd. */
	@JsonProperty("PrvdrSuffixLkpcd")
	private String prvdrSuffixLkpcd;

	/** The txnmy code. */
	@JsonProperty("ProviderTaxonomyCode")
	private String txnmyCode;

	/** The claim line. */
	@JsonBackReference
	private ClaimLine claimLine;

	/** The prvdr lctn iid. */
	private BigDecimal prvdrLctnIid;

	/**
	 * Instantiates a new clm ln X prvdr lctn.
	 */
	public ClmLnXPrvdrLctn() {
	}

	/**
	 * Gets the clm ln X prvdr lctn sid.
	 *
	 * @return the clm ln X prvdr lctn sid
	 */
	public long getClmLnXPrvdrLctnSid() {
		return clmLnXPrvdrLctnSid;
	}

	/**
	 * Sets the clm ln X prvdr lctn sid.
	 *
	 * @param clmLnXPrvdrLctnSid the new clm ln X prvdr lctn sid
	 */
	public void setClmLnXPrvdrLctnSid(long clmLnXPrvdrLctnSid) {
		this.clmLnXPrvdrLctnSid = clmLnXPrvdrLctnSid;
	}

	/**
	 * Gets the clm prvdr type lkpcd.
	 *
	 * @return the clm prvdr type lkpcd
	 */
	public String getClmPrvdrTypeLkpcd() {
		return clmPrvdrTypeLkpcd;
	}

	/**
	 * Sets the clm prvdr type lkpcd.
	 *
	 * @param clmPrvdrTypeLkpcd the new clm prvdr type lkpcd
	 */
	public void setClmPrvdrTypeLkpcd(String clmPrvdrTypeLkpcd) {
		this.clmPrvdrTypeLkpcd = clmPrvdrTypeLkpcd;
	}

	/**
	 * Gets the idntfr type cid.
	 *
	 * @return the idntfr type cid
	 */
	public BigDecimal getIdntfrTypeCid() {
		return idntfrTypeCid;
	}

	/**
	 * Sets the idntfr type cid.
	 *
	 * @param idntfrTypeCid the new idntfr type cid
	 */
	public void setIdntfrTypeCid(BigDecimal idntfrTypeCid) {
		this.idntfrTypeCid = idntfrTypeCid;
	}

	/**
	 * Gets the prvdr first name.
	 *
	 * @return the prvdr first name
	 */
	public String getPrvdrFirstName() {
		return prvdrFirstName;
	}

	/**
	 * Sets the prvdr first name.
	 *
	 * @param prvdrFirstName the new prvdr first name
	 */
	public void setPrvdrFirstName(String prvdrFirstName) {
		this.prvdrFirstName = prvdrFirstName;
	}

	/**
	 * Gets the prvdr last name.
	 *
	 * @return the prvdr last name
	 */
	public String getPrvdrLastName() {
		return prvdrLastName;
	}

	/**
	 * Sets the prvdr last name.
	 *
	 * @param prvdrLastName the new prvdr last name
	 */
	public void setPrvdrLastName(String prvdrLastName) {
		this.prvdrLastName = prvdrLastName;
	}

	/**
	 * Gets the prvdr lctn identifier.
	 *
	 * @return the prvdr lctn identifier
	 */
	public String getPrvdrLctnIdentifier() {
		return prvdrLctnIdentifier;
	}

	/**
	 * Sets the prvdr lctn identifier.
	 *
	 * @param prvdrLctnIdentifier the new prvdr lctn identifier
	 */
	public void setPrvdrLctnIdentifier(String prvdrLctnIdentifier) {
		this.prvdrLctnIdentifier = prvdrLctnIdentifier;
	}

	/**
	 * Gets the prvdr middle name.
	 *
	 * @return the prvdr middle name
	 */
	public String getPrvdrMiddleName() {
		return prvdrMiddleName;
	}

	/**
	 * Sets the prvdr middle name.
	 *
	 * @param prvdrMiddleName the new prvdr middle name
	 */
	public void setPrvdrMiddleName(String prvdrMiddleName) {
		this.prvdrMiddleName = prvdrMiddleName;
	}

	/**
	 * Gets the prvdr suffix lkpcd.
	 *
	 * @return the prvdr suffix lkpcd
	 */
	public String getPrvdrSuffixLkpcd() {
		return prvdrSuffixLkpcd;
	}

	/**
	 * Sets the prvdr suffix lkpcd.
	 *
	 * @param prvdrSuffixLkpcd the new prvdr suffix lkpcd
	 */
	public void setPrvdrSuffixLkpcd(String prvdrSuffixLkpcd) {
		this.prvdrSuffixLkpcd = prvdrSuffixLkpcd;
	}

	/**
	 * Gets the txnmy code.
	 *
	 * @return the txnmy code
	 */
	public String getTxnmyCode() {
		return txnmyCode;
	}

	/**
	 * Sets the txnmy code.
	 *
	 * @param txnmyCode the new txnmy code
	 */
	public void setTxnmyCode(String txnmyCode) {
		this.txnmyCode = txnmyCode;
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
	 * Gets the prvdr lctn iid.
	 *
	 * @return the prvdr lctn iid
	 */
	public BigDecimal getPrvdrLctnIid() {
		return prvdrLctnIid;
	}

	/**
	 * Sets the prvdr lctn iid.
	 *
	 * @param prvdrLctnIid the new prvdr lctn iid
	 */
	public void setPrvdrLctnIid(BigDecimal prvdrLctnIid) {
		this.prvdrLctnIid = prvdrLctnIid;
	}

}