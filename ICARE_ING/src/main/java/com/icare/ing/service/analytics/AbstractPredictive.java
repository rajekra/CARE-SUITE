package com.icare.ing.service.analytics;


/**
 * 
 * Attributes that have only two possible states, such as yes or no, should be marked as => Binary.
 * Attributes that are numbers or strings that are used to denote a category should be marked as => Categorical.
 * Attributes that are numeric quantities for which the order is meaningful should be marked as => Numeric.
 * Attributes that are strings that you would like to treat as words delimited by spaces should be marked as => Text.
 * @author kandhasamyr
 *
 */
public interface AbstractPredictive {

	public <T, P> T initialize(P config) throws Exception;
	public <T, P> T loadTrainingData(P config) throws Exception;
	public <T, P> T loadTestingData(P config) throws Exception;
	public <T, P> T buildPipeline(P config) throws Exception;
	public <T, P> T buildModel(P config) throws Exception;
	public <T, P> T predict(P config) throws Exception;
	public <T, P> T saveModel(P config) throws Exception;
	public <T, P> T readModel(P config) throws Exception;
}
