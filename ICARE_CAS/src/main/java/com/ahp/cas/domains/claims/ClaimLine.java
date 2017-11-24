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

@JsonIdentityInfo(generator=ObjectIdGenerators.IntSequenceGenerator.class, property="@id")
public class ClaimLine implements Serializable {
	private static final long serialVersionUID = 1L;
	private long claimLineSid;
	private String adjustmentSourceTypeLkpcd;
	private String adjustmentTypeLkpcd;
	private Date admissionDate;
	private BigDecimal aplctnStatusCid;
	private BigDecimal aplctnStatusTypeCid;
	private String athrztnNmbr;
	
	@JsonProperty("LineItemChargeAmount")
	private BigDecimal billedAmount;
	
	@JsonProperty("UnitofMeasurement")
	private String billedUnitUomCode;
	
	@JsonProperty("ServiceUnitCount")
	private BigDecimal billedUnits;
	private BigDecimal bsnsStatusCid;
	private BigDecimal bsnsStatusTypeCid;
	
	@JsonProperty("LineTcn")
	private String claimLineTcn;
	private BigDecimal clmTypeCid;
	private BigDecimal clsfctnGroupCid;
	private BigDecimal createdBy;
	private Date createdDate;
	
	@JsonProperty("FacilityTypeCode")
	private String facilityTypeCode;
	@JsonProperty("ServiceStartDate")
	private Date fromServiceDate;
	private Date lastRunDate;
	private BigDecimal lastRunNmbr;
	private Date lastSuspendDate;
	
	@JsonProperty("ServiceLineNo")
	private String lineItemControlNumber;
	
	@JsonProperty("ProcedureModifier1")
	private String mdfrCode1;
	
	@JsonProperty("ProcedureModifier2")
	private String mdfrCode2;
	
	@JsonProperty("ProcedureModifier3")
	private String mdfrCode3;
	
	@JsonProperty("ProcedureModifier4")
	private String mdfrCode4;
	private BigDecimal modifiedBy;
	private Date modifiedDate;
	private BigDecimal parentLineSid;
	
	@JsonProperty("ProcedureCode")
	private String prcdrCode;
	
	@JsonProperty("ServiceIDQualifer")
	private String prcdrCodeQlfrLkpcd;
	private BigDecimal primaryDiagnosisIid;
	private String primaryPaRqstIdentifier;
	private BigDecimal primaryPaRqstSid;
	private String primaryRfrlIdntfctnNmbr;
	private BigDecimal procedureIid;
	private BigDecimal programCid;
	
	@JsonProperty("ServiceLineRevenueCode")
	private String revenueCode;
	private BigDecimal revenueIid;
	private String sbmtdPrcdrCode;
	private String sbmtdPrcdrDesc;
	private BigDecimal sbmtdPrcdrIid;
	@JsonProperty("RenderingProviderNPI")
	private BigDecimal srvcngNationalPrvdrIdntfr;
	
	@JsonProperty("RenderingProviderFirstName")
	private String srvcngPrvdrFirstName;
	
	@JsonProperty("RenderingProviderIDType")
	private BigDecimal srvcngPrvdrIdntfrTypeCid;
	
	@JsonProperty("RenderingProviderLastName")
	private String srvcngPrvdrLastName;
	
	@JsonProperty("ServicingProviderZipCode")
	private String srvcngPrvdrLctnZipCode;
	
	@JsonProperty("RenderingProviderLocationID")
	private String srvcngPrvdrLctnIdentifier;
	private BigDecimal srvcngPrvdrLctnIid;
	
	@JsonProperty("RenderingProviderTaxonomyCode")
	private String srvcngPrvdrLctnTxnmyCode;
	private String srvcngPrvdrLegacyId;
	
	@JsonProperty("RenderingProviderMiddleName")
	private String srvcngPrvdrMiddleName;
	
	@JsonProperty("RenderingProviderNameSuffix")
	private String srvcngPrvdrSuffixLkpcd;
	private BigDecimal ssbpAthrztnHdrSid;
	private Date statusEffectiveDate;
	private Date systemInDate;
	
	@JsonProperty("ServiceEndDate")
	private Date toServiceDate;
	private String tplLkpcd;
	
	@JsonBackReference
	private ClaimHeader claimHeader;
	
	@JsonProperty("LineDiagnosisPointerInformation")
	@JsonManagedReference
	private Set<ClmHdrXDiagnosisXClmLn> clmHdrXDiagnosisXClmLns;
//	private Set<ClmLnAdtnlAdjReason> clmLnAdtnlAdjReasons;
//	private Set<ClmLnAdtnlRemarkCode> clmLnAdtnlRemarkCodes;
	
	@JsonManagedReference
	@JsonDeserialize(as=LinkedHashSet.class)
	@JsonProperty("LineAmbulanceInformation")
	private Set<ClmLnAmbulanceDtl> clmLnAmbulanceDtls;
	
	@JsonProperty("LinePatientCondOnAmbInformation")
	@JsonManagedReference
	private Set<ClmLnAmbulancePtntCndtn> clmLnAmbulancePtntCndtns;
	
	@JsonManagedReference
	@JsonProperty("LineAmountInformation")
	private Set<ClmLnAmount> clmLnAmounts;
//	private Set<ClmLnAttachment> clmLnAttachments;
	private Set<ClmLnConflict> clmLnConflicts;
	private Set<ClmLnCopayAmount> clmLnCopayAmounts;
//	private Set<ClmLnCutback> clmLnCutbacks;
//	private Set<ClmLnDate> clmLnDates;
	private Set<ClmLnDentalDetail> clmLnDentalDetails;
	@JsonManagedReference
	private ClmLnDerivedElement clmLnDerivedElement;
	
	@JsonManagedReference
	@JsonDeserialize(as=LinkedHashSet.class)
	@JsonProperty("LineDrugInformation")
	private Set<ClmLnDrugIdentification> clmLnDrugIdentifications;
//	private Set<ClmLnHptlPcgOutptnt> clmLnHptlPcgOutptnts;
//	private Set<ClmLnMepopsXRmtncAdvc> clmLnMepopsXRmtncAdvcs;
//	private Set<ClmLnOralCvtyDsgntnDetail> clmLnOralCvtyDsgntnDetails;

	@JsonDeserialize(as=LinkedHashSet.class)
	@JsonProperty("LineOtherPayerAdjudicationInformation")
	private Set<ClmLnOtherPayerDetail> clmLnOtherPayerDetails;
//	private Set<ClmLnOthPyrAdjDtl> clmLnOthPyrAdjDtls;
//	private Set<ClmLnPaymentInfo> clmLnPaymentInfos;
//	private Set<ClmLnQuantity> clmLnQuantities;
	
	@JsonManagedReference
	@JsonProperty("LineReferenceInformation")
	private Set<ClmLnReferenceInfo> clmLnReferenceInfos;
	private Set<ClmLnRunError> clmLnRunErrors;
//	private Set<ClmLnRunErrorAsgndPerson> clmLnRunErrorAsgndPersons;
//	private Set<ClmLnXFundDtl> clmLnXFundDtls;
	
	@JsonManagedReference
	@JsonProperty("LineIndicatorInformation")
	private Set<ClmLnXIndicator> clmLnXIndicators;
	
	private Set<ClmLnXPaRqst> clmLnXPaRqsts;
	
	@JsonManagedReference
	@JsonProperty("LinePriorAuthInformation")
	private Set<ClmLnXPaRqstRfrlNmbr> clmLnXPaRqstRfrlNmbrs;
	
	
	@JsonManagedReference
	@JsonProperty("LineProviderInformation")
	private Set<ClmLnXPrvdrLctn> clmLnXPrvdrLctns;

	public ClaimLine() {
	}

	public long getClaimLineSid() {
		return claimLineSid;
	}

	public void setClaimLineSid(long claimLineSid) {
		this.claimLineSid = claimLineSid;
	}

	public String getAdjustmentSourceTypeLkpcd() {
		return adjustmentSourceTypeLkpcd;
	}

	public void setAdjustmentSourceTypeLkpcd(String adjustmentSourceTypeLkpcd) {
		this.adjustmentSourceTypeLkpcd = adjustmentSourceTypeLkpcd;
	}

	public String getAdjustmentTypeLkpcd() {
		return adjustmentTypeLkpcd;
	}

	public void setAdjustmentTypeLkpcd(String adjustmentTypeLkpcd) {
		this.adjustmentTypeLkpcd = adjustmentTypeLkpcd;
	}

	public Date getAdmissionDate() {
		return admissionDate;
	}

	public void setAdmissionDate(Date admissionDate) {
		this.admissionDate = admissionDate;
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

	public BigDecimal getBilledAmount() {
		return billedAmount;
	}

	public void setBilledAmount(BigDecimal billedAmount) {
		this.billedAmount = billedAmount;
	}

	public String getBilledUnitUomCode() {
		return billedUnitUomCode;
	}

	public void setBilledUnitUomCode(String billedUnitUomCode) {
		this.billedUnitUomCode = billedUnitUomCode;
	}

	public BigDecimal getBilledUnits() {
		return billedUnits;
	}

	public void setBilledUnits(BigDecimal billedUnits) {
		this.billedUnits = billedUnits;
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

	public String getClaimLineTcn() {
		return claimLineTcn;
	}

	public void setClaimLineTcn(String claimLineTcn) {
		this.claimLineTcn = claimLineTcn;
	}

	public BigDecimal getClmTypeCid() {
		return clmTypeCid;
	}

	public void setClmTypeCid(BigDecimal clmTypeCid) {
		this.clmTypeCid = clmTypeCid;
	}

	public BigDecimal getClsfctnGroupCid() {
		return clsfctnGroupCid;
	}

	public void setClsfctnGroupCid(BigDecimal clsfctnGroupCid) {
		this.clsfctnGroupCid = clsfctnGroupCid;
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

	public String getLineItemControlNumber() {
		return lineItemControlNumber;
	}

	public void setLineItemControlNumber(String lineItemControlNumber) {
		this.lineItemControlNumber = lineItemControlNumber;
	}

	public String getMdfrCode1() {
		return mdfrCode1;
	}

	public void setMdfrCode1(String mdfrCode1) {
		this.mdfrCode1 = mdfrCode1;
	}

	public String getMdfrCode2() {
		return mdfrCode2;
	}

	public void setMdfrCode2(String mdfrCode2) {
		this.mdfrCode2 = mdfrCode2;
	}

	public String getMdfrCode3() {
		return mdfrCode3;
	}

	public void setMdfrCode3(String mdfrCode3) {
		this.mdfrCode3 = mdfrCode3;
	}

	public String getMdfrCode4() {
		return mdfrCode4;
	}

	public void setMdfrCode4(String mdfrCode4) {
		this.mdfrCode4 = mdfrCode4;
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

	public BigDecimal getParentLineSid() {
		return parentLineSid;
	}

	public void setParentLineSid(BigDecimal parentLineSid) {
		this.parentLineSid = parentLineSid;
	}

	public String getPrcdrCode() {
		return prcdrCode;
	}

	public void setPrcdrCode(String prcdrCode) {
		this.prcdrCode = prcdrCode;
	}

	public String getPrcdrCodeQlfrLkpcd() {
		return prcdrCodeQlfrLkpcd;
	}

	public void setPrcdrCodeQlfrLkpcd(String prcdrCodeQlfrLkpcd) {
		this.prcdrCodeQlfrLkpcd = prcdrCodeQlfrLkpcd;
	}

	public BigDecimal getPrimaryDiagnosisIid() {
		return primaryDiagnosisIid;
	}

	public void setPrimaryDiagnosisIid(BigDecimal primaryDiagnosisIid) {
		this.primaryDiagnosisIid = primaryDiagnosisIid;
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

	public BigDecimal getProcedureIid() {
		return procedureIid;
	}

	public void setProcedureIid(BigDecimal procedureIid) {
		this.procedureIid = procedureIid;
	}

	public BigDecimal getProgramCid() {
		return programCid;
	}

	public void setProgramCid(BigDecimal programCid) {
		this.programCid = programCid;
	}

	public String getRevenueCode() {
		return revenueCode;
	}

	public void setRevenueCode(String revenueCode) {
		this.revenueCode = revenueCode;
	}

	public BigDecimal getRevenueIid() {
		return revenueIid;
	}

	public void setRevenueIid(BigDecimal revenueIid) {
		this.revenueIid = revenueIid;
	}

	public String getSbmtdPrcdrCode() {
		return sbmtdPrcdrCode;
	}

	public void setSbmtdPrcdrCode(String sbmtdPrcdrCode) {
		this.sbmtdPrcdrCode = sbmtdPrcdrCode;
	}

	public String getSbmtdPrcdrDesc() {
		return sbmtdPrcdrDesc;
	}

	public void setSbmtdPrcdrDesc(String sbmtdPrcdrDesc) {
		this.sbmtdPrcdrDesc = sbmtdPrcdrDesc;
	}

	public BigDecimal getSbmtdPrcdrIid() {
		return sbmtdPrcdrIid;
	}

	public void setSbmtdPrcdrIid(BigDecimal sbmtdPrcdrIid) {
		this.sbmtdPrcdrIid = sbmtdPrcdrIid;
	}

	public BigDecimal getSrvcngNationalPrvdrIdntfr() {
		return srvcngNationalPrvdrIdntfr;
	}

	public void setSrvcngNationalPrvdrIdntfr(BigDecimal srvcngNationalPrvdrIdntfr) {
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

	public Date getToServiceDate() {
		return toServiceDate;
	}

	public void setToServiceDate(Date toServiceDate) {
		this.toServiceDate = toServiceDate;
	}

	public String getTplLkpcd() {
		return tplLkpcd;
	}

	public void setTplLkpcd(String tplLkpcd) {
		this.tplLkpcd = tplLkpcd;
	}

	public ClaimHeader getClaimHeader() {
		return claimHeader;
	}

	public void setClaimHeader(ClaimHeader claimHeader) {
		this.claimHeader = claimHeader;
	}

	public Set<ClmHdrXDiagnosisXClmLn> getClmHdrXDiagnosisXClmLns() {
		return clmHdrXDiagnosisXClmLns;
	}

	public void setClmHdrXDiagnosisXClmLns(
			Set<ClmHdrXDiagnosisXClmLn> clmHdrXDiagnosisXClmLns) {
		this.clmHdrXDiagnosisXClmLns = clmHdrXDiagnosisXClmLns;
	}

//	public Set<ClmLnAdtnlAdjReason> getClmLnAdtnlAdjReasons() {
//		return clmLnAdtnlAdjReasons;
//	}
//
//	public void setClmLnAdtnlAdjReasons(
//			Set<ClmLnAdtnlAdjReason> clmLnAdtnlAdjReasons) {
//		this.clmLnAdtnlAdjReasons = clmLnAdtnlAdjReasons;
//	}
//
//	public Set<ClmLnAdtnlRemarkCode> getClmLnAdtnlRemarkCodes() {
//		return clmLnAdtnlRemarkCodes;
//	}
//
//	public void setClmLnAdtnlRemarkCodes(
//			Set<ClmLnAdtnlRemarkCode> clmLnAdtnlRemarkCodes) {
//		this.clmLnAdtnlRemarkCodes = clmLnAdtnlRemarkCodes;
//	}

	public Set<ClmLnAmbulanceDtl> getClmLnAmbulanceDtls() {
		return clmLnAmbulanceDtls;
	}

	public void setClmLnAmbulanceDtls(Set<ClmLnAmbulanceDtl> clmLnAmbulanceDtls) {
		this.clmLnAmbulanceDtls = clmLnAmbulanceDtls;
	}

//	public Set<ClmLnAmbulancePtntCndtn> getClmLnAmbulancePtntCndtns() {
//		return clmLnAmbulancePtntCndtns;
//	}
//
//	public void setClmLnAmbulancePtntCndtns(
//			Set<ClmLnAmbulancePtntCndtn> clmLnAmbulancePtntCndtns) {
//		this.clmLnAmbulancePtntCndtns = clmLnAmbulancePtntCndtns;
//	}

	public Set<ClmLnAmount> getClmLnAmounts() {
		return clmLnAmounts;
	}

	public void setClmLnAmounts(Set<ClmLnAmount> clmLnAmounts) {
		this.clmLnAmounts = clmLnAmounts;
	}

//	public Set<ClmLnAttachment> getClmLnAttachments() {
//		return clmLnAttachments;
//	}
//
//	public void setClmLnAttachments(Set<ClmLnAttachment> clmLnAttachments) {
//		this.clmLnAttachments = clmLnAttachments;
//	}

	public Set<ClmLnConflict> getClmLnConflicts() {
		return clmLnConflicts;
	}

	public void setClmLnConflicts(Set<ClmLnConflict> clmLnConflicts) {
		this.clmLnConflicts = clmLnConflicts;
	}

	public Set<ClmLnCopayAmount> getClmLnCopayAmounts() {
		return clmLnCopayAmounts;
	}

	public void setClmLnCopayAmounts(Set<ClmLnCopayAmount> clmLnCopayAmounts) {
		this.clmLnCopayAmounts = clmLnCopayAmounts;
	}

//	public Set<ClmLnCutback> getClmLnCutbacks() {
//		return clmLnCutbacks;
//	}
//
//	public void setClmLnCutbacks(Set<ClmLnCutback> clmLnCutbacks) {
//		this.clmLnCutbacks = clmLnCutbacks;
//	}
//
//	public Set<ClmLnDate> getClmLnDates() {
//		return clmLnDates;
//	}
//
//	public void setClmLnDates(Set<ClmLnDate> clmLnDates) {
//		this.clmLnDates = clmLnDates;
//	}

	public Set<ClmLnDentalDetail> getClmLnDentalDetails() {
		return clmLnDentalDetails;
	}

	public void setClmLnDentalDetails(Set<ClmLnDentalDetail> clmLnDentalDetails) {
		this.clmLnDentalDetails = clmLnDentalDetails;
	}

	public ClmLnDerivedElement getClmLnDerivedElement() {
		return clmLnDerivedElement;
	}

	public void setClmLnDerivedElement(ClmLnDerivedElement clmLnDerivedElement) {
		this.clmLnDerivedElement = clmLnDerivedElement;
	}

	public Set<ClmLnDrugIdentification> getClmLnDrugIdentifications() {
		return clmLnDrugIdentifications;
	}

	public void setClmLnDrugIdentifications(
			Set<ClmLnDrugIdentification> clmLnDrugIdentifications) {
		this.clmLnDrugIdentifications = clmLnDrugIdentifications;
	}

//	public Set<ClmLnHptlPcgOutptnt> getClmLnHptlPcgOutptnts() {
//		return clmLnHptlPcgOutptnts;
//	}
//
//	public void setClmLnHptlPcgOutptnts(
//			Set<ClmLnHptlPcgOutptnt> clmLnHptlPcgOutptnts) {
//		this.clmLnHptlPcgOutptnts = clmLnHptlPcgOutptnts;
//	}
//
//	public Set<ClmLnMepopsXRmtncAdvc> getClmLnMepopsXRmtncAdvcs() {
//		return clmLnMepopsXRmtncAdvcs;
//	}
//
//	public void setClmLnMepopsXRmtncAdvcs(
//			Set<ClmLnMepopsXRmtncAdvc> clmLnMepopsXRmtncAdvcs) {
//		this.clmLnMepopsXRmtncAdvcs = clmLnMepopsXRmtncAdvcs;
//	}
//
//	public Set<ClmLnOralCvtyDsgntnDetail> getClmLnOralCvtyDsgntnDetails() {
//		return clmLnOralCvtyDsgntnDetails;
//	}
//
//	public void setClmLnOralCvtyDsgntnDetails(
//			Set<ClmLnOralCvtyDsgntnDetail> clmLnOralCvtyDsgntnDetails) {
//		this.clmLnOralCvtyDsgntnDetails = clmLnOralCvtyDsgntnDetails;
//	}

	public Set<ClmLnOtherPayerDetail> getClmLnOtherPayerDetails() {
		return clmLnOtherPayerDetails;
	}

	public void setClmLnOtherPayerDetails(
			Set<ClmLnOtherPayerDetail> clmLnOtherPayerDetails) {
		this.clmLnOtherPayerDetails = clmLnOtherPayerDetails;
	}

//	public Set<ClmLnOthPyrAdjDtl> getClmLnOthPyrAdjDtls() {
//		return clmLnOthPyrAdjDtls;
//	}
//
//	public void setClmLnOthPyrAdjDtls(Set<ClmLnOthPyrAdjDtl> clmLnOthPyrAdjDtls) {
//		this.clmLnOthPyrAdjDtls = clmLnOthPyrAdjDtls;
//	}
//
//	public Set<ClmLnPaymentInfo> getClmLnPaymentInfos() {
//		return clmLnPaymentInfos;
//	}
//
//	public void setClmLnPaymentInfos(Set<ClmLnPaymentInfo> clmLnPaymentInfos) {
//		this.clmLnPaymentInfos = clmLnPaymentInfos;
//	}
//
//	public Set<ClmLnQuantity> getClmLnQuantities() {
//		return clmLnQuantities;
//	}
//
//	public void setClmLnQuantities(Set<ClmLnQuantity> clmLnQuantities) {
//		this.clmLnQuantities = clmLnQuantities;
//	}

	public Set<ClmLnReferenceInfo> getClmLnReferenceInfos() {
		return clmLnReferenceInfos;
	}

	public void setClmLnReferenceInfos(Set<ClmLnReferenceInfo> clmLnReferenceInfos) {
		this.clmLnReferenceInfos = clmLnReferenceInfos;
	}

	public Set<ClmLnRunError> getClmLnRunErrors() {
		return clmLnRunErrors;
	}

	public void setClmLnRunErrors(Set<ClmLnRunError> clmLnRunErrors) {
		this.clmLnRunErrors = clmLnRunErrors;
	}

//	public Set<ClmLnRunErrorAsgndPerson> getClmLnRunErrorAsgndPersons() {
//		return clmLnRunErrorAsgndPersons;
//	}
//
//	public void setClmLnRunErrorAsgndPersons(
//			Set<ClmLnRunErrorAsgndPerson> clmLnRunErrorAsgndPersons) {
//		this.clmLnRunErrorAsgndPersons = clmLnRunErrorAsgndPersons;
//	}
//
//	public Set<ClmLnXFundDtl> getClmLnXFundDtls() {
//		return clmLnXFundDtls;
//	}
//
//	public void setClmLnXFundDtls(Set<ClmLnXFundDtl> clmLnXFundDtls) {
//		this.clmLnXFundDtls = clmLnXFundDtls;
//	}

	public Set<ClmLnXIndicator> getClmLnXIndicators() {
		return clmLnXIndicators;
	}

	public void setClmLnXIndicators(Set<ClmLnXIndicator> clmLnXIndicators) {
		this.clmLnXIndicators = clmLnXIndicators;
	}

	public Set<ClmLnXPaRqst> getClmLnXPaRqsts() {
		return clmLnXPaRqsts;
	}

	public void setClmLnXPaRqsts(Set<ClmLnXPaRqst> clmLnXPaRqsts) {
		this.clmLnXPaRqsts = clmLnXPaRqsts;
	}

	public Set<ClmLnXPaRqstRfrlNmbr> getClmLnXPaRqstRfrlNmbrs() {
		return clmLnXPaRqstRfrlNmbrs;
	}

	public void setClmLnXPaRqstRfrlNmbrs(
			Set<ClmLnXPaRqstRfrlNmbr> clmLnXPaRqstRfrlNmbrs) {
		this.clmLnXPaRqstRfrlNmbrs = clmLnXPaRqstRfrlNmbrs;
	}

	public Set<ClmLnXPrvdrLctn> getClmLnXPrvdrLctns() {
		return clmLnXPrvdrLctns;
	}

	public void setClmLnXPrvdrLctns(Set<ClmLnXPrvdrLctn> clmLnXPrvdrLctns) {
		this.clmLnXPrvdrLctns = clmLnXPrvdrLctns;
	}

	public ClmLnRunError addClmLnRunError(ClmLnRunError clmLnRunError) {
		getClmLnRunErrors().add(clmLnRunError);
		clmLnRunError.setClaimLine(this);

		return clmLnRunError;
	}

	public String getSrvcngPrvdrLctnZipCode() {
		return srvcngPrvdrLctnZipCode;
	}

	public void setSrvcngPrvdrLctnZipCode(String srvcngPrvdrLctnZipCode) {
		this.srvcngPrvdrLctnZipCode = srvcngPrvdrLctnZipCode;
	}
}