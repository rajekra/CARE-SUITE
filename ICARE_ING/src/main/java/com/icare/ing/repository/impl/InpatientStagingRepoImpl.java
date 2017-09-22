package com.icare.ing.repository.impl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.icare.common.dto.CH;
import com.icare.common.dto.CL;
import com.icare.ing.repository.intf.InpatientStagingRepoIntf;
import com.icare.ing.util.CommonConstants;
import com.icare.ing.util.JsonUtil;
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
	public <T> T load() throws JsonParseException, JsonMappingException, IOException {
		Map<String, List<?>> returnItems = new HashMap<String, List<?>>();
		MongoCollection<BasicDBObject> collection = CommonConstants.INSTITUTIONAL_LK;
		MongoCursor<BasicDBObject> cursor = collection.find().iterator();
		List<CH> cds = new ArrayList<CH>();
		List<CL> cls = new ArrayList<CL>();
		while (cursor.hasNext()) {
			BasicDBObject basicDBObject = cursor.next();
			String jsonString = basicDBObject.toJson();
			CH cd = JsonUtil.translateJsonToCD(jsonString);
			cls.addAll(cd.getLines());
			System.out.println("CD===============================================");
			System.out.println(cd);
			System.out.println("CD===============================================");
			cds.add(cd);
			cd.setLines(null);
		}
		returnItems.put("Header", cds);
		returnItems.put("Line", cls);
		return (T) returnItems;
	}
}
