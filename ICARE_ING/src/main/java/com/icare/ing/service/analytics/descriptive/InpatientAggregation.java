package com.icare.ing.service.analytics.descriptive;

import java.util.List;
import java.util.Map;

import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.SparkSession;

import com.icare.common.dto.CH;
import com.icare.common.dto.CL;
import com.icare.ing.repository.RepositoryFactory;
import com.icare.ing.repository.intf.InpatientAggregationRepoIntf;
import com.icare.ing.service.analytics.AbstractAnaytics;
import com.icare.ing.util.CommonConstants;

public class InpatientAggregation extends AbstractAnaytics {

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
		return RepositoryFactory.getInpatientStagingRepo().load();
	}

	@SuppressWarnings("unchecked")
	@Override
	public <T, P> T process(P config) {
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
		Dataset<Row> centenarians = sparkSession.sql(InpatientAggregationRepoIntf.aggregateQuery.toString());
		return (T) centenarians;
	}

	@SuppressWarnings("unchecked")
	@Override
	public <T, P> T write(P inputData) {
		Dataset<Row> dataSet = (Dataset<Row>) inputData;
		dataSet.createOrReplaceTempView("aggheader");
		dataSet.printSchema();
		dataSet.show(100);
		RepositoryFactory.getInpatientAggregationRepo().save(dataSet);
		return null;
	}


}