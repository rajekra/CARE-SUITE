package com.icare.common.dto;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.bson.types.ObjectId;

public class CD {
	
	private String tcn;
	private Date fromServiceDate;
	private Date toServiceDate;
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
	private Date admissionDate;
	private String admissionHour;
	private String admissionSourceLkpcd;
	private String admissionTypeLkpcd;
	
	//Discharge status
	private String patientStatusLkpcd;
	private Date dischargeDate;
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
	private Date patientBirthDate;
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
	private Date prncplPrcdrCdDate;
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
	public Date getFromServiceDate() {
		return fromServiceDate;
	}
	public void setFromServiceDate(Date fromServiceDate) {
		this.fromServiceDate = fromServiceDate;
	}
	public Date getToServiceDate() {
		return toServiceDate;
	}
	public void setToServiceDate(Date toServiceDate) {
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
	public Date getAdmissionDate() {
		return admissionDate;
	}
	public void setAdmissionDate(Date admissionDate) {
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
	public Date getDischargeDate() {
		return dischargeDate;
	}
	public void setDischargeDate(Date dischargeDate) {
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
	public Date getPatientBirthDate() {
		return patientBirthDate;
	}
	public void setPatientBirthDate(Date patientBirthDate) {
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
	public String toString() {
		return "CD [tcn=" + tcn + ", fromServiceDate=" + fromServiceDate
				+ ", toServiceDate=" + toServiceDate
				+ ", blngNationalPrvdrIdntfr=" + blngNationalPrvdrIdntfr
				+ ", blngPrvdrLctnZipCode=" + blngPrvdrLctnZipCode
				+ ", srvcngNationalPrvdrIdntfr=" + srvcngNationalPrvdrIdntfr
				+ ", srvcngPrvdrLctnZipCode=" + srvcngPrvdrLctnZipCode
				+ ", attendingNationalPrvdrIdntfr="
				+ attendingNationalPrvdrIdntfr
				+ ", operatingPhyNationalPrvdrIdntfr="
				+ operatingPhyNationalPrvdrIdntfr
				+ ", othOeratingPhyNationalPrvdrIdntfr="
				+ othOeratingPhyNationalPrvdrIdntfr
				+ ", faciType_BillFirstDigit=" + faciType_BillFirstDigit
				+ ", servType_BillSecondDigit=" + servType_BillSecondDigit
				+ ", freqType_BillThirdDigit=" + freqType_BillThirdDigit
				+ ", admissionDate=" + admissionDate + ", admissionHour="
				+ admissionHour + ", admissionSourceLkpcd="
				+ admissionSourceLkpcd + ", admissionTypeLkpcd="
				+ admissionTypeLkpcd + ", patientStatusLkpcd="
				+ patientStatusLkpcd + ", dischargeDate=" + dischargeDate
				+ ", totalBilledAmount=" + totalBilledAmount + ", paidAmount="
				+ paidAmount + ", drgCode=" + drgCode + ", apc=" + apc
				+ ", admtDiagCd=" + admtDiagCd + ", prncplDgnsCd="
				+ prncplDgnsCd + ", mbrIdentifier=" + mbrIdentifier
				+ ", patientFirstName=" + patientFirstName
				+ ", patientLastName=" + patientLastName
				+ ", patientBirthDate=" + patientBirthDate + ", patientGender="
				+ patientGender + ", patientZip=" + patientZip
				+ ", patientState=" + patientState + ", d1=" + d1 + ", d1_poa="
				+ d1_poa + ", d2=" + d2 + ", d2_poa=" + d2_poa + ", d3=" + d3
				+ ", d3_poa=" + d3_poa + ", d4=" + d4 + ", d4_poa=" + d4_poa
				+ ", d5=" + d5 + ", d5_poa=" + d5_poa + ", d6=" + d6
				+ ", d6_poa=" + d6_poa + ", d7=" + d7 + ", d7_poa=" + d7_poa
				+ ", d8=" + d8 + ", d8_poa=" + d8_poa + ", d9=" + d9
				+ ", d9_poa=" + d9_poa + ", d10=" + d10 + ", d10_poa="
				+ d10_poa + ", d11=" + d11 + ", d11_poa=" + d11_poa + ", d12="
				+ d12 + ", d12_poa=" + d12_poa + ", d13=" + d13 + ", d13_poa="
				+ d13_poa + ", d14=" + d14 + ", d14_poa=" + d14_poa + ", d15="
				+ d15 + ", d15_poa=" + d15_poa + ", d16=" + d16 + ", d16_poa="
				+ d16_poa + ", d17=" + d17 + ", d17_poa=" + d17_poa + ", d18="
				+ d18 + ", d18_poa=" + d18_poa + ", d19=" + d19 + ", d19_poa="
				+ d19_poa + ", d20=" + d20 + ", d20_poa=" + d20_poa + ", d21="
				+ d21 + ", d21_poa=" + d21_poa + ", d22=" + d22 + ", d22_poa="
				+ d22_poa + ", d23=" + d23 + ", d23_poa=" + d23_poa + ", d24="
				+ d24 + ", d24_poa=" + d24_poa + ", de1=" + de1 + ", de1_poa="
				+ de1_poa + ", de2=" + de2 + ", de2_poa=" + de2_poa + ", de3="
				+ de3 + ", de3_poa=" + de3_poa + ", de4=" + de4 + ", de4_poa="
				+ de4_poa + ", de5=" + de5 + ", de5_poa=" + de5_poa + ", de6="
				+ de6 + ", de6_poa=" + de6_poa + ", de7=" + de7 + ", de7_poa="
				+ de7_poa + ", de8=" + de8 + ", de8_poa=" + de8_poa + ", de9="
				+ de9 + ", de9_poa=" + de9_poa + ", de10=" + de10
				+ ", de10_poa=" + de10_poa + ", de11=" + de11 + ", de11_poa="
				+ de11_poa + ", de12=" + de12 + ", de12_poa=" + de12_poa
				+ ", p1=" + p1 + ", p1_dt=" + p1_dt + ", p2=" + p2 + ", p2_dt="
				+ p2_dt + ", p3=" + p3 + ", p3_dt=" + p3_dt + ", p4=" + p4
				+ ", p4_dt=" + p4_dt + ", p5=" + p5 + ", p5_dt=" + p5_dt
				+ ", p6=" + p6 + ", p6_dt=" + p6_dt + ", p7=" + p7 + ", p7_dt="
				+ p7_dt + ", p8=" + p8 + ", p8_dt=" + p8_dt + ", p9=" + p9
				+ ", p9_dt=" + p9_dt + ", p10=" + p10 + ", p10_dt=" + p10_dt
				+ ", p11=" + p11 + ", p11_dt=" + p11_dt + ", p12=" + p12
				+ ", p12_dt=" + p12_dt + ", p13=" + p13 + ", p13_dt=" + p13_dt
				+ ", p14=" + p14 + ", p14_dt=" + p14_dt + ", p15=" + p15
				+ ", p15_dt=" + p15_dt + ", p16=" + p16 + ", p16_dt=" + p16_dt
				+ ", p17=" + p17 + ", p17_dt=" + p17_dt + ", p18=" + p18
				+ ", p18_dt=" + p18_dt + ", p19=" + p19 + ", p19_dt=" + p19_dt
				+ ", p20=" + p20 + ", p20_dt=" + p20_dt + ", p21=" + p21
				+ ", p21_dt=" + p21_dt + ", p22=" + p22 + ", p22_dt=" + p22_dt
				+ ", p23=" + p23 + ", p23_dt=" + p23_dt + ", p24=" + p24
				+ ", p24_dt=" + p24_dt + ", rsn_cd_1=" + rsn_cd_1
				+ ", rsn_cd_=" + rsn_cd_ + ", rsn_cd_3=" + rsn_cd_3 + ", cnd1="
				+ cnd1 + ", cnd2=" + cnd2 + ", cnd3=" + cnd3 + ", cnd4=" + cnd4
				+ ", cnd5=" + cnd5 + ", cnd6=" + cnd6 + ", cnd7=" + cnd7
				+ ", cnd8=" + cnd8 + ", cnd9=" + cnd9 + ", cnd10=" + cnd10
				+ ", cnd11=" + cnd11 + ", cnd12=" + cnd12 + ", cnd13=" + cnd13
				+ ", cnd14=" + cnd14 + ", cnd15=" + cnd15 + ", cnd16=" + cnd16
				+ ", cnd17=" + cnd17 + ", cnd18=" + cnd18 + ", cnd19=" + cnd19
				+ ", cnd20=" + cnd20 + ", cnd21=" + cnd21 + ", cnd22=" + cnd22
				+ ", cnd23=" + cnd23 + ", cnd24=" + cnd24 + ", ocr1=" + ocr1
				+ ", ocr1_dt=" + ocr1_dt + ", ocr2=" + ocr2 + ", ocr2_dt="
				+ ocr2_dt + ", ocr3=" + ocr3 + ", ocr3_dt=" + ocr3_dt
				+ ", ocr4=" + ocr4 + ", ocr4_dt=" + ocr4_dt + ", ocr5=" + ocr5
				+ ", ocr5_dt=" + ocr5_dt + ", ocr6=" + ocr6 + ", ocr6_dt="
				+ ocr6_dt + ", ocr7=" + ocr7 + ", ocr7_dt=" + ocr7_dt
				+ ", ocr8=" + ocr8 + ", ocr8_dt=" + ocr8_dt + ", ocr9=" + ocr9
				+ ", ocr9_dt=" + ocr9_dt + ", ocr10=" + ocr10 + ", ocr10_dt="
				+ ocr10_dt + ", ocr11=" + ocr11 + ", ocr11_dt=" + ocr11_dt
				+ ", ocr12=" + ocr12 + ", ocr13_dt=" + ocr13_dt + ", ocr14="
				+ ocr14 + ", ocr14_dt=" + ocr14_dt + ", ocr15=" + ocr15
				+ ", ocr15_dt=" + ocr15_dt + ", ocr16=" + ocr16 + ", ocr16_dt="
				+ ocr16_dt + ", ocr17=" + ocr17 + ", ocr17_dt=" + ocr17_dt
				+ ", ocr18=" + ocr18 + ", ocr18_dt=" + ocr18_dt + ", ocr19="
				+ ocr19 + ", ocr19_dt=" + ocr19_dt + ", ocr20=" + ocr20
				+ ", ocr20_dt=" + ocr20_dt + ", ocr21=" + ocr21 + ", ocr21_dt="
				+ ocr21_dt + ", ocr22=" + ocr22 + ", ocr22_dt=" + ocr22_dt
				+ ", ocr23=" + ocr23 + ", ocr23_dt=" + ocr23_dt + ", ocr24="
				+ ocr24 + ", ocr24_dt=" + ocr24_dt + ", val1=" + val1
				+ ", val1_amt=" + val1_amt + ", val2=" + val2 + ", val2_amt="
				+ val2_amt + ", val3=" + val3 + ", val3_amt=" + val3_amt
				+ ", val4=" + val4 + ", val4_amt=" + val4_amt + ", val5="
				+ val5 + ", val5_amt=" + val5_amt + ", val6=" + val6
				+ ", val6_amt=" + val6_amt + ", val7=" + val7 + ", val7_amt="
				+ val7_amt + ", val8=" + val8 + ", val8_amt=" + val8_amt
				+ ", val9=" + val9 + ", val9_amt=" + val9_amt + ", val10="
				+ val10 + ", val10_amt=" + val10_amt + ", val11=" + val11
				+ ", val11_amt=" + val11_amt + ", val12=" + val12
				+ ", val13_amt=" + val13_amt + ", val14=" + val14
				+ ", val14_amt=" + val14_amt + ", val15=" + val15
				+ ", val15_amt=" + val15_amt + ", val16=" + val16
				+ ", val16_amt=" + val16_amt + ", val17=" + val17
				+ ", val17_amt=" + val17_amt + ", val18=" + val18
				+ ", val18_amt=" + val18_amt + ", val19=" + val19
				+ ", val19_amt=" + val19_amt + ", val20=" + val20
				+ ", val20_amt=" + val20_amt + ", val21=" + val21
				+ ", val21_amt=" + val21_amt + ", val22=" + val22
				+ ", val22_amt=" + val22_amt + ", val23=" + val23
				+ ", val23_amt=" + val23_amt + ", val24=" + val24
				+ ", val24_amt=" + val24_amt + ", lines=" + lines + "]";
	}
	public String getPrncplPrcdrCd() {
		return prncplPrcdrCd;
	}
	public void setPrncplPrcdrCd(String prncplPrcdrCd) {
		this.prncplPrcdrCd = prncplPrcdrCd;
	}
	public Date getPrncplPrcdrCdDate() {
		return prncplPrcdrCdDate;
	}
	public void setPrncplPrcdrCdDate(Date prncplPrcdrCdDate) {
		this.prncplPrcdrCdDate = prncplPrcdrCdDate;
	}
	public String getPrncplDgnsPoa() {
		return prncplDgnsPoa;
	}
	public void setPrncplDgnsPoa(String prncplDgnsPoa) {
		this.prncplDgnsPoa = prncplDgnsPoa;
	}
	
	
}
