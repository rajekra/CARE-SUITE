package com.icare.dataprocessing.service.ingestion;

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
import com.icare.dataprocessing.dto.CH;
import com.icare.dataprocessing.repository.impl.MasterDataRepositoryImpl;
import com.icare.dataprocessing.repository.intf.MasterDataRepositoryInf;
import com.icare.dataprocessing.util.CommonConstants;
import com.icare.dataprocessing.util.JsonUtil;
import com.icare.dataprocessing.util.spark.ClaimHeaderToCHConverter;
import com.mongodb.BasicDBObject;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
public class ConsumeInpatinetClaimStanalone {

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
		
		MongoCollection<BasicDBObject> INSTITUTIONAL_LK = CommonConstants.INPATIENT_STAGING;
		int count =1;
		File folder = new File("C:/EDPS/Delivery/test/json444/IP/20170911171412");
		//File folder = new File("C:/Users/kandhasamyr/OneDrive - CNSI/ICARE/data/WA_DATA");
		File[] listOfFiles = folder.listFiles();
		System.out.println("No. Of Files:" +listOfFiles.length );
		List<BasicDBObject>  objs= new ArrayList<BasicDBObject>();
		for (File file : listOfFiles) {
		    if (file.isFile()) {
		        System.out.println(file.getName());
		        BasicDBObject dbc = new BasicDBObject();
			//	ClaimHeader header = JsonUtil.translateJsonToBusinessObject("C:/Users/kandhasamyr/OneDrive - CNSI/ICARE/data/WA_DATA/"+file.getName());
				ClaimHeader header = JsonUtil.translateJsonToBusinessObject("C:/EDPS/Delivery/test/json444/IP/20170911171412/"+file.getName() );
				ClaimHeaderToCHConverter claimHeaderToCDConverter = new ClaimHeaderToCHConverter();
				MasterDataRepositoryInf repository = new MasterDataRepositoryImpl();
				CH cd = claimHeaderToCDConverter.translateClaimHeaderToCD(header,repository);
				System.out.println("CD String:" + cd);
				String headerString = JsonUtil.translateCDToJsonString(cd);
				System.out.println("Converted String:" + headerString);
				
				BSONObject bson = (BSONObject)com.mongodb.util.JSON.parse(headerString);
				dbc.putAll(bson);
				objs.add(dbc);
//				if(count++ == 100)
//				{
//					break;
//				}
//				
		    }
		}
		
		INSTITUTIONAL_LK.insertMany(objs);
	}

}
