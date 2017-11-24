package com.ahp.cas.domains.claims.adclaim;

import java.io.Serializable;

import javax.persistence.*;

import org.hibernate.annotations.Type;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import java.math.BigDecimal;
import java.util.Date;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;


/**
 * The persistent class for the AD_CLAIM_LINE database table.
 * 
 */
@Entity
@Table(name="AD_CLAIM_LINE")
@JsonIdentityInfo(generator=ObjectIdGenerators.IntSequenceGenerator.class, property="@id")
public class AdClaimLine extends AbstractEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Type(type = "objectid")
	private String id;
	
	
	//@Id
	//@SequenceGenerator(name="AD_CLAIM_LINE_SEQ_GENERATOR" ,sequenceName="CLAIM_LINE_SEQ", allocationSize = 1)
	//@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="AD_CLAIM_LINE_SEQ_GENERATOR")
	@Column(name = "CLAIM_LINE_SID")
	private long claimLineSid;

	@Column(name = "ADJUSTMENT_SOURCE_TYPE_LKPCD")
	private String adjustmentSourceTypeLkpcd;

	@Column(name = "ADJUSTMENT_TYPE_LKPCD")
	private String adjustmentTypeLkpcd;

	@Temporal(TemporalType.DATE)
	@Column(name = "ADMISSION_DATE")
	private Date admissionDate;

	@Column(name = "APLCTN_STATUS_CID")
	private BigDecimal aplctnStatusCid;

	@Column(name = "APLCTN_STATUS_TYPE_CID")
	private BigDecimal aplctnStatusTypeCid;

	@Column(name = "ATHRZTN_NMBR")
	private String athrztnNmbr;

	@Column(name = "BILLED_AMOUNT")
	@JsonProperty("LineItemChargeAmount")
	private BigDecimal billedAmount;

	@Column(name = "BILLED_UNIT_UOM_CODE")
	@JsonProperty("UnitofMeasurement")
	private String billedUnitUomCode;

	@Column(name = "BILLED_UNITS")
	@JsonProperty("ServiceUnitCount")
	private BigDecimal billedUnits;

	@Column(name = "BSNS_STATUS_CID")
	private BigDecimal bsnsStatusCid;

	@Column(name = "BSNS_STATUS_TYPE_CID")
	private BigDecimal bsnsStatusTypeCid;

	@Column(name = "CLAIM_LINE_TCN")
	@JsonProperty("LineTcn")
	private String claimLineTcn;

	@Column(name = "CLM_TYPE_CID")
	private BigDecimal clmTypeCid;

	@Column(name = "CLSFCTN_GROUP_CID")
	private BigDecimal clsfctnGroupCid;

	@Column(name = "FACILITY_TYPE_CODE")
	@JsonProperty("FacilityTypeCode")
	private String facilityTypeCode;

	@Temporal(TemporalType.DATE)
	@Column(name = "FROM_SERVICE_DATE")
	@JsonProperty("ServiceStartDate")
	private Date fromServiceDate;

	@Temporal(TemporalType.DATE)
	@Column(name = "LAST_RUN_DATE")
	private Date lastRunDate;

	@Column(name = "LAST_RUN_NMBR")
	private BigDecimal lastRunNmbr;

	@Temporal(TemporalType.DATE)
	@Column(name = "LAST_SUSPEND_DATE")
	private Date lastSuspendDate;

	@Column(name = "LINE_ITEM_CONTROL_NUMBER")
	@JsonProperty("ServiceLineNo")
	private String lineItemControlNumber;

	@Column(name = "MDFR_CODE1")
	@JsonProperty("ProcedureModifier1")
	private String mdfrCode1;

	@Column(name = "MDFR_CODE2")
	@JsonProperty("ProcedureModifier2")
	private String mdfrCode2;

	@Column(name = "MDFR_CODE3")
	@JsonProperty("ProcedureModifier3")
	private String mdfrCode3;

	@Column(name = "MDFR_CODE4")
	@JsonProperty("ProcedureModifier4")
	private String mdfrCode4;


	@Column(name = "PARENT_LINE_SID")
	private BigDecimal parentLineSid;

	@Column(name = "PRCDR_CODE")
	@JsonProperty("ProcedureCode")
	private String prcdrCode;

	@Column(name = "PRCDR_CODE_QLFR_LKPCD")
	@JsonProperty("ServiceIDQualifer")
	private String prcdrCodeQlfrLkpcd;

	@Column(name = "PRIMARY_DIAGNOSIS_IID")
	private BigDecimal primaryDiagnosisIid;

	@Column(name = "PRIMARY_PA_RQST_IDENTIFIER")
	private String primaryPaRqstIdentifier;

	@Column(name = "PRIMARY_PA_RQST_SID")
	private BigDecimal primaryPaRqstSid;

	@Column(name = "PRIMARY_RFRL_IDNTFCTN_NMBR")
	private String primaryRfrlIdntfctnNmbr;

	@Column(name = "PROCEDURE_IID")
	private BigDecimal procedureIid;

	@Column(name = "PROGRAM_CID")
	private BigDecimal programCid;

	@Column(name = "REVENUE_CODE")
	@JsonProperty("ServiceLineRevenueCode")
	private String revenueCode;

	@Column(name = "REVENUE_IID")
	private BigDecimal revenueIid;

	@Column(name = "SBMTD_PRCDR_CODE")
	private String sbmtdPrcdrCode;

	@Column(name = "SBMTD_PRCDR_DESC")
	private String sbmtdPrcdrDesc;

	@Column(name = "SBMTD_PRCDR_IID")
	private BigDecimal sbmtdPrcdrIid;

	@Column(name = "SRVCNG_NATIONAL_PRVDR_IDNTFR")
	@JsonProperty("RenderingProviderNPI")
	private BigDecimal srvcngNationalPrvdrIdntfr;

	@Column(name = "SRVCNG_PRVDR_FIRST_NAME")
	@JsonProperty("RenderingProviderFirstName")
	private String srvcngPrvdrFirstName;

	@Column(name = "SRVCNG_PRVDR_IDNTFR_TYPE_CID")
	@JsonProperty("RenderingProviderIDType")
	private BigDecimal srvcngPrvdrIdntfrTypeCid;

	@Column(name = "SRVCNG_PRVDR_LAST_NAME")
	@JsonProperty("RenderingProviderLastName")
	private String srvcngPrvdrLastName;

	@Column(name = "SRVCNG_PRVDR_LCTN_IDENTIFIER")
	private String srvcngPrvdrLctnIdentifier;

	@Column(name = "SRVCNG_PRVDR_LCTN_IID")
	private BigDecimal srvcngPrvdrLctnIid;

	@Column(name = "SRVCNG_PRVDR_LCTN_TXNMY_CODE")
	@JsonProperty("RenderingProviderTaxonomyCode")
	private String srvcngPrvdrLctnTxnmyCode;

	@Column(name = "SRVCNG_PRVDR_LEGACY_ID")
	private String srvcngPrvdrLegacyId;

	@Column(name = "SRVCNG_PRVDR_MIDDLE_NAME")
	@JsonProperty("RenderingProviderMiddleName")
	private String srvcngPrvdrMiddleName;

	@Column(name = "SRVCNG_PRVDR_SUFFIX_LKPCD")
	@JsonProperty("RenderingProviderNameSuffix")
	private String srvcngPrvdrSuffixLkpcd;

	@Column(name = "SSBP_ATHRZTN_HDR_SID")
	private BigDecimal ssbpAthrztnHdrSid;

	@Temporal(TemporalType.DATE)
	@Column(name = "STATUS_EFFECTIVE_DATE")
	private Date statusEffectiveDate;

	@Temporal(TemporalType.DATE)
	@Column(name = "SYSTEM_IN_DATE")
	private Date systemInDate;

	@Temporal(TemporalType.DATE)
	@Column(name = "TO_SERVICE_DATE")
	@JsonProperty("ServiceEndDate")
	private Date toServiceDate;

	@Column(name = "TPL_LKPCD")
	private String tplLkpcd;

	// bi-directional many-to-one association to ClaimHeader
	@ManyToOne
	//@JoinColumn(name = "id")
	@JsonBackReference
	private AdClaimHeader claimHeader;


	public AdClaimLine() {
	}

	public long getClaimLineSid() {
		return this.claimLineSid;
	}

	public void setClaimLineSid(long claimLineSid) {
		this.claimLineSid = claimLineSid;
	}

	public String getAdjustmentSourceTypeLkpcd() {
		return this.adjustmentSourceTypeLkpcd;
	}

	public void setAdjustmentSourceTypeLkpcd(String adjustmentSourceTypeLkpcd) {
		this.adjustmentSourceTypeLkpcd = adjustmentSourceTypeLkpcd;
	}

	public String getAdjustmentTypeLkpcd() {
		return this.adjustmentTypeLkpcd;
	}

	public void setAdjustmentTypeLkpcd(String adjustmentTypeLkpcd) {
		this.adjustmentTypeLkpcd = adjustmentTypeLkpcd;
	}

	public Date getAdmissionDate() {
		return this.admissionDate;
	}

	public void setAdmissionDate(Date admissionDate) {
		this.admissionDate = admissionDate;
	}

	public BigDecimal getAplctnStatusCid() {
		return this.aplctnStatusCid;
	}

	public void setAplctnStatusCid(BigDecimal aplctnStatusCid) {
		this.aplctnStatusCid = aplctnStatusCid;
	}

	public BigDecimal getAplctnStatusTypeCid() {
		return this.aplctnStatusTypeCid;
	}

	public void setAplctnStatusTypeCid(BigDecimal aplctnStatusTypeCid) {
		this.aplctnStatusTypeCid = aplctnStatusTypeCid;
	}

	public String getAthrztnNmbr() {
		return this.athrztnNmbr;
	}

	public void setAthrztnNmbr(String athrztnNmbr) {
		this.athrztnNmbr = athrztnNmbr;
	}

	public BigDecimal getBilledAmount() {
		return this.billedAmount;
	}

	public void setBilledAmount(BigDecimal billedAmount) {
		this.billedAmount = billedAmount;
	}

	public String getBilledUnitUomCode() {
		return this.billedUnitUomCode;
	}

	public void setBilledUnitUomCode(String billedUnitUomCode) {
		this.billedUnitUomCode = billedUnitUomCode;
	}

	public BigDecimal getBilledUnits() {
		return this.billedUnits;
	}

	public void setBilledUnits(BigDecimal billedUnits) {
		this.billedUnits = billedUnits;
	}

	public BigDecimal getBsnsStatusCid() {
		return this.bsnsStatusCid;
	}

	public void setBsnsStatusCid(BigDecimal bsnsStatusCid) {
		this.bsnsStatusCid = bsnsStatusCid;
	}

	public BigDecimal getBsnsStatusTypeCid() {
		return this.bsnsStatusTypeCid;
	}

	public void setBsnsStatusTypeCid(BigDecimal bsnsStatusTypeCid) {
		this.bsnsStatusTypeCid = bsnsStatusTypeCid;
	}

	public String getClaimLineTcn() {
		return this.claimLineTcn;
	}

	public void setClaimLineTcn(String claimLineTcn) {
		this.claimLineTcn = claimLineTcn;
	}

	public BigDecimal getClmTypeCid() {
		return this.clmTypeCid;
	}

	public void setClmTypeCid(BigDecimal clmTypeCid) {
		this.clmTypeCid = clmTypeCid;
	}

	public BigDecimal getClsfctnGroupCid() {
		return this.clsfctnGroupCid;
	}

	public void setClsfctnGroupCid(BigDecimal clsfctnGroupCid) {
		this.clsfctnGroupCid = clsfctnGroupCid;
	}

	public String getFacilityTypeCode() {
		return this.facilityTypeCode;
	}

	public void setFacilityTypeCode(String facilityTypeCode) {
		this.facilityTypeCode = facilityTypeCode;
	}

	public Date getFromServiceDate() {
		return this.fromServiceDate;
	}

	public void setFromServiceDate(Date fromServiceDate) {
		this.fromServiceDate = fromServiceDate;
	}

	public Date getLastRunDate() {
		return this.lastRunDate;
	}

	public void setLastRunDate(Date lastRunDate) {
		this.lastRunDate = lastRunDate;
	}

	public BigDecimal getLastRunNmbr() {
		return this.lastRunNmbr;
	}

	public void setLastRunNmbr(BigDecimal lastRunNmbr) {
		this.lastRunNmbr = lastRunNmbr;
	}

	public Date getLastSuspendDate() {
		return this.lastSuspendDate;
	}

	public void setLastSuspendDate(Date lastSuspendDate) {
		this.lastSuspendDate = lastSuspendDate;
	}

	public String getLineItemControlNumber() {
		return this.lineItemControlNumber;
	}

	public void setLineItemControlNumber(String lineItemControlNumber) {
		this.lineItemControlNumber = lineItemControlNumber;
	}

	public String getMdfrCode1() {
		return this.mdfrCode1;
	}

	public void setMdfrCode1(String mdfrCode1) {
		this.mdfrCode1 = mdfrCode1;
	}

	public String getMdfrCode2() {
		return this.mdfrCode2;
	}

	public void setMdfrCode2(String mdfrCode2) {
		this.mdfrCode2 = mdfrCode2;
	}

	public String getMdfrCode3() {
		return this.mdfrCode3;
	}

	public void setMdfrCode3(String mdfrCode3) {
		this.mdfrCode3 = mdfrCode3;
	}

	public String getMdfrCode4() {
		return this.mdfrCode4;
	}

	public void setMdfrCode4(String mdfrCode4) {
		this.mdfrCode4 = mdfrCode4;
	}

	public BigDecimal getParentLineSid() {
		return this.parentLineSid;
	}

	public void setParentLineSid(BigDecimal parentLineSid) {
		this.parentLineSid = parentLineSid;
	}

	public String getPrcdrCode() {
		return this.prcdrCode;
	}

	public void setPrcdrCode(String prcdrCode) {
		this.prcdrCode = prcdrCode;
	}

	public String getPrcdrCodeQlfrLkpcd() {
		return this.prcdrCodeQlfrLkpcd;
	}

	public void setPrcdrCodeQlfrLkpcd(String prcdrCodeQlfrLkpcd) {
		this.prcdrCodeQlfrLkpcd = prcdrCodeQlfrLkpcd;
	}

	public BigDecimal getPrimaryDiagnosisIid() {
		return this.primaryDiagnosisIid;
	}

	public void setPrimaryDiagnosisIid(BigDecimal primaryDiagnosisIid) {
		this.primaryDiagnosisIid = primaryDiagnosisIid;
	}

	public String getPrimaryPaRqstIdentifier() {
		return this.primaryPaRqstIdentifier;
	}

	public void setPrimaryPaRqstIdentifier(String primaryPaRqstIdentifier) {
		this.primaryPaRqstIdentifier = primaryPaRqstIdentifier;
	}

	public BigDecimal getPrimaryPaRqstSid() {
		return this.primaryPaRqstSid;
	}

	public void setPrimaryPaRqstSid(BigDecimal primaryPaRqstSid) {
		this.primaryPaRqstSid = primaryPaRqstSid;
	}

	public String getPrimaryRfrlIdntfctnNmbr() {
		return this.primaryRfrlIdntfctnNmbr;
	}

	public void setPrimaryRfrlIdntfctnNmbr(String primaryRfrlIdntfctnNmbr) {
		this.primaryRfrlIdntfctnNmbr = primaryRfrlIdntfctnNmbr;
	}

	public BigDecimal getProcedureIid() {
		return this.procedureIid;
	}

	public void setProcedureIid(BigDecimal procedureIid) {
		this.procedureIid = procedureIid;
	}

	public BigDecimal getProgramCid() {
		return this.programCid;
	}

	public void setProgramCid(BigDecimal programCid) {
		this.programCid = programCid;
	}

	public String getRevenueCode() {
		return this.revenueCode;
	}

	public void setRevenueCode(String revenueCode) {
		this.revenueCode = revenueCode;
	}

	public BigDecimal getRevenueIid() {
		return this.revenueIid;
	}

	public void setRevenueIid(BigDecimal revenueIid) {
		this.revenueIid = revenueIid;
	}

//	public String getRmtncAdvcNumber() {
//		return this.rmtncAdvcNumber;
//	}
//
//	public void setRmtncAdvcNumber(String rmtncAdvcNumber) {
//		this.rmtncAdvcNumber = rmtncAdvcNumber;
//	}

	public String getSbmtdPrcdrCode() {
		return this.sbmtdPrcdrCode;
	}

	public void setSbmtdPrcdrCode(String sbmtdPrcdrCode) {
		this.sbmtdPrcdrCode = sbmtdPrcdrCode;
	}

	public String getSbmtdPrcdrDesc() {
		return this.sbmtdPrcdrDesc;
	}

	public void setSbmtdPrcdrDesc(String sbmtdPrcdrDesc) {
		this.sbmtdPrcdrDesc = sbmtdPrcdrDesc;
	}

	public BigDecimal getSbmtdPrcdrIid() {
		return this.sbmtdPrcdrIid;
	}

	public void setSbmtdPrcdrIid(BigDecimal sbmtdPrcdrIid) {
		this.sbmtdPrcdrIid = sbmtdPrcdrIid;
	}

	public BigDecimal getSrvcngNationalPrvdrIdntfr() {
		return this.srvcngNationalPrvdrIdntfr;
	}

	public void setSrvcngNationalPrvdrIdntfr(BigDecimal srvcngNationalPrvdrIdntfr) {
		this.srvcngNationalPrvdrIdntfr = srvcngNationalPrvdrIdntfr;
	}

	public String getSrvcngPrvdrFirstName() {
		return this.srvcngPrvdrFirstName;
	}

	public void setSrvcngPrvdrFirstName(String srvcngPrvdrFirstName) {
		this.srvcngPrvdrFirstName = srvcngPrvdrFirstName;
	}

	public BigDecimal getSrvcngPrvdrIdntfrTypeCid() {
		return this.srvcngPrvdrIdntfrTypeCid;
	}

	public void setSrvcngPrvdrIdntfrTypeCid(BigDecimal srvcngPrvdrIdntfrTypeCid) {
		this.srvcngPrvdrIdntfrTypeCid = srvcngPrvdrIdntfrTypeCid;
	}

	public String getSrvcngPrvdrLastName() {
		return this.srvcngPrvdrLastName;
	}

	public void setSrvcngPrvdrLastName(String srvcngPrvdrLastName) {
		this.srvcngPrvdrLastName = srvcngPrvdrLastName;
	}

	public String getSrvcngPrvdrLctnIdentifier() {
		return this.srvcngPrvdrLctnIdentifier;
	}

	public void setSrvcngPrvdrLctnIdentifier(String srvcngPrvdrLctnIdentifier) {
		this.srvcngPrvdrLctnIdentifier = srvcngPrvdrLctnIdentifier;
	}

	public BigDecimal getSrvcngPrvdrLctnIid() {
		return this.srvcngPrvdrLctnIid;
	}

	public void setSrvcngPrvdrLctnIid(BigDecimal srvcngPrvdrLctnIid) {
		this.srvcngPrvdrLctnIid = srvcngPrvdrLctnIid;
	}

	public String getSrvcngPrvdrLctnTxnmyCode() {
		return this.srvcngPrvdrLctnTxnmyCode;
	}

	public void setSrvcngPrvdrLctnTxnmyCode(String srvcngPrvdrLctnTxnmyCode) {
		this.srvcngPrvdrLctnTxnmyCode = srvcngPrvdrLctnTxnmyCode;
	}

	public String getSrvcngPrvdrLegacyId() {
		return this.srvcngPrvdrLegacyId;
	}

	public void setSrvcngPrvdrLegacyId(String srvcngPrvdrLegacyId) {
		this.srvcngPrvdrLegacyId = srvcngPrvdrLegacyId;
	}

	public String getSrvcngPrvdrMiddleName() {
		return this.srvcngPrvdrMiddleName;
	}

	public void setSrvcngPrvdrMiddleName(String srvcngPrvdrMiddleName) {
		this.srvcngPrvdrMiddleName = srvcngPrvdrMiddleName;
	}

	public String getSrvcngPrvdrSuffixLkpcd() {
		return this.srvcngPrvdrSuffixLkpcd;
	}

	public void setSrvcngPrvdrSuffixLkpcd(String srvcngPrvdrSuffixLkpcd) {
		this.srvcngPrvdrSuffixLkpcd = srvcngPrvdrSuffixLkpcd;
	}

	public BigDecimal getSsbpAthrztnHdrSid() {
		return this.ssbpAthrztnHdrSid;
	}

	public void setSsbpAthrztnHdrSid(BigDecimal ssbpAthrztnHdrSid) {
		this.ssbpAthrztnHdrSid = ssbpAthrztnHdrSid;
	}

	public Date getStatusEffectiveDate() {
		return this.statusEffectiveDate;
	}

	public void setStatusEffectiveDate(Date statusEffectiveDate) {
		this.statusEffectiveDate = statusEffectiveDate;
	}

	public Date getSystemInDate() {
		return this.systemInDate;
	}

	public void setSystemInDate(Date systemInDate) {
		this.systemInDate = systemInDate;
	}

	public Date getToServiceDate() {
		return this.toServiceDate;
	}

	public void setToServiceDate(Date toServiceDate) {
		this.toServiceDate = toServiceDate;
	}

	public String getTplLkpcd() {
		return this.tplLkpcd;
	}

	public void setTplLkpcd(String tplLkpcd) {
		this.tplLkpcd = tplLkpcd;
	}

	public AdClaimHeader getClaimHeader() {
		return this.claimHeader;
	}

	public void setClaimHeader(AdClaimHeader adClaimHeader) {
		this.claimHeader = adClaimHeader;
	}


}