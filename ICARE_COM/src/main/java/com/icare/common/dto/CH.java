package com.icare.common.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class CH implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String inDate;
	private String mdc;
	private String tcn;
	private String fromServiceDate;
	private String toServiceDate;
	private BigDecimal blngNationalPrvdrIdntfr;
	private String blngPrvdrLctnZipCode;
	private BigDecimal srvcngNationalPrvdrIdntfr;
	private String srvcngPrvdrLctnZipCode;
	private String attendingNationalPrvdrIdntfr;
	private String operatingPhyNationalPrvdrIdntfr;
	private String othOeratingPhyNationalPrvdrIdntfr;
	private String faciType_BillFirstDigit;
	private String servType_BillSecondDigit;
	private String freqType_BillThirdDigit;
	private String admissionDate;
	private String admissionHour;
	private String admissionSourceLkpcd;
	private String admissionTypeLkpcd;
	
	//Discharge status
	private String patientStatusLkpcd;
	private String dischargeDate;
	private BigDecimal totalBilledAmount;
	private BigDecimal paidAmount;
	private String drgCode;
	private String apc;
	private String admtDiagCd;
	private String prncplDgnsCd;
	private String prncplDgnsPoa;
	private String mbrIdentifier;
	private String patientFirstName;
	private String patientLastName;
	private String patientBirthDate;
	private String patientGender;
	private String patientZip;
	private String patientState;
	private String d1;
	private String d1_poa;
	private String d2;
	private String d2_poa;
	private String d3;
	private String d3_poa;
	private String d4;
	private String d4_poa;
	private String d5;
	private String d5_poa;
	private String d6;
	private String d6_poa;
	private String d7;
	private String d7_poa;
	private String d8;
	private String d8_poa;
	private String d9;
	private String d9_poa;
	private String d10;
	private String d10_poa;
	private String d11;
	private String d11_poa;
	private String d12;
	private String d12_poa;
	private String d13;
	private String d13_poa;
	private String d14;
	private String d14_poa;
	private String d15;
	private String d15_poa;
	private String d16;
	private String d16_poa;
	private String d17;
	private String d17_poa;
	private String d18;
	private String d18_poa;
	private String d19;
	private String d19_poa;
	private String d20;
	private String d20_poa;
	private String d21;
	private String d21_poa;
	private String d22;
	private String d22_poa;
	private String d23;
	private String d23_poa;
	private String d24;
	private String d24_poa;
	private String de1;
	private String de1_poa;
	private String de2;
	private String de2_poa;
	private String de3;
	private String de3_poa;
	private String de4;
	private String de4_poa;
	private String de5;
	private String de5_poa;
	private String de6;
	private String de6_poa;
	private String de7;
	private String de7_poa;
	private String de8;
	private String de8_poa;
	private String de9;
	private String de9_poa;
	private String de10;
	private String de10_poa;
	private String de11;
	private String de11_poa;
	private String de12;
	private String de12_poa;
	private String prncplPrcdrCd;
	private String prncplPrcdrCdDate;
	private String p1;
	private String p1_dt;
	private String p2;
	private String p2_dt;
	private String p3;
	private String p3_dt;
	private String p4;
	private String p4_dt;
	private String p5;
	private String p5_dt;
	private String p6;
	private String p6_dt;
	private String p7;
	private String p7_dt;
	private String p8;
	private String p8_dt;
	private String p9;
	private String p9_dt;
	private String p10;
	private String p10_dt;
	private String p11;
	private String p11_dt;
	private String p12;
	private String p12_dt;
	private String p13;
	private String p13_dt;
	private String p14;
	private String p14_dt;
	private String p15;
	private String p15_dt;
	private String p16;
	private String p16_dt;
	private String p17;
	private String p17_dt;
	private String p18;
	private String p18_dt;
	private String p19;
	private String p19_dt;
	private String p20;
	private String p20_dt;
	private String p21;
	private String p21_dt;
	private String p22;
	private String p22_dt;
	private String p23;
	private String p23_dt;
	private String p24;
	private String p24_dt;
	private String rsn_cd_1;
	private String rsn_cd_;
	private String rsn_cd_3;
	private String cnd1;
	private String cnd2;
	private String cnd3;
	private String cnd4;
	private String cnd5;
	private String cnd6;
	private String cnd7;
	private String cnd8;
	private String cnd9;
	private String cnd10;
	private String cnd11;
	private String cnd12;
	private String cnd13;
	private String cnd14;
	private String cnd15;
	private String cnd16;
	private String cnd17;
	private String cnd18;
	private String cnd19;
	private String cnd20;
	private String cnd21;
	private String cnd22;
	private String cnd23;
	private String cnd24;
	private String ocr1;
	private String ocr1_dt;
	private String ocr2;
	private String ocr2_dt;
	private String ocr3;
	private String ocr3_dt;
	private String ocr4;
	private String ocr4_dt;
	private String ocr5;
	private String ocr5_dt;
	private String ocr6;
	private String ocr6_dt;
	private String ocr7;
	private String ocr7_dt;
	private String ocr8;
	private String ocr8_dt;
	private String ocr9;
	private String ocr9_dt;
	private String ocr10;
	private String ocr10_dt;
	private String ocr11;
	private String ocr11_dt;
	private String ocr12;
	private String ocr13_dt;
	private String ocr14;
	private String ocr14_dt;
	private String ocr15;
	private String ocr15_dt;
	private String ocr16;
	private String ocr16_dt;
	private String ocr17;
	private String ocr17_dt;
	private String ocr18;
	private String ocr18_dt;
	private String ocr19;
	private String ocr19_dt;
	private String ocr20;
	private String ocr20_dt;
	private String ocr21;
	private String ocr21_dt;
	private String ocr22;
	private String ocr22_dt;
	private String ocr23;
	private String ocr23_dt;
	private String ocr24;
	private String ocr24_dt;
	private String val1;
	private String val1_amt;
	private String val2;
	private String val2_amt;
	private String val3;
	private String val3_amt;
	private String val4;
	private String val4_amt;
	private String val5;
	private String val5_amt;
	private String val6;
	private String val6_amt;
	private String val7;
	private String val7_amt;
	private String val8;
	private String val8_amt;
	private String val9;
	private String val9_amt;
	private String val10;
	private String val10_amt;
	private String val11;
	private String val11_amt;
	private String val12;
	private String val13_amt;
	private String val14;
	private String val14_amt;
	private String val15;
	private String val15_amt;
	private String val16;
	private String val16_amt;
	private String val17;
	private String val17_amt;
	private String val18;
	private String val18_amt;
	private String val19;
	private String val19_amt;
	private String val20;
	private String val20_amt;
	private String val21;
	private String val21_amt;
	private String val22;
	private String val22_amt;
	private String val23;
	private String val23_amt;
	private String val24;
	private String val24_amt;
	private List<CL> lines = new ArrayList<CL>();
	public String getTcn() {
		return tcn;
	}
	public void setTcn(String tcn) {
		this.tcn = tcn;
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
	public BigDecimal getBlngNationalPrvdrIdntfr() {
		return blngNationalPrvdrIdntfr;
	}
	public void setBlngNationalPrvdrIdntfr(BigDecimal blngNationalPrvdrIdntfr) {
		this.blngNationalPrvdrIdntfr = blngNationalPrvdrIdntfr;
	}
	public String getBlngPrvdrLctnZipCode() {
		return blngPrvdrLctnZipCode;
	}
	public void setBlngPrvdrLctnZipCode(String blngPrvdrLctnZipCode) {
		this.blngPrvdrLctnZipCode = blngPrvdrLctnZipCode;
	}
	public BigDecimal getSrvcngNationalPrvdrIdntfr() {
		return srvcngNationalPrvdrIdntfr;
	}
	public void setSrvcngNationalPrvdrIdntfr(BigDecimal srvcngNationalPrvdrIdntfr) {
		this.srvcngNationalPrvdrIdntfr = srvcngNationalPrvdrIdntfr;
	}
	public String getSrvcngPrvdrLctnZipCode() {
		return srvcngPrvdrLctnZipCode;
	}
	public void setSrvcngPrvdrLctnZipCode(String srvcngPrvdrLctnZipCode) {
		this.srvcngPrvdrLctnZipCode = srvcngPrvdrLctnZipCode;
	}
	public String getAttendingNationalPrvdrIdntfr() {
		return attendingNationalPrvdrIdntfr;
	}
	public void setAttendingNationalPrvdrIdntfr(String attendingNationalPrvdrIdntfr) {
		this.attendingNationalPrvdrIdntfr = attendingNationalPrvdrIdntfr;
	}
	public String getOperatingPhyNationalPrvdrIdntfr() {
		return operatingPhyNationalPrvdrIdntfr;
	}
	public void setOperatingPhyNationalPrvdrIdntfr(
			String operatingPhyNationalPrvdrIdntfr) {
		this.operatingPhyNationalPrvdrIdntfr = operatingPhyNationalPrvdrIdntfr;
	}
	public String getOthOeratingPhyNationalPrvdrIdntfr() {
		return othOeratingPhyNationalPrvdrIdntfr;
	}
	public void setOthOeratingPhyNationalPrvdrIdntfr(
			String othOeratingPhyNationalPrvdrIdntfr) {
		this.othOeratingPhyNationalPrvdrIdntfr = othOeratingPhyNationalPrvdrIdntfr;
	}
	public String getFaciType_BillFirstDigit() {
		return faciType_BillFirstDigit;
	}
	public void setFaciType_BillFirstDigit(String faciType_BillFirstDigit) {
		this.faciType_BillFirstDigit = faciType_BillFirstDigit;
	}
	public String getServType_BillSecondDigit() {
		return servType_BillSecondDigit;
	}
	public void setServType_BillSecondDigit(String servType_BillSecondDigit) {
		this.servType_BillSecondDigit = servType_BillSecondDigit;
	}
	public String getFreqType_BillThirdDigit() {
		return freqType_BillThirdDigit;
	}
	public void setFreqType_BillThirdDigit(String freqType_BillThirdDigit) {
		this.freqType_BillThirdDigit = freqType_BillThirdDigit;
	}
	public String getAdmissionDate() {
		return admissionDate;
	}
	public void setAdmissionDate(String admissionDate) {
		this.admissionDate = admissionDate;
	}
	public String getAdmissionHour() {
		return admissionHour;
	}
	public void setAdmissionHour(String admissionHour) {
		this.admissionHour = admissionHour;
	}
	public String getAdmissionSourceLkpcd() {
		return admissionSourceLkpcd;
	}
	public void setAdmissionSourceLkpcd(String admissionSourceLkpcd) {
		this.admissionSourceLkpcd = admissionSourceLkpcd;
	}
	public String getAdmissionTypeLkpcd() {
		return admissionTypeLkpcd;
	}
	public void setAdmissionTypeLkpcd(String admissionTypeLkpcd) {
		this.admissionTypeLkpcd = admissionTypeLkpcd;
	}
	public String getPatientStatusLkpcd() {
		return patientStatusLkpcd;
	}
	public void setPatientStatusLkpcd(String patientStatusLkpcd) {
		this.patientStatusLkpcd = patientStatusLkpcd;
	}
	public String getDischargeDate() {
		return dischargeDate;
	}
	public void setDischargeDate(String dischargeDate) {
		this.dischargeDate = dischargeDate;
	}
	public BigDecimal getTotalBilledAmount() {
		return totalBilledAmount;
	}
	public void setTotalBilledAmount(BigDecimal totalBilledAmount) {
		this.totalBilledAmount = totalBilledAmount;
	}
	public BigDecimal getPaidAmount() {
		return paidAmount;
	}
	public void setPaidAmount(BigDecimal paidAmount) {
		this.paidAmount = paidAmount;
	}
	public String getDrgCode() {
		return drgCode;
	}
	public void setDrgCode(String drgCode) {
		this.drgCode = drgCode;
	}
	public String getApc() {
		return apc;
	}
	public void setApc(String apc) {
		this.apc = apc;
	}
	public String getAdmtDiagCd() {
		return admtDiagCd;
	}
	public void setAdmtDiagCd(String admtDiagCd) {
		this.admtDiagCd = admtDiagCd;
	}
	public String getPrncplDgnsCd() {
		return prncplDgnsCd;
	}
	public void setPrncplDgnsCd(String prncplDgnsCd) {
		this.prncplDgnsCd = prncplDgnsCd;
	}
	public String getPrncplDgnsPoa() {
		return prncplDgnsPoa;
	}
	public void setPrncplDgnsPoa(String prncplDgnsPoa) {
		this.prncplDgnsPoa = prncplDgnsPoa;
	}
	public String getMbrIdentifier() {
		return mbrIdentifier;
	}
	public void setMbrIdentifier(String mbrIdentifier) {
		this.mbrIdentifier = mbrIdentifier;
	}
	public String getPatientFirstName() {
		return patientFirstName;
	}
	public void setPatientFirstName(String patientFirstName) {
		this.patientFirstName = patientFirstName;
	}
	public String getPatientLastName() {
		return patientLastName;
	}
	public void setPatientLastName(String patientLastName) {
		this.patientLastName = patientLastName;
	}
	public String getPatientBirthDate() {
		return patientBirthDate;
	}
	public void setPatientBirthDate(String patientBirthDate) {
		this.patientBirthDate = patientBirthDate;
	}
	public String getPatientGender() {
		return patientGender;
	}
	public void setPatientGender(String patientGender) {
		this.patientGender = patientGender;
	}
	public String getPatientZip() {
		return patientZip;
	}
	public void setPatientZip(String patientZip) {
		this.patientZip = patientZip;
	}
	public String getPatientState() {
		return patientState;
	}
	public void setPatientState(String patientState) {
		this.patientState = patientState;
	}
	public String getD1() {
		return d1;
	}
	public void setD1(String d1) {
		this.d1 = d1;
	}
	public String getD1_poa() {
		return d1_poa;
	}
	public void setD1_poa(String d1_poa) {
		this.d1_poa = d1_poa;
	}
	public String getD2() {
		return d2;
	}
	public void setD2(String d2) {
		this.d2 = d2;
	}
	public String getD2_poa() {
		return d2_poa;
	}
	public void setD2_poa(String d2_poa) {
		this.d2_poa = d2_poa;
	}
	public String getD3() {
		return d3;
	}
	public void setD3(String d3) {
		this.d3 = d3;
	}
	public String getD3_poa() {
		return d3_poa;
	}
	public void setD3_poa(String d3_poa) {
		this.d3_poa = d3_poa;
	}
	public String getD4() {
		return d4;
	}
	public void setD4(String d4) {
		this.d4 = d4;
	}
	public String getD4_poa() {
		return d4_poa;
	}
	public void setD4_poa(String d4_poa) {
		this.d4_poa = d4_poa;
	}
	public String getD5() {
		return d5;
	}
	public void setD5(String d5) {
		this.d5 = d5;
	}
	public String getD5_poa() {
		return d5_poa;
	}
	public void setD5_poa(String d5_poa) {
		this.d5_poa = d5_poa;
	}
	public String getD6() {
		return d6;
	}
	public void setD6(String d6) {
		this.d6 = d6;
	}
	public String getD6_poa() {
		return d6_poa;
	}
	public void setD6_poa(String d6_poa) {
		this.d6_poa = d6_poa;
	}
	public String getD7() {
		return d7;
	}
	public void setD7(String d7) {
		this.d7 = d7;
	}
	public String getD7_poa() {
		return d7_poa;
	}
	public void setD7_poa(String d7_poa) {
		this.d7_poa = d7_poa;
	}
	public String getD8() {
		return d8;
	}
	public void setD8(String d8) {
		this.d8 = d8;
	}
	public String getD8_poa() {
		return d8_poa;
	}
	public void setD8_poa(String d8_poa) {
		this.d8_poa = d8_poa;
	}
	public String getD9() {
		return d9;
	}
	public void setD9(String d9) {
		this.d9 = d9;
	}
	public String getD9_poa() {
		return d9_poa;
	}
	public void setD9_poa(String d9_poa) {
		this.d9_poa = d9_poa;
	}
	public String getD10() {
		return d10;
	}
	public void setD10(String d10) {
		this.d10 = d10;
	}
	public String getD10_poa() {
		return d10_poa;
	}
	public void setD10_poa(String d10_poa) {
		this.d10_poa = d10_poa;
	}
	public String getD11() {
		return d11;
	}
	public void setD11(String d11) {
		this.d11 = d11;
	}
	public String getD11_poa() {
		return d11_poa;
	}
	public void setD11_poa(String d11_poa) {
		this.d11_poa = d11_poa;
	}
	public String getD12() {
		return d12;
	}
	public void setD12(String d12) {
		this.d12 = d12;
	}
	public String getD12_poa() {
		return d12_poa;
	}
	public void setD12_poa(String d12_poa) {
		this.d12_poa = d12_poa;
	}
	public String getD13() {
		return d13;
	}
	public void setD13(String d13) {
		this.d13 = d13;
	}
	public String getD13_poa() {
		return d13_poa;
	}
	public void setD13_poa(String d13_poa) {
		this.d13_poa = d13_poa;
	}
	public String getD14() {
		return d14;
	}
	public void setD14(String d14) {
		this.d14 = d14;
	}
	public String getD14_poa() {
		return d14_poa;
	}
	public void setD14_poa(String d14_poa) {
		this.d14_poa = d14_poa;
	}
	public String getD15() {
		return d15;
	}
	public void setD15(String d15) {
		this.d15 = d15;
	}
	public String getD15_poa() {
		return d15_poa;
	}
	public void setD15_poa(String d15_poa) {
		this.d15_poa = d15_poa;
	}
	public String getD16() {
		return d16;
	}
	public void setD16(String d16) {
		this.d16 = d16;
	}
	public String getD16_poa() {
		return d16_poa;
	}
	public void setD16_poa(String d16_poa) {
		this.d16_poa = d16_poa;
	}
	public String getD17() {
		return d17;
	}
	public void setD17(String d17) {
		this.d17 = d17;
	}
	public String getD17_poa() {
		return d17_poa;
	}
	public void setD17_poa(String d17_poa) {
		this.d17_poa = d17_poa;
	}
	public String getD18() {
		return d18;
	}
	public void setD18(String d18) {
		this.d18 = d18;
	}
	public String getD18_poa() {
		return d18_poa;
	}
	public void setD18_poa(String d18_poa) {
		this.d18_poa = d18_poa;
	}
	public String getD19() {
		return d19;
	}
	public void setD19(String d19) {
		this.d19 = d19;
	}
	public String getD19_poa() {
		return d19_poa;
	}
	public void setD19_poa(String d19_poa) {
		this.d19_poa = d19_poa;
	}
	public String getD20() {
		return d20;
	}
	public void setD20(String d20) {
		this.d20 = d20;
	}
	public String getD20_poa() {
		return d20_poa;
	}
	public void setD20_poa(String d20_poa) {
		this.d20_poa = d20_poa;
	}
	public String getD21() {
		return d21;
	}
	public void setD21(String d21) {
		this.d21 = d21;
	}
	public String getD21_poa() {
		return d21_poa;
	}
	public void setD21_poa(String d21_poa) {
		this.d21_poa = d21_poa;
	}
	public String getD22() {
		return d22;
	}
	public void setD22(String d22) {
		this.d22 = d22;
	}
	public String getD22_poa() {
		return d22_poa;
	}
	public void setD22_poa(String d22_poa) {
		this.d22_poa = d22_poa;
	}
	public String getD23() {
		return d23;
	}
	public void setD23(String d23) {
		this.d23 = d23;
	}
	public String getD23_poa() {
		return d23_poa;
	}
	public void setD23_poa(String d23_poa) {
		this.d23_poa = d23_poa;
	}
	public String getD24() {
		return d24;
	}
	public void setD24(String d24) {
		this.d24 = d24;
	}
	public String getD24_poa() {
		return d24_poa;
	}
	public void setD24_poa(String d24_poa) {
		this.d24_poa = d24_poa;
	}
	public String getDe1() {
		return de1;
	}
	public void setDe1(String de1) {
		this.de1 = de1;
	}
	public String getDe1_poa() {
		return de1_poa;
	}
	public void setDe1_poa(String de1_poa) {
		this.de1_poa = de1_poa;
	}
	public String getDe2() {
		return de2;
	}
	public void setDe2(String de2) {
		this.de2 = de2;
	}
	public String getDe2_poa() {
		return de2_poa;
	}
	public void setDe2_poa(String de2_poa) {
		this.de2_poa = de2_poa;
	}
	public String getDe3() {
		return de3;
	}
	public void setDe3(String de3) {
		this.de3 = de3;
	}
	public String getDe3_poa() {
		return de3_poa;
	}
	public void setDe3_poa(String de3_poa) {
		this.de3_poa = de3_poa;
	}
	public String getDe4() {
		return de4;
	}
	public void setDe4(String de4) {
		this.de4 = de4;
	}
	public String getDe4_poa() {
		return de4_poa;
	}
	public void setDe4_poa(String de4_poa) {
		this.de4_poa = de4_poa;
	}
	public String getDe5() {
		return de5;
	}
	public void setDe5(String de5) {
		this.de5 = de5;
	}
	public String getDe5_poa() {
		return de5_poa;
	}
	public void setDe5_poa(String de5_poa) {
		this.de5_poa = de5_poa;
	}
	public String getDe6() {
		return de6;
	}
	public void setDe6(String de6) {
		this.de6 = de6;
	}
	public String getDe6_poa() {
		return de6_poa;
	}
	public void setDe6_poa(String de6_poa) {
		this.de6_poa = de6_poa;
	}
	public String getDe7() {
		return de7;
	}
	public void setDe7(String de7) {
		this.de7 = de7;
	}
	public String getDe7_poa() {
		return de7_poa;
	}
	public void setDe7_poa(String de7_poa) {
		this.de7_poa = de7_poa;
	}
	public String getDe8() {
		return de8;
	}
	public void setDe8(String de8) {
		this.de8 = de8;
	}
	public String getDe8_poa() {
		return de8_poa;
	}
	public void setDe8_poa(String de8_poa) {
		this.de8_poa = de8_poa;
	}
	public String getDe9() {
		return de9;
	}
	public void setDe9(String de9) {
		this.de9 = de9;
	}
	public String getDe9_poa() {
		return de9_poa;
	}
	public void setDe9_poa(String de9_poa) {
		this.de9_poa = de9_poa;
	}
	public String getDe10() {
		return de10;
	}
	public void setDe10(String de10) {
		this.de10 = de10;
	}
	public String getDe10_poa() {
		return de10_poa;
	}
	public void setDe10_poa(String de10_poa) {
		this.de10_poa = de10_poa;
	}
	public String getDe11() {
		return de11;
	}
	public void setDe11(String de11) {
		this.de11 = de11;
	}
	public String getDe11_poa() {
		return de11_poa;
	}
	public void setDe11_poa(String de11_poa) {
		this.de11_poa = de11_poa;
	}
	public String getDe12() {
		return de12;
	}
	public void setDe12(String de12) {
		this.de12 = de12;
	}
	public String getDe12_poa() {
		return de12_poa;
	}
	public void setDe12_poa(String de12_poa) {
		this.de12_poa = de12_poa;
	}
	public String getPrncplPrcdrCd() {
		return prncplPrcdrCd;
	}
	public void setPrncplPrcdrCd(String prncplPrcdrCd) {
		this.prncplPrcdrCd = prncplPrcdrCd;
	}
	public String getPrncplPrcdrCdDate() {
		return prncplPrcdrCdDate;
	}
	public void setPrncplPrcdrCdDate(String prncplPrcdrCdDate) {
		this.prncplPrcdrCdDate = prncplPrcdrCdDate;
	}
	public String getP1() {
		return p1;
	}
	public void setP1(String p1) {
		this.p1 = p1;
	}
	public String getP1_dt() {
		return p1_dt;
	}
	public void setP1_dt(String p1_dt) {
		this.p1_dt = p1_dt;
	}
	public String getP2() {
		return p2;
	}
	public void setP2(String p2) {
		this.p2 = p2;
	}
	public String getP2_dt() {
		return p2_dt;
	}
	public void setP2_dt(String p2_dt) {
		this.p2_dt = p2_dt;
	}
	public String getP3() {
		return p3;
	}
	public void setP3(String p3) {
		this.p3 = p3;
	}
	public String getP3_dt() {
		return p3_dt;
	}
	public void setP3_dt(String p3_dt) {
		this.p3_dt = p3_dt;
	}
	public String getP4() {
		return p4;
	}
	public void setP4(String p4) {
		this.p4 = p4;
	}
	public String getP4_dt() {
		return p4_dt;
	}
	public void setP4_dt(String p4_dt) {
		this.p4_dt = p4_dt;
	}
	public String getP5() {
		return p5;
	}
	public void setP5(String p5) {
		this.p5 = p5;
	}
	public String getP5_dt() {
		return p5_dt;
	}
	public void setP5_dt(String p5_dt) {
		this.p5_dt = p5_dt;
	}
	public String getP6() {
		return p6;
	}
	public void setP6(String p6) {
		this.p6 = p6;
	}
	public String getP6_dt() {
		return p6_dt;
	}
	public void setP6_dt(String p6_dt) {
		this.p6_dt = p6_dt;
	}
	public String getP7() {
		return p7;
	}
	public void setP7(String p7) {
		this.p7 = p7;
	}
	public String getP7_dt() {
		return p7_dt;
	}
	public void setP7_dt(String p7_dt) {
		this.p7_dt = p7_dt;
	}
	public String getP8() {
		return p8;
	}
	public void setP8(String p8) {
		this.p8 = p8;
	}
	public String getP8_dt() {
		return p8_dt;
	}
	public void setP8_dt(String p8_dt) {
		this.p8_dt = p8_dt;
	}
	public String getP9() {
		return p9;
	}
	public void setP9(String p9) {
		this.p9 = p9;
	}
	public String getP9_dt() {
		return p9_dt;
	}
	public void setP9_dt(String p9_dt) {
		this.p9_dt = p9_dt;
	}
	public String getP10() {
		return p10;
	}
	public void setP10(String p10) {
		this.p10 = p10;
	}
	public String getP10_dt() {
		return p10_dt;
	}
	public void setP10_dt(String p10_dt) {
		this.p10_dt = p10_dt;
	}
	public String getP11() {
		return p11;
	}
	public void setP11(String p11) {
		this.p11 = p11;
	}
	public String getP11_dt() {
		return p11_dt;
	}
	public void setP11_dt(String p11_dt) {
		this.p11_dt = p11_dt;
	}
	public String getP12() {
		return p12;
	}
	public void setP12(String p12) {
		this.p12 = p12;
	}
	public String getP12_dt() {
		return p12_dt;
	}
	public void setP12_dt(String p12_dt) {
		this.p12_dt = p12_dt;
	}
	public String getP13() {
		return p13;
	}
	public void setP13(String p13) {
		this.p13 = p13;
	}
	public String getP13_dt() {
		return p13_dt;
	}
	public void setP13_dt(String p13_dt) {
		this.p13_dt = p13_dt;
	}
	public String getP14() {
		return p14;
	}
	public void setP14(String p14) {
		this.p14 = p14;
	}
	public String getP14_dt() {
		return p14_dt;
	}
	public void setP14_dt(String p14_dt) {
		this.p14_dt = p14_dt;
	}
	public String getP15() {
		return p15;
	}
	public void setP15(String p15) {
		this.p15 = p15;
	}
	public String getP15_dt() {
		return p15_dt;
	}
	public void setP15_dt(String p15_dt) {
		this.p15_dt = p15_dt;
	}
	public String getP16() {
		return p16;
	}
	public void setP16(String p16) {
		this.p16 = p16;
	}
	public String getP16_dt() {
		return p16_dt;
	}
	public void setP16_dt(String p16_dt) {
		this.p16_dt = p16_dt;
	}
	public String getP17() {
		return p17;
	}
	public void setP17(String p17) {
		this.p17 = p17;
	}
	public String getP17_dt() {
		return p17_dt;
	}
	public void setP17_dt(String p17_dt) {
		this.p17_dt = p17_dt;
	}
	public String getP18() {
		return p18;
	}
	public void setP18(String p18) {
		this.p18 = p18;
	}
	public String getP18_dt() {
		return p18_dt;
	}
	public void setP18_dt(String p18_dt) {
		this.p18_dt = p18_dt;
	}
	public String getP19() {
		return p19;
	}
	public void setP19(String p19) {
		this.p19 = p19;
	}
	public String getP19_dt() {
		return p19_dt;
	}
	public void setP19_dt(String p19_dt) {
		this.p19_dt = p19_dt;
	}
	public String getP20() {
		return p20;
	}
	public void setP20(String p20) {
		this.p20 = p20;
	}
	public String getP20_dt() {
		return p20_dt;
	}
	public void setP20_dt(String p20_dt) {
		this.p20_dt = p20_dt;
	}
	public String getP21() {
		return p21;
	}
	public void setP21(String p21) {
		this.p21 = p21;
	}
	public String getP21_dt() {
		return p21_dt;
	}
	public void setP21_dt(String p21_dt) {
		this.p21_dt = p21_dt;
	}
	public String getP22() {
		return p22;
	}
	public void setP22(String p22) {
		this.p22 = p22;
	}
	public String getP22_dt() {
		return p22_dt;
	}
	public void setP22_dt(String p22_dt) {
		this.p22_dt = p22_dt;
	}
	public String getP23() {
		return p23;
	}
	public void setP23(String p23) {
		this.p23 = p23;
	}
	public String getP23_dt() {
		return p23_dt;
	}
	public void setP23_dt(String p23_dt) {
		this.p23_dt = p23_dt;
	}
	public String getP24() {
		return p24;
	}
	public void setP24(String p24) {
		this.p24 = p24;
	}
	public String getP24_dt() {
		return p24_dt;
	}
	public void setP24_dt(String p24_dt) {
		this.p24_dt = p24_dt;
	}
	public String getRsn_cd_1() {
		return rsn_cd_1;
	}
	public void setRsn_cd_1(String rsn_cd_1) {
		this.rsn_cd_1 = rsn_cd_1;
	}
	public String getRsn_cd_() {
		return rsn_cd_;
	}
	public void setRsn_cd_(String rsn_cd_) {
		this.rsn_cd_ = rsn_cd_;
	}
	public String getRsn_cd_3() {
		return rsn_cd_3;
	}
	public void setRsn_cd_3(String rsn_cd_3) {
		this.rsn_cd_3 = rsn_cd_3;
	}
	public String getCnd1() {
		return cnd1;
	}
	public void setCnd1(String cnd1) {
		this.cnd1 = cnd1;
	}
	public String getCnd2() {
		return cnd2;
	}
	public void setCnd2(String cnd2) {
		this.cnd2 = cnd2;
	}
	public String getCnd3() {
		return cnd3;
	}
	public void setCnd3(String cnd3) {
		this.cnd3 = cnd3;
	}
	public String getCnd4() {
		return cnd4;
	}
	public void setCnd4(String cnd4) {
		this.cnd4 = cnd4;
	}
	public String getCnd5() {
		return cnd5;
	}
	public void setCnd5(String cnd5) {
		this.cnd5 = cnd5;
	}
	public String getCnd6() {
		return cnd6;
	}
	public void setCnd6(String cnd6) {
		this.cnd6 = cnd6;
	}
	public String getCnd7() {
		return cnd7;
	}
	public void setCnd7(String cnd7) {
		this.cnd7 = cnd7;
	}
	public String getCnd8() {
		return cnd8;
	}
	public void setCnd8(String cnd8) {
		this.cnd8 = cnd8;
	}
	public String getCnd9() {
		return cnd9;
	}
	public void setCnd9(String cnd9) {
		this.cnd9 = cnd9;
	}
	public String getCnd10() {
		return cnd10;
	}
	public void setCnd10(String cnd10) {
		this.cnd10 = cnd10;
	}
	public String getCnd11() {
		return cnd11;
	}
	public void setCnd11(String cnd11) {
		this.cnd11 = cnd11;
	}
	public String getCnd12() {
		return cnd12;
	}
	public void setCnd12(String cnd12) {
		this.cnd12 = cnd12;
	}
	public String getCnd13() {
		return cnd13;
	}
	public void setCnd13(String cnd13) {
		this.cnd13 = cnd13;
	}
	public String getCnd14() {
		return cnd14;
	}
	public void setCnd14(String cnd14) {
		this.cnd14 = cnd14;
	}
	public String getCnd15() {
		return cnd15;
	}
	public void setCnd15(String cnd15) {
		this.cnd15 = cnd15;
	}
	public String getCnd16() {
		return cnd16;
	}
	public void setCnd16(String cnd16) {
		this.cnd16 = cnd16;
	}
	public String getCnd17() {
		return cnd17;
	}
	public void setCnd17(String cnd17) {
		this.cnd17 = cnd17;
	}
	public String getCnd18() {
		return cnd18;
	}
	public void setCnd18(String cnd18) {
		this.cnd18 = cnd18;
	}
	public String getCnd19() {
		return cnd19;
	}
	public void setCnd19(String cnd19) {
		this.cnd19 = cnd19;
	}
	public String getCnd20() {
		return cnd20;
	}
	public void setCnd20(String cnd20) {
		this.cnd20 = cnd20;
	}
	public String getCnd21() {
		return cnd21;
	}
	public void setCnd21(String cnd21) {
		this.cnd21 = cnd21;
	}
	public String getCnd22() {
		return cnd22;
	}
	public void setCnd22(String cnd22) {
		this.cnd22 = cnd22;
	}
	public String getCnd23() {
		return cnd23;
	}
	public void setCnd23(String cnd23) {
		this.cnd23 = cnd23;
	}
	public String getCnd24() {
		return cnd24;
	}
	public void setCnd24(String cnd24) {
		this.cnd24 = cnd24;
	}
	public String getOcr1() {
		return ocr1;
	}
	public void setOcr1(String ocr1) {
		this.ocr1 = ocr1;
	}
	public String getOcr1_dt() {
		return ocr1_dt;
	}
	public void setOcr1_dt(String ocr1_dt) {
		this.ocr1_dt = ocr1_dt;
	}
	public String getOcr2() {
		return ocr2;
	}
	public void setOcr2(String ocr2) {
		this.ocr2 = ocr2;
	}
	public String getOcr2_dt() {
		return ocr2_dt;
	}
	public void setOcr2_dt(String ocr2_dt) {
		this.ocr2_dt = ocr2_dt;
	}
	public String getOcr3() {
		return ocr3;
	}
	public void setOcr3(String ocr3) {
		this.ocr3 = ocr3;
	}
	public String getOcr3_dt() {
		return ocr3_dt;
	}
	public void setOcr3_dt(String ocr3_dt) {
		this.ocr3_dt = ocr3_dt;
	}
	public String getOcr4() {
		return ocr4;
	}
	public void setOcr4(String ocr4) {
		this.ocr4 = ocr4;
	}
	public String getOcr4_dt() {
		return ocr4_dt;
	}
	public void setOcr4_dt(String ocr4_dt) {
		this.ocr4_dt = ocr4_dt;
	}
	public String getOcr5() {
		return ocr5;
	}
	public void setOcr5(String ocr5) {
		this.ocr5 = ocr5;
	}
	public String getOcr5_dt() {
		return ocr5_dt;
	}
	public void setOcr5_dt(String ocr5_dt) {
		this.ocr5_dt = ocr5_dt;
	}
	public String getOcr6() {
		return ocr6;
	}
	public void setOcr6(String ocr6) {
		this.ocr6 = ocr6;
	}
	public String getOcr6_dt() {
		return ocr6_dt;
	}
	public void setOcr6_dt(String ocr6_dt) {
		this.ocr6_dt = ocr6_dt;
	}
	public String getOcr7() {
		return ocr7;
	}
	public void setOcr7(String ocr7) {
		this.ocr7 = ocr7;
	}
	public String getOcr7_dt() {
		return ocr7_dt;
	}
	public void setOcr7_dt(String ocr7_dt) {
		this.ocr7_dt = ocr7_dt;
	}
	public String getOcr8() {
		return ocr8;
	}
	public void setOcr8(String ocr8) {
		this.ocr8 = ocr8;
	}
	public String getOcr8_dt() {
		return ocr8_dt;
	}
	public void setOcr8_dt(String ocr8_dt) {
		this.ocr8_dt = ocr8_dt;
	}
	public String getOcr9() {
		return ocr9;
	}
	public void setOcr9(String ocr9) {
		this.ocr9 = ocr9;
	}
	public String getOcr9_dt() {
		return ocr9_dt;
	}
	public void setOcr9_dt(String ocr9_dt) {
		this.ocr9_dt = ocr9_dt;
	}
	public String getOcr10() {
		return ocr10;
	}
	public void setOcr10(String ocr10) {
		this.ocr10 = ocr10;
	}
	public String getOcr10_dt() {
		return ocr10_dt;
	}
	public void setOcr10_dt(String ocr10_dt) {
		this.ocr10_dt = ocr10_dt;
	}
	public String getOcr11() {
		return ocr11;
	}
	public void setOcr11(String ocr11) {
		this.ocr11 = ocr11;
	}
	public String getOcr11_dt() {
		return ocr11_dt;
	}
	public void setOcr11_dt(String ocr11_dt) {
		this.ocr11_dt = ocr11_dt;
	}
	public String getOcr12() {
		return ocr12;
	}
	public void setOcr12(String ocr12) {
		this.ocr12 = ocr12;
	}
	public String getOcr13_dt() {
		return ocr13_dt;
	}
	public void setOcr13_dt(String ocr13_dt) {
		this.ocr13_dt = ocr13_dt;
	}
	public String getOcr14() {
		return ocr14;
	}
	public void setOcr14(String ocr14) {
		this.ocr14 = ocr14;
	}
	public String getOcr14_dt() {
		return ocr14_dt;
	}
	public void setOcr14_dt(String ocr14_dt) {
		this.ocr14_dt = ocr14_dt;
	}
	public String getOcr15() {
		return ocr15;
	}
	public void setOcr15(String ocr15) {
		this.ocr15 = ocr15;
	}
	public String getOcr15_dt() {
		return ocr15_dt;
	}
	public void setOcr15_dt(String ocr15_dt) {
		this.ocr15_dt = ocr15_dt;
	}
	public String getOcr16() {
		return ocr16;
	}
	public void setOcr16(String ocr16) {
		this.ocr16 = ocr16;
	}
	public String getOcr16_dt() {
		return ocr16_dt;
	}
	public void setOcr16_dt(String ocr16_dt) {
		this.ocr16_dt = ocr16_dt;
	}
	public String getOcr17() {
		return ocr17;
	}
	public void setOcr17(String ocr17) {
		this.ocr17 = ocr17;
	}
	public String getOcr17_dt() {
		return ocr17_dt;
	}
	public void setOcr17_dt(String ocr17_dt) {
		this.ocr17_dt = ocr17_dt;
	}
	public String getOcr18() {
		return ocr18;
	}
	public void setOcr18(String ocr18) {
		this.ocr18 = ocr18;
	}
	public String getOcr18_dt() {
		return ocr18_dt;
	}
	public void setOcr18_dt(String ocr18_dt) {
		this.ocr18_dt = ocr18_dt;
	}
	public String getOcr19() {
		return ocr19;
	}
	public void setOcr19(String ocr19) {
		this.ocr19 = ocr19;
	}
	public String getOcr19_dt() {
		return ocr19_dt;
	}
	public void setOcr19_dt(String ocr19_dt) {
		this.ocr19_dt = ocr19_dt;
	}
	public String getOcr20() {
		return ocr20;
	}
	public void setOcr20(String ocr20) {
		this.ocr20 = ocr20;
	}
	public String getOcr20_dt() {
		return ocr20_dt;
	}
	public void setOcr20_dt(String ocr20_dt) {
		this.ocr20_dt = ocr20_dt;
	}
	public String getOcr21() {
		return ocr21;
	}
	public void setOcr21(String ocr21) {
		this.ocr21 = ocr21;
	}
	public String getOcr21_dt() {
		return ocr21_dt;
	}
	public void setOcr21_dt(String ocr21_dt) {
		this.ocr21_dt = ocr21_dt;
	}
	public String getOcr22() {
		return ocr22;
	}
	public void setOcr22(String ocr22) {
		this.ocr22 = ocr22;
	}
	public String getOcr22_dt() {
		return ocr22_dt;
	}
	public void setOcr22_dt(String ocr22_dt) {
		this.ocr22_dt = ocr22_dt;
	}
	public String getOcr23() {
		return ocr23;
	}
	public void setOcr23(String ocr23) {
		this.ocr23 = ocr23;
	}
	public String getOcr23_dt() {
		return ocr23_dt;
	}
	public void setOcr23_dt(String ocr23_dt) {
		this.ocr23_dt = ocr23_dt;
	}
	public String getOcr24() {
		return ocr24;
	}
	public void setOcr24(String ocr24) {
		this.ocr24 = ocr24;
	}
	public String getOcr24_dt() {
		return ocr24_dt;
	}
	public void setOcr24_dt(String ocr24_dt) {
		this.ocr24_dt = ocr24_dt;
	}
	public String getVal1() {
		return val1;
	}
	public void setVal1(String val1) {
		this.val1 = val1;
	}
	public String getVal1_amt() {
		return val1_amt;
	}
	public void setVal1_amt(String val1_amt) {
		this.val1_amt = val1_amt;
	}
	public String getVal2() {
		return val2;
	}
	public void setVal2(String val2) {
		this.val2 = val2;
	}
	public String getVal2_amt() {
		return val2_amt;
	}
	public void setVal2_amt(String val2_amt) {
		this.val2_amt = val2_amt;
	}
	public String getVal3() {
		return val3;
	}
	public void setVal3(String val3) {
		this.val3 = val3;
	}
	public String getVal3_amt() {
		return val3_amt;
	}
	public void setVal3_amt(String val3_amt) {
		this.val3_amt = val3_amt;
	}
	public String getVal4() {
		return val4;
	}
	public void setVal4(String val4) {
		this.val4 = val4;
	}
	public String getVal4_amt() {
		return val4_amt;
	}
	public void setVal4_amt(String val4_amt) {
		this.val4_amt = val4_amt;
	}
	public String getVal5() {
		return val5;
	}
	public void setVal5(String val5) {
		this.val5 = val5;
	}
	public String getVal5_amt() {
		return val5_amt;
	}
	public void setVal5_amt(String val5_amt) {
		this.val5_amt = val5_amt;
	}
	public String getVal6() {
		return val6;
	}
	public void setVal6(String val6) {
		this.val6 = val6;
	}
	public String getVal6_amt() {
		return val6_amt;
	}
	public void setVal6_amt(String val6_amt) {
		this.val6_amt = val6_amt;
	}
	public String getVal7() {
		return val7;
	}
	public void setVal7(String val7) {
		this.val7 = val7;
	}
	public String getVal7_amt() {
		return val7_amt;
	}
	public void setVal7_amt(String val7_amt) {
		this.val7_amt = val7_amt;
	}
	public String getVal8() {
		return val8;
	}
	public void setVal8(String val8) {
		this.val8 = val8;
	}
	public String getVal8_amt() {
		return val8_amt;
	}
	public void setVal8_amt(String val8_amt) {
		this.val8_amt = val8_amt;
	}
	public String getVal9() {
		return val9;
	}
	public void setVal9(String val9) {
		this.val9 = val9;
	}
	public String getVal9_amt() {
		return val9_amt;
	}
	public void setVal9_amt(String val9_amt) {
		this.val9_amt = val9_amt;
	}
	public String getVal10() {
		return val10;
	}
	public void setVal10(String val10) {
		this.val10 = val10;
	}
	public String getVal10_amt() {
		return val10_amt;
	}
	public void setVal10_amt(String val10_amt) {
		this.val10_amt = val10_amt;
	}
	public String getVal11() {
		return val11;
	}
	public void setVal11(String val11) {
		this.val11 = val11;
	}
	public String getVal11_amt() {
		return val11_amt;
	}
	public void setVal11_amt(String val11_amt) {
		this.val11_amt = val11_amt;
	}
	public String getVal12() {
		return val12;
	}
	public void setVal12(String val12) {
		this.val12 = val12;
	}
	public String getVal13_amt() {
		return val13_amt;
	}
	public void setVal13_amt(String val13_amt) {
		this.val13_amt = val13_amt;
	}
	public String getVal14() {
		return val14;
	}
	public void setVal14(String val14) {
		this.val14 = val14;
	}
	public String getVal14_amt() {
		return val14_amt;
	}
	public void setVal14_amt(String val14_amt) {
		this.val14_amt = val14_amt;
	}
	public String getVal15() {
		return val15;
	}
	public void setVal15(String val15) {
		this.val15 = val15;
	}
	public String getVal15_amt() {
		return val15_amt;
	}
	public void setVal15_amt(String val15_amt) {
		this.val15_amt = val15_amt;
	}
	public String getVal16() {
		return val16;
	}
	public void setVal16(String val16) {
		this.val16 = val16;
	}
	public String getVal16_amt() {
		return val16_amt;
	}
	public void setVal16_amt(String val16_amt) {
		this.val16_amt = val16_amt;
	}
	public String getVal17() {
		return val17;
	}
	public void setVal17(String val17) {
		this.val17 = val17;
	}
	public String getVal17_amt() {
		return val17_amt;
	}
	public void setVal17_amt(String val17_amt) {
		this.val17_amt = val17_amt;
	}
	public String getVal18() {
		return val18;
	}
	public void setVal18(String val18) {
		this.val18 = val18;
	}
	public String getVal18_amt() {
		return val18_amt;
	}
	public void setVal18_amt(String val18_amt) {
		this.val18_amt = val18_amt;
	}
	public String getVal19() {
		return val19;
	}
	public void setVal19(String val19) {
		this.val19 = val19;
	}
	public String getVal19_amt() {
		return val19_amt;
	}
	public void setVal19_amt(String val19_amt) {
		this.val19_amt = val19_amt;
	}
	public String getVal20() {
		return val20;
	}
	public void setVal20(String val20) {
		this.val20 = val20;
	}
	public String getVal20_amt() {
		return val20_amt;
	}
	public void setVal20_amt(String val20_amt) {
		this.val20_amt = val20_amt;
	}
	public String getVal21() {
		return val21;
	}
	public void setVal21(String val21) {
		this.val21 = val21;
	}
	public String getVal21_amt() {
		return val21_amt;
	}
	public void setVal21_amt(String val21_amt) {
		this.val21_amt = val21_amt;
	}
	public String getVal22() {
		return val22;
	}
	public void setVal22(String val22) {
		this.val22 = val22;
	}
	public String getVal22_amt() {
		return val22_amt;
	}
	public void setVal22_amt(String val22_amt) {
		this.val22_amt = val22_amt;
	}
	public String getVal23() {
		return val23;
	}
	public void setVal23(String val23) {
		this.val23 = val23;
	}
	public String getVal23_amt() {
		return val23_amt;
	}
	public void setVal23_amt(String val23_amt) {
		this.val23_amt = val23_amt;
	}
	public String getVal24() {
		return val24;
	}
	public void setVal24(String val24) {
		this.val24 = val24;
	}
	public String getVal24_amt() {
		return val24_amt;
	}
	public void setVal24_amt(String val24_amt) {
		this.val24_amt = val24_amt;
	}
	public List<CL> getLines() {
		return lines;
	}
	public void setLines(List<CL> lines) {
		this.lines = lines;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((admissionDate == null) ? 0 : admissionDate.hashCode());
		result = prime * result
				+ ((admissionHour == null) ? 0 : admissionHour.hashCode());
		result = prime
				* result
				+ ((admissionSourceLkpcd == null) ? 0 : admissionSourceLkpcd
						.hashCode());
		result = prime
				* result
				+ ((admissionTypeLkpcd == null) ? 0 : admissionTypeLkpcd
						.hashCode());
		result = prime * result
				+ ((admtDiagCd == null) ? 0 : admtDiagCd.hashCode());
		result = prime * result + ((apc == null) ? 0 : apc.hashCode());
		result = prime
				* result
				+ ((attendingNationalPrvdrIdntfr == null) ? 0
						: attendingNationalPrvdrIdntfr.hashCode());
		result = prime
				* result
				+ ((blngNationalPrvdrIdntfr == null) ? 0
						: blngNationalPrvdrIdntfr.hashCode());
		result = prime
				* result
				+ ((blngPrvdrLctnZipCode == null) ? 0 : blngPrvdrLctnZipCode
						.hashCode());
		result = prime * result + ((cnd1 == null) ? 0 : cnd1.hashCode());
		result = prime * result + ((cnd10 == null) ? 0 : cnd10.hashCode());
		result = prime * result + ((cnd11 == null) ? 0 : cnd11.hashCode());
		result = prime * result + ((cnd12 == null) ? 0 : cnd12.hashCode());
		result = prime * result + ((cnd13 == null) ? 0 : cnd13.hashCode());
		result = prime * result + ((cnd14 == null) ? 0 : cnd14.hashCode());
		result = prime * result + ((cnd15 == null) ? 0 : cnd15.hashCode());
		result = prime * result + ((cnd16 == null) ? 0 : cnd16.hashCode());
		result = prime * result + ((cnd17 == null) ? 0 : cnd17.hashCode());
		result = prime * result + ((cnd18 == null) ? 0 : cnd18.hashCode());
		result = prime * result + ((cnd19 == null) ? 0 : cnd19.hashCode());
		result = prime * result + ((cnd2 == null) ? 0 : cnd2.hashCode());
		result = prime * result + ((cnd20 == null) ? 0 : cnd20.hashCode());
		result = prime * result + ((cnd21 == null) ? 0 : cnd21.hashCode());
		result = prime * result + ((cnd22 == null) ? 0 : cnd22.hashCode());
		result = prime * result + ((cnd23 == null) ? 0 : cnd23.hashCode());
		result = prime * result + ((cnd24 == null) ? 0 : cnd24.hashCode());
		result = prime * result + ((cnd3 == null) ? 0 : cnd3.hashCode());
		result = prime * result + ((cnd4 == null) ? 0 : cnd4.hashCode());
		result = prime * result + ((cnd5 == null) ? 0 : cnd5.hashCode());
		result = prime * result + ((cnd6 == null) ? 0 : cnd6.hashCode());
		result = prime * result + ((cnd7 == null) ? 0 : cnd7.hashCode());
		result = prime * result + ((cnd8 == null) ? 0 : cnd8.hashCode());
		result = prime * result + ((cnd9 == null) ? 0 : cnd9.hashCode());
		result = prime * result + ((d1 == null) ? 0 : d1.hashCode());
		result = prime * result + ((d10 == null) ? 0 : d10.hashCode());
		result = prime * result + ((d10_poa == null) ? 0 : d10_poa.hashCode());
		result = prime * result + ((d11 == null) ? 0 : d11.hashCode());
		result = prime * result + ((d11_poa == null) ? 0 : d11_poa.hashCode());
		result = prime * result + ((d12 == null) ? 0 : d12.hashCode());
		result = prime * result + ((d12_poa == null) ? 0 : d12_poa.hashCode());
		result = prime * result + ((d13 == null) ? 0 : d13.hashCode());
		result = prime * result + ((d13_poa == null) ? 0 : d13_poa.hashCode());
		result = prime * result + ((d14 == null) ? 0 : d14.hashCode());
		result = prime * result + ((d14_poa == null) ? 0 : d14_poa.hashCode());
		result = prime * result + ((d15 == null) ? 0 : d15.hashCode());
		result = prime * result + ((d15_poa == null) ? 0 : d15_poa.hashCode());
		result = prime * result + ((d16 == null) ? 0 : d16.hashCode());
		result = prime * result + ((d16_poa == null) ? 0 : d16_poa.hashCode());
		result = prime * result + ((d17 == null) ? 0 : d17.hashCode());
		result = prime * result + ((d17_poa == null) ? 0 : d17_poa.hashCode());
		result = prime * result + ((d18 == null) ? 0 : d18.hashCode());
		result = prime * result + ((d18_poa == null) ? 0 : d18_poa.hashCode());
		result = prime * result + ((d19 == null) ? 0 : d19.hashCode());
		result = prime * result + ((d19_poa == null) ? 0 : d19_poa.hashCode());
		result = prime * result + ((d1_poa == null) ? 0 : d1_poa.hashCode());
		result = prime * result + ((d2 == null) ? 0 : d2.hashCode());
		result = prime * result + ((d20 == null) ? 0 : d20.hashCode());
		result = prime * result + ((d20_poa == null) ? 0 : d20_poa.hashCode());
		result = prime * result + ((d21 == null) ? 0 : d21.hashCode());
		result = prime * result + ((d21_poa == null) ? 0 : d21_poa.hashCode());
		result = prime * result + ((d22 == null) ? 0 : d22.hashCode());
		result = prime * result + ((d22_poa == null) ? 0 : d22_poa.hashCode());
		result = prime * result + ((d23 == null) ? 0 : d23.hashCode());
		result = prime * result + ((d23_poa == null) ? 0 : d23_poa.hashCode());
		result = prime * result + ((d24 == null) ? 0 : d24.hashCode());
		result = prime * result + ((d24_poa == null) ? 0 : d24_poa.hashCode());
		result = prime * result + ((d2_poa == null) ? 0 : d2_poa.hashCode());
		result = prime * result + ((d3 == null) ? 0 : d3.hashCode());
		result = prime * result + ((d3_poa == null) ? 0 : d3_poa.hashCode());
		result = prime * result + ((d4 == null) ? 0 : d4.hashCode());
		result = prime * result + ((d4_poa == null) ? 0 : d4_poa.hashCode());
		result = prime * result + ((d5 == null) ? 0 : d5.hashCode());
		result = prime * result + ((d5_poa == null) ? 0 : d5_poa.hashCode());
		result = prime * result + ((d6 == null) ? 0 : d6.hashCode());
		result = prime * result + ((d6_poa == null) ? 0 : d6_poa.hashCode());
		result = prime * result + ((d7 == null) ? 0 : d7.hashCode());
		result = prime * result + ((d7_poa == null) ? 0 : d7_poa.hashCode());
		result = prime * result + ((d8 == null) ? 0 : d8.hashCode());
		result = prime * result + ((d8_poa == null) ? 0 : d8_poa.hashCode());
		result = prime * result + ((d9 == null) ? 0 : d9.hashCode());
		result = prime * result + ((d9_poa == null) ? 0 : d9_poa.hashCode());
		result = prime * result + ((de1 == null) ? 0 : de1.hashCode());
		result = prime * result + ((de10 == null) ? 0 : de10.hashCode());
		result = prime * result
				+ ((de10_poa == null) ? 0 : de10_poa.hashCode());
		result = prime * result + ((de11 == null) ? 0 : de11.hashCode());
		result = prime * result
				+ ((de11_poa == null) ? 0 : de11_poa.hashCode());
		result = prime * result + ((de12 == null) ? 0 : de12.hashCode());
		result = prime * result
				+ ((de12_poa == null) ? 0 : de12_poa.hashCode());
		result = prime * result + ((de1_poa == null) ? 0 : de1_poa.hashCode());
		result = prime * result + ((de2 == null) ? 0 : de2.hashCode());
		result = prime * result + ((de2_poa == null) ? 0 : de2_poa.hashCode());
		result = prime * result + ((de3 == null) ? 0 : de3.hashCode());
		result = prime * result + ((de3_poa == null) ? 0 : de3_poa.hashCode());
		result = prime * result + ((de4 == null) ? 0 : de4.hashCode());
		result = prime * result + ((de4_poa == null) ? 0 : de4_poa.hashCode());
		result = prime * result + ((de5 == null) ? 0 : de5.hashCode());
		result = prime * result + ((de5_poa == null) ? 0 : de5_poa.hashCode());
		result = prime * result + ((de6 == null) ? 0 : de6.hashCode());
		result = prime * result + ((de6_poa == null) ? 0 : de6_poa.hashCode());
		result = prime * result + ((de7 == null) ? 0 : de7.hashCode());
		result = prime * result + ((de7_poa == null) ? 0 : de7_poa.hashCode());
		result = prime * result + ((de8 == null) ? 0 : de8.hashCode());
		result = prime * result + ((de8_poa == null) ? 0 : de8_poa.hashCode());
		result = prime * result + ((de9 == null) ? 0 : de9.hashCode());
		result = prime * result + ((de9_poa == null) ? 0 : de9_poa.hashCode());
		result = prime * result
				+ ((dischargeDate == null) ? 0 : dischargeDate.hashCode());
		result = prime * result + ((drgCode == null) ? 0 : drgCode.hashCode());
		result = prime
				* result
				+ ((faciType_BillFirstDigit == null) ? 0
						: faciType_BillFirstDigit.hashCode());
		result = prime
				* result
				+ ((freqType_BillThirdDigit == null) ? 0
						: freqType_BillThirdDigit.hashCode());
		result = prime * result
				+ ((fromServiceDate == null) ? 0 : fromServiceDate.hashCode());
		result = prime * result + ((lines == null) ? 0 : lines.hashCode());
		result = prime * result
				+ ((mbrIdentifier == null) ? 0 : mbrIdentifier.hashCode());
		result = prime * result + ((ocr1 == null) ? 0 : ocr1.hashCode());
		result = prime * result + ((ocr10 == null) ? 0 : ocr10.hashCode());
		result = prime * result
				+ ((ocr10_dt == null) ? 0 : ocr10_dt.hashCode());
		result = prime * result + ((ocr11 == null) ? 0 : ocr11.hashCode());
		result = prime * result
				+ ((ocr11_dt == null) ? 0 : ocr11_dt.hashCode());
		result = prime * result + ((ocr12 == null) ? 0 : ocr12.hashCode());
		result = prime * result
				+ ((ocr13_dt == null) ? 0 : ocr13_dt.hashCode());
		result = prime * result + ((ocr14 == null) ? 0 : ocr14.hashCode());
		result = prime * result
				+ ((ocr14_dt == null) ? 0 : ocr14_dt.hashCode());
		result = prime * result + ((ocr15 == null) ? 0 : ocr15.hashCode());
		result = prime * result
				+ ((ocr15_dt == null) ? 0 : ocr15_dt.hashCode());
		result = prime * result + ((ocr16 == null) ? 0 : ocr16.hashCode());
		result = prime * result
				+ ((ocr16_dt == null) ? 0 : ocr16_dt.hashCode());
		result = prime * result + ((ocr17 == null) ? 0 : ocr17.hashCode());
		result = prime * result
				+ ((ocr17_dt == null) ? 0 : ocr17_dt.hashCode());
		result = prime * result + ((ocr18 == null) ? 0 : ocr18.hashCode());
		result = prime * result
				+ ((ocr18_dt == null) ? 0 : ocr18_dt.hashCode());
		result = prime * result + ((ocr19 == null) ? 0 : ocr19.hashCode());
		result = prime * result
				+ ((ocr19_dt == null) ? 0 : ocr19_dt.hashCode());
		result = prime * result + ((ocr1_dt == null) ? 0 : ocr1_dt.hashCode());
		result = prime * result + ((ocr2 == null) ? 0 : ocr2.hashCode());
		result = prime * result + ((ocr20 == null) ? 0 : ocr20.hashCode());
		result = prime * result
				+ ((ocr20_dt == null) ? 0 : ocr20_dt.hashCode());
		result = prime * result + ((ocr21 == null) ? 0 : ocr21.hashCode());
		result = prime * result
				+ ((ocr21_dt == null) ? 0 : ocr21_dt.hashCode());
		result = prime * result + ((ocr22 == null) ? 0 : ocr22.hashCode());
		result = prime * result
				+ ((ocr22_dt == null) ? 0 : ocr22_dt.hashCode());
		result = prime * result + ((ocr23 == null) ? 0 : ocr23.hashCode());
		result = prime * result
				+ ((ocr23_dt == null) ? 0 : ocr23_dt.hashCode());
		result = prime * result + ((ocr24 == null) ? 0 : ocr24.hashCode());
		result = prime * result
				+ ((ocr24_dt == null) ? 0 : ocr24_dt.hashCode());
		result = prime * result + ((ocr2_dt == null) ? 0 : ocr2_dt.hashCode());
		result = prime * result + ((ocr3 == null) ? 0 : ocr3.hashCode());
		result = prime * result + ((ocr3_dt == null) ? 0 : ocr3_dt.hashCode());
		result = prime * result + ((ocr4 == null) ? 0 : ocr4.hashCode());
		result = prime * result + ((ocr4_dt == null) ? 0 : ocr4_dt.hashCode());
		result = prime * result + ((ocr5 == null) ? 0 : ocr5.hashCode());
		result = prime * result + ((ocr5_dt == null) ? 0 : ocr5_dt.hashCode());
		result = prime * result + ((ocr6 == null) ? 0 : ocr6.hashCode());
		result = prime * result + ((ocr6_dt == null) ? 0 : ocr6_dt.hashCode());
		result = prime * result + ((ocr7 == null) ? 0 : ocr7.hashCode());
		result = prime * result + ((ocr7_dt == null) ? 0 : ocr7_dt.hashCode());
		result = prime * result + ((ocr8 == null) ? 0 : ocr8.hashCode());
		result = prime * result + ((ocr8_dt == null) ? 0 : ocr8_dt.hashCode());
		result = prime * result + ((ocr9 == null) ? 0 : ocr9.hashCode());
		result = prime * result + ((ocr9_dt == null) ? 0 : ocr9_dt.hashCode());
		result = prime
				* result
				+ ((operatingPhyNationalPrvdrIdntfr == null) ? 0
						: operatingPhyNationalPrvdrIdntfr.hashCode());
		result = prime
				* result
				+ ((othOeratingPhyNationalPrvdrIdntfr == null) ? 0
						: othOeratingPhyNationalPrvdrIdntfr.hashCode());
		result = prime * result + ((p1 == null) ? 0 : p1.hashCode());
		result = prime * result + ((p10 == null) ? 0 : p10.hashCode());
		result = prime * result + ((p10_dt == null) ? 0 : p10_dt.hashCode());
		result = prime * result + ((p11 == null) ? 0 : p11.hashCode());
		result = prime * result + ((p11_dt == null) ? 0 : p11_dt.hashCode());
		result = prime * result + ((p12 == null) ? 0 : p12.hashCode());
		result = prime * result + ((p12_dt == null) ? 0 : p12_dt.hashCode());
		result = prime * result + ((p13 == null) ? 0 : p13.hashCode());
		result = prime * result + ((p13_dt == null) ? 0 : p13_dt.hashCode());
		result = prime * result + ((p14 == null) ? 0 : p14.hashCode());
		result = prime * result + ((p14_dt == null) ? 0 : p14_dt.hashCode());
		result = prime * result + ((p15 == null) ? 0 : p15.hashCode());
		result = prime * result + ((p15_dt == null) ? 0 : p15_dt.hashCode());
		result = prime * result + ((p16 == null) ? 0 : p16.hashCode());
		result = prime * result + ((p16_dt == null) ? 0 : p16_dt.hashCode());
		result = prime * result + ((p17 == null) ? 0 : p17.hashCode());
		result = prime * result + ((p17_dt == null) ? 0 : p17_dt.hashCode());
		result = prime * result + ((p18 == null) ? 0 : p18.hashCode());
		result = prime * result + ((p18_dt == null) ? 0 : p18_dt.hashCode());
		result = prime * result + ((p19 == null) ? 0 : p19.hashCode());
		result = prime * result + ((p19_dt == null) ? 0 : p19_dt.hashCode());
		result = prime * result + ((p1_dt == null) ? 0 : p1_dt.hashCode());
		result = prime * result + ((p2 == null) ? 0 : p2.hashCode());
		result = prime * result + ((p20 == null) ? 0 : p20.hashCode());
		result = prime * result + ((p20_dt == null) ? 0 : p20_dt.hashCode());
		result = prime * result + ((p21 == null) ? 0 : p21.hashCode());
		result = prime * result + ((p21_dt == null) ? 0 : p21_dt.hashCode());
		result = prime * result + ((p22 == null) ? 0 : p22.hashCode());
		result = prime * result + ((p22_dt == null) ? 0 : p22_dt.hashCode());
		result = prime * result + ((p23 == null) ? 0 : p23.hashCode());
		result = prime * result + ((p23_dt == null) ? 0 : p23_dt.hashCode());
		result = prime * result + ((p24 == null) ? 0 : p24.hashCode());
		result = prime * result + ((p24_dt == null) ? 0 : p24_dt.hashCode());
		result = prime * result + ((p2_dt == null) ? 0 : p2_dt.hashCode());
		result = prime * result + ((p3 == null) ? 0 : p3.hashCode());
		result = prime * result + ((p3_dt == null) ? 0 : p3_dt.hashCode());
		result = prime * result + ((p4 == null) ? 0 : p4.hashCode());
		result = prime * result + ((p4_dt == null) ? 0 : p4_dt.hashCode());
		result = prime * result + ((p5 == null) ? 0 : p5.hashCode());
		result = prime * result + ((p5_dt == null) ? 0 : p5_dt.hashCode());
		result = prime * result + ((p6 == null) ? 0 : p6.hashCode());
		result = prime * result + ((p6_dt == null) ? 0 : p6_dt.hashCode());
		result = prime * result + ((p7 == null) ? 0 : p7.hashCode());
		result = prime * result + ((p7_dt == null) ? 0 : p7_dt.hashCode());
		result = prime * result + ((p8 == null) ? 0 : p8.hashCode());
		result = prime * result + ((p8_dt == null) ? 0 : p8_dt.hashCode());
		result = prime * result + ((p9 == null) ? 0 : p9.hashCode());
		result = prime * result + ((p9_dt == null) ? 0 : p9_dt.hashCode());
		result = prime * result
				+ ((paidAmount == null) ? 0 : paidAmount.hashCode());
		result = prime
				* result
				+ ((patientBirthDate == null) ? 0 : patientBirthDate.hashCode());
		result = prime
				* result
				+ ((patientFirstName == null) ? 0 : patientFirstName.hashCode());
		result = prime * result
				+ ((patientGender == null) ? 0 : patientGender.hashCode());
		result = prime * result
				+ ((patientLastName == null) ? 0 : patientLastName.hashCode());
		result = prime * result
				+ ((patientState == null) ? 0 : patientState.hashCode());
		result = prime
				* result
				+ ((patientStatusLkpcd == null) ? 0 : patientStatusLkpcd
						.hashCode());
		result = prime * result
				+ ((patientZip == null) ? 0 : patientZip.hashCode());
		result = prime * result
				+ ((prncplDgnsCd == null) ? 0 : prncplDgnsCd.hashCode());
		result = prime * result
				+ ((prncplDgnsPoa == null) ? 0 : prncplDgnsPoa.hashCode());
		result = prime * result
				+ ((prncplPrcdrCd == null) ? 0 : prncplPrcdrCd.hashCode());
		result = prime
				* result
				+ ((prncplPrcdrCdDate == null) ? 0 : prncplPrcdrCdDate
						.hashCode());
		result = prime * result + ((rsn_cd_ == null) ? 0 : rsn_cd_.hashCode());
		result = prime * result
				+ ((rsn_cd_1 == null) ? 0 : rsn_cd_1.hashCode());
		result = prime * result
				+ ((rsn_cd_3 == null) ? 0 : rsn_cd_3.hashCode());
		result = prime
				* result
				+ ((servType_BillSecondDigit == null) ? 0
						: servType_BillSecondDigit.hashCode());
		result = prime
				* result
				+ ((srvcngNationalPrvdrIdntfr == null) ? 0
						: srvcngNationalPrvdrIdntfr.hashCode());
		result = prime
				* result
				+ ((srvcngPrvdrLctnZipCode == null) ? 0
						: srvcngPrvdrLctnZipCode.hashCode());
		result = prime * result + ((tcn == null) ? 0 : tcn.hashCode());
		result = prime * result
				+ ((toServiceDate == null) ? 0 : toServiceDate.hashCode());
		result = prime
				* result
				+ ((totalBilledAmount == null) ? 0 : totalBilledAmount
						.hashCode());
		result = prime * result + ((val1 == null) ? 0 : val1.hashCode());
		result = prime * result + ((val10 == null) ? 0 : val10.hashCode());
		result = prime * result
				+ ((val10_amt == null) ? 0 : val10_amt.hashCode());
		result = prime * result + ((val11 == null) ? 0 : val11.hashCode());
		result = prime * result
				+ ((val11_amt == null) ? 0 : val11_amt.hashCode());
		result = prime * result + ((val12 == null) ? 0 : val12.hashCode());
		result = prime * result
				+ ((val13_amt == null) ? 0 : val13_amt.hashCode());
		result = prime * result + ((val14 == null) ? 0 : val14.hashCode());
		result = prime * result
				+ ((val14_amt == null) ? 0 : val14_amt.hashCode());
		result = prime * result + ((val15 == null) ? 0 : val15.hashCode());
		result = prime * result
				+ ((val15_amt == null) ? 0 : val15_amt.hashCode());
		result = prime * result + ((val16 == null) ? 0 : val16.hashCode());
		result = prime * result
				+ ((val16_amt == null) ? 0 : val16_amt.hashCode());
		result = prime * result + ((val17 == null) ? 0 : val17.hashCode());
		result = prime * result
				+ ((val17_amt == null) ? 0 : val17_amt.hashCode());
		result = prime * result + ((val18 == null) ? 0 : val18.hashCode());
		result = prime * result
				+ ((val18_amt == null) ? 0 : val18_amt.hashCode());
		result = prime * result + ((val19 == null) ? 0 : val19.hashCode());
		result = prime * result
				+ ((val19_amt == null) ? 0 : val19_amt.hashCode());
		result = prime * result
				+ ((val1_amt == null) ? 0 : val1_amt.hashCode());
		result = prime * result + ((val2 == null) ? 0 : val2.hashCode());
		result = prime * result + ((val20 == null) ? 0 : val20.hashCode());
		result = prime * result
				+ ((val20_amt == null) ? 0 : val20_amt.hashCode());
		result = prime * result + ((val21 == null) ? 0 : val21.hashCode());
		result = prime * result
				+ ((val21_amt == null) ? 0 : val21_amt.hashCode());
		result = prime * result + ((val22 == null) ? 0 : val22.hashCode());
		result = prime * result
				+ ((val22_amt == null) ? 0 : val22_amt.hashCode());
		result = prime * result + ((val23 == null) ? 0 : val23.hashCode());
		result = prime * result
				+ ((val23_amt == null) ? 0 : val23_amt.hashCode());
		result = prime * result + ((val24 == null) ? 0 : val24.hashCode());
		result = prime * result
				+ ((val24_amt == null) ? 0 : val24_amt.hashCode());
		result = prime * result
				+ ((val2_amt == null) ? 0 : val2_amt.hashCode());
		result = prime * result + ((val3 == null) ? 0 : val3.hashCode());
		result = prime * result
				+ ((val3_amt == null) ? 0 : val3_amt.hashCode());
		result = prime * result + ((val4 == null) ? 0 : val4.hashCode());
		result = prime * result
				+ ((val4_amt == null) ? 0 : val4_amt.hashCode());
		result = prime * result + ((val5 == null) ? 0 : val5.hashCode());
		result = prime * result
				+ ((val5_amt == null) ? 0 : val5_amt.hashCode());
		result = prime * result + ((val6 == null) ? 0 : val6.hashCode());
		result = prime * result
				+ ((val6_amt == null) ? 0 : val6_amt.hashCode());
		result = prime * result + ((val7 == null) ? 0 : val7.hashCode());
		result = prime * result
				+ ((val7_amt == null) ? 0 : val7_amt.hashCode());
		result = prime * result + ((val8 == null) ? 0 : val8.hashCode());
		result = prime * result
				+ ((val8_amt == null) ? 0 : val8_amt.hashCode());
		result = prime * result + ((val9 == null) ? 0 : val9.hashCode());
		result = prime * result
				+ ((val9_amt == null) ? 0 : val9_amt.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CH other = (CH) obj;
		if (admissionDate == null) {
			if (other.admissionDate != null)
				return false;
		} else if (!admissionDate.equals(other.admissionDate))
			return false;
		if (admissionHour == null) {
			if (other.admissionHour != null)
				return false;
		} else if (!admissionHour.equals(other.admissionHour))
			return false;
		if (admissionSourceLkpcd == null) {
			if (other.admissionSourceLkpcd != null)
				return false;
		} else if (!admissionSourceLkpcd.equals(other.admissionSourceLkpcd))
			return false;
		if (admissionTypeLkpcd == null) {
			if (other.admissionTypeLkpcd != null)
				return false;
		} else if (!admissionTypeLkpcd.equals(other.admissionTypeLkpcd))
			return false;
		if (admtDiagCd == null) {
			if (other.admtDiagCd != null)
				return false;
		} else if (!admtDiagCd.equals(other.admtDiagCd))
			return false;
		if (apc == null) {
			if (other.apc != null)
				return false;
		} else if (!apc.equals(other.apc))
			return false;
		if (attendingNationalPrvdrIdntfr == null) {
			if (other.attendingNationalPrvdrIdntfr != null)
				return false;
		} else if (!attendingNationalPrvdrIdntfr
				.equals(other.attendingNationalPrvdrIdntfr))
			return false;
		if (blngNationalPrvdrIdntfr == null) {
			if (other.blngNationalPrvdrIdntfr != null)
				return false;
		} else if (!blngNationalPrvdrIdntfr
				.equals(other.blngNationalPrvdrIdntfr))
			return false;
		if (blngPrvdrLctnZipCode == null) {
			if (other.blngPrvdrLctnZipCode != null)
				return false;
		} else if (!blngPrvdrLctnZipCode.equals(other.blngPrvdrLctnZipCode))
			return false;
		if (cnd1 == null) {
			if (other.cnd1 != null)
				return false;
		} else if (!cnd1.equals(other.cnd1))
			return false;
		if (cnd10 == null) {
			if (other.cnd10 != null)
				return false;
		} else if (!cnd10.equals(other.cnd10))
			return false;
		if (cnd11 == null) {
			if (other.cnd11 != null)
				return false;
		} else if (!cnd11.equals(other.cnd11))
			return false;
		if (cnd12 == null) {
			if (other.cnd12 != null)
				return false;
		} else if (!cnd12.equals(other.cnd12))
			return false;
		if (cnd13 == null) {
			if (other.cnd13 != null)
				return false;
		} else if (!cnd13.equals(other.cnd13))
			return false;
		if (cnd14 == null) {
			if (other.cnd14 != null)
				return false;
		} else if (!cnd14.equals(other.cnd14))
			return false;
		if (cnd15 == null) {
			if (other.cnd15 != null)
				return false;
		} else if (!cnd15.equals(other.cnd15))
			return false;
		if (cnd16 == null) {
			if (other.cnd16 != null)
				return false;
		} else if (!cnd16.equals(other.cnd16))
			return false;
		if (cnd17 == null) {
			if (other.cnd17 != null)
				return false;
		} else if (!cnd17.equals(other.cnd17))
			return false;
		if (cnd18 == null) {
			if (other.cnd18 != null)
				return false;
		} else if (!cnd18.equals(other.cnd18))
			return false;
		if (cnd19 == null) {
			if (other.cnd19 != null)
				return false;
		} else if (!cnd19.equals(other.cnd19))
			return false;
		if (cnd2 == null) {
			if (other.cnd2 != null)
				return false;
		} else if (!cnd2.equals(other.cnd2))
			return false;
		if (cnd20 == null) {
			if (other.cnd20 != null)
				return false;
		} else if (!cnd20.equals(other.cnd20))
			return false;
		if (cnd21 == null) {
			if (other.cnd21 != null)
				return false;
		} else if (!cnd21.equals(other.cnd21))
			return false;
		if (cnd22 == null) {
			if (other.cnd22 != null)
				return false;
		} else if (!cnd22.equals(other.cnd22))
			return false;
		if (cnd23 == null) {
			if (other.cnd23 != null)
				return false;
		} else if (!cnd23.equals(other.cnd23))
			return false;
		if (cnd24 == null) {
			if (other.cnd24 != null)
				return false;
		} else if (!cnd24.equals(other.cnd24))
			return false;
		if (cnd3 == null) {
			if (other.cnd3 != null)
				return false;
		} else if (!cnd3.equals(other.cnd3))
			return false;
		if (cnd4 == null) {
			if (other.cnd4 != null)
				return false;
		} else if (!cnd4.equals(other.cnd4))
			return false;
		if (cnd5 == null) {
			if (other.cnd5 != null)
				return false;
		} else if (!cnd5.equals(other.cnd5))
			return false;
		if (cnd6 == null) {
			if (other.cnd6 != null)
				return false;
		} else if (!cnd6.equals(other.cnd6))
			return false;
		if (cnd7 == null) {
			if (other.cnd7 != null)
				return false;
		} else if (!cnd7.equals(other.cnd7))
			return false;
		if (cnd8 == null) {
			if (other.cnd8 != null)
				return false;
		} else if (!cnd8.equals(other.cnd8))
			return false;
		if (cnd9 == null) {
			if (other.cnd9 != null)
				return false;
		} else if (!cnd9.equals(other.cnd9))
			return false;
		if (d1 == null) {
			if (other.d1 != null)
				return false;
		} else if (!d1.equals(other.d1))
			return false;
		if (d10 == null) {
			if (other.d10 != null)
				return false;
		} else if (!d10.equals(other.d10))
			return false;
		if (d10_poa == null) {
			if (other.d10_poa != null)
				return false;
		} else if (!d10_poa.equals(other.d10_poa))
			return false;
		if (d11 == null) {
			if (other.d11 != null)
				return false;
		} else if (!d11.equals(other.d11))
			return false;
		if (d11_poa == null) {
			if (other.d11_poa != null)
				return false;
		} else if (!d11_poa.equals(other.d11_poa))
			return false;
		if (d12 == null) {
			if (other.d12 != null)
				return false;
		} else if (!d12.equals(other.d12))
			return false;
		if (d12_poa == null) {
			if (other.d12_poa != null)
				return false;
		} else if (!d12_poa.equals(other.d12_poa))
			return false;
		if (d13 == null) {
			if (other.d13 != null)
				return false;
		} else if (!d13.equals(other.d13))
			return false;
		if (d13_poa == null) {
			if (other.d13_poa != null)
				return false;
		} else if (!d13_poa.equals(other.d13_poa))
			return false;
		if (d14 == null) {
			if (other.d14 != null)
				return false;
		} else if (!d14.equals(other.d14))
			return false;
		if (d14_poa == null) {
			if (other.d14_poa != null)
				return false;
		} else if (!d14_poa.equals(other.d14_poa))
			return false;
		if (d15 == null) {
			if (other.d15 != null)
				return false;
		} else if (!d15.equals(other.d15))
			return false;
		if (d15_poa == null) {
			if (other.d15_poa != null)
				return false;
		} else if (!d15_poa.equals(other.d15_poa))
			return false;
		if (d16 == null) {
			if (other.d16 != null)
				return false;
		} else if (!d16.equals(other.d16))
			return false;
		if (d16_poa == null) {
			if (other.d16_poa != null)
				return false;
		} else if (!d16_poa.equals(other.d16_poa))
			return false;
		if (d17 == null) {
			if (other.d17 != null)
				return false;
		} else if (!d17.equals(other.d17))
			return false;
		if (d17_poa == null) {
			if (other.d17_poa != null)
				return false;
		} else if (!d17_poa.equals(other.d17_poa))
			return false;
		if (d18 == null) {
			if (other.d18 != null)
				return false;
		} else if (!d18.equals(other.d18))
			return false;
		if (d18_poa == null) {
			if (other.d18_poa != null)
				return false;
		} else if (!d18_poa.equals(other.d18_poa))
			return false;
		if (d19 == null) {
			if (other.d19 != null)
				return false;
		} else if (!d19.equals(other.d19))
			return false;
		if (d19_poa == null) {
			if (other.d19_poa != null)
				return false;
		} else if (!d19_poa.equals(other.d19_poa))
			return false;
		if (d1_poa == null) {
			if (other.d1_poa != null)
				return false;
		} else if (!d1_poa.equals(other.d1_poa))
			return false;
		if (d2 == null) {
			if (other.d2 != null)
				return false;
		} else if (!d2.equals(other.d2))
			return false;
		if (d20 == null) {
			if (other.d20 != null)
				return false;
		} else if (!d20.equals(other.d20))
			return false;
		if (d20_poa == null) {
			if (other.d20_poa != null)
				return false;
		} else if (!d20_poa.equals(other.d20_poa))
			return false;
		if (d21 == null) {
			if (other.d21 != null)
				return false;
		} else if (!d21.equals(other.d21))
			return false;
		if (d21_poa == null) {
			if (other.d21_poa != null)
				return false;
		} else if (!d21_poa.equals(other.d21_poa))
			return false;
		if (d22 == null) {
			if (other.d22 != null)
				return false;
		} else if (!d22.equals(other.d22))
			return false;
		if (d22_poa == null) {
			if (other.d22_poa != null)
				return false;
		} else if (!d22_poa.equals(other.d22_poa))
			return false;
		if (d23 == null) {
			if (other.d23 != null)
				return false;
		} else if (!d23.equals(other.d23))
			return false;
		if (d23_poa == null) {
			if (other.d23_poa != null)
				return false;
		} else if (!d23_poa.equals(other.d23_poa))
			return false;
		if (d24 == null) {
			if (other.d24 != null)
				return false;
		} else if (!d24.equals(other.d24))
			return false;
		if (d24_poa == null) {
			if (other.d24_poa != null)
				return false;
		} else if (!d24_poa.equals(other.d24_poa))
			return false;
		if (d2_poa == null) {
			if (other.d2_poa != null)
				return false;
		} else if (!d2_poa.equals(other.d2_poa))
			return false;
		if (d3 == null) {
			if (other.d3 != null)
				return false;
		} else if (!d3.equals(other.d3))
			return false;
		if (d3_poa == null) {
			if (other.d3_poa != null)
				return false;
		} else if (!d3_poa.equals(other.d3_poa))
			return false;
		if (d4 == null) {
			if (other.d4 != null)
				return false;
		} else if (!d4.equals(other.d4))
			return false;
		if (d4_poa == null) {
			if (other.d4_poa != null)
				return false;
		} else if (!d4_poa.equals(other.d4_poa))
			return false;
		if (d5 == null) {
			if (other.d5 != null)
				return false;
		} else if (!d5.equals(other.d5))
			return false;
		if (d5_poa == null) {
			if (other.d5_poa != null)
				return false;
		} else if (!d5_poa.equals(other.d5_poa))
			return false;
		if (d6 == null) {
			if (other.d6 != null)
				return false;
		} else if (!d6.equals(other.d6))
			return false;
		if (d6_poa == null) {
			if (other.d6_poa != null)
				return false;
		} else if (!d6_poa.equals(other.d6_poa))
			return false;
		if (d7 == null) {
			if (other.d7 != null)
				return false;
		} else if (!d7.equals(other.d7))
			return false;
		if (d7_poa == null) {
			if (other.d7_poa != null)
				return false;
		} else if (!d7_poa.equals(other.d7_poa))
			return false;
		if (d8 == null) {
			if (other.d8 != null)
				return false;
		} else if (!d8.equals(other.d8))
			return false;
		if (d8_poa == null) {
			if (other.d8_poa != null)
				return false;
		} else if (!d8_poa.equals(other.d8_poa))
			return false;
		if (d9 == null) {
			if (other.d9 != null)
				return false;
		} else if (!d9.equals(other.d9))
			return false;
		if (d9_poa == null) {
			if (other.d9_poa != null)
				return false;
		} else if (!d9_poa.equals(other.d9_poa))
			return false;
		if (de1 == null) {
			if (other.de1 != null)
				return false;
		} else if (!de1.equals(other.de1))
			return false;
		if (de10 == null) {
			if (other.de10 != null)
				return false;
		} else if (!de10.equals(other.de10))
			return false;
		if (de10_poa == null) {
			if (other.de10_poa != null)
				return false;
		} else if (!de10_poa.equals(other.de10_poa))
			return false;
		if (de11 == null) {
			if (other.de11 != null)
				return false;
		} else if (!de11.equals(other.de11))
			return false;
		if (de11_poa == null) {
			if (other.de11_poa != null)
				return false;
		} else if (!de11_poa.equals(other.de11_poa))
			return false;
		if (de12 == null) {
			if (other.de12 != null)
				return false;
		} else if (!de12.equals(other.de12))
			return false;
		if (de12_poa == null) {
			if (other.de12_poa != null)
				return false;
		} else if (!de12_poa.equals(other.de12_poa))
			return false;
		if (de1_poa == null) {
			if (other.de1_poa != null)
				return false;
		} else if (!de1_poa.equals(other.de1_poa))
			return false;
		if (de2 == null) {
			if (other.de2 != null)
				return false;
		} else if (!de2.equals(other.de2))
			return false;
		if (de2_poa == null) {
			if (other.de2_poa != null)
				return false;
		} else if (!de2_poa.equals(other.de2_poa))
			return false;
		if (de3 == null) {
			if (other.de3 != null)
				return false;
		} else if (!de3.equals(other.de3))
			return false;
		if (de3_poa == null) {
			if (other.de3_poa != null)
				return false;
		} else if (!de3_poa.equals(other.de3_poa))
			return false;
		if (de4 == null) {
			if (other.de4 != null)
				return false;
		} else if (!de4.equals(other.de4))
			return false;
		if (de4_poa == null) {
			if (other.de4_poa != null)
				return false;
		} else if (!de4_poa.equals(other.de4_poa))
			return false;
		if (de5 == null) {
			if (other.de5 != null)
				return false;
		} else if (!de5.equals(other.de5))
			return false;
		if (de5_poa == null) {
			if (other.de5_poa != null)
				return false;
		} else if (!de5_poa.equals(other.de5_poa))
			return false;
		if (de6 == null) {
			if (other.de6 != null)
				return false;
		} else if (!de6.equals(other.de6))
			return false;
		if (de6_poa == null) {
			if (other.de6_poa != null)
				return false;
		} else if (!de6_poa.equals(other.de6_poa))
			return false;
		if (de7 == null) {
			if (other.de7 != null)
				return false;
		} else if (!de7.equals(other.de7))
			return false;
		if (de7_poa == null) {
			if (other.de7_poa != null)
				return false;
		} else if (!de7_poa.equals(other.de7_poa))
			return false;
		if (de8 == null) {
			if (other.de8 != null)
				return false;
		} else if (!de8.equals(other.de8))
			return false;
		if (de8_poa == null) {
			if (other.de8_poa != null)
				return false;
		} else if (!de8_poa.equals(other.de8_poa))
			return false;
		if (de9 == null) {
			if (other.de9 != null)
				return false;
		} else if (!de9.equals(other.de9))
			return false;
		if (de9_poa == null) {
			if (other.de9_poa != null)
				return false;
		} else if (!de9_poa.equals(other.de9_poa))
			return false;
		if (dischargeDate == null) {
			if (other.dischargeDate != null)
				return false;
		} else if (!dischargeDate.equals(other.dischargeDate))
			return false;
		if (drgCode == null) {
			if (other.drgCode != null)
				return false;
		} else if (!drgCode.equals(other.drgCode))
			return false;
		if (faciType_BillFirstDigit == null) {
			if (other.faciType_BillFirstDigit != null)
				return false;
		} else if (!faciType_BillFirstDigit
				.equals(other.faciType_BillFirstDigit))
			return false;
		if (freqType_BillThirdDigit == null) {
			if (other.freqType_BillThirdDigit != null)
				return false;
		} else if (!freqType_BillThirdDigit
				.equals(other.freqType_BillThirdDigit))
			return false;
		if (fromServiceDate == null) {
			if (other.fromServiceDate != null)
				return false;
		} else if (!fromServiceDate.equals(other.fromServiceDate))
			return false;
		if (lines == null) {
			if (other.lines != null)
				return false;
		} else if (!lines.equals(other.lines))
			return false;
		if (mbrIdentifier == null) {
			if (other.mbrIdentifier != null)
				return false;
		} else if (!mbrIdentifier.equals(other.mbrIdentifier))
			return false;
		if (ocr1 == null) {
			if (other.ocr1 != null)
				return false;
		} else if (!ocr1.equals(other.ocr1))
			return false;
		if (ocr10 == null) {
			if (other.ocr10 != null)
				return false;
		} else if (!ocr10.equals(other.ocr10))
			return false;
		if (ocr10_dt == null) {
			if (other.ocr10_dt != null)
				return false;
		} else if (!ocr10_dt.equals(other.ocr10_dt))
			return false;
		if (ocr11 == null) {
			if (other.ocr11 != null)
				return false;
		} else if (!ocr11.equals(other.ocr11))
			return false;
		if (ocr11_dt == null) {
			if (other.ocr11_dt != null)
				return false;
		} else if (!ocr11_dt.equals(other.ocr11_dt))
			return false;
		if (ocr12 == null) {
			if (other.ocr12 != null)
				return false;
		} else if (!ocr12.equals(other.ocr12))
			return false;
		if (ocr13_dt == null) {
			if (other.ocr13_dt != null)
				return false;
		} else if (!ocr13_dt.equals(other.ocr13_dt))
			return false;
		if (ocr14 == null) {
			if (other.ocr14 != null)
				return false;
		} else if (!ocr14.equals(other.ocr14))
			return false;
		if (ocr14_dt == null) {
			if (other.ocr14_dt != null)
				return false;
		} else if (!ocr14_dt.equals(other.ocr14_dt))
			return false;
		if (ocr15 == null) {
			if (other.ocr15 != null)
				return false;
		} else if (!ocr15.equals(other.ocr15))
			return false;
		if (ocr15_dt == null) {
			if (other.ocr15_dt != null)
				return false;
		} else if (!ocr15_dt.equals(other.ocr15_dt))
			return false;
		if (ocr16 == null) {
			if (other.ocr16 != null)
				return false;
		} else if (!ocr16.equals(other.ocr16))
			return false;
		if (ocr16_dt == null) {
			if (other.ocr16_dt != null)
				return false;
		} else if (!ocr16_dt.equals(other.ocr16_dt))
			return false;
		if (ocr17 == null) {
			if (other.ocr17 != null)
				return false;
		} else if (!ocr17.equals(other.ocr17))
			return false;
		if (ocr17_dt == null) {
			if (other.ocr17_dt != null)
				return false;
		} else if (!ocr17_dt.equals(other.ocr17_dt))
			return false;
		if (ocr18 == null) {
			if (other.ocr18 != null)
				return false;
		} else if (!ocr18.equals(other.ocr18))
			return false;
		if (ocr18_dt == null) {
			if (other.ocr18_dt != null)
				return false;
		} else if (!ocr18_dt.equals(other.ocr18_dt))
			return false;
		if (ocr19 == null) {
			if (other.ocr19 != null)
				return false;
		} else if (!ocr19.equals(other.ocr19))
			return false;
		if (ocr19_dt == null) {
			if (other.ocr19_dt != null)
				return false;
		} else if (!ocr19_dt.equals(other.ocr19_dt))
			return false;
		if (ocr1_dt == null) {
			if (other.ocr1_dt != null)
				return false;
		} else if (!ocr1_dt.equals(other.ocr1_dt))
			return false;
		if (ocr2 == null) {
			if (other.ocr2 != null)
				return false;
		} else if (!ocr2.equals(other.ocr2))
			return false;
		if (ocr20 == null) {
			if (other.ocr20 != null)
				return false;
		} else if (!ocr20.equals(other.ocr20))
			return false;
		if (ocr20_dt == null) {
			if (other.ocr20_dt != null)
				return false;
		} else if (!ocr20_dt.equals(other.ocr20_dt))
			return false;
		if (ocr21 == null) {
			if (other.ocr21 != null)
				return false;
		} else if (!ocr21.equals(other.ocr21))
			return false;
		if (ocr21_dt == null) {
			if (other.ocr21_dt != null)
				return false;
		} else if (!ocr21_dt.equals(other.ocr21_dt))
			return false;
		if (ocr22 == null) {
			if (other.ocr22 != null)
				return false;
		} else if (!ocr22.equals(other.ocr22))
			return false;
		if (ocr22_dt == null) {
			if (other.ocr22_dt != null)
				return false;
		} else if (!ocr22_dt.equals(other.ocr22_dt))
			return false;
		if (ocr23 == null) {
			if (other.ocr23 != null)
				return false;
		} else if (!ocr23.equals(other.ocr23))
			return false;
		if (ocr23_dt == null) {
			if (other.ocr23_dt != null)
				return false;
		} else if (!ocr23_dt.equals(other.ocr23_dt))
			return false;
		if (ocr24 == null) {
			if (other.ocr24 != null)
				return false;
		} else if (!ocr24.equals(other.ocr24))
			return false;
		if (ocr24_dt == null) {
			if (other.ocr24_dt != null)
				return false;
		} else if (!ocr24_dt.equals(other.ocr24_dt))
			return false;
		if (ocr2_dt == null) {
			if (other.ocr2_dt != null)
				return false;
		} else if (!ocr2_dt.equals(other.ocr2_dt))
			return false;
		if (ocr3 == null) {
			if (other.ocr3 != null)
				return false;
		} else if (!ocr3.equals(other.ocr3))
			return false;
		if (ocr3_dt == null) {
			if (other.ocr3_dt != null)
				return false;
		} else if (!ocr3_dt.equals(other.ocr3_dt))
			return false;
		if (ocr4 == null) {
			if (other.ocr4 != null)
				return false;
		} else if (!ocr4.equals(other.ocr4))
			return false;
		if (ocr4_dt == null) {
			if (other.ocr4_dt != null)
				return false;
		} else if (!ocr4_dt.equals(other.ocr4_dt))
			return false;
		if (ocr5 == null) {
			if (other.ocr5 != null)
				return false;
		} else if (!ocr5.equals(other.ocr5))
			return false;
		if (ocr5_dt == null) {
			if (other.ocr5_dt != null)
				return false;
		} else if (!ocr5_dt.equals(other.ocr5_dt))
			return false;
		if (ocr6 == null) {
			if (other.ocr6 != null)
				return false;
		} else if (!ocr6.equals(other.ocr6))
			return false;
		if (ocr6_dt == null) {
			if (other.ocr6_dt != null)
				return false;
		} else if (!ocr6_dt.equals(other.ocr6_dt))
			return false;
		if (ocr7 == null) {
			if (other.ocr7 != null)
				return false;
		} else if (!ocr7.equals(other.ocr7))
			return false;
		if (ocr7_dt == null) {
			if (other.ocr7_dt != null)
				return false;
		} else if (!ocr7_dt.equals(other.ocr7_dt))
			return false;
		if (ocr8 == null) {
			if (other.ocr8 != null)
				return false;
		} else if (!ocr8.equals(other.ocr8))
			return false;
		if (ocr8_dt == null) {
			if (other.ocr8_dt != null)
				return false;
		} else if (!ocr8_dt.equals(other.ocr8_dt))
			return false;
		if (ocr9 == null) {
			if (other.ocr9 != null)
				return false;
		} else if (!ocr9.equals(other.ocr9))
			return false;
		if (ocr9_dt == null) {
			if (other.ocr9_dt != null)
				return false;
		} else if (!ocr9_dt.equals(other.ocr9_dt))
			return false;
		if (operatingPhyNationalPrvdrIdntfr == null) {
			if (other.operatingPhyNationalPrvdrIdntfr != null)
				return false;
		} else if (!operatingPhyNationalPrvdrIdntfr
				.equals(other.operatingPhyNationalPrvdrIdntfr))
			return false;
		if (othOeratingPhyNationalPrvdrIdntfr == null) {
			if (other.othOeratingPhyNationalPrvdrIdntfr != null)
				return false;
		} else if (!othOeratingPhyNationalPrvdrIdntfr
				.equals(other.othOeratingPhyNationalPrvdrIdntfr))
			return false;
		if (p1 == null) {
			if (other.p1 != null)
				return false;
		} else if (!p1.equals(other.p1))
			return false;
		if (p10 == null) {
			if (other.p10 != null)
				return false;
		} else if (!p10.equals(other.p10))
			return false;
		if (p10_dt == null) {
			if (other.p10_dt != null)
				return false;
		} else if (!p10_dt.equals(other.p10_dt))
			return false;
		if (p11 == null) {
			if (other.p11 != null)
				return false;
		} else if (!p11.equals(other.p11))
			return false;
		if (p11_dt == null) {
			if (other.p11_dt != null)
				return false;
		} else if (!p11_dt.equals(other.p11_dt))
			return false;
		if (p12 == null) {
			if (other.p12 != null)
				return false;
		} else if (!p12.equals(other.p12))
			return false;
		if (p12_dt == null) {
			if (other.p12_dt != null)
				return false;
		} else if (!p12_dt.equals(other.p12_dt))
			return false;
		if (p13 == null) {
			if (other.p13 != null)
				return false;
		} else if (!p13.equals(other.p13))
			return false;
		if (p13_dt == null) {
			if (other.p13_dt != null)
				return false;
		} else if (!p13_dt.equals(other.p13_dt))
			return false;
		if (p14 == null) {
			if (other.p14 != null)
				return false;
		} else if (!p14.equals(other.p14))
			return false;
		if (p14_dt == null) {
			if (other.p14_dt != null)
				return false;
		} else if (!p14_dt.equals(other.p14_dt))
			return false;
		if (p15 == null) {
			if (other.p15 != null)
				return false;
		} else if (!p15.equals(other.p15))
			return false;
		if (p15_dt == null) {
			if (other.p15_dt != null)
				return false;
		} else if (!p15_dt.equals(other.p15_dt))
			return false;
		if (p16 == null) {
			if (other.p16 != null)
				return false;
		} else if (!p16.equals(other.p16))
			return false;
		if (p16_dt == null) {
			if (other.p16_dt != null)
				return false;
		} else if (!p16_dt.equals(other.p16_dt))
			return false;
		if (p17 == null) {
			if (other.p17 != null)
				return false;
		} else if (!p17.equals(other.p17))
			return false;
		if (p17_dt == null) {
			if (other.p17_dt != null)
				return false;
		} else if (!p17_dt.equals(other.p17_dt))
			return false;
		if (p18 == null) {
			if (other.p18 != null)
				return false;
		} else if (!p18.equals(other.p18))
			return false;
		if (p18_dt == null) {
			if (other.p18_dt != null)
				return false;
		} else if (!p18_dt.equals(other.p18_dt))
			return false;
		if (p19 == null) {
			if (other.p19 != null)
				return false;
		} else if (!p19.equals(other.p19))
			return false;
		if (p19_dt == null) {
			if (other.p19_dt != null)
				return false;
		} else if (!p19_dt.equals(other.p19_dt))
			return false;
		if (p1_dt == null) {
			if (other.p1_dt != null)
				return false;
		} else if (!p1_dt.equals(other.p1_dt))
			return false;
		if (p2 == null) {
			if (other.p2 != null)
				return false;
		} else if (!p2.equals(other.p2))
			return false;
		if (p20 == null) {
			if (other.p20 != null)
				return false;
		} else if (!p20.equals(other.p20))
			return false;
		if (p20_dt == null) {
			if (other.p20_dt != null)
				return false;
		} else if (!p20_dt.equals(other.p20_dt))
			return false;
		if (p21 == null) {
			if (other.p21 != null)
				return false;
		} else if (!p21.equals(other.p21))
			return false;
		if (p21_dt == null) {
			if (other.p21_dt != null)
				return false;
		} else if (!p21_dt.equals(other.p21_dt))
			return false;
		if (p22 == null) {
			if (other.p22 != null)
				return false;
		} else if (!p22.equals(other.p22))
			return false;
		if (p22_dt == null) {
			if (other.p22_dt != null)
				return false;
		} else if (!p22_dt.equals(other.p22_dt))
			return false;
		if (p23 == null) {
			if (other.p23 != null)
				return false;
		} else if (!p23.equals(other.p23))
			return false;
		if (p23_dt == null) {
			if (other.p23_dt != null)
				return false;
		} else if (!p23_dt.equals(other.p23_dt))
			return false;
		if (p24 == null) {
			if (other.p24 != null)
				return false;
		} else if (!p24.equals(other.p24))
			return false;
		if (p24_dt == null) {
			if (other.p24_dt != null)
				return false;
		} else if (!p24_dt.equals(other.p24_dt))
			return false;
		if (p2_dt == null) {
			if (other.p2_dt != null)
				return false;
		} else if (!p2_dt.equals(other.p2_dt))
			return false;
		if (p3 == null) {
			if (other.p3 != null)
				return false;
		} else if (!p3.equals(other.p3))
			return false;
		if (p3_dt == null) {
			if (other.p3_dt != null)
				return false;
		} else if (!p3_dt.equals(other.p3_dt))
			return false;
		if (p4 == null) {
			if (other.p4 != null)
				return false;
		} else if (!p4.equals(other.p4))
			return false;
		if (p4_dt == null) {
			if (other.p4_dt != null)
				return false;
		} else if (!p4_dt.equals(other.p4_dt))
			return false;
		if (p5 == null) {
			if (other.p5 != null)
				return false;
		} else if (!p5.equals(other.p5))
			return false;
		if (p5_dt == null) {
			if (other.p5_dt != null)
				return false;
		} else if (!p5_dt.equals(other.p5_dt))
			return false;
		if (p6 == null) {
			if (other.p6 != null)
				return false;
		} else if (!p6.equals(other.p6))
			return false;
		if (p6_dt == null) {
			if (other.p6_dt != null)
				return false;
		} else if (!p6_dt.equals(other.p6_dt))
			return false;
		if (p7 == null) {
			if (other.p7 != null)
				return false;
		} else if (!p7.equals(other.p7))
			return false;
		if (p7_dt == null) {
			if (other.p7_dt != null)
				return false;
		} else if (!p7_dt.equals(other.p7_dt))
			return false;
		if (p8 == null) {
			if (other.p8 != null)
				return false;
		} else if (!p8.equals(other.p8))
			return false;
		if (p8_dt == null) {
			if (other.p8_dt != null)
				return false;
		} else if (!p8_dt.equals(other.p8_dt))
			return false;
		if (p9 == null) {
			if (other.p9 != null)
				return false;
		} else if (!p9.equals(other.p9))
			return false;
		if (p9_dt == null) {
			if (other.p9_dt != null)
				return false;
		} else if (!p9_dt.equals(other.p9_dt))
			return false;
		if (paidAmount == null) {
			if (other.paidAmount != null)
				return false;
		} else if (!paidAmount.equals(other.paidAmount))
			return false;
		if (patientBirthDate == null) {
			if (other.patientBirthDate != null)
				return false;
		} else if (!patientBirthDate.equals(other.patientBirthDate))
			return false;
		if (patientFirstName == null) {
			if (other.patientFirstName != null)
				return false;
		} else if (!patientFirstName.equals(other.patientFirstName))
			return false;
		if (patientGender == null) {
			if (other.patientGender != null)
				return false;
		} else if (!patientGender.equals(other.patientGender))
			return false;
		if (patientLastName == null) {
			if (other.patientLastName != null)
				return false;
		} else if (!patientLastName.equals(other.patientLastName))
			return false;
		if (patientState == null) {
			if (other.patientState != null)
				return false;
		} else if (!patientState.equals(other.patientState))
			return false;
		if (patientStatusLkpcd == null) {
			if (other.patientStatusLkpcd != null)
				return false;
		} else if (!patientStatusLkpcd.equals(other.patientStatusLkpcd))
			return false;
		if (patientZip == null) {
			if (other.patientZip != null)
				return false;
		} else if (!patientZip.equals(other.patientZip))
			return false;
		if (prncplDgnsCd == null) {
			if (other.prncplDgnsCd != null)
				return false;
		} else if (!prncplDgnsCd.equals(other.prncplDgnsCd))
			return false;
		if (prncplDgnsPoa == null) {
			if (other.prncplDgnsPoa != null)
				return false;
		} else if (!prncplDgnsPoa.equals(other.prncplDgnsPoa))
			return false;
		if (prncplPrcdrCd == null) {
			if (other.prncplPrcdrCd != null)
				return false;
		} else if (!prncplPrcdrCd.equals(other.prncplPrcdrCd))
			return false;
		if (prncplPrcdrCdDate == null) {
			if (other.prncplPrcdrCdDate != null)
				return false;
		} else if (!prncplPrcdrCdDate.equals(other.prncplPrcdrCdDate))
			return false;
		if (rsn_cd_ == null) {
			if (other.rsn_cd_ != null)
				return false;
		} else if (!rsn_cd_.equals(other.rsn_cd_))
			return false;
		if (rsn_cd_1 == null) {
			if (other.rsn_cd_1 != null)
				return false;
		} else if (!rsn_cd_1.equals(other.rsn_cd_1))
			return false;
		if (rsn_cd_3 == null) {
			if (other.rsn_cd_3 != null)
				return false;
		} else if (!rsn_cd_3.equals(other.rsn_cd_3))
			return false;
		if (servType_BillSecondDigit == null) {
			if (other.servType_BillSecondDigit != null)
				return false;
		} else if (!servType_BillSecondDigit
				.equals(other.servType_BillSecondDigit))
			return false;
		if (srvcngNationalPrvdrIdntfr == null) {
			if (other.srvcngNationalPrvdrIdntfr != null)
				return false;
		} else if (!srvcngNationalPrvdrIdntfr
				.equals(other.srvcngNationalPrvdrIdntfr))
			return false;
		if (srvcngPrvdrLctnZipCode == null) {
			if (other.srvcngPrvdrLctnZipCode != null)
				return false;
		} else if (!srvcngPrvdrLctnZipCode.equals(other.srvcngPrvdrLctnZipCode))
			return false;
		if (tcn == null) {
			if (other.tcn != null)
				return false;
		} else if (!tcn.equals(other.tcn))
			return false;
		if (toServiceDate == null) {
			if (other.toServiceDate != null)
				return false;
		} else if (!toServiceDate.equals(other.toServiceDate))
			return false;
		if (totalBilledAmount == null) {
			if (other.totalBilledAmount != null)
				return false;
		} else if (!totalBilledAmount.equals(other.totalBilledAmount))
			return false;
		if (val1 == null) {
			if (other.val1 != null)
				return false;
		} else if (!val1.equals(other.val1))
			return false;
		if (val10 == null) {
			if (other.val10 != null)
				return false;
		} else if (!val10.equals(other.val10))
			return false;
		if (val10_amt == null) {
			if (other.val10_amt != null)
				return false;
		} else if (!val10_amt.equals(other.val10_amt))
			return false;
		if (val11 == null) {
			if (other.val11 != null)
				return false;
		} else if (!val11.equals(other.val11))
			return false;
		if (val11_amt == null) {
			if (other.val11_amt != null)
				return false;
		} else if (!val11_amt.equals(other.val11_amt))
			return false;
		if (val12 == null) {
			if (other.val12 != null)
				return false;
		} else if (!val12.equals(other.val12))
			return false;
		if (val13_amt == null) {
			if (other.val13_amt != null)
				return false;
		} else if (!val13_amt.equals(other.val13_amt))
			return false;
		if (val14 == null) {
			if (other.val14 != null)
				return false;
		} else if (!val14.equals(other.val14))
			return false;
		if (val14_amt == null) {
			if (other.val14_amt != null)
				return false;
		} else if (!val14_amt.equals(other.val14_amt))
			return false;
		if (val15 == null) {
			if (other.val15 != null)
				return false;
		} else if (!val15.equals(other.val15))
			return false;
		if (val15_amt == null) {
			if (other.val15_amt != null)
				return false;
		} else if (!val15_amt.equals(other.val15_amt))
			return false;
		if (val16 == null) {
			if (other.val16 != null)
				return false;
		} else if (!val16.equals(other.val16))
			return false;
		if (val16_amt == null) {
			if (other.val16_amt != null)
				return false;
		} else if (!val16_amt.equals(other.val16_amt))
			return false;
		if (val17 == null) {
			if (other.val17 != null)
				return false;
		} else if (!val17.equals(other.val17))
			return false;
		if (val17_amt == null) {
			if (other.val17_amt != null)
				return false;
		} else if (!val17_amt.equals(other.val17_amt))
			return false;
		if (val18 == null) {
			if (other.val18 != null)
				return false;
		} else if (!val18.equals(other.val18))
			return false;
		if (val18_amt == null) {
			if (other.val18_amt != null)
				return false;
		} else if (!val18_amt.equals(other.val18_amt))
			return false;
		if (val19 == null) {
			if (other.val19 != null)
				return false;
		} else if (!val19.equals(other.val19))
			return false;
		if (val19_amt == null) {
			if (other.val19_amt != null)
				return false;
		} else if (!val19_amt.equals(other.val19_amt))
			return false;
		if (val1_amt == null) {
			if (other.val1_amt != null)
				return false;
		} else if (!val1_amt.equals(other.val1_amt))
			return false;
		if (val2 == null) {
			if (other.val2 != null)
				return false;
		} else if (!val2.equals(other.val2))
			return false;
		if (val20 == null) {
			if (other.val20 != null)
				return false;
		} else if (!val20.equals(other.val20))
			return false;
		if (val20_amt == null) {
			if (other.val20_amt != null)
				return false;
		} else if (!val20_amt.equals(other.val20_amt))
			return false;
		if (val21 == null) {
			if (other.val21 != null)
				return false;
		} else if (!val21.equals(other.val21))
			return false;
		if (val21_amt == null) {
			if (other.val21_amt != null)
				return false;
		} else if (!val21_amt.equals(other.val21_amt))
			return false;
		if (val22 == null) {
			if (other.val22 != null)
				return false;
		} else if (!val22.equals(other.val22))
			return false;
		if (val22_amt == null) {
			if (other.val22_amt != null)
				return false;
		} else if (!val22_amt.equals(other.val22_amt))
			return false;
		if (val23 == null) {
			if (other.val23 != null)
				return false;
		} else if (!val23.equals(other.val23))
			return false;
		if (val23_amt == null) {
			if (other.val23_amt != null)
				return false;
		} else if (!val23_amt.equals(other.val23_amt))
			return false;
		if (val24 == null) {
			if (other.val24 != null)
				return false;
		} else if (!val24.equals(other.val24))
			return false;
		if (val24_amt == null) {
			if (other.val24_amt != null)
				return false;
		} else if (!val24_amt.equals(other.val24_amt))
			return false;
		if (val2_amt == null) {
			if (other.val2_amt != null)
				return false;
		} else if (!val2_amt.equals(other.val2_amt))
			return false;
		if (val3 == null) {
			if (other.val3 != null)
				return false;
		} else if (!val3.equals(other.val3))
			return false;
		if (val3_amt == null) {
			if (other.val3_amt != null)
				return false;
		} else if (!val3_amt.equals(other.val3_amt))
			return false;
		if (val4 == null) {
			if (other.val4 != null)
				return false;
		} else if (!val4.equals(other.val4))
			return false;
		if (val4_amt == null) {
			if (other.val4_amt != null)
				return false;
		} else if (!val4_amt.equals(other.val4_amt))
			return false;
		if (val5 == null) {
			if (other.val5 != null)
				return false;
		} else if (!val5.equals(other.val5))
			return false;
		if (val5_amt == null) {
			if (other.val5_amt != null)
				return false;
		} else if (!val5_amt.equals(other.val5_amt))
			return false;
		if (val6 == null) {
			if (other.val6 != null)
				return false;
		} else if (!val6.equals(other.val6))
			return false;
		if (val6_amt == null) {
			if (other.val6_amt != null)
				return false;
		} else if (!val6_amt.equals(other.val6_amt))
			return false;
		if (val7 == null) {
			if (other.val7 != null)
				return false;
		} else if (!val7.equals(other.val7))
			return false;
		if (val7_amt == null) {
			if (other.val7_amt != null)
				return false;
		} else if (!val7_amt.equals(other.val7_amt))
			return false;
		if (val8 == null) {
			if (other.val8 != null)
				return false;
		} else if (!val8.equals(other.val8))
			return false;
		if (val8_amt == null) {
			if (other.val8_amt != null)
				return false;
		} else if (!val8_amt.equals(other.val8_amt))
			return false;
		if (val9 == null) {
			if (other.val9 != null)
				return false;
		} else if (!val9.equals(other.val9))
			return false;
		if (val9_amt == null) {
			if (other.val9_amt != null)
				return false;
		} else if (!val9_amt.equals(other.val9_amt))
			return false;
		return true;
	}
	public String getMdc() {
		return mdc;
	}
	public void setMdc(String mdc) {
		this.mdc = mdc;
	}
	public String getInDate() {
		return inDate;
	}
	public void setInDate(String inDate) {
		this.inDate = inDate;
	}
		
	
}
