package com.icare.dataprocessing.service.analytics.predictive;

import org.apache.spark.sql.SparkSession;

import com.cloudera.livy.Job;
import com.cloudera.livy.JobContext;
import com.icare.dataprocessing.util.CommonConstants;

public class PredictionExecutor extends AbstractPredictorBuilder implements Job{
	
	public PredictionExecutor(String jobName) {
		this.jobName = jobName;
	}

	public static void main(String[] args) throws Exception
	{
		PredictionExecutor client = new PredictionExecutor("INPATIENT_MDC");
		SparkSession sparkSession = SparkSession.builder().master(CommonConstants.SPARK_MASTER)
				 .config("spark.app.name", "InpatientMdcwisePrediction")
				 .config("spark.sql.crossJoin.enabled", "true")
				  .getOrCreate();
		client.executePrediction(sparkSession);
	}

	@Override
	public Object call(JobContext jc) throws Exception {
		try
		{
			 executePrediction(jc.sparkSession());
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		return "RAJ";
	}
}
