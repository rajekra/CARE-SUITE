package com.ahp.cas.domains.claims;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

// TODO: Auto-generated Javadoc
/**
 * The Class ClmSbmtr.
 */
public class ClmSbmtr implements Serializable {
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The clm sbmtr sid. */
	private long clmSbmtrSid;

	/** The submitter identifier code. */
	@JsonProperty("SubmitterIdentifierCode")
	private String submitterIdentifierCode;

	/** The cmnctn nmbr qlfr 1. */
	@JsonProperty("CommunicationNoQualifier1")
	private String cmnctnNmbrQlfr1;

	/** The cmnctn nmbr qlfr 2. */
	@JsonProperty("CommunicationNoQualifier2")
	private String cmnctnNmbrQlfr2;

	/** The cmnctn nmbr qlfr 3. */
	@JsonProperty("CommunicationNoQualifier3")
	private String cmnctnNmbrQlfr3;

	/** The cmnctn nmbr qlfr 4. */
	@JsonProperty("CommunicationNoQualifier4")
	private String cmnctnNmbrQlfr4;

	/** The cmnctn nmbr qlfr 5. */
	@JsonProperty("CommunicationNoQualifier5")
	private String cmnctnNmbrQlfr5;

	/** The cmnctn nmbr qlfr 6. */
	@JsonProperty("CommunicationNoQualifier6")
	private String cmnctnNmbrQlfr6;

	/** The cmnctn nmbr 1. */
	@JsonProperty("CommunicationNo1")
	private String cmnctnNmbr1;

	/** The cmnctn nmbr 2. */
	@JsonProperty("CommunicationNo2")
	private String cmnctnNmbr2;

	/** The cmnctn nmbr 3. */
	@JsonProperty("CommunicationNo3")
	private String cmnctnNmbr3;

	/** The cmnctn nmbr 4. */
	@JsonProperty("CommunicationNo4")
	private String cmnctnNmbr4;

	/** The cmnctn nmbr 5. */
	@JsonProperty("CommunicationNo5")
	private String cmnctnNmbr5;

	/** The cmnctn nmbr 6. */
	@JsonProperty("CommunicationNo6")
	private String cmnctnNmbr6;

	/** The oprtnl flag. */
	@JsonProperty("SubmitterStatusIndicator")
	private String oprtnlFlag;

	/** The sbmtr contact name 1. */
	@JsonProperty("SubmitterContactName1")
	private String sbmtrContactName1;

	/** The sbmtr contact name 2. */
	@JsonProperty("SubmitterContactName2")
	private String sbmtrContactName2;

	/** The sbmtr first name. */
	@JsonProperty("SubmitterFirstName")
	private String sbmtrFirstName;

	/** The sbmtr idntfr. */
	@JsonProperty("SubmitterIdentifier")
	private String sbmtrIdntfr;

	/** The sbmtr last name. */
	@JsonProperty("SubmitterLastName")
	private String sbmtrLastName;

	/** The sbmtr middle name. */
	@JsonProperty("SubmitterMiddleName")
	private String sbmtrMiddleName;

	/** The clm trnsctn. */
	@JsonIgnore
	private ClmTrnsctn clmTrnsctn;

	/**
	 * Gets the submitter identifier code.
	 *
	 * @return the submitter identifier code
	 */
	public String getSubmitterIdentifierCode() {
		return submitterIdentifierCode;
	}

	/**
	 * Sets the submitter identifier code.
	 *
	 * @param submitterIdentifierCode the new submitter identifier code
	 */
	public void setSubmitterIdentifierCode(String submitterIdentifierCode) {
		this.submitterIdentifierCode = submitterIdentifierCode;
	}

	// public long getClmTrnsctnSid() {
	// return clmTrnsctnSid;
	// }
	//
	// public void setClmTrnsctnSid(long clmTrnsctnSid) {
	// this.clmTrnsctnSid = clmTrnsctnSid;
	// }

	/** The claim header. */
	// bi-directional many-to-one association to AdClmHdrXProcedure
	@JsonBackReference
	private ClaimHeader claimHeader;

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
	 * Instantiates a new clm sbmtr.
	 */
	public ClmSbmtr() {
	}

	/**
	 * Gets the cmnctn nmbr qlfr 1.
	 *
	 * @return the cmnctn nmbr qlfr 1
	 */
	public String getCmnctnNmbrQlfr1() {
		return this.cmnctnNmbrQlfr1;
	}

	/**
	 * Sets the cmnctn nmbr qlfr 1.
	 *
	 * @param cmnctnNmbrQlfr1 the new cmnctn nmbr qlfr 1
	 */
	public void setCmnctnNmbrQlfr1(String cmnctnNmbrQlfr1) {
		this.cmnctnNmbrQlfr1 = cmnctnNmbrQlfr1;
	}

	/**
	 * Gets the cmnctn nmbr qlfr 2.
	 *
	 * @return the cmnctn nmbr qlfr 2
	 */
	public String getCmnctnNmbrQlfr2() {
		return this.cmnctnNmbrQlfr2;
	}

	/**
	 * Sets the cmnctn nmbr qlfr 2.
	 *
	 * @param cmnctnNmbrQlfr2 the new cmnctn nmbr qlfr 2
	 */
	public void setCmnctnNmbrQlfr2(String cmnctnNmbrQlfr2) {
		this.cmnctnNmbrQlfr2 = cmnctnNmbrQlfr2;
	}

	/**
	 * Gets the cmnctn nmbr qlfr 3.
	 *
	 * @return the cmnctn nmbr qlfr 3
	 */
	public String getCmnctnNmbrQlfr3() {
		return this.cmnctnNmbrQlfr3;
	}

	/**
	 * Sets the cmnctn nmbr qlfr 3.
	 *
	 * @param cmnctnNmbrQlfr3 the new cmnctn nmbr qlfr 3
	 */
	public void setCmnctnNmbrQlfr3(String cmnctnNmbrQlfr3) {
		this.cmnctnNmbrQlfr3 = cmnctnNmbrQlfr3;
	}

	/**
	 * Gets the cmnctn nmbr qlfr 4.
	 *
	 * @return the cmnctn nmbr qlfr 4
	 */
	public String getCmnctnNmbrQlfr4() {
		return this.cmnctnNmbrQlfr4;
	}

	/**
	 * Sets the cmnctn nmbr qlfr 4.
	 *
	 * @param cmnctnNmbrQlfr4 the new cmnctn nmbr qlfr 4
	 */
	public void setCmnctnNmbrQlfr4(String cmnctnNmbrQlfr4) {
		this.cmnctnNmbrQlfr4 = cmnctnNmbrQlfr4;
	}

	/**
	 * Gets the cmnctn nmbr qlfr 5.
	 *
	 * @return the cmnctn nmbr qlfr 5
	 */
	public String getCmnctnNmbrQlfr5() {
		return this.cmnctnNmbrQlfr5;
	}

	/**
	 * Sets the cmnctn nmbr qlfr 5.
	 *
	 * @param cmnctnNmbrQlfr5 the new cmnctn nmbr qlfr 5
	 */
	public void setCmnctnNmbrQlfr5(String cmnctnNmbrQlfr5) {
		this.cmnctnNmbrQlfr5 = cmnctnNmbrQlfr5;
	}

	/**
	 * Gets the cmnctn nmbr qlfr 6.
	 *
	 * @return the cmnctn nmbr qlfr 6
	 */
	public String getCmnctnNmbrQlfr6() {
		return this.cmnctnNmbrQlfr6;
	}

	/**
	 * Sets the cmnctn nmbr qlfr 6.
	 *
	 * @param cmnctnNmbrQlfr6 the new cmnctn nmbr qlfr 6
	 */
	public void setCmnctnNmbrQlfr6(String cmnctnNmbrQlfr6) {
		this.cmnctnNmbrQlfr6 = cmnctnNmbrQlfr6;
	}

	/**
	 * Gets the cmnctn nmbr 1.
	 *
	 * @return the cmnctn nmbr 1
	 */
	public String getCmnctnNmbr1() {
		return this.cmnctnNmbr1;
	}

	/**
	 * Sets the cmnctn nmbr 1.
	 *
	 * @param cmnctnNmbr1 the new cmnctn nmbr 1
	 */
	public void setCmnctnNmbr1(String cmnctnNmbr1) {
		this.cmnctnNmbr1 = cmnctnNmbr1;
	}

	/**
	 * Gets the cmnctn nmbr 2.
	 *
	 * @return the cmnctn nmbr 2
	 */
	public String getCmnctnNmbr2() {
		return this.cmnctnNmbr2;
	}

	/**
	 * Sets the cmnctn nmbr 2.
	 *
	 * @param cmnctnNmbr2 the new cmnctn nmbr 2
	 */
	public void setCmnctnNmbr2(String cmnctnNmbr2) {
		this.cmnctnNmbr2 = cmnctnNmbr2;
	}

	/**
	 * Gets the cmnctn nmbr 3.
	 *
	 * @return the cmnctn nmbr 3
	 */
	public String getCmnctnNmbr3() {
		return this.cmnctnNmbr3;
	}

	/**
	 * Sets the cmnctn nmbr 3.
	 *
	 * @param cmnctnNmbr3 the new cmnctn nmbr 3
	 */
	public void setCmnctnNmbr3(String cmnctnNmbr3) {
		this.cmnctnNmbr3 = cmnctnNmbr3;
	}

	/**
	 * Gets the cmnctn nmbr 4.
	 *
	 * @return the cmnctn nmbr 4
	 */
	public String getCmnctnNmbr4() {
		return this.cmnctnNmbr4;
	}

	/**
	 * Sets the cmnctn nmbr 4.
	 *
	 * @param cmnctnNmbr4 the new cmnctn nmbr 4
	 */
	public void setCmnctnNmbr4(String cmnctnNmbr4) {
		this.cmnctnNmbr4 = cmnctnNmbr4;
	}

	/**
	 * Gets the cmnctn nmbr 5.
	 *
	 * @return the cmnctn nmbr 5
	 */
	public String getCmnctnNmbr5() {
		return this.cmnctnNmbr5;
	}

	/**
	 * Sets the cmnctn nmbr 5.
	 *
	 * @param cmnctnNmbr5 the new cmnctn nmbr 5
	 */
	public void setCmnctnNmbr5(String cmnctnNmbr5) {
		this.cmnctnNmbr5 = cmnctnNmbr5;
	}

	/**
	 * Gets the cmnctn nmbr 6.
	 *
	 * @return the cmnctn nmbr 6
	 */
	public String getCmnctnNmbr6() {
		return this.cmnctnNmbr6;
	}

	/**
	 * Sets the cmnctn nmbr 6.
	 *
	 * @param cmnctnNmbr6 the new cmnctn nmbr 6
	 */
	public void setCmnctnNmbr6(String cmnctnNmbr6) {
		this.cmnctnNmbr6 = cmnctnNmbr6;
	}

	/**
	 * Gets the oprtnl flag.
	 *
	 * @return the oprtnl flag
	 */
	public String getOprtnlFlag() {
		return this.oprtnlFlag;
	}

	/**
	 * Sets the oprtnl flag.
	 *
	 * @param oprtnlFlag the new oprtnl flag
	 */
	public void setOprtnlFlag(String oprtnlFlag) {
		this.oprtnlFlag = oprtnlFlag;
	}

	/**
	 * Gets the sbmtr contact name 1.
	 *
	 * @return the sbmtr contact name 1
	 */
	public String getSbmtrContactName1() {
		return this.sbmtrContactName1;
	}

	/**
	 * Sets the sbmtr contact name 1.
	 *
	 * @param sbmtrContactName1 the new sbmtr contact name 1
	 */
	public void setSbmtrContactName1(String sbmtrContactName1) {
		this.sbmtrContactName1 = sbmtrContactName1;
	}

	/**
	 * Gets the sbmtr contact name 2.
	 *
	 * @return the sbmtr contact name 2
	 */
	public String getSbmtrContactName2() {
		return this.sbmtrContactName2;
	}

	/**
	 * Sets the sbmtr contact name 2.
	 *
	 * @param sbmtrContactName2 the new sbmtr contact name 2
	 */
	public void setSbmtrContactName2(String sbmtrContactName2) {
		this.sbmtrContactName2 = sbmtrContactName2;
	}

	/**
	 * Gets the sbmtr first name.
	 *
	 * @return the sbmtr first name
	 */
	public String getSbmtrFirstName() {
		return this.sbmtrFirstName;
	}

	/**
	 * Sets the sbmtr first name.
	 *
	 * @param sbmtrFirstName the new sbmtr first name
	 */
	public void setSbmtrFirstName(String sbmtrFirstName) {
		this.sbmtrFirstName = sbmtrFirstName;
	}

	/**
	 * Gets the sbmtr idntfr.
	 *
	 * @return the sbmtr idntfr
	 */
	public String getSbmtrIdntfr() {
		return this.sbmtrIdntfr;
	}

	/**
	 * Sets the sbmtr idntfr.
	 *
	 * @param sbmtrIdntfr the new sbmtr idntfr
	 */
	public void setSbmtrIdntfr(String sbmtrIdntfr) {
		this.sbmtrIdntfr = sbmtrIdntfr;
	}

	/**
	 * Gets the sbmtr last name.
	 *
	 * @return the sbmtr last name
	 */
	public String getSbmtrLastName() {
		return this.sbmtrLastName;
	}

	/**
	 * Sets the sbmtr last name.
	 *
	 * @param sbmtrLastName the new sbmtr last name
	 */
	public void setSbmtrLastName(String sbmtrLastName) {
		this.sbmtrLastName = sbmtrLastName;
	}

	/**
	 * Gets the sbmtr middle name.
	 *
	 * @return the sbmtr middle name
	 */
	public String getSbmtrMiddleName() {
		return this.sbmtrMiddleName;
	}

	/**
	 * Sets the sbmtr middle name.
	 *
	 * @param sbmtrMiddleName the new sbmtr middle name
	 */
	public void setSbmtrMiddleName(String sbmtrMiddleName) {
		this.sbmtrMiddleName = sbmtrMiddleName;
	}

	/**
	 * Gets the clm trnsctn.
	 *
	 * @return the clm trnsctn
	 */
	public ClmTrnsctn getClmTrnsctn() {
		return this.clmTrnsctn;
	}

	/**
	 * Sets the clm trnsctn.
	 *
	 * @param clmTrnsctn the new clm trnsctn
	 */
	public void setClmTrnsctn(ClmTrnsctn clmTrnsctn) {
		this.clmTrnsctn = clmTrnsctn;
	}

	/**
	 * Gets the clm sbmtr sid.
	 *
	 * @return the clm sbmtr sid
	 */
	public long getClmSbmtrSid() {
		return clmSbmtrSid;
	}

	/**
	 * Sets the clm sbmtr sid.
	 *
	 * @param clmSbmtrSid the new clm sbmtr sid
	 */
	public void setClmSbmtrSid(long clmSbmtrSid) {
		this.clmSbmtrSid = clmSbmtrSid;
	}

}