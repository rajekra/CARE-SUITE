package com.icare.dataprocessing.service.analytics.predictive.examples;


//$example on$
import org.apache.spark.ml.evaluation.RegressionEvaluator;
import org.apache.spark.ml.param.ParamMap;
import org.apache.spark.ml.regression.LinearRegression;
import org.apache.spark.ml.tuning.ParamGridBuilder;
import org.apache.spark.ml.tuning.TrainValidationSplit;
import org.apache.spark.ml.tuning.TrainValidationSplitModel;
import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;
//$example off$
import org.apache.spark.sql.SparkSession;

/**
* Java example demonstrating model selection using TrainValidationSplit.
* OUTPUT
+--------------------+--------------------+--------------------+
|            features|               label|          prediction|
+--------------------+--------------------+--------------------+
|(10,[0,1,2,3,4,5,...|  -23.51088409032297| -1.6659388625179559|
|(10,[0,1,2,3,4,5,...| -21.432387764165806|  0.3400877302576284|
|(10,[0,1,2,3,4,5,...| -12.977848725392104|-0.02335359093652395|
|(10,[0,1,2,3,4,5,...| -11.827072996392571|  2.5642684021108417|
|(10,[0,1,2,3,4,5,...| -10.945919657782932| -0.1631314487734783|
|(10,[0,1,2,3,4,5,...|  -10.58331129986813|   2.517790654691453|
|(10,[0,1,2,3,4,5,...| -10.288657252388708| -0.9443474180536754|
|(10,[0,1,2,3,4,5,...|  -8.822357870425154|  0.6872889429113783|
|(10,[0,1,2,3,4,5,...|  -8.772667465932606|  -1.485408580416465|
|(10,[0,1,2,3,4,5,...|  -8.605713514762092|   1.110272909026478|
|(10,[0,1,2,3,4,5,...|  -6.544633229269576|  3.0454559778611285|
|(10,[0,1,2,3,4,5,...|  -5.055293333055445|  0.6441174575094268|
|(10,[0,1,2,3,4,5,...|  -5.039628433467326|  0.9572366607107066|
|(10,[0,1,2,3,4,5,...|  -4.937258492902948|  0.2292114538379546|
|(10,[0,1,2,3,4,5,...|  -3.741044592262687|   3.343205816009816|
|(10,[0,1,2,3,4,5,...|  -3.731112242951253| -2.6826413698701064|
|(10,[0,1,2,3,4,5,...|  -2.109441044710089| -2.1930034039595445|
|(10,[0,1,2,3,4,5,...| -1.8722161156986976| 0.49547270330052423|
|(10,[0,1,2,3,4,5,...| -1.1009750789589774| -0.9441633113006601|
|(10,[0,1,2,3,4,5,...|-0.48115211266405217| -0.6756196573079968|
+--------------------+--------------------+--------------------+
* Run with
* {{{
* bin/run-example ml.JavaModelSelectionViaTrainValidationSplitExample
* }}}
*/
public class JavaModelSelectionViaTrainValidationSplitExample {
public static void main(String[] args) {
 SparkSession spark = SparkSession
   .builder()
   .appName("JavaModelSelectionViaTrainValidationSplitExample")
   .getOrCreate();
 // $example on$
 Dataset<Row> data = spark.read().format("libsvm").load("sample_linear_regression_data.txt");
 data.show();
 // Prepare training and test data.
 Dataset<Row>[] splits = data.randomSplit(new double[] {0.9, 0.1}, 12345);
 Dataset<Row> training = splits[0];
 Dataset<Row> test = splits[1];

 LinearRegression lr = new LinearRegression();

 // We use a ParamGridBuilder to construct a grid of parameters to search over.
 // TrainValidationSplit will try all combinations of values and determine best model using
 // the evaluator.
 ParamMap[] paramGrid = new ParamGridBuilder()
   .addGrid(lr.regParam(), new double[] {0.1, 0.01})
   .addGrid(lr.fitIntercept())
   .addGrid(lr.elasticNetParam(), new double[] {0.0, 0.5, 1.0})
   .build();

 // In this case the estimator is simply the linear regression.
 // A TrainValidationSplit requires an Estimator, a set of Estimator ParamMaps, and an Evaluator.
 TrainValidationSplit trainValidationSplit = new TrainValidationSplit()
   .setEstimator(lr)
   .setEvaluator(new RegressionEvaluator())
   .setEstimatorParamMaps(paramGrid)
   .setTrainRatio(0.8);  // Evaluate up to 2 parameter settings in parallel

 // Run train validation split, and choose the best set of parameters.
 TrainValidationSplitModel model = trainValidationSplit.fit(training);

 // Make predictions on test data. model is the model with combination of parameters
 // that performed best.
 model.transform(test)
   .select("features", "label", "prediction")
   .show();
 // $example off$

 spark.stop();
}
}