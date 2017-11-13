package com.icare.dataprocessing.service.examples.graph;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.SparkSession;
import org.apache.spark.storage.StorageLevel;
import org.graphframes.GraphFrame;
import org.graphframes.lib.BFS;
import org.graphframes.lib.ConnectedComponents;
import org.graphframes.lib.PageRank;

//https://www.infoq.com/articles/apache-spark-graphx
//https://docs.databricks.com/spark/latest/graph-analysis/graphframes/graph-analysis-tutorial.html
public class SparkGraphFrameSampleV2 {

	public static void main(String[] args) {

		SparkSession spark = SparkSession.builder()
				.appName("SparkGraphFrameSample")
				.config("spark.sql.warehouse.dir", "/file:C:/temp")
				.master("local[*]").getOrCreate();
		// Create a Vertex DataFrame with unique ID column "id"
//		List<User> uList = new ArrayList<User>() {
//			/**
//			 * 
//			 */
//			private static final long serialVersionUID = 1L;
//
//			{
//				add(new User("a", "Alice", 34));
//				add(new User("b", "Bob", 36));
//				add(new User("c", "Raj", 30));
//			}
//		};
		
		List<Entity> memberVerticeList = new ArrayList<Entity>() {
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			{
				add(new Member(new BigDecimal(11),  "Alice"));
				add(new Member(new BigDecimal(12),"Bob"));
				add(new Member(new BigDecimal(13),"Raj"));
				add(new Member(new BigDecimal(14),"tob"));
				add(new Member(new BigDecimal(15),"taj"));
				add(new Provider(new BigDecimal(1000),  "Adventist"));
				add(new Provider(new BigDecimal(2000), "HolyCross"));
			}
		};
		Dataset<Row> memberProviderEdges = spark.createDataFrame(memberVerticeList, Entity.class);
		memberProviderEdges.printSchema();
		//verDF = verDF.withColumnRenamed("providerId", "id");
		// Create an Edge DataFrame with "src" and "dst" columns
		List<Claim> claimList = new ArrayList<Claim>() {
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			{
				add(new Claim(new BigDecimal(11), new BigDecimal(1000), new BigDecimal(3500)));
				add(new Claim(new BigDecimal(12), new BigDecimal(2000), new BigDecimal(4500)));
				add(new Claim(new BigDecimal(13), new BigDecimal(2000), new BigDecimal(5500)));
				add(new Claim(new BigDecimal(11), new BigDecimal(2000), new BigDecimal(6500)));
				add(new Claim(new BigDecimal(12), new BigDecimal(1000), new BigDecimal(7500)));
				add(new Claim(new BigDecimal(13), new BigDecimal(2000), new BigDecimal(8500)));
				add(new Claim(new BigDecimal(14), new BigDecimal(1000), new BigDecimal(9500)));
				add(new Claim(new BigDecimal(15), new BigDecimal(2000), new BigDecimal(10500)));
			}
		};
		Dataset<Row> claimEdges = spark.createDataFrame(claimList, Claim.class);
		claimEdges = claimEdges.withColumnRenamed("memberId", "src").withColumnRenamed("providerId", "dst");
		
		claimEdges.cache();
		// Create a GraphFrame
		GraphFrame gFrame = new GraphFrame(memberProviderEdges, claimEdges);
		gFrame.vertices().show();
		//gFrame.cache();
		gFrame.edges().show();
		gFrame.inDegrees().show();
		gFrame.outDegrees().show();
//		
//		//working fine
//		GraphFrame pRank = gFrame.pageRank().resetProbability(0.01).maxIter(1).run();
//		pRank.vertices().show();
//		
//		// Get in-degree of each vertex.
//		gFrame.inDegrees().show();
//		// Count the number of "follow" connections in the graph.
//		@SuppressWarnings("unused")
//		long count = gFrame.edges().filter("relationship = 'follow'").count();
//		// Run PageRank algorithm, and show results.
////		
////		
		GraphFrame pRank = gFrame.pageRank().resetProbability(0.15).maxIter(1).run();
		//pRank.vertices().select("id", "pagerank").show();
		pRank.vertices().orderBy("pagerank").show();
		pRank.edges().show();
//
//		// stop
		
//		System.out.println("Total Number of Entities: " + gFrame.vertices().count());
//		System.out.println("Total Number of Claims in Graph: " + gFrame.edges().count());
//		System.out.println("Total Number of Claims in Original Data: " + claimEdges.count());// sanity check
		
		Dataset<Row> topTrips = gFrame
				  .edges()
				  .groupBy("src", "dst")
				  .count()
				  .orderBy("count")
				  .limit(10);
		topTrips.show();
		
		
		Dataset<Row> inDeg = gFrame.inDegrees();
		inDeg.orderBy("inDegree").show();
				
		Dataset<Row> outDeg = gFrame.outDegrees();
		outDeg.orderBy("outDegree").show();
				
//		BFS bfs = gFrame.bfs();
//		bfs.toExpr("totalBilledAmount >5500").run().show();
		spark.stop();

	}

}
