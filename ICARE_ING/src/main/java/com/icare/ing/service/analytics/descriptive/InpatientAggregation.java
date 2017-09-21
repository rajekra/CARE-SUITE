package com.icare.ing.service.analytics.descriptive;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.icare.common.dto.CH;
import com.icare.common.dto.CL;
import com.icare.ing.service.analytics.AbstractAnaytics;
import com.icare.ing.util.CommonConstants;
import com.icare.ing.util.PropUtilityService;
import com.mongodb.BasicDBObject;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.spark.MongoSpark;

public class InpatientAggregation extends AbstractAnaytics {

	public static void main(final String[] args) throws Exception {
		InpatientAggregation inpatientAggregation = new InpatientAggregation();
		inpatientAggregation.executePipeLine();
	}

	@Override
	public void init() {
		sparkSession.conf().set("", "");
		sparkSession.conf().set("spark.executor.heartbeatInterval", "20s");
		sparkSession.conf().set("spark.driver.extraJavaOptions", "-Xss600m");
		sparkSession.conf().set("spark.sql.crossJoin.enabled", "true");
		sparkSession.conf().set("spark.mongodb.input.uri",
				"mongodb://127.0.0.1/icare.institutional");
		sparkSession.conf().set("spark.mongodb.output.uri",
				"mongodb://127.0.0.1/icare.institutional");

	}

	@Override
	public <T, P> T load(P config) throws JsonParseException,
			JsonMappingException, IOException {
		Map<String, List<?>> returnItems = new HashMap<String, List<?>>();
		MongoCollection<BasicDBObject> collection = CommonConstants.INSTITUTIONAL_LK;
		MongoCursor<BasicDBObject> cursor = collection.find().iterator();
		List<CH> cds = new ArrayList<CH>();
		List<CL> cls = new ArrayList<CL>();
		while (cursor.hasNext()) {
			BasicDBObject basicDBObject = cursor.next();
			String jsonString = basicDBObject.toJson();
			CH cd = PropUtilityService.translateJsonToCD(jsonString);
			cls.addAll(cd.getLines());
			System.out
					.println("CD===============================================");
			System.out.println(cd);
			System.out
					.println("CD===============================================");
			cds.add(cd);
			cd.setLines(null);
		}
		returnItems.put("Header", cds);
		returnItems.put("Line", cls);
		return (T) returnItems;
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
		StringBuilder aggregateQuery = new StringBuilder();
		aggregateQuery.append("SELECT cd.inDate, cd.prncplPrcdrCd,");
		aggregateQuery.append("  cd.prncplDgnsCd,");
		aggregateQuery.append("  cd.mdc,");
		aggregateQuery
				.append("  SUM(CAST(cd.totalBilledAmount AS INT)) AS totalBilledAmount,");
		aggregateQuery
				.append("  SUM(CAST(cd.paidAmount AS        INT)) AS paidAmount,");
		aggregateQuery.append("  cd.admissionDate,");
		aggregateQuery.append("  cd.dischargeDate,");
		aggregateQuery.append("  cd.drgCode,");
		aggregateQuery.append("  cd.admtDiagCd,");
		aggregateQuery.append("  cd.prncplDgnsCd,");
		aggregateQuery.append("  cd.prncplDgnsPoa,");
		aggregateQuery.append("  cd.mbrIdentifier,");
		aggregateQuery.append("  cd.prncplPrcdrCd,");
		aggregateQuery.append("  cd.prncplPrcdrCdDate,");
		aggregateQuery.append("  cd.p1 ,");
		aggregateQuery.append("  cd.p1_dt ,");
		aggregateQuery.append("  cd.p2 ,");
		aggregateQuery.append("  cd.p2_dt ,");
		aggregateQuery.append("  cd.p3 ,");
		aggregateQuery.append("  cd.p3_dt ,");
		aggregateQuery.append("  cd.p4 ,");
		aggregateQuery.append("  cd.p4_dt ,");
		aggregateQuery.append("  cd.p5 ,");
		aggregateQuery.append("  cd.p5_dt ,");
		aggregateQuery.append("  cd.p6 ,");
		aggregateQuery.append("  cd.p6_dt ,");
		aggregateQuery.append("  cd.p7 ,");
		aggregateQuery.append("  cd.p7_dt ,");
		aggregateQuery.append("  cd.p8 ,");
		aggregateQuery.append("  cd.p8_dt ,");
		aggregateQuery.append("  cd.p9 ,");
		aggregateQuery.append("  cd.p9_dt ,");
		aggregateQuery.append("  cd.p10 ,");
		aggregateQuery.append("  cd.p10_dt ,");
		aggregateQuery.append("  cd.p11 ,");
		aggregateQuery.append("  cd.p11_dt ,");
		aggregateQuery.append("  cd.p12 ,");
		aggregateQuery.append("  cd.p12_dt ,");
		aggregateQuery.append("  cd.p13 ,");
		aggregateQuery.append("  cd.p13_dt ,");
		aggregateQuery.append("  cd.p14 ,");
		aggregateQuery.append("  cd.p14_dt ,");
		aggregateQuery.append("  cd.p15 ,");
		aggregateQuery.append("  cd.p15_dt ,");
		aggregateQuery.append("  cd.p16 ,");
		aggregateQuery.append("  cd.p16_dt ,");
		aggregateQuery.append("  cd.p17 ,");
		aggregateQuery.append("  cd.p17_dt ,");
		aggregateQuery.append("  cd.p18 ,");
		aggregateQuery.append("  cd.p18_dt ,");
		aggregateQuery.append("  cd.p19 ,");
		aggregateQuery.append("  cd.p19_dt ,");
		aggregateQuery.append("  cd.p20 ,");
		aggregateQuery.append("  cd.p20_dt ,");
		aggregateQuery.append("  cd.p21 ,");
		aggregateQuery.append("  cd.p21_dt ,");
		aggregateQuery.append("  cd.p22 ,");
		aggregateQuery.append("  cd.p22_dt ,");
		aggregateQuery.append("  cd.p23 ,");
		aggregateQuery.append("  cd.p23_dt ,");
		aggregateQuery.append("  cd.p24 ,");
		aggregateQuery.append("  cd.p24_dt ,");
		aggregateQuery.append("  cd.cnd1 ,");
		aggregateQuery.append("  cd.cnd2 ,");
		aggregateQuery.append("  cd.cnd3 ,");
		aggregateQuery.append("  cd.cnd4 ,");
		aggregateQuery.append("  cd.cnd5 ,");
		aggregateQuery.append("  cd.ocr1 ,");
		aggregateQuery.append("  cd.ocr1_dt ,");
		aggregateQuery.append("  cd.ocr2 ,");
		aggregateQuery.append("  cd.ocr2_dt ,");
		aggregateQuery.append("  cd.ocr3 ,");
		aggregateQuery.append("  cd.ocr3_dt ,");
		aggregateQuery.append("  cd.ocr4 ,");
		aggregateQuery.append("  cd.ocr4_dt ,");
		aggregateQuery.append("  cd.ocr5 ,");
		aggregateQuery.append("  cd.ocr5_dt ,");
		aggregateQuery.append("  cd.val1 ,");
		aggregateQuery.append("  cd.val1_amt ,");
		aggregateQuery.append("  cd.val2 ,");
		aggregateQuery.append("  cd.val2_amt ,");
		aggregateQuery.append("  cd.val3 ,");
		aggregateQuery.append("  cd.val3_amt ,");
		aggregateQuery.append("  cd.val4 ,");
		aggregateQuery.append("  cd.val4_amt ,");
		aggregateQuery.append("  cd.val5 ,");
		aggregateQuery.append("  cd.val5_amt ,");
		aggregateQuery.append("  cd.val6 ,");
		aggregateQuery.append("  cd.val6_amt ,");
		aggregateQuery.append("  cd.val7 ,");
		aggregateQuery.append("  cd.val7_amt ,");
		aggregateQuery.append("  cd.val8 ,");
		aggregateQuery.append("  cd.val8_amt ,");
		aggregateQuery.append("  cd.val9 ,");
		aggregateQuery.append("  cd.val9_amt ,");
		aggregateQuery.append("  cd.val10 ,");
		aggregateQuery.append("  cd.val10_amt");
		aggregateQuery.append(" FROM CD cd ");
		aggregateQuery.append(" GROUP BY cd.mdc,cd.inDate,");
		aggregateQuery.append("  cd.prncplPrcdrCd,");
		aggregateQuery.append("  cd.prncplDgnsCd,");
		aggregateQuery.append("  cd.admissionDate,");
		aggregateQuery.append("  cd.dischargeDate,");
		aggregateQuery.append("  cd.drgCode,");
		aggregateQuery.append("  cd.admtDiagCd,");
		aggregateQuery.append("  cd.prncplDgnsCd,");
		aggregateQuery.append("  cd.prncplDgnsPoa,");
		aggregateQuery.append("  cd.mbrIdentifier,");
		aggregateQuery.append("  cd.prncplPrcdrCd,");
		aggregateQuery.append("  cd.prncplPrcdrCdDate,");
		aggregateQuery.append("  cd.p1 ,");
		aggregateQuery.append("  cd.p1_dt ,");
		aggregateQuery.append("  cd.p2 ,");
		aggregateQuery.append("  cd.p2_dt ,");
		aggregateQuery.append("  cd.p3 ,");
		aggregateQuery.append("  cd.p3_dt ,");
		aggregateQuery.append("  cd.p4 ,");
		aggregateQuery.append("  cd.p4_dt ,");
		aggregateQuery.append("  cd.p5 ,");
		aggregateQuery.append("  cd.p5_dt ,");
		aggregateQuery.append("  cd.p6 ,");
		aggregateQuery.append("  cd.p6_dt ,");
		aggregateQuery.append("  cd.p7 ,");
		aggregateQuery.append("  cd.p7_dt ,");
		aggregateQuery.append("  cd.p8 ,");
		aggregateQuery.append("  cd.p8_dt ,");
		aggregateQuery.append("  cd.p9 ,");
		aggregateQuery.append("  cd.p9_dt ,");
		aggregateQuery.append("  cd.p10 ,");
		aggregateQuery.append("  cd.p10_dt ,");
		aggregateQuery.append("  cd.p11 ,");
		aggregateQuery.append("  cd.p11_dt ,");
		aggregateQuery.append("  cd.p12 ,");
		aggregateQuery.append("  cd.p12_dt ,");
		aggregateQuery.append("  cd.p13 ,");
		aggregateQuery.append("  cd.p13_dt ,");
		aggregateQuery.append("  cd.p14 ,");
		aggregateQuery.append("  cd.p14_dt ,");
		aggregateQuery.append("  cd.p15 ,");
		aggregateQuery.append("  cd.p15_dt ,");
		aggregateQuery.append("  cd.p16 ,");
		aggregateQuery.append("  cd.p16_dt ,");
		aggregateQuery.append("  cd.p17 ,");
		aggregateQuery.append("  cd.p17_dt ,");
		aggregateQuery.append("  cd.p18 ,");
		aggregateQuery.append("  cd.p18_dt ,");
		aggregateQuery.append("  cd.p19 ,");
		aggregateQuery.append("  cd.p19_dt ,");
		aggregateQuery.append("  cd.p20 ,");
		aggregateQuery.append("  cd.p20_dt ,");
		aggregateQuery.append("  cd.p21 ,");
		aggregateQuery.append("  cd.p21_dt ,");
		aggregateQuery.append("  cd.p22 ,");
		aggregateQuery.append("  cd.p22_dt ,");
		aggregateQuery.append("  cd.p23 ,");
		aggregateQuery.append("  cd.p23_dt ,");
		aggregateQuery.append("  cd.p24 ,");
		aggregateQuery.append("  cd.p24_dt ,");
		aggregateQuery.append("  cd.cnd1 ,");
		aggregateQuery.append("  cd.cnd2 ,");
		aggregateQuery.append("  cd.cnd3 ,");
		aggregateQuery.append("  cd.cnd4 ,");
		aggregateQuery.append("  cd.cnd5 ,");
		aggregateQuery.append("  cd.ocr1 ,");
		aggregateQuery.append("  cd.ocr1_dt ,");
		aggregateQuery.append("  cd.ocr2 ,");
		aggregateQuery.append("  cd.ocr2_dt ,");
		aggregateQuery.append("  cd.ocr3 ,");
		aggregateQuery.append("  cd.ocr3_dt ,");
		aggregateQuery.append("  cd.ocr4 ,");
		aggregateQuery.append("  cd.ocr4_dt ,");
		aggregateQuery.append("  cd.ocr5 ,");
		aggregateQuery.append("  cd.ocr5_dt ,");
		aggregateQuery.append("  cd.val1 ,");
		aggregateQuery.append("  cd.val1_amt ,");
		aggregateQuery.append("  cd.val2 ,");
		aggregateQuery.append("  cd.val2_amt ,");
		aggregateQuery.append("  cd.val3 ,");
		aggregateQuery.append("  cd.val3_amt ,");
		aggregateQuery.append("  cd.val4 ,");
		aggregateQuery.append("  cd.val4_amt ,");
		aggregateQuery.append("  cd.val5 ,");
		aggregateQuery.append("  cd.val5_amt ,");
		aggregateQuery.append("  cd.val6 ,");
		aggregateQuery.append("  cd.val6_amt ,");
		aggregateQuery.append("  cd.val7 ,");
		aggregateQuery.append("  cd.val7_amt ,");
		aggregateQuery.append("  cd.val8 ,");
		aggregateQuery.append("  cd.val8_amt ,");
		aggregateQuery.append("  cd.val9 ,");
		aggregateQuery.append("  cd.val9_amt ,");
		aggregateQuery.append("  cd.val10 ,");
		aggregateQuery.append("  cd.val10_amt ");
		aggregateQuery.append("ORDER BY totalBilledAmount DESC   ");

		// Dataset<Row> centenarians =
		// spark.sql("select distinct h.prncplPrcdrCd, h.prncplDgnsCd, h.mdc, sum(cast(h.totalBilledAmount as int)) as total_amount from header h group by h.mdc,h.prncplDgnsCd, h.prncplPrcdrCd order by total_amount desc");
		Dataset<Row> centenarians = sparkSession.sql(aggregateQuery.toString());
		return (T) centenarians;
	}

	@Override
	public <T, P> T write(P inputData) {
		Dataset<Row> centenarians = (Dataset<Row>) inputData;
		centenarians.createOrReplaceTempView("aggheader");
		centenarians.printSchema();
		centenarians.show(100);
		// MongoSpark.write(centenarians).option("collection",
		// "INSTITUTIONAL_AGGR").mode("overwrite").save();
		return null;
	}

}