package com.icare.dataprocessing.service_examples;

import java.io.IOException;

import org.bson.BSONObject;

import com.ecams.claim.bo.ClaimHeader;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.icare.dataprocessing.util.JsonUtil;
import com.mongodb.BasicDBObject;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
public class Sample {

	public static void main(String[] args) throws JsonParseException, JsonMappingException, IOException {
		MongoClient mongoClient = new MongoClient( "localhost" , 27017 );
		MongoDatabase database = mongoClient.getDatabase("icare");
		MongoCollection<BasicDBObject> collection = database.getCollection("t1",BasicDBObject.class);
		BasicDBObject dbc = new BasicDBObject();
		
		
		ClaimHeader header = JsonUtil.translateJsonToBusinessObject("C:\\Testing\\Output\\JSON\\CLAIM_5010_PROFESSIONAL_A1\\20170906\\16\\Output_Claim_1_20170906_160815546.json");
		String headerString = JsonUtil.translateBoToJsonString(header);
		System.out.println("My String:" + headerString);
		
		BSONObject bson = (BSONObject)com.mongodb.util.JSON.parse(headerString);
		dbc.putAll(bson);
		collection.insertOne(dbc);
	}

}
