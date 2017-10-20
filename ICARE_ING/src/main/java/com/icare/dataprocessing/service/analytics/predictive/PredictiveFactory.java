package com.icare.dataprocessing.service.analytics.predictive;

import com.icare.dataprocessing.service.analytics.AbstractPredictive;
import com.icare.dataprocessing.service.analytics.predictive.regression.linear_regression.InpatientMdcwisePrediction;

public class PredictiveFactory {
	
	   public static AbstractPredictive getPredictor(String predictorType) throws Exception{
	      if(predictorType == null){
	         return null;
	      }		
	      if(predictorType.equalsIgnoreCase("INPATIENT_MDC")){
	         return new InpatientMdcwisePrediction();
	      } 
	      
	      return null;
	   }
}
