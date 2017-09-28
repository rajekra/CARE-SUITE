package com.icare.ing.service.analytics.predictive.regression.linear_regression;

import org.apache.spark.ml.tuning.TrainValidationSplitModel;
import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.SparkSession;

import com.icare.ing.repository.RepositoryFactory;
import com.icare.ing.util.CommonConstants;

public class InpatientMdcwisePrediction extends LinearRegressionBuilder {
	public InpatientMdcwisePrediction() throws Exception {
		super();
	}

	public static void main(String args[]) throws Exception {
		new InpatientMdcwisePrediction();
	}


	@Override
	public <T, P> T initialize(P config) throws Exception {
		sparkSession = SparkSession.builder().master(CommonConstants.SPARK_MASTER)
		 .config("spark.app.name", "InpatientMdcwisePrediction")
		 .config("spark.sql.crossJoin.enabled", "true")
		 .config("spark.mongodb.input.uri",	CommonConstants.MONGO_URI+"icare.INPATIENT_AGGREGATED")
		 .config("spark.mongodb.output.uri", CommonConstants.MONGO_URI+"icare.INPATIENT_AGGREGATED")
		  .getOrCreate();
		return null;
	}

	@Override
	public <T, P> T loadTrainingData(P config) throws Exception {
		return RepositoryFactory.getInpatientAggregationRepo().load(javaSparkContext);
	}

	@Override
	public <T, P> T loadTestingData(P config) throws Exception {
		Dataset<Row> testingData  = RepositoryFactory.getInpatientAggregationRepo().load(javaSparkContext);
		Dataset<Row> extractedTestingData = testingData.drop("id","inDate","ocr1_dt","ocr2_dt","ocr3_dt","ocr4_dt","ocr5_dt",
				"p1_dt","p2_dt","p3_dt","p4_dt","p5_dt","p6_dt","p7_dt","p8_dt","p9_dt","p10_dt",
				"p11_dt","p12_dt","p13_dt","p14_dt","p15_dt","p16_dt","p17_dt","p18_dt","p19_dt","p20_dt",
				"p21_dt","p22_dt","p23_dt","p24_dt");
		return (T) extractedTestingData;
	}

	@Override
	public <T, P> T buildPipeline(P config) throws Exception {
		return null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public <T, P> T buildModel(P trainingData) throws Exception {
//		trainValidationSplitModel = trainValidationSplit.fit((Dataset<Row>) trainingData);
//		return (T) trainValidationSplitModel;
		return null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public <T, P> T predict(P testingData) throws Exception {
//		Dataset<Row> predictedValues = trainValidationSplitModel.transform((Dataset<Row>) testingData).select("features", "label", "prediction");	
//		return (T) predictedValues;
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



}
