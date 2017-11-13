package com.icare.dataprocessing.service.examples.graph;

import java.math.BigDecimal;

public class Claim {
private String tcn;
private BigDecimal memberId;
private BigDecimal providerId;
private BigDecimal totalBilledAmount;
private String principleDiagCode;
public String getTcn() {
	return tcn;
}
public void setTcn(String tcn) {
	this.tcn = tcn;
}
public BigDecimal getMemberId() {
	return memberId;
}
public void setMemberId(BigDecimal memberId) {
	this.memberId = memberId;
}
public BigDecimal getProviderId() {
	return providerId;
}
public void setProviderId(BigDecimal providerId) {
	this.providerId = providerId;
}
public BigDecimal getTotalBilledAmount() {
	return totalBilledAmount;
}
public void setTotalBilledAmount(BigDecimal totalBilledAmount) {
	this.totalBilledAmount = totalBilledAmount;
}
public String getPrincipleDiagCode() {
	return principleDiagCode;
}
public void setPrincipleDiagCode(String principleDiagCode) {
	this.principleDiagCode = principleDiagCode;
}
public Claim( BigDecimal memberId, BigDecimal providerId,
		BigDecimal totalBilledAmount) {
	super();
	this.memberId = memberId;
	this.providerId = providerId;
	this.totalBilledAmount = totalBilledAmount;
}

}
