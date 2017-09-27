package com.icare.ing.service.analytics.predictive.regression.linear_regression;

import org.apache.spark.sql.SparkSession;

import com.icare.ing.repository.RepositoryFactory;
import com.icare.ing.service.analytics.AbstractPredictiveAnalytics;
import com.icare.ing.util.CommonConstants;

public class InpatientMdcwisePrediction extends AbstractPredictiveAnalytics {
	public InpatientMdcwisePrediction() throws Exception {
		super();
	}

	public static void main(String args[]) throws Exception {
		new InpatientMdcwisePrediction();
	}

	@Override
	public void init() {
		sparkSession = SparkSession.builder().master(CommonConstants.SPARK_MASTER)
				 .config("spark.app.name", "InpatientMdcwisePrediction")
				 .config("spark.sql.crossJoin.enabled", "true")
				 .config("spark.mongodb.input.uri",	CommonConstants.MONGO_URI+"icare.INPATIENT_AGGREGATED")
				 .config("spark.mongodb.output.uri", CommonConstants.MONGO_URI+"icare.INPATIENT_AGGREGATED")
				  .getOrCreate();
	}

	@Override
	public <T, P> T load(P config) throws Exception {
		return RepositoryFactory.getInpatientAggregationRepo().load(javaSparkContext);
	}

	@Override
	public <T, P> T loadTrainingData(P config) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <T, P> T loadTestingData(P config) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <T, P> T buildPipeline(P config) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <T, P> T buildModel(P config) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <T, P> T predict(P config) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <T, P> T saveModel(P config) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}


}
