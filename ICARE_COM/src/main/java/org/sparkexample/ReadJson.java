package org.sparkexample;

import java.util.List;

import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.SQLContext;
import org.apache.spark.sql.SparkSession;

import scala.Tuple2;

public class ReadJson {
public static void main(String[] aregs)
{

	 String master = "local[*]";

	    /*
	     * Initialises a Spark context.
	     */
	    SparkConf conf = new SparkConf()
	        .setAppName(WordCountTask.class.getName())
	        .setMaster(master);
	    JavaSparkContext context = new JavaSparkContext(conf);
	    SQLContext sqlContext = new SQLContext(context);
	    Dataset<Row> claimDataSet =  sqlContext.read().json("C:/EDPS/CATEGORY_1/17864_category.json");
	    
	    claimDataSet.createOrReplaceTempView("ClaimInformation");
	    claimDataSet.printSchema();
	    
	    
	    Dataset<Row> sqlDF = sqlContext.sql("SELECT * FROM ClaimInformation ");
	    sqlDF.show();
	    sqlDF.createOrReplaceTempView("ClaimInformation.LineInformation");
	    
	    Dataset<Row> lineDF = sqlContext.sql("SELECT * FROM LineInformation ");
	    lineDF.show();
}
}
