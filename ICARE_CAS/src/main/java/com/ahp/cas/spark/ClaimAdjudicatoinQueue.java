package com.ahp.cas.spark;

import java.io.File;

import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.function.Function;
import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.RowFactory;
import org.apache.spark.sql.SparkSession;

import com.ahp.cas.domains.claims.ClaimHeader;
import com.ahp.cas.ruleengine.RuleEngine;

public class ClaimAdjudicatoinQueue {

	public static void main(String[] args) {
		 SparkSession spark = SparkSession
			      .builder()
			      .master("local[*]")
			      .appName("Java Spark SQL basic example")
			      .config("spark.some.config.option", "some-value")
			      .getOrCreate();
		 
		 JavaRDD<String> peopleRDD = spark.read()
			      .textFile("file:///C:/DevelopmentStage/OWCP/HCE_DEMO/HCE_DEMO_JSONS/ICARE/")
				// .textFile("file:///C:\\Users\\kandhasamyr\\OneDrive - CNSI\\ICARE\\data\\MONGO_MASTER\\COPD_Final2.csv")
			      .toJavaRDD();
		 
		// peopleRDD.f
		 peopleRDD.foreach(data -> {
		        System.out.println("model="+data);
		        RuleEngine engine = new RuleEngine();
				engine.init();
				ClaimHeader claimHeader = engine.load(data);
				System.out.println("Converted claimHeader:" + claimHeader);
				engine.adjudicate(claimHeader);
		    }); 
		 spark.stop();
	}

}
