package com.ahp.cas.domains.claims;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * The persistent class for the CLAIM_HEADER database table.
 * 
 */
//
public class ClaimHeaderWithJSONAnnotation implements Serializable {
	private static final long serialVersionUID = 1L;

	private BigDecimal programCid;
	
	private long claimHeaderSid;

	@JsonProperty("AdjustmentSourceType")
	private String adjustmentSourceTypeLkpcd;

	@JsonProperty("AdmissionDate")
	private Date admissionDate;

	@JsonProperty("AdmissionHour")
	private String admissionHour;
	
	
	private BigDecimal aplctnStatusCid;
	private BigDecimal aplctnStatusTypeCid;
	private String athrztnNmbr;
	
	@JsonProperty("TransactionSetCreationDate")
	private Date billDate;
	private String billTypeFourthDigitLkpcd;
	
	@JsonProperty("BillingProviderNPI")
	private BigDecimal blngNationalPrvdrIdntfr;
	
	//@JsonProperty("BillingProviderFirstName")
	private String blngPrvdrFirstName;
	
	//@JsonProperty("BillingProviderIdentifierType")
	private BigDecimal blngPrvdrIdntfrTypeCid;
	
	//@JsonProperty("BillingProviderLastName")
	private String blngPrvdrLastName;
	
	@JsonProperty("BillingProviderLocationID")
	private String blngPrvdrLctnIdentifier;
	private BigDecimal blngPrvdrLctnIid;
	
	@JsonProperty("BillingProviderTaxonomyCode")
	private String blngPrvdrLctnTxnmyCode;
	private String blngPrvdrLegacyId;
	
	//@JsonProperty("BillingProviderMiddleName")
	private String blngPrvdrMiddleName;
	private String blngPrvdrName;
	private String blngPrvdrSuffixLkpcd;
	private BigDecimal blngPrvdrTypeCode;
	private BigDecimal bsnsStatusCid;
	private BigDecimal bsnsStatusTypeCid;
	private BigDecimal chkdoutBy;
	private String chkdoutStatusLkpcd;
	
	@JsonProperty("ClaimFrequencyCode")
	private String claimSubmissionReasonLkpcd;
	private BigDecimal clmSbmtrSid;
	
	@JsonProperty("ClaimSourceCode")
	private String clmSourceCode;
	private BigDecimal clmTrnsctnSid;
	private BigDecimal clmTypeCid;
	private BigDecimal createdBy;
	private Date createdDate;
	
//	@JsonProperty("ClaimCurrencyType")
	private String currencyTypeLkpcd;
	private String denialReasonCd1;
	private String denialReasonCd2;
	
	@JsonProperty("DischargeDate")
	private Date dischargeDate;
	
	@JsonProperty("DiagnosisRelatedGroupCode")
	private String drgCode;
	
	@JsonProperty("FacilityTypeCode")
	private String facilityTypeCode;
	
	@JsonProperty("ServiceStartDate")
	private Date fromServiceDate;
	
	@JsonProperty("X12Version")
	private String hipaaVersion;
	private String inbndFileLineNmbr;
	private String insuranceCoverageCode;
	
	@JsonProperty("ClaimType")
	private String invoiceTypeLkpcd;
	private Date lastPaymentDate;
	private Date lastRunDate;
	
	@JsonProperty("LastRunNmbr")
	private BigDecimal lastRunNmbr;
	private Date lastSuspendDate;
	private String massAdjstmntFlag;
	
	@JsonProperty("SubscriberPrimaryID")
	private String mbrIdentifier;
	
	@JsonProperty("SubscriberPrimaryIDType")
	private BigDecimal mbrIdntfrTypeCid;
	private String mbrLegacyIdntfr;
	private BigDecimal mbrSid;
	
	@JsonProperty("MedicalRecordNumber")
	private String medicalRecordNmbr;
	private BigDecimal modifiedBy;
	private Date modifiedDate;
	
	@JsonProperty("OriginalTcn")
	private String originalTcn;
	
	
	@JsonProperty("PayerClaimControlNo")
	private String parentTcn;
	
	@JsonProperty("PatientControlNo")
	private String patientAccountNmbr;
	
	@JsonProperty("PatientBirthDate")
	private Date patientBirthDate;
	
	@JsonProperty("PatientDeathDate")
	private Date patientDeathDate;
	
	@JsonProperty("PatientFirstName")
	private String patientFirstName;
	
	@JsonProperty("PatientGender")
	private String patientGender;
	
	@JsonProperty("PatientLastName")
	private String patientLastName;
	
	@JsonProperty("PatientMiddleName")
	private String patientMiddleName;
	
	@JsonProperty("PatientRelationshipCode")
	private String patientRelationshipLkpcd;
	
	@JsonProperty("PatientSuffix")
	private String patientSuffixLkpcd;
	private BigDecimal primaryDiagnosisIid;
	private String primaryDiagnosisPoaLkpcd;
	
	@JsonProperty("PriorAuthorizationNo")
	private String primaryPaRqstIdentifier;
	private BigDecimal primaryPaRqstSid;
	private String primaryRfrlIdntfctnNmbr;
	private BigDecimal sbmtFcltyBillClsfctnSid;
	
	@JsonProperty("ServiceAuthExceptionCode")
	private String serviceAthrztnExcptnLkpcd;
	
	@JsonProperty("SpecialProgramIndicator")
	private String specialProgramLkpcd;
	
	@JsonProperty("RenderingProviderNPI")
	private BigDecimal srvcngNationalPrvdrIdntfr;
	
	@JsonProperty("RenderingProviderFirstName")
	private String srvcngPrvdrFirstName;
	
	@JsonProperty("RenderingProviderType")
	private BigDecimal srvcngPrvdrIdntfrTypeCid;
	
	@JsonProperty("RenderingProviderLastName")
	private String srvcngPrvdrLastName;
	private String srvcngPrvdrLctnIdentifier;
	private BigDecimal srvcngPrvdrLctnIid;
	
	@JsonProperty("RenderingProviderTaxonomyCode")
	private String srvcngPrvdrLctnTxnmyCode;
	private String srvcngPrvdrLegacyId;
	
	@JsonProperty("RenderingProviderMiddleName")
	private String srvcngPrvdrMiddleName;
	
	@JsonProperty("RenderingProviderSuffix")
	private String srvcngPrvdrSuffixLkpcd;
	private BigDecimal ssbpAthrztnHdrSid;
	private Date statusEffectiveDate;
	
	@JsonProperty("SystemInDate")
	private Date systemInDate;
	
	@JsonProperty("TCN")
	private String tcn;
	
	@JsonProperty("TcnDate")
	private Date tcnDate;
	
	@JsonProperty("ServiceEndDate")
	private Date toServiceDate;
	
	@JsonProperty("TotalClaimChargeAmount")
	private BigDecimal totalBilledAmount;
	private BigDecimal totalBilledUnit;
	@JsonManagedReference
	private Set<ClaimLine> claimLines;
//	private Set<ClmHdrAcdntLctnRltdCaus> clmHdrAcdntLctnRltdCauses;
//	private Set<ClmHdrAdmissionDetail> clmHdrAdmissionDetails;
//	private Set<ClmHdrAdtnlAdjReason> clmHdrAdtnlAdjReasons;
//	private Set<ClmHdrAdtnlRemarkCode> clmHdrAdtnlRemarkCodes;
//	private Set<ClmHdrAmbulanceDtl> clmHdrAmbulanceDtls;
//	private Set<ClmHdrAmbulancePtntCndtn> clmHdrAmbulancePtntCndtns;
//	private Set<ClmHdrAmount> clmHdrAmounts;
//	private Set<ClmHdrAttachment> clmHdrAttachments;
//	private Set<ClmHdrCondition> clmHdrConditions;
//	private Set<ClmHdrConflict> clmHdrConflicts;
//	private Set<ClmHdrCutback> clmHdrCutbacks;
//	private Set<ClmHdrDate> clmHdrDates;
	@JsonManagedReference
	private ClmHdrDerivedElement clmHdrDerivedElement;
//	private Set<ClmHdrHptlPcgInptnt> clmHdrHptlPcgInptnts;
//	private Set<ClmHdrOccurrenceDetail> clmHdrOccurrenceDetails;
//	private Set<ClmHdrOtherPayerDtl> clmHdrOtherPayerDtls;
//	private Set<ClmHdrOtherPayerRemark> clmHdrOtherPayerRemarks;
//	private Set<ClmHdrOthPyrAdjDtl> clmHdrOthPyrAdjDtls;
//	private Set<ClmHdrQuantity> clmHdrQuantities;
//	private Set<ClmHdrReferenceInfo> clmHdrReferenceInfos;
//	private Set<ClmHdrRunError> clmHdrRunErrors;
//	private Set<ClmHdrRunErrorAsgndPerson> clmHdrRunErrorAsgndPersons;
//	private Set<ClmHdrSubscriber> clmHdrSubscribers;
//	private Set<ClmHdrValueAmount> clmHdrValueAmounts;
	@JsonManagedReference
	private Set<ClmHdrXDiagnosis> clmHdrXDiagnosis;
//	private Set<ClmHdrXIndicator> clmHdrXIndicators;
//	private Set<ClmHdrXPaRqst> clmHdrXPaRqsts;
//	private Set<ClmHdrXProcedure> clmHdrXProcedures;
//	private Set<ClmHdrXPrvdrLctn> clmHdrXPrvdrLctns;
//	private Set<ClmLnHptlPcgOutptnt> clmLnHptlPcgOutptnts;

	public ClaimHeaderWithJSONAnnotation() {
	}

	public long getClaimHeaderSid() {
		return claimHeaderSid;
	}

	public void setClaimHeaderSid(long claimHeaderSid) {
		this.claimHeaderSid = claimHeaderSid;
	}

	public String getAdjustmentSourceTypeLkpcd() {
		return adjustmentSourceTypeLkpcd;
	}

	public void setAdjustmentSourceTypeLkpcd(String adjustmentSourceTypeLkpcd) {
		this.adjustmentSourceTypeLkpcd = adjustmentSourceTypeLkpcd;
	}

	public Date getAdmissionDate() {
		return admissionDate;
	}

	public void setAdmissionDate(Date admissionDate) {
		this.admissionDate = admissionDate;
	}

	public String getAdmissionHour() {
		return admissionHour;
	}

	public void setAdmissionHour(String admissionHour) {
		this.admissionHour = admissionHour;
	}

	public BigDecimal getAplctnStatusCid() {
		return aplctnStatusCid;
	}

	public void setAplctnStatusCid(BigDecimal aplctnStatusCid) {
		this.aplctnStatusCid = aplctnStatusCid;
	}

	public BigDecimal getAplctnStatusTypeCid() {
		return aplctnStatusTypeCid;
	}

	public void setAplctnStatusTypeCid(BigDecimal aplctnStatusTypeCid) {
		this.aplctnStatusTypeCid = aplctnStatusTypeCid;
	}

	public String getAthrztnNmbr() {
		return athrztnNmbr;
	}

	public void setAthrztnNmbr(String athrztnNmbr) {
		this.athrztnNmbr = athrztnNmbr;
	}

	public Date getBillDate() {
		return billDate;
	}

	public void setBillDate(Date billDate) {
		this.billDate = billDate;
	}

	public String getBillTypeFourthDigitLkpcd() {
		return billTypeFourthDigitLkpcd;
	}

	public void setBillTypeFourthDigitLkpcd(String billTypeFourthDigitLkpcd) {
		this.billTypeFourthDigitLkpcd = billTypeFourthDigitLkpcd;
	}

	public BigDecimal getBlngNationalPrvdrIdntfr() {
		return blngNationalPrvdrIdntfr;
	}

	public void setBlngNationalPrvdrIdntfr(BigDecimal blngNationalPrvdrIdntfr) {
		this.blngNationalPrvdrIdntfr = blngNationalPrvdrIdntfr;
	}

	public String getBlngPrvdrFirstName() {
		return blngPrvdrFirstName;
	}

	public void setBlngPrvdrFirstName(String blngPrvdrFirstName) {
		this.blngPrvdrFirstName = blngPrvdrFirstName;
	}

	public BigDecimal getBlngPrvdrIdntfrTypeCid() {
		return blngPrvdrIdntfrTypeCid;
	}

	public void setBlngPrvdrIdntfrTypeCid(BigDecimal blngPrvdrIdntfrTypeCid) {
		this.blngPrvdrIdntfrTypeCid = blngPrvdrIdntfrTypeCid;
	}

	public String getBlngPrvdrLastName() {
		return blngPrvdrLastName;
	}

	public void setBlngPrvdrLastName(String blngPrvdrLastName) {
		this.blngPrvdrLastName = blngPrvdrLastName;
	}

	public String getBlngPrvdrLctnIdentifier() {
		return blngPrvdrLctnIdentifier;
	}

	public void setBlngPrvdrLctnIdentifier(String blngPrvdrLctnIdentifier) {
		this.blngPrvdrLctnIdentifier = blngPrvdrLctnIdentifier;
	}

	public BigDecimal getBlngPrvdrLctnIid() {
		return blngPrvdrLctnIid;
	}

	public void setBlngPrvdrLctnIid(BigDecimal blngPrvdrLctnIid) {
		this.blngPrvdrLctnIid = blngPrvdrLctnIid;
	}

	public String getBlngPrvdrLctnTxnmyCode() {
		return blngPrvdrLctnTxnmyCode;
	}

	public void setBlngPrvdrLctnTxnmyCode(String blngPrvdrLctnTxnmyCode) {
		this.blngPrvdrLctnTxnmyCode = blngPrvdrLctnTxnmyCode;
	}

	public String getBlngPrvdrLegacyId() {
		return blngPrvdrLegacyId;
	}

	public void setBlngPrvdrLegacyId(String blngPrvdrLegacyId) {
		this.blngPrvdrLegacyId = blngPrvdrLegacyId;
	}

	public String getBlngPrvdrMiddleName() {
		return blngPrvdrMiddleName;
	}

	public void setBlngPrvdrMiddleName(String blngPrvdrMiddleName) {
		this.blngPrvdrMiddleName = blngPrvdrMiddleName;
	}

	public String getBlngPrvdrName() {
		return blngPrvdrName;
	}

	public void setBlngPrvdrName(String blngPrvdrName) {
		this.blngPrvdrName = blngPrvdrName;
	}

	public String getBlngPrvdrSuffixLkpcd() {
		return blngPrvdrSuffixLkpcd;
	}

	public void setBlngPrvdrSuffixLkpcd(String blngPrvdrSuffixLkpcd) {
		this.blngPrvdrSuffixLkpcd = blngPrvdrSuffixLkpcd;
	}

	public BigDecimal getBlngPrvdrTypeCode() {
		return blngPrvdrTypeCode;
	}

	public void setBlngPrvdrTypeCode(BigDecimal blngPrvdrTypeCode) {
		this.blngPrvdrTypeCode = blngPrvdrTypeCode;
	}

	public BigDecimal getBsnsStatusCid() {
		return bsnsStatusCid;
	}

	public void setBsnsStatusCid(BigDecimal bsnsStatusCid) {
		this.bsnsStatusCid = bsnsStatusCid;
	}

	public BigDecimal getBsnsStatusTypeCid() {
		return bsnsStatusTypeCid;
	}

	public void setBsnsStatusTypeCid(BigDecimal bsnsStatusTypeCid) {
		this.bsnsStatusTypeCid = bsnsStatusTypeCid;
	}

	public BigDecimal getChkdoutBy() {
		return chkdoutBy;
	}

	public void setChkdoutBy(BigDecimal chkdoutBy) {
		this.chkdoutBy = chkdoutBy;
	}

	public String getChkdoutStatusLkpcd() {
		return chkdoutStatusLkpcd;
	}

	public void setChkdoutStatusLkpcd(String chkdoutStatusLkpcd) {
		this.chkdoutStatusLkpcd = chkdoutStatusLkpcd;
	}

	public String getClaimSubmissionReasonLkpcd() {
		return claimSubmissionReasonLkpcd;
	}

	public void setClaimSubmissionReasonLkpcd(String claimSubmissionReasonLkpcd) {
		this.claimSubmissionReasonLkpcd = claimSubmissionReasonLkpcd;
	}

	public BigDecimal getClmSbmtrSid() {
		return clmSbmtrSid;
	}

	public void setClmSbmtrSid(BigDecimal clmSbmtrSid) {
		this.clmSbmtrSid = clmSbmtrSid;
	}

	public String getClmSourceCode() {
		return clmSourceCode;
	}

	public void setClmSourceCode(String clmSourceCode) {
		this.clmSourceCode = clmSourceCode;
	}

	public BigDecimal getClmTrnsctnSid() {
		return clmTrnsctnSid;
	}

	public void setClmTrnsctnSid(BigDecimal clmTrnsctnSid) {
		this.clmTrnsctnSid = clmTrnsctnSid;
	}

	public BigDecimal getClmTypeCid() {
		return clmTypeCid;
	}

	public void setClmTypeCid(BigDecimal clmTypeCid) {
		this.clmTypeCid = clmTypeCid;
	}

	public BigDecimal getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(BigDecimal createdBy) {
		this.createdBy = createdBy;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public String getCurrencyTypeLkpcd() {
		return currencyTypeLkpcd;
	}

	public void setCurrencyTypeLkpcd(String currencyTypeLkpcd) {
		this.currencyTypeLkpcd = currencyTypeLkpcd;
	}

	public String getDenialReasonCd1() {
		return denialReasonCd1;
	}

	public void setDenialReasonCd1(String denialReasonCd1) {
		this.denialReasonCd1 = denialReasonCd1;
	}

	public String getDenialReasonCd2() {
		return denialReasonCd2;
	}

	public void setDenialReasonCd2(String denialReasonCd2) {
		this.denialReasonCd2 = denialReasonCd2;
	}

	public Date getDischargeDate() {
		return dischargeDate;
	}

	public void setDischargeDate(Date dischargeDate) {
		this.dischargeDate = dischargeDate;
	}

	public String getDrgCode() {
		return drgCode;
	}

	public void setDrgCode(String drgCode) {
		this.drgCode = drgCode;
	}

	public String getFacilityTypeCode() {
		return facilityTypeCode;
	}

	public void setFacilityTypeCode(String facilityTypeCode) {
		this.facilityTypeCode = facilityTypeCode;
	}

	public Date getFromServiceDate() {
		return fromServiceDate;
	}

	public void setFromServiceDate(Date fromServiceDate) {
		this.fromServiceDate = fromServiceDate;
	}

	public String getHipaaVersion() {
		return hipaaVersion;
	}

	public void setHipaaVersion(String hipaaVersion) {
		this.hipaaVersion = hipaaVersion;
	}

	public String getInbndFileLineNmbr() {
		return inbndFileLineNmbr;
	}

	public void setInbndFileLineNmbr(String inbndFileLineNmbr) {
		this.inbndFileLineNmbr = inbndFileLineNmbr;
	}

	public String getInsuranceCoverageCode() {
		return insuranceCoverageCode;
	}

	public void setInsuranceCoverageCode(String insuranceCoverageCode) {
		this.insuranceCoverageCode = insuranceCoverageCode;
	}

	public String getInvoiceTypeLkpcd() {
		return invoiceTypeLkpcd;
	}

	public void setInvoiceTypeLkpcd(String invoiceTypeLkpcd) {
		this.invoiceTypeLkpcd = invoiceTypeLkpcd;
	}

	public Date getLastPaymentDate() {
		return lastPaymentDate;
	}

	public void setLastPaymentDate(Date lastPaymentDate) {
		this.lastPaymentDate = lastPaymentDate;
	}

	public Date getLastRunDate() {
		return lastRunDate;
	}

	public void setLastRunDate(Date lastRunDate) {
		this.lastRunDate = lastRunDate;
	}

	public BigDecimal getLastRunNmbr() {
		return lastRunNmbr;
	}

	public void setLastRunNmbr(BigDecimal lastRunNmbr) {
		this.lastRunNmbr = lastRunNmbr;
	}

	public Date getLastSuspendDate() {
		return lastSuspendDate;
	}

	public void setLastSuspendDate(Date lastSuspendDate) {
		this.lastSuspendDate = lastSuspendDate;
	}

	public String getMassAdjstmntFlag() {
		return massAdjstmntFlag;
	}

	public void setMassAdjstmntFlag(String massAdjstmntFlag) {
		this.massAdjstmntFlag = massAdjstmntFlag;
	}

	public String getMbrIdentifier() {
		return mbrIdentifier;
	}

	public void setMbrIdentifier(String mbrIdentifier) {
		this.mbrIdentifier = mbrIdentifier;
	}

	public BigDecimal getMbrIdntfrTypeCid() {
		return mbrIdntfrTypeCid;
	}

	public void setMbrIdntfrTypeCid(BigDecimal mbrIdntfrTypeCid) {
		this.mbrIdntfrTypeCid = mbrIdntfrTypeCid;
	}

	public String getMbrLegacyIdntfr() {
		return mbrLegacyIdntfr;
	}

	public void setMbrLegacyIdntfr(String mbrLegacyIdntfr) {
		this.mbrLegacyIdntfr = mbrLegacyIdntfr;
	}

	public BigDecimal getMbrSid() {
		return mbrSid;
	}

	public void setMbrSid(BigDecimal mbrSid) {
		this.mbrSid = mbrSid;
	}

	public String getMedicalRecordNmbr() {
		return medicalRecordNmbr;
	}

	public void setMedicalRecordNmbr(String medicalRecordNmbr) {
		this.medicalRecordNmbr = medicalRecordNmbr;
	}

	public BigDecimal getModifiedBy() {
		return modifiedBy;
	}

	public void setModifiedBy(BigDecimal modifiedBy) {
		this.modifiedBy = modifiedBy;
	}

	public Date getModifiedDate() {
		return modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		this.modifiedDate = modifiedDate;
	}

	public String getOriginalTcn() {
		return originalTcn;
	}

	public void setOriginalTcn(String originalTcn) {
		this.originalTcn = originalTcn;
	}

	public String getParentTcn() {
		return parentTcn;
	}

	public void setParentTcn(String parentTcn) {
		this.parentTcn = parentTcn;
	}

	public String getPatientAccountNmbr() {
		return patientAccountNmbr;
	}

	public void setPatientAccountNmbr(String patientAccountNmbr) {
		this.patientAccountNmbr = patientAccountNmbr;
	}

	public Date getPatientBirthDate() {
		return patientBirthDate;
	}

	public void setPatientBirthDate(Date patientBirthDate) {
		this.patientBirthDate = patientBirthDate;
	}

	public Date getPatientDeathDate() {
		return patientDeathDate;
	}

	public void setPatientDeathDate(Date patientDeathDate) {
		this.patientDeathDate = patientDeathDate;
	}

	public String getPatientFirstName() {
		return patientFirstName;
	}

	public void setPatientFirstName(String patientFirstName) {
		this.patientFirstName = patientFirstName;
	}

	public String getPatientGender() {
		return patientGender;
	}

	public void setPatientGender(String patientGender) {
		this.patientGender = patientGender;
	}

	public String getPatientLastName() {
		return patientLastName;
	}

	public void setPatientLastName(String patientLastName) {
		this.patientLastName = patientLastName;
	}

	public String getPatientMiddleName() {
		return patientMiddleName;
	}

	public void setPatientMiddleName(String patientMiddleName) {
		this.patientMiddleName = patientMiddleName;
	}

	public String getPatientRelationshipLkpcd() {
		return patientRelationshipLkpcd;
	}

	public void setPatientRelationshipLkpcd(String patientRelationshipLkpcd) {
		this.patientRelationshipLkpcd = patientRelationshipLkpcd;
	}

	public String getPatientSuffixLkpcd() {
		return patientSuffixLkpcd;
	}

	public void setPatientSuffixLkpcd(String patientSuffixLkpcd) {
		this.patientSuffixLkpcd = patientSuffixLkpcd;
	}

	public BigDecimal getPrimaryDiagnosisIid() {
		return primaryDiagnosisIid;
	}

	public void setPrimaryDiagnosisIid(BigDecimal primaryDiagnosisIid) {
		this.primaryDiagnosisIid = primaryDiagnosisIid;
	}

	public String getPrimaryDiagnosisPoaLkpcd() {
		return primaryDiagnosisPoaLkpcd;
	}

	public void setPrimaryDiagnosisPoaLkpcd(String primaryDiagnosisPoaLkpcd) {
		this.primaryDiagnosisPoaLkpcd = primaryDiagnosisPoaLkpcd;
	}

	public String getPrimaryPaRqstIdentifier() {
		return primaryPaRqstIdentifier;
	}

	public void setPrimaryPaRqstIdentifier(String primaryPaRqstIdentifier) {
		this.primaryPaRqstIdentifier = primaryPaRqstIdentifier;
	}

	public BigDecimal getPrimaryPaRqstSid() {
		return primaryPaRqstSid;
	}

	public void setPrimaryPaRqstSid(BigDecimal primaryPaRqstSid) {
		this.primaryPaRqstSid = primaryPaRqstSid;
	}

	public String getPrimaryRfrlIdntfctnNmbr() {
		return primaryRfrlIdntfctnNmbr;
	}

	public void setPrimaryRfrlIdntfctnNmbr(String primaryRfrlIdntfctnNmbr) {
		this.primaryRfrlIdntfctnNmbr = primaryRfrlIdntfctnNmbr;
	}

	public BigDecimal getSbmtFcltyBillClsfctnSid() {
		return sbmtFcltyBillClsfctnSid;
	}

	public void setSbmtFcltyBillClsfctnSid(BigDecimal sbmtFcltyBillClsfctnSid) {
		this.sbmtFcltyBillClsfctnSid = sbmtFcltyBillClsfctnSid;
	}

	public String getServiceAthrztnExcptnLkpcd() {
		return serviceAthrztnExcptnLkpcd;
	}

	public void setServiceAthrztnExcptnLkpcd(String serviceAthrztnExcptnLkpcd) {
		this.serviceAthrztnExcptnLkpcd = serviceAthrztnExcptnLkpcd;
	}

	public String getSpecialProgramLkpcd() {
		return specialProgramLkpcd;
	}

	public void setSpecialProgramLkpcd(String specialProgramLkpcd) {
		this.specialProgramLkpcd = specialProgramLkpcd;
	}

	public BigDecimal getSrvcngNationalPrvdrIdntfr() {
		return srvcngNationalPrvdrIdntfr;
	}

	public void setSrvcngNationalPrvdrIdntfr(
			BigDecimal srvcngNationalPrvdrIdntfr) {
		this.srvcngNationalPrvdrIdntfr = srvcngNationalPrvdrIdntfr;
	}

	public String getSrvcngPrvdrFirstName() {
		return srvcngPrvdrFirstName;
	}

	public void setSrvcngPrvdrFirstName(String srvcngPrvdrFirstName) {
		this.srvcngPrvdrFirstName = srvcngPrvdrFirstName;
	}

	public BigDecimal getSrvcngPrvdrIdntfrTypeCid() {
		return srvcngPrvdrIdntfrTypeCid;
	}

	public void setSrvcngPrvdrIdntfrTypeCid(BigDecimal srvcngPrvdrIdntfrTypeCid) {
		this.srvcngPrvdrIdntfrTypeCid = srvcngPrvdrIdntfrTypeCid;
	}

	public String getSrvcngPrvdrLastName() {
		return srvcngPrvdrLastName;
	}

	public void setSrvcngPrvdrLastName(String srvcngPrvdrLastName) {
		this.srvcngPrvdrLastName = srvcngPrvdrLastName;
	}

	public String getSrvcngPrvdrLctnIdentifier() {
		return srvcngPrvdrLctnIdentifier;
	}

	public void setSrvcngPrvdrLctnIdentifier(String srvcngPrvdrLctnIdentifier) {
		this.srvcngPrvdrLctnIdentifier = srvcngPrvdrLctnIdentifier;
	}

	public BigDecimal getSrvcngPrvdrLctnIid() {
		return srvcngPrvdrLctnIid;
	}

	public void setSrvcngPrvdrLctnIid(BigDecimal srvcngPrvdrLctnIid) {
		this.srvcngPrvdrLctnIid = srvcngPrvdrLctnIid;
	}

	public String getSrvcngPrvdrLctnTxnmyCode() {
		return srvcngPrvdrLctnTxnmyCode;
	}

	public void setSrvcngPrvdrLctnTxnmyCode(String srvcngPrvdrLctnTxnmyCode) {
		this.srvcngPrvdrLctnTxnmyCode = srvcngPrvdrLctnTxnmyCode;
	}

	public String getSrvcngPrvdrLegacyId() {
		return srvcngPrvdrLegacyId;
	}

	public void setSrvcngPrvdrLegacyId(String srvcngPrvdrLegacyId) {
		this.srvcngPrvdrLegacyId = srvcngPrvdrLegacyId;
	}

	public String getSrvcngPrvdrMiddleName() {
		return srvcngPrvdrMiddleName;
	}

	public void setSrvcngPrvdrMiddleName(String srvcngPrvdrMiddleName) {
		this.srvcngPrvdrMiddleName = srvcngPrvdrMiddleName;
	}

	public String getSrvcngPrvdrSuffixLkpcd() {
		return srvcngPrvdrSuffixLkpcd;
	}

	public void setSrvcngPrvdrSuffixLkpcd(String srvcngPrvdrSuffixLkpcd) {
		this.srvcngPrvdrSuffixLkpcd = srvcngPrvdrSuffixLkpcd;
	}

	public BigDecimal getSsbpAthrztnHdrSid() {
		return ssbpAthrztnHdrSid;
	}

	public void setSsbpAthrztnHdrSid(BigDecimal ssbpAthrztnHdrSid) {
		this.ssbpAthrztnHdrSid = ssbpAthrztnHdrSid;
	}

	public Date getStatusEffectiveDate() {
		return statusEffectiveDate;
	}

	public void setStatusEffectiveDate(Date statusEffectiveDate) {
		this.statusEffectiveDate = statusEffectiveDate;
	}

	public Date getSystemInDate() {
		return systemInDate;
	}

	public void setSystemInDate(Date systemInDate) {
		this.systemInDate = systemInDate;
	}

	public String getTcn() {
		return tcn;
	}

	public void setTcn(String tcn) {
		this.tcn = tcn;
	}

	public Date getTcnDate() {
		return tcnDate;
	}

	public void setTcnDate(Date tcnDate) {
		this.tcnDate = tcnDate;
	}

	public Date getToServiceDate() {
		return toServiceDate;
	}

	public void setToServiceDate(Date toServiceDate) {
		this.toServiceDate = toServiceDate;
	}

	public BigDecimal getTotalBilledAmount() {
		return totalBilledAmount;
	}

	public void setTotalBilledAmount(BigDecimal totalBilledAmount) {
		this.totalBilledAmount = totalBilledAmount;
	}

	public BigDecimal getTotalBilledUnit() {
		return totalBilledUnit;
	}

	public void setTotalBilledUnit(BigDecimal totalBilledUnit) {
		this.totalBilledUnit = totalBilledUnit;
	}

	public Set<ClaimLine> getClaimLines() {
		return claimLines;
	}

	public void setClaimLines(Set<ClaimLine> claimLines) {
		this.claimLines = claimLines;
	}
//
//	public Set<ClmHdrAcdntLctnRltdCaus> getClmHdrAcdntLctnRltdCauses() {
//		return clmHdrAcdntLctnRltdCauses;
//	}
//
//	public void setClmHdrAcdntLctnRltdCauses(
//			Set<ClmHdrAcdntLctnRltdCaus> clmHdrAcdntLctnRltdCauses) {
//		this.clmHdrAcdntLctnRltdCauses = clmHdrAcdntLctnRltdCauses;
//	}
//
//	public Set<ClmHdrAdmissionDetail> getClmHdrAdmissionDetails() {
//		return clmHdrAdmissionDetails;
//	}
//
//	public void setClmHdrAdmissionDetails(
//			Set<ClmHdrAdmissionDetail> clmHdrAdmissionDetails) {
//		this.clmHdrAdmissionDetails = clmHdrAdmissionDetails;
//	}
//
//	public Set<ClmHdrAdtnlAdjReason> getClmHdrAdtnlAdjReasons() {
//		return clmHdrAdtnlAdjReasons;
//	}
//
//	public void setClmHdrAdtnlAdjReasons(
//			Set<ClmHdrAdtnlAdjReason> clmHdrAdtnlAdjReasons) {
//		this.clmHdrAdtnlAdjReasons = clmHdrAdtnlAdjReasons;
//	}
//
//	public Set<ClmHdrAdtnlRemarkCode> getClmHdrAdtnlRemarkCodes() {
//		return clmHdrAdtnlRemarkCodes;
//	}
//
//	public void setClmHdrAdtnlRemarkCodes(
//			Set<ClmHdrAdtnlRemarkCode> clmHdrAdtnlRemarkCodes) {
//		this.clmHdrAdtnlRemarkCodes = clmHdrAdtnlRemarkCodes;
//	}
//
//	public Set<ClmHdrAmbulanceDtl> getClmHdrAmbulanceDtls() {
//		return clmHdrAmbulanceDtls;
//	}
//
//	public void setClmHdrAmbulanceDtls(
//			Set<ClmHdrAmbulanceDtl> clmHdrAmbulanceDtls) {
//		this.clmHdrAmbulanceDtls = clmHdrAmbulanceDtls;
//	}
//
//	public Set<ClmHdrAmbulancePtntCndtn> getClmHdrAmbulancePtntCndtns() {
//		return clmHdrAmbulancePtntCndtns;
//	}
//
//	public void setClmHdrAmbulancePtntCndtns(
//			Set<ClmHdrAmbulancePtntCndtn> clmHdrAmbulancePtntCndtns) {
//		this.clmHdrAmbulancePtntCndtns = clmHdrAmbulancePtntCndtns;
//	}
//
//	public Set<ClmHdrAmount> getClmHdrAmounts() {
//		return clmHdrAmounts;
//	}
//
//	public void setClmHdrAmounts(Set<ClmHdrAmount> clmHdrAmounts) {
//		this.clmHdrAmounts = clmHdrAmounts;
//	}
//
//	public Set<ClmHdrAttachment> getClmHdrAttachments() {
//		return clmHdrAttachments;
//	}
//
//	public void setClmHdrAttachments(Set<ClmHdrAttachment> clmHdrAttachments) {
//		this.clmHdrAttachments = clmHdrAttachments;
//	}
//
//	public Set<ClmHdrCondition> getClmHdrConditions() {
//		return clmHdrConditions;
//	}
//
//	public void setClmHdrConditions(Set<ClmHdrCondition> clmHdrConditions) {
//		this.clmHdrConditions = clmHdrConditions;
//	}
//
//	public Set<ClmHdrConflict> getClmHdrConflicts() {
//		return clmHdrConflicts;
//	}
//
//	public void setClmHdrConflicts(Set<ClmHdrConflict> clmHdrConflicts) {
//		this.clmHdrConflicts = clmHdrConflicts;
//	}
//
//	public Set<ClmHdrCutback> getClmHdrCutbacks() {
//		return clmHdrCutbacks;
//	}
//
//	public void setClmHdrCutbacks(Set<ClmHdrCutback> clmHdrCutbacks) {
//		this.clmHdrCutbacks = clmHdrCutbacks;
//	}
//
//	public Set<ClmHdrDate> getClmHdrDates() {
//		return clmHdrDates;
//	}
//
//	public void setClmHdrDates(Set<ClmHdrDate> clmHdrDates) {
//		this.clmHdrDates = clmHdrDates;
//	}

	public ClmHdrDerivedElement getClmHdrDerivedElement() {
		return clmHdrDerivedElement;
	}

	public void setClmHdrDerivedElement(
			ClmHdrDerivedElement clmHdrDerivedElement) {
		this.clmHdrDerivedElement = clmHdrDerivedElement;
	}
//
//	public Set<ClmHdrHptlPcgInptnt> getClmHdrHptlPcgInptnts() {
//		return clmHdrHptlPcgInptnts;
//	}
//
//	public void setClmHdrHptlPcgInptnts(
//			Set<ClmHdrHptlPcgInptnt> clmHdrHptlPcgInptnts) {
//		this.clmHdrHptlPcgInptnts = clmHdrHptlPcgInptnts;
//	}
//
//	public Set<ClmHdrOccurrenceDetail> getClmHdrOccurrenceDetails() {
//		return clmHdrOccurrenceDetails;
//	}
//
//	public void setClmHdrOccurrenceDetails(
//			Set<ClmHdrOccurrenceDetail> clmHdrOccurrenceDetails) {
//		this.clmHdrOccurrenceDetails = clmHdrOccurrenceDetails;
//	}
//
//	public Set<ClmHdrOtherPayerDtl> getClmHdrOtherPayerDtls() {
//		return clmHdrOtherPayerDtls;
//	}
//
//	public void setClmHdrOtherPayerDtls(
//			Set<ClmHdrOtherPayerDtl> clmHdrOtherPayerDtls) {
//		this.clmHdrOtherPayerDtls = clmHdrOtherPayerDtls;
//	}
//
//	public Set<ClmHdrOtherPayerRemark> getClmHdrOtherPayerRemarks() {
//		return clmHdrOtherPayerRemarks;
//	}
//
//	public void setClmHdrOtherPayerRemarks(
//			Set<ClmHdrOtherPayerRemark> clmHdrOtherPayerRemarks) {
//		this.clmHdrOtherPayerRemarks = clmHdrOtherPayerRemarks;
//	}
//
//	public Set<ClmHdrOthPyrAdjDtl> getClmHdrOthPyrAdjDtls() {
//		return clmHdrOthPyrAdjDtls;
//	}
//
//	public void setClmHdrOthPyrAdjDtls(
//			Set<ClmHdrOthPyrAdjDtl> clmHdrOthPyrAdjDtls) {
//		this.clmHdrOthPyrAdjDtls = clmHdrOthPyrAdjDtls;
//	}
//
//	public Set<ClmHdrQuantity> getClmHdrQuantities() {
//		return clmHdrQuantities;
//	}
//
//	public void setClmHdrQuantities(Set<ClmHdrQuantity> clmHdrQuantities) {
//		this.clmHdrQuantities = clmHdrQuantities;
//	}
//
//	public Set<ClmHdrReferenceInfo> getClmHdrReferenceInfos() {
//		return clmHdrReferenceInfos;
//	}
//
//	public void setClmHdrReferenceInfos(
//			Set<ClmHdrReferenceInfo> clmHdrReferenceInfos) {
//		this.clmHdrReferenceInfos = clmHdrReferenceInfos;
//	}
//
//	public Set<ClmHdrRunError> getClmHdrRunErrors() {
//		return clmHdrRunErrors;
//	}
//
//	public void setClmHdrRunErrors(Set<ClmHdrRunError> clmHdrRunErrors) {
//		this.clmHdrRunErrors = clmHdrRunErrors;
//	}
//
//	public Set<ClmHdrRunErrorAsgndPerson> getClmHdrRunErrorAsgndPersons() {
//		return clmHdrRunErrorAsgndPersons;
//	}
//
//	public void setClmHdrRunErrorAsgndPersons(
//			Set<ClmHdrRunErrorAsgndPerson> clmHdrRunErrorAsgndPersons) {
//		this.clmHdrRunErrorAsgndPersons = clmHdrRunErrorAsgndPersons;
//	}
//
//	public Set<ClmHdrSubscriber> getClmHdrSubscribers() {
//		return clmHdrSubscribers;
//	}
//
//	public void setClmHdrSubscribers(Set<ClmHdrSubscriber> clmHdrSubscribers) {
//		this.clmHdrSubscribers = clmHdrSubscribers;
//	}
//
//	public Set<ClmHdrValueAmount> getClmHdrValueAmounts() {
//		return clmHdrValueAmounts;
//	}
//
//	public void setClmHdrValueAmounts(Set<ClmHdrValueAmount> clmHdrValueAmounts) {
//		this.clmHdrValueAmounts = clmHdrValueAmounts;
//	}

	public Set<ClmHdrXDiagnosis> getClmHdrXDiagnosis() {
		return clmHdrXDiagnosis;
	}

	public void setClmHdrXDiagnosis(Set<ClmHdrXDiagnosis> clmHdrXDiagnosis) {
		this.clmHdrXDiagnosis = clmHdrXDiagnosis;
	}

	public BigDecimal getProgramCid() {
		return programCid;
	}

	public void setProgramCid(BigDecimal programCid) {
		this.programCid = programCid;
	}


//	public Set<ClmHdrXIndicator> getClmHdrXIndicators() {
//		return clmHdrXIndicators;
//	}
//
//	public void setClmHdrXIndicators(Set<ClmHdrXIndicator> clmHdrXIndicators) {
//		this.clmHdrXIndicators = clmHdrXIndicators;
//	}
//
//	public Set<ClmHdrXPaRqst> getClmHdrXPaRqsts() {
//		return clmHdrXPaRqsts;
//	}
//
//	public void setClmHdrXPaRqsts(Set<ClmHdrXPaRqst> clmHdrXPaRqsts) {
//		this.clmHdrXPaRqsts = clmHdrXPaRqsts;
//	}
//
//	public Set<ClmHdrXProcedure> getClmHdrXProcedures() {
//		return clmHdrXProcedures;
//	}
//
//	public void setClmHdrXProcedures(Set<ClmHdrXProcedure> clmHdrXProcedures) {
//		this.clmHdrXProcedures = clmHdrXProcedures;
//	}
//
//	public Set<ClmHdrXPrvdrLctn> getClmHdrXPrvdrLctns() {
//		return clmHdrXPrvdrLctns;
//	}
//
//	public void setClmHdrXPrvdrLctns(Set<ClmHdrXPrvdrLctn> clmHdrXPrvdrLctns) {
//		this.clmHdrXPrvdrLctns = clmHdrXPrvdrLctns;
//	}
//
//	public Set<ClmLnHptlPcgOutptnt> getClmLnHptlPcgOutptnts() {
//		return clmLnHptlPcgOutptnts;
//	}
//
//	public void setClmLnHptlPcgOutptnts(
//			Set<ClmLnHptlPcgOutptnt> clmLnHptlPcgOutptnts) {
//		this.clmLnHptlPcgOutptnts = clmLnHptlPcgOutptnts;
//	}
}