package com.icare.ing.util;

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

import org.apache.commons.lang.StringUtils;

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
import com.icare.common.dto.CH;
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
	
	public static String translateCDToJsonString(CH claimHeaderBo) throws JsonProcessingException
	{
		return objectMapper.writeValueAsString(claimHeaderBo);
	}
	
	public static CH translateJsonToCD(String json) throws JsonParseException, JsonMappingException, IOException
	{
		objectMapper.configure(DeserializationFeature.UNWRAP_ROOT_VALUE, false);
		CH cd = objectMapper.readValue(json, CH.class);
		objectMapper.configure(DeserializationFeature.UNWRAP_ROOT_VALUE, true);
		return cd;
	}
	
	public static ClaimHeader translateJsonToBusinessObject(String jsonFileWithPath) throws JsonParseException, JsonMappingException, IOException
	{
		ClaimHeader claimHeader =   objectMapper.readValue(new File(jsonFileWithPath), ClaimHeader.class);
		System.out.println("ClaimHeader:" + claimHeader.getClaimLines());
		return claimHeader;
	}
}
