package com.icare.ing.repository.impl;

import static com.mongodb.client.model.Projections.excludeId;

import org.bson.BSONObject;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.icare.common.dto.CH;
import com.icare.ing.repository.intf.MasterDataRepositoryInf;
import com.icare.ing.util.CommonConstants;
import com.icare.ing.util.JsonUtil;
import com.mongodb.BasicDBObject;
import com.mongodb.BasicDBObjectBuilder;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.model.Projections;

public class MasterDataRepositoryImpl implements MasterDataRepositoryInf{
	public String convertIcd9To10(String icd9Code)
	{
		MongoCollection<BasicDBObject> ICD_GEM_MS = CommonConstants.ICD_GEM_MS;
		BasicDBObject query = new BasicDBObject();
		query.put("icd9", icd9Code);
		BasicDBObject fields = new BasicDBObject();
		FindIterable<BasicDBObject> cursor = ICD_GEM_MS.find(query).projection(Projections.fields(Projections.include("icd9"),excludeId()));
		////String price = ((Document) cursor).getString("icd9");
		MongoCursor<BasicDBObject> ll = cursor.iterator();
		String correspondingIcd10Code = null;
		while (ll.hasNext()) {
			BasicDBObject bo = ll.next();
			correspondingIcd10Code = bo.getString("icd9");
			System.out.println(correspondingIcd10Code);
			break;
		}
		System.out.println("ICD 9 Code:"+icd9Code + " => ICD 10 Code:" +correspondingIcd10Code );
		return (correspondingIcd10Code==null)?icd9Code:correspondingIcd10Code;
	}
	public String getMdcId(String drgCode)
	{
		MongoCollection<BasicDBObject> MAJOR_DIAG_CATEGORY_MS =CommonConstants.MAJOR_DIAG_CATEGORY_MS;
		BasicDBObject query = new BasicDBObject();
		query.put("MDC_START", BasicDBObjectBuilder.start( "$lte", Integer.parseInt(drgCode)).get());
		query.put("MDC_END", BasicDBObjectBuilder.start( "$gte", Integer.parseInt(drgCode)).get());
		BasicDBObject fields = new BasicDBObject();
		
		FindIterable<BasicDBObject> cursor = MAJOR_DIAG_CATEGORY_MS.find(query).projection(Projections.fields(Projections.include("MDC_ID"),excludeId()));
		////String price = ((Document) cursor).getString("icd9");
		MongoCursor<BasicDBObject> ll = cursor.iterator();
		String mdcDescription = null;
		while (ll.hasNext()) {
			BasicDBObject bo = ll.next();
			mdcDescription = bo.getString("MDC_ID");
			break;
		}
 
		System.out.println("MDC_ID:" +mdcDescription );
		return (mdcDescription==null)?drgCode:mdcDescription;
	}
	@Override
	public void saveCD(CH cd) {
		MongoCollection<BasicDBObject> INSTITUTIONAL_LK = CommonConstants.INPATIENT_STAGING;
		String headerString = null;
		try {
			headerString = JsonUtil.translateCDToJsonString(cd);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		BSONObject bson = (BSONObject) com.mongodb.util.JSON.parse(headerString);
		BasicDBObject dbc = new BasicDBObject();
		dbc.putAll(bson);
		INSTITUTIONAL_LK.insertOne(dbc);
	}
}
