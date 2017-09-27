package com.icare.ing.repository.impl;

import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;

import com.icare.ing.repository.intf.InpatientAggregationRepoIntf;
import com.icare.ing.util.CommonConstants;
import com.mongodb.spark.MongoSpark;

public class InpatientAggregationRepoImpl implements InpatientAggregationRepoIntf{

	@SuppressWarnings("unchecked")
	@Override
	public <T> void save(T dataSet) {
		MongoSpark.write((Dataset<T>) dataSet).option("collection",CommonConstants.INPATIENT_AGGREGATED_STR).mode("overwrite").save();
	}

	@SuppressWarnings("unchecked")
	@Override
	public <T,C> T load(C context) {
		Dataset<Row> implicitDS = MongoSpark.load((JavaSparkContext) context).toDF();
		return (T) implicitDS;
	}

}
