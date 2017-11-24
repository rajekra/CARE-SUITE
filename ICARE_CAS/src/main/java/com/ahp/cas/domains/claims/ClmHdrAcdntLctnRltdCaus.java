package com.ahp.cas.domains.claims;

import java.io.Serializable;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigDecimal;
import java.util.Date;

public class ClmHdrAcdntLctnRltdCaus implements Serializable {
	private static final long serialVersionUID = 1L;
	private long clmHdrAcdntLctnRltdCsSid;
	
	@JsonProperty("AccidentDate")
	private Date accidentDate;
	
	@JsonProperty("AutoAccidentCountryCode")
	private String countryCode;
	
	@JsonProperty("AccidentRelatedCause1")
	private String rltdCause1Lkpcd;
	
	@JsonProperty("AccidentRelatedCause2")
	private String rltdCause2Lkpcd;
	
	@JsonProperty("AccidentRelatedCause3")
	private String rltdCause3Lkpcd;
	
	@JsonProperty("AutoAccidentStateOrProvCode")
	private String statePrvncCode;
	
	@JsonBackReference
	private ClaimHeader claimHeader;

	public ClmHdrAcdntLctnRltdCaus() {
	}

	public long getClmHdrAcdntLctnRltdCsSid() {
		return clmHdrAcdntLctnRltdCsSid;
	}

	public void setClmHdrAcdntLctnRltdCsSid(long clmHdrAcdntLctnRltdCsSid) {
		this.clmHdrAcdntLctnRltdCsSid = clmHdrAcdntLctnRltdCsSid;
	}

	public Date getAccidentDate() {
		return accidentDate;
	}

	public void setAccidentDate(Date accidentDate) {
		this.accidentDate = accidentDate;
	}

	public String getCountryCode() {
		return countryCode;
	}

	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}


	public String getRltdCause1Lkpcd() {
		return rltdCause1Lkpcd;
	}

	public void setRltdCause1Lkpcd(String rltdCause1Lkpcd) {
		this.rltdCause1Lkpcd = rltdCause1Lkpcd;
	}

	public String getRltdCause2Lkpcd() {
		return rltdCause2Lkpcd;
	}

	public void setRltdCause2Lkpcd(String rltdCause2Lkpcd) {
		this.rltdCause2Lkpcd = rltdCause2Lkpcd;
	}

	public String getRltdCause3Lkpcd() {
		return rltdCause3Lkpcd;
	}

	public void setRltdCause3Lkpcd(String rltdCause3Lkpcd) {
		this.rltdCause3Lkpcd = rltdCause3Lkpcd;
	}

	public String getStatePrvncCode() {
		return statePrvncCode;
	}

	public void setStatePrvncCode(String statePrvncCode) {
		this.statePrvncCode = statePrvncCode;
	}

	public ClaimHeader getClaimHeader() {
		return claimHeader;
	}

	public void setClaimHeader(ClaimHeader claimHeader) {
		this.claimHeader = claimHeader;
	}

}