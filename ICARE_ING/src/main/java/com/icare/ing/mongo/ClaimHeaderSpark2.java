package com.icare.ing.mongo;


import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.SparkSession;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.icare.common.dto.CD;
import com.icare.common.dto.CL;
import com.icare.common.service.PropUtilityService;
import com.mongodb.BasicDBObject;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;


public final class ClaimHeaderSpark2 {

  public static void main(final String[] args) throws InterruptedException, JsonParseException, JsonMappingException, IOException {
	  
    SparkSession spark = SparkSession.builder()
      .master("local")
      .appName("MongoSparkConnectorIntro")
      .config("spark.executor.heartbeatInterval", "20s")
      .config("spark.driver.extraJavaOptions", "-Xss600m")
      .config("spark.sql.crossJoin.enabled", "true")
      .config("spark.mongodb.input.uri", "mongodb://127.0.0.1/icare.institutional")
      .config("spark.mongodb.output.uri", "mongodb://127.0.0.1/icare.institutional")
      .getOrCreate();
    JavaSparkContext jsc = new JavaSparkContext(spark.sparkContext());
    
	MongoClient mongoClient = new MongoClient( "localhost" , 27017 );

    MongoDatabase database = mongoClient.getDatabase("icare");
	MongoCollection<BasicDBObject> collection = database.getCollection("institutional",BasicDBObject.class);
	BasicDBObject dbc = new BasicDBObject();
	
	MongoCursor<BasicDBObject> cursor= collection.find().iterator();
	List<CD> cds = new ArrayList<CD>();
	List<CL> cls = new ArrayList<CL>();
	 while (cursor.hasNext()) {
		 BasicDBObject basicDBObject = cursor.next();
		 String jsonString = basicDBObject.toJson();
		 CD cd = PropUtilityService.translateJsonToCD(jsonString);
		 cls.addAll(cd.getLines());
		 System.out.println("CD===============================================");
		 System.out.println(cd);
		 System.out.println("CD===============================================");
		 cds.add(cd);
		 cd.setLines(null);
	    }
	
	  Dataset<Row> dataFrame = spark.createDataFrame(cds, CD.class);
	  Dataset<Row> lineFrames = spark.createDataFrame(cls, CL.class);
	  lineFrames.printSchema();
	  lineFrames.show();
	  
	  dataFrame.createOrReplaceTempView("header");
	  lineFrames.createOrReplaceTempView("line");
	    
	    //Dataset<Row> centenarians = spark.sql("select sum(cast(s.billedAmount as int)) from line s");
	  Dataset<Row> centenarians = spark.sql("select distinct h.blngNationalPrvdrIdntfr, sum(cast(s.billedAmount as int)) , to_date(s.fromServiceDate) as dd from line s , header h group by s.fromServiceDate,h.blngNationalPrvdrIdntfr");
	    centenarians.show();
      
    jsc.close();

  }
}