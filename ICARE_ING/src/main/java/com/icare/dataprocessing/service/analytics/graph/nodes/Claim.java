package com.icare.dataprocessing.service.analytics.graph.nodes;

import java.math.BigDecimal;

public class Claim {
private String tcn;
private Integer memberId;
private Integer providerId;
private Long totalBilledAmount;
private String principleDiagCode;
public String getTcn() {
	return tcn;
}
public void setTcn(String tcn) {
	this.tcn = tcn;
}
public Integer getMemberId() {
	return memberId;
}
public void setMemberId(Integer memberId) {
	this.memberId = memberId;
}
public Integer getProviderId() {
	return providerId;
}
public void setProviderId(Integer providerId) {
	this.providerId = providerId;
}
public  Long getTotalBilledAmount() {
	return totalBilledAmount;
}
public void setTotalBilledAmount( Long totalBilledAmount) {
	this.totalBilledAmount = totalBilledAmount;
}
public String getPrincipleDiagCode() {
	return principleDiagCode;
}
public void setPrincipleDiagCode(String principleDiagCode) {
	this.principleDiagCode = principleDiagCode;
}
public Claim( Integer memberId, Integer providerId,
		 Long totalBilledAmount) {
	super();
	this.memberId = memberId;
	this.providerId = providerId;
	this.totalBilledAmount = totalBilledAmount;
}

}
