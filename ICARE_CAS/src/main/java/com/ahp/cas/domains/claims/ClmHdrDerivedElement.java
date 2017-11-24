package com.ahp.cas.domains.claims;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonBackReference;

import java.math.BigDecimal;
import java.util.Date;

// TODO: Auto-generated Javadoc
/**
 * The Class ClmHdrDerivedElement.
 */
public class ClmHdrDerivedElement implements Serializable {
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;
	
	/** Claim Header Derived Element SID */
	private long clmHdrDrvdElemSid;
	
	/** The aces medical grp. */
	private String acesMedicalGrp;
	
	/** The aces prgrm type. */
	private String acesPrgrmType;
	
	/** The adjstmnt date. */
	private Date adjstmntDate;
	
	/** The adjudication date. */
	private Date adjudicationDate;
	
	/** The afrs program cid. */
	private BigDecimal afrsProgramCid;
	
	/** The allowed amount. */
	private BigDecimal allowedAmount;
	
	/** The au prgrm type lkpcd. */
	private String auPrgrmTypeLkpcd;
	
	/** The bsp group cid. */
	private BigDecimal bspGroupCid;
	
	/** The cd data flag. */
	private String cdDataFlag;
	
	/** The charge modes csv. */
	private String chargeModesCsv;
	
	/** The check date. */
	private Date checkDate;
	
	/** The check nmbr. */
	private String checkNmbr;
	
	/** The clm ctgry lkpcd. */
	private String clmCtgryLkpcd;
	
	/** The clm type cid. */
	private BigDecimal clmTypeCid;
	
	/** The copay amount. */
	private BigDecimal copayAmount;
	
	/** The cost of care amount. */
	private BigDecimal costOfCareAmount;
	
	/** The created by. */
	private BigDecimal createdBy;
	
	/** The created date. */
	private Date createdDate;
	
	/** The cso residence. */
	private String csoResidence;
	
	/** The denied amount. */
	private BigDecimal deniedAmount;
	
	/** The disposition ctgry lkpcd. */
	private String dispositionCtgryLkpcd;
	
	/** The drg code. */
	private String drgCode;
	
	/** The fmly prctc in rrl area amount. */
	private BigDecimal fmlyPrctcInRrlAreaAmount;
	
	/** The gross adj rsn code. */
	private String grossAdjRsnCode;
	
	/** The hcbs waiver lkpcd. */
	private String hcbsWaiverLkpcd;
	
	/** The high cost outlier amount. */
	private BigDecimal highCostOutlierAmount;
	
	/** The high risk dlvry amount. */
	private BigDecimal highRiskDlvryAmount;
	
	/** The insurance type. */
	private String insuranceType;
	
	/** The last suspended org unit sid. */
	private BigDecimal lastSuspendedOrgUnitSid;
	
	/** The lvng arngmnt lkpcd. */
	private String lvngArngmntLkpcd;
	
	/** The mbr age. */
	private BigDecimal mbrAge;
	
	/** The mbr county code. */
	private String mbrCountyCode;
	
	/** The mbr nh class code. */
	private String mbrNhClassCode;
	
	/** The mbr race code. */
	private String mbrRaceCode;
	
	/** The mc prgrm code. */
	private String mcPrgrmCode;
	
	/** The mc prgrm type lkpcd. */
	private String mcPrgrmTypeLkpcd;
	
	/** The medicare cost avoidance amt. */
	private BigDecimal medicareCostAvoidanceAmt;
	
	/** The mh data flag. */
	private String mhDataFlag;
	
	/** The modified by. */
	private BigDecimal modifiedBy;
	
	/** The modified date. */
	private Date modifiedDate;
	
	/** The net claim charge amount. */
	private BigDecimal netClaimChargeAmount;
	
	/** The newborn screening amount. */
	private BigDecimal newbornScreeningAmount;
	
	/** The org unit sid. */
	private BigDecimal orgUnitSid;
	
	/** The pa rqst idntfr. */
	private String paRqstIdntfr;
	
	/** The pa rqst sid. */
	private BigDecimal paRqstSid;
	
	/** The paid amount. */
	private BigDecimal paidAmount;
	
	/** The paid units. */
	private BigDecimal paidUnits;
	
	/** The pay order date. */
	private Date payOrderDate;
	
	/** The pcop type. */
	private String pcopType;
	
	/** The pricing path lkpcd. */
	private String pricingPathLkpcd;
	
	/** The prvdr county code. */
	private String prvdrCountyCode;
	
	/** The prvdr enrlmnt cid. */
	private BigDecimal prvdrEnrlmntCid;
	
	/** The ra adj rsn code. */
	private String raAdjRsnCode;
	
	/** The rac code. */
	private String racCode;
	
	/** The race lkpcd. */
	private String raceLkpcd;
	
	/** The rprtng unit lkpcd. */
	private String rprtngUnitLkpcd;
	
	/** The sales tax amount. */
	private BigDecimal salesTaxAmount;
	
	/** The social service txnmy code. */
	private String socialServiceTxnmyCode;
	
	/** The state share amount. */
	private BigDecimal stateShareAmount;
	
	/** The tpl cost avoidance amt. */
	private BigDecimal tplCostAvoidanceAmt;
	
	/** The trauma amount. */
	private BigDecimal traumaAmount;
	
	/** The txnmy code. */
	private String txnmyCode;
	
	/** The virtual clm type cid. */
	private BigDecimal virtualClmTypeCid;
	
	private String chartReviewInd;

	/** The claim header. */
	@JsonBackReference
	private ClaimHeader claimHeader;

	/**
	 * Instantiates a new clm hdr derived element.
	 */
	public ClmHdrDerivedElement() {
	}

	/**
	 * Gets the aces medical grp.
	 *
	 * @return the aces medical grp
	 */
	public String getAcesMedicalGrp() {
		return acesMedicalGrp;
	}

	/**
	 * Sets the aces medical grp.
	 *
	 * @param acesMedicalGrp the new aces medical grp
	 */
	public void setAcesMedicalGrp(String acesMedicalGrp) {
		this.acesMedicalGrp = acesMedicalGrp;
	}

	/**
	 * Gets the aces prgrm type.
	 *
	 * @return the aces prgrm type
	 */
	public String getAcesPrgrmType() {
		return acesPrgrmType;
	}

	/**
	 * Sets the aces prgrm type.
	 *
	 * @param acesPrgrmType the new aces prgrm type
	 */
	public void setAcesPrgrmType(String acesPrgrmType) {
		this.acesPrgrmType = acesPrgrmType;
	}

	/**
	 * Gets the adjstmnt date.
	 *
	 * @return the adjstmnt date
	 */
	public Date getAdjstmntDate() {
		return adjstmntDate;
	}

	/**
	 * Sets the adjstmnt date.
	 *
	 * @param adjstmntDate the new adjstmnt date
	 */
	public void setAdjstmntDate(Date adjstmntDate) {
		this.adjstmntDate = adjstmntDate;
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
	 * Gets the afrs program cid.
	 *
	 * @return the afrs program cid
	 */
	public BigDecimal getAfrsProgramCid() {
		return afrsProgramCid;
	}

	/**
	 * Sets the afrs program cid.
	 *
	 * @param afrsProgramCid the new afrs program cid
	 */
	public void setAfrsProgramCid(BigDecimal afrsProgramCid) {
		this.afrsProgramCid = afrsProgramCid;
	}

	/**
	 * Gets the allowed amount.
	 *
	 * @return the allowed amount
	 */
	public BigDecimal getAllowedAmount() {
		return allowedAmount;
	}

	/**
	 * Sets the allowed amount.
	 *
	 * @param allowedAmount the new allowed amount
	 */
	public void setAllowedAmount(BigDecimal allowedAmount) {
		this.allowedAmount = allowedAmount;
	}

	/**
	 * Gets the au prgrm type lkpcd.
	 *
	 * @return the au prgrm type lkpcd
	 */
	public String getAuPrgrmTypeLkpcd() {
		return auPrgrmTypeLkpcd;
	}

	/**
	 * Sets the au prgrm type lkpcd.
	 *
	 * @param auPrgrmTypeLkpcd the new au prgrm type lkpcd
	 */
	public void setAuPrgrmTypeLkpcd(String auPrgrmTypeLkpcd) {
		this.auPrgrmTypeLkpcd = auPrgrmTypeLkpcd;
	}

	/**
	 * Gets the bsp group cid.
	 *
	 * @return the bsp group cid
	 */
	public BigDecimal getBspGroupCid() {
		return bspGroupCid;
	}

	/**
	 * Sets the bsp group cid.
	 *
	 * @param bspGroupCid the new bsp group cid
	 */
	public void setBspGroupCid(BigDecimal bspGroupCid) {
		this.bspGroupCid = bspGroupCid;
	}

	/**
	 * Gets the cd data flag.
	 *
	 * @return the cd data flag
	 */
	public String getCdDataFlag() {
		return cdDataFlag;
	}

	/**
	 * Sets the cd data flag.
	 *
	 * @param cdDataFlag the new cd data flag
	 */
	public void setCdDataFlag(String cdDataFlag) {
		this.cdDataFlag = cdDataFlag;
	}

	/**
	 * Gets the charge modes csv.
	 *
	 * @return the charge modes csv
	 */
	public String getChargeModesCsv() {
		return chargeModesCsv;
	}

	/**
	 * Sets the charge modes csv.
	 *
	 * @param chargeModesCsv the new charge modes csv
	 */
	public void setChargeModesCsv(String chargeModesCsv) {
		this.chargeModesCsv = chargeModesCsv;
	}

	/**
	 * Gets the check date.
	 *
	 * @return the check date
	 */
	public Date getCheckDate() {
		return checkDate;
	}

	/**
	 * Sets the check date.
	 *
	 * @param checkDate the new check date
	 */
	public void setCheckDate(Date checkDate) {
		this.checkDate = checkDate;
	}

	/**
	 * Gets the check nmbr.
	 *
	 * @return the check nmbr
	 */
	public String getCheckNmbr() {
		return checkNmbr;
	}

	/**
	 * Sets the check nmbr.
	 *
	 * @param checkNmbr the new check nmbr
	 */
	public void setCheckNmbr(String checkNmbr) {
		this.checkNmbr = checkNmbr;
	}

	/**
	 * Gets the clm ctgry lkpcd.
	 *
	 * @return the clm ctgry lkpcd
	 */
	public String getClmCtgryLkpcd() {
		return clmCtgryLkpcd;
	}

	/**
	 * Sets the clm ctgry lkpcd.
	 *
	 * @param clmCtgryLkpcd the new clm ctgry lkpcd
	 */
	public void setClmCtgryLkpcd(String clmCtgryLkpcd) {
		this.clmCtgryLkpcd = clmCtgryLkpcd;
	}

	/**
	 * Gets the clm type cid.
	 *
	 * @return the clm type cid
	 */
	public BigDecimal getClmTypeCid() {
		return clmTypeCid;
	}

	/**
	 * Sets the clm type cid.
	 *
	 * @param clmTypeCid the new clm type cid
	 */
	public void setClmTypeCid(BigDecimal clmTypeCid) {
		this.clmTypeCid = clmTypeCid;
	}

	/**
	 * Gets the copay amount.
	 *
	 * @return the copay amount
	 */
	public BigDecimal getCopayAmount() {
		return copayAmount;
	}

	/**
	 * Sets the copay amount.
	 *
	 * @param copayAmount the new copay amount
	 */
	public void setCopayAmount(BigDecimal copayAmount) {
		this.copayAmount = copayAmount;
	}

	/**
	 * Gets the cost of care amount.
	 *
	 * @return the cost of care amount
	 */
	public BigDecimal getCostOfCareAmount() {
		return costOfCareAmount;
	}

	/**
	 * Sets the cost of care amount.
	 *
	 * @param costOfCareAmount the new cost of care amount
	 */
	public void setCostOfCareAmount(BigDecimal costOfCareAmount) {
		this.costOfCareAmount = costOfCareAmount;
	}

	/**
	 * Gets the created by.
	 *
	 * @return the created by
	 */
	public BigDecimal getCreatedBy() {
		return createdBy;
	}

	/**
	 * Sets the created by.
	 *
	 * @param createdBy the new created by
	 */
	public void setCreatedBy(BigDecimal createdBy) {
		this.createdBy = createdBy;
	}

	/**
	 * Gets the created date.
	 *
	 * @return the created date
	 */
	public Date getCreatedDate() {
		return createdDate;
	}

	/**
	 * Sets the created date.
	 *
	 * @param createdDate the new created date
	 */
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	/**
	 * Gets the cso residence.
	 *
	 * @return the cso residence
	 */
	public String getCsoResidence() {
		return csoResidence;
	}

	/**
	 * Sets the cso residence.
	 *
	 * @param csoResidence the new cso residence
	 */
	public void setCsoResidence(String csoResidence) {
		this.csoResidence = csoResidence;
	}

	/**
	 * Gets the denied amount.
	 *
	 * @return the denied amount
	 */
	public BigDecimal getDeniedAmount() {
		return deniedAmount;
	}

	/**
	 * Sets the denied amount.
	 *
	 * @param deniedAmount the new denied amount
	 */
	public void setDeniedAmount(BigDecimal deniedAmount) {
		this.deniedAmount = deniedAmount;
	}

	/**
	 * Gets the disposition ctgry lkpcd.
	 *
	 * @return the disposition ctgry lkpcd
	 */
	public String getDispositionCtgryLkpcd() {
		return dispositionCtgryLkpcd;
	}

	/**
	 * Sets the disposition ctgry lkpcd.
	 *
	 * @param dispositionCtgryLkpcd the new disposition ctgry lkpcd
	 */
	public void setDispositionCtgryLkpcd(String dispositionCtgryLkpcd) {
		this.dispositionCtgryLkpcd = dispositionCtgryLkpcd;
	}

	/**
	 * Gets the drg code.
	 *
	 * @return the drg code
	 */
	public String getDrgCode() {
		return drgCode;
	}

	/**
	 * Sets the drg code.
	 *
	 * @param drgCode the new drg code
	 */
	public void setDrgCode(String drgCode) {
		this.drgCode = drgCode;
	}

	/**
	 * Gets the fmly prctc in rrl area amount.
	 *
	 * @return the fmly prctc in rrl area amount
	 */
	public BigDecimal getFmlyPrctcInRrlAreaAmount() {
		return fmlyPrctcInRrlAreaAmount;
	}

	/**
	 * Sets the fmly prctc in rrl area amount.
	 *
	 * @param fmlyPrctcInRrlAreaAmount the new fmly prctc in rrl area amount
	 */
	public void setFmlyPrctcInRrlAreaAmount(BigDecimal fmlyPrctcInRrlAreaAmount) {
		this.fmlyPrctcInRrlAreaAmount = fmlyPrctcInRrlAreaAmount;
	}

	/**
	 * Gets the gross adj rsn code.
	 *
	 * @return the gross adj rsn code
	 */
	public String getGrossAdjRsnCode() {
		return grossAdjRsnCode;
	}

	/**
	 * Sets the gross adj rsn code.
	 *
	 * @param grossAdjRsnCode the new gross adj rsn code
	 */
	public void setGrossAdjRsnCode(String grossAdjRsnCode) {
		this.grossAdjRsnCode = grossAdjRsnCode;
	}

	/**
	 * Gets the hcbs waiver lkpcd.
	 *
	 * @return the hcbs waiver lkpcd
	 */
	public String getHcbsWaiverLkpcd() {
		return hcbsWaiverLkpcd;
	}

	/**
	 * Sets the hcbs waiver lkpcd.
	 *
	 * @param hcbsWaiverLkpcd the new hcbs waiver lkpcd
	 */
	public void setHcbsWaiverLkpcd(String hcbsWaiverLkpcd) {
		this.hcbsWaiverLkpcd = hcbsWaiverLkpcd;
	}

	/**
	 * Gets the high cost outlier amount.
	 *
	 * @return the high cost outlier amount
	 */
	public BigDecimal getHighCostOutlierAmount() {
		return highCostOutlierAmount;
	}

	/**
	 * Sets the high cost outlier amount.
	 *
	 * @param highCostOutlierAmount the new high cost outlier amount
	 */
	public void setHighCostOutlierAmount(BigDecimal highCostOutlierAmount) {
		this.highCostOutlierAmount = highCostOutlierAmount;
	}

	/**
	 * Gets the high risk dlvry amount.
	 *
	 * @return the high risk dlvry amount
	 */
	public BigDecimal getHighRiskDlvryAmount() {
		return highRiskDlvryAmount;
	}

	/**
	 * Sets the high risk dlvry amount.
	 *
	 * @param highRiskDlvryAmount the new high risk dlvry amount
	 */
	public void setHighRiskDlvryAmount(BigDecimal highRiskDlvryAmount) {
		this.highRiskDlvryAmount = highRiskDlvryAmount;
	}

	/**
	 * Gets the insurance type.
	 *
	 * @return the insurance type
	 */
	public String getInsuranceType() {
		return insuranceType;
	}

	/**
	 * Sets the insurance type.
	 *
	 * @param insuranceType the new insurance type
	 */
	public void setInsuranceType(String insuranceType) {
		this.insuranceType = insuranceType;
	}

	/**
	 * Gets the last suspended org unit sid.
	 *
	 * @return the last suspended org unit sid
	 */
	public BigDecimal getLastSuspendedOrgUnitSid() {
		return lastSuspendedOrgUnitSid;
	}

	/**
	 * Sets the last suspended org unit sid.
	 *
	 * @param lastSuspendedOrgUnitSid the new last suspended org unit sid
	 */
	public void setLastSuspendedOrgUnitSid(BigDecimal lastSuspendedOrgUnitSid) {
		this.lastSuspendedOrgUnitSid = lastSuspendedOrgUnitSid;
	}

	/**
	 * Gets the lvng arngmnt lkpcd.
	 *
	 * @return the lvng arngmnt lkpcd
	 */
	public String getLvngArngmntLkpcd() {
		return lvngArngmntLkpcd;
	}

	/**
	 * Sets the lvng arngmnt lkpcd.
	 *
	 * @param lvngArngmntLkpcd the new lvng arngmnt lkpcd
	 */
	public void setLvngArngmntLkpcd(String lvngArngmntLkpcd) {
		this.lvngArngmntLkpcd = lvngArngmntLkpcd;
	}

	/**
	 * Gets the mbr age.
	 *
	 * @return the mbr age
	 */
	public BigDecimal getMbrAge() {
		return mbrAge;
	}

	/**
	 * Sets the mbr age.
	 *
	 * @param mbrAge the new mbr age
	 */
	public void setMbrAge(BigDecimal mbrAge) {
		this.mbrAge = mbrAge;
	}

	/**
	 * Gets the mbr county code.
	 *
	 * @return the mbr county code
	 */
	public String getMbrCountyCode() {
		return mbrCountyCode;
	}

	/**
	 * Sets the mbr county code.
	 *
	 * @param mbrCountyCode the new mbr county code
	 */
	public void setMbrCountyCode(String mbrCountyCode) {
		this.mbrCountyCode = mbrCountyCode;
	}

	/**
	 * Gets the mbr nh class code.
	 *
	 * @return the mbr nh class code
	 */
	public String getMbrNhClassCode() {
		return mbrNhClassCode;
	}

	/**
	 * Sets the mbr nh class code.
	 *
	 * @param mbrNhClassCode the new mbr nh class code
	 */
	public void setMbrNhClassCode(String mbrNhClassCode) {
		this.mbrNhClassCode = mbrNhClassCode;
	}

	/**
	 * Gets the mbr race code.
	 *
	 * @return the mbr race code
	 */
	public String getMbrRaceCode() {
		return mbrRaceCode;
	}

	/**
	 * Sets the mbr race code.
	 *
	 * @param mbrRaceCode the new mbr race code
	 */
	public void setMbrRaceCode(String mbrRaceCode) {
		this.mbrRaceCode = mbrRaceCode;
	}

	/**
	 * Gets the mc prgrm code.
	 *
	 * @return the mc prgrm code
	 */
	public String getMcPrgrmCode() {
		return mcPrgrmCode;
	}

	/**
	 * Sets the mc prgrm code.
	 *
	 * @param mcPrgrmCode the new mc prgrm code
	 */
	public void setMcPrgrmCode(String mcPrgrmCode) {
		this.mcPrgrmCode = mcPrgrmCode;
	}

	/**
	 * Gets the mc prgrm type lkpcd.
	 *
	 * @return the mc prgrm type lkpcd
	 */
	public String getMcPrgrmTypeLkpcd() {
		return mcPrgrmTypeLkpcd;
	}

	/**
	 * Sets the mc prgrm type lkpcd.
	 *
	 * @param mcPrgrmTypeLkpcd the new mc prgrm type lkpcd
	 */
	public void setMcPrgrmTypeLkpcd(String mcPrgrmTypeLkpcd) {
		this.mcPrgrmTypeLkpcd = mcPrgrmTypeLkpcd;
	}

	/**
	 * Gets the medicare cost avoidance amt.
	 *
	 * @return the medicare cost avoidance amt
	 */
	public BigDecimal getMedicareCostAvoidanceAmt() {
		return medicareCostAvoidanceAmt;
	}

	/**
	 * Sets the medicare cost avoidance amt.
	 *
	 * @param medicareCostAvoidanceAmt the new medicare cost avoidance amt
	 */
	public void setMedicareCostAvoidanceAmt(BigDecimal medicareCostAvoidanceAmt) {
		this.medicareCostAvoidanceAmt = medicareCostAvoidanceAmt;
	}

	/**
	 * Gets the mh data flag.
	 *
	 * @return the mh data flag
	 */
	public String getMhDataFlag() {
		return mhDataFlag;
	}

	/**
	 * Sets the mh data flag.
	 *
	 * @param mhDataFlag the new mh data flag
	 */
	public void setMhDataFlag(String mhDataFlag) {
		this.mhDataFlag = mhDataFlag;
	}

	/**
	 * Gets the modified by.
	 *
	 * @return the modified by
	 */
	public BigDecimal getModifiedBy() {
		return modifiedBy;
	}

	/**
	 * Sets the modified by.
	 *
	 * @param modifiedBy the new modified by
	 */
	public void setModifiedBy(BigDecimal modifiedBy) {
		this.modifiedBy = modifiedBy;
	}

	/**
	 * Gets the modified date.
	 *
	 * @return the modified date
	 */
	public Date getModifiedDate() {
		return modifiedDate;
	}

	/**
	 * Sets the modified date.
	 *
	 * @param modifiedDate the new modified date
	 */
	public void setModifiedDate(Date modifiedDate) {
		this.modifiedDate = modifiedDate;
	}

	/**
	 * Gets the net claim charge amount.
	 *
	 * @return the net claim charge amount
	 */
	public BigDecimal getNetClaimChargeAmount() {
		return netClaimChargeAmount;
	}

	/**
	 * Sets the net claim charge amount.
	 *
	 * @param netClaimChargeAmount the new net claim charge amount
	 */
	public void setNetClaimChargeAmount(BigDecimal netClaimChargeAmount) {
		this.netClaimChargeAmount = netClaimChargeAmount;
	}

	/**
	 * Gets the newborn screening amount.
	 *
	 * @return the newborn screening amount
	 */
	public BigDecimal getNewbornScreeningAmount() {
		return newbornScreeningAmount;
	}

	/**
	 * Sets the newborn screening amount.
	 *
	 * @param newbornScreeningAmount the new newborn screening amount
	 */
	public void setNewbornScreeningAmount(BigDecimal newbornScreeningAmount) {
		this.newbornScreeningAmount = newbornScreeningAmount;
	}

	/**
	 * Gets the org unit sid.
	 *
	 * @return the org unit sid
	 */
	public BigDecimal getOrgUnitSid() {
		return orgUnitSid;
	}

	/**
	 * Sets the org unit sid.
	 *
	 * @param orgUnitSid the new org unit sid
	 */
	public void setOrgUnitSid(BigDecimal orgUnitSid) {
		this.orgUnitSid = orgUnitSid;
	}

	/**
	 * Gets the pa rqst idntfr.
	 *
	 * @return the pa rqst idntfr
	 */
	public String getPaRqstIdntfr() {
		return paRqstIdntfr;
	}

	/**
	 * Sets the pa rqst idntfr.
	 *
	 * @param paRqstIdntfr the new pa rqst idntfr
	 */
	public void setPaRqstIdntfr(String paRqstIdntfr) {
		this.paRqstIdntfr = paRqstIdntfr;
	}

	/**
	 * Gets the pa rqst sid.
	 *
	 * @return the pa rqst sid
	 */
	public BigDecimal getPaRqstSid() {
		return paRqstSid;
	}

	/**
	 * Sets the pa rqst sid.
	 *
	 * @param paRqstSid the new pa rqst sid
	 */
	public void setPaRqstSid(BigDecimal paRqstSid) {
		this.paRqstSid = paRqstSid;
	}

	/**
	 * Gets the paid amount.
	 *
	 * @return the paid amount
	 */
	public BigDecimal getPaidAmount() {
		return paidAmount;
	}

	/**
	 * Sets the paid amount.
	 *
	 * @param paidAmount the new paid amount
	 */
	public void setPaidAmount(BigDecimal paidAmount) {
		this.paidAmount = paidAmount;
	}

	/**
	 * Gets the paid units.
	 *
	 * @return the paid units
	 */
	public BigDecimal getPaidUnits() {
		return paidUnits;
	}

	/**
	 * Sets the paid units.
	 *
	 * @param paidUnits the new paid units
	 */
	public void setPaidUnits(BigDecimal paidUnits) {
		this.paidUnits = paidUnits;
	}

	/**
	 * Gets the pay order date.
	 *
	 * @return the pay order date
	 */
	public Date getPayOrderDate() {
		return payOrderDate;
	}

	/**
	 * Sets the pay order date.
	 *
	 * @param payOrderDate the new pay order date
	 */
	public void setPayOrderDate(Date payOrderDate) {
		this.payOrderDate = payOrderDate;
	}

	/**
	 * Gets the pcop type.
	 *
	 * @return the pcop type
	 */
	public String getPcopType() {
		return pcopType;
	}

	/**
	 * Sets the pcop type.
	 *
	 * @param pcopType the new pcop type
	 */
	public void setPcopType(String pcopType) {
		this.pcopType = pcopType;
	}

	/**
	 * Gets the pricing path lkpcd.
	 *
	 * @return the pricing path lkpcd
	 */
	public String getPricingPathLkpcd() {
		return pricingPathLkpcd;
	}

	/**
	 * Sets the pricing path lkpcd.
	 *
	 * @param pricingPathLkpcd the new pricing path lkpcd
	 */
	public void setPricingPathLkpcd(String pricingPathLkpcd) {
		this.pricingPathLkpcd = pricingPathLkpcd;
	}

	/**
	 * Gets the prvdr county code.
	 *
	 * @return the prvdr county code
	 */
	public String getPrvdrCountyCode() {
		return prvdrCountyCode;
	}

	/**
	 * Sets the prvdr county code.
	 *
	 * @param prvdrCountyCode the new prvdr county code
	 */
	public void setPrvdrCountyCode(String prvdrCountyCode) {
		this.prvdrCountyCode = prvdrCountyCode;
	}

	/**
	 * Gets the prvdr enrlmnt cid.
	 *
	 * @return the prvdr enrlmnt cid
	 */
	public BigDecimal getPrvdrEnrlmntCid() {
		return prvdrEnrlmntCid;
	}

	/**
	 * Sets the prvdr enrlmnt cid.
	 *
	 * @param prvdrEnrlmntCid the new prvdr enrlmnt cid
	 */
	public void setPrvdrEnrlmntCid(BigDecimal prvdrEnrlmntCid) {
		this.prvdrEnrlmntCid = prvdrEnrlmntCid;
	}

	/**
	 * Gets the ra adj rsn code.
	 *
	 * @return the ra adj rsn code
	 */
	public String getRaAdjRsnCode() {
		return raAdjRsnCode;
	}

	/**
	 * Sets the ra adj rsn code.
	 *
	 * @param raAdjRsnCode the new ra adj rsn code
	 */
	public void setRaAdjRsnCode(String raAdjRsnCode) {
		this.raAdjRsnCode = raAdjRsnCode;
	}

	/**
	 * Gets the rac code.
	 *
	 * @return the rac code
	 */
	public String getRacCode() {
		return racCode;
	}

	/**
	 * Sets the rac code.
	 *
	 * @param racCode the new rac code
	 */
	public void setRacCode(String racCode) {
		this.racCode = racCode;
	}

	/**
	 * Gets the race lkpcd.
	 *
	 * @return the race lkpcd
	 */
	public String getRaceLkpcd() {
		return raceLkpcd;
	}

	/**
	 * Sets the race lkpcd.
	 *
	 * @param raceLkpcd the new race lkpcd
	 */
	public void setRaceLkpcd(String raceLkpcd) {
		this.raceLkpcd = raceLkpcd;
	}

	/**
	 * Gets the rprtng unit lkpcd.
	 *
	 * @return the rprtng unit lkpcd
	 */
	public String getRprtngUnitLkpcd() {
		return rprtngUnitLkpcd;
	}

	/**
	 * Sets the rprtng unit lkpcd.
	 *
	 * @param rprtngUnitLkpcd the new rprtng unit lkpcd
	 */
	public void setRprtngUnitLkpcd(String rprtngUnitLkpcd) {
		this.rprtngUnitLkpcd = rprtngUnitLkpcd;
	}

	/**
	 * Gets the sales tax amount.
	 *
	 * @return the sales tax amount
	 */
	public BigDecimal getSalesTaxAmount() {
		return salesTaxAmount;
	}

	/**
	 * Sets the sales tax amount.
	 *
	 * @param salesTaxAmount the new sales tax amount
	 */
	public void setSalesTaxAmount(BigDecimal salesTaxAmount) {
		this.salesTaxAmount = salesTaxAmount;
	}

	/**
	 * Gets the social service txnmy code.
	 *
	 * @return the social service txnmy code
	 */
	public String getSocialServiceTxnmyCode() {
		return socialServiceTxnmyCode;
	}

	/**
	 * Sets the social service txnmy code.
	 *
	 * @param socialServiceTxnmyCode the new social service txnmy code
	 */
	public void setSocialServiceTxnmyCode(String socialServiceTxnmyCode) {
		this.socialServiceTxnmyCode = socialServiceTxnmyCode;
	}

	/**
	 * Gets the state share amount.
	 *
	 * @return the state share amount
	 */
	public BigDecimal getStateShareAmount() {
		return stateShareAmount;
	}

	/**
	 * Sets the state share amount.
	 *
	 * @param stateShareAmount the new state share amount
	 */
	public void setStateShareAmount(BigDecimal stateShareAmount) {
		this.stateShareAmount = stateShareAmount;
	}

	/**
	 * Gets the tpl cost avoidance amt.
	 *
	 * @return the tpl cost avoidance amt
	 */
	public BigDecimal getTplCostAvoidanceAmt() {
		return tplCostAvoidanceAmt;
	}

	/**
	 * Sets the tpl cost avoidance amt.
	 *
	 * @param tplCostAvoidanceAmt the new tpl cost avoidance amt
	 */
	public void setTplCostAvoidanceAmt(BigDecimal tplCostAvoidanceAmt) {
		this.tplCostAvoidanceAmt = tplCostAvoidanceAmt;
	}

	/**
	 * Gets the trauma amount.
	 *
	 * @return the trauma amount
	 */
	public BigDecimal getTraumaAmount() {
		return traumaAmount;
	}

	/**
	 * Sets the trauma amount.
	 *
	 * @param traumaAmount the new trauma amount
	 */
	public void setTraumaAmount(BigDecimal traumaAmount) {
		this.traumaAmount = traumaAmount;
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
	 * Gets the virtual clm type cid.
	 *
	 * @return the virtual clm type cid
	 */
	public BigDecimal getVirtualClmTypeCid() {
		return virtualClmTypeCid;
	}

	/**
	 * Sets the virtual clm type cid.
	 *
	 * @param virtualClmTypeCid the new virtual clm type cid
	 */
	public void setVirtualClmTypeCid(BigDecimal virtualClmTypeCid) {
		this.virtualClmTypeCid = virtualClmTypeCid;
	}

	public String getChartReviewInd() {
		return chartReviewInd;
	}

	public void setChartReviewInd(String chartReviewInd) {
		this.chartReviewInd = chartReviewInd;
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
	
	public long getClmHdrDrvdElemSid() {
		return clmHdrDrvdElemSid;
	}

	public void setClmHdrDrvdElemSid(long clmHdrDrvdElemSid) {
		this.clmHdrDrvdElemSid = clmHdrDrvdElemSid;
	}

}