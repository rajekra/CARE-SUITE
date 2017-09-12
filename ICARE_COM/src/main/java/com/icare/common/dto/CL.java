package com.icare.common.dto;

import java.math.BigDecimal;
import java.util.Date;

public class CL {
	private String claimLineTcn;
	private String fromServiceDate;
	private String toServiceDate;
	private String revenueCode;
	private String prcdrCode;
	private String billedUnits;
	private String billedAmount;
	private String paidAmount;
	public String getClaimLineTcn() {
		return claimLineTcn;
	}
	public void setClaimLineTcn(String claimLineTcn) {
		this.claimLineTcn = claimLineTcn;
	}
	public String getFromServiceDate() {
		return fromServiceDate;
	}
	public void setFromServiceDate(String fromServiceDate) {
		this.fromServiceDate = fromServiceDate;
	}
	public String getToServiceDate() {
		return toServiceDate;
	}
	public void setToServiceDate(String toServiceDate) {
		this.toServiceDate = toServiceDate;
	}
	public String getRevenueCode() {
		return revenueCode;
	}
	public void setRevenueCode(String revenueCode) {
		this.revenueCode = revenueCode;
	}
	public String getPrcdrCode() {
		return prcdrCode;
	}
	public void setPrcdrCode(String prcdrCode) {
		this.prcdrCode = prcdrCode;
	}
	public String getBilledUnits() {
		return billedUnits;
	}
	public void setBilledUnits(String billedUnits) {
		this.billedUnits = billedUnits;
	}
	public String getBilledAmount() {
		return billedAmount;
	}
	public void setBilledAmount(String billedAmount) {
		this.billedAmount = billedAmount;
	}
	public String getPaidAmount() {
		return paidAmount;
	}
	public void setPaidAmount(String paidAmount) {
		this.paidAmount = paidAmount;
	}
	
}
