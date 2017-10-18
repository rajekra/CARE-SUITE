package com.icare.dataprocessing.service.examples;

import java.util.ArrayList;
import java.util.List;

import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.SparkSession;
import org.graphframes.GraphFrame;

public class CopyOfSparkGraphFrameSample {

	public static void main(String[] args) {

		SparkSession spark = SparkSession.builder()
				.appName("SparkGraphFrameSample")
				.config("spark.sql.warehouse.dir", "/file:C:/temp")
				.master("local[*]").getOrCreate();
		// Create a Vertex DataFrame with unique ID column "id"
		List<MDCTest> uList = new ArrayList<MDCTest>() {
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			{
				add(new MDCTest("1", "3", 10));
				add(new MDCTest("2", "2", 15));
				add(new MDCTest("3", "1", 20));
				add(new MDCTest("4", "1", 25));
				add(new MDCTest("5", "2", 40));
			}
		};

		Dataset<Row> verDF = spark.createDataFrame(uList, MDCTest.class);
		verDF.cache();
		// Create an Edge DataFrame with "src" and "dst" columns
		List<MDCTestClaim> rList = new ArrayList<MDCTestClaim>() {
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			{
				add(new MDCTestClaim("3", "4", 20));
				add(new MDCTestClaim("4", "3", 25));
				add(new MDCTestClaim("2", "5", 15));
				add(new MDCTestClaim("5", "2", 40));
				add(new MDCTestClaim("1", "1", 10));
			}
		};

		Dataset<Row> edgDF = spark.createDataFrame(rList, MDCTestClaim.class);
		
		
		edgDF.cache();
		// Create a GraphFrame
		GraphFrame gFrame = new GraphFrame(verDF, edgDF);
		//gFrame.vertices().show();
		gFrame.cache();
//		gFrame.edges().show();
//		gFrame.inDegrees().show();
//		gFrame.outDegrees().show();
		
		//working fine
		GraphFrame pRank = gFrame.pageRank().resetProbability(0.01).maxIter(1).run();
		System.out.println("RAJK:"+pRank.vertices().count());
		pRank.edges().count();
		pRank.vertices().show();
		
		// Get in-degree of each vertex.
		System.out.println("RAJ Indeg");
		gFrame.inDegrees().show();
		System.out.println("RAJ out");
		gFrame.outDegrees().show();
		// Count the number of "follow" connections in the graph.
		@SuppressWarnings("unused")
		long count = gFrame.edges().filter("relationship = 'follow'").count();
		// Run PageRank algorithm, and show results.
//		
//		
//		PageRank pRank = gFrame.pageRank().resetProbability(0.00).maxIter(1);
//		pRank.run().vertices().select("id", "pagerank").show();

		// stop
		spark.stop();

	}

}
