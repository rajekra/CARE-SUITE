package com.icare.dataprocessing.service.analytics.predictive;

import com.icare.dataprocessing.service.analytics.AbstractPredictive;

public class PredictorFacade extends AbstractPredictorBuilder{
	public static void main(String[] args) throws Exception
	{
		PredictorFacade client = new PredictorFacade();
		client.executePrediction(args);
	}
	
	public void executePrediction(String[] args) throws Exception
	{
		if(null==args || args.length<1)
		{
			System.out.println("Argument should not be empty!");
			return;
		}
		String predictorType  = args[0];
		AbstractPredictive predictor = PredictiveFactory.getPredictor(predictorType);
		setModelBuilder(predictor);
		buildModel(null);
		predict(null);
	}
}
