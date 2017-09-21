package com.icare.ing.service_examples;


import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.RuntimeConfig;
import org.apache.spark.sql.SparkSession;
import org.apache.spark.storage.StorageLevel;
import org.bson.Document;

import com.ecams.claim.bo.ClaimHeader;
import com.icare.common.dto.CH;
import com.mongodb.spark.MongoSpark;
import com.mongodb.spark.config.ReadConfig;
import com.mongodb.spark.rdd.api.java.JavaMongoRDD;


public final class ClassStudentSpark {

  public static void main(final String[] args) throws InterruptedException {
	  
//	  SparkConf conf = new SparkConf()
//      .setMaster("local[3]")
//    //  .set("spark.executor.instances", "2")
//      .set("spark.executor.memory", "2g")
//      .setAppName("VerySimpleStreamingApp");
//	  JavaSparkContext jsc = new JavaSparkContext(conf);
//	  
//	  SparkSession spark = SparkSession
//      .builder()
//      .sparkContext(jsc.sc())
//      .appName("Java Spark SQL basic example")
//      .config("spark.mongodb.input.uri", "mongodb://127.0.0.1/icare.t1")
//      .config("spark.mongodb.output.uri", "mongodb://127.0.0.1/icare.t1")
//      .getOrCreate();

    SparkSession spark = SparkSession.builder()
      .master("local")
      .appName("MongoSparkConnectorIntro")
      .config("spark.executor.heartbeatInterval", "20s")
      .config("spark.driver.extraJavaOptions", "-Xss600m")
      .config("spark.sql.crossJoin.enabled", "true")
     // .config("spark.executor.instances", "2")
      .config("spark.mongodb.input.uri", "mongodb://127.0.0.1/icare.class")
      .config("spark.mongodb.output.uri", "mongodb://127.0.0.1/icare.class")
      .getOrCreate();
 //  ss.set("spark.driver.extraJavaOptions", "-Xss1G");
    // Create a JavaSparkContext using the SparkSession's SparkContext object
   
    
    JavaSparkContext jsc = new JavaSparkContext(spark.sparkContext());
    
//    // Load data and infejscr schema, disregard toDF() name as it returns Dataset
//    Dataset<Row> implicitDS = MongoSpark.load(jsc).toDF();
//    implicitDS.printSchema();
//    implicitDS.show();

    // Load data with explicit schema
    System.out.println("1");
    
    JavaMongoRDD<Document> dd = MongoSpark.load(jsc);
    dd.persist(StorageLevel.MEMORY_AND_DISK());
    System.out.println("2");
    Dataset<com.icare.common.dto.Class> explicitDS = dd.toDS(com.icare.common.dto.Class.class);
    
    explicitDS.printSchema();
    //explicitDS.show();
    
    Dataset<Row> sts =explicitDS.select("students.name","students.grade");
    sts.show();
    
    explicitDS.createOrReplaceTempView("class");
    sts.createOrReplaceTempView("student");
    
    Dataset<Row> centenarians = spark.sql("select distinct c.name,s.name,s.grade from class c ,student s");
    centenarians.show();
    
    // Create the temp view and execute the query
  //  explicitDS.createOrReplaceTempView("characters");
  //  Dataset<Row> centenarians = spark.sql("SELECT * FROM characters ch");
   // centenarians.show();
    
   // Dataset<Row> centenarians2 = explicitDS.select("lines.ln_amt","lines.ln_from_dt");

    // Write the data to the "hundredClub" collection
  //  MongoSpark.write(centenarians2).option("collection", "test").mode("overwrite").save();

//    // Load the data from the "hundredClub" collection
//    MongoSpark.load(spark, ReadConfig.create(spark).withOption("collection", "hundredClub"), Character.class).show();

    jsc.close();

  }
}