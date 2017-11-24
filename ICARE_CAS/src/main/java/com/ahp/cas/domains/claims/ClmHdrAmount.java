package com.ahp.cas.domains.claims;

import java.io.Serializable;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigDecimal;


public class ClmHdrAmount implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private long clmHdrAmountSid;
	
	@JsonProperty("PricingMethodCode")
	private String amountTypeLkpcd;
	
	@JsonProperty("MonetaryAmount")
	private BigDecimal clmAmountValue;
	
	@JsonBackReference
	private ClaimHeader claimHeader;

	public ClmHdrAmount() {
	}

	public String getAmountTypeLkpcd() {
		System.out.println("getAmountTypeLkpcd");
		return amountTypeLkpcd;
	}

	public void setAmountTypeLkpcd(String amountTypeLkpcd) {
		System.out.println("setAmountTypeLkpcd" + amountTypeLkpcd);
		this.amountTypeLkpcd = amountTypeLkpcd;
	}

	public BigDecimal getClmAmountValue() {
		return clmAmountValue;
	}

	public void setClmAmountValue(BigDecimal clmAmountValue) {
		this.clmAmountValue = clmAmountValue;
	}

	public ClaimHeader getClaimHeader() {
		return claimHeader;
	}

	public void setClaimHeader(ClaimHeader claimHeader) {
		this.claimHeader = claimHeader;
	}

	public long getClmHdrAmountSid() {
		return clmHdrAmountSid;
	}

	public void setClmHdrAmountSid(long clmHdrAmountSid) {
		this.clmHdrAmountSid = clmHdrAmountSid;
	}

}