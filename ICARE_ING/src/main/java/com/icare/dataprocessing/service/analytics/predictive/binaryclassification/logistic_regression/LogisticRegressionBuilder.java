package com.icare.dataprocessing.service.analytics.predictive.binaryclassification.logistic_regression;

import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.ml.classification.LogisticRegression;
import org.apache.spark.ml.evaluation.BinaryClassificationEvaluator;
import org.apache.spark.ml.evaluation.RegressionEvaluator;
import org.apache.spark.ml.param.ParamMap;
import org.apache.spark.ml.regression.LinearRegression;
import org.apache.spark.ml.tuning.CrossValidator;
import org.apache.spark.ml.tuning.CrossValidatorModel;
import org.apache.spark.ml.tuning.ParamGridBuilder;
import org.apache.spark.ml.tuning.TrainValidationSplit;
import org.apache.spark.ml.tuning.TrainValidationSplitModel;
import org.apache.spark.sql.SparkSession;

import com.icare.dataprocessing.service.analytics.AbstractPredictive;
import com.icare.dataprocessing.util.CommonConstants;


/*
 * https://sourcemaking.com/design_patterns/builder/java/2
 */
public abstract class LogisticRegressionBuilder implements AbstractPredictive{
	
	protected LogisticRegression logisticRegression = new LogisticRegression();
	
	 // We use a ParamGridBuilder to construct a grid of parameters to search over.
	 // TrainValidationSplit will try all combinations of values and determine best model using
	 // the evaluator.
	protected ParamMap[] paramGrid = null;
	protected ParamGridBuilder paramBuilder = new ParamGridBuilder()
	//.addGrid(hashingTF.numFeatures(), new int[] { 10, 100, 1000 })
	.addGrid(logisticRegression.regParam(), new double[] { 0.1, 0.01 });

	 // In this case the estimator is simply the linear regression.
	 // A TrainValidationSplit requires an Estimator, a set of Estimator ParamMaps, and an Evaluator.
	protected CrossValidator trainValidationSplit = new CrossValidator()
		//	.setEstimator(pipeline)
			.setEvaluator(new BinaryClassificationEvaluator())
			.setEstimatorParamMaps(paramGrid).setNumFolds(2); 
	 
	protected CrossValidatorModel trainValidationSplitModel = null;
	
	
	/** The spark session. */
	protected SparkSession sparkSession ;
	
	/** The java spark context. */
	protected JavaSparkContext javaSparkContext;

	public LogisticRegressionBuilder(SparkSession sparkSession2) {
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
