package com.icare.dataprocessing.service_examples;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.apache.avro.ipc.specific.Person;
import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.SQLContext;
import org.apache.spark.sql.SparkSession;







import com.ecams.claim.process.domains.wip.ClaimHeader;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import scala.Tuple2;

import java.util.Arrays;
import java.util.Collections;
import java.io.Serializable;

import org.apache.spark.api.java.function.MapFunction;
import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.Encoder;
import org.apache.spark.sql.Encoders;
import org.apache.spark.sql.functions.*;

public class ReadJsonOption2 {
public static void main(String[] aregs) throws JsonParseException, JsonMappingException, IOException
{

	 String master = "local[*]";

	 
//	 ObjectMapper mapper = new ObjectMapper();
//	 mapper.configure(DeserializationFeature.UNWRAP_ROOT_VALUE, false);
//		mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
//		mapper.enable(DeserializationFeature.ACCEPT_EMPTY_STRING_AS_NULL_OBJECT);
//		mapper.enable(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY);
//	 ClaimHeader user =  mapper.readValue(new File("C:/DevelopmentStage/OWCP/Loading - Ins Revenuew Code Derivation.json"), ClaimHeader.class);
//	 System.out.println(user);
	  SparkSession spark = SparkSession
	  .builder().master(master)
	  .appName("Java Spark SQL basic example")
	  .config("spark.some.config.option", "some-value")
	  .getOrCreate();
	 
//	  Dataset<ClaimHeader> pojos = spark.read().json("C:/EDPS/CATEGORY_1/17864_category.json").as(Encoders.bean(ClaimHeader.class));
	
//	 Encoder<ClaimHeader> personEncoder = Encoders.bean(ClaimHeader.class);
//	 Dataset<ClaimHeader> javaBeanDS = spark.createDataset(
//	   Collections.singletonList(user),
//	   personEncoder
//	 );
//	 javaBeanDS.show();
//	    /*
//	     * Initialises a Spark context.
//	     */
//	    SparkConf conf = new SparkConf()
//	        .setAppName(WordCountTask.class.getName())
//	        .setMaster(master);
//	    JavaSparkContext context = new JavaSparkContext(conf);
	    SQLContext sqlContext = spark.sqlContext();
	    Dataset<Row> claimDataSet =  sqlContext.read().json("C:/EDPS/CATEGORY_1/17864_category.json");
	    claimDataSet.printSchema();
	    Dataset<Row> personPositions = claimDataSet.select(org.apache.spark.sql.functions.explode(claimDataSet.col("HeaderProviderInformation")).as("pos"));
	    personPositions.show();
//	    claimDataSet.select(explode(data("parent.children"))).toDF("children"))
//	    claimDataSet.createOrReplaceTempView("ClaimInformation");
//	    Dataset<Row> sqlDF = sqlContext.sql("SELECT * FROM ClaimInformation ");
//	    sqlDF.show();
//	    sqlDF.createOrReplaceTempView("ClaimInformation.LineInformation");
//	    Dataset<Row> lineDF = sqlContext.sql("SELECT * FROM LineInformation ");
//	    lineDF.show();
}
}
