package com.ahp.cas.domains.reference;

import java.io.Serializable;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the PROCEDURE_DETAIL database table.
 * 
 */
@Entity
@Table(name="PROCEDURE_DETAIL")
@NamedQuery(name="ProcedureDetail.findAll", query="SELECT p FROM ProcedureDetail p")
@JsonIdentityInfo(generator=ObjectIdGenerators.IntSequenceGenerator.class, property="@id")
public class ProcedureDetail implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="PRCDR_DTL_SID")
	private long prcdrDtlSid;

	@Column(name="ADDITIONAL_SERVICE_UNITS")
	private BigDecimal additionalServiceUnits;

	@Column(name="CREATED_BY")
	private BigDecimal createdBy;

	@Temporal(TemporalType.DATE)
	@Column(name="CREATED_DATE")
	private Date createdDate;

	@Column(name="DATA_SOURCE_LKPCD")
	private String dataSourceLkpcd;

	@Column(name="FOLLOW_UP_DAYS")
	private BigDecimal followUpDays;

	@Column(name="GENDER_LKPCD")
	private String genderLkpcd;

	@Column(name="HCPCS_ANSTHS_BASE_UNITS")
	private BigDecimal hcpcsAnsthsBaseUnits;

	@Column(name="HCPCS_BETOS_LKPCD")
	private String hcpcsBetosLkpcd;

	@Temporal(TemporalType.DATE)
	@Column(name="HCPCS_END_DATE")
	private Date hcpcsEndDate;

	@Temporal(TemporalType.DATE)
	@Column(name="HCPCS_START_DATE")
	private Date hcpcsStartDate;

	@Column(name="MODIFIED_BY")
	private BigDecimal modifiedBy;

	@Temporal(TemporalType.DATE)
	@Column(name="MODIFIED_DATE")
	private Date modifiedDate;

	@Column(name="PRCDR_LONG_DESC")
	private String prcdrLongDesc;

	@Column(name="PRCDR_SHORT_DESC")
	private String prcdrShortDesc;

	@Column(name="PRCDR_STATE_DESC")
	private String prcdrStateDesc;

	@Column(name="PRCDR_SUBCTGRY_LKPCD")
	private String prcdrSubctgryLkpcd;

	@Column(name="PRCDR_UNITS")
	private BigDecimal prcdrUnits;

	@Column(name="UNIT_TYPE_LKPCD")
	private String unitTypeLkpcd;

	@Column(name="UOM_CODE")
	private String uomCode;

	//bi-directional many-to-one association to Procedure
	@ManyToOne
	@JoinColumn(name="PROCEDURE_IID")
	private Procedure procedure;

	public ProcedureDetail() {
	}

	public long getPrcdrDtlSid() {
		return this.prcdrDtlSid;
	}

	public void setPrcdrDtlSid(long prcdrDtlSid) {
		this.prcdrDtlSid = prcdrDtlSid;
	}

	public BigDecimal getAdditionalServiceUnits() {
		return this.additionalServiceUnits;
	}

	public void setAdditionalServiceUnits(BigDecimal additionalServiceUnits) {
		this.additionalServiceUnits = additionalServiceUnits;
	}

	public BigDecimal getCreatedBy() {
		return this.createdBy;
	}

	public void setCreatedBy(BigDecimal createdBy) {
		this.createdBy = createdBy;
	}

	public Date getCreatedDate() {
		return this.createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public String getDataSourceLkpcd() {
		return this.dataSourceLkpcd;
	}

	public void setDataSourceLkpcd(String dataSourceLkpcd) {
		this.dataSourceLkpcd = dataSourceLkpcd;
	}

	public BigDecimal getFollowUpDays() {
		return this.followUpDays;
	}

	public void setFollowUpDays(BigDecimal followUpDays) {
		this.followUpDays = followUpDays;
	}

	public String getGenderLkpcd() {
		return this.genderLkpcd;
	}

	public void setGenderLkpcd(String genderLkpcd) {
		this.genderLkpcd = genderLkpcd;
	}

	public BigDecimal getHcpcsAnsthsBaseUnits() {
		return this.hcpcsAnsthsBaseUnits;
	}

	public void setHcpcsAnsthsBaseUnits(BigDecimal hcpcsAnsthsBaseUnits) {
		this.hcpcsAnsthsBaseUnits = hcpcsAnsthsBaseUnits;
	}

	public String getHcpcsBetosLkpcd() {
		return this.hcpcsBetosLkpcd;
	}

	public void setHcpcsBetosLkpcd(String hcpcsBetosLkpcd) {
		this.hcpcsBetosLkpcd = hcpcsBetosLkpcd;
	}

	public Date getHcpcsEndDate() {
		return this.hcpcsEndDate;
	}

	public void setHcpcsEndDate(Date hcpcsEndDate) {
		this.hcpcsEndDate = hcpcsEndDate;
	}

	public Date getHcpcsStartDate() {
		return this.hcpcsStartDate;
	}

	public void setHcpcsStartDate(Date hcpcsStartDate) {
		this.hcpcsStartDate = hcpcsStartDate;
	}

	public BigDecimal getModifiedBy() {
		return this.modifiedBy;
	}

	public void setModifiedBy(BigDecimal modifiedBy) {
		this.modifiedBy = modifiedBy;
	}

	public Date getModifiedDate() {
		return this.modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		this.modifiedDate = modifiedDate;
	}

	public String getPrcdrLongDesc() {
		return this.prcdrLongDesc;
	}

	public void setPrcdrLongDesc(String prcdrLongDesc) {
		this.prcdrLongDesc = prcdrLongDesc;
	}

	public String getPrcdrShortDesc() {
		return this.prcdrShortDesc;
	}

	public void setPrcdrShortDesc(String prcdrShortDesc) {
		this.prcdrShortDesc = prcdrShortDesc;
	}

	public String getPrcdrStateDesc() {
		return this.prcdrStateDesc;
	}

	public void setPrcdrStateDesc(String prcdrStateDesc) {
		this.prcdrStateDesc = prcdrStateDesc;
	}

	public String getPrcdrSubctgryLkpcd() {
		return this.prcdrSubctgryLkpcd;
	}

	public void setPrcdrSubctgryLkpcd(String prcdrSubctgryLkpcd) {
		this.prcdrSubctgryLkpcd = prcdrSubctgryLkpcd;
	}

	public BigDecimal getPrcdrUnits() {
		return this.prcdrUnits;
	}

	public void setPrcdrUnits(BigDecimal prcdrUnits) {
		this.prcdrUnits = prcdrUnits;
	}

	public String getUnitTypeLkpcd() {
		return this.unitTypeLkpcd;
	}

	public void setUnitTypeLkpcd(String unitTypeLkpcd) {
		this.unitTypeLkpcd = unitTypeLkpcd;
	}

	public String getUomCode() {
		return this.uomCode;
	}

	public void setUomCode(String uomCode) {
		this.uomCode = uomCode;
	}

	public Procedure getProcedure() {
		return this.procedure;
	}

	public void setProcedure(Procedure procedure) {
		this.procedure = procedure;
	}


}