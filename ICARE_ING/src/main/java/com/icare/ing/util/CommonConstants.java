package com.icare.ing.util;

import com.mongodb.BasicDBObject;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

public class CommonConstants {
	public static MongoClient MONGO_CLIENT_URL = new MongoClient( "localhost" , 27017 );
	public static MongoDatabase ICARE_SCHEMA = MONGO_CLIENT_URL.getDatabase("icare");
	public static MongoCollection<BasicDBObject> MDC_DRG_DIAGNOSIS_CROSSWALK_MS = ICARE_SCHEMA.getCollection("MDC_DRG_DIAGNOSIS_CROSSWALK_MS",BasicDBObject.class);
	public static MongoCollection<BasicDBObject> INSTITUTIONAL_LK = ICARE_SCHEMA.getCollection("INSTITUTIONAL_LK",BasicDBObject.class);
	public static MongoCollection<BasicDBObject> ICD_GEM_MS = ICARE_SCHEMA.getCollection("ICD_GEM_MS",BasicDBObject.class);
	public static MongoCollection<BasicDBObject> MAJOR_DIAG_CATEGORY_MS = ICARE_SCHEMA.getCollection("MAJOR_DIAG_CATEGORY_MS",BasicDBObject.class);
}
