package com.icare.dataprocessing.service.analytics.predictive;

import com.icare.dataprocessing.service.analytics.AbstractPredictive;
import com.icare.dataprocessing.service.analytics.predictive.regression.linear_regression.InpatientMdcwisePrediction;

public class PredictiveFactory {
	
	   public static AbstractPredictive getPredictor(String predictorType) throws Exception{
		   System.out.println("[getPredictor] STARTS");
	      if(predictorType == null){
	         return null;
	      }		
	      if(predictorType.equalsIgnoreCase("INPATIENT_MDC")){
	    	  System.out.println("[getPredictor] predictorType1:"  +predictorType);
	    	  InpatientMdcwisePrediction inp = null;
	    	  try
	    	  {
	    		  inp = new InpatientMdcwisePrediction();
	    		  System.out.println("[getPredictor] after InpatientMdcwisePrediction"  +inp);
	    	  }
	    	  catch(Exception ex)
	    	  {
	    		  System.out.println("EX: RAJ" + ex.getMessage());
	    	  }
	         return inp;
	      } 
	      
	      return null;
	   }
}
