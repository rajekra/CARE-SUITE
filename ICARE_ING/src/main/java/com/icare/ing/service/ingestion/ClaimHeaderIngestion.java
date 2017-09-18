package com.icare.ing.service.ingestion;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.bson.BSONObject;
import org.bson.BasicBSONEncoder;
import org.bson.Document;

import com.ecams.claim.bo.ClaimHeader;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.icare.common.dto.CD;
import com.icare.ing.repository.impl.SparkMongoRepositoryImpl;
import com.icare.ing.repository.intf.SparkRepositoryInf;
import com.icare.ing.util.CommonConstants;
import com.icare.ing.util.PropUtilityService;
import com.icare.ing.util.spark.ClaimHeaderToCDConverter;
import com.mongodb.BasicDBObject;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
public class ClaimHeaderIngestion {

	public static void main(String[] args) throws JsonParseException, JsonMappingException, IOException {
		
//		BasicDBObject dbc = new BasicDBObject();
//		ClaimHeader header = PropUtilityService.translateJsonToBusinessObject("C:/Testing/Output/JSON/CLAIM_5010_INSTITUIONAL_A2/20170912/12/Output_Claim_1_20170912_124143106.json");
//		CD cd = PropUtilityService.translateClaimHeaderToCD(header);
//		System.out.println("CD String:" + cd);
//		String headerString = PropUtilityService.translateCDToJsonString(cd);
//		System.out.println("Converted String:" + headerString);
//		
//		BSONObject bson = (BSONObject)com.mongodb.util.JSON.parse(headerString);
//		dbc.putAll(bson);
//		collection.insertOne(dbc);
		
		MongoCollection<BasicDBObject> INSTITUTIONAL_LK = CommonConstants.INSTITUTIONAL_LK;
		int count =1;
		File folder = new File("C:/EDPS/Delivery/test/json444/IP/20170911171412");
		File[] listOfFiles = folder.listFiles();
		List<BasicDBObject>  objs= new ArrayList<BasicDBObject>();
		for (File file : listOfFiles) {
		    if (file.isFile()) {
		        System.out.println(file.getName());
		        BasicDBObject dbc = new BasicDBObject();
				ClaimHeader header = PropUtilityService.translateJsonToBusinessObject("C:/EDPS/Delivery/test/json444/IP/20170911171412/"+file.getName());
				ClaimHeaderToCDConverter claimHeaderToCDConverter = new ClaimHeaderToCDConverter();
				SparkRepositoryInf repository = new SparkMongoRepositoryImpl();
				CD cd = claimHeaderToCDConverter.translateClaimHeaderToCD(header,repository);
				System.out.println("CD String:" + cd);
				String headerString = PropUtilityService.translateCDToJsonString(cd);
				System.out.println("Converted String:" + headerString);
				
				BSONObject bson = (BSONObject)com.mongodb.util.JSON.parse(headerString);
				dbc.putAll(bson);
				objs.add(dbc);
				if(count++ == 100)
				{
					break;
				}
				
		    }
		}
		
		INSTITUTIONAL_LK.insertMany(objs);
	}

}
