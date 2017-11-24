package com.ahp.cas.domains.claims;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonProperty;

// TODO: Auto-generated Javadoc
/**
 * The Class ClmHdrXProcedure.
 */
public class ClmHdrXProcedure implements Serializable {
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The clm hdr X procedure sid. */
	private long clmHdrXProcedureSid;

	/** The prcdr code. */
	@JsonProperty("ProcedureCode")
	private String prcdrCode;

	/** The prcdr code qlfr lkpcd. */
	@JsonProperty("ProcedureCodeQualifier")
	private String prcdrCodeQlfrLkpcd;

	/** The prcdr order sqnc nmbr. */
	@JsonProperty("ProcedureSequenceNo")
	private BigDecimal prcdrOrderSqncNmbr;
	
	/** The procedure iid.  - *** unused *****/
	private BigDecimal procedureIid;

	/** The procedure iid. - *****Actually used. *** */
	private BigDecimal prcdrIid;
	
	public BigDecimal getPrcdrIid() {
		return prcdrIid;
	}

	public void setPrcdrIid(BigDecimal prcdrIid) {
		this.prcdrIid = prcdrIid;
	}

	/** The procedure type qlfr. */
	@JsonProperty("ProcedureTypeQualifier")
	private String procedureTypeQlfr;

	/** The surgical prcdr date. */
	@JsonProperty("ProcedureDate")
	private Date surgicalPrcdrDate;

	/** The claim header. */
	@JsonBackReference
	private ClaimHeader claimHeader;

	/**
	 * Instantiates a new clm hdr X procedure.
	 */
	public ClmHdrXProcedure() {
	}

	/**
	 * Gets the prcdr code.
	 *
	 * @return the prcdr code
	 */
	public String getPrcdrCode() {
		return prcdrCode;
	}

	/**
	 * Sets the prcdr code.
	 *
	 * @param prcdrCode the new prcdr code
	 */
	public void setPrcdrCode(String prcdrCode) {
		this.prcdrCode = prcdrCode;
	}

	/**
	 * Gets the prcdr code qlfr lkpcd.
	 *
	 * @return the prcdr code qlfr lkpcd
	 */
	public String getPrcdrCodeQlfrLkpcd() {
		return prcdrCodeQlfrLkpcd;
	}

	/**
	 * Sets the prcdr code qlfr lkpcd.
	 *
	 * @param prcdrCodeQlfrLkpcd the new prcdr code qlfr lkpcd
	 */
	public void setPrcdrCodeQlfrLkpcd(String prcdrCodeQlfrLkpcd) {
		this.prcdrCodeQlfrLkpcd = prcdrCodeQlfrLkpcd;
	}

	/**
	 * Gets the prcdr order sqnc nmbr.
	 *
	 * @return the prcdr order sqnc nmbr
	 */
	public BigDecimal getPrcdrOrderSqncNmbr() {
		return prcdrOrderSqncNmbr;
	}

	/**
	 * Sets the prcdr order sqnc nmbr.
	 *
	 * @param prcdrOrderSqncNmbr the new prcdr order sqnc nmbr
	 */
	public void setPrcdrOrderSqncNmbr(BigDecimal prcdrOrderSqncNmbr) {
		this.prcdrOrderSqncNmbr = prcdrOrderSqncNmbr;
	}

	/**
	 * Gets the procedure iid.
	 *
	 * @return the procedure iid
	 */
	public BigDecimal getProcedureIid() {
		return procedureIid;
	}

	/**
	 * Sets the procedure iid.
	 *
	 * @param procedureIid the new procedure iid
	 */
	public void setProcedureIid(BigDecimal procedureIid) {
		this.procedureIid = procedureIid;
	}

	/**
	 * Gets the procedure type qlfr.
	 *
	 * @return the procedure type qlfr
	 */
	public String getProcedureTypeQlfr() {
		return procedureTypeQlfr;
	}

	/**
	 * Sets the procedure type qlfr.
	 *
	 * @param procedureTypeQlfr the new procedure type qlfr
	 */
	public void setProcedureTypeQlfr(String procedureTypeQlfr) {
		this.procedureTypeQlfr = procedureTypeQlfr;
	}

	/**
	 * Gets the surgical prcdr date.
	 *
	 * @return the surgical prcdr date
	 */
	public Date getSurgicalPrcdrDate() {
		return surgicalPrcdrDate;
	}

	/**
	 * Sets the surgical prcdr date.
	 *
	 * @param surgicalPrcdrDate the new surgical prcdr date
	 */
	public void setSurgicalPrcdrDate(Date surgicalPrcdrDate) {
		this.surgicalPrcdrDate = surgicalPrcdrDate;
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
	 * Gets the serialversionuid.
	 *
	 * @return the serialversionuid
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	/**
	 * Gets the clm hdr X procedure sid.
	 *
	 * @return the clm hdr X procedure sid
	 */
	public long getClmHdrXProcedureSid() {
		return clmHdrXProcedureSid;
	}

	/**
	 * Sets the clm hdr X procedure sid.
	 *
	 * @param clmHdrXProcedureSid the new clm hdr X procedure sid
	 */
	public void setClmHdrXProcedureSid(long clmHdrXProcedureSid) {
		this.clmHdrXProcedureSid = clmHdrXProcedureSid;
	}

}