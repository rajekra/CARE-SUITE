package com.icare.ing.service.analytics.predictive;

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
		modelBuilder.loadTrainingData(config);
		modelBuilder.loadTestingData(config);
		modelBuilder.buildPipeline(config);
		modelBuilder.buildModel(config);
	}
	
	public <P> void predict(P config) throws Exception
	{
		modelBuilder.predict(config);
	}
}
