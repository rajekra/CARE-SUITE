package com.icare.ing.service.analytics.predictive;

import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;

import com.icare.ing.service.analytics.AbstractPredictive;

public class ClientWaiter {

	private AbstractPredictive modelBuilder;

	public AbstractPredictive getModelBuilder() {
		return modelBuilder;
	}

	public void setModelBuilder(AbstractPredictive modelBuilder) {
		this.modelBuilder = modelBuilder;
	}
	public <P> void buildModel(P config) throws Exception
	{
		modelBuilder.initialize(config);
		Dataset<Row> trainingData = modelBuilder.loadTrainingData(config);
		System.out.println("====================Training Data====================");
		//trainingData.show();
		modelBuilder.buildPipeline(config);
		modelBuilder.buildModel(trainingData);
	}
	
	public <P> void predict(P config) throws Exception
	{
		Dataset<Row> testingData = modelBuilder.loadTestingData(config);
		System.out.println("====================Testing Data====================");
		testingData.show();
		testingData.printSchema();
		modelBuilder.predict(testingData);
	}
}
