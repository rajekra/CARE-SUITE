package com.icare.ing.service.analytics.predictive.models;

import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.ml.evaluation.RegressionEvaluator;
import org.apache.spark.ml.param.ParamMap;
import org.apache.spark.ml.regression.LinearRegression;
import org.apache.spark.ml.tuning.ParamGridBuilder;
import org.apache.spark.ml.tuning.TrainValidationSplit;
import org.apache.spark.sql.SparkSession;

import com.icare.ing.service.analytics.AbstractPredictive;
import com.icare.ing.util.CommonConstants;


/*
 * https://sourcemaking.com/design_patterns/builder/java/2
 */
public abstract class LinearRegressionBuilder implements AbstractPredictive{
	
	protected LinearRegression linearRegression = new LinearRegression();
	
	 // We use a ParamGridBuilder to construct a grid of parameters to search over.
	 // TrainValidationSplit will try all combinations of values and determine best model using
	 // the evaluator.
	 ParamMap[] paramGrid = new ParamGridBuilder()
	   .addGrid(linearRegression.regParam(), new double[] {0.1, 0.01})
	   .addGrid(linearRegression.fitIntercept())
	   .addGrid(linearRegression.elasticNetParam(), new double[] {0.0, 0.5, 1.0})
	   .build();

	 // In this case the estimator is simply the linear regression.
	 // A TrainValidationSplit requires an Estimator, a set of Estimator ParamMaps, and an Evaluator.
	 TrainValidationSplit trainValidationSplit = new TrainValidationSplit()
	   .setEstimator(linearRegression)
	   .setEvaluator(new RegressionEvaluator())
	   .setEstimatorParamMaps(paramGrid)
	   .setTrainRatio(0.8); 
	
	
	/** The spark session. */
	protected SparkSession sparkSession ;
	
	/** The java spark context. */
	protected JavaSparkContext javaSparkContext;

	public LinearRegressionBuilder() throws Exception
	{
		if(null==sparkSession)
		{
			sparkSession = SparkSession.builder().master(CommonConstants.SPARK_MASTER)
					 .config("spark.app.name", "AbstractAnaytics")
					  .getOrCreate();
		}
		javaSparkContext = new JavaSparkContext(sparkSession.sparkContext());
		close();
	}
	public void close()
	{
		if(null!=javaSparkContext)
		{
			javaSparkContext.close();
		}
	}
	
}
