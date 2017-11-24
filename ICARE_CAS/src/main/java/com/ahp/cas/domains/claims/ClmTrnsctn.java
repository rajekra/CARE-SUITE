package com.ahp.cas.domains.claims;

import java.io.Serializable;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;
import java.util.List;

// TODO: Auto-generated Javadoc
/**
 * The Class ClmTrnsctn.
 */
public class ClmTrnsctn implements Serializable {
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The clm trnsctn sid. */
	private long clmTrnsctnSid;

	/** The clm encntr indctr. */
	@JsonProperty("ClaimOrEncounterIdentifier")
	private String clmEncntrIndctr;

	/** The grp sndr idntfr. */
	@JsonProperty("GroupSenderIdentifier")
	private String grpSndrIdntfr;

	/** The implmntn guide vrsn name. */
	@JsonProperty("ImplementationGuideVersion")
	private String implmntnGuideVrsnName;

	/** The intrchng cntrl vrsn nmbr. */
	@JsonProperty("InterchangeVersionNumber")
	private String intrchngCntrlVrsnNmbr;

	/** The intrchng sndr idntfr. */
	@JsonProperty("InterchangeSenderID")
	private String intrchngSndrIdntfr;

	/** The orgntr aplctn trnsctn idntfr. */
	@JsonProperty("OriginatorApplicationID")
	private String orgntrAplctnTrnsctnIdntfr;

	/** The trnsctn cntrl nmbr. */
	@JsonProperty("TransactionSetControlNo")
	private String trnsctnCntrlNmbr;

	/** The trnsctn set creation date. */
	@JsonProperty("TransactionSetDateTime")
	private Date trnsctnSetCreationDate;

	/** The trnsctn set purpose code. */
	@JsonProperty("TransactionSetPurposeCode")
	private String trnsctnSetPurposeCode;

	/** The vrsn rls indstry idntfr code. */
	@JsonProperty("GroupVersionReleaseIndustryCode")
	private String vrsnRlsIndstryIdntfrCode;

	/** The clm sbmtrs. */
	@JsonIgnore
	private List<ClmSbmtr> clmSbmtrs;

	/** The input acknwldgmnt sid. */
	private BigDecimal inputAcknwldgmntSid;

	/** The claim header. */
	// bi-directional many-to-one association to AdClmHdrXProcedure
	@JsonBackReference
	private ClaimHeader claimHeader;

	/**
	 * Instantiates a new clm trnsctn.
	 */
	public ClmTrnsctn() {
	}

	/**
	 * Gets the clm trnsctn sid.
	 *
	 * @return the clm trnsctn sid
	 */
	public long getClmTrnsctnSid() {
		return this.clmTrnsctnSid;
	}

	/**
	 * Sets the clm trnsctn sid.
	 *
	 * @param clmTrnsctnSid the new clm trnsctn sid
	 */
	public void setClmTrnsctnSid(long clmTrnsctnSid) {
		this.clmTrnsctnSid = clmTrnsctnSid;
	}

	/**
	 * Gets the clm encntr indctr.
	 *
	 * @return the clm encntr indctr
	 */
	public String getClmEncntrIndctr() {
		return this.clmEncntrIndctr;
	}

	/**
	 * Sets the clm encntr indctr.
	 *
	 * @param clmEncntrIndctr the new clm encntr indctr
	 */
	public void setClmEncntrIndctr(String clmEncntrIndctr) {
		this.clmEncntrIndctr = clmEncntrIndctr;
	}

	/**
	 * Gets the grp sndr idntfr.
	 *
	 * @return the grp sndr idntfr
	 */
	public String getGrpSndrIdntfr() {
		return this.grpSndrIdntfr;
	}

	/**
	 * Sets the grp sndr idntfr.
	 *
	 * @param grpSndrIdntfr the new grp sndr idntfr
	 */
	public void setGrpSndrIdntfr(String grpSndrIdntfr) {
		this.grpSndrIdntfr = grpSndrIdntfr;
	}

	/**
	 * Gets the implmntn guide vrsn name.
	 *
	 * @return the implmntn guide vrsn name
	 */
	public String getImplmntnGuideVrsnName() {
		return this.implmntnGuideVrsnName;
	}

	/**
	 * Sets the implmntn guide vrsn name.
	 *
	 * @param implmntnGuideVrsnName the new implmntn guide vrsn name
	 */
	public void setImplmntnGuideVrsnName(String implmntnGuideVrsnName) {
		this.implmntnGuideVrsnName = implmntnGuideVrsnName;
	}

	/**
	 * Gets the intrchng cntrl vrsn nmbr.
	 *
	 * @return the intrchng cntrl vrsn nmbr
	 */
	public String getIntrchngCntrlVrsnNmbr() {
		return this.intrchngCntrlVrsnNmbr;
	}

	/**
	 * Sets the intrchng cntrl vrsn nmbr.
	 *
	 * @param intrchngCntrlVrsnNmbr the new intrchng cntrl vrsn nmbr
	 */
	public void setIntrchngCntrlVrsnNmbr(String intrchngCntrlVrsnNmbr) {
		this.intrchngCntrlVrsnNmbr = intrchngCntrlVrsnNmbr;
	}

	/**
	 * Gets the intrchng sndr idntfr.
	 *
	 * @return the intrchng sndr idntfr
	 */
	public String getIntrchngSndrIdntfr() {
		return this.intrchngSndrIdntfr;
	}

	/**
	 * Sets the intrchng sndr idntfr.
	 *
	 * @param intrchngSndrIdntfr the new intrchng sndr idntfr
	 */
	public void setIntrchngSndrIdntfr(String intrchngSndrIdntfr) {
		this.intrchngSndrIdntfr = intrchngSndrIdntfr;
	}

	/**
	 * Gets the orgntr aplctn trnsctn idntfr.
	 *
	 * @return the orgntr aplctn trnsctn idntfr
	 */
	public String getOrgntrAplctnTrnsctnIdntfr() {
		return this.orgntrAplctnTrnsctnIdntfr;
	}

	/**
	 * Sets the orgntr aplctn trnsctn idntfr.
	 *
	 * @param orgntrAplctnTrnsctnIdntfr the new orgntr aplctn trnsctn idntfr
	 */
	public void setOrgntrAplctnTrnsctnIdntfr(String orgntrAplctnTrnsctnIdntfr) {
		this.orgntrAplctnTrnsctnIdntfr = orgntrAplctnTrnsctnIdntfr;
	}

	/**
	 * Gets the trnsctn cntrl nmbr.
	 *
	 * @return the trnsctn cntrl nmbr
	 */
	public String getTrnsctnCntrlNmbr() {
		return this.trnsctnCntrlNmbr;
	}

	/**
	 * Sets the trnsctn cntrl nmbr.
	 *
	 * @param trnsctnCntrlNmbr the new trnsctn cntrl nmbr
	 */
	public void setTrnsctnCntrlNmbr(String trnsctnCntrlNmbr) {
		this.trnsctnCntrlNmbr = trnsctnCntrlNmbr;
	}

	/**
	 * Gets the trnsctn set creation date.
	 *
	 * @return the trnsctn set creation date
	 */
	public Date getTrnsctnSetCreationDate() {
		return this.trnsctnSetCreationDate;
	}

	/**
	 * Sets the trnsctn set creation date.
	 *
	 * @param trnsctnSetCreationDate the new trnsctn set creation date
	 */
	public void setTrnsctnSetCreationDate(Date trnsctnSetCreationDate) {
		this.trnsctnSetCreationDate = trnsctnSetCreationDate;
	}

	/**
	 * Gets the trnsctn set purpose code.
	 *
	 * @return the trnsctn set purpose code
	 */
	public String getTrnsctnSetPurposeCode() {
		return this.trnsctnSetPurposeCode;
	}

	/**
	 * Sets the trnsctn set purpose code.
	 *
	 * @param trnsctnSetPurposeCode the new trnsctn set purpose code
	 */
	public void setTrnsctnSetPurposeCode(String trnsctnSetPurposeCode) {
		this.trnsctnSetPurposeCode = trnsctnSetPurposeCode;
	}

	/**
	 * Gets the vrsn rls indstry idntfr code.
	 *
	 * @return the vrsn rls indstry idntfr code
	 */
	public String getVrsnRlsIndstryIdntfrCode() {
		return this.vrsnRlsIndstryIdntfrCode;
	}

	/**
	 * Sets the vrsn rls indstry idntfr code.
	 *
	 * @param vrsnRlsIndstryIdntfrCode the new vrsn rls indstry idntfr code
	 */
	public void setVrsnRlsIndstryIdntfrCode(String vrsnRlsIndstryIdntfrCode) {
		this.vrsnRlsIndstryIdntfrCode = vrsnRlsIndstryIdntfrCode;
	}

	/**
	 * Gets the clm sbmtrs.
	 *
	 * @return the clm sbmtrs
	 */
	public List<ClmSbmtr> getClmSbmtrs() {
		return this.clmSbmtrs;
	}

	/**
	 * Sets the clm sbmtrs.
	 *
	 * @param clmSbmtrs the new clm sbmtrs
	 */
	public void setClmSbmtrs(List<ClmSbmtr> clmSbmtrs) {
		this.clmSbmtrs = clmSbmtrs;
	}

	/**
	 * Adds the clm sbmtr.
	 *
	 * @param clmSbmtr the clm sbmtr
	 * @return the clm sbmtr
	 */
	public ClmSbmtr addClmSbmtr(ClmSbmtr clmSbmtr) {
		getClmSbmtrs().add(clmSbmtr);
		clmSbmtr.setClmTrnsctn(this);

		return clmSbmtr;
	}

	/**
	 * Removes the clm sbmtr.
	 *
	 * @param clmSbmtr the clm sbmtr
	 * @return the clm sbmtr
	 */
	public ClmSbmtr removeClmSbmtr(ClmSbmtr clmSbmtr) {
		getClmSbmtrs().remove(clmSbmtr);
		clmSbmtr.setClmTrnsctn(null);

		return clmSbmtr;
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
	 * Gets the input acknwldgmnt sid.
	 *
	 * @return the input acknwldgmnt sid
	 */
	public BigDecimal getInputAcknwldgmntSid() {
		return inputAcknwldgmntSid;
	}

	/**
	 * Sets the input acknwldgmnt sid.
	 *
	 * @param inputAcknwldgmntSid the new input acknwldgmnt sid
	 */
	public void setInputAcknwldgmntSid(BigDecimal inputAcknwldgmntSid) {
		this.inputAcknwldgmntSid = inputAcknwldgmntSid;
	}

}