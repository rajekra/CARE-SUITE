package com.icare.ing.service_examples;

import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.graphx.EdgeRDD;
import org.apache.spark.graphx.Graph;
import org.apache.spark.graphx.GraphLoader;
import org.apache.spark.graphx.VertexRDD;
import org.apache.spark.graphx.lib.PageRank;
import org.apache.spark.sql.SparkSession;
import org.apache.spark.storage.StorageLevel;

public class JavaGraphXPageRank {

	public static void mian(String[] args)
	{
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
			    
			    scala.collection.Seq s;
			    
			    //(graph, 0.1, 0.5, Double.class, Double.class);
			    //PageRank.runUntilConvergence(arg0, arg1, arg2, arg3, arg4)
	}
}
