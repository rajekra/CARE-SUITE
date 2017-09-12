package com.icare.ing.service;

import java.util.Arrays;

import org.apache.log4j.*;
import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.api.java.function.FlatMapFunction;
import org.apache.spark.api.java.function.VoidFunction;
import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Encoders;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.SparkSession;
import org.apache.spark.sql.streaming.StreamingQuery;
import org.apache.spark.sql.streaming.StreamingQueryException;
import org.apache.spark.streaming.Durations;
import org.apache.spark.streaming.api.java.*;

import com.ecams.claim.bo.ClaimHeader;

public class VerySimpleStreamingApp {
    private static final String HOST = "localhost";
    private static final int PORT = 9999;

    public static void main(String[] args) throws InterruptedException, StreamingQueryException {
        // Configure and initialize the SparkStreamingContext
        SparkConf conf = new SparkConf()
                .setMaster("local")
                .setAppName("VerySimpleStreamingApp");
        JavaStreamingContext streamingContext =
                new JavaStreamingContext(conf, Durations.seconds(10));
        Logger.getRootLogger().setLevel(Level.OFF);
        // Receive streaming data from the source
     //   JavaReceiverInputDStream<String> lines = streamingContext.socketTextStream(HOST, PORT);
        
        
        JavaReceiverInputDStream<String> lines = streamingContext.socketTextStream(HOST, PORT);
        
        
//        lines.foreachRDD(new VoidFunction<JavaRDD<String>>() {
//            @Override
//            public void call(JavaRDD<String> rdd) throws Exception {
//            	rdd.toDebugString();
//                rdd.foreach(new VoidFunction<String>() {
//                    @Override
//                    public void call(String s) throws Exception {
//                        System.out.println(s);
//                    }
//                });
//            }
//        });
        
        
//        lines.foreachRDD((rdd, time) -> {
//        	rdd.toDebugString();
//    	      // Convert JavaRDD[String] to JavaRDD[bean class] to DataFrame
//    	      JavaRDD<ClaimHeader> rowRDD = rdd.map(word -> {
//    	    	  System.out.println("WORD:"+ word);
//    	    	 // ClaimHeader record = new ClaimHeader();
//    	    	 // ClaimHeader record =   objectMapper().readValue(word, ClaimHeader.class);
//    	        return null;
//    	      });
//        });
    	      
        
        System.out.println("MMM");
        // Execute the Spark workflow defined above
        streamingContext.start();
        streamingContext.awaitTermination();
        System.out.println("TERMI");
    	
      
        
    	// APPROCHH 2
//    	SparkConf sparkConf = new SparkConf()
//        .setAppName("VerySimpleStreamingApp")
//        .setMaster("local[*]");
//    	
//    	JavaSparkContext sparkcontext = new JavaSparkContext(sparkConf);
//    	
//    	SparkSession spark = SparkSession
//    			  .builder()
//    			  .sparkContext(sparkcontext.sc())
//    			  .appName("JavaStructuredNetworkWordCount")
//    			  .getOrCreate();
//    	
//    	spark.readStream().s
//    	
//    	Dataset<Row> lines = spark
//    			  .readStream()
//    			  .format("socket")
//    			  .option("host", "localhost")
//    			  .option("port", 9999)
//    			  .load();
//    	
//    	//lines.show();
//    	
//    	// Split the lines into words
//    	Dataset<String> words = lines
//    	  .as(Encoders.STRING())
//    	  .flatMap((FlatMapFunction<String, String>) x -> Arrays.asList(x.split(" ")).iterator(), Encoders.STRING());
//
//    	// Generate running word count
//    	Dataset<Row> wordCounts = words.groupBy("value").count();
//    	
//    	// Start running the query that prints the running counts to the console
//    	StreamingQuery query = wordCounts.writeStream()
//    	  .outputMode("complete")
//    	  .format("console")
//    	  .start();
//
//    	query.awaitTermination();
    	
    }
}
