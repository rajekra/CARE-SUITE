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
	public <P> void buildModel(P config) throws Exception
	{
		System.out.println("[buildModel]: STARTS");
		if(null!=modelBuilder)
		{
			modelBuilder.initialize(config);
			Dataset<Row> trainingData = modelBuilder.loadTrainingData(config);
			System.out.println("====================Training Data====================");
			//trainingData.show();
			modelBuilder.buildPipeline(config);
			modelBuilder.buildModel(trainingData);
		}
		System.out.println("[buildModel]: ENDS");
	}
	
	/**
	 * Predict.
	 *
	 * @param <P> the generic type
	 * @param config the config
	 * @throws Exception the exception
	 */
	public <P> void predict(P config) throws Exception
	{
		if(null!=modelBuilder)
		{
			Dataset<Row> testingData = modelBuilder.loadTestingData(config);
			System.out.println("====================Testing Data====================");
			testingData.show();
			testingData.printSchema();
			Dataset<Row> predictedData = modelBuilder.predict(testingData);
			System.out.println("**************************** Predicted Data - Starts ***********************************");
			predictedData.printSchema();
			//predictedData.show();
			List<Row> rows = predictedData.takeAsList(1000);
			
			for(Row row:rows)
			{
				System.out.println("row:" +row);
			}
			System.out.println("**************************** Predicted Data - Ends ***********************************");
		}
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
		buildModel(null);
		System.out.println("[executePrediction]: buildModel after");
		predict(null);
	}
}
