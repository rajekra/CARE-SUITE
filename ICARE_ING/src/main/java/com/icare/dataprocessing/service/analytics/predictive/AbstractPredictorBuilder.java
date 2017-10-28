package com.icare.dataprocessing.service.analytics.predictive;

import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;

import com.icare.dataprocessing.service.analytics.AbstractPredictive;

public abstract class AbstractPredictorBuilder {

	private AbstractPredictive modelBuilder;

	public AbstractPredictive getModelBuilder() {
		return modelBuilder;
	}

	public void setModelBuilder(AbstractPredictive modelBuilder) {
		this.modelBuilder = modelBuilder;
	}
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
	
	public <P> void predict(P config) throws Exception
	{
		if(null!=modelBuilder)
		{
			Dataset<Row> testingData = modelBuilder.loadTestingData(config);
			System.out.println("====================Testing Data====================");
			testingData.show();
			testingData.printSchema();
			modelBuilder.predict(testingData);
		}
	}
}
