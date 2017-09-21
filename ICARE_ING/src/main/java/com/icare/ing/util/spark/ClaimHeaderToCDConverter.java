package com.icare.ing.util.spark;

import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

import org.apache.commons.lang.StringUtils;

import com.ecams.claim.bo.ClaimLine;
import com.ecams.claim.bo.ClmHdrAdmissionDetail;
import com.ecams.claim.bo.ClmHdrCondition;
import com.ecams.claim.bo.ClmHdrOccurrenceDetail;
import com.ecams.claim.bo.ClmHdrValueAmount;
import com.ecams.claim.bo.ClmHdrXDiagnosis;
import com.ecams.claim.bo.ClmHdrXProcedure;
import com.ecams.claim.bo.ClmHdrXPrvdrLctn;
import com.icare.common.dto.CH;
import com.icare.common.dto.CL;
import com.icare.ing.repository.intf.SparkRepositoryInf;

public class ClaimHeaderToCDConverter {
	public CH translateClaimHeaderToCD(com.ecams.claim.bo.ClaimHeader claimHeaderBo, SparkRepositoryInf repository)
	{
		CH cd = new CH();
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		//cd.setInDate(df.format(new Date(117,8,19)));
		cd.setInDate(df.format(new Date()));
		//cd.set_id(new ObjectId());
		cd.setPatientBirthDate(claimHeaderBo.getPatientBirthDate().toString());
		cd.setPatientFirstName(claimHeaderBo.getPatientFirstName());
		cd.setPatientGender(claimHeaderBo.getPatientGender());
		cd.setPatientLastName(claimHeaderBo.getPatientLastName());
		cd.setPatientZip(claimHeaderBo.getPatientZipCode());
		cd.setPatientStatusLkpcd(claimHeaderBo.getPatientRelationshipLkpcd());
		
		cd.setTcn(claimHeaderBo.getTcn());
		if(null!=claimHeaderBo.getFromServiceDate())
		{
			cd.setFromServiceDate(claimHeaderBo.getFromServiceDate().toString());
		}
		if(null!=claimHeaderBo.getToServiceDate())
		{
			cd.setToServiceDate(claimHeaderBo.getToServiceDate().toString());
		}
		if(null!=claimHeaderBo.getAdmissionDate())
		{
			cd.setAdmissionDate(claimHeaderBo.getAdmissionDate().toString());
		}
		cd.setAdmissionHour(claimHeaderBo.getAdmissionHour());
		if(null!=claimHeaderBo.getDischargeDate())
		{
			cd.setDischargeDate(claimHeaderBo.getDischargeDate().toString());
		}
		
		if(!StringUtils.isEmpty(claimHeaderBo.getFacilityTypeCode()))
		{
			cd.setFaciType_BillFirstDigit(claimHeaderBo.getFacilityTypeCode().substring(0,1));
			cd.setServType_BillSecondDigit(claimHeaderBo.getFacilityTypeCode().substring(1,2));
		}
		if(!StringUtils.isEmpty(claimHeaderBo.getClaimSubmissionReasonLkpcd()))
		{
			cd.setFreqType_BillThirdDigit(claimHeaderBo.getClaimSubmissionReasonLkpcd());
		}
		cd.setApc("");
		cd.setDrgCode(claimHeaderBo.getDrgCode());
		if(!StringUtils.isEmpty(claimHeaderBo.getDrgCode()))
		{
			cd.setMdc(repository.getMdcId(claimHeaderBo.getDrgCode()));
		}
		
		cd.setBlngNationalPrvdrIdntfr(claimHeaderBo.getBlngNationalPrvdrIdntfr());
		cd.setBlngPrvdrLctnZipCode(claimHeaderBo.getBlngPrvdrLctnZipCode());
		cd.setTotalBilledAmount(claimHeaderBo.getTotalBilledAmount());
		if(null!=claimHeaderBo.getClmHdrDerivedElement())
		{
			cd.setPaidAmount(claimHeaderBo.getClmHdrDerivedElement().getPaidAmount());
		}
		//Diagnosis
		if(null!=claimHeaderBo.getClmHdrXDiagnosis())
		{
			Set<ClmHdrXDiagnosis> diagSet = claimHeaderBo.getClmHdrXDiagnosis();
			for(ClmHdrXDiagnosis clmHdrXDiagnosis : diagSet){
				if("P".equals(clmHdrXDiagnosis.getPrimaryQlfr()))
				{
					cd.setPrncplDgnsCd(repository.convertIcd9To10(clmHdrXDiagnosis.getDiagnosisCode()));
					cd.setPrncplDgnsPoa(clmHdrXDiagnosis.getPoaLkpcd());
				}
				if("BJ".equals(clmHdrXDiagnosis.getDiagQlfr()) || "ABJ".equals(clmHdrXDiagnosis.getDiagQlfr()))
				{
					cd.setAdmtDiagCd(repository.convertIcd9To10(clmHdrXDiagnosis.getDiagnosisCode()));
				}
				else if("T".equals(clmHdrXDiagnosis.getPrimaryQlfr()))
				{
					int seqNo = clmHdrXDiagnosis.getDiagnosisOrderSqncNmbr().intValue();
					seqNo = seqNo -1;
					if(seqNo<25)
					{
						//cd.setP1(clmHdrXProcedure.getPrcdrCode());
						cd = setValue(cd, "d"+seqNo,repository.convertIcd9To10(clmHdrXDiagnosis.getDiagnosisCode()));
						cd = setValue(cd, "d"+seqNo+"_poa",clmHdrXDiagnosis.getPoaLkpcd());
					}
				}
			}
		}
			
		
		//Providers
		if(null!=claimHeaderBo.getClmHdrXPrvdrLctns())
		for(ClmHdrXPrvdrLctn clmHdrXPrvdrLctn:claimHeaderBo.getClmHdrXPrvdrLctns())
		{
			cd.setAttendingNationalPrvdrIdntfr(clmHdrXPrvdrLctn.getPrvdrLctnIdentifier());
		}
		//Procedures
		if(null!=claimHeaderBo.getClmHdrXProcedures())
		for(ClmHdrXProcedure clmHdrXProcedure:claimHeaderBo.getClmHdrXProcedures())
		{
			if("P".equals(clmHdrXProcedure.getProcedureTypeQlfr()))
			{
				cd.setPrncplPrcdrCd(repository.convertIcd9To10(clmHdrXProcedure.getPrcdrCode()));
				if(null!=clmHdrXProcedure.getSurgicalPrcdrDate())
				{
					cd.setPrncplPrcdrCdDate(clmHdrXProcedure.getSurgicalPrcdrDate().toString());
				}
			}
			else if("O".equals(clmHdrXProcedure.getProcedureTypeQlfr()))
			{
				int seqNo = clmHdrXProcedure.getPrcdrOrderSqncNmbr().intValue();
				seqNo = seqNo -1;
				cd = setValue(cd, "p"+seqNo,repository.convertIcd9To10(clmHdrXProcedure.getPrcdrCode()));
				cd = setValue(cd, "p"+seqNo+"_dt",clmHdrXProcedure.getSurgicalPrcdrDate());
			}
		}
		
		//Admissions
		if(null!=claimHeaderBo.getClmHdrAdmissionDetails())
		{
			for(ClmHdrAdmissionDetail clmHdrAdmissionDetail:claimHeaderBo.getClmHdrAdmissionDetails())
			{
				cd.setAdmissionSourceLkpcd(clmHdrAdmissionDetail.getAdmissionSourceLkpcd());
				cd.setAdmissionSourceLkpcd(clmHdrAdmissionDetail.getAdmissionTypeLkpcd());
				cd.setAdmissionTypeLkpcd(clmHdrAdmissionDetail.getPatientStatusLkpcd());
			}
		}
		
		//Conditions
		if(null!=claimHeaderBo.getClmHdrConditions())
		{
			int seqNo =1;
			for(ClmHdrCondition clmHdrCondition: claimHeaderBo.getClmHdrConditions())
			{
				cd = setValue(cd, "cnd"+seqNo,clmHdrCondition.getClmConditionCid());
				seqNo++;
			}
		}
		
		//Occurence
		if(null!=claimHeaderBo.getClmHdrOccurrenceDetails())
		{
			int seqNo =1;
			for(ClmHdrOccurrenceDetail clmHdrOccurrenceDetail: claimHeaderBo.getClmHdrOccurrenceDetails())
			{
				cd = setValue(cd, "ocr"+seqNo,clmHdrOccurrenceDetail.getClmOccurrenceAndSpanCid());
				cd = setValue(cd, "ocr"+seqNo+"_dt",clmHdrOccurrenceDetail.getFromDate());
				seqNo++;
			}
		}
		//Value codes
		if(null!=claimHeaderBo.getClmHdrValueAmounts())
		{
			int seqNo =1;
			for(ClmHdrValueAmount clmHdrValueAmount: claimHeaderBo.getClmHdrValueAmounts())
			{
				cd = setValue(cd, "val"+seqNo,clmHdrValueAmount.getAmountTypeLkpcd());
				cd = setValue(cd, "val"+seqNo+"_amt",clmHdrValueAmount.getClmAmountValue());
				seqNo++;
			}
		}
		
		List<CL> lines = new ArrayList<CL>();
		//Lines
		for(ClaimLine claimLine:claimHeaderBo.getClaimLines())
		{
			CL cl = new CL();
			cl.setBilledAmount(claimLine.getBilledAmount().toString());
			cl.setBilledUnits(claimLine.getBilledUnits().toString());
			cl.setClaimLineTcn(claimLine.getClaimLineTcn());
			SimpleDateFormat sdfSource = new SimpleDateFormat("yyyy-MM-dd");
			String date = sdfSource.format(claimLine.getFromServiceDate());
			cl.setFromServiceDate(date);
			cl.setToServiceDate(date);
			if(null!=claimLine.getClmLnDerivedElement())
			{
				cl.setPaidAmount(claimLine.getClmLnDerivedElement().getPaidAmount().toString());
			}
			cl.setPrcdrCode(claimLine.getPrcdrCode());
			cl.setRevenueCode(claimLine.getRevenueCode());
			lines.add(cl);
		}
		cd.setLines(lines);
		return cd;
	}
	
	private CH setValue(CH c1, String p_sAttributeName, Object p_sAttributeValue)
	{
		Field field;
		try {
			field = c1.getClass().getDeclaredField(p_sAttributeName);
			field.setAccessible(true);
			field.set(c1, typeCastedObject(field, p_sAttributeValue));
			field.setAccessible(false);
		} catch (NoSuchFieldException | SecurityException
				| IllegalArgumentException | IllegalAccessException e) {
			e.printStackTrace();
		}
		return c1;
	}
	private  Object typeCastedObject(Field field, Object value) {
		if (value != null && !value.toString().equals("") && !value.toString().equals("Blank")) {
			if (field.getType().equals(String.class)) {
				return value.toString();
			}
			if (field.getType().equals(double.class) || field.getType().equals(Double.class)) {
				return Double.parseDouble(value.toString());
			}
			if (field.getType().equals(int.class) || field.getType().equals(Integer.class)) {
				return Integer.parseInt(value.toString());
			}
			if (field.getType().equals(long.class) || field.getType().equals(Long.class)) {
				return Long.parseLong(value.toString());
			}
			if (field.getType().equals(BigDecimal.class)) {
				return value.toString() != null ? new BigDecimal(value.toString()): new BigDecimal(0);
			}
			if (field.getType().equals(boolean.class)) {
				return Boolean.parseBoolean(value.toString());
			}
			if (field.getType().equals(Date.class)) {
				return value;
			}
		}
		return null;
	}
}
