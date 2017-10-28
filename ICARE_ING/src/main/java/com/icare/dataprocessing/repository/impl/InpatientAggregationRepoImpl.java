package com.icare.dataprocessing.repository.impl;

import java.util.HashMap;
import java.util.Map;

import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;

import com.icare.dataprocessing.repository.intf.InpatientAggregationRepoIntf;
import com.mongodb.spark.MongoSpark;
import com.mongodb.spark.config.ReadConfig;

public class InpatientAggregationRepoImpl implements InpatientAggregationRepoIntf{

	@SuppressWarnings("unchecked")
	@Override
	public <T> void save(T dataSet,String tableName) {
		//MongoSpark.write((Dataset<T>) dataSet).option("collection",CommonConstants.INPATIENT_AGGREGATED_STR).mode("overwrite").save();
		MongoSpark.write((Dataset<T>) dataSet).option("collection",tableName).mode("overwrite").save();
	}

	@SuppressWarnings("unchecked")
	@Override
	public <T,C> T load(C context,String tableName) {
		System.out.println("InpatientAggregationRepoImpl [load] STARTS");
		Map<String, String> readOverrides = new HashMap<String, String>();
	    //readOverrides.put("uri", "mongodb://10.0.0.247:27017/icare.INPATIENT_AGGREGATED");
	    readOverrides.put("uri", "mongodb://10.0.0.247:27017/icare."+tableName);
	    ReadConfig readConfig = ReadConfig.create(readOverrides);
		Dataset<Row> implicitDS = MongoSpark.load((JavaSparkContext) context, readConfig).toDF();
		System.out.println("InpatientAggregationRepoImpl [load] ENDS");
		return (T) implicitDS;
	}

}
