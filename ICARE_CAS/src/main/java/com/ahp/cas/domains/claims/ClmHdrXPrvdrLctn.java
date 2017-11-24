package com.ahp.cas.domains.claims;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigDecimal;

// TODO: Auto-generated Javadoc
/**
 * The Class ClmHdrXPrvdrLctn.
 */
public class ClmHdrXPrvdrLctn implements Serializable {
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The clm hdr X prvdr lctn sid. */
	private long clmHdrXPrvdrLctnSid;

	/** The provider state code. */
	@JsonProperty("ProviderStateCode")
	private String providerStateCode;

	/** The clm prvdr type lkpcd. */
	@JsonProperty("ProviderType")
	private String clmPrvdrTypeLkpcd;

	/** The idntfr type cid. */
	@JsonProperty("ProviderIDQualifier")
	private BigDecimal idntfrTypeCid;

	/** The providertaxid. */
	@JsonProperty("ProviderTaxID")
	private String providertaxid;

	/** The providertaxidqualifier. */
	@JsonProperty("ProviderTaxIDQualifier")
	private String providertaxidqualifier;

	/** The prvdr first name. */
	@JsonProperty("ProviderFirstName")
	private String prvdrFirstName;

	/** The prvdr last name. */
	@JsonProperty("ProviderLastName")
	private String prvdrLastName;

	/** The prvdr lctn identifier. */
	@JsonProperty("ProviderNPI")
	private String prvdrLctnIdentifier;
	
	/** The prvdr lctn iid. */
	private BigDecimal prvdrLctnIid;

	/** The prvdr middle name. */
	@JsonProperty("ProviderMiddleName")
	private String prvdrMiddleName;

	/** The prvdr suffix lkpcd. */
	@JsonProperty("ProviderNameSuffix")
	private String prvdrSuffixLkpcd;

	/** The txnmy code. */
	@JsonProperty("ProviderTaxonomyCode")
	private String txnmyCode;

	/** The claim header. */
	@JsonBackReference
	private ClaimHeader claimHeader;

	/** The zip code. */
	@JsonProperty("ProviderZipCode")
	private String zipCode;

	/**
	 * Instantiates a new clm hdr X prvdr lctn.
	 */
	public ClmHdrXPrvdrLctn() {
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
	 * Gets the providertaxid.
	 *
	 * @return the providertaxid
	 */
	public String getProvidertaxid() {
		return providertaxid;
	}

	/**
	 * Sets the providertaxid.
	 *
	 * @param providertaxid the new providertaxid
	 */
	public void setProvidertaxid(String providertaxid) {
		this.providertaxid = providertaxid;
	}

	/**
	 * Gets the providertaxidqualifier.
	 *
	 * @return the providertaxidqualifier
	 */
	public String getProvidertaxidqualifier() {
		return providertaxidqualifier;
	}

	/**
	 * Sets the providertaxidqualifier.
	 *
	 * @param providertaxidqualifier the new providertaxidqualifier
	 */
	public void setProvidertaxidqualifier(String providertaxidqualifier) {
		this.providertaxidqualifier = providertaxidqualifier;
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
	 * Gets the provider state code.
	 *
	 * @return the provider state code
	 */
	public String getProviderStateCode() {
		return providerStateCode;
	}

	/**
	 * Sets the provider state code.
	 *
	 * @param providerStateCode the new provider state code
	 */
	public void setProviderStateCode(String providerStateCode) {
		this.providerStateCode = providerStateCode;
	}

	/**
	 * Gets the zip code.
	 *
	 * @return the zip code
	 */
	public String getZipCode() {
		return this.zipCode;
	}

	/**
	 * Sets the zip code.
	 *
	 * @param zipCode the new zip code
	 */
	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	/**
	 * Gets the clm hdr X prvdr lctn sid.
	 *
	 * @return the clm hdr X prvdr lctn sid
	 */
	public long getClmHdrXPrvdrLctnSid() {
		return clmHdrXPrvdrLctnSid;
	}

	/**
	 * Sets the clm hdr X prvdr lctn sid.
	 *
	 * @param clmHdrXPrvdrLctnSid the new clm hdr X prvdr lctn sid
	 */
	public void setClmHdrXPrvdrLctnSid(long clmHdrXPrvdrLctnSid) {
		this.clmHdrXPrvdrLctnSid = clmHdrXPrvdrLctnSid;
	}
}