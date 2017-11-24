package com.ahp.cas.domains.reference;

import java.io.Serializable;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the "PROCEDURE" database table.
 * 
 */
@Entity
@Table(name="\"PROCEDURE\"")
@NamedQuery(name="Procedure.findAll", query="SELECT p FROM Procedure p")
@JsonIdentityInfo(generator=ObjectIdGenerators.IntSequenceGenerator.class, property="@id")
public class Procedure implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="PROCEDURE_IID")
	private long procedureIid;

	@Column(name="CREATED_BY")
	private BigDecimal createdBy;

	@Temporal(TemporalType.DATE)
	@Column(name="CREATED_DATE")
	private Date createdDate;

	@Column(name="DATA_SOURCE_LKPCD")
	private String dataSourceLkpcd;

	@Column(name="MODIFIED_BY")
	private BigDecimal modifiedBy;

	@Temporal(TemporalType.DATE)
	@Column(name="MODIFIED_DATE")
	private Date modifiedDate;

	@Column(name="PRCDR_CODE")
	private String prcdrCode;

	@Column(name="PRCDR_CTGRY_LKPCD")
	private String prcdrCtgryLkpcd;

	@Column(name="PRCDR_SHORT_DESC")
	private String prcdrShortDesc;

	@Column(name="RATE_EXCEPTION_FLAG")
	private String rateExceptionFlag;


	//bi-directional many-to-one association to ProcedureDetail
	@OneToMany(mappedBy="procedure")
	private List<ProcedureDetail> procedureDetails;


	public Procedure() {
	}

	public long getProcedureIid() {
		return this.procedureIid;
	}

	public void setProcedureIid(long procedureIid) {
		this.procedureIid = procedureIid;
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

	public String getPrcdrCode() {
		return this.prcdrCode;
	}

	public void setPrcdrCode(String prcdrCode) {
		this.prcdrCode = prcdrCode;
	}

	public String getPrcdrCtgryLkpcd() {
		return this.prcdrCtgryLkpcd;
	}

	public void setPrcdrCtgryLkpcd(String prcdrCtgryLkpcd) {
		this.prcdrCtgryLkpcd = prcdrCtgryLkpcd;
	}

	public String getPrcdrShortDesc() {
		return this.prcdrShortDesc;
	}

	public void setPrcdrShortDesc(String prcdrShortDesc) {
		this.prcdrShortDesc = prcdrShortDesc;
	}

	public String getRateExceptionFlag() {
		return this.rateExceptionFlag;
	}

	public void setRateExceptionFlag(String rateExceptionFlag) {
		this.rateExceptionFlag = rateExceptionFlag;
	}


	public List<ProcedureDetail> getProcedureDetails() {
		return this.procedureDetails;
	}

	public void setProcedureDetails(List<ProcedureDetail> procedureDetails) {
		this.procedureDetails = procedureDetails;
	}

	public ProcedureDetail addProcedureDetail(ProcedureDetail procedureDetail) {
		getProcedureDetails().add(procedureDetail);
		procedureDetail.setProcedure(this);

		return procedureDetail;
	}

	public ProcedureDetail removeProcedureDetail(ProcedureDetail procedureDetail) {
		getProcedureDetails().remove(procedureDetail);
		procedureDetail.setProcedure(null);

		return procedureDetail;
	}

}