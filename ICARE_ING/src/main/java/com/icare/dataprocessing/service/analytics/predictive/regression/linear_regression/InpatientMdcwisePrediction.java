package com.icare.dataprocessing.service.analytics.predictive.regression.linear_regression;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.ArrayUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.ml.Estimator;
import org.apache.spark.ml.Pipeline;
import org.apache.spark.ml.PipelineStage;
import org.apache.spark.ml.Transformer;
import org.apache.spark.ml.feature.Bucketizer;
import org.apache.spark.ml.feature.Normalizer;
import org.apache.spark.ml.feature.OneHotEncoder;
import org.apache.spark.ml.feature.StringIndexer;
import org.apache.spark.ml.feature.VectorAssembler;
import org.apache.spark.ml.linalg.Vectors;
import org.apache.spark.ml.regression.LinearRegressionModel;
import org.apache.spark.ml.regression.LinearRegressionTrainingSummary;
import org.apache.spark.ml.tuning.TrainValidationSplitModel;
import org.apache.spark.mllib.evaluation.RegressionMetrics;
import org.apache.spark.sql.Column;
import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.SparkSession;

import com.icare.dataprocessing.repository.RepositoryFactory;
import com.icare.dataprocessing.util.CommonConstants;

/*
 * root
 |-- admtDiagCd: string (nullable = true)
 |-- age: double (nullable = true)
 |-- d1: string (nullable = true)
 |-- d10: string (nullable = true)
 |-- d10_poa: string (nullable = true)
 |-- d11: string (nullable = true)
 |-- d11_poa: string (nullable = true)
 |-- d12: string (nullable = true)
 |-- d12_poa: string (nullable = true)
 |-- d13: string (nullable = true)
 |-- d13_poa: string (nullable = true)
 |-- d14: string (nullable = true)
 |-- d14_poa: string (nullable = true)
 |-- d15: string (nullable = true)
 |-- d15_poa: string (nullable = true)
 |-- d16: string (nullable = true)
 |-- d16_poa: string (nullable = true)
 |-- d17: string (nullable = true)
 |-- d17_poa: string (nullable = true)
 |-- d18: string (nullable = true)
 |-- d18_poa: string (nullable = true)
 |-- d19: string (nullable = true)
 |-- d19_poa: string (nullable = true)
 |-- d1_poa: string (nullable = true)
 |-- d2: string (nullable = true)
 |-- d20: string (nullable = true)
 |-- d20_poa: string (nullable = true)
 |-- d21: string (nullable = true)
 |-- d21_poa: string (nullable = true)
 |-- d22: string (nullable = true)
 |-- d22_poa: string (nullable = true)
 |-- d23: string (nullable = true)
 |-- d23_poa: string (nullable = true)
 |-- d24: string (nullable = true)
 |-- d24_poa: string (nullable = true)
 |-- d2_poa: string (nullable = true)
 |-- d3: string (nullable = true)
 |-- d3_poa: string (nullable = true)
 |-- d4: string (nullable = true)
 |-- d4_poa: string (nullable = true)
 |-- d5: string (nullable = true)
 |-- d5_poa: string (nullable = true)
 |-- d6: string (nullable = true)
 |-- d6_poa: string (nullable = true)
 |-- d7: string (nullable = true)
 |-- d7_poa: string (nullable = true)
 |-- d8: string (nullable = true)
 |-- d8_poa: string (nullable = true)
 |-- d9: string (nullable = true)
 |-- d9_poa: string (nullable = true)
 |-- drgCode: string (nullable = true)
 |-- los: integer (nullable = true)
 |-- mdc: string (nullable = true)
 |-- p1: string (nullable = true)
 |-- p10: string (nullable = true)
 |-- p11: string (nullable = true)
 |-- p12: string (nullable = true)
 |-- p13: string (nullable = true)
 |-- p14: string (nullable = true)
 |-- p15: string (nullable = true)
 |-- p16: string (nullable = true)
 |-- p17: string (nullable = true)
 |-- p2: string (nullable = true)
 |-- p3: string (nullable = true)
 |-- p4: string (nullable = true)
 |-- p5: string (nullable = true)
 |-- p6: string (nullable = true)
 |-- p7: string (nullable = true)
 |-- p8: string (nullable = true)
 |-- p9: string (nullable = true)
 |-- patientGender: string (nullable = true)
 |-- patientStatusLkpcd: string (nullable = true)
 |-- prncplDgnsCd: string (nullable = true)
 |-- prncplDgnsPoa: string (nullable = true)
 |-- prncplPrcdrCd: string (nullable = true)
 |-- totalBilledAmount: long (nullable = true)
 */
public class InpatientMdcwisePrediction extends LinearRegressionBuilder {
	public InpatientMdcwisePrediction() throws Exception {
		super();
		 System.out.println("InpatientMdcwisePrediction Constructor");
	}

	public static void main(String args[]) throws Exception {
		new InpatientMdcwisePrediction();
	}


	@Override
	public <T, P> T initialize(P config) throws Exception {
		System.out.println("InpatientMdcwisePrediction [initialize]: STARTS");
		try{
			sparkSession = SparkSession.builder().master(CommonConstants.SPARK_MASTER)
					 .config("spark.app.name", "InpatientMdcwisePrediction")
					 .config("spark.sql.crossJoin.enabled", "true")
					// .config("spark.mongodb.input.uri", "mongodb://10.0.0.247:27017/icare.INPATIENT_AGGREGATED")
					// .config("spark.mongodb.output.uri", "mongodb://10.0.0.247:27017")
					// .config("spark.mongodb.input.collection", "icare.INPATIENT_AGGREGATED")
					//  .config("spark.mongodb.input.database", "icare")
					  .getOrCreate();
			javaSparkContext = new JavaSparkContext(sparkSession.sparkContext());
		}
		catch(Exception ex)
		{
			System.out.println("InpatientMdcwisePrediction [initialize]: Exception:" + ex.getMessage());
		}
		System.out.println("InpatientMdcwisePrediction [initialize]: ENDS");
		return null;
	}

	@Override
	public <T, P> T loadTrainingData(P config) throws Exception {
		Dataset<Row> testingData  = RepositoryFactory.getInpatientAggregationRepo().load(javaSparkContext);
		Dataset<Row> extractedTestingData = testingData.drop("_id", "inDate",
				"ocr1_dt", "ocr2_dt", "ocr3_dt", "ocr4_dt", "ocr5_dt", "p1_dt",
				"p2_dt", "p3_dt", "p4_dt", "p5_dt", "p6_dt", "p7_dt", "p8_dt",
				"p9_dt", "p10_dt", "p11_dt", "p12_dt", "p13_dt", "p14_dt",
				"p15_dt", "p16_dt", "p17_dt", "p18_dt", "p19_dt", "p20_dt",
				"p21_dt", "p22_dt", "p23_dt", "p24_dt", "cnd1", "cnd2", "cnd3",
				"cnd4", "cnd5", "ocr1", "ocr1_dt", "ocr2", "ocr2_dt", "ocr3",
				"ocr3_dt", "ocr4", "ocr4_dt", "ocr5", "ocr5_dt", "val1",
				"val1_amt", "val2", "val2_amt", "val3", "val3_amt", "val4",
				"val4_amt", "val5", "val5_amt", "val6", "val6_amt", "val7",
				"val7_amt", "val8", "val8_amt", "val9", "val9_amt", "val10",
				"val10_amt", "prncplPrcdrCdDate", "dischargeDate",
				"admissionDate");
		//extractedTestingData.printSchema();

		//To print mean/median
		//extractedTestingData.describe("admtDiagCd").show();
		return (T) extractedTestingData;	}

	@Override
	public <T, P> T loadTestingData(P config) throws Exception {
		Dataset<Row> testingData  = RepositoryFactory.getInpatientAggregationRepo().load(javaSparkContext);
		Dataset<Row> extractedTestingData = testingData.drop("_id", "inDate",
				"ocr1_dt", "ocr2_dt", "ocr3_dt", "ocr4_dt", "ocr5_dt", "p1_dt",
				"p2_dt", "p3_dt", "p4_dt", "p5_dt", "p6_dt", "p7_dt", "p8_dt",
				"p9_dt", "p10_dt", "p11_dt", "p12_dt", "p13_dt", "p14_dt",
				"p15_dt", "p16_dt", "p17_dt", "p18_dt", "p19_dt", "p20_dt",
				"p21_dt", "p22_dt", "p23_dt", "p24_dt", "cnd1", "cnd2", "cnd3",
				"cnd4", "cnd5", "ocr1", "ocr1_dt", "ocr2", "ocr2_dt", "ocr3",
				"ocr3_dt", "ocr4", "ocr4_dt", "ocr5", "ocr5_dt", "val1",
				"val1_amt", "val2", "val2_amt", "val3", "val3_amt", "val4",
				"val4_amt", "val5", "val5_amt", "val6", "val6_amt", "val7",
				"val7_amt", "val8", "val8_amt", "val9", "val9_amt", "val10",
				"val10_amt", "prncplPrcdrCdDate", "dischargeDate",
				"admissionDate");
		//extractedTestingData.printSchema();

		//To print mean/median
		//extractedTestingData.describe("admtDiagCd").show();
		return (T) extractedTestingData;
	}

	@Override
	public <T, P> T buildPipeline(P config) throws Exception {
		return null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public <T, P> T buildModel(P trainingData) throws Exception {
//		trainValidationSplitModel = trainValidationSplit.fit((Dataset<Row>) trainingData);
//		return (T) trainValidationSplitModel;
		Dataset<Row> trainingDataConverted = (Dataset<Row>) trainingData;
		trainingDataConverted.createOrReplaceTempView("TrainingTable");
		System.out.println("RAJ");
		
		//trainingDataConverted = sparkSession.sql("SELECT los, label, d1, d1_poa,d2, d2_poa,d3, d3_poa,d4, d4_poa from TrainingTable");
		
		List<PipelineStage> indexers = new ArrayList<PipelineStage>();
		//List<PipelineStage> indexers = new ArrayList<PipelineStage>();
		List<String> assemblers = new ArrayList<String>();
		
		if(ArrayUtils.contains(trainingDataConverted.columns(),"d1"))
		{
			Row d1Max = sparkSession.sql("SELECT d1, COUNT(d1) as d1_ct from TrainingTable group by d1 order by d1_ct desc").first();
			String d1MaxValue = d1Max.getAs("d1");
			trainingDataConverted = trainingDataConverted.na().fill(d1MaxValue, new String[] {"d1"});
			StringIndexer d1Indexer = new StringIndexer().setInputCol("d1").setOutputCol("d1Indexer");
			OneHotEncoder d1Vec = new OneHotEncoder().setInputCol("d1Indexer").setOutputCol("d1Vec");
			indexers.add(d1Indexer);
			indexers.add(d1Vec);
			//assemblers.add("d1Vec");
		}
		
		if(ArrayUtils.contains(trainingDataConverted.columns(),"d1_poa"))
		{
			Row d1Max = sparkSession.sql("SELECT d1_poa, COUNT(d1_poa) as d1_ct from TrainingTable group by d1_poa order by d1_ct desc").first();
			String d1MaxValue = d1Max.getAs("d1_poa");
			trainingDataConverted = trainingDataConverted.na().fill(d1MaxValue, new String[] {"d1_poa"});
			StringIndexer d1poaIndexer = new StringIndexer().setInputCol("d1_poa").setOutputCol("d1poaIndexer");
			OneHotEncoder d1poaVec = new OneHotEncoder().setInputCol("d1poaIndexer").setOutputCol("d1poaVec");
			indexers.add(d1poaIndexer);
			indexers.add(d1poaVec);
			//assemblers.add("d1_poa");
		}
		
		if(ArrayUtils.contains(trainingDataConverted.columns(),"d2"))
		{
			Row d1Max = sparkSession.sql("SELECT d2, COUNT(d2) as d1_ct from TrainingTable group by d2 order by d1_ct desc").first();
			String d1MaxValue = d1Max.getAs("d2");
			trainingDataConverted = trainingDataConverted.na().fill(d1MaxValue, new String[] {"d2"});	
			StringIndexer d2Indexer = new StringIndexer().setInputCol("d2").setOutputCol("d2Indexer");
			OneHotEncoder d2Vec = new OneHotEncoder().setInputCol("d2Indexer").setOutputCol("d2Vec");
			indexers.add(d2Indexer);
			indexers.add(d2Vec);
			//assemblers.add("d2");
		}
		

		if(ArrayUtils.contains(trainingDataConverted.columns(),"d2_poa"))
		{
			Row d1Max = sparkSession.sql("SELECT d2_poa, COUNT(d2_poa) as d1_ct from TrainingTable group by d2_poa order by d1_ct desc").first();
			String d1MaxValue = d1Max.getAs("d2_poa");
			trainingDataConverted = trainingDataConverted.na().fill(d1MaxValue, new String[] {"d2_poa"});	
			StringIndexer d2poaIndexer = new StringIndexer().setInputCol("d2_poa").setOutputCol("d2poaIndexer");
			OneHotEncoder d2poaVec = new OneHotEncoder().setInputCol("d2poaIndexer").setOutputCol("d2poaVec");
			indexers.add(d2poaIndexer);
			indexers.add(d2poaVec);
		//	assemblers.add("d2_poa");
		}
		
		if(ArrayUtils.contains(trainingDataConverted.columns(),"d3"))
		{
			Row d1Max = sparkSession.sql("SELECT d3, COUNT(d3) as d1_ct from TrainingTable group by d3 order by d1_ct desc").first();
			String d1MaxValue = d1Max.getAs("d3");
			trainingDataConverted = trainingDataConverted.na().fill(d1MaxValue, new String[] {"d3"});	
			StringIndexer d3Indexer = new StringIndexer().setInputCol("d3").setOutputCol("d3Indexer");
			OneHotEncoder d3Vec = new OneHotEncoder().setInputCol("d3Indexer").setOutputCol("d3Vec");
			indexers.add(d3Indexer);
			indexers.add(d3Vec);
		//	assemblers.add("d3");
		}
		
		if(ArrayUtils.contains(trainingDataConverted.columns(),"d3_poa"))
		{
			Row d1Max = sparkSession.sql("SELECT d3_poa, COUNT(d3_poa) as d1_ct from TrainingTable group by d3_poa order by d1_ct desc").first();
			String d1MaxValue = d1Max.getAs("d3_poa");
			trainingDataConverted = trainingDataConverted.na().fill(d1MaxValue, new String[] {"d3_poa"});
			StringIndexer d3poaIndexer = new StringIndexer().setInputCol("d3_poa").setOutputCol("d3poaIndexer");
			OneHotEncoder d3poaVec = new OneHotEncoder().setInputCol("d3poaIndexer").setOutputCol("d3poaVec");
			indexers.add(d3poaIndexer);
			indexers.add(d3poaVec);
			//assemblers.add("d3_poa");
		}
		
		if(ArrayUtils.contains(trainingDataConverted.columns(),"d4"))
		{
			Row d1Max = sparkSession.sql("SELECT d4, COUNT(d4) as d1_ct from TrainingTable group by d4 order by d1_ct desc").first();
			String d1MaxValue = d1Max.getAs("d4");
			trainingDataConverted = trainingDataConverted.na().fill(d1MaxValue, new String[] {"d4"});
			StringIndexer d4Indexer = new StringIndexer().setInputCol("d4").setOutputCol("d4Indexer");
			OneHotEncoder d4Vec = new OneHotEncoder().setInputCol("d4Indexer").setOutputCol("d4Vec");
			indexers.add(d4Indexer);
			indexers.add(d4Vec);
			//assemblers.add("d4");
		}
		
		if(ArrayUtils.contains(trainingDataConverted.columns(),"d4_poa"))
		{
			Row d1Max = sparkSession.sql("SELECT d4_poa, COUNT(d4_poa) as d1_ct from TrainingTable group by d4_poa order by d1_ct desc").first();
			String d1MaxValue = d1Max.getAs("d4_poa");
			trainingDataConverted = trainingDataConverted.na().fill(d1MaxValue, new String[] {"d4_poa"});
			StringIndexer d4poaIndexer = new StringIndexer().setInputCol("d4_poa").setOutputCol("d4poaIndexer");
			OneHotEncoder d4poaVec = new OneHotEncoder().setInputCol("d4poaIndexer").setOutputCol("d4poaVec");
			indexers.add(d4poaIndexer);
			indexers.add(d4poaVec);
		//	assemblers.add("d4_poa");
		}
		
		if(ArrayUtils.contains(trainingDataConverted.columns(),"d5"))
		{
			Row d1Max = sparkSession.sql("SELECT d5, COUNT(d5) as d1_ct from TrainingTable group by d5 order by d1_ct desc").first();
			String d1MaxValue = d1Max.getAs("d5");
			trainingDataConverted = trainingDataConverted.na().fill(d1MaxValue, new String[] {"d5"});
			StringIndexer d5Indexer = new StringIndexer().setInputCol("d5").setOutputCol("d5Indexer");
			OneHotEncoder d5Vec = new OneHotEncoder().setInputCol("d5Indexer").setOutputCol("d5Vec");
			indexers.add(d5Indexer);
			indexers.add(d5Vec);
			//assemblers.add("d5");
		}
		
		if(ArrayUtils.contains(trainingDataConverted.columns(),"d5_poa"))
		{
			Row d1Max = sparkSession.sql("SELECT d5_poa, COUNT(d5_poa) as d1_ct from TrainingTable group by d5_poa order by d1_ct desc").first();
			String d1MaxValue = d1Max.getAs("d5_poa");
			trainingDataConverted = trainingDataConverted.na().fill(d1MaxValue, new String[] {"d5_poa"});
			StringIndexer d5poaIndexer = new StringIndexer().setInputCol("d5_poa").setOutputCol("d5poaIndexer");
			OneHotEncoder d5poaVec = new OneHotEncoder().setInputCol("d5poaIndexer").setOutputCol("d5poaVec");
			indexers.add(d5poaIndexer);
			indexers.add(d5poaVec);
			//assemblers.add("d5_poa");
		}
		
		if(ArrayUtils.contains(trainingDataConverted.columns(),"d6"))
		{
			Row d1Max = sparkSession.sql("SELECT d6, COUNT(d6) as d1_ct from TrainingTable group by d6 order by d1_ct desc").first();
			String d1MaxValue = d1Max.getAs("d6");
			trainingDataConverted = trainingDataConverted.na().fill(d1MaxValue, new String[] {"d6"});
			StringIndexer d6Indexer = new StringIndexer().setInputCol("d6").setOutputCol("d6Indexer");
			OneHotEncoder d6Vec = new OneHotEncoder().setInputCol("d6Indexer").setOutputCol("d6Vec");
			indexers.add(d6Indexer);
			indexers.add(d6Vec);
			//assemblers.add("d6");
		}
		
		if(ArrayUtils.contains(trainingDataConverted.columns(),"d6_poa"))
		{
			Row d1Max = sparkSession.sql("SELECT d6_poa, COUNT(d6) as d1_ct from TrainingTable group by d6_poa order by d1_ct desc").first();
			String d1MaxValue = d1Max.getAs("d6_poa");
			trainingDataConverted = trainingDataConverted.na().fill(d1MaxValue, new String[] {"d6_poa"});
			StringIndexer d6poaIndexer = new StringIndexer().setInputCol("d6_poa").setOutputCol("d6poaIndexer");
			OneHotEncoder d6poaVec = new OneHotEncoder().setInputCol("d6poaIndexer").setOutputCol("d6poaVec");
			indexers.add(d6poaIndexer);
			indexers.add(d6poaVec);
			//assemblers.add("d6_poa");
		}
		
		if(ArrayUtils.contains(trainingDataConverted.columns(),"d7"))
		{
			Row d1Max = sparkSession.sql("SELECT d7, COUNT(d7) as d1_ct from TrainingTable group by d7 order by d1_ct desc").first();
			String d1MaxValue = d1Max.getAs("d7");
			trainingDataConverted = trainingDataConverted.na().fill(d1MaxValue, new String[] {"d7"});
			StringIndexer d7Indexer = new StringIndexer().setInputCol("d7").setOutputCol("d7Indexer");
			OneHotEncoder d7Vec = new OneHotEncoder().setInputCol("d7Indexer").setOutputCol("d7Vec");
			indexers.add(d7Indexer);
			indexers.add(d7Vec);
		//	assemblers.add("d7");
		}
		if(ArrayUtils.contains(trainingDataConverted.columns(),"d7_poa"))
		{		
			Row d1Max = sparkSession.sql("SELECT d7_poa, COUNT(d7_poa) as d1_ct from TrainingTable group by d7_poa order by d1_ct desc").first();
			String d1MaxValue = d1Max.getAs("d7_poa");
			trainingDataConverted = trainingDataConverted.na().fill(d1MaxValue, new String[] {"d7_poa"});
			StringIndexer d7poaIndexer = new StringIndexer().setInputCol("d7_poa").setOutputCol("d7poaIndexer");
			OneHotEncoder d7poaVec = new OneHotEncoder().setInputCol("d7poaIndexer").setOutputCol("d7poaVec");
			indexers.add(d7poaIndexer);
			indexers.add(d7poaVec);
		//	assemblers.add("d7_poa");
		}
		
		if(ArrayUtils.contains(trainingDataConverted.columns(),"d8"))
		{		
			Row d1Max = sparkSession.sql("SELECT d8, COUNT(d8) as d1_ct from TrainingTable group by d8 order by d1_ct desc").first();
			String d1MaxValue = d1Max.getAs("d8");
			trainingDataConverted = trainingDataConverted.na().fill(d1MaxValue, new String[] {"d8"});
			StringIndexer d8Indexer = new StringIndexer().setInputCol("d8").setOutputCol("d8Indexer");
			OneHotEncoder d8Vec = new OneHotEncoder().setInputCol("d8Indexer").setOutputCol("d8Vec");
			indexers.add(d8Indexer);
			indexers.add(d8Vec);
		//	assemblers.add("d8");
		}
		
		if(ArrayUtils.contains(trainingDataConverted.columns(),"d8_poa"))
		{		
			Row d1Max = sparkSession.sql("SELECT d8_poa, COUNT(d8_poa) as d1_ct from TrainingTable group by d8_poa order by d1_ct desc").first();
			String d1MaxValue = d1Max.getAs("d8_poa");
			trainingDataConverted = trainingDataConverted.na().fill(d1MaxValue, new String[] {"d8_poa"});
			StringIndexer d8poaIndexer = new StringIndexer().setInputCol("d8_poa").setOutputCol("d8poaIndexer");
			OneHotEncoder d8poaVec = new OneHotEncoder().setInputCol("d8poaIndexer").setOutputCol("d8poaVec");
			indexers.add(d8poaIndexer);
			indexers.add(d8poaVec);
		//	assemblers.add("d8_poa");
		}
		
		if(ArrayUtils.contains(trainingDataConverted.columns(),"d9"))
		{		
			Row d1Max = sparkSession.sql("SELECT d9, COUNT(d9) as d1_ct from TrainingTable group by d9 order by d1_ct desc").first();
			String d1MaxValue = d1Max.getAs("d9");
			trainingDataConverted = trainingDataConverted.na().fill(d1MaxValue, new String[] {"d9"});
			StringIndexer d9Indexer = new StringIndexer().setInputCol("d9").setOutputCol("d9Indexer");
			OneHotEncoder d9Vec = new OneHotEncoder().setInputCol("d9Indexer").setOutputCol("d9Vec");
			indexers.add(d9Indexer);
			indexers.add(d9Vec);
	//		assemblers.add("d9");
		}
		
		if(ArrayUtils.contains(trainingDataConverted.columns(),"d9_poa"))
		{		
			Row d1Max = sparkSession.sql("SELECT d9_poa, COUNT(d9_poa) as d1_ct from TrainingTable group by d9_poa order by d1_ct desc").first();
			String d1MaxValue = d1Max.getAs("d9_poa");
			trainingDataConverted = trainingDataConverted.na().fill(d1MaxValue, new String[] {"d9_poa"});
			StringIndexer d9poaIndexer = new StringIndexer().setInputCol("d9_poa").setOutputCol("d9poaIndexer");
			OneHotEncoder d9poaVec = new OneHotEncoder().setInputCol("d9poaIndexer").setOutputCol("d9poaVec");
			indexers.add(d9poaIndexer);
			indexers.add(d9poaVec);
	//		assemblers.add("d9_poa");
		}
		
		if(ArrayUtils.contains(trainingDataConverted.columns(),"d10"))
		{		
			Row d1Max = sparkSession.sql("SELECT d10, COUNT(d10) as d1_ct from TrainingTable group by d10 order by d1_ct desc").first();
			String d1MaxValue = d1Max.getAs("d10");
			trainingDataConverted = trainingDataConverted.na().fill(d1MaxValue, new String[] {"d10"});
			StringIndexer d10Indexer = new StringIndexer().setInputCol("d10").setOutputCol("d10Indexer");
			OneHotEncoder d10Vec = new OneHotEncoder().setInputCol("d10Indexer").setOutputCol("d10Vec");
			indexers.add(d10Indexer);
			indexers.add(d10Vec);
		//	assemblers.add("d10");
		}
		
		if(ArrayUtils.contains(trainingDataConverted.columns(),"d10_poa"))
		{		
			Row d1Max = sparkSession.sql("SELECT d10_poa, COUNT(d10_poa) as d1_ct from TrainingTable group by d10_poa order by d1_ct desc").first();
			String d1MaxValue = d1Max.getAs("d10_poa");
			trainingDataConverted = trainingDataConverted.na().fill(d1MaxValue, new String[] {"d10_poa"});
			StringIndexer d10poaIndexer = new StringIndexer().setInputCol("d10_poa").setOutputCol("d10poaIndexer");
			OneHotEncoder d10poaVec = new OneHotEncoder().setInputCol("d10poaIndexer").setOutputCol("d10poaVec");
			indexers.add(d10poaIndexer);
			indexers.add(d10poaVec);
		//	assemblers.add("d10_poa");
		}
		
		if(ArrayUtils.contains(trainingDataConverted.columns(),"d11"))
		{		
			Row d1Max = sparkSession.sql("SELECT d11, COUNT(d11) as d1_ct from TrainingTable group by d11 order by d1_ct desc").first();
			String d1MaxValue = d1Max.getAs("d11");
			trainingDataConverted = trainingDataConverted.na().fill(d1MaxValue, new String[] {"d11"});
			StringIndexer d11Indexer = new StringIndexer().setInputCol("d11").setOutputCol("d11Indexer");
			OneHotEncoder d11Vec = new OneHotEncoder().setInputCol("d11Indexer").setOutputCol("d11Vec");
			indexers.add(d11Indexer);
			indexers.add(d11Vec);
		//	assemblers.add("d11");
		}
		
		if(ArrayUtils.contains(trainingDataConverted.columns(),"d11_poa"))
		{		
			Row d1Max = sparkSession.sql("SELECT d11_poa, COUNT(d11_poa) as d1_ct from TrainingTable group by d11_poa order by d1_ct desc").first();
			String d1MaxValue = d1Max.getAs("d11_poa");
			trainingDataConverted = trainingDataConverted.na().fill(d1MaxValue, new String[] {"d11_poa"});
			StringIndexer d11poaIndexer = new StringIndexer().setInputCol("d11_poa").setOutputCol("d11poaIndexer");
			OneHotEncoder d11poaVec = new OneHotEncoder().setInputCol("d11poaIndexer").setOutputCol("d11poaVec");
			indexers.add(d11poaIndexer);
			indexers.add(d11poaVec);
		//	assemblers.add("d11_poa");
		}
		
		if(ArrayUtils.contains(trainingDataConverted.columns(),"d12"))
		{		
			Row d1Max = sparkSession.sql("SELECT d12, COUNT(d12) as d1_ct from TrainingTable group by d12 order by d1_ct desc").first();
			String d1MaxValue = d1Max.getAs("d12");
			trainingDataConverted = trainingDataConverted.na().fill(d1MaxValue, new String[] {"d12"});
			StringIndexer d12Indexer = new StringIndexer().setInputCol("d12").setOutputCol("d12Indexer");
			OneHotEncoder d12Vec = new OneHotEncoder().setInputCol("d12Indexer").setOutputCol("d12Vec");
			indexers.add(d12Indexer);
			indexers.add(d12Vec);
		//	assemblers.add("d12");
		}
		
		if(ArrayUtils.contains(trainingDataConverted.columns(),"d12_poa"))
		{		
			Row d1Max = sparkSession.sql("SELECT d12_poa, COUNT(d12_poa) as d1_ct from TrainingTable group by d12_poa order by d1_ct desc").first();
			String d1MaxValue = d1Max.getAs("d12_poa");
			trainingDataConverted = trainingDataConverted.na().fill(d1MaxValue, new String[] {"d12_poa"});
			StringIndexer d12poaIndexer = new StringIndexer().setInputCol("d12_poa").setOutputCol("d12poaIndexer");
			OneHotEncoder d12poaVec = new OneHotEncoder().setInputCol("d12poaIndexer").setOutputCol("d12poaVec");
			indexers.add(d12poaIndexer);
			indexers.add(d12poaVec);
		//	assemblers.add("d12_poa");
		}
		
		if(ArrayUtils.contains(trainingDataConverted.columns(),"d13"))
		{		
			Row d1Max = sparkSession.sql("SELECT d13, COUNT(d13) as d1_ct from TrainingTable group by d13 order by d1_ct desc").first();
			String d1MaxValue = d1Max.getAs("d13");
			trainingDataConverted = trainingDataConverted.na().fill(d1MaxValue, new String[] {"d13"});
			StringIndexer d13Indexer = new StringIndexer().setInputCol("d13").setOutputCol("d13Indexer");
			OneHotEncoder d13Vec = new OneHotEncoder().setInputCol("d13Indexer").setOutputCol("d13Vec");
			indexers.add(d13Indexer);
			indexers.add(d13Vec);
	//		assemblers.add("d13");
		}
		
		if(ArrayUtils.contains(trainingDataConverted.columns(),"d13_poa"))
		{		
			Row d1Max = sparkSession.sql("SELECT d13_poa, COUNT(d13_poa) as d1_ct from TrainingTable group by d13_poa order by d1_ct desc").first();
			String d1MaxValue = d1Max.getAs("d13_poa");
			trainingDataConverted = trainingDataConverted.na().fill(d1MaxValue, new String[] {"d13_poa"});
			StringIndexer d13poaIndexer = new StringIndexer().setInputCol("d13_poa").setOutputCol("d13poaIndexer");
			OneHotEncoder d13poaVec = new OneHotEncoder().setInputCol("d13poaIndexer").setOutputCol("d13poaVec");
			indexers.add(d13poaIndexer);
			indexers.add(d13poaVec);
//			assemblers.add("d13_poa");
		}
		
		if(ArrayUtils.contains(trainingDataConverted.columns(),"d14"))
		{		
			Row d1Max = sparkSession.sql("SELECT d14, COUNT(d14) as d1_ct from TrainingTable group by d14 order by d1_ct desc").first();
			String d1MaxValue = d1Max.getAs("d14");
			trainingDataConverted = trainingDataConverted.na().fill(d1MaxValue, new String[] {"d14"});
			StringIndexer d14Indexer = new StringIndexer().setInputCol("d14").setOutputCol("d14Indexer");
			OneHotEncoder d14Vec = new OneHotEncoder().setInputCol("d14Indexer").setOutputCol("d14Vec");
			indexers.add(d14Indexer);
			indexers.add(d14Vec);
		//	assemblers.add("d14");
		}
		
		if(ArrayUtils.contains(trainingDataConverted.columns(),"d14_poa"))
		{		
			Row d1Max = sparkSession.sql("SELECT d14_poa, COUNT(d14_poa) as d1_ct from TrainingTable group by d14_poa order by d1_ct desc").first();
			String d1MaxValue = d1Max.getAs("d14_poa");
			trainingDataConverted = trainingDataConverted.na().fill(d1MaxValue, new String[] {"d14_poa"});
			StringIndexer d14poaIndexer = new StringIndexer().setInputCol("d14_poa").setOutputCol("d14poaIndexer");
			OneHotEncoder d14poaVec = new OneHotEncoder().setInputCol("d14poaIndexer").setOutputCol("d14poaVec");
			indexers.add(d14poaIndexer);
			indexers.add(d14poaVec);
		//	assemblers.add("d14_poa");
		}
		
		if(ArrayUtils.contains(trainingDataConverted.columns(),"d15"))
		{		
			Row d1Max = sparkSession.sql("SELECT d15, COUNT(d15) as d1_ct from TrainingTable group by d15 order by d1_ct desc").first();
			String d1MaxValue = d1Max.getAs("d15");
			trainingDataConverted = trainingDataConverted.na().fill(d1MaxValue, new String[] {"d15"});
			StringIndexer d15Indexer = new StringIndexer().setInputCol("d15").setOutputCol("d15Indexer");
			OneHotEncoder d15Vec = new OneHotEncoder().setInputCol("d15Indexer").setOutputCol("d15Vec");
			indexers.add(d15Indexer);
			indexers.add(d15Vec);
		//	assemblers.add("d15");
		}
		
		if(ArrayUtils.contains(trainingDataConverted.columns(),"d15_poa"))
		{		
			Row d1Max = sparkSession.sql("SELECT d15_poa, COUNT(d15_poa) as d1_ct from TrainingTable group by d15_poa order by d1_ct desc").first();
			String d1MaxValue = d1Max.getAs("d15_poa");
			trainingDataConverted = trainingDataConverted.na().fill(d1MaxValue, new String[] {"d15_poa"});
			StringIndexer d15poaIndexer = new StringIndexer().setInputCol("d15_poa").setOutputCol("d15poaIndexer");
			OneHotEncoder d15poaVec = new OneHotEncoder().setInputCol("d15poaIndexer").setOutputCol("d15poaVec");
			indexers.add(d15poaIndexer);
			indexers.add(d15poaVec);
		//	assemblers.add("d15_poa");
		}
		
		if(ArrayUtils.contains(trainingDataConverted.columns(),"d16"))
		{		
			Row d1Max = sparkSession.sql("SELECT d16, COUNT(d16) as d1_ct from TrainingTable group by d16 order by d1_ct desc").first();
			String d1MaxValue = d1Max.getAs("d16");
			trainingDataConverted = trainingDataConverted.na().fill(d1MaxValue, new String[] {"d16"});
			StringIndexer d16Indexer = new StringIndexer().setInputCol("d16").setOutputCol("d16Indexer");
			OneHotEncoder d16Vec = new OneHotEncoder().setInputCol("d16Indexer").setOutputCol("d16Vec");
			indexers.add(d16Indexer);
			indexers.add(d16Vec);
		//	assemblers.add("d16");
		}
		
		if(ArrayUtils.contains(trainingDataConverted.columns(),"d16_poa"))
		{		
			Row d1Max = sparkSession.sql("SELECT d16_poa, COUNT(d16_poa) as d1_ct from TrainingTable group by d16_poa order by d1_ct desc").first();
			String d1MaxValue = d1Max.getAs("d16_poa");
			trainingDataConverted = trainingDataConverted.na().fill(d1MaxValue, new String[] {"d16_poa"});
			StringIndexer d16poaIndexer = new StringIndexer().setInputCol("d16_poa").setOutputCol("d16poaIndexer");
			OneHotEncoder d16poaVec = new OneHotEncoder().setInputCol("d16poaIndexer").setOutputCol("d16poaVec");
			indexers.add(d16poaIndexer);
			indexers.add(d16poaVec);
		//	assemblers.add("d16_poa");
		}
		
		if(ArrayUtils.contains(trainingDataConverted.columns(),"d17"))
		{		
			Row d1Max = sparkSession.sql("SELECT d17, COUNT(d17) as d1_ct from TrainingTable group by d17 order by d1_ct desc").first();
			String d1MaxValue = d1Max.getAs("d17");
			trainingDataConverted = trainingDataConverted.na().fill(d1MaxValue, new String[] {"d17"});
			StringIndexer d17Indexer = new StringIndexer().setInputCol("d17").setOutputCol("d17Indexer");
			OneHotEncoder d17Vec = new OneHotEncoder().setInputCol("d17Indexer").setOutputCol("d17Vec");
			indexers.add(d17Indexer);
			indexers.add(d17Vec);
		//	assemblers.add("d17");
		}
		
		if(ArrayUtils.contains(trainingDataConverted.columns(),"d17_poa"))
		{		
			Row d1Max = sparkSession.sql("SELECT d17_poa, COUNT(d17_poa) as d1_ct from TrainingTable group by d17_poa order by d1_ct desc").first();
			String d1MaxValue = d1Max.getAs("d17_poa");
			trainingDataConverted = trainingDataConverted.na().fill(d1MaxValue, new String[] {"d17_poa"});
			StringIndexer d17poaIndexer = new StringIndexer().setInputCol("d17_poa").setOutputCol("d17poaIndexer");
			OneHotEncoder d17poaVec = new OneHotEncoder().setInputCol("d17poaIndexer").setOutputCol("d17poaVec");
			indexers.add(d17poaIndexer);
			indexers.add(d17poaVec);
		//	assemblers.add("d17_poa");
		}
		
		if(ArrayUtils.contains(trainingDataConverted.columns(),"d18"))
		{		
			Row d1Max = sparkSession.sql("SELECT d18, COUNT(d18) as d1_ct from TrainingTable group by d18 order by d1_ct desc").first();
			String d1MaxValue = d1Max.getAs("d18");
			trainingDataConverted = trainingDataConverted.na().fill(d1MaxValue, new String[] {"d18"});
			StringIndexer d18Indexer = new StringIndexer().setInputCol("d18").setOutputCol("d18Indexer");
			OneHotEncoder d18Vec = new OneHotEncoder().setInputCol("d18Indexer").setOutputCol("d18Vec");
			indexers.add(d18Indexer);
			indexers.add(d18Vec);
		//	assemblers.add("d18");
		}
		
		if(ArrayUtils.contains(trainingDataConverted.columns(),"d18_poa"))
		{		
			Row d1Max = sparkSession.sql("SELECT d18_poa, COUNT(d18_poa) as d1_ct from TrainingTable group by d18_poa order by d1_ct desc").first();
			String d1MaxValue = d1Max.getAs("d18_poa");
			trainingDataConverted = trainingDataConverted.na().fill(d1MaxValue, new String[] {"d18_poa"});
			StringIndexer d18poaIndexer = new StringIndexer().setInputCol("d18_poa").setOutputCol("d18poaIndexer");
			OneHotEncoder d18poaVec = new OneHotEncoder().setInputCol("d18poaIndexer").setOutputCol("d18poaVec");
			indexers.add(d18poaIndexer);
			indexers.add(d18poaVec);
		//	assemblers.add("d18_poa");
		}
		
		if(ArrayUtils.contains(trainingDataConverted.columns(),"d19"))
		{		
			Row d1Max = sparkSession.sql("SELECT d19, COUNT(d19) as d1_ct from TrainingTable group by d19 order by d1_ct desc").first();
			String d1MaxValue = d1Max.getAs("d19");
			trainingDataConverted = trainingDataConverted.na().fill(d1MaxValue, new String[] {"d19"});
			StringIndexer d19Indexer = new StringIndexer().setInputCol("d19").setOutputCol("d19Indexer");
			OneHotEncoder d19Vec = new OneHotEncoder().setInputCol("d19Indexer").setOutputCol("d19Vec");
			indexers.add(d19Indexer);
			indexers.add(d19Vec);
		//	assemblers.add("d19");
		}
		
		if(ArrayUtils.contains(trainingDataConverted.columns(),"d19_poa"))
		{		
			Row d1Max = sparkSession.sql("SELECT d19_poa, COUNT(d19_poa) as d1_ct from TrainingTable group by d19_poa order by d1_ct desc").first();
			String d1MaxValue = d1Max.getAs("d19_poa");
			trainingDataConverted = trainingDataConverted.na().fill(d1MaxValue, new String[] {"d19_poa"});
			StringIndexer d19poaIndexer = new StringIndexer().setInputCol("d19_poa").setOutputCol("d19poaIndexer");
			OneHotEncoder d19poaVec = new OneHotEncoder().setInputCol("d19poaIndexer").setOutputCol("d19poaVec");
			indexers.add(d19poaIndexer);
			indexers.add(d19poaVec);
	//		assemblers.add("d19_poa");
		}
		
		if(ArrayUtils.contains(trainingDataConverted.columns(),"d20"))
		{		
			Row d1Max = sparkSession.sql("SELECT d20, COUNT(d20) as d1_ct from TrainingTable group by d20 order by d1_ct desc").first();
			String d1MaxValue = d1Max.getAs("d20");
			trainingDataConverted = trainingDataConverted.na().fill(d1MaxValue, new String[] {"d20"});
			StringIndexer d20Indexer = new StringIndexer().setInputCol("d20").setOutputCol("d20Indexer");
			OneHotEncoder d20Vec = new OneHotEncoder().setInputCol("d20Indexer").setOutputCol("d20Vec");
			indexers.add(d20Indexer);
			indexers.add(d20Vec);
		//	assemblers.add("d20");
		}
		
		if(ArrayUtils.contains(trainingDataConverted.columns(),"d20_poa"))
		{		
			Row d1Max = sparkSession.sql("SELECT d20_poa, COUNT(d20_poa) as d1_ct from TrainingTable group by d20_poa order by d1_ct desc").first();
			String d1MaxValue = d1Max.getAs("d20_poa");
			trainingDataConverted = trainingDataConverted.na().fill(d1MaxValue, new String[] {"d20_poa"});
			StringIndexer d20poaIndexer = new StringIndexer().setInputCol("d20_poa").setOutputCol("d20poaIndexer");
			OneHotEncoder d20poaVec = new OneHotEncoder().setInputCol("d20poaIndexer").setOutputCol("d20poaVec");
			indexers.add(d20poaIndexer);
			indexers.add(d20poaVec);
//			assemblers.add("d20_poa");
		}
		
		if(ArrayUtils.contains(trainingDataConverted.columns(),"d21"))
		{		
			Row d1Max = sparkSession.sql("SELECT d21, COUNT(d21) as d1_ct from TrainingTable group by d21 order by d1_ct desc").first();
			String d1MaxValue = d1Max.getAs("d21");
			trainingDataConverted = trainingDataConverted.na().fill(d1MaxValue, new String[] {"d21"});
			StringIndexer d21Indexer = new StringIndexer().setInputCol("d21").setOutputCol("d21Indexer");
			OneHotEncoder d21Vec = new OneHotEncoder().setInputCol("d21Indexer").setOutputCol("d21Vec");
			indexers.add(d21Indexer);
			indexers.add(d21Vec);
		//	assemblers.add("d21");
		}
		
		if(ArrayUtils.contains(trainingDataConverted.columns(),"d21_poa"))
		{		
			Row d1Max = sparkSession.sql("SELECT d21_poa, COUNT(d21_poa) as d1_ct from TrainingTable group by d21_poa order by d1_ct desc").first();
			String d1MaxValue = d1Max.getAs("d21_poa");
			trainingDataConverted = trainingDataConverted.na().fill(d1MaxValue, new String[] {"d21_poa"});
			StringIndexer d21poaIndexer = new StringIndexer().setInputCol("d21_poa").setOutputCol("d21poaIndexer");
			OneHotEncoder d21poaVec = new OneHotEncoder().setInputCol("d21poaIndexer").setOutputCol("d21poaVec");
			indexers.add(d21poaIndexer);
			indexers.add(d21poaVec);
		//	assemblers.add("d21_poa");
		}
		
		if(ArrayUtils.contains(trainingDataConverted.columns(),"d22"))
		{		
			Row d1Max = sparkSession.sql("SELECT d22, COUNT(d22) as d1_ct from TrainingTable group by d22 order by d1_ct desc").first();
			String d1MaxValue = d1Max.getAs("d22");
			trainingDataConverted = trainingDataConverted.na().fill(d1MaxValue, new String[] {"d22"});
			StringIndexer d22Indexer = new StringIndexer().setInputCol("d22").setOutputCol("d22Indexer");
			OneHotEncoder d22Vec = new OneHotEncoder().setInputCol("d22Indexer").setOutputCol("d22Vec");
			indexers.add(d22Indexer);
			indexers.add(d22Vec);
	//		assemblers.add("d22");
		}
		
		if(ArrayUtils.contains(trainingDataConverted.columns(),"d22_poa"))
		{		
			Row d1Max = sparkSession.sql("SELECT d22_poa, COUNT(d22_poa) as d1_ct from TrainingTable group by d22_poa order by d1_ct desc").first();
			String d1MaxValue = d1Max.getAs("d22_poa");
			trainingDataConverted = trainingDataConverted.na().fill(d1MaxValue, new String[] {"d22_poa"});
			StringIndexer d22poaIndexer = new StringIndexer().setInputCol("d22_poa").setOutputCol("d22poaIndexer");
			OneHotEncoder d22poaVec = new OneHotEncoder().setInputCol("d22poaIndexer").setOutputCol("d22poaVec");
			indexers.add(d22poaIndexer);
			indexers.add(d22poaVec);
	//		assemblers.add("d22_poa");
		}
		
		if(ArrayUtils.contains(trainingDataConverted.columns(),"d23"))
		{		
			Row d1Max = sparkSession.sql("SELECT d23, COUNT(d23) as d1_ct from TrainingTable group by d23 order by d1_ct desc").first();
			String d1MaxValue = d1Max.getAs("d23");
			trainingDataConverted = trainingDataConverted.na().fill(d1MaxValue, new String[] {"d23"});
			StringIndexer d23ndexer = new StringIndexer().setInputCol("d23").setOutputCol("d23Indexer");
			OneHotEncoder d23Vec = new OneHotEncoder().setInputCol("d23Indexer").setOutputCol("d23Vec");
			indexers.add(d23ndexer);
			indexers.add(d23Vec);
		//	assemblers.add("d23");
		}
		
		if(ArrayUtils.contains(trainingDataConverted.columns(),"d23_poa"))
		{		
			Row d1Max = sparkSession.sql("SELECT d23_poa, COUNT(d23_poa) as d1_ct from TrainingTable group by d23_poa order by d1_ct desc").first();
			String d1MaxValue = d1Max.getAs("d23_poa");
			trainingDataConverted = trainingDataConverted.na().fill(d1MaxValue, new String[] {"d23_poa"});
			StringIndexer d23poaIndexer = new StringIndexer().setInputCol("d23_poa").setOutputCol("d23poaIndexer");
			OneHotEncoder d23poaVec = new OneHotEncoder().setInputCol("d23poaIndexer").setOutputCol("d23poaVec");
			indexers.add(d23poaIndexer);
			indexers.add(d23poaVec);
	//		assemblers.add("d23_poa");
		}
		
		if(ArrayUtils.contains(trainingDataConverted.columns(),"d24"))
		{		
			List<Row> d1Max = sparkSession.sql("SELECT d24, COUNT(d24) as d1_ct from TrainingTable group by d24 order by d1_ct desc").takeAsList(2);
			if(null!=d1Max && !d1Max.isEmpty() && d1Max.size()>1 && null!=d1Max.get(1).getAs("d24"))
			{
				Row row = d1Max.get(0);
			String d1MaxValue = row.getAs("d24");
			trainingDataConverted = trainingDataConverted.na().fill(d1MaxValue, new String[] {"d24"});
			StringIndexer d24Indexer = new StringIndexer().setInputCol("d24").setOutputCol("d24Indexer");
			OneHotEncoder d24Vec = new OneHotEncoder().setInputCol("d24Indexer").setOutputCol("d24Vec");
			indexers.add(d24Indexer);
			indexers.add(d24Vec);
		//	assemblers.add("d24");
			}
		}
		
		if(ArrayUtils.contains(trainingDataConverted.columns(),"d24_poa"))
		{		
			List<Row> d1Max = sparkSession.sql("SELECT d24_poa, COUNT(d24_poa) as d1_ct from TrainingTable group by d24_poa order by d1_ct desc").takeAsList(2);
			System.out.println("d24poaIndexer:"+d1Max);
			if(null!=d1Max && !d1Max.isEmpty() && d1Max.size()>1 && null!=d1Max.get(1).getAs("d24_poa"))
			{
				Row row = d1Max.get(0);
			String d1MaxValue = row.getAs("d24_poa");
			trainingDataConverted = trainingDataConverted.na().fill(d1MaxValue, new String[] {"d24_poa"});
			StringIndexer d24poaIndexer = new StringIndexer().setInputCol("d24_poa").setOutputCol("d24poaIndexer");
			OneHotEncoder d24poaVec = new OneHotEncoder().setInputCol("d24poaIndexer").setOutputCol("d24poaVec");
			indexers.add(d24poaIndexer);
			indexers.add(d24poaVec);
	//		assemblers.add("d24_poa");
			}
		}
		//Other Diag codes - Ends		
		
		
		//Other Procedure codes - Starts	
				if(ArrayUtils.contains(trainingDataConverted.columns(),"p1"))
				{		
					List<Row> d1Max = sparkSession.sql("SELECT p1, COUNT(p1) as d1_ct from TrainingTable group by p1 order by d1_ct desc").takeAsList(2);
					if(null!=d1Max && !d1Max.isEmpty() && d1Max.size()>1 && null!=d1Max.get(1).getAs("p1"))
					{
						Row row = d1Max.get(0);
					String d1MaxValue = row.getAs("p1");
					trainingDataConverted = trainingDataConverted.na().fill(d1MaxValue, new String[] {"p1"});
					StringIndexer p1Indexer = new StringIndexer().setInputCol("p1").setOutputCol("p1Indexer");
					OneHotEncoder p1Vec = new OneHotEncoder().setInputCol("p1Indexer").setOutputCol("p1Vec");
					indexers.add(p1Indexer);
					indexers.add(p1Vec);
				////	assemblers.add("p1");
					}
				}
				if(ArrayUtils.contains(trainingDataConverted.columns(),"p2"))
				{		
					List<Row> d1Max = sparkSession.sql("SELECT p2, COUNT(p2) as d1_ct from TrainingTable group by p2 order by d1_ct desc").takeAsList(2);
					if(null!=d1Max && !d1Max.isEmpty() && d1Max.size()>1 && null!=d1Max.get(1).getAs("p2"))
					{
						Row row = d1Max.get(0);
					String d1MaxValue = row.getAs("p2");
					trainingDataConverted = trainingDataConverted.na().fill(d1MaxValue, new String[] {"p2"});
					StringIndexer p2Indexer = new StringIndexer().setInputCol("p2").setOutputCol("p2Indexer");
					OneHotEncoder p2Vec = new OneHotEncoder().setInputCol("p2Indexer").setOutputCol("p2Vec");
					indexers.add(p2Indexer);
					indexers.add(p2Vec);
				//	assemblers.add("p2");
					}
				}
				if(ArrayUtils.contains(trainingDataConverted.columns(),"p3"))
				{		
					List<Row> d1Max = sparkSession.sql("SELECT p3, COUNT(p3) as d1_ct from TrainingTable group by p3 order by d1_ct desc").takeAsList(2);
					if(null!=d1Max && !d1Max.isEmpty() && d1Max.size()>1 && null!=d1Max.get(1).getAs("p3"))
					{
						Row row = d1Max.get(0);
					String d1MaxValue = row.getAs("p3");
					trainingDataConverted = trainingDataConverted.na().fill(d1MaxValue, new String[] {"p3"});
				StringIndexer p3Indexer = new StringIndexer().setInputCol("p3").setOutputCol("p3Indexer");
					OneHotEncoder p3Vec = new OneHotEncoder().setInputCol("p3Indexer").setOutputCol("p3Vec");
					indexers.add(p3Indexer);
					indexers.add(p3Vec);
				//	assemblers.add("p3");
					}
				}
				if(ArrayUtils.contains(trainingDataConverted.columns(),"p4"))
				{		
					List<Row> d1Max = sparkSession.sql("SELECT p4, COUNT(p4) as d1_ct from TrainingTable group by p4 order by d1_ct desc").takeAsList(2);
					if(null!=d1Max && !d1Max.isEmpty() && d1Max.size()>1 && null!=d1Max.get(1).getAs("p4"))
					{
						Row row = d1Max.get(0);
					String d1MaxValue = row.getAs("p4");
					trainingDataConverted = trainingDataConverted.na().fill(d1MaxValue, new String[] {"p4"});
					StringIndexer p4Indexer = new StringIndexer().setInputCol("p4").setOutputCol("p4Indexer");
					OneHotEncoder p4Vec = new OneHotEncoder().setInputCol("p4Indexer").setOutputCol("p4Vec");
					indexers.add(p4Indexer);
					indexers.add(p4Vec);
					//assemblers.add("p4");
					}
				}
				if(ArrayUtils.contains(trainingDataConverted.columns(),"p5"))
				{		
					List<Row> d1Max = sparkSession.sql("SELECT p5, COUNT(p5) as d1_ct from TrainingTable group by p5 order by d1_ct desc").takeAsList(2);
					if(null!=d1Max && !d1Max.isEmpty() && d1Max.size()>1 && null!=d1Max.get(1).getAs("p5"))
					{
						Row row = d1Max.get(0);
					String d1MaxValue = row.getAs("p5");
					trainingDataConverted = trainingDataConverted.na().fill(d1MaxValue, new String[] {"p5"});
					StringIndexer p5Indexer = new StringIndexer().setInputCol("p5").setOutputCol("p5Indexer");
					OneHotEncoder p5Vec = new OneHotEncoder().setInputCol("p5Indexer").setOutputCol("p5Vec");
					indexers.add(p5Indexer);
					indexers.add(p5Vec);
					//assemblers.add("p5");
					}
				}
				if(ArrayUtils.contains(trainingDataConverted.columns(),"p6"))
				{		
					List<Row> d1Max = sparkSession.sql("SELECT p6, COUNT(p6) as d1_ct from TrainingTable group by p6 order by d1_ct desc").takeAsList(2);
					if(null!=d1Max && !d1Max.isEmpty() && d1Max.size()>1 && null!=d1Max.get(1).getAs("p6"))
					{
						Row row = d1Max.get(0);
					String d1MaxValue = row.getAs("p6");
					trainingDataConverted = trainingDataConverted.na().fill(d1MaxValue, new String[] {"p6"});
					StringIndexer p6Indexer = new StringIndexer().setInputCol("p6").setOutputCol("p6Indexer");
					OneHotEncoder p6Vec = new OneHotEncoder().setInputCol("p6Indexer").setOutputCol("p6Vec");
					indexers.add(p6Indexer);
					indexers.add(p6Vec);
				//	assemblers.add("p6");
					}
				}
				if(ArrayUtils.contains(trainingDataConverted.columns(),"p7"))
				{		
					List<Row> d1Max = sparkSession.sql("SELECT p7, COUNT(p7) as d1_ct from TrainingTable group by p7 order by d1_ct desc").takeAsList(2);
					if(null!=d1Max && !d1Max.isEmpty() && d1Max.size()>1 && null!=d1Max.get(1).getAs("p7"))
					{
						Row row = d1Max.get(0);
					String d1MaxValue = row.getAs("p7");
					trainingDataConverted = trainingDataConverted.na().fill(d1MaxValue, new String[] {"p7"});
					StringIndexer p7Indexer = new StringIndexer().setInputCol("p7").setOutputCol("p7Indexer");
					OneHotEncoder p7Vec = new OneHotEncoder().setInputCol("p7Indexer").setOutputCol("p7Vec");
					indexers.add(p7Indexer);
					indexers.add(p7Vec);
				//	assemblers.add("p7");
					}
				}
				if(ArrayUtils.contains(trainingDataConverted.columns(),"p8"))
				{		
					List<Row> d1Max = sparkSession.sql("SELECT p8, COUNT(p8) as d1_ct from TrainingTable group by p8 order by d1_ct desc").takeAsList(2);
					System.out.println("p8Indexer:"+ d1Max);
					if(null!=d1Max && !d1Max.isEmpty() && d1Max.size()>1 && null!=d1Max.get(1).getAs("p8"))
					{
						Row row = d1Max.get(0);
					String d1MaxValue = row.getAs("p8");
					trainingDataConverted = trainingDataConverted.na().fill(d1MaxValue, new String[] {"p8"});
					StringIndexer p8Indexer = new StringIndexer().setInputCol("p8").setOutputCol("p8Indexer");
					OneHotEncoder p8Vec = new OneHotEncoder().setInputCol("p8Indexer").setOutputCol("p8Vec");
					indexers.add(p8Indexer);
					indexers.add(p8Vec);
					//assemblers.add("p8");
					}
				}
				if(ArrayUtils.contains(trainingDataConverted.columns(),"p9"))
				{		
					List<Row> d1Max = sparkSession.sql("SELECT p9, COUNT(p9) as d1_ct from TrainingTable group by p9 order by d1_ct desc").takeAsList(2);
					System.out.println("p9Indexer "+d1Max);
					if(null!=d1Max && !d1Max.isEmpty() && d1Max.size()>1 && null!=d1Max.get(1).getAs("p9"))
					{
						Row row = d1Max.get(0);
						String d1MaxValue = row.getAs("p9");
						trainingDataConverted = trainingDataConverted = trainingDataConverted.na().fill(d1MaxValue, new String[] {"p9"});
						StringIndexer p9Indexer = new StringIndexer().setInputCol("p9").setOutputCol("p9Indexer");
						OneHotEncoder p9Vec = new OneHotEncoder().setInputCol("p9Indexer").setOutputCol("p9Vec");
						indexers.add(p9Indexer);
						indexers.add(p9Vec);
					//	assemblers.add("p9");
					}
					else
					{
						trainingDataConverted = trainingDataConverted.drop("p9");
					}
				}
				if(ArrayUtils.contains(trainingDataConverted.columns(),"p10"))
				{		
					List<Row> d1Max = sparkSession.sql("SELECT p10, COUNT(p10) as d1_ct from TrainingTable group by p10 order by d1_ct desc").takeAsList(2);
					if(null!=d1Max && !d1Max.isEmpty() && d1Max.size()>1 && null!=d1Max.get(1).getAs("p10"))
					{
						Row row = d1Max.get(0);
					String d1MaxValue = row.getAs("p10");
					trainingDataConverted = trainingDataConverted.na().fill(d1MaxValue, new String[] {"p10"});
					StringIndexer p10Indexer = new StringIndexer().setInputCol("p10").setOutputCol("p10Indexer");
					OneHotEncoder p10Vec = new OneHotEncoder().setInputCol("p10Indexer").setOutputCol("p10Vec");
					indexers.add(p10Indexer);
					indexers.add(p10Vec);
				//	assemblers.add("p10");
					}
					else
					{
						trainingDataConverted = trainingDataConverted.drop("p10");
					}
				}
				if(ArrayUtils.contains(trainingDataConverted.columns(),"p11"))
				{		
					List<Row> d1Max = sparkSession.sql("SELECT p11, COUNT(p11) as d1_ct from TrainingTable group by p11 order by d1_ct desc").takeAsList(2);
					if(null!=d1Max && !d1Max.isEmpty() && d1Max.size()>1 && null!=d1Max.get(1).getAs("p11"))
					{
						Row row = d1Max.get(0);
					String d1MaxValue = row.getAs("p11");
					trainingDataConverted = trainingDataConverted.na().fill(d1MaxValue, new String[] {"p11"});
					StringIndexer p11Indexer = new StringIndexer().setInputCol("p11").setOutputCol("p11Indexer");
					OneHotEncoder p11Vec = new OneHotEncoder().setInputCol("p11Indexer").setOutputCol("p11Vec");
					indexers.add(p11Indexer);
					indexers.add(p11Vec);
				//	assemblers.add("p11");
					}
					else
					{
						trainingDataConverted = trainingDataConverted.drop("p11");
					}
				}
				if(ArrayUtils.contains(trainingDataConverted.columns(),"p12"))
				{		
					List<Row> d1Max = sparkSession.sql("SELECT p12, COUNT(p12) as d1_ct from TrainingTable group by p12 order by d1_ct desc").takeAsList(2);
					System.out.println("p12Indexer:"+d1Max);
					if(null!=d1Max && !d1Max.isEmpty() && d1Max.size()>1 && null!=d1Max.get(1).getAs("p12"))
					{
						Row row = d1Max.get(0);
					String d1MaxValue = row.getAs("p12");
					trainingDataConverted = trainingDataConverted.na().fill(d1MaxValue, new String[] {"p12"});
					StringIndexer p12Indexer = new StringIndexer().setInputCol("p12").setOutputCol("p12Indexer");
					OneHotEncoder p12Vec = new OneHotEncoder().setInputCol("p12Indexer").setOutputCol("p12Vec");
					indexers.add(p12Indexer);
					indexers.add(p12Vec);
					//assemblers.add("p12");
					}
					else
					{
						trainingDataConverted = trainingDataConverted.drop("p12");
					}
				}
				if(ArrayUtils.contains(trainingDataConverted.columns(),"p13"))
				{		
					List<Row> d1Max = sparkSession.sql("SELECT p13, COUNT(p13) as d1_ct from TrainingTable group by p13 order by d1_ct desc").takeAsList(2);
					System.out.println("p13 indexser:"+d1Max);
					if(null!=d1Max && !d1Max.isEmpty() && d1Max.size()>1 && null!=d1Max.get(1).getAs("p13"))
					{
						Row row = d1Max.get(0);
					String d1MaxValue = row.getAs("p13");
					trainingDataConverted = trainingDataConverted.na().fill(d1MaxValue, new String[] {"p13"});
					StringIndexer p13Indexer = new StringIndexer().setInputCol("p13").setOutputCol("p13Indexer");
					OneHotEncoder p13Vec = new OneHotEncoder().setInputCol("p13Indexer").setOutputCol("p13Vec");
					indexers.add(p13Indexer);
					indexers.add(p13Vec);
				//	assemblers.add("p13");
					}
					else
					{
						trainingDataConverted = trainingDataConverted.drop("p13");
					}
				}
				if(ArrayUtils.contains(trainingDataConverted.columns(),"p14"))
				{		
					List<Row> d1Max = sparkSession.sql("SELECT p14, COUNT(p14) as d1_ct from TrainingTable group by p14 order by d1_ct desc").takeAsList(2);
					if(null!=d1Max && !d1Max.isEmpty() && d1Max.size()>1 && null!=d1Max.get(1).getAs("p14"))
					{
						Row row = d1Max.get(0);
					String d1MaxValue = row.getAs("p14");
					trainingDataConverted = trainingDataConverted.na().fill(d1MaxValue, new String[] {"p14"});
					StringIndexer p14Indexer = new StringIndexer().setInputCol("p14").setOutputCol("p14Indexer");
					OneHotEncoder p14Vec = new OneHotEncoder().setInputCol("p14Indexer").setOutputCol("p14Vec");
					indexers.add(p14Indexer);
					indexers.add(p14Vec);
			//		assemblers.add("p14");
					}
					else
					{
						trainingDataConverted = trainingDataConverted.drop("p14");
					}
				}
				if(ArrayUtils.contains(trainingDataConverted.columns(),"p15"))
				{		
					List<Row> d1Max = sparkSession.sql("SELECT p15, COUNT(p15) as d1_ct from TrainingTable group by p15 order by d1_ct desc").takeAsList(2);
					System.out.println("d1Max List size:" + d1Max.size());
					System.out.println("d1Max List size:" + d1Max);
					if(null!=d1Max && !d1Max.isEmpty() && d1Max.size()>1 && null!=d1Max.get(1).getAs("p15"))
					{
						Row row = d1Max.get(0);
						String d1MaxValue = row.getAs("p15");
						System.out.println("p15Indexer va:" + d1MaxValue);
						trainingDataConverted = trainingDataConverted.na().fill(d1MaxValue, new String[] {"p15"});
						trainingDataConverted.select("p15").show();
						StringIndexer p15Indexer = new StringIndexer().setInputCol("p15").setOutputCol("p15Indexer");
						OneHotEncoder p15Vec = new OneHotEncoder().setInputCol("p15Indexer").setOutputCol("p15Vec");
						indexers.add(p15Indexer);
						indexers.add(p15Vec);
					//	assemblers.add("p15");
					}
					else
					{
						trainingDataConverted = trainingDataConverted.drop("p15");
					}
				}
				if(ArrayUtils.contains(trainingDataConverted.columns(),"p16"))
				{		
					List<Row> d1Max = sparkSession.sql("SELECT p16, COUNT(p16) as d1_ct from TrainingTable group by p16 order by d1_ct desc").takeAsList(2);
					System.out.println("p16Indexer:"+d1Max);
					if(null!=d1Max && !d1Max.isEmpty() && d1Max.size()>1 && null!=d1Max.get(1).getAs("p16"))
					{
						Row row = d1Max.get(0);
					String d1MaxValue = row.getAs("p16");
					trainingDataConverted = trainingDataConverted.na().fill(d1MaxValue, new String[] {"p16"});
					StringIndexer p16Indexer = new StringIndexer().setInputCol("p16").setOutputCol("p16Indexer");
					OneHotEncoder p16Vec = new OneHotEncoder().setInputCol("p16Indexer").setOutputCol("p16Vec");
					indexers.add(p16Indexer);
					indexers.add(p16Vec);
				//	assemblers.add("p16");
					}
					else
					{
						trainingDataConverted = trainingDataConverted.drop("p16");
					}
				}
				if(ArrayUtils.contains(trainingDataConverted.columns(),"p17"))
				{		
					List<Row> d1Max = sparkSession.sql("SELECT p17, COUNT(p17) as d1_ct from TrainingTable group by p17 order by d1_ct desc").takeAsList(2);
					System.out.println("p17Indexer:"+d1Max);
					if(null!=d1Max && !d1Max.isEmpty() && d1Max.size()>1 && null!=d1Max.get(1).getAs("p17"))
					{
						Row row = d1Max.get(0);
					String d1MaxValue = row.getAs("p17");
					trainingDataConverted = trainingDataConverted.na().fill(d1MaxValue, new String[] {"p17"});
					StringIndexer p17Indexer = new StringIndexer().setInputCol("p17").setOutputCol("p17Indexer");
					OneHotEncoder p17Vec = new OneHotEncoder().setInputCol("p17Indexer").setOutputCol("p17Vec");
					indexers.add(p17Indexer);
					indexers.add(p17Vec);
				//	assemblers.add("p17");
					}
					else
					{
						trainingDataConverted = trainingDataConverted.drop("p17");
					}
					
				}
				if(ArrayUtils.contains(trainingDataConverted.columns(),"p18"))
				{		
					List<Row> d1Max = sparkSession.sql("SELECT p18, COUNT(p18) as d1_ct from TrainingTable group by p18 order by d1_ct desc").takeAsList(2);
					System.out.println("p18Indexer:" + d1Max);
					System.out.println("d1Max.get(1).getAs:" + StringUtils.isEmpty(d1Max.get(1).getAs("p18")));
					if(null!=d1Max && !d1Max.isEmpty() && d1Max.size()>1 && !StringUtils.isEmpty(d1Max.get(1).getAs("p18")))
					{
						Row row = d1Max.get(0);
					String d1MaxValue = row.getAs("p18");
					trainingDataConverted = trainingDataConverted.na().fill(d1MaxValue, new String[] {"p18"});
					StringIndexer p18Indexer = new StringIndexer().setInputCol("p18").setOutputCol("p18Indexer");
					OneHotEncoder p18Vec = new OneHotEncoder().setInputCol("p18Indexer").setOutputCol("p18Vec");
					indexers.add(p18Indexer);
					indexers.add(p18Vec);
				//	assemblers.add("p18");
					}
					else
					{
						trainingDataConverted = trainingDataConverted.drop("p18");
					}
				}
				if(ArrayUtils.contains(trainingDataConverted.columns(),"p19"))
				{		
					List<Row> d1Max = sparkSession.sql("SELECT p19, COUNT(p19) as d1_ct from TrainingTable group by p19 order by d1_ct desc").takeAsList(2);
					if(null!=d1Max && !d1Max.isEmpty() && d1Max.size()>1 && null!=d1Max.get(1).getAs("p19"))
					{
						Row row = d1Max.get(0);
					String d1MaxValue = row.getAs("p19");
					trainingDataConverted = trainingDataConverted.na().fill(d1MaxValue, new String[] {"p19"});
					StringIndexer p19Indexer = new StringIndexer().setInputCol("p19").setOutputCol("p19Indexer");
					OneHotEncoder p19Vec = new OneHotEncoder().setInputCol("p19Indexer").setOutputCol("p19Vec");
					indexers.add(p19Indexer);
					indexers.add(p19Vec);
				//	assemblers.add("p19");
					}
					else
					{
						trainingDataConverted = trainingDataConverted.drop("p19");
					}
				}
				if(ArrayUtils.contains(trainingDataConverted.columns(),"p20"))
				{		
					List<Row> d1Max = sparkSession.sql("SELECT p20, COUNT(p20) as d1_ct from TrainingTable group by p20 order by d1_ct desc").takeAsList(2);
					if(null!=d1Max && !d1Max.isEmpty() && d1Max.size()>1 && null!=d1Max.get(1).getAs("p20"))
					{
						Row row = d1Max.get(0);
					String d1MaxValue = row.getAs("p20");
					trainingDataConverted = trainingDataConverted.na().fill(d1MaxValue, new String[] {"p20"});
					StringIndexer p20Indexer = new StringIndexer().setInputCol("p20").setOutputCol("p20Indexer");
					OneHotEncoder p20Vec = new OneHotEncoder().setInputCol("p20Indexer").setOutputCol("p20Vec");
					indexers.add(p20Indexer);
					indexers.add(p20Vec);
			//		assemblers.add("p20");
					}
					else
					{
						trainingDataConverted = trainingDataConverted.drop("p20");
					}
				}
				if(ArrayUtils.contains(trainingDataConverted.columns(),"p21"))
				{		
					List<Row> d1Max = sparkSession.sql("SELECT p21, COUNT(p21) as d1_ct from TrainingTable group by p21 order by d1_ct desc").takeAsList(2);
					if(null!=d1Max && !d1Max.isEmpty() && d1Max.size()>1 && null!=d1Max.get(1).getAs("p21"))
					{
						Row row = d1Max.get(0);
					String d1MaxValue = row.getAs("p21");
					trainingDataConverted = trainingDataConverted.na().fill(d1MaxValue, new String[] {"p21"});
					StringIndexer p21Indexer = new StringIndexer().setInputCol("p21").setOutputCol("p21Indexer");
					OneHotEncoder p21Vec = new OneHotEncoder().setInputCol("p21Indexer").setOutputCol("p21Vec");
					indexers.add(p21Indexer);
					indexers.add(p21Vec);
				//	assemblers.add("p21");
					}
					else
					{
						trainingDataConverted = trainingDataConverted.drop("p21");
					}
				}
				if(ArrayUtils.contains(trainingDataConverted.columns(),"p22"))
				{		
					List<Row> d1Max = sparkSession.sql("SELECT p22, COUNT(p22) as d1_ct from TrainingTable group by p22 order by d1_ct desc").takeAsList(2);
					if(null!=d1Max && !d1Max.isEmpty() && d1Max.size()>1 && null!=d1Max.get(1).getAs("p22"))
					{
						Row row = d1Max.get(0);
					String d1MaxValue = row.getAs("p22");
					trainingDataConverted = trainingDataConverted.na().fill(d1MaxValue, new String[] {"p22"});
					StringIndexer p22Indexer = new StringIndexer().setInputCol("p22").setOutputCol("p22Indexer");
					OneHotEncoder p22Vec = new OneHotEncoder().setInputCol("p22Indexer").setOutputCol("p22Vec");
					indexers.add(p22Indexer);
					indexers.add(p22Vec);
				//	assemblers.add("p22");
					}
					else
					{
						trainingDataConverted = trainingDataConverted.drop("p22");
					}
				}
				if(ArrayUtils.contains(trainingDataConverted.columns(),"p23"))
				{		
					List<Row> d1Max = sparkSession.sql("SELECT p23, COUNT(p23) as d1_ct from TrainingTable group by p23 order by d1_ct desc").takeAsList(2);
					if(null!=d1Max && !d1Max.isEmpty() && d1Max.size()>1 && null!=d1Max.get(1).getAs("p23"))
					{
						Row row = d1Max.get(0);
					String d1MaxValue = row.getAs("p23");
					trainingDataConverted = trainingDataConverted.na().fill(d1MaxValue, new String[] {"p23"});
					StringIndexer p23Indexer = new StringIndexer().setInputCol("p23").setOutputCol("p23Indexer");
					OneHotEncoder p23Vec = new OneHotEncoder().setInputCol("p23Indexer").setOutputCol("p23Vec");
					indexers.add(p23Indexer);
					indexers.add(p23Vec);
				//	assemblers.add("p23");
					}
					else
					{
						trainingDataConverted = trainingDataConverted.drop("p23");
					}
				}
				if(ArrayUtils.contains(trainingDataConverted.columns(),"p24"))
				{		
					List<Row> d1Max = sparkSession.sql("SELECT p24, COUNT(p24) as d1_ct from TrainingTable group by p24 order by d1_ct desc").takeAsList(2);
					if(null!=d1Max && !d1Max.isEmpty() && d1Max.size()>1 && null!=d1Max.get(1).getAs("p24"))
					{
						Row row = d1Max.get(0);
					String d1MaxValue = row.getAs("p24");
					trainingDataConverted = trainingDataConverted.na().fill(d1MaxValue, new String[] {"p24"});
					StringIndexer p24Indexer = new StringIndexer().setInputCol("p24").setOutputCol("p24Indexer");
					OneHotEncoder p24Vec = new OneHotEncoder().setInputCol("p24Indexer").setOutputCol("p24Vec");
					indexers.add(p24Indexer);
					indexers.add(p24Vec);
			//		assemblers.add("p24");
					}
					else
					{
						trainingDataConverted = trainingDataConverted.drop("p24");
					}
				}
				//Other Procedure codes - Ends
				
				if(ArrayUtils.contains(trainingDataConverted.columns(),"admtDiagCd"))
				{		
					Row d1Max = sparkSession.sql("SELECT admtDiagCd, COUNT(admtDiagCd) as d1_ct from TrainingTable group by admtDiagCd order by d1_ct desc").first();
					String d1MaxValue = d1Max.getAs("admtDiagCd");
					trainingDataConverted = trainingDataConverted.na().fill(d1MaxValue, new String[] {"admtDiagCd"});
					StringIndexer admtDiagCdIndexer = new StringIndexer().setInputCol("admtDiagCd").setOutputCol("admtDiagCdIndexer");
					OneHotEncoder admtDiagCdVec = new OneHotEncoder().setInputCol("admtDiagCdIndexer").setOutputCol("admtDiagCdVec");
					indexers.add(admtDiagCdIndexer);
					indexers.add(admtDiagCdVec);
				//	assemblers.add("admtDiagCd");
				}
				if(ArrayUtils.contains(trainingDataConverted.columns(),"admtDiagCdPoa"))
				{		
					List<Row> d1Max = sparkSession.sql("SELECT admtDiagCdPoa, COUNT(admtDiagCdPoa) as d1_ct from TrainingTable group by admtDiagCdPoa order by d1_ct desc").takeAsList(2);
					if(null!=d1Max && !d1Max.isEmpty() && d1Max.size()>1 && null!=d1Max.get(1).getAs("admtDiagCdPoa"))
					{
						Row row = d1Max.get(0);
						String d1MaxValue = row.getAs("admtDiagCdPoa");
						trainingDataConverted = trainingDataConverted.na().fill(d1MaxValue, new String[] {"admtDiagCdPoa"});
						StringIndexer admtDiagCdPoaIndexer = new StringIndexer().setInputCol("admtDiagCdPoa").setOutputCol("admtDiagCdPoaIndexer");
						OneHotEncoder admtDiagCdPoaVec = new OneHotEncoder().setInputCol("admtDiagCdPoaIndexer").setOutputCol("admtDiagCdPoaVec");
						indexers.add(admtDiagCdPoaIndexer);
						indexers.add(admtDiagCdPoaVec);
					//	assemblers.add("admtDiagCdPoa");
					}
					else
					{
						trainingDataConverted = trainingDataConverted.drop("admtDiagCdPoa");
					}
				}
				if(ArrayUtils.contains(trainingDataConverted.columns(),"prncplDgnsCd"))
				{		
					List<Row> d1Max = sparkSession.sql("SELECT prncplDgnsCd, COUNT(prncplDgnsCd) as d1_ct from TrainingTable group by prncplDgnsCd order by d1_ct desc").takeAsList(2);
					if(null!=d1Max && !d1Max.isEmpty() && d1Max.size()>1 && null!=d1Max.get(1).getAs("prncplDgnsCd"))
					{
						Row row = d1Max.get(0);
						String d1MaxValue = row.getAs("prncplDgnsCd");
						trainingDataConverted = trainingDataConverted.na().fill(d1MaxValue, new String[] {"prncplDgnsCd"});
						StringIndexer prncplDgnsCdIndexer = new StringIndexer().setInputCol("prncplDgnsCd").setOutputCol("prncplDgnsCdIndexer");
						OneHotEncoder prncplDgnsCdVec = new OneHotEncoder().setInputCol("prncplDgnsCdIndexer").setOutputCol("prncplDgnsCdVec");
						indexers.add(prncplDgnsCdIndexer);
						indexers.add(prncplDgnsCdVec);
				//		assemblers.add("prncplDgnsCd");
					}
					else
					{
						trainingDataConverted = trainingDataConverted.drop("prncplDgnsCd");
					}
				}
				
				if(ArrayUtils.contains(trainingDataConverted.columns(),"prncplDgnsPoa"))
				{		
					Row d1Max = sparkSession.sql("SELECT prncplDgnsPoa, COUNT(prncplDgnsPoa) as d1_ct from TrainingTable group by prncplDgnsPoa order by d1_ct desc").first();
					System.out.println("prncplDgnsPoaIndexer:"+d1Max.toString());
					if(null!=d1Max)
					{
						String d1MaxValue = d1Max.getAs("prncplDgnsPoa");
						if(!StringUtils.isEmpty(d1MaxValue))
						{
							trainingDataConverted = trainingDataConverted.na().fill(d1MaxValue, new String[] {"prncplDgnsPoa"});
							StringIndexer prncplDgnsPoaIndexer = new StringIndexer().setInputCol("prncplDgnsPoa").setOutputCol("prncplDgnsPoaIndexer");
							OneHotEncoder prncplDgnsPoaVec = new OneHotEncoder().setInputCol("prncplDgnsPoaIndexer").setOutputCol("prncplDgnsPoaVec");
							indexers.add(prncplDgnsPoaIndexer);
							indexers.add(prncplDgnsPoaVec);
						//	assemblers.add("prncplDgnsPoa");
						}
						else
						{
							trainingDataConverted = trainingDataConverted.drop("prncplDgnsPoa");
						}
					}
				}
				if(ArrayUtils.contains(trainingDataConverted.columns(),"prncplPrcdrCd"))
				{		
					Row d1Max = sparkSession.sql("SELECT prncplPrcdrCd, COUNT(prncplPrcdrCd) as d1_ct from TrainingTable group by prncplPrcdrCd order by d1_ct desc").first();
					String d1MaxValue = d1Max.getAs("prncplPrcdrCd");
					trainingDataConverted = trainingDataConverted.na().fill(d1MaxValue, new String[] {"prncplPrcdrCd"});
					StringIndexer prncplPrcdrCdIndexer = new StringIndexer().setInputCol("prncplPrcdrCd").setOutputCol("prncplPrcdrCdIndexer");
					OneHotEncoder prncplPrcdrCdVec = new OneHotEncoder().setInputCol("prncplPrcdrCdIndexer").setOutputCol("prncplPrcdrCdVec");
					indexers.add(prncplPrcdrCdIndexer);
					indexers.add(prncplPrcdrCdVec);
			//		assemblers.add("prncplPrcdrCd");
				}
				if(ArrayUtils.contains(trainingDataConverted.columns(),"patientStatusLkpcd"))
				{		
					List<Row> d1Max = sparkSession.sql("SELECT patientStatusLkpcd, COUNT(patientStatusLkpcd) as d1_ct from TrainingTable group by patientStatusLkpcd order by d1_ct desc").takeAsList(2);
					System.out.println("patientStatusLkpcd:"+d1Max);
					if(null!=d1Max && !d1Max.isEmpty() && d1Max.size()>1 && null!=d1Max.get(1).getAs("patientStatusLkpcd"))
					{
						Row row = d1Max.get(0);
						String d1MaxValue = row.getAs("patientStatusLkpcd");
						trainingDataConverted = trainingDataConverted.na().fill(d1MaxValue, new String[] {"patientStatusLkpcd"});
						StringIndexer patientStatusLkpcdIndexer = new StringIndexer().setInputCol("patientStatusLkpcd").setOutputCol("patientStatusLkpcdIndexer");
						indexers.add(patientStatusLkpcdIndexer);
						OneHotEncoder patientStatusLkpcdVec = new OneHotEncoder().setInputCol("patientStatusLkpcdIndexer").setOutputCol("patientStatusLkpcdVec");
						indexers.add(patientStatusLkpcdVec);
					}
					else
					{
						Row row = d1Max.get(0);
						String d1MaxValue = row.getAs("patientStatusLkpcd");
						trainingDataConverted = trainingDataConverted.na().fill(d1MaxValue, new String[] {"patientStatusLkpcd"});
						StringIndexer patientStatusLkpcdIndexer = new StringIndexer().setInputCol("patientStatusLkpcd").setOutputCol("patientStatusLkpcdIndexer");
						indexers.add(patientStatusLkpcdIndexer);
					}
				}
				
				StringIndexer patientGenderIndexer = new StringIndexer().setInputCol("patientGender").setOutputCol("patientGenderIndexer");
				indexers.add(patientGenderIndexer);
			//	OneHotEncoder patientGenderVec = new OneHotEncoder().setInputCol("patientGenderIndexer").setOutputCol("patientGenderVec");
			//F	indexers.add(patientGenderVec);
				
				
				
				double[] splits = {020,113,129,163,215,326,405,453,573,614,652,707,734,765,789,799,820,853,876,894,901,927,939,955,969,981,999};
				Bucketizer drgCodeBucketizer = new Bucketizer().setInputCol("drgCode").setOutputCol("drgCodeBucketizer").setSplits(splits);
				indexers.add(drgCodeBucketizer);
				
				double[] mdcSplits = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27};
				Bucketizer mdcBucketizer = new Bucketizer().setInputCol("mdc").setOutputCol("mdcBucketizer").setSplits(mdcSplits);
				indexers.add(mdcBucketizer);
		assemblers.add("los");
		VectorAssembler assembler = new VectorAssembler().setInputCols(assemblers.toArray(new String[assemblers.size()])).setOutputCol("features_temp");
		
//		//Vector normalizer
		Normalizer normalizer = new Normalizer().setInputCol("features_temp").setOutputCol("features");

		
		indexers.add(assembler);
		indexers.add(normalizer);
		indexers.add(linearRegression);
		Pipeline pipeLine = new Pipeline().setStages(indexers.toArray(new PipelineStage[indexers.size()]));
		

		//Option 1
		trainValidationSplit.setEstimator(pipeLine);
		
		
		Dataset<Row>[] splitData = trainingDataConverted.randomSplit(new double[]{0.8, 0.2});
		Dataset<Row> train = splitData[0];
		List<Row> rows = train.takeAsList(100);
		
		for(Row row:rows)
		{
			System.out.println("row:" +row);
		}
		Dataset<Row> test = splitData[1];
		train.printSchema();
		train.show();
		trainValidationSplitModel = trainValidationSplit.fit(train);
		Dataset<Row> holdOut = trainValidationSplitModel.transform(test).select("prediction", "label");
		RegressionMetrics metrics = new RegressionMetrics(holdOut);
		System.out.println("Test Metrics");
		System.out.println("Test Explained Variance:");
		System.out.println(metrics.explainedVariance());
		System.out.println("Test R^2 Coef:");
		System.out.println(metrics.r2());
		System.out.println("Test MSE:");
		System.out.println(metrics.meanSquaredError());
		System.out.println("Test RMSE:");
		System.out.println(metrics.rootMeanSquaredError());
		
		
		//Option 2
//		LinearRegressionModel lrModel = linearRegression.fit(null);
//		printMySummary(lrModel);
	    
//		los
//		totalBilledAmount
		
		return (T) trainValidationSplitModel;
	}

	@SuppressWarnings("unchecked")
	@Override
	public <T, P> T predict(P testingData) throws Exception {
//		Dataset<Row> predictedValues = trainValidationSplitModel.transform((Dataset<Row>) testingData).select("features", "label", "prediction");	
//		return (T) predictedValues;
		return null;
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


	private void printMySummary(LinearRegressionModel lrModel)
	{
		  // Print the coefficients and intercept for linear regression.
	    System.out.println("Coefficients: "   + lrModel.coefficients() + " Intercept: " + lrModel.intercept());

	    // Summarize the model over the training set and print out some metrics.
	    LinearRegressionTrainingSummary trainingSummary = lrModel.summary();
	    System.out.println("numIterations: " + trainingSummary.totalIterations());
	    System.out.println("objectiveHistory: " + Vectors.dense(trainingSummary.objectiveHistory()));
	    trainingSummary.residuals().show();
	    System.out.println("RMSE: " + trainingSummary.rootMeanSquaredError());
	    System.out.println("r2: " + trainingSummary.r2());
	}

}
