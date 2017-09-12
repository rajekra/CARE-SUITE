package com.icare.common.dto;

import java.util.Map;

import org.apache.kafka.common.serialization.Serializer;

import com.ecams.claim.bo.ClaimHeader;
import com.ecams.claim.bo.ClaimLine;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.icare.common.service.PropUtilityService;
public class CHSerializer implements Serializer<ClaimHeader> {

	  @Override
	  public void close() {

	  }

	  @Override
	  public void configure(Map<String, ?> arg0, boolean arg1) {

	  }

	  @Override
	  public byte[] serialize(String arg0, ClaimHeader arg1) {
	    byte[] retVal = null;
	    try {
	      retVal = PropUtilityService.getMapper().writeValueAsString(arg1).getBytes();
	    } catch (Exception e) {
	      e.printStackTrace();
	    }
	    return retVal;
	  }


	}
