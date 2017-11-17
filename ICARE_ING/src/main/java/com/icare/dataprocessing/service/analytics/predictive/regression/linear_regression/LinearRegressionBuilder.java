package com.icare.dataprocessing.service.analytics.predictive.regression.linear_regression;

import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.ml.evaluation.RegressionEvaluator;
import org.apache.spark.ml.param.ParamMap;
import org.apache.spark.ml.regression.LinearRegression;
import org.apache.spark.ml.tuning.ParamGridBuilder;
import org.apache.spark.ml.tuning.TrainValidationSplit;
import org.apache.spark.ml.tuning.TrainValidationSplitModel;
import org.apache.spark.sql.SparkSession;

import com.icare.dataprocessing.service.analytics.AbstractPredictive;
import com.icare.dataprocessing.util.CommonConstants;


/*
 * https://sourcemaking.com/design_patterns/builder/java/2
 */
public abstract class LinearRegressionBuilder implements AbstractPredictive{
	
	protected LinearRegression linearRegression = new LinearRegression();
	
	 // We use a ParamGridBuilder to construct a grid of parameters to search over.
	 // TrainValidationSplit will try all combinations of values and determine best model using
	 // the evaluator.
	protected ParamMap[] paramGrid = new ParamGridBuilder()
	   .addGrid(linearRegression.regParam(), new double[] {0.1, 0.01})
	   .addGrid(linearRegression.fitIntercept())
	   .addGrid(linearRegression.elasticNetParam(), new double[] {0.0, 0.25, 0.5, 0.75, 1.0})
	   .build();

	 // In this case the estimator is simply the linear regression.
	 // A TrainValidationSplit requires an Estimator, a set of Estimator ParamMaps, and an Evaluator.
	protected TrainValidationSplit trainValidationSplit = new TrainValidationSplit()
	   // Replace below with pipeline
	   //.setEstimator(linearRegression)
	   .setEvaluator(new RegressionEvaluator())
	   .setEstimatorParamMaps(paramGrid)
	   .setTrainRatio(0.75); 
	 
	protected TrainValidationSplitModel trainValidationSplitModel = null;
	
	
	/** The spark session. */
	protected SparkSession sparkSession ;
	
	/** The java spark context. */
	protected JavaSparkContext javaSparkContext;

	public LinearRegressionBuilder(SparkSession sparkSession2) {
		this.sparkSession = sparkSession2;
		javaSparkContext = new JavaSparkContext(sparkSession.sparkContext());
		}
	public void close()
	{
		if(null!=javaSparkContext)
		{
			javaSparkContext.close();
		}
	}
	
}
