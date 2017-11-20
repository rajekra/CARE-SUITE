package com.icare.dataprocessing.service.ingestion;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections.map.MultiValueMap;
import org.bson.BSONObject;
import org.bson.BasicBSONEncoder;
import org.bson.Document;

import com.ecams.claim.bo.ClaimHeader;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.icare.dataprocessing.dto.CH;
import com.icare.dataprocessing.dto.CL;
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
		
	//	MongoCollection<BasicDBObject> INSTITUTIONAL_LK = CommonConstants.INPATIENT_STAGING;
		MongoCollection<BasicDBObject> INSTITUTIONAL_LK = CommonConstants.PROF_STAGING;
		int count =1;
		//File folder = new File("C:/EDPS/Delivery/test/json444/IP/20170911171412");
		//File folder = new File("C:/Users/kandhasamyr/OneDrive - CNSI/ICARE/data/WA_DATA");
		File folder = new File("C:/DevelopmentStage/OWCP/HCE_DEMO/HCE_DEMO_JSONS/ICARE");
		File[] listOfFiles = folder.listFiles();
		System.out.println("No. Of Files:" +listOfFiles.length );
		List<BasicDBObject>  objs= new ArrayList<BasicDBObject>();
		Map<Integer,String> map = CSVReaderExample.getMemberAndDate();

		for (File file : listOfFiles) {
		    if (file.isFile()) {
		        System.out.println(file.getName());
		        for(int i=0;i<=map.size()-60;i++)
		        {
		        	  BasicDBObject dbc = new BasicDBObject();
		  			//	ClaimHeader header = JsonUtil.translateJsonToBusinessObject("C:/Users/kandhasamyr/OneDrive - CNSI/ICARE/data/WA_DATA/"+file.getName());
		  			//	ClaimHeader header = JsonUtil.translateJsonToBusinessObject("C:/EDPS/Delivery/test/json444/IP/20170911171412/"+file.getName() );
		  				ClaimHeader header = JsonUtil.translateJsonToBusinessObject("C:/DevelopmentStage/OWCP/HCE_DEMO/HCE_DEMO_JSONS/ICARE/"+file.getName() );
		  				ClaimHeaderToCHConverter claimHeaderToCDConverter = new ClaimHeaderToCHConverter();
		  				MasterDataRepositoryInf repository = new MasterDataRepositoryImpl();
		  				CH cd = claimHeaderToCDConverter.translateClaimHeaderToCD(header,repository);
		  				System.out.println("CD String:" + cd);
		  				String headerString = JsonUtil.translateCDToJsonString(cd);
		  				System.out.println("Converted String:" + headerString);
		  				String value = (String) map.get(i);
		  				System.out.println("==============value:" + value);
		  				if(null!=value &&value.length()>1 && !"_".equals(value)){
		  					String[] values = value.split("_");
			  				String mbrId = values[0];
			  				String date = values[1];
			  				cd.setMbrIdentifier(mbrId);
			  				CL cl = cd.getLines().get(0);
			  				cl.setMbrIdentifier(mbrId);
			  				cl.setFromServiceDate(date);
			  				cl.setToServiceDate(date);
			  				BSONObject bson = (BSONObject)com.mongodb.util.JSON.parse(headerString);
			  				dbc.putAll(bson);
			  				objs.add(dbc);
		  				}
		  				
//		  				if(count++ == 100)
//		  				{
//		  					break;
//		  				}
//		  				
		        }
		      
		    }
		}
		
		INSTITUTIONAL_LK.insertMany(objs);
	}

}
