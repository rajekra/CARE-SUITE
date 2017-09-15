package com.spark.mygraphframe;

import java.util.ArrayList;
import java.util.List;

import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.SparkSession;
import org.apache.spark.storage.StorageLevel;
import org.graphframes.GraphFrame;
import org.graphframes.lib.PageRank;

public class SparkGraphFrameSample {

	public static void main(String[] args) {

		SparkSession spark = SparkSession.builder()
				.appName("SparkGraphFrameSample")
				.config("spark.sql.warehouse.dir", "/file:C:/temp")
				.master("local[*]").getOrCreate();
		// Create a Vertex DataFrame with unique ID column "id"
		List<User> uList = new ArrayList<User>() {
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			{
				add(new User("a", "Alice", 34));
				add(new User("b", "Bob", 36));
				add(new User("c", "Bob", 30));
			}
		};

		Dataset<Row> verDF = spark.createDataFrame(uList, User.class);
		verDF.cache();
		// Create an Edge DataFrame with "src" and "dst" columns
		List<Relation> rList = new ArrayList<Relation>() {
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			{
				add(new Relation("a", "b", "friend"));
				add(new Relation("b", "c", "follow"));
				add(new Relation("c", "b", "follow"));
			}
		};

		Dataset<Row> edgDF = spark.createDataFrame(rList, Relation.class);
		
		
		edgDF.cache();
		// Create a GraphFrame
		GraphFrame gFrame = new GraphFrame(verDF, edgDF);
		//gFrame.vertices().show();
		gFrame.cache();
//		gFrame.edges().show();
//		gFrame.inDegrees().show();
//		gFrame.outDegrees().show();
		
		GraphFrame pRank = gFrame.pageRank().resetProbability(0.0015).tol(0.00001).run();
		pRank.vertices().show();
		
//		// Get in-degree of each vertex.
//		gFrame.inDegrees().show();
//		// Count the number of "follow" connections in the graph.
//		@SuppressWarnings("unused")
//		long count = gFrame.edges().filter("relationship = 'follow'").count();
//		// Run PageRank algorithm, and show results.
//		
//		
//		PageRank pRank = gFrame.pageRank().resetProbability(0.00).maxIter(1);
//		pRank.run().vertices().select("id", "pagerank").show();

		// stop
		spark.stop();

	}

}
