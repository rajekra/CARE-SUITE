package com.icare.ing.repository.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;

import com.icare.common.dto.CH;
import com.icare.common.dto.CL;
import com.icare.ing.repository.intf.InpatientAggregationRepoIntf;
import com.icare.ing.util.CommonConstants;
import com.icare.ing.util.JsonUtil;
import com.mongodb.BasicDBObject;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.spark.MongoSpark;

public class InpatientAggregationRepoImpl implements InpatientAggregationRepoIntf{

	@Override
	public <T> void save(T dataSet) {
		MongoSpark.write((Dataset<T>) dataSet).option("collection",CommonConstants.INPATIENT_AGGREGATED_STR).mode("overwrite").save();
	}

	@Override
	public <T,C> T load(C context) {
		Dataset<Row> implicitDS = MongoSpark.load((JavaSparkContext) context).toDF();
		return (T) implicitDS;
	}

}
