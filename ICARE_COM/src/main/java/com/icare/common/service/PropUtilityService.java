package com.icare.common.service;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

import com.ecams.claim.bo.ClaimHeader;
import com.ecams.claim.bo.ClaimLine;
import com.ecams.claim.bo.ClmHdrAdmissionDetail;
import com.ecams.claim.bo.ClmHdrCondition;
import com.ecams.claim.bo.ClmHdrOccurrenceDetail;
import com.ecams.claim.bo.ClmHdrValueAmount;
import com.ecams.claim.bo.ClmHdrXDiagnosis;
import com.ecams.claim.bo.ClmHdrXProcedure;
import com.ecams.claim.bo.ClmHdrXPrvdrLctn;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.icare.common.dto.CD;
import com.icare.common.dto.CL;


public class PropUtilityService {

	public static void main(String[] args)
	{
		
	}
	
	private static ObjectMapper objectMapper;
	static{
		objectMapper = new ObjectMapper();
		objectMapper.configure(DeserializationFeature.UNWRAP_ROOT_VALUE, true);
		objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		objectMapper.setDateFormat(df);
		objectMapper.enable(DeserializationFeature.ACCEPT_EMPTY_STRING_AS_NULL_OBJECT);
		objectMapper.enable(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY);
	}
	public static ObjectMapper getMapper()
	{
		return objectMapper;
	}
	public static String translateBoToJsonString(com.ecams.claim.bo.ClaimHeader claimHeaderBo) throws JsonProcessingException
	{
		return objectMapper.writeValueAsString(claimHeaderBo);
	}
	
	public static String translateBoToJsonString(com.icare.common.dto.Class claimHeaderBo) throws JsonProcessingException
	{
		return objectMapper.writeValueAsString(claimHeaderBo);
	}
	
	public static String translateCDToJsonString(CD claimHeaderBo) throws JsonProcessingException
	{
		return objectMapper.writeValueAsString(claimHeaderBo);
	}
	
	public static CD translateJsonToCD(String json) throws JsonParseException, JsonMappingException, IOException
	{
		objectMapper.configure(DeserializationFeature.UNWRAP_ROOT_VALUE, false);
		CD cd = objectMapper.readValue(json, CD.class);
		objectMapper.configure(DeserializationFeature.UNWRAP_ROOT_VALUE, true);
		return cd;
	}
	
	public static ClaimHeader translateJsonToBusinessObject(String jsonFileWithPath) throws JsonParseException, JsonMappingException, IOException
	{
		ClaimHeader claimHeader =   objectMapper.readValue(new File(jsonFileWithPath), ClaimHeader.class);
		System.out.println("ClaimHeader:" + claimHeader.getClaimLines());
		return claimHeader;
	}
	
	public static CD translateClaimHeaderToCD(com.ecams.claim.bo.ClaimHeader claimHeaderBo)
	{
		CD cd = new CD();
		
		//cd.set_id(new ObjectId());
		cd.setTcn(claimHeaderBo.getTcn());
		cd.setFromServiceDate(claimHeaderBo.getFromServiceDate());
		cd.setToServiceDate(claimHeaderBo.getToServiceDate());
		cd.setAdmissionDate(claimHeaderBo.getAdmissionDate());
		cd.setAdmissionHour(claimHeaderBo.getAdmissionHour());
		cd.setDischargeDate(claimHeaderBo.getDischargeDate());
		cd.setFaciType_BillFirstDigit(claimHeaderBo.getFacilityTypeCode().substring(0,1));
		cd.setServType_BillSecondDigit(claimHeaderBo.getFacilityTypeCode().substring(1,2));
		cd.setFreqType_BillThirdDigit(claimHeaderBo.getClaimSubmissionReasonLkpcd());
		cd.setApc("");
		cd.setDrgCode(claimHeaderBo.getDrgCode());
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
					cd.setPrncplDgnsCd(clmHdrXDiagnosis.getDiagnosisCode());
					cd.setPrncplDgnsPoa(clmHdrXDiagnosis.getPoaLkpcd());
				}
				if("BJ".equals(clmHdrXDiagnosis.getDiagQlfr()) || "ABJ".equals(clmHdrXDiagnosis.getDiagQlfr()))
				{
					cd.setAdmtDiagCd(clmHdrXDiagnosis.getDiagnosisCode());
				}
				else if("T".equals(clmHdrXDiagnosis.getPrimaryQlfr()))
				{
					int seqNo = clmHdrXDiagnosis.getDiagnosisOrderSqncNmbr().intValue();
					seqNo = seqNo -1;
					//cd.setP1(clmHdrXProcedure.getPrcdrCode());
					cd = setValue(cd, "d"+seqNo,clmHdrXDiagnosis.getDiagnosisCode());
					cd = setValue(cd, "d"+seqNo+"_poa",clmHdrXDiagnosis.getPoaLkpcd());
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
				cd.setPrncplPrcdrCd(clmHdrXProcedure.getPrcdrCode());
				cd.setPrncplPrcdrCdDate(clmHdrXProcedure.getSurgicalPrcdrDate());
			}
			else if("O".equals(clmHdrXProcedure.getProcedureTypeQlfr()))
			{
				int seqNo = clmHdrXProcedure.getPrcdrOrderSqncNmbr().intValue();
				seqNo = seqNo -1;
				//cd.setP1(clmHdrXProcedure.getPrcdrCode());
				cd = setValue(cd, "p"+seqNo,clmHdrXProcedure.getPrcdrCode());
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
			System.out.println("Date:"+date);
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
	
	private static CD setValue(CD c1, String p_sAttributeName, Object p_sAttributeValue)
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
	private static Object typeCastedObject(Field field, Object value) {
		System.out.println("[typeCastedObject:" + value);
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
