package com.icare.dataprocessing.service.analytics.predictive.binaryclassification.logistic_regression;

import java.util.List;

import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.SparkSession;

import com.icare.dataprocessing.repository.RepositoryFactory;
import com.icare.dataprocessing.util.CommonConstants;

public class COPDReadmissionPrediction extends LogisticRegressionBuilder {
	public COPDReadmissionPrediction(SparkSession sparkSession) throws Exception {
		super(sparkSession);
		 System.out.println("COPDReadmissionPrediction Constructor");
	}

	public static void main(String args[]) throws Exception {
		SparkSession sparkSession = SparkSession.builder().master(CommonConstants.SPARK_MASTER)
				 .config("spark.app.name", "COPDReadmissionPrediction")
				 .config("spark.sql.crossJoin.enabled", "true")
				  .getOrCreate();
		new COPDReadmissionPrediction(sparkSession);
	}

	@Override
	public <T, P> T initialize(P config) throws Exception {
		return null;
	}

	@Override
	public <T, P> T loadTrainingData(P config) throws Exception {
		Dataset<Row> testingData  = RepositoryFactory.getInpatientAggregationRepo().load(javaSparkContext,"COPD_READMISSION");
		return (T) testingData;
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

	@Override
	public <T, P> T readModel(P config) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <T, P> T savePrediction(P config) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
}
