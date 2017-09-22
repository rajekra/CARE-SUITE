package com.icare.ing.repository.impl;

import org.apache.spark.sql.Dataset;

import com.icare.ing.repository.intf.InpatientAggregationRepoIntf;
import com.mongodb.spark.MongoSpark;

public class InpatientAggregationRepoImpl implements InpatientAggregationRepoIntf{

	@Override
	public <T> void save(T dataSet) {
		MongoSpark.write((Dataset<T>) dataSet).option("collection","INSTITUTIONAL_AGGR").mode("overwrite").save();
	}

}
