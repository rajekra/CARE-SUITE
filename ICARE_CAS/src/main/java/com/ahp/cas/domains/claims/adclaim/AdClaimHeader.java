package com.ahp.cas.domains.claims.adclaim;

import java.io.Serializable;

import javax.persistence.*;

import org.hibernate.annotations.Type;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Set;


/**
 * The persistent class for the AD_CLAIM_HEADER database table.
 * 
 */
@Entity
@Table(name="AD_CLAIM_HEADER")
public class AdClaimHeader extends AbstractEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Transient
	@JsonProperty("InterchangeReceiverID")
	private String payerId;
	
	@Transient
	@JsonProperty("ClaimSubmitterID")
	private String claimSubmitterID;
	
	@Transient
	@JsonProperty("PatientZipCode")
	private String patientZipCode;
	
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
	
	//@SequenceGenerator(name="AD_CLAIM_HEADER_SEQ_GENERATOR", sequenceName="CLAIM_HEADER_SEQ", allocationSize = 1)
	//@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="AD_CLAIM_HEADER_SEQ_GENERATOR")
	@Column(name = "CLAIM_HEADER_SID")
	private long claimHeaderSid;

	@Column(name = "ADJUSTMENT_SOURCE_TYPE_LKPCD")
	@JsonProperty("AdjustmentSourceType")
	private String adjustmentSourceTypeLkpcd;

	@Temporal(TemporalType.DATE)
	@Column(name = "ADMISSION_DATE")
	@JsonProperty("AdmissionDate")
	private Date admissionDate;

	@Column(name = "ADMISSION_HOUR")
	@JsonProperty("AdmissionHour")
	private String admissionHour;

	@Column(name = "APLCTN_STATUS_CID")
	private BigDecimal aplctnStatusCid;

	@Column(name = "APLCTN_STATUS_TYPE_CID")
	private BigDecimal aplctnStatusTypeCid;

	@Column(name = "ATHRZTN_NMBR")
	private String athrztnNmbr;

	@Temporal(TemporalType.DATE)
	@Column(name = "BILL_DATE")
	@JsonProperty("TransactionSetCreationDate")
	private Date billDate;

	@Column(name = "BILL_TYPE_FOURTH_DIGIT_LKPCD")
	private String billTypeFourthDigitLkpcd;

	@Column(name = "BLNG_NATIONAL_PRVDR_IDNTFR")
	@JsonProperty("BillingProviderNPI")
	private BigDecimal blngNationalPrvdrIdntfr;

	@Column(name = "BLNG_PRVDR_FIRST_NAME")
	private String blngPrvdrFirstName;

	@Column(name = "BLNG_PRVDR_IDNTFR_TYPE_CID")
	@JsonProperty("BillingProviderIdentifierType")
	private BigDecimal blngPrvdrIdntfrTypeCid;

	@Column(name = "BLNG_PRVDR_LAST_NAME")
	private String blngPrvdrLastName;

	@Column(name = "BLNG_PRVDR_LCTN_IDENTIFIER")
	@JsonProperty("BillingProviderLocationID")
	private String blngPrvdrLctnIdentifier;

	@Column(name = "BLNG_PRVDR_LCTN_IID")
	private BigDecimal blngPrvdrLctnIid;

	@Column(name = "BLNG_PRVDR_LCTN_TXNMY_CODE")
	private String blngPrvdrLctnTxnmyCode;

	@Column(name = "BLNG_PRVDR_LEGACY_ID")
	private String blngPrvdrLegacyId;

	@Column(name = "BLNG_PRVDR_MIDDLE_NAME")
	private String blngPrvdrMiddleName;

	@Column(name = "BLNG_PRVDR_NAME")
	private String blngPrvdrName;

	@Column(name = "BLNG_PRVDR_SUFFIX_LKPCD")
	private String blngPrvdrSuffixLkpcd;

	@Column(name = "BLNG_PRVDR_TYPE_CODE")
	private BigDecimal blngPrvdrTypeCode;

	@Column(name = "BSNS_STATUS_CID")
	private BigDecimal bsnsStatusCid;

	@Column(name = "BSNS_STATUS_TYPE_CID")
	private BigDecimal bsnsStatusTypeCid;

	@Column(name = "CHKDOUT_BY")
	private BigDecimal chkdoutBy;

	@Column(name = "CHKDOUT_STATUS_LKPCD")
	private String chkdoutStatusLkpcd;

	@Column(name = "CLAIM_SUBMISSION_REASON_LKPCD")
	@JsonProperty("ClaimFrequencyCode")
	private String claimSubmissionReasonLkpcd;

	@Column(name = "CLM_SOURCE_CODE")
	@JsonProperty("ClaimSourceCode")
	private String clmSourceCode;

	@Column(name = "CLM_TYPE_CID")
	private BigDecimal clmTypeCid;


	@Column(name = "CURRENCY_TYPE_LKPCD")
	@JsonProperty("ClaimCurrencyType")
	private String currencyTypeLkpcd;

	@Column(name = "DENIAL_REASON_CD_1")
	private String denialReasonCd1;

	@Column(name = "DENIAL_REASON_CD_2")
	private String denialReasonCd2;

	@Temporal(TemporalType.DATE)
	@Column(name = "DISCHARGE_DATE")
	@JsonProperty("DischargeDate")
	private Date dischargeDate;

	@Column(name = "DRG_CODE")
	@JsonProperty("DiagnosisRelatedGroupCode")
	private String drgCode;

	@Column(name = "FACILITY_TYPE_CODE")
	@JsonProperty("FacilityTypeCode")
	private String facilityTypeCode;

	@Temporal(TemporalType.DATE)
	@Column(name = "FROM_SERVICE_DATE")
	@JsonProperty("ServiceStartDate")
	private Date fromServiceDate;

	@Column(name = "HIPAA_VERSION")
	@JsonProperty("X12Version")
	private String hipaaVersion;

	@Column(name = "INBND_FILE_LINE_NMBR")
	private String inbndFileLineNmbr;

	@Column(name = "INSURANCE_COVERAGE_CODE")
	private String insuranceCoverageCode;

	@Column(name = "INVOICE_TYPE_LKPCD")
	@JsonProperty("ClaimType")
	private String invoiceTypeLkpcd;

	@Temporal(TemporalType.DATE)
	@Column(name = "LAST_PAYMENT_DATE")
	private Date lastPaymentDate;

	@Temporal(TemporalType.DATE)
	@Column(name = "LAST_RUN_DATE")
	private Date lastRunDate;

	@Column(name = "LAST_RUN_NMBR")
	private BigDecimal lastRunNmbr;

	@Temporal(TemporalType.DATE)
	@Column(name = "LAST_SUSPEND_DATE")
	private Date lastSuspendDate;

	@Transient
	@Column(name = "MASS_ADJSTMNT_FLAG")
	private String massAdjstmntFlag;

	@Column(name = "MBR_IDENTIFIER")
	@JsonProperty("SubscriberPrimaryID")
	private String mbrIdentifier;

	@Column(name = "MBR_IDNTFR_TYPE_CID")
	@JsonProperty("SubscriberPrimaryIDType")
	private BigDecimal mbrIdntfrTypeCid;

	@Column(name = "MBR_LEGACY_IDNTFR")
	private String mbrLegacyIdntfr;

	@Column(name = "MBR_SID")
	private BigDecimal mbrSid;

	@Column(name = "MEDICAL_RECORD_NMBR")
	@JsonProperty("MedicalRecordNumber")
	private String medicalRecordNmbr;

	@Column(name = "ORIGINAL_TCN")
	@JsonProperty("OriginalTcn")
	private String originalTcn;

	@Column(name = "PARENT_TCN")
	@JsonProperty("PayerClaimControlNo")
	private String parentTcn;

	@Column(name = "PATIENT_ACCOUNT_NMBR")
	@JsonProperty("PatientControlNo")
	private String patientAccountNmbr;

	@Temporal(TemporalType.DATE)
	@Column(name = "PATIENT_BIRTH_DATE")
	@JsonProperty("PatientBirthDate")
	private Date patientBirthDate;

	@Temporal(TemporalType.DATE)
	@Column(name = "PATIENT_DEATH_DATE")
	@JsonProperty("PatientDeathDate")
	private Date patientDeathDate;

	@Column(name = "PATIENT_FIRST_NAME")
	@JsonProperty("PatientFirstName")
	private String patientFirstName;

	@Column(name = "PATIENT_GENDER")
	@JsonProperty("PatientGender")
	private String patientGender;

	@Column(name = "PATIENT_LAST_NAME")
	@JsonProperty("PatientLastName")
	private String patientLastName;

	@Column(name = "PATIENT_MIDDLE_NAME")
	@JsonProperty("PatientMiddleName")
	private String patientMiddleName;

	@Column(name = "PATIENT_RELATIONSHIP_LKPCD")
	@JsonProperty("PatientRelationshipCode")
	private String patientRelationshipLkpcd;

	@Column(name = "PATIENT_SUFFIX_LKPCD")
	@JsonProperty("PatientSuffix")
	private String patientSuffixLkpcd;

	@Column(name = "PRIMARY_DIAGNOSIS_IID")
	private BigDecimal primaryDiagnosisIid;

	@Column(name = "PRIMARY_DIAGNOSIS_POA_LKPCD")
	private String primaryDiagnosisPoaLkpcd;

	@Column(name = "PRIMARY_PA_RQST_IDENTIFIER")
	@JsonProperty("PriorAuthorizationNo")
	private String primaryPaRqstIdentifier;

	@Column(name = "PRIMARY_PA_RQST_SID")
	private BigDecimal primaryPaRqstSid;

	@Column(name = "PRIMARY_RFRL_IDNTFCTN_NMBR")
	private String primaryRfrlIdntfctnNmbr;

	@Column(name = "SBMT_FCLTY_BILL_CLSFCTN_SID")
	private BigDecimal sbmtFcltyBillClsfctnSid;

	@Column(name = "SERVICE_ATHRZTN_EXCPTN_LKPCD")
	@JsonProperty("ServiceAuthExceptionCode")
	private String serviceAthrztnExcptnLkpcd;

	@Column(name = "SPECIAL_PROGRAM_LKPCD")
	@JsonProperty("SpecialProgramIndicator")
	private String specialProgramLkpcd;

	@Column(name = "SRVCNG_NATIONAL_PRVDR_IDNTFR")
	@JsonProperty("RenderingProviderNPI")
	private BigDecimal srvcngNationalPrvdrIdntfr;

	@Column(name = "SRVCNG_PRVDR_FIRST_NAME")
	@JsonProperty("RenderingProviderFirstName")
	private String srvcngPrvdrFirstName;

	@Column(name = "SRVCNG_PRVDR_IDNTFR_TYPE_CID")
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
	@JsonProperty("RenderingProviderSuffix")
	private String srvcngPrvdrSuffixLkpcd;

	@Column(name = "SSBP_ATHRZTN_HDR_SID")
	private BigDecimal ssbpAthrztnHdrSid;

	@Temporal(TemporalType.DATE)
	@Column(name = "STATUS_EFFECTIVE_DATE")
	private Date statusEffectiveDate;

	@Temporal(TemporalType.DATE)
	@Column(name = "SYSTEM_IN_DATE")
	private Date systemInDate;

	@Column(name = "TCN",length=21)
	@JsonProperty("TCN")
	private String tcn;

	@Temporal(TemporalType.DATE)
	@Column(name = "TCN_DATE")
	private Date tcnDate;

	@Temporal(TemporalType.DATE)
	@Column(name = "TO_SERVICE_DATE")
	@JsonProperty("ServiceEndDate")
	private Date toServiceDate;

	@Column(name = "TOTAL_BILLED_AMOUNT")
	private BigDecimal totalBilledAmount;

	@Column(name = "TOTAL_BILLED_UNIT")
	private BigDecimal totalBilledUnit;

	@Column(name = "OWCP_PROGRAM_CID")
	private BigDecimal programCid;
	
	// bi-directional many-to-one association to ClaimLine
	@OneToMany(targetEntity=AdClaimLine.class,mappedBy = "claimHeader", cascade = CascadeType.ALL)
	@JsonManagedReference
	@JsonProperty("LineInformation")
	private Set<AdClaimLine> claimLines;

	
	// UnComment Based On the Requirment
	
		/*
		
		// bi-directional many-to-one association to ClmLnHptlPcgOutptnt
		@OneToMany(mappedBy = "claimHeader")
		private Set<AdClmLnHptlPcgOutptnt> clmLnHptlPcgOutptnts;

		// bi-directional many-to-one association to ClmHdrRunErrorAsgndPerson
		@OneToMany(mappedBy = "claimHeader")
		private Set<AdClmHdrRunErrorAsgndPerson> clmHdrRunErrorAsgndPersons;
	*/

		/**
		 * @return the payerId
		 */
		public String getPayerId() {
			return payerId;
		}

		/**
		 * @param payerId the payerId to set
		 */
		public void setPayerId(String payerId) {
			this.payerId = payerId;
		}

		/**
		 * @return the programCid
		 */
		public BigDecimal getProgramCid() {
			return programCid;
		}

		/**
		 * @param programCid the programCid to set
		 */
		public void setProgramCid(BigDecimal programCid) {
			this.programCid = programCid;
		}

		/**
		 * @return the massAdjstmntFlag
		 */
		public String getMassAdjstmntFlag() {
			return massAdjstmntFlag;
		}

		/**
		 * @param massAdjstmntFlag the massAdjstmntFlag to set
		 */
		public void setMassAdjstmntFlag(String massAdjstmntFlag) {
			this.massAdjstmntFlag = massAdjstmntFlag;
		}

		/**
		 * @return the claimHeaderSid
		 */
		public long getClaimHeaderSid() {
			return claimHeaderSid;
		}

		/**
		 * @param claimHeaderSid the claimHeaderSid to set
		 */
		public void setClaimHeaderSid(long claimHeaderSid) {
			this.claimHeaderSid = claimHeaderSid;
		}

		/**
		 * @return the adjustmentSourceTypeLkpcd
		 */
		public String getAdjustmentSourceTypeLkpcd() {
			return adjustmentSourceTypeLkpcd;
		}

		/**
		 * @param adjustmentSourceTypeLkpcd the adjustmentSourceTypeLkpcd to set
		 */
		public void setAdjustmentSourceTypeLkpcd(String adjustmentSourceTypeLkpcd) {
			this.adjustmentSourceTypeLkpcd = adjustmentSourceTypeLkpcd;
		}

		/**
		 * @return the admissionDate
		 */
		public Date getAdmissionDate() {
			return admissionDate;
		}

		/**
		 * @param admissionDate the admissionDate to set
		 */
		public void setAdmissionDate(Date admissionDate) {
			this.admissionDate = admissionDate;
		}

		/**
		 * @return the admissionHour
		 */
		public String getAdmissionHour() {
			return admissionHour;
		}

		/**
		 * @param admissionHour the admissionHour to set
		 */
		public void setAdmissionHour(String admissionHour) {
			this.admissionHour = admissionHour;
		}

		/**
		 * @return the aplctnStatusCid
		 */
		public BigDecimal getAplctnStatusCid() {
			return aplctnStatusCid;
		}

		/**
		 * @param aplctnStatusCid the aplctnStatusCid to set
		 */
		public void setAplctnStatusCid(BigDecimal aplctnStatusCid) {
			this.aplctnStatusCid = aplctnStatusCid;
		}

		/**
		 * @return the aplctnStatusTypeCid
		 */
		public BigDecimal getAplctnStatusTypeCid() {
			return aplctnStatusTypeCid;
		}

		/**
		 * @param aplctnStatusTypeCid the aplctnStatusTypeCid to set
		 */
		public void setAplctnStatusTypeCid(BigDecimal aplctnStatusTypeCid) {
			this.aplctnStatusTypeCid = aplctnStatusTypeCid;
		}

		/**
		 * @return the athrztnNmbr
		 */
		public String getAthrztnNmbr() {
			return athrztnNmbr;
		}

		/**
		 * @param athrztnNmbr the athrztnNmbr to set
		 */
		public void setAthrztnNmbr(String athrztnNmbr) {
			this.athrztnNmbr = athrztnNmbr;
		}

		/**
		 * @return the billDate
		 */
		public Date getBillDate() {
			return billDate;
		}

		/**
		 * @param billDate the billDate to set
		 */
		public void setBillDate(Date billDate) {
			this.billDate = billDate;
		}

		/**
		 * @return the billTypeFourthDigitLkpcd
		 */
		public String getBillTypeFourthDigitLkpcd() {
			return billTypeFourthDigitLkpcd;
		}

		/**
		 * @param billTypeFourthDigitLkpcd the billTypeFourthDigitLkpcd to set
		 */
		public void setBillTypeFourthDigitLkpcd(String billTypeFourthDigitLkpcd) {
			this.billTypeFourthDigitLkpcd = billTypeFourthDigitLkpcd;
		}

		/**
		 * @return the blngNationalPrvdrIdntfr
		 */
		public BigDecimal getBlngNationalPrvdrIdntfr() {
			return blngNationalPrvdrIdntfr;
		}

		/**
		 * @param blngNationalPrvdrIdntfr the blngNationalPrvdrIdntfr to set
		 */
		public void setBlngNationalPrvdrIdntfr(BigDecimal blngNationalPrvdrIdntfr) {
			this.blngNationalPrvdrIdntfr = blngNationalPrvdrIdntfr;
		}

		/**
		 * @return the blngPrvdrFirstName
		 */
		public String getBlngPrvdrFirstName() {
			return blngPrvdrFirstName;
		}

		/**
		 * @param blngPrvdrFirstName the blngPrvdrFirstName to set
		 */
		public void setBlngPrvdrFirstName(String blngPrvdrFirstName) {
			this.blngPrvdrFirstName = blngPrvdrFirstName;
		}

		/**
		 * @return the blngPrvdrIdntfrTypeCid
		 */
		public BigDecimal getBlngPrvdrIdntfrTypeCid() {
			return blngPrvdrIdntfrTypeCid;
		}

		/**
		 * @param blngPrvdrIdntfrTypeCid the blngPrvdrIdntfrTypeCid to set
		 */
		public void setBlngPrvdrIdntfrTypeCid(BigDecimal blngPrvdrIdntfrTypeCid) {
			this.blngPrvdrIdntfrTypeCid = blngPrvdrIdntfrTypeCid;
		}

		/**
		 * @return the blngPrvdrLastName
		 */
		public String getBlngPrvdrLastName() {
			return blngPrvdrLastName;
		}

		/**
		 * @param blngPrvdrLastName the blngPrvdrLastName to set
		 */
		public void setBlngPrvdrLastName(String blngPrvdrLastName) {
			this.blngPrvdrLastName = blngPrvdrLastName;
		}

		/**
		 * @return the blngPrvdrLctnIdentifier
		 */
		public String getBlngPrvdrLctnIdentifier() {
			return blngPrvdrLctnIdentifier;
		}

		/**
		 * @param blngPrvdrLctnIdentifier the blngPrvdrLctnIdentifier to set
		 */
		public void setBlngPrvdrLctnIdentifier(String blngPrvdrLctnIdentifier) {
			this.blngPrvdrLctnIdentifier = blngPrvdrLctnIdentifier;
		}

		/**
		 * @return the blngPrvdrLctnIid
		 */
		public BigDecimal getBlngPrvdrLctnIid() {
			return blngPrvdrLctnIid;
		}

		/**
		 * @param blngPrvdrLctnIid the blngPrvdrLctnIid to set
		 */
		public void setBlngPrvdrLctnIid(BigDecimal blngPrvdrLctnIid) {
			this.blngPrvdrLctnIid = blngPrvdrLctnIid;
		}

		/**
		 * @return the blngPrvdrLctnTxnmyCode
		 */
		public String getBlngPrvdrLctnTxnmyCode() {
			return blngPrvdrLctnTxnmyCode;
		}

		/**
		 * @param blngPrvdrLctnTxnmyCode the blngPrvdrLctnTxnmyCode to set
		 */
		public void setBlngPrvdrLctnTxnmyCode(String blngPrvdrLctnTxnmyCode) {
			this.blngPrvdrLctnTxnmyCode = blngPrvdrLctnTxnmyCode;
		}

		/**
		 * @return the blngPrvdrLegacyId
		 */
		public String getBlngPrvdrLegacyId() {
			return blngPrvdrLegacyId;
		}

		/**
		 * @param blngPrvdrLegacyId the blngPrvdrLegacyId to set
		 */
		public void setBlngPrvdrLegacyId(String blngPrvdrLegacyId) {
			this.blngPrvdrLegacyId = blngPrvdrLegacyId;
		}

		/**
		 * @return the blngPrvdrMiddleName
		 */
		public String getBlngPrvdrMiddleName() {
			return blngPrvdrMiddleName;
		}

		/**
		 * @param blngPrvdrMiddleName the blngPrvdrMiddleName to set
		 */
		public void setBlngPrvdrMiddleName(String blngPrvdrMiddleName) {
			this.blngPrvdrMiddleName = blngPrvdrMiddleName;
		}

		/**
		 * @return the blngPrvdrName
		 */
		public String getBlngPrvdrName() {
			return blngPrvdrName;
		}

		/**
		 * @param blngPrvdrName the blngPrvdrName to set
		 */
		public void setBlngPrvdrName(String blngPrvdrName) {
			this.blngPrvdrName = blngPrvdrName;
		}

		/**
		 * @return the blngPrvdrSuffixLkpcd
		 */
		public String getBlngPrvdrSuffixLkpcd() {
			return blngPrvdrSuffixLkpcd;
		}

		/**
		 * @param blngPrvdrSuffixLkpcd the blngPrvdrSuffixLkpcd to set
		 */
		public void setBlngPrvdrSuffixLkpcd(String blngPrvdrSuffixLkpcd) {
			this.blngPrvdrSuffixLkpcd = blngPrvdrSuffixLkpcd;
		}

		/**
		 * @return the blngPrvdrTypeCode
		 */
		public BigDecimal getBlngPrvdrTypeCode() {
			return blngPrvdrTypeCode;
		}

		/**
		 * @param blngPrvdrTypeCode the blngPrvdrTypeCode to set
		 */
		public void setBlngPrvdrTypeCode(BigDecimal blngPrvdrTypeCode) {
			this.blngPrvdrTypeCode = blngPrvdrTypeCode;
		}

		/**
		 * @return the bsnsStatusCid
		 */
		public BigDecimal getBsnsStatusCid() {
			return bsnsStatusCid;
		}

		/**
		 * @param bsnsStatusCid the bsnsStatusCid to set
		 */
		public void setBsnsStatusCid(BigDecimal bsnsStatusCid) {
			this.bsnsStatusCid = bsnsStatusCid;
		}

		/**
		 * @return the bsnsStatusTypeCid
		 */
		public BigDecimal getBsnsStatusTypeCid() {
			return bsnsStatusTypeCid;
		}

		/**
		 * @param bsnsStatusTypeCid the bsnsStatusTypeCid to set
		 */
		public void setBsnsStatusTypeCid(BigDecimal bsnsStatusTypeCid) {
			this.bsnsStatusTypeCid = bsnsStatusTypeCid;
		}

		/**
		 * @return the chkdoutBy
		 */
		public BigDecimal getChkdoutBy() {
			return chkdoutBy;
		}

		/**
		 * @param chkdoutBy the chkdoutBy to set
		 */
		public void setChkdoutBy(BigDecimal chkdoutBy) {
			this.chkdoutBy = chkdoutBy;
		}

		/**
		 * @return the chkdoutStatusLkpcd
		 */
		public String getChkdoutStatusLkpcd() {
			return chkdoutStatusLkpcd;
		}

		/**
		 * @param chkdoutStatusLkpcd the chkdoutStatusLkpcd to set
		 */
		public void setChkdoutStatusLkpcd(String chkdoutStatusLkpcd) {
			this.chkdoutStatusLkpcd = chkdoutStatusLkpcd;
		}

		/**
		 * @return the claimSubmissionReasonLkpcd
		 */
		public String getClaimSubmissionReasonLkpcd() {
			return claimSubmissionReasonLkpcd;
		}

		/**
		 * @param claimSubmissionReasonLkpcd the claimSubmissionReasonLkpcd to set
		 */
		public void setClaimSubmissionReasonLkpcd(String claimSubmissionReasonLkpcd) {
			this.claimSubmissionReasonLkpcd = claimSubmissionReasonLkpcd;
		}

		/**
		 * @return the clmSourceCode
		 */
		public String getClmSourceCode() {
			return clmSourceCode;
		}

		/**
		 * @param clmSourceCode the clmSourceCode to set
		 */
		public void setClmSourceCode(String clmSourceCode) {
			this.clmSourceCode = clmSourceCode;
		}

		/**
		 * @return the clmTypeCid
		 */
		public BigDecimal getClmTypeCid() {
			return clmTypeCid;
		}

		/**
		 * @param clmTypeCid the clmTypeCid to set
		 */
		public void setClmTypeCid(BigDecimal clmTypeCid) {
			this.clmTypeCid = clmTypeCid;
		}

		/**
		 * @return the currencyTypeLkpcd
		 */
		public String getCurrencyTypeLkpcd() {
			return currencyTypeLkpcd;
		}

		/**
		 * @param currencyTypeLkpcd the currencyTypeLkpcd to set
		 */
		public void setCurrencyTypeLkpcd(String currencyTypeLkpcd) {
			this.currencyTypeLkpcd = currencyTypeLkpcd;
		}

		/**
		 * @return the denialReasonCd1
		 */
		public String getDenialReasonCd1() {
			return denialReasonCd1;
		}

		/**
		 * @param denialReasonCd1 the denialReasonCd1 to set
		 */
		public void setDenialReasonCd1(String denialReasonCd1) {
			this.denialReasonCd1 = denialReasonCd1;
		}

		/**
		 * @return the denialReasonCd2
		 */
		public String getDenialReasonCd2() {
			return denialReasonCd2;
		}

		/**
		 * @param denialReasonCd2 the denialReasonCd2 to set
		 */
		public void setDenialReasonCd2(String denialReasonCd2) {
			this.denialReasonCd2 = denialReasonCd2;
		}

		/**
		 * @return the dischargeDate
		 */
		public Date getDischargeDate() {
			return dischargeDate;
		}

		/**
		 * @param dischargeDate the dischargeDate to set
		 */
		public void setDischargeDate(Date dischargeDate) {
			this.dischargeDate = dischargeDate;
		}

		/**
		 * @return the drgCode
		 */
		public String getDrgCode() {
			return drgCode;
		}

		/**
		 * @param drgCode the drgCode to set
		 */
		public void setDrgCode(String drgCode) {
			this.drgCode = drgCode;
		}

		/**
		 * @return the facilityTypeCode
		 */
		public String getFacilityTypeCode() {
			return facilityTypeCode;
		}

		/**
		 * @param facilityTypeCode the facilityTypeCode to set
		 */
		public void setFacilityTypeCode(String facilityTypeCode) {
			this.facilityTypeCode = facilityTypeCode;
		}

		/**
		 * @return the fromServiceDate
		 */
		public Date getFromServiceDate() {
			return fromServiceDate;
		}

		/**
		 * @param fromServiceDate the fromServiceDate to set
		 */
		public void setFromServiceDate(Date fromServiceDate) {
			this.fromServiceDate = fromServiceDate;
		}

		/**
		 * @return the hipaaVersion
		 */
		public String getHipaaVersion() {
			return hipaaVersion;
		}

		/**
		 * @param hipaaVersion the hipaaVersion to set
		 */
		public void setHipaaVersion(String hipaaVersion) {
			this.hipaaVersion = hipaaVersion;
		}

		/**
		 * @return the inbndFileLineNmbr
		 */
		public String getInbndFileLineNmbr() {
			return inbndFileLineNmbr;
		}

		/**
		 * @param inbndFileLineNmbr the inbndFileLineNmbr to set
		 */
		public void setInbndFileLineNmbr(String inbndFileLineNmbr) {
			this.inbndFileLineNmbr = inbndFileLineNmbr;
		}

		/**
		 * @return the insuranceCoverageCode
		 */
		public String getInsuranceCoverageCode() {
			return insuranceCoverageCode;
		}

		/**
		 * @param insuranceCoverageCode the insuranceCoverageCode to set
		 */
		public void setInsuranceCoverageCode(String insuranceCoverageCode) {
			this.insuranceCoverageCode = insuranceCoverageCode;
		}

		/**
		 * @return the invoiceTypeLkpcd
		 */
		public String getInvoiceTypeLkpcd() {
			return invoiceTypeLkpcd;
		}

		/**
		 * @param invoiceTypeLkpcd the invoiceTypeLkpcd to set
		 */
		public void setInvoiceTypeLkpcd(String invoiceTypeLkpcd) {
			this.invoiceTypeLkpcd = invoiceTypeLkpcd;
		}

		/**
		 * @return the lastPaymentDate
		 */
		public Date getLastPaymentDate() {
			return lastPaymentDate;
		}

		/**
		 * @param lastPaymentDate the lastPaymentDate to set
		 */
		public void setLastPaymentDate(Date lastPaymentDate) {
			this.lastPaymentDate = lastPaymentDate;
		}

		/**
		 * @return the lastRunDate
		 */
		public Date getLastRunDate() {
			return lastRunDate;
		}

		/**
		 * @param lastRunDate the lastRunDate to set
		 */
		public void setLastRunDate(Date lastRunDate) {
			this.lastRunDate = lastRunDate;
		}

		/**
		 * @return the lastRunNmbr
		 */
		public BigDecimal getLastRunNmbr() {
			return lastRunNmbr;
		}

		/**
		 * @param lastRunNmbr the lastRunNmbr to set
		 */
		public void setLastRunNmbr(BigDecimal lastRunNmbr) {
			this.lastRunNmbr = lastRunNmbr;
		}

		/**
		 * @return the lastSuspendDate
		 */
		public Date getLastSuspendDate() {
			return lastSuspendDate;
		}

		/**
		 * @param lastSuspendDate the lastSuspendDate to set
		 */
		public void setLastSuspendDate(Date lastSuspendDate) {
			this.lastSuspendDate = lastSuspendDate;
		}

		/**
		 * @return the mbrIdentifier
		 */
		public String getMbrIdentifier() {
			return mbrIdentifier;
		}

		/**
		 * @param mbrIdentifier the mbrIdentifier to set
		 */
		public void setMbrIdentifier(String mbrIdentifier) {
			this.mbrIdentifier = mbrIdentifier;
		}

		/**
		 * @return the mbrIdntfrTypeCid
		 */
		public BigDecimal getMbrIdntfrTypeCid() {
			return mbrIdntfrTypeCid;
		}

		/**
		 * @param mbrIdntfrTypeCid the mbrIdntfrTypeCid to set
		 */
		public void setMbrIdntfrTypeCid(BigDecimal mbrIdntfrTypeCid) {
			this.mbrIdntfrTypeCid = mbrIdntfrTypeCid;
		}

		/**
		 * @return the mbrLegacyIdntfr
		 */
		public String getMbrLegacyIdntfr() {
			return mbrLegacyIdntfr;
		}

		/**
		 * @param mbrLegacyIdntfr the mbrLegacyIdntfr to set
		 */
		public void setMbrLegacyIdntfr(String mbrLegacyIdntfr) {
			this.mbrLegacyIdntfr = mbrLegacyIdntfr;
		}

		/**
		 * @return the mbrSid
		 */
		public BigDecimal getMbrSid() {
			return mbrSid;
		}

		/**
		 * @param mbrSid the mbrSid to set
		 */
		public void setMbrSid(BigDecimal mbrSid) {
			this.mbrSid = mbrSid;
		}

		/**
		 * @return the medicalRecordNmbr
		 */
		public String getMedicalRecordNmbr() {
			return medicalRecordNmbr;
		}

		/**
		 * @param medicalRecordNmbr the medicalRecordNmbr to set
		 */
		public void setMedicalRecordNmbr(String medicalRecordNmbr) {
			this.medicalRecordNmbr = medicalRecordNmbr;
		}
		
		/**
		 * @return the originalTcn
		 */
		public String getOriginalTcn() {
			return originalTcn;
		}

		/**
		 * @param originalTcn the originalTcn to set
		 */
		public void setOriginalTcn(String originalTcn) {
			this.originalTcn = originalTcn;
		}

		/**
		 * @return the parentTcn
		 */
		public String getParentTcn() {
			return parentTcn;
		}

		/**
		 * @param parentTcn the parentTcn to set
		 */
		public void setParentTcn(String parentTcn) {
			this.parentTcn = parentTcn;
		}

		/**
		 * @return the patientAccountNmbr
		 */
		public String getPatientAccountNmbr() {
			return patientAccountNmbr;
		}

		/**
		 * @param patientAccountNmbr the patientAccountNmbr to set
		 */
		public void setPatientAccountNmbr(String patientAccountNmbr) {
			this.patientAccountNmbr = patientAccountNmbr;
		}

		/**
		 * @return the patientBirthDate
		 */
		public Date getPatientBirthDate() {
			return patientBirthDate;
		}

		/**
		 * @param patientBirthDate the patientBirthDate to set
		 */
		public void setPatientBirthDate(Date patientBirthDate) {
			this.patientBirthDate = patientBirthDate;
		}

		/**
		 * @return the patientDeathDate
		 */
		public Date getPatientDeathDate() {
			return patientDeathDate;
		}

		/**
		 * @param patientDeathDate the patientDeathDate to set
		 */
		public void setPatientDeathDate(Date patientDeathDate) {
			this.patientDeathDate = patientDeathDate;
		}

		/**
		 * @return the patientFirstName
		 */
		public String getPatientFirstName() {
			return patientFirstName;
		}

		/**
		 * @param patientFirstName the patientFirstName to set
		 */
		public void setPatientFirstName(String patientFirstName) {
			this.patientFirstName = patientFirstName;
		}

		/**
		 * @return the patientGender
		 */
		public String getPatientGender() {
			return patientGender;
		}

		/**
		 * @param patientGender the patientGender to set
		 */
		public void setPatientGender(String patientGender) {
			this.patientGender = patientGender;
		}

		/**
		 * @return the patientLastName
		 */
		public String getPatientLastName() {
			return patientLastName;
		}

		/**
		 * @param patientLastName the patientLastName to set
		 */
		public void setPatientLastName(String patientLastName) {
			this.patientLastName = patientLastName;
		}

		/**
		 * @return the patientMiddleName
		 */
		public String getPatientMiddleName() {
			return patientMiddleName;
		}

		/**
		 * @param patientMiddleName the patientMiddleName to set
		 */
		public void setPatientMiddleName(String patientMiddleName) {
			this.patientMiddleName = patientMiddleName;
		}

		/**
		 * @return the patientRelationshipLkpcd
		 */
		public String getPatientRelationshipLkpcd() {
			return patientRelationshipLkpcd;
		}

		/**
		 * @param patientRelationshipLkpcd the patientRelationshipLkpcd to set
		 */
		public void setPatientRelationshipLkpcd(String patientRelationshipLkpcd) {
			this.patientRelationshipLkpcd = patientRelationshipLkpcd;
		}

		/**
		 * @return the patientSuffixLkpcd
		 */
		public String getPatientSuffixLkpcd() {
			return patientSuffixLkpcd;
		}

		/**
		 * @param patientSuffixLkpcd the patientSuffixLkpcd to set
		 */
		public void setPatientSuffixLkpcd(String patientSuffixLkpcd) {
			this.patientSuffixLkpcd = patientSuffixLkpcd;
		}

		/**
		 * @return the primaryDiagnosisIid
		 */
		public BigDecimal getPrimaryDiagnosisIid() {
			return primaryDiagnosisIid;
		}

		/**
		 * @param primaryDiagnosisIid the primaryDiagnosisIid to set
		 */
		public void setPrimaryDiagnosisIid(BigDecimal primaryDiagnosisIid) {
			this.primaryDiagnosisIid = primaryDiagnosisIid;
		}

		/**
		 * @return the primaryDiagnosisPoaLkpcd
		 */
		public String getPrimaryDiagnosisPoaLkpcd() {
			return primaryDiagnosisPoaLkpcd;
		}

		/**
		 * @param primaryDiagnosisPoaLkpcd the primaryDiagnosisPoaLkpcd to set
		 */
		public void setPrimaryDiagnosisPoaLkpcd(String primaryDiagnosisPoaLkpcd) {
			this.primaryDiagnosisPoaLkpcd = primaryDiagnosisPoaLkpcd;
		}

		/**
		 * @return the primaryPaRqstIdentifier
		 */
		public String getPrimaryPaRqstIdentifier() {
			return primaryPaRqstIdentifier;
		}

		/**
		 * @param primaryPaRqstIdentifier the primaryPaRqstIdentifier to set
		 */
		public void setPrimaryPaRqstIdentifier(String primaryPaRqstIdentifier) {
			this.primaryPaRqstIdentifier = primaryPaRqstIdentifier;
		}

		/**
		 * @return the primaryPaRqstSid
		 */
		public BigDecimal getPrimaryPaRqstSid() {
			return primaryPaRqstSid;
		}

		/**
		 * @param primaryPaRqstSid the primaryPaRqstSid to set
		 */
		public void setPrimaryPaRqstSid(BigDecimal primaryPaRqstSid) {
			this.primaryPaRqstSid = primaryPaRqstSid;
		}

		/**
		 * @return the primaryRfrlIdntfctnNmbr
		 */
		public String getPrimaryRfrlIdntfctnNmbr() {
			return primaryRfrlIdntfctnNmbr;
		}

		/**
		 * @param primaryRfrlIdntfctnNmbr the primaryRfrlIdntfctnNmbr to set
		 */
		public void setPrimaryRfrlIdntfctnNmbr(String primaryRfrlIdntfctnNmbr) {
			this.primaryRfrlIdntfctnNmbr = primaryRfrlIdntfctnNmbr;
		}


		/**
		 * @return the sbmtFcltyBillClsfctnSid
		 */
		public BigDecimal getSbmtFcltyBillClsfctnSid() {
			return sbmtFcltyBillClsfctnSid;
		}

		/**
		 * @param sbmtFcltyBillClsfctnSid the sbmtFcltyBillClsfctnSid to set
		 */
		public void setSbmtFcltyBillClsfctnSid(BigDecimal sbmtFcltyBillClsfctnSid) {
			this.sbmtFcltyBillClsfctnSid = sbmtFcltyBillClsfctnSid;
		}

		/**
		 * @return the serviceAthrztnExcptnLkpcd
		 */
		public String getServiceAthrztnExcptnLkpcd() {
			return serviceAthrztnExcptnLkpcd;
		}

		/**
		 * @param serviceAthrztnExcptnLkpcd the serviceAthrztnExcptnLkpcd to set
		 */
		public void setServiceAthrztnExcptnLkpcd(String serviceAthrztnExcptnLkpcd) {
			this.serviceAthrztnExcptnLkpcd = serviceAthrztnExcptnLkpcd;
		}

		/**
		 * @return the specialProgramLkpcd
		 */
		public String getSpecialProgramLkpcd() {
			return specialProgramLkpcd;
		}

		/**
		 * @param specialProgramLkpcd the specialProgramLkpcd to set
		 */
		public void setSpecialProgramLkpcd(String specialProgramLkpcd) {
			this.specialProgramLkpcd = specialProgramLkpcd;
		}

		/**
		 * @return the srvcngNationalPrvdrIdntfr
		 */
		public BigDecimal getSrvcngNationalPrvdrIdntfr() {
			return srvcngNationalPrvdrIdntfr;
		}

		/**
		 * @param srvcngNationalPrvdrIdntfr the srvcngNationalPrvdrIdntfr to set
		 */
		public void setSrvcngNationalPrvdrIdntfr(BigDecimal srvcngNationalPrvdrIdntfr) {
			this.srvcngNationalPrvdrIdntfr = srvcngNationalPrvdrIdntfr;
		}

		/**
		 * @return the srvcngPrvdrFirstName
		 */
		public String getSrvcngPrvdrFirstName() {
			return srvcngPrvdrFirstName;
		}

		/**
		 * @param srvcngPrvdrFirstName the srvcngPrvdrFirstName to set
		 */
		public void setSrvcngPrvdrFirstName(String srvcngPrvdrFirstName) {
			this.srvcngPrvdrFirstName = srvcngPrvdrFirstName;
		}

		/**
		 * @return the srvcngPrvdrIdntfrTypeCid
		 */
		public BigDecimal getSrvcngPrvdrIdntfrTypeCid() {
			return srvcngPrvdrIdntfrTypeCid;
		}

		/**
		 * @param srvcngPrvdrIdntfrTypeCid the srvcngPrvdrIdntfrTypeCid to set
		 */
		public void setSrvcngPrvdrIdntfrTypeCid(BigDecimal srvcngPrvdrIdntfrTypeCid) {
			this.srvcngPrvdrIdntfrTypeCid = srvcngPrvdrIdntfrTypeCid;
		}

		/**
		 * @return the srvcngPrvdrLastName
		 */
		public String getSrvcngPrvdrLastName() {
			return srvcngPrvdrLastName;
		}

		/**
		 * @param srvcngPrvdrLastName the srvcngPrvdrLastName to set
		 */
		public void setSrvcngPrvdrLastName(String srvcngPrvdrLastName) {
			this.srvcngPrvdrLastName = srvcngPrvdrLastName;
		}

		/**
		 * @return the srvcngPrvdrLctnIdentifier
		 */
		public String getSrvcngPrvdrLctnIdentifier() {
			return srvcngPrvdrLctnIdentifier;
		}

		/**
		 * @param srvcngPrvdrLctnIdentifier the srvcngPrvdrLctnIdentifier to set
		 */
		public void setSrvcngPrvdrLctnIdentifier(String srvcngPrvdrLctnIdentifier) {
			this.srvcngPrvdrLctnIdentifier = srvcngPrvdrLctnIdentifier;
		}

		/**
		 * @return the srvcngPrvdrLctnIid
		 */
		public BigDecimal getSrvcngPrvdrLctnIid() {
			return srvcngPrvdrLctnIid;
		}

		/**
		 * @param srvcngPrvdrLctnIid the srvcngPrvdrLctnIid to set
		 */
		public void setSrvcngPrvdrLctnIid(BigDecimal srvcngPrvdrLctnIid) {
			this.srvcngPrvdrLctnIid = srvcngPrvdrLctnIid;
		}

		/**
		 * @return the srvcngPrvdrLctnTxnmyCode
		 */
		public String getSrvcngPrvdrLctnTxnmyCode() {
			return srvcngPrvdrLctnTxnmyCode;
		}

		/**
		 * @param srvcngPrvdrLctnTxnmyCode the srvcngPrvdrLctnTxnmyCode to set
		 */
		public void setSrvcngPrvdrLctnTxnmyCode(String srvcngPrvdrLctnTxnmyCode) {
			this.srvcngPrvdrLctnTxnmyCode = srvcngPrvdrLctnTxnmyCode;
		}

		/**
		 * @return the srvcngPrvdrLegacyId
		 */
		public String getSrvcngPrvdrLegacyId() {
			return srvcngPrvdrLegacyId;
		}

		/**
		 * @param srvcngPrvdrLegacyId the srvcngPrvdrLegacyId to set
		 */
		public void setSrvcngPrvdrLegacyId(String srvcngPrvdrLegacyId) {
			this.srvcngPrvdrLegacyId = srvcngPrvdrLegacyId;
		}

		/**
		 * @return the srvcngPrvdrMiddleName
		 */
		public String getSrvcngPrvdrMiddleName() {
			return srvcngPrvdrMiddleName;
		}

		/**
		 * @param srvcngPrvdrMiddleName the srvcngPrvdrMiddleName to set
		 */
		public void setSrvcngPrvdrMiddleName(String srvcngPrvdrMiddleName) {
			this.srvcngPrvdrMiddleName = srvcngPrvdrMiddleName;
		}

		/**
		 * @return the srvcngPrvdrSuffixLkpcd
		 */
		public String getSrvcngPrvdrSuffixLkpcd() {
			return srvcngPrvdrSuffixLkpcd;
		}

		/**
		 * @param srvcngPrvdrSuffixLkpcd the srvcngPrvdrSuffixLkpcd to set
		 */
		public void setSrvcngPrvdrSuffixLkpcd(String srvcngPrvdrSuffixLkpcd) {
			this.srvcngPrvdrSuffixLkpcd = srvcngPrvdrSuffixLkpcd;
		}

		/**
		 * @return the ssbpAthrztnHdrSid
		 */
		public BigDecimal getSsbpAthrztnHdrSid() {
			return ssbpAthrztnHdrSid;
		}

		/**
		 * @param ssbpAthrztnHdrSid the ssbpAthrztnHdrSid to set
		 */
		public void setSsbpAthrztnHdrSid(BigDecimal ssbpAthrztnHdrSid) {
			this.ssbpAthrztnHdrSid = ssbpAthrztnHdrSid;
		}

		/**
		 * @return the statusEffectiveDate
		 */
		public Date getStatusEffectiveDate() {
			return statusEffectiveDate;
		}

		/**
		 * @param statusEffectiveDate the statusEffectiveDate to set
		 */
		public void setStatusEffectiveDate(Date statusEffectiveDate) {
			this.statusEffectiveDate = statusEffectiveDate;
		}

		/**
		 * @return the systemInDate
		 */
		public Date getSystemInDate() {
			return systemInDate;
		}

		/**
		 * @param systemInDate the systemInDate to set
		 */
		public void setSystemInDate(Date systemInDate) {
			this.systemInDate = systemInDate;
		}

		/**
		 * @return the tcn
		 */
		public String getTcn() {
			return tcn;
		}

		/**
		 * @param tcn the tcn to set
		 */
		public void setTcn(String tcn) {
			this.tcn = tcn;
		}

		/**
		 * @return the tcnDate
		 */
		public Date getTcnDate() {
			return tcnDate;
		}

		/**
		 * @param tcnDate the tcnDate to set
		 */
		public void setTcnDate(Date tcnDate) {
			this.tcnDate = tcnDate;
		}

		/**
		 * @return the toServiceDate
		 */
		public Date getToServiceDate() {
			return toServiceDate;
		}

		/**
		 * @param toServiceDate the toServiceDate to set
		 */
		public void setToServiceDate(Date toServiceDate) {
			this.toServiceDate = toServiceDate;
		}

		/**
		 * @return the totalBilledAmount
		 */
		public BigDecimal getTotalBilledAmount() {
			return totalBilledAmount;
		}

		/**
		 * @param totalBilledAmount the totalBilledAmount to set
		 */
		public void setTotalBilledAmount(BigDecimal totalBilledAmount) {
			this.totalBilledAmount = totalBilledAmount;
		}

		/**
		 * @return the totalBilledUnit
		 */
		public BigDecimal getTotalBilledUnit() {
			return totalBilledUnit;
		}

		/**
		 * @param totalBilledUnit the totalBilledUnit to set
		 */
		public void setTotalBilledUnit(BigDecimal totalBilledUnit) {
			this.totalBilledUnit = totalBilledUnit;
		}

		/**
		 * @return the claimLines
		 */
		public Set<AdClaimLine> getClaimLines() {
			return claimLines;
		}

		/**
		 * @param claimLines the claimLines to set
		 */
		public void setClaimLines(Set<AdClaimLine> claimLines) {
			this.claimLines = claimLines;
		}

		/**
		 * @return the serialversionuid
		 */
		public static long getSerialversionuid() {
			return serialVersionUID;
		}

}