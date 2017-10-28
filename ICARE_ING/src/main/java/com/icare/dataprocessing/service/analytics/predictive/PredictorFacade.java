package com.icare.dataprocessing.service.analytics.predictive;

import com.cloudera.livy.Job;
import com.cloudera.livy.JobContext;
import com.icare.dataprocessing.service.analytics.AbstractPredictive;
import com.icare.dataprocessing.util.CommonConstants;

public class PredictorFacade extends AbstractPredictorBuilder implements Job{
	public static void main(String[] args) throws Exception
	{
		PredictorFacade client = new PredictorFacade();
		client.executePrediction(args);
	}
	
	public void executePrediction(String[] args) throws Exception
	{
		System.out.println("[executePrediction]: STARTS" );
		if(null==args || args.length<1)
		{
			System.out.println("Argument should not be empty!");
			return;
		}
		String predictorType  = args[0];
		AbstractPredictive predictor = PredictiveFactory.getPredictor(predictorType);
		System.out.println("[executePrediction]:" + predictor);
		System.out.println("[executePrediction]: setModelBuilder before");
		setModelBuilder(predictor);
		System.out.println("[executePrediction]: setModelBuilder after");
		System.out.println("[executePrediction]: buildModel before");
		buildModel(null);
		System.out.println("[executePrediction]: buildModel after");
		//predict(null);
	}

	@Override
	public Object call(JobContext jc) throws Exception {
		System.out.println("RAJASEKARAN");
		System.err.println("RAJASEKARAN");
		//jc.sc().getConf().set("spark.mongodb.input.uri",	CommonConstants.MONGO_URI+"icare.INPATIENT_AGGREGATED");
		//jc.sc().getConf().set("spark.mongodb.input.uri",	CommonConstants.MONGO_URI+"icare.INPATIENT_AGGREGATED");
		try
		{
			 String[] STRING_ARRAY = {"INPATIENT_MDC"};		
			 executePrediction(STRING_ARRAY);
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		return "RAJ";
	}
}
