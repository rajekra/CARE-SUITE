package com.icare.ing.mongo;

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
import com.icare.common.service.PropUtilityService;
import com.mongodb.BasicDBObject;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
public class ClaimHeaderIngestion {

	public static void main(String[] args) throws JsonParseException, JsonMappingException, IOException {
		MongoClient mongoClient = new MongoClient( "localhost" , 27017 );
		MongoDatabase database = mongoClient.getDatabase("icare");
		MongoCollection<BasicDBObject> collection = database.getCollection("institutional",BasicDBObject.class);
		
		
		
		File folder = new File("C:/EDPS/Delivery/test/json444/IP/20170911171412");
		File[] listOfFiles = folder.listFiles();
		List<BasicDBObject>  objs= new ArrayList<BasicDBObject>();
		for (File file : listOfFiles) {
		    if (file.isFile()) {
		        System.out.println(file.getName());
		        BasicDBObject dbc = new BasicDBObject();
				ClaimHeader header = PropUtilityService.translateJsonToBusinessObject("C:/EDPS/Delivery/test/json444/IP/20170911171412/"+file.getName());
				CD cd = PropUtilityService.translateClaimHeaderToCD(header);
				System.out.println("CD String:" + cd);
				String headerString = PropUtilityService.translateCDToJsonString(cd);
				System.out.println("Converted String:" + headerString);
				
				BSONObject bson = (BSONObject)com.mongodb.util.JSON.parse(headerString);
				dbc.putAll(bson);
				objs.add(dbc);
				break;
		    }
		}
		
		collection.insertMany(objs);
	}

}
