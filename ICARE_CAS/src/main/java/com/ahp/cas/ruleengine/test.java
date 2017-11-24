package com.ahp.cas.ruleengine;

import com.ahp.cas.domains.member.MemberInfo;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

public class test {
	private static ObjectMapper mapper = new ObjectMapper();

	public static void main(String[] args) throws JsonProcessingException {
		mapper.configure(DeserializationFeature.UNWRAP_ROOT_VALUE, false);
		mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		mapper.enable(DeserializationFeature.ACCEPT_EMPTY_STRING_AS_NULL_OBJECT);
		mapper.enable(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY);
		MemberInfo mbr = new MemberInfo();
		mbr.setMbrSid(new Long(855840));
		mbr.setIdentifier("855840");
		mbr.setFirstName("ANTHONY");
		mbr.setLastName("BISHOP");
		String jsonInString = mapper.writeValueAsString(mbr);
		System.out.println(jsonInString);
	}

}
