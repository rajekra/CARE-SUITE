package com.icare.dataprocessing.util;

import com.mongodb.BasicDBObject;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

public class CommonConstants {
	public static String SPARK_MASTER = "local";
	//public static String MONGO_URI = "mongodb://10.0.0.247/";
	//public static MongoClient MONGO_CLIENT_URL = new MongoClient( "10.0.0.247" , 27017 );
	public static String MONGO_URI = "mongodb://127.0.0.1/";
	public static MongoClient MONGO_CLIENT_URL = new MongoClient( "127.0.0.1" , 27017 );
	public static MongoDatabase ICARE_SCHEMA = MONGO_CLIENT_URL.getDatabase("icare");
	public static MongoCollection<BasicDBObject> MDC_DRG_DIAGNOSIS_CROSSWALK_MS = ICARE_SCHEMA.getCollection("MDC_DRG_DIAGNOSIS_CROSSWALK_MS",BasicDBObject.class);
	public static MongoCollection<BasicDBObject> ICD_GEM_MS = ICARE_SCHEMA.getCollection("ICD_GEM_MS",BasicDBObject.class);

	public static MongoCollection<BasicDBObject> MAJOR_DIAG_CATEGORY_MS = ICARE_SCHEMA.getCollection("MAJOR_DIAG_CATEGORY_MS",BasicDBObject.class);
	
	public static MongoCollection<BasicDBObject> INPATIENT_STAGING = ICARE_SCHEMA.getCollection("INPATIENT_STAGING_NONCOPD",BasicDBObject.class);
	public static MongoCollection<BasicDBObject> INPATIENT_AGGREGATED = ICARE_SCHEMA.getCollection("INPATIENT_AGGREGATED_NONCOPD",BasicDBObject.class);
	public static MongoCollection<BasicDBObject> PROF_STAGING = ICARE_SCHEMA.getCollection("PROF_STAGING",BasicDBObject.class);

	public static String INPATIENT_AGGREGATED_STR = "INPATIENT_STAGING_NONCOPD";
	
	public static MongoCollection<BasicDBObject> OUTPATIENT_STAGING = ICARE_SCHEMA.getCollection("OUTPATIENT_STAGING",BasicDBObject.class);
	public static MongoCollection<BasicDBObject> OUTPATIENT_AGGREGATED = ICARE_SCHEMA.getCollection("OUTPATIENT_AGGREGATED",BasicDBObject.class);
	public static String OUTPATIENT_AGGREGATED_STR = "OUTPATIENT_AGGREGATED";
}
