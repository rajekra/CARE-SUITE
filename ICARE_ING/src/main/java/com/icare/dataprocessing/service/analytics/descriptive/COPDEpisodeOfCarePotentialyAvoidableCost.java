package com.icare.dataprocessing.service.analytics.descriptive;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.SparkSession;

import com.icare.dataprocessing.dto.CH;
import com.icare.dataprocessing.dto.CL;
import com.icare.dataprocessing.repository.RepositoryFactory;
import com.icare.dataprocessing.service.analytics.AbstractDescriptive;
import com.icare.dataprocessing.util.CommonConstants;
import com.mongodb.spark.MongoSpark;

public class COPDEpisodeOfCarePotentialyAvoidableCost extends AbstractDescriptive{

	public COPDEpisodeOfCarePotentialyAvoidableCost() throws Exception {
		super();
	}

	public static void main(String[] args) throws Exception {
		new COPDEpisodeOfCarePotentialyAvoidableCost();
	}

	@Override
	public void init() {
		sparkSession = SparkSession.builder().master(CommonConstants.SPARK_MASTER)
				 .config("spark.app.name", "COPDEpisodeOfCarePotentialyAvoidableCost")
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
		//Step 1: Load the claims with ICD9 Diagnosis codes 491.0, 491.1, 491.2, 491.20, 491.21, 491.22, 491.8, 491.9, 492.0, 492.8, 496
		//OR Load the claims with  ICD 10-Diagnosis codes: 0DBQ0ZZ, 0DBQ3ZZ, 0DBQ4ZZ, 0DBQ7ZZ, 0DBQ8ZZ, 0DBQXZZ, 0DBR0ZZ, 0DBR3ZZ, 0DBR4ZZ, 0DTQ0ZZ, 0DTQ4ZZ,0DTQ7ZZ, 0DTQ8ZZ, 0DTR0ZZ, 0DTR4ZZ, J410, J411, J418, J42, J430, J431, J432, J438, J439, J440, J441, J449
		//OR Load the claims with DRG codes: 0190, 0191, 0192
		//OR Load the claims with Revenue Codes: 0450, 0451, 0452, 0456, 0459
		Dataset<Row> completeData  = RepositoryFactory.getInpatientAggregationRepo().load(javaSparkContext,"INPATIENT_STAGING_COPD");
		completeData.createOrReplaceTempView("InpStagingTable");
		// ICD 9 => Dataset<Row> eocData  = sparkSession.sql("SELECT * FROM InpAggTable ip WHERE ip.prncplDgnsCd IN ('49100', '49110', '49120', '49121', '49122', '49180', '49190', '49200', '49280', '49600')");
		Dataset<Row> eocData  = sparkSession.sql("SELECT * FROM InpStagingTable ip WHERE ip.prncplDgnsCd IN ('J449','J441','J440') ");

		System.out.println("ECO DATA"+eocData.count());
		eocData.show();
		//SELECT * FROM TABLE A JOIN TABLE B  ON A.KEY1= B.KEY2
		return (T) eocData;
	}

	@Override
	public <T, P> T process(P config) throws Exception {
		//Step 2: Check header procedure codes not in Procedure codes: E0424, E0425, E0430, E0431, E0433, E0434, E0435, E0439, E0440, E0441, E0442, E0443, E0444, E1390, E1391, E1392,E1405, E1406, K0738, K0741, S8120, S8121
		Dataset<Row> eocData = (Dataset<Row>) config;
		eocData.createOrReplaceTempView("EpisodeTable");
		Map<String, List<?>> dataItem =  RepositoryFactory.getInpatientStagingRepo().load("PROF_STAGING");
		List<CL> cls = (List<CL>) dataItem.get("Line");
		Dataset<Row> profLines = sparkSession.createDataFrame(cls, CL.class);
		profLines.createTempView("ProfLineTable");
		System.out.println("==profLines");
		profLines.show();
		
		Dataset<Row> joinedData = sparkSession
				.sql("SELECT ET.admissiondate, ET.dischargeDate, ET.prncplDgnsCd, ET.drgCode,ET.mdc,ET.blngNationalPrvdrIdntfr,ET.patientGender,ET.patientBirthDate, CAST(PT.billedAmount AS INT) ,PT.fromServiceDate, PT.mbrIdentifier,PT.prcdrCode"
						+ " FROM EpisodeTable ET , ProfLineTable PT WHERE ET.mbrIdentifier = PT.mbrIdentifier"
						+ " AND TO_DATE(CAST(UNIX_TIMESTAMP(PT.fromServiceDate,'MM/dd/yyyy') AS TIMESTAMP))"
						+ " BETWEEN TO_DATE(CAST(UNIX_TIMESTAMP(ET.admissionDate,'MM/dd/yyyy') AS TIMESTAMP)) AND TO_DATE(CAST(UNIX_TIMESTAMP(ET.dischargeDate,'MM/dd/yyyy') AS TIMESTAMP))"
						+ " AND PT.prcdrCode NOT IN ('E0424','E0425','E0430','E0431','E0433','E0434','E0435','E0439','E0440','E0441','E0442','E0443','E0444','E1390','E1391','E1392','E1405','E1406','K0738','K0741','S8120','S8121')");
		
		System.out.println("JOINED DATA STARTS");
		joinedData.printSchema();
		
		joinedData.show();
		System.out.println("COUNT:"+joinedData.count());
		System.out.println("JOINED DATA ENDS");
		
		return (T) joinedData;
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
		RepositoryFactory.getInpatientAggregationRepo().save(dataSet, "COPD_PAC");

		//MongoSpark.save(dataSet);
		return null;
	}

}
