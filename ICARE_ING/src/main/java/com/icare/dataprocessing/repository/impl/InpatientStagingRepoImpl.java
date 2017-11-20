package com.icare.dataprocessing.repository.impl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.icare.dataprocessing.dto.CH;
import com.icare.dataprocessing.dto.CL;
import com.icare.dataprocessing.repository.intf.InpatientStagingRepoIntf;
import com.icare.dataprocessing.util.CommonConstants;
import com.icare.dataprocessing.util.JsonUtil;
import com.mongodb.BasicDBObject;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;

// TODO: Auto-generated Javadoc
/**
 * The Class InpatientStagingRepoImpl.
 */
public class InpatientStagingRepoImpl implements InpatientStagingRepoIntf{
	
	/* (non-Javadoc)
	 * @see com.icare.ing.repository.intf.InpatientStagingRepoIntf#load()
	 */
	public <T> T load(String tableName) throws JsonParseException, JsonMappingException, IOException {
		System.out.println("Getting records from staging table!!!");
		Map<String, List<?>> returnItems = new HashMap<String, List<?>>();
		MongoCollection<BasicDBObject> collection = null;
		if(null!=tableName && "INPATIENT_STAGING".equalsIgnoreCase(tableName))
		{
			collection = CommonConstants.INPATIENT_STAGING;
		}
		else if(null!=tableName && "PROF_STAGING".equalsIgnoreCase(tableName))
		{
			collection = CommonConstants.PROF_STAGING;
		}
		if(null!=collection)
		{
			MongoCursor<BasicDBObject> cursor = collection.find().iterator();
			int count =0;
			List<CH> cds = new ArrayList<CH>();
			List<CL> cls = new ArrayList<CL>();
			while (cursor.hasNext()) {
				BasicDBObject basicDBObject = cursor.next();
				String jsonString = basicDBObject.toJson();
				CH cd = JsonUtil.translateJsonToCD(jsonString);
				cls.addAll(cd.getLines());
//				System.out.println("CD===============================================");
//				System.out.println(cd);
//				System.out.println("CD===============================================");
				cds.add(cd);
				cd.setLines(null);
//				count++;
//				if(count==1500)
//				{
//					break;
//				}
			}
			returnItems.put("Header", cds);
			returnItems.put("Line", cls);
			System.out.println("InpatientStagingRepoImpl=>"+ returnItems.get("Header").size());
			System.out.println("InpatientStagingRepoImpl=>"+ returnItems.get("Line").size());
			return (T) returnItems;
		}
		else
		{
			return null;
		}
	}
}
