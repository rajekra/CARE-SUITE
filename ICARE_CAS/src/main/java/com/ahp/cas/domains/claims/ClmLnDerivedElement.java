package com.ahp.cas.domains.claims;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonBackReference;

// TODO: Auto-generated Javadoc
/**
 * The Class ClmLnDerivedElement.
 */
public class ClmLnDerivedElement implements Serializable {
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;
	
	/** The claim line derived element sid */
	private long clmLnDrvdElemSid;
	
	/** The actual allowed amount. */
	private BigDecimal actualAllowedAmount;
	
	/** The adjstmnt date. */
	private Date adjstmntDate;
	
	/** The adjudication date. */
	private Date adjudicationDate;
	
	/** The afrs program cid. */
	private BigDecimal afrsProgramCid;
	
	/** The allowed amount. */
	private BigDecimal allowedAmount;
	
	/** The ansthsa units. */
	private BigDecimal ansthsaUnits;
	
	/** The apc code. */
	private String apcCode;
	
	/** The approved amount. */
	private BigDecimal approvedAmount;
	
	/** The au prgrm type lkpcd. */
	private String auPrgrmTypeLkpcd;
	
	/** The blanket code. */
	private String blanketCode;
	
	/** The blng spclty subspclty sid. */
	private BigDecimal blngSpcltySubspcltySid;
	
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
	
	/** The clm type cid. */
	private BigDecimal clmTypeCid;
	
	/** The clsfctn group cid. */
	private BigDecimal clsfctnGroupCid;
	
	/** The copay amount. */
	private BigDecimal copayAmount;
	
	/** The cost of care amount. */
	private BigDecimal costOfCareAmount;
	
	/** The created by. */
	private BigDecimal createdBy;
	
	/** The created date. */
	private Date createdDate;
	
	/** The crtfd seed amount. */
	private BigDecimal crtfdSeedAmount;
	
	/** The cutback srvc units. */
	private BigDecimal cutbackSrvcUnits;
	
	/** The denied amount. */
	private BigDecimal deniedAmount;
	
	/** The fmly prctc in rrl area amount. */
	private BigDecimal fmlyPrctcInRrlAreaAmount;
	
	/** The follow up date. */
	private Date followUpDate;
	
	/** The follow up days. */
	private BigDecimal followUpDays;
	
	/** The high cost outlier amount. */
	private BigDecimal highCostOutlierAmount;
	
	/** The high risk dlvry amount. */
	private BigDecimal highRiskDlvryAmount;
	
	/** The high risk ob care enhncmnt amt. */
	private BigDecimal highRiskObCareEnhncmntAmt;
	
	/** The medicare cost avoidance amt. */
	private BigDecimal medicareCostAvoidanceAmt;
	
	/** The mh data flag. */
	private String mhDataFlag;
	
	/** The modified by. */
	private BigDecimal modifiedBy;
	
	/** The modified date. */
	private Date modifiedDate;
	
	/** The ndc units. */
	private BigDecimal ndcUnits;
	
	/** The net claim charge amount. */
	private BigDecimal netClaimChargeAmount;
	
	/** The newborn screening amount. */
	private BigDecimal newbornScreeningAmount;
	
	/** The oth pyr paid amount. */
	private BigDecimal othPyrPaidAmount;
	
	/** The pa rqst idntfr. */
	private String paRqstIdntfr;
	
	/** The pa rqst sid. */
	private BigDecimal paRqstSid;
	
	/** The paid amount. */
	private BigDecimal paidAmount;
	
	/** The paid srvc units. */
	private BigDecimal paidSrvcUnits;
	
	/** The patient paid amount. */
	private BigDecimal patientPaidAmount;
	
	/** The pay order date. */
	private Date payOrderDate;
	
	/** The pricing path lkpcd. */
	private String pricingPathLkpcd;
	
	/** The prtcptn amt. */
	private BigDecimal prtcptnAmt;
	
	/** The rac code. */
	private String racCode;
	
	/** The room board amt. */
	private BigDecimal roomBoardAmt;
	
	/** The sales tax amount. */
	private BigDecimal salesTaxAmount;
	
	/** The social service txnmy code. */
	private String socialServiceTxnmyCode;
	
	/** The srvcng spclty subspclty sid. */
	private BigDecimal srvcngSpcltySubspcltySid;
	
	/** The ssbp athrztn hdr sid. */
	private BigDecimal ssbpAthrztnHdrSid;
	
	/** The ssbp athrztn line nmbr. */
	private BigDecimal ssbpAthrztnLineNmbr;
	
	/** The ssbp athrztn line sid. */
	private BigDecimal ssbpAthrztnLineSid;
	
	/** The ssbp athrztn line suffix nmbr. */
	private BigDecimal ssbpAthrztnLineSuffixNmbr;
	
	/** The ssbp reason code. */
	private String ssbpReasonCode;
	
	/** The state share amount. */
	private BigDecimal stateShareAmount;
	
	/** The tax amount. */
	private BigDecimal taxAmount;
	
	/** The tax rate. */
	private BigDecimal taxRate;
	
	/** The tcn rate paid. */
	private BigDecimal tcnRatePaid;
	
	/** The third party rsrc amt. */
	private BigDecimal thirdPartyRsrcAmt;
	
	/** The tpl cost avoidance amt. */
	private BigDecimal tplCostAvoidanceAmt;
	
	/** The trauma amount. */
	private BigDecimal traumaAmount;
	
	/** The trtmnt type code. */
	private String trtmntTypeCode;
	
	/** The txnmy code. */
	private String txnmyCode;
	
	/** The virtual clm type cid. */
	private BigDecimal virtualClmTypeCid;
	
	/** The claim line. */
	@JsonBackReference
	private ClaimLine claimLine;

	/**
	 * Instantiates a new clm ln derived element.
	 */
	public ClmLnDerivedElement() {
	}

	/**
	 * Gets the actual allowed amount.
	 *
	 * @return the actual allowed amount
	 */
	public BigDecimal getActualAllowedAmount() {
		return actualAllowedAmount;
	}

	/**
	 * Sets the actual allowed amount.
	 *
	 * @param actualAllowedAmount the new actual allowed amount
	 */
	public void setActualAllowedAmount(BigDecimal actualAllowedAmount) {
		this.actualAllowedAmount = actualAllowedAmount;
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
	 * Gets the ansthsa units.
	 *
	 * @return the ansthsa units
	 */
	public BigDecimal getAnsthsaUnits() {
		return ansthsaUnits;
	}

	/**
	 * Sets the ansthsa units.
	 *
	 * @param ansthsaUnits the new ansthsa units
	 */
	public void setAnsthsaUnits(BigDecimal ansthsaUnits) {
		this.ansthsaUnits = ansthsaUnits;
	}

	/**
	 * Gets the apc code.
	 *
	 * @return the apc code
	 */
	public String getApcCode() {
		return apcCode;
	}

	/**
	 * Sets the apc code.
	 *
	 * @param apcCode the new apc code
	 */
	public void setApcCode(String apcCode) {
		this.apcCode = apcCode;
	}

	/**
	 * Gets the approved amount.
	 *
	 * @return the approved amount
	 */
	public BigDecimal getApprovedAmount() {
		return approvedAmount;
	}

	/**
	 * Sets the approved amount.
	 *
	 * @param approvedAmount the new approved amount
	 */
	public void setApprovedAmount(BigDecimal approvedAmount) {
		this.approvedAmount = approvedAmount;
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
	 * Gets the blanket code.
	 *
	 * @return the blanket code
	 */
	public String getBlanketCode() {
		return blanketCode;
	}

	/**
	 * Sets the blanket code.
	 *
	 * @param blanketCode the new blanket code
	 */
	public void setBlanketCode(String blanketCode) {
		this.blanketCode = blanketCode;
	}

	/**
	 * Gets the blng spclty subspclty sid.
	 *
	 * @return the blng spclty subspclty sid
	 */
	public BigDecimal getBlngSpcltySubspcltySid() {
		return blngSpcltySubspcltySid;
	}

	/**
	 * Sets the blng spclty subspclty sid.
	 *
	 * @param blngSpcltySubspcltySid the new blng spclty subspclty sid
	 */
	public void setBlngSpcltySubspcltySid(BigDecimal blngSpcltySubspcltySid) {
		this.blngSpcltySubspcltySid = blngSpcltySubspcltySid;
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
	 * Gets the clsfctn group cid.
	 *
	 * @return the clsfctn group cid
	 */
	public BigDecimal getClsfctnGroupCid() {
		return clsfctnGroupCid;
	}

	/**
	 * Sets the clsfctn group cid.
	 *
	 * @param clsfctnGroupCid the new clsfctn group cid
	 */
	public void setClsfctnGroupCid(BigDecimal clsfctnGroupCid) {
		this.clsfctnGroupCid = clsfctnGroupCid;
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
	 * Gets the crtfd seed amount.
	 *
	 * @return the crtfd seed amount
	 */
	public BigDecimal getCrtfdSeedAmount() {
		return crtfdSeedAmount;
	}

	/**
	 * Sets the crtfd seed amount.
	 *
	 * @param crtfdSeedAmount the new crtfd seed amount
	 */
	public void setCrtfdSeedAmount(BigDecimal crtfdSeedAmount) {
		this.crtfdSeedAmount = crtfdSeedAmount;
	}

	/**
	 * Gets the cutback srvc units.
	 *
	 * @return the cutback srvc units
	 */
	public BigDecimal getCutbackSrvcUnits() {
		return cutbackSrvcUnits;
	}

	/**
	 * Sets the cutback srvc units.
	 *
	 * @param cutbackSrvcUnits the new cutback srvc units
	 */
	public void setCutbackSrvcUnits(BigDecimal cutbackSrvcUnits) {
		this.cutbackSrvcUnits = cutbackSrvcUnits;
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
	 * Gets the follow up date.
	 *
	 * @return the follow up date
	 */
	public Date getFollowUpDate() {
		return followUpDate;
	}

	/**
	 * Sets the follow up date.
	 *
	 * @param followUpDate the new follow up date
	 */
	public void setFollowUpDate(Date followUpDate) {
		this.followUpDate = followUpDate;
	}

	/**
	 * Gets the follow up days.
	 *
	 * @return the follow up days
	 */
	public BigDecimal getFollowUpDays() {
		return followUpDays;
	}

	/**
	 * Sets the follow up days.
	 *
	 * @param followUpDays the new follow up days
	 */
	public void setFollowUpDays(BigDecimal followUpDays) {
		this.followUpDays = followUpDays;
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
	 * Gets the high risk ob care enhncmnt amt.
	 *
	 * @return the high risk ob care enhncmnt amt
	 */
	public BigDecimal getHighRiskObCareEnhncmntAmt() {
		return highRiskObCareEnhncmntAmt;
	}

	/**
	 * Sets the high risk ob care enhncmnt amt.
	 *
	 * @param highRiskObCareEnhncmntAmt the new high risk ob care enhncmnt amt
	 */
	public void setHighRiskObCareEnhncmntAmt(
			BigDecimal highRiskObCareEnhncmntAmt) {
		this.highRiskObCareEnhncmntAmt = highRiskObCareEnhncmntAmt;
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
	 * Gets the ndc units.
	 *
	 * @return the ndc units
	 */
	public BigDecimal getNdcUnits() {
		return ndcUnits;
	}

	/**
	 * Sets the ndc units.
	 *
	 * @param ndcUnits the new ndc units
	 */
	public void setNdcUnits(BigDecimal ndcUnits) {
		this.ndcUnits = ndcUnits;
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
	 * Gets the oth pyr paid amount.
	 *
	 * @return the oth pyr paid amount
	 */
	public BigDecimal getOthPyrPaidAmount() {
		return othPyrPaidAmount;
	}

	/**
	 * Sets the oth pyr paid amount.
	 *
	 * @param othPyrPaidAmount the new oth pyr paid amount
	 */
	public void setOthPyrPaidAmount(BigDecimal othPyrPaidAmount) {
		this.othPyrPaidAmount = othPyrPaidAmount;
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
	 * Gets the paid srvc units.
	 *
	 * @return the paid srvc units
	 */
	public BigDecimal getPaidSrvcUnits() {
		return paidSrvcUnits;
	}

	/**
	 * Sets the paid srvc units.
	 *
	 * @param paidSrvcUnits the new paid srvc units
	 */
	public void setPaidSrvcUnits(BigDecimal paidSrvcUnits) {
		this.paidSrvcUnits = paidSrvcUnits;
	}

	/**
	 * Gets the patient paid amount.
	 *
	 * @return the patient paid amount
	 */
	public BigDecimal getPatientPaidAmount() {
		return patientPaidAmount;
	}

	/**
	 * Sets the patient paid amount.
	 *
	 * @param patientPaidAmount the new patient paid amount
	 */
	public void setPatientPaidAmount(BigDecimal patientPaidAmount) {
		this.patientPaidAmount = patientPaidAmount;
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
	 * Gets the prtcptn amt.
	 *
	 * @return the prtcptn amt
	 */
	public BigDecimal getPrtcptnAmt() {
		return prtcptnAmt;
	}

	/**
	 * Sets the prtcptn amt.
	 *
	 * @param prtcptnAmt the new prtcptn amt
	 */
	public void setPrtcptnAmt(BigDecimal prtcptnAmt) {
		this.prtcptnAmt = prtcptnAmt;
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
	 * Gets the room board amt.
	 *
	 * @return the room board amt
	 */
	public BigDecimal getRoomBoardAmt() {
		return roomBoardAmt;
	}

	/**
	 * Sets the room board amt.
	 *
	 * @param roomBoardAmt the new room board amt
	 */
	public void setRoomBoardAmt(BigDecimal roomBoardAmt) {
		this.roomBoardAmt = roomBoardAmt;
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
	 * Gets the srvcng spclty subspclty sid.
	 *
	 * @return the srvcng spclty subspclty sid
	 */
	public BigDecimal getSrvcngSpcltySubspcltySid() {
		return srvcngSpcltySubspcltySid;
	}

	/**
	 * Sets the srvcng spclty subspclty sid.
	 *
	 * @param srvcngSpcltySubspcltySid the new srvcng spclty subspclty sid
	 */
	public void setSrvcngSpcltySubspcltySid(BigDecimal srvcngSpcltySubspcltySid) {
		this.srvcngSpcltySubspcltySid = srvcngSpcltySubspcltySid;
	}

	/**
	 * Gets the ssbp athrztn hdr sid.
	 *
	 * @return the ssbp athrztn hdr sid
	 */
	public BigDecimal getSsbpAthrztnHdrSid() {
		return ssbpAthrztnHdrSid;
	}

	/**
	 * Sets the ssbp athrztn hdr sid.
	 *
	 * @param ssbpAthrztnHdrSid the new ssbp athrztn hdr sid
	 */
	public void setSsbpAthrztnHdrSid(BigDecimal ssbpAthrztnHdrSid) {
		this.ssbpAthrztnHdrSid = ssbpAthrztnHdrSid;
	}

	/**
	 * Gets the ssbp athrztn line nmbr.
	 *
	 * @return the ssbp athrztn line nmbr
	 */
	public BigDecimal getSsbpAthrztnLineNmbr() {
		return ssbpAthrztnLineNmbr;
	}

	/**
	 * Sets the ssbp athrztn line nmbr.
	 *
	 * @param ssbpAthrztnLineNmbr the new ssbp athrztn line nmbr
	 */
	public void setSsbpAthrztnLineNmbr(BigDecimal ssbpAthrztnLineNmbr) {
		this.ssbpAthrztnLineNmbr = ssbpAthrztnLineNmbr;
	}

	/**
	 * Gets the ssbp athrztn line sid.
	 *
	 * @return the ssbp athrztn line sid
	 */
	public BigDecimal getSsbpAthrztnLineSid() {
		return ssbpAthrztnLineSid;
	}

	/**
	 * Sets the ssbp athrztn line sid.
	 *
	 * @param ssbpAthrztnLineSid the new ssbp athrztn line sid
	 */
	public void setSsbpAthrztnLineSid(BigDecimal ssbpAthrztnLineSid) {
		this.ssbpAthrztnLineSid = ssbpAthrztnLineSid;
	}

	/**
	 * Gets the ssbp athrztn line suffix nmbr.
	 *
	 * @return the ssbp athrztn line suffix nmbr
	 */
	public BigDecimal getSsbpAthrztnLineSuffixNmbr() {
		return ssbpAthrztnLineSuffixNmbr;
	}

	/**
	 * Sets the ssbp athrztn line suffix nmbr.
	 *
	 * @param ssbpAthrztnLineSuffixNmbr the new ssbp athrztn line suffix nmbr
	 */
	public void setSsbpAthrztnLineSuffixNmbr(
			BigDecimal ssbpAthrztnLineSuffixNmbr) {
		this.ssbpAthrztnLineSuffixNmbr = ssbpAthrztnLineSuffixNmbr;
	}

	/**
	 * Gets the ssbp reason code.
	 *
	 * @return the ssbp reason code
	 */
	public String getSsbpReasonCode() {
		return ssbpReasonCode;
	}

	/**
	 * Sets the ssbp reason code.
	 *
	 * @param ssbpReasonCode the new ssbp reason code
	 */
	public void setSsbpReasonCode(String ssbpReasonCode) {
		this.ssbpReasonCode = ssbpReasonCode;
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
	 * Gets the tax amount.
	 *
	 * @return the tax amount
	 */
	public BigDecimal getTaxAmount() {
		return taxAmount;
	}

	/**
	 * Sets the tax amount.
	 *
	 * @param taxAmount the new tax amount
	 */
	public void setTaxAmount(BigDecimal taxAmount) {
		this.taxAmount = taxAmount;
	}

	/**
	 * Gets the tax rate.
	 *
	 * @return the tax rate
	 */
	public BigDecimal getTaxRate() {
		return taxRate;
	}

	/**
	 * Sets the tax rate.
	 *
	 * @param taxRate the new tax rate
	 */
	public void setTaxRate(BigDecimal taxRate) {
		this.taxRate = taxRate;
	}

	/**
	 * Gets the tcn rate paid.
	 *
	 * @return the tcn rate paid
	 */
	public BigDecimal getTcnRatePaid() {
		return tcnRatePaid;
	}

	/**
	 * Sets the tcn rate paid.
	 *
	 * @param tcnRatePaid the new tcn rate paid
	 */
	public void setTcnRatePaid(BigDecimal tcnRatePaid) {
		this.tcnRatePaid = tcnRatePaid;
	}

	/**
	 * Gets the third party rsrc amt.
	 *
	 * @return the third party rsrc amt
	 */
	public BigDecimal getThirdPartyRsrcAmt() {
		return thirdPartyRsrcAmt;
	}

	/**
	 * Sets the third party rsrc amt.
	 *
	 * @param thirdPartyRsrcAmt the new third party rsrc amt
	 */
	public void setThirdPartyRsrcAmt(BigDecimal thirdPartyRsrcAmt) {
		this.thirdPartyRsrcAmt = thirdPartyRsrcAmt;
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
	 * Gets the trtmnt type code.
	 *
	 * @return the trtmnt type code
	 */
	public String getTrtmntTypeCode() {
		return trtmntTypeCode;
	}

	/**
	 * Sets the trtmnt type code.
	 *
	 * @param trtmntTypeCode the new trtmnt type code
	 */
	public void setTrtmntTypeCode(String trtmntTypeCode) {
		this.trtmntTypeCode = trtmntTypeCode;
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
	
	public long getClmLnDrvdElemSid() {
		return clmLnDrvdElemSid;
	}

	public void setClmLnDrvdElemSid(long clmLnDrvdElemSid) {
		this.clmLnDrvdElemSid = clmLnDrvdElemSid;
	}

}