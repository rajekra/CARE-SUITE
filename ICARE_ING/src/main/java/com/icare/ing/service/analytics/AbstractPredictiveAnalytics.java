package com.icare.ing.service.analytics;

import org.apache.spark.ml.tuning.CrossValidator;
import org.apache.spark.ml.tuning.TrainValidationSplit;
import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;

/**
 * 
 * Attributes that have only two possible states, such as yes or no, should be marked as => Binary.
 * Attributes that are numbers or strings that are used to denote a category should be marked as => Categorical.
 * Attributes that are numeric quantities for which the order is meaningful should be marked as => Numeric.
 * Attributes that are strings that you would like to treat as words delimited by spaces should be marked as => Text.
 * @author kandhasamyr
 *
 */
public abstract class AbstractPredictiveAnalytics extends AbstractAnaytics {

	protected CrossValidator rossValidator = new CrossValidator();
	protected TrainValidationSplit trainValidationSplit = new TrainValidationSplit();
	
	public AbstractPredictiveAnalytics() throws Exception {
	}
	
	@Override
	public <T, P> T process(P data) throws Exception {
		Dataset<Row> rows = (Dataset<Row>) data;
		rows.printSchema();
		rows.show();
		return null;
	}

	@Override
	public <T, P> T write(P config) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
	public abstract  <T, P> T loadTrainingData(P config) throws Exception;
	public abstract  <T, P> T loadTestingData(P config) throws Exception;
	public abstract  <T, P> T buildPipeline(P config) throws Exception;
	public abstract  <T, P> T buildModel(P config) throws Exception;
	public abstract  <T, P> T predict(P config) throws Exception;
	public abstract  <T, P> T saveModel(P config) throws Exception;
}
