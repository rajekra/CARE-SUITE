package com.icare.dataprocessing.service.analytics.predictive;

import java.util.List;

import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.SparkSession;

import com.icare.dataprocessing.service.analytics.AbstractPredictive;

/**
 * The Class AbstractPredictorBuilder.
 */
public abstract class AbstractPredictorBuilder {

	/** The model builder. */
	private AbstractPredictive modelBuilder;
	
	/** The prediction job name. */
	protected String predictionJobName;

	/**
	 * Gets the model builder.
	 *
	 * @return the model builder
	 */
	public AbstractPredictive getModelBuilder() {
		return modelBuilder;
	}

	/**
	 * Sets the model builder.
	 *
	 * @param modelBuilder the new model builder
	 */
	public void setModelBuilder(AbstractPredictive modelBuilder) {
		this.modelBuilder = modelBuilder;
	}
	
	/**
	 * Builds the model.
	 *
	 * @param <P> the generic type
	 * @param config the config
	 * @throws Exception the exception
	 */
	public <P> void predict(P config) throws Exception
	{
		System.out.println("[buildModel]: STARTS");
		if(null!=modelBuilder)
		{
			System.out.println("++++++++++++++++++++STEP 1: Initialize prediction++++++++++++++++++++");
			modelBuilder.initialize(config);
			System.out.println("++++++++++++++++++++STEP 2: Load the dataset+++++++++++++++++++++");
			Dataset<Row> completeData = modelBuilder.loadTrainingData(config);
			Dataset<Row>[] splitData = completeData.randomSplit(new double[]{0.7, 0.3});
			Dataset<Row> trainData = splitData[0];
			Dataset<Row> testData = splitData[1];
			System.out.println("++++++++++++++++++++Step 3: Build the pipeline+++++++++++++++++++++");
			trainData = modelBuilder.buildPipeline(trainData);
			System.out.println("++++++++++++++++++++Step 4: Build the model with train data+++++++++++++++++++++");
			modelBuilder.buildModel(trainData);
			System.out.println("++++++++++++++++++++Step 5: Predict the model test data+++++++++++++++++++++");
			Dataset<Row> predictedData = modelBuilder.predict(testData);
			predictedData.printSchema();
			predictedData.show();
			System.out.println("++++++++++++++++++++Step 6: Save the predicted data+++++++++++++++++++++");
			modelBuilder.savePrediction(predictedData);
		}
		System.out.println("[buildModel]: ENDS");
	}
	
	/**
	 * Execute prediction.
	 *
	 * @param sparkSession the spark session
	 * @throws Exception the exception
	 */
	public void executePrediction(SparkSession sparkSession) throws Exception
	{
		AbstractPredictive predictor = PredictiveFactory.getPredictor(predictionJobName,sparkSession);
		System.out.println("[executePrediction]:" + predictor);
		System.out.println("[executePrediction]: setModelBuilder before");
		setModelBuilder(predictor);
		System.out.println("[executePrediction]: setModelBuilder after");
		System.out.println("[executePrediction]: buildModel before");
		predict(null);
		System.out.println("[executePrediction]: buildModel after");
	//	predict(null);
	}
}
