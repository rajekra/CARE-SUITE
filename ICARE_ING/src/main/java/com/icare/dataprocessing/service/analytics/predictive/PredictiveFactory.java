package com.icare.dataprocessing.service.analytics.predictive;

import org.apache.spark.sql.SparkSession;

import com.icare.dataprocessing.service.analytics.AbstractPredictive;
import com.icare.dataprocessing.service.analytics.predictive.binaryclassification.logistic_regression.COPDReadmissionPrediction;
import com.icare.dataprocessing.service.analytics.predictive.regression.linear_regression.CopyOfInpatientMdcwisePrediction;
import com.icare.dataprocessing.service.analytics.predictive.regression.linear_regression.InpatientMdcwisePrediction;

public class PredictiveFactory {
	
	   public static AbstractPredictive getPredictor(String predictorType, SparkSession sparkSession) throws Exception{
		   System.out.println("[getPredictor] STARTS");
	      if(predictorType == null){
	         return null;
	      }		
	      if(predictorType.equalsIgnoreCase("INPATIENT_MDC")){
	    	  System.out.println("[getPredictor] predictorType1:"  +predictorType);
	    	  InpatientMdcwisePrediction inp = null;
	    	  try
	    	  {
	    		  inp = new InpatientMdcwisePrediction(sparkSession);
	    		 // inp = new CopyOfInpatientMdcwisePrediction(sparkSession);
	    		  System.out.println("[getPredictor] after COPDReadmissionPrediction"  +inp);
	    	  }
	    	  catch(Exception ex)
	    	  {
	    		  System.out.println("EX: RAJ" + ex.getMessage());
	    	  }
	         return inp;
	      } 
	      else  if(predictorType.equalsIgnoreCase("COPD_READMISSION")){
	    	  System.out.println("[getPredictor] predictorType1:"  +predictorType);
	    	  COPDReadmissionPrediction inp = null;
	    	  try
	    	  {
	    		  inp = new COPDReadmissionPrediction(sparkSession);
	    		  System.out.println("[getPredictor] after COPDReadmissionPrediction"  +inp);
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
