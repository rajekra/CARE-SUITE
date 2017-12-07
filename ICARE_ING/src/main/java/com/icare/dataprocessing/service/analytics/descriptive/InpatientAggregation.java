package com.icare.dataprocessing.service.analytics.descriptive;

import java.util.List;
import java.util.Map;

import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.SparkSession;

import com.icare.dataprocessing.dto.CH;
import com.icare.dataprocessing.dto.CL;
import com.icare.dataprocessing.repository.RepositoryFactory;
import com.icare.dataprocessing.repository.intf.InpatientAggregationRepoIntf;
import com.icare.dataprocessing.service.analytics.AbstractDescriptive;
import com.icare.dataprocessing.util.CommonConstants;

public class InpatientAggregation extends AbstractDescriptive {

	public InpatientAggregation() throws Exception {
		super();
	}

	public static void main(final String[] args) throws Exception {
		new InpatientAggregation();
	}

	@Override
	public void init() {
		sparkSession = SparkSession.builder().master(CommonConstants.SPARK_MASTER)
		 .config("spark.app.name", "InpatientAggregation")
		 .config("spark.executor.heartbeatInterval", "20s")
		 .config("spark.driver.extraJavaOptions", "-Xss600m")
		 .config("spark.sql.crossJoin.enabled", "true")
		 .config("spark.mongodb.input.uri",	CommonConstants.MONGO_URI+"icare.institutional")
		 .config("spark.mongodb.output.uri", CommonConstants.MONGO_URI+"icare.institutional")
		  .getOrCreate();

	}

	@Override
	public <T, P> T load(P config) throws Exception {
		return RepositoryFactory.getInpatientStagingRepo().load("INPATIENT_STAGING_NONCOPD");
	}

	@SuppressWarnings("unchecked")
	@Override
	public <T, P> T process(P config) {
		System.out.println("Processing the records from staging table!!!");
		Map<String, List<?>> dataItem = (Map<String, List<?>>) config;
		List<CH> cds = (List<CH>) dataItem.get("Header");
		List<CL> cls = (List<CL>) dataItem.get("Line");
		Dataset<Row> dataFrame = sparkSession.createDataFrame(cds, CH.class);
		Dataset<Row> lineFrames = sparkSession.createDataFrame(cls, CL.class);
		lineFrames.printSchema();
		// lineFrames.show();

		dataFrame.createOrReplaceTempView("CD");
		lineFrames.createOrReplaceTempView("CL");

		// Dataset<Row> centenarians =
		// spark.sql("select sum(cast(s.billedAmount as int)) from line s");
		// Dataset<Row> centenarians =
		// spark.sql("select distinct h.totalBilledAmount,h.tcn, sum(cast(s.billedAmount as int)) , to_date(s.fromServiceDate) as dd from line s , header h group by s.fromServiceDate,h.totalBilledAmount,h.tcn");

		// Dataset<Row> centenarians =
		// spark.sql("select distinct h.prncplPrcdrCd, h.prncplDgnsCd, h.mdc, sum(cast(h.totalBilledAmount as int)) as total_amount from header h group by h.mdc,h.prncplDgnsCd, h.prncplPrcdrCd order by total_amount desc");
		Dataset<Row> centenarians = sparkSession.sql(InpatientAggregationRepoIntf.inpatientAggregateQuery.toString());
		
		return (T) centenarians;
	}

	@SuppressWarnings("unchecked")
	@Override
	public <T, P> T write(P inputData) {
		System.out.println("Saving the records from staging table to AGGR table!!!");
		Dataset<Row> dataSet = (Dataset<Row>) inputData;
		dataSet.createOrReplaceTempView("aggheader");
		//dataSet.printSchema();
		dataSet.show();
		Dataset<Row> withAge = sparkSession.sql(" select aggr.*, CASE WHEN aggr.age between 0 and 18 THEN '0 - 18' WHEN aggr.age between 19 and 30 THEN '18 - 30' WHEN aggr.age between 31 and 40 THEN '31 - 40' WHEN aggr.age between 41 and 50 THEN '41 - 50' WHEN aggr.age between 51 and 65 THEN '51 - 65' ELSE 'GT 65' END AS age_range from aggheader aggr");
		withAge.printSchema();
		withAge.show();
		withAge.persist();
		withAge.cache();
		
		Dataset<Row> mdcData  = RepositoryFactory.getInpatientAggregationRepo().load(javaSparkContext,"MAJOR_DIAG_CATEGORY_MS");
		mdcData.createOrReplaceTempView("MDC");
		withAge.createOrReplaceTempView("AGGREGATION");
		Dataset<Row> dataForMetrics = sparkSession.sql("select P.*,M.MDC_DESCRIPTION from AGGREGATION P, MDC M WHERE P.mdc = M.MDC_ID");
		dataForMetrics.printSchema();
		dataForMetrics.show();
		dataForMetrics.persist();
		dataForMetrics.cache();
		RepositoryFactory.getInpatientAggregationRepo().save(dataForMetrics,"INPATIENT_AGGREGATED_NONCOPD");
		return null;
	}


}