package com.icare.ing.service.analytics;


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
import com.icare.ing.util.CommonConstants;
import com.icare.ing.util.PropUtilityService;
import com.mongodb.BasicDBObject;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;


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
    
	MongoCollection<BasicDBObject> collection = CommonConstants.INSTITUTIONAL_LK;
	
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
	//  lineFrames.show();
	  
	  dataFrame.createOrReplaceTempView("header");
	  lineFrames.createOrReplaceTempView("line");
	    
	    //Dataset<Row> centenarians = spark.sql("select sum(cast(s.billedAmount as int)) from line s");
	 // Dataset<Row> centenarians = spark.sql("select distinct h.totalBilledAmount,h.tcn, sum(cast(s.billedAmount as int)) , to_date(s.fromServiceDate) as dd from line s , header h group by s.fromServiceDate,h.totalBilledAmount,h.tcn");
	  Dataset<Row> centenarians = spark.sql("select distinct h.prncplPrcdrCd, h.prncplDgnsCd, h.mdc, sum(cast(h.totalBilledAmount as int)) as total_amount from header h group by h.mdc,h.prncplDgnsCd, h.prncplPrcdrCd order by total_amount desc");
	  	StringBuilder sb = new StringBuilder();
	    centenarians.foreach(i -> System.out.println("RAJ:"+i));
	    System.out.println(sb);

	    centenarians.createOrReplaceTempView("aggheader");
	    centenarians.printSchema();
	    centenarians.collect();
    jsc.close();

  }
}