package com.icare.dataprocessing.service.analytics.predictive.binaryclassification.logistic_regression;

import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.ml.Pipeline;
import org.apache.spark.ml.PipelineModel;
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
	
	protected LogisticRegression logisticRegression = new LogisticRegression().setMaxIter(1).setRegParam(0.01).setLabelCol("label").setFeaturesCol("features").setElasticNetParam(0.8);
	
	 // We use a ParamGridBuilder to construct a grid of parameters to search over.
	 // TrainValidationSplit will try all combinations of values and determine best model using
	 // the evaluator.
	protected ParamMap[] paramGrid = null;
	protected ParamGridBuilder paramBuilder = new ParamGridBuilder()
	 .addGrid(logisticRegression.regParam(),  new double[] {0.01, 0.4, 0.8})
     .addGrid(logisticRegression.elasticNetParam(), new double[] {0.0, 0.2, 0.3})
     .addGrid(logisticRegression.maxIter(), new int[] {1, 3, 5});

	 // In this case the estimator is simply the linear regression.
	 // A TrainValidationSplit requires an Estimator, a set of Estimator ParamMaps, and an Evaluator.
	protected CrossValidator trainValidationSplit = new CrossValidator()
		//	.setEstimator(pipeline)
			.setEvaluator(new BinaryClassificationEvaluator())
			.setEstimatorParamMaps(paramGrid).setNumFolds(2); 
	 
	protected CrossValidatorModel trainValidationSplitModel = null;
	
	protected Pipeline pipeLine ;
	protected PipelineModel pipelineModel;
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
