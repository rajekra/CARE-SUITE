package com.icare.dataprocessing.service.analytics.descriptive;

import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.SparkSession;

import com.icare.dataprocessing.repository.RepositoryFactory;
import com.icare.dataprocessing.service.analytics.AbstractDescriptive;
import com.icare.dataprocessing.util.CommonConstants;

public class COPDEpisodeOfCare extends AbstractDescriptive{

	public COPDEpisodeOfCare() throws Exception {
		super();
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	@Override
	public void init() {
		sparkSession = SparkSession.builder().master(CommonConstants.SPARK_MASTER)
				 .config("spark.app.name", "COPDEpisodeOfCare")
				 .config("spark.executor.heartbeatInterval", "20s")
				 .config("spark.driver.extraJavaOptions", "-Xss600m")
				 .config("spark.sql.crossJoin.enabled", "true")
				 .config("spark.mongodb.input.uri",	CommonConstants.MONGO_URI+"icare.institutional")
				 .config("spark.mongodb.output.uri", CommonConstants.MONGO_URI+"icare.institutional")
				  .getOrCreate();
		
	}

	@Override
	public <T, P> T load(P config) throws Exception {
		//Step 1: Load the claims with ICD9 Diagnosis codes 491.0, 491.1, 491.2, 491.20, 491.21, 491.22, 491.8, 491.9, 492.0, 492.8, 496
		//OR Load the claims with  ICD 10-Diagnosis codes: 0DBQ0ZZ, 0DBQ3ZZ, 0DBQ4ZZ, 0DBQ7ZZ, 0DBQ8ZZ, 0DBQXZZ, 0DBR0ZZ, 0DBR3ZZ, 0DBR4ZZ, 0DTQ0ZZ, 0DTQ4ZZ,0DTQ7ZZ, 0DTQ8ZZ, 0DTR0ZZ, 0DTR4ZZ, J410, J411, J418, J42, J430, J431, J432, J438, J439, J440, J441, J449
		//OR Load the claims with DRG codes: 0190, 0191, 0192
		//OR Load the claims with Revenue Codes: 0450, 0451, 0452, 0456, 0459
		Dataset<Row> completeData  = RepositoryFactory.getInpatientAggregationRepo().load(javaSparkContext,"INPATIENT_AGGREGATED");
		completeData.createOrReplaceTempView("InpAggTable");
		Dataset<Row> eocData  = sparkSession.sql("SELECT * FROM InpAggTable ip WHERE ip.prncplDgnsCd IN ('49100', '49110', '49120', '49121', '49122', '49180', '49190', '49200', '49280', '49600')");		
		return (T) eocData;
	}

	@Override
	public <T, P> T process(P config) throws Exception {
		//Step 2: Check header procedure codes not in Procedure codes: E0424, E0425, E0430, E0431, E0433, E0434, E0435, E0439, E0440, E0441, E0442, E0443, E0444, E1390, E1391, E1392,E1405, E1406, K0738, K0741, S8120, S8121
		Dataset<Row> eocData = (Dataset<Row>) config;
		eocData.createOrReplaceTempView("EpisodeTable");
		Dataset<Row> filteredData  = sparkSession.sql("SELECT * FROM EpisodeTable et WHERE "
				+ " et.p1 IN('E0424','E0425','E0430','E0431','E0433','E0434','E0435','E0439','E0440','E0441','E0442','E0443','E0444','E1390','E1391','E1392','E1405','E1406','K0738','K0741','S8120','S8121')"
				+ "OR et.p2 IN('E0424','E0425','E0430','E0431','E0433','E0434','E0435','E0439','E0440','E0441','E0442','E0443','E0444','E1390','E1391','E1392','E1405','E1406','K0738','K0741','S8120','S8121')"
				+ "OR  et.p3 IN('E0424','E0425','E0430','E0431','E0433','E0434','E0435','E0439','E0440','E0441','E0442','E0443','E0444','E1390','E1391','E1392','E1405','E1406','K0738','K0741','S8120','S8121')"
				+ "OR  et.p4 IN('E0424','E0425','E0430','E0431','E0433','E0434','E0435','E0439','E0440','E0441','E0442','E0443','E0444','E1390','E1391','E1392','E1405','E1406','K0738','K0741','S8120','S8121')"
				+ "OR  et.p5 IN('E0424','E0425','E0430','E0431','E0433','E0434','E0435','E0439','E0440','E0441','E0442','E0443','E0444','E1390','E1391','E1392','E1405','E1406','K0738','K0741','S8120','S8121')"
				+ "OR  et.p6 IN('E0424','E0425','E0430','E0431','E0433','E0434','E0435','E0439','E0440','E0441','E0442','E0443','E0444','E1390','E1391','E1392','E1405','E1406','K0738','K0741','S8120','S8121')"
				+ "OR  et.p7 IN('E0424','E0425','E0430','E0431','E0433','E0434','E0435','E0439','E0440','E0441','E0442','E0443','E0444','E1390','E1391','E1392','E1405','E1406','K0738','K0741','S8120','S8121')"
				+ "OR  et.p8 IN('E0424','E0425','E0430','E0431','E0433','E0434','E0435','E0439','E0440','E0441','E0442','E0443','E0444','E1390','E1391','E1392','E1405','E1406','K0738','K0741','S8120','S8121')"
				+ "OR  et.p9 IN('E0424','E0425','E0430','E0431','E0433','E0434','E0435','E0439','E0440','E0441','E0442','E0443','E0444','E1390','E1391','E1392','E1405','E1406','K0738','K0741','S8120','S8121')"
				+ "OR  et.p10 IN('E0424','E0425','E0430','E0431','E0433','E0434','E0435','E0439','E0440','E0441','E0442','E0443','E0444','E1390','E1391','E1392','E1405','E1406','K0738','K0741','S8120','S8121')"
				+ "OR  et.p11 IN('E0424','E0425','E0430','E0431','E0433','E0434','E0435','E0439','E0440','E0441','E0442','E0443','E0444','E1390','E1391','E1392','E1405','E1406','K0738','K0741','S8120','S8121')"
				+ "OR  et.p12 IN('E0424','E0425','E0430','E0431','E0433','E0434','E0435','E0439','E0440','E0441','E0442','E0443','E0444','E1390','E1391','E1392','E1405','E1406','K0738','K0741','S8120','S8121')"
				+ "OR  et.p13 IN('E0424','E0425','E0430','E0431','E0433','E0434','E0435','E0439','E0440','E0441','E0442','E0443','E0444','E1390','E1391','E1392','E1405','E1406','K0738','K0741','S8120','S8121')"
				+ "OR  et.p14 IN('E0424','E0425','E0430','E0431','E0433','E0434','E0435','E0439','E0440','E0441','E0442','E0443','E0444','E1390','E1391','E1392','E1405','E1406','K0738','K0741','S8120','S8121')"
				+ "OR  et.p15 IN('E0424','E0425','E0430','E0431','E0433','E0434','E0435','E0439','E0440','E0441','E0442','E0443','E0444','E1390','E1391','E1392','E1405','E1406','K0738','K0741','S8120','S8121')"
				+ "OR  et.p16 IN('E0424','E0425','E0430','E0431','E0433','E0434','E0435','E0439','E0440','E0441','E0442','E0443','E0444','E1390','E1391','E1392','E1405','E1406','K0738','K0741','S8120','S8121')"
				+ "OR  et.p17 IN('E0424','E0425','E0430','E0431','E0433','E0434','E0435','E0439','E0440','E0441','E0442','E0443','E0444','E1390','E1391','E1392','E1405','E1406','K0738','K0741','S8120','S8121')"
				+ "OR  et.p18 IN('E0424','E0425','E0430','E0431','E0433','E0434','E0435','E0439','E0440','E0441','E0442','E0443','E0444','E1390','E1391','E1392','E1405','E1406','K0738','K0741','S8120','S8121')"
				+ "OR  et.p19 IN('E0424','E0425','E0430','E0431','E0433','E0434','E0435','E0439','E0440','E0441','E0442','E0443','E0444','E1390','E1391','E1392','E1405','E1406','K0738','K0741','S8120','S8121')"
				+ "OR  et.p20 IN('E0424','E0425','E0430','E0431','E0433','E0434','E0435','E0439','E0440','E0441','E0442','E0443','E0444','E1390','E1391','E1392','E1405','E1406','K0738','K0741','S8120','S8121')"
				+ "OR  et.p21 IN('E0424','E0425','E0430','E0431','E0433','E0434','E0435','E0439','E0440','E0441','E0442','E0443','E0444','E1390','E1391','E1392','E1405','E1406','K0738','K0741','S8120','S8121')"
				+ "OR  et.p22 IN('E0424','E0425','E0430','E0431','E0433','E0434','E0435','E0439','E0440','E0441','E0442','E0443','E0444','E1390','E1391','E1392','E1405','E1406','K0738','K0741','S8120','S8121')"
				+ "OR  et.p23 IN('E0424','E0425','E0430','E0431','E0433','E0434','E0435','E0439','E0440','E0441','E0442','E0443','E0444','E1390','E1391','E1392','E1405','E1406','K0738','K0741','S8120','S8121')"
				+ "OR  et.p24 IN('E0424','E0425','E0430','E0431','E0433','E0434','E0435','E0439','E0440','E0441','E0442','E0443','E0444','E1390','E1391','E1392','E1405','E1406','K0738','K0741','S8120','S8121')");
		return null;
	}

	@Override
	public <T, P> T write(P config) throws Exception {
		//Step 3: If step 2 is true then save that data in DB
		return null;
	}

}
