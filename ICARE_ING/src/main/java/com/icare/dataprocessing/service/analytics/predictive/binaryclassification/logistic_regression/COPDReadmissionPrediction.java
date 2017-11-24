package com.icare.dataprocessing.service.analytics.predictive.binaryclassification.logistic_regression;

import java.util.ArrayList;
import java.util.List;

import org.apache.spark.ml.Pipeline;
import org.apache.spark.ml.PipelineStage;
import org.apache.spark.ml.feature.Bucketizer;
import org.apache.spark.ml.feature.Normalizer;
import org.apache.spark.ml.feature.OneHotEncoder;
import org.apache.spark.ml.feature.StringIndexer;
import org.apache.spark.ml.feature.VectorAssembler;
import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.SparkSession;

import com.icare.dataprocessing.repository.RepositoryFactory;
import com.icare.dataprocessing.util.CommonConstants;

public class COPDReadmissionPrediction extends LogisticRegressionBuilder {
	public COPDReadmissionPrediction(SparkSession sparkSession) throws Exception {
		super(sparkSession);
		 System.out.println("COPDReadmissionPrediction Constructor");
	}

	public static void main(String args[]) throws Exception {
		SparkSession sparkSession = SparkSession.builder().master(CommonConstants.SPARK_MASTER)
				 .config("spark.app.name", "COPDReadmissionPrediction")
				 .config("spark.sql.crossJoin.enabled", "true")
				  .getOrCreate();
		new COPDReadmissionPrediction(sparkSession);
	}

	@Override
	public <T, P> T initialize(P config) throws Exception {
		return null;
	}

	@Override
	public <T, P> T loadTrainingData(P config) throws Exception {
		Dataset<Row> testingData  = RepositoryFactory.getInpatientAggregationRepo().load(javaSparkContext,"COPD_READMISSION");
		testingData = testingData.withColumnRenamed("label", "totalBilledAmount");
		testingData = testingData.withColumnRenamed("label1", "label");
		testingData.createOrReplaceTempView("FinalTable");
		Dataset<Row> aggr  = sparkSession.sql("SELECT IS1.label, IS1.mbrIdentifier, IS1._id, "
				+ " SUM(CASE WHEN IS1.prncplDgnsCd is NULL OR IS1.prncplDgnsCd='' THEN 0 ELSE 1 END) AS prncplDgnsCd_cnt,"
				+ " SUM(CASE WHEN IS1.admtDiagCd is NULL OR IS1.admtDiagCd='' THEN 0 ELSE 1 END) AS admtDiagCd_cnt,"
				+ " SUM(CASE WHEN IS1.d1 is NULL OR IS1.d1='' THEN 0 ELSE 1 END) AS d1_cnt,"
				+ " SUM(CASE WHEN IS1.d2 is NULL OR IS1.d2='' THEN 0 ELSE 1 END) as d2_cnt ,"
				+ " SUM(CASE WHEN IS1.d3 is NULL OR IS1.d3='' THEN 0 ELSE 1 END) AS d3_cnt,"
				+ " SUM(CASE WHEN IS1.d4 is NULL OR IS1.d4='' THEN 0 ELSE 1 END) as d4_cnt ,"
				+ " SUM(CASE WHEN IS1.d5 is NULL OR IS1.d5='' THEN 0 ELSE 1 END) AS d5_cnt,"
				+ " SUM(CASE WHEN IS1.d6 is NULL OR IS1.d6='' THEN 0 ELSE 1 END) as d6_cnt ,"
				+ " SUM(CASE WHEN IS1.d7 is NULL OR IS1.d7='' THEN 0 ELSE 1 END) AS d7_cnt,"
				+ " SUM(CASE WHEN IS1.d8 is NULL OR IS1.d8='' THEN 0 ELSE 1 END) as d8_cnt ,"
				+ " SUM(CASE WHEN IS1.d9 is NULL OR IS1.d9='' THEN 0 ELSE 1 END) AS d9_cnt,"
				+ " SUM(CASE WHEN IS1.d10 is NULL OR IS1.d10='' THEN 0 ELSE 1 END) as d10_cnt ,"
				+ " SUM(CASE WHEN IS1.d11 is NULL OR IS1.d11='' THEN 0 ELSE 1 END) AS d11_cnt,"
				+ " SUM(CASE WHEN IS1.d12 is NULL OR IS1.d12='' THEN 0 ELSE 1 END) as d12_cnt ,"
				+ " SUM(CASE WHEN IS1.d13 is NULL OR IS1.d13='' THEN 0 ELSE 1 END) AS d13_cnt,"
				+ " SUM(CASE WHEN IS1.d14 is NULL OR IS1.d14='' THEN 0 ELSE 1 END) as d14_cnt ,"
				+ " SUM(CASE WHEN IS1.d15 is NULL OR IS1.d15='' THEN 0 ELSE 1 END) AS d15_cnt,"
				+ " SUM(CASE WHEN IS1.d16 is NULL OR IS1.d16='' THEN 0 ELSE 1 END) as d16_cnt ,"
				+ " SUM(CASE WHEN IS1.d17 is NULL OR IS1.d17='' THEN 0 ELSE 1 END) AS d17_cnt,"
				+ " SUM(CASE WHEN IS1.d18 is NULL OR IS1.d18='' THEN 0 ELSE 1 END) as d18_cnt ,"
				+ " SUM(CASE WHEN IS1.d19 is NULL OR IS1.d19='' THEN 0 ELSE 1 END) AS d19_cnt,"
				+ " SUM(CASE WHEN IS1.d20 is NULL OR IS1.d20='' THEN 0 ELSE 1 END) as d20_cnt ,"
				+ " SUM(CASE WHEN IS1.d21 is NULL OR IS1.d20='' THEN 0 ELSE 1 END) as d21_cnt ,"
				+ " SUM(CASE WHEN IS1.d22 is NULL OR IS1.d20='' THEN 0 ELSE 1 END) as d22_cnt ,"
				+ " SUM(CASE WHEN IS1.d23 is NULL OR IS1.d20='' THEN 0 ELSE 1 END) as d23_cnt ,"
				+ " IS1.age,IS1.patientGender,YEAR(TO_DATE(CAST(UNIX_TIMESTAMP(IS1.admissionDate,'MM/dd/yyyy') AS TIMESTAMP))) AS admitYear,"
				+ " MONTH(TO_DATE(CAST(UNIX_TIMESTAMP(IS1.admissionDate,'MM/dd/yyyy') AS TIMESTAMP))) AS admitMonth,"
				+ " IS1.patientStatusLkpcd,IS1.los "
				+ " from FinalTable IS1 GROUP BY"
				+ " IS1.label, IS1.mbrIdentifier,IS1._id, IS1.age,IS1.patientGender,admitYear,admitMonth,IS1.patientStatusLkpcd,IS1.los");
//		aggr.printSchema();
//		aggr.show();
		aggr.createOrReplaceTempView("COPDTable");
		//|label|mbrIdentifier|                 _id|d18_cnt|d17_cnt|             age|patientGender|admitYear|admitMonth|patientStatusLkpcd|los|
		Dataset<Row> copData = sparkSession.sql("SELECT CAST(IS1.label AS DOUBLE) AS label, IS1.mbrIdentifier, IS1._id, "
				+ " SUM(IS1.prncplDgnsCd_cnt+IS1.admtDiagCd_cnt+IS1.d1_cnt+IS1.d2_cnt+IS1.d3_cnt+IS1.d4_cnt+IS1.d5_cnt+IS1.d6_cnt+IS1.d7_cnt+IS1.d8_cnt+IS1.d9_cnt+IS1.d10_cnt+IS1.d11_cnt+IS1.d12_cnt+IS1.d13_cnt+IS1.d14_cnt+IS1.d15_cnt+IS1.d16_cnt+IS1.d17_cnt+IS1.d18_cnt+IS1.d19_cnt+IS1.d20_cnt+IS1.d21_cnt+IS1.d22_cnt) AS diag_cnt,"
				+ " IS1.age,IS1.patientGender,IS1.admitYear,"
				+ " IS1.admitMonth,"
				+ " IS1.patientStatusLkpcd,IS1.los "
				+ " from COPDTable IS1 GROUP BY"
				+ " label, IS1.mbrIdentifier,IS1._id, IS1.age,IS1.patientGender,IS1.admitYear,IS1.admitMonth,IS1.patientStatusLkpcd,IS1.los");
		copData.printSchema();
		copData.show();
		return (T) copData;
	}

	@Override
	public <T, P> T loadTestingData(P config) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <T, P> T buildPipeline(P config) throws Exception {
		List<String> assemblers = new ArrayList<String>();
		List<PipelineStage> indexers = new ArrayList<PipelineStage>();
		
		StringIndexer patientGenderIndexer = new StringIndexer().setInputCol("patientGender").setOutputCol("patientGenderIndexer");
		OneHotEncoder patientGenderVec = new OneHotEncoder().setInputCol("patientGenderIndexer").setOutputCol("patientGenderVec");
		patientGenderIndexer.setHandleInvalid("keep");
		assemblers.add("patientGenderIndexer");
		assemblers.add("patientGenderVec");
		indexers.add(patientGenderIndexer);
		indexers.add(patientGenderVec);
		
		StringIndexer admitYearIndexer = new StringIndexer().setInputCol("admitYear").setOutputCol("admitYearIndexer");
		OneHotEncoder admitYearVec = new OneHotEncoder().setInputCol("admitYearIndexer").setOutputCol("admitYearVec");
		admitYearIndexer.setHandleInvalid("keep");
		assemblers.add("admitYearIndexer");
		assemblers.add("admitYearVec");
		indexers.add(admitYearIndexer);
		indexers.add(admitYearVec);
		
		
		StringIndexer admitMonthIndexer = new StringIndexer().setInputCol("admitMonth").setOutputCol("admitMonthIndexer");
		OneHotEncoder admitMonthVec = new OneHotEncoder().setInputCol("admitMonthIndexer").setOutputCol("admitMonthVec");
		admitMonthIndexer.setHandleInvalid("keep");
		assemblers.add("admitMonthIndexer");
		assemblers.add("admitMonthVec");
		indexers.add(admitMonthIndexer);
		indexers.add(admitMonthVec);
		
		StringIndexer patientStatusLkpcdIndexer = new StringIndexer().setInputCol("patientStatusLkpcd").setOutputCol("patientStatusLkpcdIndexer");
		OneHotEncoder patientStatusLkpcdVec = new OneHotEncoder().setInputCol("patientStatusLkpcdIndexer").setOutputCol("patientStatusLkpcdVec");
		patientStatusLkpcdIndexer.setHandleInvalid("keep");
		assemblers.add("patientStatusLkpcdIndexer");
		assemblers.add("patientStatusLkpcdVec");
		indexers.add(patientStatusLkpcdIndexer);
		indexers.add(patientStatusLkpcdVec);
		
		
		double[] splits = {10,20,30,40,65,75,100};
		Bucketizer ageBucketizer = new Bucketizer().setInputCol("age").setOutputCol("ageBucketizer").setSplits(splits);
		ageBucketizer.setHandleInvalid("keep");
		indexers.add(ageBucketizer);
		
		assemblers.add("ageBucketizer");
		assemblers.add("los");
		assemblers.add("diag_cnt");
		
		VectorAssembler assembler = new VectorAssembler().setInputCols(assemblers.toArray(new String[assemblers.size()])).setOutputCol("features_temp");
		Normalizer normalizer = new Normalizer().setInputCol("features_temp").setOutputCol("features");
		indexers.add(assembler);
		indexers.add(normalizer);
		indexers.add(logisticRegression);
		
		Pipeline pipeLine = new Pipeline().setStages(indexers.toArray(new PipelineStage[indexers.size()]));

		paramGrid = paramBuilder.build();
		trainValidationSplit.setEstimatorParamMaps(paramGrid);
		trainValidationSplit.setEstimator(pipeLine);
		return (T) config;
	}

	@Override
	public <T, P> T buildModel(P training) throws Exception {
		Dataset<Row> train = (Dataset<Row>) training;
		train = train.drop("mbrIdentifier");
		train = train.drop("_id");
		trainValidationSplitModel = trainValidationSplit.fit(train);
		System.out.println("Avg Met:"+trainValidationSplitModel.bestModel().explainParams());
		return null;
	}

	@Override
	public <T, P> T predict(P test) throws Exception {
		Dataset<Row> testing = (Dataset<Row>) test;
		testing = testing.drop("label");
		System.out.println("===========B4 PREDICTION==========");
		testing.printSchema();
		testing.show();
		Dataset<Row> predictions = trainValidationSplitModel.transform(testing);
		System.out.println("===========AFTER PREDICTION==========");
		predictions.printSchema();
		predictions.show();
		for (Row r : predictions.select("_id", "mbrIdentifier", "probability",
				"prediction").collectAsList()) {
			System.out.println("(" + r.get(0) + ", " + r.get(1) + ") --> prob="
					+ r.get(2) + ", prediction=" + r.get(3));
		}
		return (T) predictions;
	}

	@Override
	public <T, P> T saveModel(P config) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <T, P> T readModel(P config) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <T, P> T savePrediction(P config) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
}
