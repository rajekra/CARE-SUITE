package com.icare.ing.util.kafka;
import java.util.Map;

import org.apache.kafka.common.serialization.Deserializer;

import com.ecams.claim.bo.ClaimHeader;
import com.fasterxml.jackson.databind.ObjectMapper;
public class ClaimHeaderDeserializer implements Deserializer<ClaimHeader> {

	  @Override
	  public void close() {

	  }

	  @Override
	  public void configure(Map<String, ?> arg0, boolean arg1) {

	  }

	  @Override
	  public ClaimHeader deserialize(String arg0, byte[] arg1) {
	    ObjectMapper mapper = new ObjectMapper();
	    ClaimHeader user = null;
	    try {
	      user = mapper.readValue(arg1, ClaimHeader.class);
	    } catch (Exception e) {

	      e.printStackTrace();
	    }
	    return user;
	  }

	}