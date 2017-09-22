package com.icare.ing.service.analytics;

import java.io.IOException;

import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.sql.SparkSession;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;

/**
 * The Class AbstractAnaytics.
 */
public abstract class AbstractAnayticsService {
	
	/** The spark session. */
	protected SparkSession sparkSession ;
	
	/** The java spark context. */
	protected JavaSparkContext javaSparkContext;
	
	/**
	 * Inits the.
	 */
	public abstract void init();
	/**
	 * Load.
	 *
	 * @param <T> the generic type
	 * @param <P>
	 * @param config the config
	 * @return the list
	 * @throws IOException 
	 * @throws JsonMappingException 
	 * @throws JsonParseException 
	 */
	public abstract <T, P> T load(P config) throws Exception;

	/**
	 * Process.
	 *
	 * @param <T> the generic type
	 * @param config the config
	 * @return the list
	 */
	public abstract  <T, P> T process(P config) throws Exception;

	/**
	 * Write.
	 *
	 * @param <T> the generic type
	 * @param config the config
	 * @return the list
	 */
	public abstract  <T, P> T write(P config) throws Exception;
	
	
	public void close()
	{
		javaSparkContext.close();
	}
	
	public AbstractAnayticsService() throws Exception
	{
		init();
		javaSparkContext = new JavaSparkContext(sparkSession.sparkContext());
		write(process(load(null)));
		close();
	}

}
