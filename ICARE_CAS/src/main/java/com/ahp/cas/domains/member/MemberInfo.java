package com.ahp.cas.domains.member;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.Type;

@Entity
@Table(name ="MBR_INFO")
public class MemberInfo implements Serializable {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = -13946345525490030L;

	private String id;
	private Long mbrSid;
	private String firstName;
	private String middleName;
	private String lastName;
	private Character genderLkpcd;
	private Date birthDate ;
	private Date mortalityDate ;
	private String socialSecurityNmbr ;
	private Date fromDate;
	private Date toDate ;
	private Integer statusCid;
	private Character oprtnlFlag;
	private String programCode ;
	private String caseNmbr;
	private String caseTypeLkpcd ;
	private String masterCase;
	private Date injuryDate;
	private String injuryTypeLkpcd ;
	private String injurySourceLkpcd;
	private String agencyCodeLkpcd ;
	private Date caseCreatedDate ;
	private String caseStatusLkpcd;
	private String sfcFlag;
	private String tplStatusLkpcd;
	private String identifier;
	
	
	@Column(name = "IDNTFR")
	public String getIdentifier() {
		return identifier;
	}
	public void setIdentifier(String identifier) {
		this.identifier = identifier;
	}
	
	@Id
	@Type(type = "objectid")
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	@Column(name = "MBR_SID")
	public Long getMbrSid() {
		return mbrSid;
	}
	public void setMbrSid(Long mbrSid) {
		this.mbrSid = mbrSid;
	}
	
	@Column(name = "FIRST_NAME")
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	@Column(name = "MIDDLE_NAME")
	public String getMiddleName() {
		return middleName;
	}
	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}
	
	@Column(name = "LAST_NAME")
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	@Column(name = "GENDER_LKPCD", length=1)
	public Character getGenderLkpcd() {
		return genderLkpcd;
	}
	public void setGenderLkpcd(Character genderLkpcd) {
		this.genderLkpcd = genderLkpcd;
	}
	
	@Temporal(TemporalType.DATE)
	@Column(name = "BIRTH_DATE")
	public Date getBirthDate() {
		return birthDate;
	}
	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}
	
	@Temporal(TemporalType.DATE)
	@Column(name = "MORTALITY_DATE")
	public Date getMortalityDate() {
		return mortalityDate;
	}
	public void setMortalityDate(Date mortalityDate) {
		this.mortalityDate = mortalityDate;
	}
	
	@Column(name = "SOCIAL_SECURITY_NMBR")
	public String getSocialSecurityNmbr() {
		return socialSecurityNmbr;
	}
	public void setSocialSecurityNmbr(String socialSecurityNmbr) {
		this.socialSecurityNmbr = socialSecurityNmbr;
	}
	
	@Temporal(TemporalType.DATE)
	@Column(name = "FROM_DATE")
	public Date getFromDate() {
		return fromDate;
	}
	public void setFromDate(Date fromDate) {
		this.fromDate = fromDate;
	}
	
	@Temporal(TemporalType.DATE)
	@Column(name = "TO_DATE")
	public Date getToDate() {
		return toDate;
	}
	public void setToDate(Date toDate) {
		this.toDate = toDate;
	}
	
	@Column(name = "STATUS_CID")
	public Integer getStatusCid() {
		return statusCid;
	}
	public void setStatusCid(Integer statusCid) {
		this.statusCid = statusCid;
	}
	
	@Column(name = "OPRTNL_FLAG")
	public Character getOprtnlFlag() {
		return oprtnlFlag;
	}
	public void setOprtnlFlag(Character oprtnlFlag) {
		this.oprtnlFlag = oprtnlFlag;
	}
	
	@Column(name = "PROGRAM_CODE")
	public String getProgramCode() {
		return programCode;
	}
	public void setProgramCode(String programCode) {
		this.programCode = programCode;
	}
	
	@Column(name = "CASE_NUMBER")
	public String getCaseNmbr() {
		return caseNmbr;
	}
	public void setCaseNmbr(String caseNmbr) {
		this.caseNmbr = caseNmbr;
	}
	
	@Column(name = "CASE_TYPE_LKPCD")
	public String getCaseTypeLkpcd() {
		return caseTypeLkpcd;
	}
	public void setCaseTypeLkpcd(String caseTypeLkpcd) {
		this.caseTypeLkpcd = caseTypeLkpcd;
	}
	
	@Column(name = "MASTER_CASE_NUMBER")
	public String getMasterCase() {
		return masterCase;
	}
	public void setMasterCase(String masterCase) {
		this.masterCase = masterCase;
	}
	
	@Temporal(TemporalType.DATE)
	@Column(name = "INJURY_DATE")
	public Date getInjuryDate() {
		return injuryDate;
	}
	public void setInjuryDate(Date injuryDate) {
		this.injuryDate = injuryDate;
	}
	
	@Column(name = "INJURY_TYPE_LKPCD")
	public String getInjuryTypeLkpcd() {
		return injuryTypeLkpcd;
	}
	public void setInjuryTypeLkpcd(String injuryTypeLkpcd) {
		this.injuryTypeLkpcd = injuryTypeLkpcd;
	}
	
	@Column(name = "INJURY_SOURCE_LKPCD")
	public String getInjurySourceLkpcd() {
		return injurySourceLkpcd;
	}
	public void setInjurySourceLkpcd(String injurySourceLkpcd) {
		this.injurySourceLkpcd = injurySourceLkpcd;
	}
	
	@Column(name = "AGENCY_CODE_LKPCD")
	public String getAgencyCodeLkpcd() {
		return agencyCodeLkpcd;
	}
	public void setAgencyCodeLkpcd(String agencycodelkpcd) {
		this.agencyCodeLkpcd = agencycodelkpcd;
	}
	
	@Temporal(TemporalType.DATE)
	@Column(name = "CASE_CREATED_DATE")
	public Date getCaseCreatedDate() {
		return caseCreatedDate;
	}
	
	public void setCaseCreatedDate(Date casecreateddate) {
		this.caseCreatedDate = casecreateddate;
	}
	
	@Column(name = "CASE_STATUS_LKPCD")
	public String getCaseStatusLkpcd() {
		return caseStatusLkpcd;
	}
	public void setCaseStatusLkpcd(String caseStatusLkpcd) {
		this.caseStatusLkpcd = caseStatusLkpcd;
	}
	
	@Column(name = "SFC_FLAG")
	public String getSfcFlag() {
		return sfcFlag;
	}
	public void setSfcFlag(String sfcFlag) {
		this.sfcFlag = sfcFlag;
	}
	
	@Column(name = "TPL_STATUS_LKPCD")
	public String getTplStatusLkpcd() {
		return tplStatusLkpcd;
	}
	public void setTplStatusLkpcd(String tplStatusLkpcd) {
		this.tplStatusLkpcd = tplStatusLkpcd;
	}
	@Override
	public String toString() {
		return "MemberInfo [mbrSid=" + mbrSid + ", firstName=" + firstName + ", middleName=" + middleName
				+ ", lastName=" + lastName + ", genderLkpcd=" + genderLkpcd + ", birthDate=" + birthDate
				+ ", mortalityDate=" + mortalityDate + ", socialSecurityNmbr=" + socialSecurityNmbr + ", fromDate="
				+ fromDate + ", toDate=" + toDate + ", statusCid=" + statusCid + ", oprtnlFlag=" + oprtnlFlag
				+ ", programCode=" + programCode + ", caseNmbr=" + caseNmbr + ", caseTypeLkpcd=" + caseTypeLkpcd
				+ ", masterCase=" + masterCase + ", injuryDate=" + injuryDate + ", injuryTypeLkpcd=" + injuryTypeLkpcd
				+ ", injurySourceLkpcd=" + injurySourceLkpcd + ", agencyCodeLkpcd=" + agencyCodeLkpcd
				+ ", caseCreatedDate=" + caseCreatedDate + ", caseStatusLkpcd=" + caseStatusLkpcd + ", sfcFlag="
				+ sfcFlag + ", tplStatusLkpcd=" + tplStatusLkpcd + "]";
	}
		
	
	
		
	
	
	
}
