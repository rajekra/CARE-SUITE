package com.icare.dataprocessing.service.analytics.descriptive;

import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.SparkSession;

import com.icare.dataprocessing.repository.RepositoryFactory;
import com.icare.dataprocessing.service.analytics.AbstractDescriptive;
import com.icare.dataprocessing.util.CommonConstants;

public class COPDReadmissionReconcile extends AbstractDescriptive{

	public COPDReadmissionReconcile() throws Exception {
		super();
	}

	public static void main(String[] args) throws Exception {
		new COPDReadmissionReconcile();
	}

	@Override
	public void init() {
		sparkSession = SparkSession.builder().master(CommonConstants.SPARK_MASTER)
				 .config("spark.app.name", "COPDEpisodeOfCare")
				 .config("spark.executor.heartbeatInterval", "20s")
				 .config("spark.driver.extraJavaOptions", "-Xss5g")
				  .config("spark.driver.driver-memory ", "5g")
				 .config("spark.sql.crossJoin.enabled", "true")
		//		 .config("spark.mongodb.input.uri",	CommonConstants.MONGO_URI+"icare.COPD_DESCRIPITIVE")
		//		 .config("spark.mongodb.output.uri", CommonConstants.MONGO_URI+"icare.COPD_DESCRIPITIVE")
				  .getOrCreate();
		
	}

	@Override
	public <T, P> T load(P config) throws Exception {

		Dataset<Row> completeData  = RepositoryFactory.getInpatientAggregationRepo().load(javaSparkContext,"INPATIENT_AGGREGATED");
		
		return (T) completeData;
	
	}

	@Override
	public <T, P> T process(P config) throws Exception {
		Dataset<Row> completeData  = (Dataset<Row>) config;
		completeData.createOrReplaceTempView("InpStagingTable");
		
		Dataset<Row> eocData  = sparkSession.sql("SELECT mbrIdentifier, count(mbrIdentifier) AS id_count FROM InpStagingTable WHERE prncplDgnsCd IN ('J449','J441','J440') GROUP BY mbrIdentifier HAVING id_count > 1");
		eocData.createOrReplaceTempView("COPDData");
		eocData.printSchema();
		Dataset<Row> finalData = sparkSession.sql("SELECT 'label1',IST.* from InpStagingTable IST, COPDData copd WHERE IST.mbrIdentifier = copd.mbrIdentifier"
				+ " AND IST.prncplDgnsCd IN ('J449','J441','J440')");
		finalData.createOrReplaceTempView("FinalTable");
		
//		Dataset<Row> aggr  = sparkSession.sql("SELECT DISTINCT IS1.mbrIdentifier, IS1._id, "
//				+ " SUM(CASE WHEN IS1.d18 is NULL OR IS1.d18='' THEN 0 ELSE 1 END) AS d18_cnt,"
//				+ " SUM(CASE WHEN IS1.d17 is NULL OR IS1.d17='' THEN 0 ELSE 1 END) as d17_cnt ,"
//				+ " IS1.age,IS1.patientGender,YEAR(TO_DATE(CAST(UNIX_TIMESTAMP(IS1.admissionDate,'MM/dd/yyyy') AS TIMESTAMP))) AS admitYear,"
//				+ " MONTH(TO_DATE(CAST(UNIX_TIMESTAMP(IS1.admissionDate,'MM/dd/yyyy') AS TIMESTAMP))) AS admitMonth,"
//				+ " IS1.patientStatusLkpcd,IS1.los "
//				+ " from FinalTable IS1, FinalTable IS2"
//				+ " WHERE IS1._id != IS2._id"
//				+ " AND IS1.mbrIdentifier = IS2.mbrIdentifier"
//				+ " AND datediff(TO_DATE(CAST(UNIX_TIMESTAMP(IS1.dischargeDate,'MM/dd/yyyy') AS TIMESTAMP)), "
//				+ " TO_DATE(CAST(UNIX_TIMESTAMP(IS2.admissionDate,'MM/dd/yyyy') AS TIMESTAMP))) < 31 "
//				+ " AND IS1.prncplDgnsCd IN ('J449','J441','J440') GROUP BY"
//				+ " IS1.mbrIdentifier,IS1._id, IS1.age,IS1.patientGender,admitYear,admitMonth,IS1.patientStatusLkpcd,IS1.los");
		
	//	Dataset<Row> aggr  = sparkSession.sql("SELECT * from FinalTable ft1 LEFT OUTER JOIN FinalTable ft2 ON ft1.mbrIdentifier = ft2.mbrIdentifier");
		
		//Dataset<Row> aggr  = sparkSession.sql("select distinct(mbrIdentifier, _id) from FinalTable where mbrIdentifier in ( select distinct(t1a.mbrIdentifier) from FinalTable as t1a inner join FinalTable as t1b  on t1a.mbrIdentifier = t1b.mbrIdentifier  and t1a.dischargeDate < t1b.admissionDate  and datediff(TO_DATE(CAST(UNIX_TIMESTAMP(t1a.dischargeDate,'MM/dd/yyyy') AS TIMESTAMP)), TO_DATE(CAST(UNIX_TIMESTAMP(t1b.admissionDate,'MM/dd/yyyy') AS TIMESTAMP))) <= 30)");
//		Dataset<Row> aggr= sparkSession.sql("select DISTINCT t1._id, t1.mbrIdentifier from FinalTable t1 INNER JOIN FinalTable t2 ON t1.mbrIdentifier = t2.mbrIdentifier AND datediff(TO_DATE(CAST(UNIX_TIMESTAMP(t1.dischargeDate,'MM/dd/yyyy') AS TIMESTAMP)), TO_DATE(CAST(UNIX_TIMESTAMP(t2.admissionDate,'MM/dd/yyyy') AS TIMESTAMP))) <= 30");
//				aggr.show();
//
//		System.out.println("ECO COUNT:"+aggr.count());
//		Dataset<Row> eocData  = sparkSession.sql("SELECT * from InpStagingTable WHERE "
//				+ " datediff(TO_DATE(CAST(UNIX_TIMESTAMP(admissionDate,'MM/dd/yyyy') AS TIMESTAMP)), "
//				+ " TO_DATE(CAST(UNIX_TIMESTAMP(dischargeDate,'MM/dd/yyyy') AS TIMESTAMP))) < 31 ");
//		
		
//		Dataset<Row> eocData  = sparkSession.sql("SELECT ip._id,"
//				+ " SUM(CASE WHEN ip.d18 is NULL OR ip.d18='' THEN 0 ELSE 1 END) AS d18_cnt,"
//				+ " SUM(CASE WHEN ip.d17 is NULL OR ip.d17='' THEN 0 ELSE 1 END) as d17_cnt ,"
//				+ "ip.age,ip.patientGender,YEAR(TO_DATE(CAST(UNIX_TIMESTAMP(ip.admissionDate,'MM/dd/yyyy') AS TIMESTAMP))) AS admitYear,"
//				+ "MONTH(TO_DATE(CAST(UNIX_TIMESTAMP(ip.admissionDate,'MM/dd/yyyy') AS TIMESTAMP))) AS admitMonth,"
//				+ "ip.patientStatusLkpcd,ip.los FROM InpStagingTable ip"
//				+ " WHERE ip.prncplDgnsCd IN ('J449','J441','J440') GROUP BY"
//				+ " ip._id, ip.age,ip.patientGender,admitYear,admitMonth,ip.patientStatusLkpcd,ip.los");
////		eocData.show();
//		List<Row> rows = aggr.takeAsList(10000);
//		for(Row row:rows)
//		{
//			System.out.println(row);
//		}
//		
//		eocData.createOrReplaceTempView("Aggr");
//		Dataset<Row> aggr = sparkSession.sql("Select _id, sum(d18_cnt + d17_cnt) from Aggr group by _id");
//		aggr.show();
		return (T) finalData;
	}

	@Override
	public <T, P> T write(P inputData) throws Exception {
		//Step 3: If step 2 is true then save that data in DB
		System.out.println("Saving the records from staging table to AGGR table!!!");
		Dataset<Row> dataSet = (Dataset<Row>) inputData;
		dataSet.createOrReplaceTempView("aggheader");
		//dataSet.printSchema();
		dataSet.show();
		//MongoSpark.write((Dataset<T>) dataSet).option("collection","COPD_DESCRIPTIVE").mode("overwrite").save();
		dataSet.cache();
		dataSet.persist();
		RepositoryFactory.getInpatientAggregationRepo().save(dataSet, "COPD_READMISSION");

		//MongoSpark.save(dataSet);
		return null;
	}

}
