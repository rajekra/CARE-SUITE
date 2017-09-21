package com.icare.ing.service.descriptive;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.SparkSession;
import org.graphframes.GraphFrame;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.icare.common.dto.CH;
import com.icare.common.dto.CL;
import com.icare.ing.dto.InpatientVertex;
import com.icare.ing.dto.MDCVertex;
import com.icare.ing.util.CommonConstants;
import com.icare.ing.util.PropUtilityService;
import com.mongodb.BasicDBObject;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.spark.MongoSpark;
import com.mongodb.spark.config.ReadConfig;

public class MdcAnalytics {
	public static void main(String[] args) throws JsonParseException, JsonMappingException, IOException {

		SparkSession spark = SparkSession.builder()
			      .master("local")
			      .appName("MongoSparkConnectorIntro")
			      .config("spark.mongodb.input.uri", "mongodb://127.0.0.1/icare.MAJOR_DIAG_CATEGORY_MS")
			      .config("spark.mongodb.output.uri", "mongodb://127.0.0.1/icare.MAJOR_DIAG_CATEGORY_MS")
			      .getOrCreate();
		
		JavaSparkContext jsc = new JavaSparkContext(spark.sparkContext());
		
		
		
		
		
		
		MongoCollection<BasicDBObject> collection = CommonConstants.INSTITUTIONAL_LK;
		
		MongoCursor<BasicDBObject> cursor= collection.find().iterator();
		List<InpatientVertex> cds = new ArrayList<InpatientVertex>();
		 while (cursor.hasNext()) {
			 BasicDBObject basicDBObject = cursor.next();
			 String jsonString = basicDBObject.toJson();
			 CH cd = PropUtilityService.translateJsonToCD(jsonString);
			 InpatientVertex ipv = new InpatientVertex();
			 ipv.setMdc(cd.getMdc());
			 ipv.setTotalBilledAmount(cd.getTotalBilledAmount());
			 cds.add(ipv);
			 cd.setLines(null);
		    }
		
		  Dataset<Row> claims = spark.createDataFrame(cds, InpatientVertex.class);
		
		
		
		
		
		
		 Dataset<Row> masterMdcVertices = MongoSpark.load(jsc).toDF();
		// masterMdcVertices.printSchema();
		// masterMdcVertices.show();

		 // Loading data with a custom ReadConfig
	     Map<String, String> readOverrides = new HashMap<String, String>();
	     readOverrides.put("collection", "INSTITUTIONAL_LK");
	     readOverrides.put("readPreference.name", "secondaryPreferred");
	     ReadConfig readConfig = ReadConfig.create(jsc).withOptions(readOverrides);
	     
	   //  Dataset<CD> claims =  MongoSpark.load(jsc, readConfig).toDS(CD.class);
	   //  claims.printSchema();
	   //  claims.show();
	        
	     masterMdcVertices.createOrReplaceTempView("MasterMdc");
	     claims.createOrReplaceTempView("Claims");
	    
	     //Dataset<Row> edges = spark.sql("SELECT claims.mdc as srcMdc, md.MDC_ID as desMdc,claims.totalBilledAmount as tb FROM MasterMdc md, Claims claims where md.MDC_ID = claims.mdc");
    
	     Dataset<Row> aggrClaims = spark.sql("select cast(h.mdc as int) as mdc, sum(cast(h.totalBilledAmount as int)) as total_amount from Claims h group by h.mdc order by total_amount desc");
	     aggrClaims.createOrReplaceTempView("AggrClaims");
	     aggrClaims.printSchema();
	     aggrClaims.show();
	     
	     Dataset<Row> edges = spark.sql("SELECT cast(MDC_ID as int) as srcMdc, cast(MDC_ID as int) as desMdc FROM MasterMdc");
	     
	     edges.printSchema();
	     GraphFrame gFrame = new GraphFrame(masterMdcVertices, edges);
		 gFrame.cache();
		 
		 
		// gFrame.edges().show();
 		 gFrame.inDegrees().show();
		 
//		 GraphFrame pRank = gFrame.pageRank().resetProbability(0.01).maxIter(1).run();
//			pRank.vertices().show();
 		 spark.stop();
		
	}
	
}
