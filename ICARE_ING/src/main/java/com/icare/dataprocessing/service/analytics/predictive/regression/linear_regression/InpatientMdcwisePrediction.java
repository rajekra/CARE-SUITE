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
	public InpatientMdcwisePrediction(SparkSession sparkSession) throws Exception {
		super(sparkSession);
		 System.out.println("COPDReadmissionPrediction Constructor");
	}

	public static void main(String args[]) throws Exception {
		SparkSession sparkSession = SparkSession.builder().master(CommonConstants.SPARK_MASTER)
				 .config("spark.app.name", "COPDReadmissionPrediction")
				 .config("spark.sql.crossJoin.enabled", "true")
				// .config("spark.mongodb.input.uri", "mongodb://10.0.0.247:27017/icare.INPATIENT_AGGREGATED")
				// .config("spark.mongodb.output.uri", "mongodb://10.0.0.247:27017")
				// .config("spark.mongodb.input.collection", "icare.INPATIENT_AGGREGATED")
				//  .config("spark.mongodb.input.database", "icare")
				  .getOrCreate();
		new InpatientMdcwisePrediction(sparkSession);
	}


	@Override
	public <T, P> T initialize(P config) throws Exception {
		return null;
	}

	@Override
	public <T, P> T loadTrainingData(P config) throws Exception {
		Dataset<Row> testingData  = RepositoryFactory.getInpatientAggregationRepo().load(javaSparkContext,"INPATIENT_AGGREGATED_NONCOPD");
		testingData.createOrReplaceTempView("Withcopd");
		testingData  = sparkSession.sql("SELECT * FROM Withcopd ip WHERE ip.prncplDgnsCd NOT IN ('J449','J441','J440') ");
		Dataset<Row> extractedTestingData = testingData.drop("inDate",
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
				"admissionDate","age_range","MDC_DESCRIPTION",
				"p1",
				"p1_dt",
				"p2",
				"p2_dt",
				"p3",
				"p3_dt",
				"p4",
				"p4_dt",
				"p5",
				"p5_dt",
				"p6",
				"p6_dt",
				"p7",
				"p7_dt",
				"p8",
				"p8_dt",
				"p9",
				"p9_dt",
				"p10",
				"p10_dt",
				"p11",
				"p11_dt",
				"p12",
				"p12_dt",
				"p13",
				"p13_dt",
				"p14",
				"p14_dt",
				"p15",
				"p15_dt",
				"p16",
				"p16_dt",
				"p17",
				"p17_dt",
				"p18",
				"p18_dt",
				"p19",
				"p19_dt",
				"p20",
				"p20_dt",
				"p21",
				"p21_dt",
				"p22",
				"p22_dt",
				"p23",
				"p23_dt",
				"p24",
				"p24_dt",
				"d1_poa",
				"d2_poa",
				"d3_poa",
				"d4_poa",
				"d5_poa",
				"d6_poa",
				"d7_poa",
				"d8_poa",
				"d9_poa",
				"d10_poa",
				"d11_poa",
				"d12_poa",
				"d13_poa",
				"d14_poa",
				"d15_poa",
				"d16_poa",
				"d17_poa",
				"d18_poa",
				"d19_poa",
				"d20_poa",
				"d21_poa",
				"d22_poa",
				"d23_poa",
				"d24_poa",
				"d24",
				"de1"
				);
		//extractedTestingData.printSchema();

		//To print mean/median
		//extractedTestingData.describe("admtDiagCd").show();
		return (T) extractedTestingData;	}

	@Override
	public <T, P> T loadTestingData(P config) throws Exception {
		Dataset<Row> testingData  = RepositoryFactory.getInpatientAggregationRepo().load(javaSparkContext,"INPATIENT_AGGREGATED_NONCOPD");
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
				"admissionDate","totalBilledAmount");
		//extractedTestingData.printSchema();
		
		//To print mean/median
		//extractedTestingData.describe("admtDiagCd").show();
		return (T) extractedTestingData;
	}

	@Override
	public <T, P> T buildPipeline(P trainInputData) throws Exception {
		Dataset<Row> trainData = (Dataset<Row>) trainInputData;
		
		trainData = trainData.drop("_id");
		trainData = trainData.withColumnRenamed("totalBilledAmount", "label");
		trainData.createOrReplaceTempView("TrainingTable");
		List<PipelineStage> indexers = new ArrayList<PipelineStage>();
		List<String> assemblers = new ArrayList<String>();
		
		System.out.println("PRIN SCHEMA");
		trainData.printSchema();
		
		if(ArrayUtils.contains(trainData.columns(),"d1"))
		{
			List<Row> d1Max = sparkSession.sql("SELECT case when d1 is NULL OR d1='' then '1000' else d1 end as d1, COUNT(d1) as d1_ct from TrainingTable group by d1 order by d1_ct desc").takeAsList(2);
			System.out.println("TEST d1:"+d1Max);
			if(null!=d1Max && !d1Max.isEmpty() && d1Max.size()>1 && null!=d1Max.get(1).getAs("d1"))
			{
				Row row = d1Max.get(0);
			String d1MaxValue = row.getAs("d1");
			trainData = trainData.na().fill(d1MaxValue, new String[] {"d1"});
			StringIndexer d1Indexer = new StringIndexer().setInputCol("d1").setOutputCol("d1Indexer");
			OneHotEncoder d1Vec = new OneHotEncoder().setInputCol("d1Indexer").setOutputCol("d1Vec");
			d1Indexer.setHandleInvalid("keep");
			indexers.add(d1Indexer);
			indexers.add(d1Vec);
			assemblers.add("d1Indexer");
			assemblers.add("d1Vec");
			}
		}
		
//		if(ArrayUtils.contains(trainData.columns(),"d1_poa"))
//		{
//			List<Row> d1Max = sparkSession.sql("SELECT case when d1_poa is NULL OR d1_poa='' then '1000' else d1_poa end as d1_poa, COUNT(d1_poa) as d1_ct from TrainingTable group by d1_poa order by d1_ct desc").takeAsList(2);
//			System.out.println("TEST d1_poa:"+d1Max);
//			if(null!=d1Max && !d1Max.isEmpty() && d1Max.size()>1 && null!=d1Max.get(1).getAs("d1_poa"))
//			{
//				Row row = d1Max.get(0);
//			String d1MaxValue = row.getAs("d1_poa");
//			trainData = trainData.na().fill(d1MaxValue, new String[] {"d1_poa"});
//			StringIndexer d1poaIndexer = new StringIndexer().setInputCol("d1_poa").setOutputCol("d1poaIndexer");
//			OneHotEncoder d1poaVec = new OneHotEncoder().setInputCol("d1poaIndexer").setOutputCol("d1poaVec");
//			d1poaIndexer.setHandleInvalid("keep");
//			indexers.add(d1poaIndexer);
//			indexers.add(d1poaVec);
//			assemblers.add("d1poaIndexer");
//			assemblers.add("d1poaVec");
//			}
//		}
		
		if(ArrayUtils.contains(trainData.columns(),"d2"))
		{
			List<Row> d1Max = sparkSession.sql("SELECT case when d2 is NULL OR d2='' then '1000' else d2 end as d2, COUNT(d2) as d1_ct from TrainingTable group by d2 order by d1_ct desc").takeAsList(2);
			System.out.println("TEST d2:"+d1Max);
			if(null!=d1Max && !d1Max.isEmpty() && d1Max.size()>1 && null!=d1Max.get(1).getAs("d2"))
			{
				Row row = d1Max.get(0);
			String d1MaxValue = row.getAs("d2");
			trainData = trainData.na().fill(d1MaxValue, new String[] {"d2"});	
			StringIndexer d2Indexer = new StringIndexer().setInputCol("d2").setOutputCol("d2Indexer");
			d2Indexer.setHandleInvalid("keep");
			OneHotEncoder d2Vec = new OneHotEncoder().setInputCol("d2Indexer").setOutputCol("d2Vec");
			indexers.add(d2Indexer);
			indexers.add(d2Vec);
			assemblers.add("d2Indexer");
			assemblers.add("d2Vec");
			}
		}
		

//		if(ArrayUtils.contains(trainData.columns(),"d2_poa"))
//		{
//			List<Row> d1Max = sparkSession.sql("SELECT case when d2_poa is NULL OR d2_poa='' then '1000' else d2_poa end as d2_poa, COUNT(d2_poa) as d1_ct from TrainingTable group by d2_poa order by d1_ct desc").takeAsList(2);
//			System.out.println("TEST d2_poa:"+d1Max);
//			if(null!=d1Max && !d1Max.isEmpty() && d1Max.size()>1 && null!=d1Max.get(1).getAs("d2_poa"))
//			{
//				Row row = d1Max.get(0);
//			String d1MaxValue = row.getAs("d2_poa");
//			trainData = trainData.na().fill(d1MaxValue, new String[] {"d2_poa"});	
//			StringIndexer d2poaIndexer = new StringIndexer().setInputCol("d2_poa").setOutputCol("d2poaIndexer");
//			d2poaIndexer.setHandleInvalid("keep");
//			OneHotEncoder d2poaVec = new OneHotEncoder().setInputCol("d2poaIndexer").setOutputCol("d2poaVec");
//			indexers.add(d2poaIndexer);
//			indexers.add(d2poaVec);
//			assemblers.add("d2poaIndexer");
//			assemblers.add("d2poaVec");			}
//		}
		
		if(ArrayUtils.contains(trainData.columns(),"d3"))
		{
			List<Row> d1Max = sparkSession.sql("SELECT case when d3 is NULL OR d3='' then '1000' else d3 end as d3, COUNT(d3) as d1_ct from TrainingTable group by d3 order by d1_ct desc").takeAsList(2);
			System.out.println("TEST D3:"+d1Max);
			if(null!=d1Max && !d1Max.isEmpty() && d1Max.size()>1 && null!=d1Max.get(1).getAs("d3"))
			{
				Row row = d1Max.get(0);
			String d1MaxValue = row.getAs("d3");
			trainData = trainData.na().fill(d1MaxValue, new String[] {"d3"});	
			StringIndexer d3Indexer = new StringIndexer().setInputCol("d3").setOutputCol("d3Indexer");
			OneHotEncoder d3Vec = new OneHotEncoder().setInputCol("d3Indexer").setOutputCol("d3Vec");
			d3Indexer.setHandleInvalid("keep");
			indexers.add(d3Indexer);
			indexers.add(d3Vec);
			assemblers.add("d3Indexer");
			assemblers.add("d3Vec");			}
		}
		
//		if(ArrayUtils.contains(trainData.columns(),"d3_poa"))
//		{
//			List<Row> d1Max = sparkSession.sql("SELECT case when d3_poa is NULL OR d3_poa='' then '1000' else d3_poa end as d3_poa, COUNT(d3_poa) as d1_ct from TrainingTable group by d3_poa order by d1_ct desc").takeAsList(2);
//			System.out.println("TEST D3POA:"+d1Max);
//			if(null!=d1Max && !d1Max.isEmpty() && d1Max.size()>1 && null!=d1Max.get(1).getAs("d3_poa"))
//			{
//				Row row = d1Max.get(0);
//			String d1MaxValue = row.getAs("d3_poa");
//			trainData = trainData.na().fill(d1MaxValue, new String[] {"d3_poa"});
//			StringIndexer d3poaIndexer = new StringIndexer().setInputCol("d3_poa").setOutputCol("d3poaIndexer");
//			d3poaIndexer.setHandleInvalid("keep");
//			OneHotEncoder d3poaVec = new OneHotEncoder().setInputCol("d3poaIndexer").setOutputCol("d3poaVec");
//			indexers.add(d3poaIndexer);
//			indexers.add(d3poaVec);
//			assemblers.add("d3poaIndexer");
//			assemblers.add("d3poaVec");			}
//		}
		
		if(ArrayUtils.contains(trainData.columns(),"d4"))
		{
			List<Row> d1Max = sparkSession.sql("SELECT case when d4 is NULL OR d4='' then '1000' else d4 end as d4, COUNT(d4) as d1_ct from TrainingTable group by d4 order by d1_ct desc").takeAsList(2);
			System.out.println("TEST D4:"+d1Max);
			if(null!=d1Max && !d1Max.isEmpty() && d1Max.size()>1 && null!=d1Max.get(1).getAs("d4"))
			{
				Row row = d1Max.get(0);
			String d1MaxValue = row.getAs("d4");
			trainData = trainData.na().fill(d1MaxValue, new String[] {"d4"});
			StringIndexer d4Indexer = new StringIndexer().setInputCol("d4").setOutputCol("d4Indexer");
			OneHotEncoder d4Vec = new OneHotEncoder().setInputCol("d4Indexer").setOutputCol("d4Vec");
			d4Indexer.setHandleInvalid("keep");
			indexers.add(d4Indexer);
			indexers.add(d4Vec);
			assemblers.add("d4Indexer");
			assemblers.add("d4Vec");			}
		}
		
//		if(ArrayUtils.contains(trainData.columns(),"d4_poa"))
//		{
//			List<Row> d1Max = sparkSession.sql("SELECT case when d4_poa is NULL OR d4_poa='' then '1000' else d4_poa end as d4_poa, COUNT(d4_poa) as d1_ct from TrainingTable group by d4_poa order by d1_ct desc").takeAsList(2);
//			System.out.println("TEST D4POA:"+d1Max);
//			if(null!=d1Max && !d1Max.isEmpty() && d1Max.size()>1 && null!=d1Max.get(1).getAs("d4_poa"))
//			{
//				Row row = d1Max.get(0);
//			String d1MaxValue = row.getAs("d4_poa");
//			trainData = trainData.na().fill(d1MaxValue, new String[] {"d4_poa"});
//			StringIndexer d4poaIndexer = new StringIndexer().setInputCol("d4_poa").setOutputCol("d4poaIndexer");
//			d4poaIndexer.setHandleInvalid("keep");
//			OneHotEncoder d4poaVec = new OneHotEncoder().setInputCol("d4poaIndexer").setOutputCol("d4poaVec");
//			indexers.add(d4poaIndexer);
//			indexers.add(d4poaVec);
//			assemblers.add("d4poaIndexer");
//			assemblers.add("d4poaVec");
//			}		//	assemblers.add("d4_poa");
//		}
		
		if(ArrayUtils.contains(trainData.columns(),"d5"))
		{
			List<Row> d1Max = sparkSession.sql("SELECT case when d5 is NULL OR d5='' then '1000' else d5 end as d5, COUNT(d5) as d1_ct from TrainingTable group by d5 order by d1_ct desc").takeAsList(2);
			System.out.println("TEST D5:"+d1Max);
			if(null!=d1Max && !d1Max.isEmpty() && d1Max.size()>1 && null!=d1Max.get(1).getAs("d5"))
			{
				Row row = d1Max.get(0);
			String d1MaxValue = row.getAs("d5");
			trainData = trainData.na().fill(d1MaxValue, new String[] {"d5"});
			StringIndexer d5Indexer = new StringIndexer().setInputCol("d5").setOutputCol("d5Indexer");
			d5Indexer.setHandleInvalid("keep");
			OneHotEncoder d5Vec = new OneHotEncoder().setInputCol("d5Indexer").setOutputCol("d5Vec");
			indexers.add(d5Indexer);
			indexers.add(d5Vec);
			assemblers.add("d5Indexer");
			assemblers.add("d5Vec");
			}			//assemblers.add("d5");
		}
		
//		if(ArrayUtils.contains(trainData.columns(),"d5_poa"))
//		{
//			List<Row> d1Max = sparkSession.sql("SELECT case when d5_poa is NULL OR d5_poa='' then '1000' else d5_poa end as d5_poa, COUNT(d5_poa) as d1_ct from TrainingTable group by d5_poa order by d1_ct desc").takeAsList(2);
//			System.out.println("TEST D5POA:"+d1Max);
//			if(null!=d1Max && !d1Max.isEmpty() && d1Max.size()>1 && null!=d1Max.get(1).getAs("d5_poa"))
//			{
//				Row row = d1Max.get(0);
//			String d1MaxValue = row.getAs("d5_poa");
//			trainData = trainData.na().fill(d1MaxValue, new String[] {"d5_poa"});
//			StringIndexer d5poaIndexer = new StringIndexer().setInputCol("d5_poa").setOutputCol("d5poaIndexer");
//			
//			d5poaIndexer.setHandleInvalid("keep");
//			OneHotEncoder d5poaVec = new OneHotEncoder().setInputCol("d5poaIndexer").setOutputCol("d5poaVec");
//			indexers.add(d5poaIndexer);
//			indexers.add(d5poaVec);
//			assemblers.add("d5poaIndexer");
//			assemblers.add("d5poaVec");
//			}//assemblers.add("d5_poa");
//		}
		
		if(ArrayUtils.contains(trainData.columns(),"d6"))
		{
			List<Row> d1Max = sparkSession.sql("SELECT case when d6 is NULL OR d6='' then '1000' else d6 end as d6, COUNT(d6) as d1_ct from TrainingTable group by d6 order by d1_ct desc").takeAsList(2);
			System.out.println("TEST D6:"+d1Max);
			if(null!=d1Max && !d1Max.isEmpty() && d1Max.size()>1 && null!=d1Max.get(1).getAs("d6"))
			{
				Row row = d1Max.get(0);
			String d1MaxValue = row.getAs("d6");
			trainData = trainData.na().fill(d1MaxValue, new String[] {"d6"});
			StringIndexer d6Indexer = new StringIndexer().setInputCol("d6").setOutputCol("d6Indexer");			
			d6Indexer.setHandleInvalid("keep");
			OneHotEncoder d6Vec = new OneHotEncoder().setInputCol("d6Indexer").setOutputCol("d6Vec");
			indexers.add(d6Indexer);
			indexers.add(d6Vec);
			assemblers.add("d6Indexer");
			assemblers.add("d6Vec");
			//assemblers.add("d6");
			}
		}
//		
//		if(ArrayUtils.contains(trainData.columns(),"d6_poa"))
//		{
//			List<Row> d1Max = sparkSession.sql("SELECT case when d6_poa is NULL OR d6_poa='' then '1000' else d6_poa end as d6_poa, COUNT(d6) as d1_ct from TrainingTable group by d6_poa order by d1_ct desc").takeAsList(2);
//			System.out.println("TEST D6P:"+d1Max);
//			if(null!=d1Max && !d1Max.isEmpty() && d1Max.size()>1 && null!=d1Max.get(1).getAs("d6_poa"))
//			{
//				Row row = d1Max.get(0);
//			String d1MaxValue = row.getAs("d6_poa");
//			trainData = trainData.na().fill(d1MaxValue, new String[] {"d6_poa"});
//			StringIndexer d6poaIndexer = new StringIndexer().setInputCol("d6_poa").setOutputCol("d6poaIndexer");			
//			d6poaIndexer.setHandleInvalid("keep");
//			OneHotEncoder d6poaVec = new OneHotEncoder().setInputCol("d6poaIndexer").setOutputCol("d6poaVec");
//			indexers.add(d6poaIndexer);
//			indexers.add(d6poaVec);
//			assemblers.add("d6poaIndexer");
//			assemblers.add("d6poaVec");
//			//assemblers.add("d6_poa");
//			}
//		}
		
		if(ArrayUtils.contains(trainData.columns(),"d7"))
		{
			List<Row> d1Max = sparkSession.sql("SELECT case when d7 is NULL OR d7='' then '1000' else d7 end as d7, COUNT(d7) as d1_ct from TrainingTable group by d7 order by d1_ct desc").takeAsList(2);
			System.out.println("TEST D7:"+d1Max);
			if(null!=d1Max && !d1Max.isEmpty() && d1Max.size()>1 && null!=d1Max.get(1).getAs("d7"))
			{
				Row row = d1Max.get(0);
			String d1MaxValue = row.getAs("d7");
			trainData = trainData.na().fill(d1MaxValue, new String[] {"d7"});
			StringIndexer d7Indexer = new StringIndexer().setInputCol("d7").setOutputCol("d7Indexer");			
			d7Indexer.setHandleInvalid("keep");
			OneHotEncoder d7Vec = new OneHotEncoder().setInputCol("d7Indexer").setOutputCol("d7Vec");
			indexers.add(d7Indexer);
			indexers.add(d7Vec);
			assemblers.add("d7Indexer");
			assemblers.add("d7Vec");
			}		//	assemblers.add("d7");
		}
//		if(ArrayUtils.contains(trainData.columns(),"d7_poa"))
//		{		
//			List<Row> d1Max = sparkSession.sql("SELECT case when d7_poa is NULL OR d7_poa='' then '1000' else d7_poa end as d7_poa, COUNT(d7_poa) as d1_ct from TrainingTable group by d7_poa order by d1_ct desc").takeAsList(2);
//			System.out.println("TEST D7P:"+d1Max);
//			if(null!=d1Max && !d1Max.isEmpty() && d1Max.size()>1 && null!=d1Max.get(1).getAs("d7_poa"))
//			{
//				Row row = d1Max.get(0);
//			String d1MaxValue = row.getAs("d7_poa");
//			trainData = trainData.na().fill(d1MaxValue, new String[] {"d7_poa"});
//			StringIndexer d7poaIndexer = new StringIndexer().setInputCol("d7_poa").setOutputCol("d7poaIndexer");			
//			d7poaIndexer.setHandleInvalid("keep");
//			OneHotEncoder d7poaVec = new OneHotEncoder().setInputCol("d7poaIndexer").setOutputCol("d7poaVec");
//			indexers.add(d7poaIndexer);
//			indexers.add(d7poaVec);
//			assemblers.add("d7poaIndexer");
//			assemblers.add("d7poaVec");
//			}		//	assemblers.add("d7_poa");
//		}
		
		if(ArrayUtils.contains(trainData.columns(),"d8"))
		{		
			List<Row> d1Max = sparkSession.sql("SELECT case when d8 is NULL OR d8='' then '1000' else d8 end as d8, COUNT(d8) as d1_ct from TrainingTable group by d8 order by d1_ct desc").takeAsList(2);
			System.out.println("TEST D8:"+d1Max);
			if(null!=d1Max && !d1Max.isEmpty() && d1Max.size()>1 && null!=d1Max.get(1).getAs("d8"))
			{
				Row row = d1Max.get(0);
			String d1MaxValue = row.getAs("d8");
			trainData = trainData.na().fill(d1MaxValue, new String[] {"d8"});
			StringIndexer d8Indexer = new StringIndexer().setInputCol("d8").setOutputCol("d8Indexer");			
			d8Indexer.setHandleInvalid("keep");
			OneHotEncoder d8Vec = new OneHotEncoder().setInputCol("d8Indexer").setOutputCol("d8Vec");
			indexers.add(d8Indexer);
			indexers.add(d8Vec);
			assemblers.add("d8Indexer");
			assemblers.add("d8Vec");
			}		//	assemblers.add("d8");
		}
		
//		if(ArrayUtils.contains(trainData.columns(),"d8_poa"))
//		{		
//			List<Row> d1Max = sparkSession.sql("SELECT case when d8_poa is NULL OR d8_poa='' then '1000' else d8_poa end as d8_poa, COUNT(d8_poa) as d1_ct from TrainingTable group by d8_poa order by d1_ct desc").takeAsList(2);
//			System.out.println("TEST D8P:"+d1Max);
//			if(null!=d1Max && !d1Max.isEmpty() && d1Max.size()>1 && null!=d1Max.get(1).getAs("d8_poa"))
//			{
//				Row row = d1Max.get(0);
//			String d1MaxValue = row.getAs("d8_poa");
//			trainData = trainData.na().fill(d1MaxValue, new String[] {"d8_poa"});
//			StringIndexer d8poaIndexer = new StringIndexer().setInputCol("d8_poa").setOutputCol("d8poaIndexer");			
//			d8poaIndexer.setHandleInvalid("keep");
//			OneHotEncoder d8poaVec = new OneHotEncoder().setInputCol("d8poaIndexer").setOutputCol("d8poaVec");
//			indexers.add(d8poaIndexer);
//			indexers.add(d8poaVec);
//			assemblers.add("d8poaIndexer");
//			assemblers.add("d8poaVec");
//			}		//	assemblers.add("d8_poa");
//		}
		
		if(ArrayUtils.contains(trainData.columns(),"d9"))
		{		
			List<Row> d1Max = sparkSession.sql("SELECT case when d9 is NULL OR d9='' then '1000' else d9 end as d9, COUNT(d9) as d1_ct from TrainingTable group by d9 order by d1_ct desc").takeAsList(2);
			System.out.println(" TEST d9:"+d1Max);
			if(null!=d1Max && !d1Max.isEmpty() && d1Max.size()>1 && null!=d1Max.get(1).getAs("d9"))
			{
				Row row = d1Max.get(0);
			String d1MaxValue = row.getAs("d9");
			trainData = trainData.na().fill(d1MaxValue, new String[] {"d9"});
			StringIndexer d9Indexer = new StringIndexer().setInputCol("d9").setOutputCol("d9Indexer");			
			d9Indexer.setHandleInvalid("keep");
			OneHotEncoder d9Vec = new OneHotEncoder().setInputCol("d9Indexer").setOutputCol("d9Vec");
			indexers.add(d9Indexer);
			indexers.add(d9Vec);
			assemblers.add("d9Indexer");
			assemblers.add("d9Vec");
			}	//		assemblers.add("d9");
		}
		
//		if(ArrayUtils.contains(trainData.columns(),"d9_poa"))
//		{		
//			List<Row> d1Max = sparkSession.sql("SELECT case when d9_poa is NULL OR d9_poa='' then '1000' else d9_poa end as d9_poa, COUNT(d9_poa) as d1_ct from TrainingTable group by d9_poa order by d1_ct desc").takeAsList(2);
//			System.out.println(" TEST:"+d1Max);
//			if(null!=d1Max && !d1Max.isEmpty() && d1Max.size()>1 && null!=d1Max.get(1).getAs("d9_poa"))
//			{
//				Row row = d1Max.get(0);
//			String d1MaxValue = row.getAs("d9_poa");
//			trainData = trainData.na().fill(d1MaxValue, new String[] {"d9_poa"});
//			StringIndexer d9poaIndexer = new StringIndexer().setInputCol("d9_poa").setOutputCol("d9poaIndexer");			
//			d9poaIndexer.setHandleInvalid("keep");
//			OneHotEncoder d9poaVec = new OneHotEncoder().setInputCol("d9poaIndexer").setOutputCol("d9poaVec");
//			indexers.add(d9poaIndexer);
//			indexers.add(d9poaVec);
//			assemblers.add("d9poaIndexer");
//			assemblers.add("d9poaVec");
//			}	//		assemblers.add("d9_poa");
//		}
		
		if(ArrayUtils.contains(trainData.columns(),"d10"))
		{		
			List<Row> d1Max = sparkSession.sql("SELECT case when d10 is NULL OR d10='' then '1000' else d10 end as d10, COUNT(d10) as d1_ct from TrainingTable group by d10 order by d1_ct desc").takeAsList(2);
			System.out.println(" TEST d10:"+d1Max);
			if(null!=d1Max && !d1Max.isEmpty() && d1Max.size()>1 && null!=d1Max.get(1).getAs("d10"))
			{
				Row row = d1Max.get(0);
			String d1MaxValue = row.getAs("d10");
			trainData = trainData.na().fill(d1MaxValue, new String[] {"d10"});
			StringIndexer d10Indexer = new StringIndexer().setInputCol("d10").setOutputCol("d10Indexer");			
			d10Indexer.setHandleInvalid("keep");
			OneHotEncoder d10Vec = new OneHotEncoder().setInputCol("d10Indexer").setOutputCol("d10Vec");
			indexers.add(d10Indexer);
			indexers.add(d10Vec);
			assemblers.add("d10Indexer");
			assemblers.add("d10Vec");
			}		//	assemblers.add("d10");
		}
		
//		if(ArrayUtils.contains(trainData.columns(),"d10_poa"))
//		{		
//			List<Row> d1Max = sparkSession.sql("SELECT case when d10_poa is NULL OR d10_poa='' then '1000' else d10_poa end as d10_poa, COUNT(d10_poa) as d1_ct from TrainingTable group by d10_poa order by d1_ct desc").takeAsList(2);
//			System.out.println(" TEST:"+d1Max);
//			if(null!=d1Max && !d1Max.isEmpty() && d1Max.size()>1 && null!=d1Max.get(1).getAs("d10_poa"))
//			{
//				Row row = d1Max.get(0);
//			String d1MaxValue = row.getAs("d10_poa");
//			trainData = trainData.na().fill(d1MaxValue, new String[] {"d10_poa"});
//			StringIndexer d10poaIndexer = new StringIndexer().setInputCol("d10_poa").setOutputCol("d10poaIndexer");			
//			d10poaIndexer.setHandleInvalid("keep");
//			OneHotEncoder d10poaVec = new OneHotEncoder().setInputCol("d10poaIndexer").setOutputCol("d10poaVec");
//			indexers.add(d10poaIndexer);
//			indexers.add(d10poaVec);
//			assemblers.add("d10poaIndexer");
//			assemblers.add("d10poaVec");
//			}		//	assemblers.add("d10_poa");
//		}
		
		if(ArrayUtils.contains(trainData.columns(),"d11"))
		{		
			List<Row> d1Max = sparkSession.sql("SELECT case when d11 is NULL OR d11='' then '1000' else d11 end as d11, COUNT(d11) as d1_ct from TrainingTable group by d11 order by d1_ct desc").takeAsList(2);
			System.out.println(" TEST d11:"+d1Max);
			if(null!=d1Max && !d1Max.isEmpty() && d1Max.size()>1 && null!=d1Max.get(1).getAs("d11"))
			{
				Row row = d1Max.get(0);
			String d1MaxValue = row.getAs("d11");
			trainData = trainData.na().fill(d1MaxValue, new String[] {"d11"});
			StringIndexer d11Indexer = new StringIndexer().setInputCol("d11").setOutputCol("d11Indexer");			
			d11Indexer.setHandleInvalid("keep");
			OneHotEncoder d11Vec = new OneHotEncoder().setInputCol("d11Indexer").setOutputCol("d11Vec");
			indexers.add(d11Indexer);
			indexers.add(d11Vec);
			assemblers.add("d11Indexer");
			assemblers.add("d11Vec");
			}		//	assemblers.add("d11");
		}
		
//		if(ArrayUtils.contains(trainData.columns(),"d11_poa"))
//		{		
//			List<Row> d1Max = sparkSession.sql("SELECT case when d11_poa is NULL OR d11_poa='' then '1000' else d11_poa end as d11_poa, COUNT(d11_poa) as d1_ct from TrainingTable group by d11_poa order by d1_ct desc").takeAsList(2);
//			System.out.println(" TEST:"+d1Max);
//			if(null!=d1Max && !d1Max.isEmpty() && d1Max.size()>1 && null!=d1Max.get(1).getAs("d11_poa"))
//			{
//				Row row = d1Max.get(0);
//			String d1MaxValue = row.getAs("d11_poa");
//			trainData = trainData.na().fill(d1MaxValue, new String[] {"d11_poa"});
//			StringIndexer d11poaIndexer = new StringIndexer().setInputCol("d11_poa").setOutputCol("d11poaIndexer");			
//			d11poaIndexer.setHandleInvalid("keep");
//			OneHotEncoder d11poaVec = new OneHotEncoder().setInputCol("d11poaIndexer").setOutputCol("d11poaVec");
//			indexers.add(d11poaIndexer);
//			indexers.add(d11poaVec);
//			assemblers.add("d11poaIndexer");
//			assemblers.add("d11poaVec");
//			}		//	assemblers.add("d11_poa");
//		}
		
		if(ArrayUtils.contains(trainData.columns(),"d12"))
		{		
			List<Row> d1Max = sparkSession.sql("SELECT case when d12 is NULL OR d12='' then '1000' else d12 end as d12, COUNT(d12) as d1_ct from TrainingTable group by d12 order by d1_ct desc").takeAsList(2);
			System.out.println(" TEST d12:"+d1Max);
			if(null!=d1Max && !d1Max.isEmpty() && d1Max.size()>1 && null!=d1Max.get(1).getAs("d12"))
			{
				Row row = d1Max.get(0);
			String d1MaxValue = row.getAs("d12");
			trainData = trainData.na().fill(d1MaxValue, new String[] {"d12"});
			StringIndexer d12Indexer = new StringIndexer().setInputCol("d12").setOutputCol("d12Indexer");			
			d12Indexer.setHandleInvalid("keep");
			OneHotEncoder d12Vec = new OneHotEncoder().setInputCol("d12Indexer").setOutputCol("d12Vec");
			indexers.add(d12Indexer);
			indexers.add(d12Vec);
			assemblers.add("d12Indexer");
			assemblers.add("d12Vec");
			}		//	assemblers.add("d12");
		}
		
//		if(ArrayUtils.contains(trainData.columns(),"d12_poa"))
//		{		
//			List<Row> d1Max = sparkSession.sql("SELECT case when d12_poa is NULL OR d12_poa='' then '1000' else d12_poa end as d12_poa, COUNT(d12_poa) as d1_ct from TrainingTable group by d12_poa order by d1_ct desc").takeAsList(2);
//			System.out.println(" TEST:"+d1Max);
//			if(null!=d1Max && !d1Max.isEmpty() && d1Max.size()>1 && null!=d1Max.get(1).getAs("d12_poa"))
//			{
//				Row row = d1Max.get(0);
//			String d1MaxValue = row.getAs("d12_poa");
//			trainData = trainData.na().fill(d1MaxValue, new String[] {"d12_poa"});
//			StringIndexer d12poaIndexer = new StringIndexer().setInputCol("d12_poa").setOutputCol("d12poaIndexer");			
//			d12poaIndexer.setHandleInvalid("keep");
//			OneHotEncoder d12poaVec = new OneHotEncoder().setInputCol("d12poaIndexer").setOutputCol("d12poaVec");
//			indexers.add(d12poaIndexer);
//			indexers.add(d12poaVec);
//			assemblers.add("d12poaIndexer");
//			assemblers.add("d12poaVec");
//			}		//	assemblers.add("d12_poa");
//		}
		
		if(ArrayUtils.contains(trainData.columns(),"d13"))
		{		
			List<Row> d1Max = sparkSession.sql("SELECT case when d13 is NULL OR d13='' then '1000' else d13 end as d13, COUNT(d13) as d1_ct from TrainingTable group by d13 order by d1_ct desc").takeAsList(2);
			System.out.println(" TEST d13:"+d1Max);
			if(null!=d1Max && !d1Max.isEmpty() && d1Max.size()>1 && null!=d1Max.get(1).getAs("d13"))
			{
				Row row = d1Max.get(0);
			String d1MaxValue = row.getAs("d13");
			trainData = trainData.na().fill(d1MaxValue, new String[] {"d13"});
			StringIndexer d13Indexer = new StringIndexer().setInputCol("d13").setOutputCol("d13Indexer");			
			d13Indexer.setHandleInvalid("keep");
			OneHotEncoder d13Vec = new OneHotEncoder().setInputCol("d13Indexer").setOutputCol("d13Vec");
			indexers.add(d13Indexer);
			indexers.add(d13Vec);
			assemblers.add("d13Indexer");
			assemblers.add("d13Vec");
			}	//		assemblers.add("d13");
		}
		
//		if(ArrayUtils.contains(trainData.columns(),"d13_poa"))
//		{		
//			List<Row> d1Max = sparkSession.sql("SELECT case when d13_poa is NULL OR d13_poa='' then '1000' else d13_poa end as d13_poa, COUNT(d13_poa) as d1_ct from TrainingTable group by d13_poa order by d1_ct desc").takeAsList(2);
//			System.out.println(" TEST:"+d1Max);
//			if(null!=d1Max && !d1Max.isEmpty() && d1Max.size()>1 && null!=d1Max.get(1).getAs("d13_poa"))
//			{
//				Row row = d1Max.get(0);
//			String d1MaxValue = row.getAs("d13_poa");
//			trainData = trainData.na().fill(d1MaxValue, new String[] {"d13_poa"});
//			StringIndexer d13poaIndexer = new StringIndexer().setInputCol("d13_poa").setOutputCol("d13poaIndexer");			
//			d13poaIndexer.setHandleInvalid("keep");
//			OneHotEncoder d13poaVec = new OneHotEncoder().setInputCol("d13poaIndexer").setOutputCol("d13poaVec");
//			indexers.add(d13poaIndexer);
//			indexers.add(d13poaVec);
//			assemblers.add("d13poaIndexer");
//			assemblers.add("d13poaVec");
//			}//			assemblers.add("d13_poa");
//		}
		
		if(ArrayUtils.contains(trainData.columns(),"d14"))
		{		
			List<Row> d1Max = sparkSession.sql("SELECT case when d14 is NULL OR d14='' then '1000' else d14 end as d14, COUNT(d14) as d1_ct from TrainingTable group by d14 order by d1_ct desc").takeAsList(2);
			System.out.println(" TEST d14:"+d1Max);
			if(null!=d1Max && !d1Max.isEmpty() && d1Max.size()>1 && null!=d1Max.get(1).getAs("d14"))
			{
				Row row = d1Max.get(0);
			String d1MaxValue = row.getAs("d14");
			trainData = trainData.na().fill(d1MaxValue, new String[] {"d14"});
			StringIndexer d14Indexer = new StringIndexer().setInputCol("d14").setOutputCol("d14Indexer");			
			d14Indexer.setHandleInvalid("keep");
			OneHotEncoder d14Vec = new OneHotEncoder().setInputCol("d14Indexer").setOutputCol("d14Vec");
			indexers.add(d14Indexer);
			indexers.add(d14Vec);
			assemblers.add("d14Indexer");
			assemblers.add("d14Vec");
			}		//	assemblers.add("d14");
		}
//		
//		if(ArrayUtils.contains(trainData.columns(),"d14_poa"))
//		{		
//			List<Row> d1Max = sparkSession.sql("SELECT case when d14_poa is NULL OR d14_poa='' then '1000' else d14_poa end as d14_poa, COUNT(d14_poa) as d1_ct from TrainingTable group by d14_poa order by d1_ct desc").takeAsList(2);
//			System.out.println(" TEST:"+d1Max);
//			if(null!=d1Max && !d1Max.isEmpty() && d1Max.size()>1 && null!=d1Max.get(1).getAs("d14_poa"))
//			{
//				Row row = d1Max.get(0);
//			String d1MaxValue = row.getAs("d14_poa");
//			trainData = trainData.na().fill(d1MaxValue, new String[] {"d14_poa"});
//			StringIndexer d14poaIndexer = new StringIndexer().setInputCol("d14_poa").setOutputCol("d14poaIndexer");			
//			d14poaIndexer.setHandleInvalid("keep");
//			OneHotEncoder d14poaVec = new OneHotEncoder().setInputCol("d14poaIndexer").setOutputCol("d14poaVec");
//			indexers.add(d14poaIndexer);
//			indexers.add(d14poaVec);
//			assemblers.add("d14poaIndexer");
//			assemblers.add("d14poaVec");
//			}		//	assemblers.add("d14_poa");
//		}
		
		if(ArrayUtils.contains(trainData.columns(),"d15"))
		{		
			List<Row> d1Max = sparkSession.sql("SELECT case when d15 is NULL OR d15='' then '1000' else d15 end as d15, COUNT(d15) as d1_ct from TrainingTable group by d15 order by d1_ct desc").takeAsList(2);
			System.out.println(" TEST d15:"+d1Max);
			if(null!=d1Max && !d1Max.isEmpty() && d1Max.size()>1 && null!=d1Max.get(1).getAs("d15"))
			{
				Row row = d1Max.get(0);
			String d1MaxValue = row.getAs("d15");
			trainData = trainData.na().fill(d1MaxValue, new String[] {"d15"});
			StringIndexer d15Indexer = new StringIndexer().setInputCol("d15").setOutputCol("d15Indexer");			
			d15Indexer.setHandleInvalid("keep");
			OneHotEncoder d15Vec = new OneHotEncoder().setInputCol("d15Indexer").setOutputCol("d15Vec");
			indexers.add(d15Indexer);
			indexers.add(d15Vec);
			assemblers.add("d15Indexer");
			assemblers.add("d15Vec");
			}		//	assemblers.add("d15");
		}
		
//		if(ArrayUtils.contains(trainData.columns(),"d15_poa"))
//		{		
//			List<Row> d1Max = sparkSession.sql("SELECT case when d15_poa is NULL OR d15_poa='' then '1000' else d15_poa end as d15_poa, COUNT(d15_poa) as d1_ct from TrainingTable group by d15_poa order by d1_ct desc").takeAsList(2);
//			System.out.println(" TEST:"+d1Max);
//			if(null!=d1Max && !d1Max.isEmpty() && d1Max.size()>1 && null!=d1Max.get(1).getAs("d15_poa"))
//			{
//				Row row = d1Max.get(0);
//			String d1MaxValue = row.getAs("d15_poa");
//			trainData = trainData.na().fill(d1MaxValue, new String[] {"d15_poa"});
//			StringIndexer d15poaIndexer = new StringIndexer().setInputCol("d15_poa").setOutputCol("d15poaIndexer");			
//			d15poaIndexer.setHandleInvalid("keep");
//			OneHotEncoder d15poaVec = new OneHotEncoder().setInputCol("d15poaIndexer").setOutputCol("d15poaVec");
//			indexers.add(d15poaIndexer);
//			indexers.add(d15poaVec);
//			assemblers.add("d15poaIndexer");
//			assemblers.add("d15poaVec");
//			}		//	assemblers.add("d15_poa");
//		}
		
		if(ArrayUtils.contains(trainData.columns(),"d16"))
		{		
			List<Row> d1Max = sparkSession.sql("SELECT case when d16 is NULL OR d16='' then '1000' else d16 end as d16, COUNT(d16) as d1_ct from TrainingTable group by d16 order by d1_ct desc").takeAsList(2);
			System.out.println(" TEST d16:"+d1Max);
			if(null!=d1Max && !d1Max.isEmpty() && d1Max.size()>1 && null!=d1Max.get(1).getAs("d16"))
			{
				Row row = d1Max.get(0);
			String d1MaxValue = row.getAs("d16");
			trainData = trainData.na().fill(d1MaxValue, new String[] {"d16"});
			StringIndexer d16Indexer = new StringIndexer().setInputCol("d16").setOutputCol("d16Indexer");			
			d16Indexer.setHandleInvalid("keep");
			OneHotEncoder d16Vec = new OneHotEncoder().setInputCol("d16Indexer").setOutputCol("d16Vec");
			indexers.add(d16Indexer);
			indexers.add(d16Vec);
			assemblers.add("d16Indexer");
			assemblers.add("d16Vec");
			}		//	assemblers.add("d16");
		}
		
//		if(ArrayUtils.contains(trainData.columns(),"d16_poa"))
//		{		
//			List<Row> d1Max = sparkSession.sql("SELECT case when d16_poa is NULL OR d16_poa='' then '1000' else d16_poa end as d16_poa, COUNT(d16_poa) as d1_ct from TrainingTable group by d16_poa order by d1_ct desc").takeAsList(2);
//			System.out.println(" TEST:"+d1Max);
//			if(null!=d1Max && !d1Max.isEmpty() && d1Max.size()>1 && null!=d1Max.get(1).getAs("d16_poa"))
//			{
//				Row row = d1Max.get(0);
//			String d1MaxValue = row.getAs("d16_poa");
//			trainData = trainData.na().fill(d1MaxValue, new String[] {"d16_poa"});
//			StringIndexer d16poaIndexer = new StringIndexer().setInputCol("d16_poa").setOutputCol("d16poaIndexer");			
//			d16poaIndexer.setHandleInvalid("keep");
//			OneHotEncoder d16poaVec = new OneHotEncoder().setInputCol("d16poaIndexer").setOutputCol("d16poaVec");
//			indexers.add(d16poaIndexer);
//			indexers.add(d16poaVec);
//			assemblers.add("d16poaIndexer");
//			assemblers.add("d16poaVec");
//			}		//	assemblers.add("d16_poa");
//		}
		
		if(ArrayUtils.contains(trainData.columns(),"d17"))
		{		
			List<Row> d1Max = sparkSession.sql("SELECT case when d17 is NULL OR d17='' then '1000' else d17 end as d17, COUNT(d17) as d1_ct from TrainingTable group by d17 order by d1_ct desc").takeAsList(2);
			System.out.println(" TEST d17:"+d1Max);
			if(null!=d1Max && !d1Max.isEmpty() && d1Max.size()>1 && null!=d1Max.get(1).getAs("d17"))
			{
				Row row = d1Max.get(0);
			String d1MaxValue = row.getAs("d17");
			trainData = trainData.na().fill(d1MaxValue, new String[] {"d17"});
			StringIndexer d17Indexer = new StringIndexer().setInputCol("d17").setOutputCol("d17Indexer");			
			d17Indexer.setHandleInvalid("keep");
			OneHotEncoder d17Vec = new OneHotEncoder().setInputCol("d17Indexer").setOutputCol("d17Vec");
			indexers.add(d17Indexer);
			indexers.add(d17Vec);
			assemblers.add("d17Indexer");
			assemblers.add("d17Vec");
			}		//	assemblers.add("d17");
		}
		
//		if(ArrayUtils.contains(trainData.columns(),"d17_poa"))
//		{		
//			List<Row> d1Max = sparkSession.sql("SELECT case when d17_poa is NULL OR d17_poa='' then '1000' else d17_poa end as d17_poa, COUNT(d17_poa) as d1_ct from TrainingTable group by d17_poa order by d1_ct desc").takeAsList(2);
//			if(null!=d1Max && !d1Max.isEmpty() && d1Max.size()>1 && null!=d1Max.get(1).getAs("d17_poa"))
//			{
//				Row row = d1Max.get(0);
//			String d1MaxValue = row.getAs("d17_poa");
//			trainData = trainData.na().fill(d1MaxValue, new String[] {"d17_poa"});
//			StringIndexer d17poaIndexer = new StringIndexer().setInputCol("d17_poa").setOutputCol("d17poaIndexer");			
//			d17poaIndexer.setHandleInvalid("keep");
//			OneHotEncoder d17poaVec = new OneHotEncoder().setInputCol("d17poaIndexer").setOutputCol("d17poaVec");
//			indexers.add(d17poaIndexer);
//			indexers.add(d17poaVec);
//			assemblers.add("d17poaIndexer");
//			assemblers.add("d17poaVec");
//			}//	assemblers.add("d17_poa");
//		}
		
		if(ArrayUtils.contains(trainData.columns(),"d18"))
		{		
			List<Row> d1Max = sparkSession.sql("SELECT case when d18 is NULL OR d18='' then '1000' else d18 end as d18, COUNT(d18) as d1_ct from TrainingTable group by d18 order by d1_ct desc").takeAsList(2);
			System.out.println(" TEST d18:"+d1Max);
			if(null!=d1Max && !d1Max.isEmpty() && d1Max.size()>1 && null!=d1Max.get(1).getAs("d18"))
			{
				Row row = d1Max.get(0);
			String d1MaxValue = row.getAs("d18");
			trainData = trainData.na().fill(d1MaxValue, new String[] {"d18"});
			StringIndexer d18Indexer = new StringIndexer().setInputCol("d18").setOutputCol("d18Indexer");			
			d18Indexer.setHandleInvalid("keep");
			OneHotEncoder d18Vec = new OneHotEncoder().setInputCol("d18Indexer").setOutputCol("d18Vec");
			indexers.add(d18Indexer);
			indexers.add(d18Vec);
			assemblers.add("d18Indexer");
			assemblers.add("d18Vec");
			}		//	assemblers.add("d18");
		}
		
//		if(ArrayUtils.contains(trainData.columns(),"d18_poa"))
//		{		
//			List<Row> d1Max = sparkSession.sql("SELECT case when d18_poa is NULL OR d18_poa='' then '1000' else d18_poa end as d18_poa, COUNT(d18_poa) as d1_ct from TrainingTable group by d18_poa order by d1_ct desc").takeAsList(2);
//			if(null!=d1Max && !d1Max.isEmpty() && d1Max.size()>1 && null!=d1Max.get(1).getAs("d18_poa"))
//			{
//				Row row = d1Max.get(0);
//			String d1MaxValue = row.getAs("d18_poa");
//			trainData = trainData.na().fill(d1MaxValue, new String[] {"d18_poa"});
//			StringIndexer d18poaIndexer = new StringIndexer().setInputCol("d18_poa").setOutputCol("d18poaIndexer");			
//			d18poaIndexer.setHandleInvalid("keep");
//			OneHotEncoder d18poaVec = new OneHotEncoder().setInputCol("d18poaIndexer").setOutputCol("d18poaVec");
//			indexers.add(d18poaIndexer);
//			indexers.add(d18poaVec);
//			assemblers.add("d18poaIndexer");
//			assemblers.add("d18poaVec");
//			}//	assemblers.add("d18_poa");
//		}
		
		if(ArrayUtils.contains(trainData.columns(),"d19"))
		{		
			List<Row> d1Max = sparkSession.sql("SELECT case when d19 is NULL OR d19='' then '1000' else d19 end as d19, COUNT(d19) as d1_ct from TrainingTable group by d19 order by d1_ct desc").takeAsList(2);
			System.out.println(" TEST d19:"+d1Max);
			if(null!=d1Max && !d1Max.isEmpty() && d1Max.size()>1 && null!=d1Max.get(1).getAs("d19"))
			{
				Row row = d1Max.get(0);
			String d1MaxValue = row.getAs("d19");
			trainData = trainData.na().fill(d1MaxValue, new String[] {"d19"});
			StringIndexer d19Indexer = new StringIndexer().setInputCol("d19").setOutputCol("d19Indexer");			
			d19Indexer.setHandleInvalid("keep");
			OneHotEncoder d19Vec = new OneHotEncoder().setInputCol("d19Indexer").setOutputCol("d19Vec");
			indexers.add(d19Indexer);
			indexers.add(d19Vec);
			assemblers.add("d19Indexer");
			assemblers.add("d19Vec");
			}//	assemblers.add("d19");
		}
		
//		if(ArrayUtils.contains(trainData.columns(),"d19_poa"))
//		{		
//			List<Row> d1Max = sparkSession.sql("SELECT case when d19_poa is NULL OR d19_poa='' then '1000' else d19_poa end as d19_poa, COUNT(d19_poa) as d1_ct from TrainingTable group by d19_poa order by d1_ct desc").takeAsList(2);
//			System.out.println(" TEST:"+d1Max);
//			if(null!=d1Max && !d1Max.isEmpty() && d1Max.size()>1 && null!=d1Max.get(1).getAs("d19_poa"))
//			{
//				Row row = d1Max.get(0);
//			String d1MaxValue = row.getAs("d19_poa");
//			trainData = trainData.na().fill(d1MaxValue, new String[] {"d19_poa"});
//			StringIndexer d19poaIndexer = new StringIndexer().setInputCol("d19_poa").setOutputCol("d19poaIndexer");			
//			d19poaIndexer.setHandleInvalid("keep");
//			OneHotEncoder d19poaVec = new OneHotEncoder().setInputCol("d19poaIndexer").setOutputCol("d19poaVec");
//			indexers.add(d19poaIndexer);
//			indexers.add(d19poaVec);
//			assemblers.add("d19poaIndexer");
//			assemblers.add("d19poaVec");
//			}	//		assemblers.add("d19_poa");
//		}
		
		if(ArrayUtils.contains(trainData.columns(),"d20"))
		{		
			List<Row> d1Max = sparkSession.sql("SELECT case when d20 is NULL OR d20='' then '1000' else d20 end as d20, COUNT(d20) as d1_ct from TrainingTable group by d20 order by d1_ct desc").takeAsList(2);
			System.out.println(" TEST d20:"+d1Max);
			if(null!=d1Max && !d1Max.isEmpty() && d1Max.size()>1 && null!=d1Max.get(1).getAs("d20"))
			{
				Row row = d1Max.get(0);
			String d1MaxValue = row.getAs("d20");
			trainData = trainData.na().fill(d1MaxValue, new String[] {"d20"});
			StringIndexer d20Indexer = new StringIndexer().setInputCol("d20").setOutputCol("d20Indexer");			
			d20Indexer.setHandleInvalid("keep");
			OneHotEncoder d20Vec = new OneHotEncoder().setInputCol("d20Indexer").setOutputCol("d20Vec");
			indexers.add(d20Indexer);
			indexers.add(d20Vec);
			assemblers.add("d20Indexer");
			assemblers.add("d20Vec");
			}		//	assemblers.add("d20");
		}
		
//		if(ArrayUtils.contains(trainData.columns(),"d20_poa"))
//		{		
//			List<Row> d1Max = sparkSession.sql("SELECT case when d20_poa is NULL OR d20_poa='' then '1000' else d20_poa end as d20_poa, COUNT(d20_poa) as d1_ct from TrainingTable group by d20_poa order by d1_ct desc").takeAsList(2);
//			System.out.println(" TEST:"+d1Max);
//			if(null!=d1Max && !d1Max.isEmpty() && d1Max.size()>1 && null!=d1Max.get(1).getAs("d20_poa"))
//			{
//				Row row = d1Max.get(0);
//			String d1MaxValue = row.getAs("d20_poa");
//			trainData = trainData.na().fill(d1MaxValue, new String[] {"d20_poa"});
//			StringIndexer d20poaIndexer = new StringIndexer().setInputCol("d20_poa").setOutputCol("d20poaIndexer");			
//			d20poaIndexer.setHandleInvalid("keep");
//			OneHotEncoder d20poaVec = new OneHotEncoder().setInputCol("d20poaIndexer").setOutputCol("d20poaVec");
//			indexers.add(d20poaIndexer);
//			indexers.add(d20poaVec);
//			assemblers.add("d20poaIndexer");
//			assemblers.add("d20poaVec");
//			}//			assemblers.add("d20_poa");
//		}
		
		if(ArrayUtils.contains(trainData.columns(),"d21"))
		{		
			List<Row> d1Max = sparkSession.sql("SELECT case when d21 is NULL OR d21='' then '1000' else d21 end as d21, COUNT(d21) as d1_ct from TrainingTable group by d21 order by d1_ct desc").takeAsList(2);
			System.out.println(" TEST d21:"+d1Max);
			if(null!=d1Max && !d1Max.isEmpty() && d1Max.size()>1 && null!=d1Max.get(1).getAs("d21"))
			{
				Row row = d1Max.get(0);
			String d1MaxValue = row.getAs("d21");
			trainData = trainData.na().fill(d1MaxValue, new String[] {"d21"});
			StringIndexer d21Indexer = new StringIndexer().setInputCol("d21").setOutputCol("d21Indexer");			
			d21Indexer.setHandleInvalid("keep");
			OneHotEncoder d21Vec = new OneHotEncoder().setInputCol("d21Indexer").setOutputCol("d21Vec");
			indexers.add(d21Indexer);
			indexers.add(d21Vec);
			assemblers.add("d21Indexer");
			assemblers.add("d21Vec");
			}		//	assemblers.add("d21");
		}
		
//		if(ArrayUtils.contains(trainData.columns(),"d21_poa"))
//		{		
//			List<Row> d1Max = sparkSession.sql("SELECT case when d21_poa is NULL OR d21_poa='' then '1000' else d21_poa end as d21_poa, COUNT(d21_poa) as d1_ct from TrainingTable group by d21_poa order by d1_ct desc").takeAsList(2);
//			System.out.println(" TEST:"+d1Max);
//			if(null!=d1Max && !d1Max.isEmpty() && d1Max.size()>1 && null!=d1Max.get(1).getAs("d21_poa"))
//			{
//				Row row = d1Max.get(0);
//			String d1MaxValue = row.getAs("d21_poa");
//			trainData = trainData.na().fill(d1MaxValue, new String[] {"d21_poa"});
//			StringIndexer d21poaIndexer = new StringIndexer().setInputCol("d21_poa").setOutputCol("d21poaIndexer");			
//			d21poaIndexer.setHandleInvalid("keep");
//			OneHotEncoder d21poaVec = new OneHotEncoder().setInputCol("d21poaIndexer").setOutputCol("d21poaVec");
//			indexers.add(d21poaIndexer);
//			indexers.add(d21poaVec);
//			assemblers.add("d21poaIndexer");
//			assemblers.add("d21poaVec");
//			}		//	assemblers.add("d21_poa");
//		}
		
		if(ArrayUtils.contains(trainData.columns(),"d22"))
		{		
			List<Row> d1Max = sparkSession.sql("SELECT case when d22 is NULL OR d22='' then '1000' else d22 end as d22, COUNT(d22) as d1_ct from TrainingTable group by d22 order by d1_ct desc").takeAsList(2);
			System.out.println(" TEST d22:"+d1Max);
			if(null!=d1Max && !d1Max.isEmpty() && d1Max.size()>1 && null!=d1Max.get(1).getAs("d22"))
			{
				Row row = d1Max.get(0);
			String d1MaxValue = row.getAs("d22");
			trainData = trainData.na().fill(d1MaxValue, new String[] {"d22"});
			StringIndexer d22Indexer = new StringIndexer().setInputCol("d22").setOutputCol("d22Indexer");			
			d22Indexer.setHandleInvalid("keep");
			OneHotEncoder d22Vec = new OneHotEncoder().setInputCol("d22Indexer").setOutputCol("d22Vec");
			indexers.add(d22Indexer);
			indexers.add(d22Vec);
			assemblers.add("d22Indexer");
			assemblers.add("d22Vec");
			}	//		assemblers.add("d22");
		}
		
//		if(ArrayUtils.contains(trainData.columns(),"d22_poa"))
//		{		
//			List<Row> d1Max = sparkSession.sql("SELECT case when d22_poa is NULL OR d22_poa='' then '1000' else d22_poa end as d22_poa, COUNT(d22_poa) as d1_ct from TrainingTable group by d22_poa order by d1_ct desc").takeAsList(2);
//			System.out.println(" TEST:"+d1Max);
//			if(null!=d1Max && !d1Max.isEmpty() && d1Max.size()>1 && null!=d1Max.get(1).getAs("d22_poa"))
//			{
//				Row row = d1Max.get(0);
//			String d1MaxValue = row.getAs("d22_poa");
//			trainData = trainData.na().fill(d1MaxValue, new String[] {"d22_poa"});
//			StringIndexer d22poaIndexer = new StringIndexer().setInputCol("d22_poa").setOutputCol("d22poaIndexer");			
//			d22poaIndexer.setHandleInvalid("keep");
//			OneHotEncoder d22poaVec = new OneHotEncoder().setInputCol("d22poaIndexer").setOutputCol("d22poaVec");
//			indexers.add(d22poaIndexer);
//			assemblers.add("d22poaIndexer");
//			assemblers.add("d22poaVec");
//			indexers.add(d22poaVec);
//			}	//		assemblers.add("d22_poa");
//		}
		
		if(ArrayUtils.contains(trainData.columns(),"d23"))
		{		
			List<Row> d1Max = sparkSession.sql("SELECT case when d23 is NULL OR d23='' then '1000' else d23 end as d23, COUNT(d23) as d1_ct from TrainingTable group by d23 order by d1_ct desc").takeAsList(2);
			System.out.println(" TEST d23:"+d1Max);
			if(null!=d1Max && !d1Max.isEmpty() && d1Max.size()>1 && null!=d1Max.get(1).getAs("d23"))
			{
				Row row = d1Max.get(0);
			String d1MaxValue = row.getAs("d23");
			trainData = trainData.na().fill(d1MaxValue, new String[] {"d23"});
			StringIndexer d23ndexer = new StringIndexer().setInputCol("d23").setOutputCol("d23Indexer");			
			d23ndexer.setHandleInvalid("keep");
			OneHotEncoder d23Vec = new OneHotEncoder().setInputCol("d23Indexer").setOutputCol("d23Vec");
			indexers.add(d23ndexer);
			indexers.add(d23Vec);
			assemblers.add("d23Indexer");
			assemblers.add("d23Vec");
			}		//	assemblers.add("d23");
		}
		
//		if(ArrayUtils.contains(trainData.columns(),"d23_poa"))
//		{		
//			List<Row> d1Max = sparkSession.sql("SELECT case when d23_poa is NULL OR d23_poa='' then '1000' else d23_poa end as d23_poa, COUNT(d23_poa) as d1_ct from TrainingTable group by d23_poa order by d1_ct desc").takeAsList(2);
//			System.out.println(" TEST:"+d1Max);
//			if(null!=d1Max && !d1Max.isEmpty() && d1Max.size()>1 && null!=d1Max.get(1).getAs("d23_poa"))
//			{
//				Row row = d1Max.get(0);
//			String d1MaxValue = row.getAs("d23_poa");
//			trainData = trainData.na().fill(d1MaxValue, new String[] {"d23_poa"});
//			StringIndexer d23poaIndexer = new StringIndexer().setInputCol("d23_poa").setOutputCol("d23poaIndexer");			
//			d23poaIndexer.setHandleInvalid("keep");
//			OneHotEncoder d23poaVec = new OneHotEncoder().setInputCol("d23poaIndexer").setOutputCol("d23poaVec");
//			indexers.add(d23poaIndexer);
//			indexers.add(d23poaVec);
//			assemblers.add("d23poaIndexer");
//			assemblers.add("d23poaVec");
//			}	//		assemblers.add("d23_poa");
//		}
		
//		if(ArrayUtils.contains(trainData.columns(),"d24"))
//		{		
//			List<Row> d1Max = sparkSession.sql("SELECT case when d24 is NULL OR d24='' then '1000' else d24 end as d24, COUNT(d24) as d1_ct from TrainingTable group by d24 order by d1_ct desc").takeAsList(2);
//			if(null!=d1Max && !d1Max.isEmpty() && d1Max.size()>1 && null!=d1Max.get(1).getAs("d24"))
//			{
//				Row row = d1Max.get(0);
//			String d1MaxValue = row.getAs("d24");
//			trainData = trainData.na().fill(d1MaxValue, new String[] {"d24"});
//			StringIndexer d24Indexer = new StringIndexer().setInputCol("d24").setOutputCol("d24Indexer");			
//			d24Indexer.setHandleInvalid("keep");
//			OneHotEncoder d24Vec = new OneHotEncoder().setInputCol("d24Indexer").setOutputCol("d24Vec");
//			indexers.add(d24Indexer);
//			indexers.add(d24Vec);
//			assemblers.add("d24Indexer");
//			assemblers.add("d24Vec");
//			}//	assemblers.add("d24");
//		}
		
//		if(ArrayUtils.contains(trainData.columns(),"d24_poa"))
//		{		
//			List<Row> d1Max = sparkSession.sql("SELECT case when d24_poa is NULL OR d24_poa='' then '1000' else d24_poa end as d24_poa, COUNT(d24_poa) as d1_ct from TrainingTable group by d24_poa order by d1_ct desc").takeAsList(2);
//			System.out.println(" TEST:"+d1Max);
//			if(null!=d1Max && !d1Max.isEmpty() && d1Max.size()>1 && null!=d1Max.get(1).getAs("d24_poa"))
//			{
//				Row row = d1Max.get(0);
//			String d1MaxValue = row.getAs("d24_poa");
//			trainData = trainData.na().fill(d1MaxValue, new String[] {"d24_poa"});
//			StringIndexer d24poaIndexer = new StringIndexer().setInputCol("d24_poa").setOutputCol("d24poaIndexer");			
//			d24poaIndexer.setHandleInvalid("keep");
//			OneHotEncoder d24poaVec = new OneHotEncoder().setInputCol("d24poaIndexer").setOutputCol("d24poaVec");
//			indexers.add(d24poaIndexer);
//			indexers.add(d24poaVec);
//			assemblers.add("d24poaIndexer");
//			assemblers.add("d24poaVec");
//	//		assemblers.add("d24_poa");
//			}
//		}
		//Other Diag codes - Ends		
		
		
		//Other Procedure codes - Starts	
//				if(ArrayUtils.contains(trainData.columns(),"p1"))
//				{		
//					List<Row> d1Max = sparkSession.sql("SELECT p1, COUNT(p1) as d1_ct from TrainingTable group by p1 order by d1_ct desc").takeAsList(2);
//					if(null!=d1Max && !d1Max.isEmpty() && d1Max.size()>1 && null!=d1Max.get(1).getAs("p1"))
//					{
//						Row row = d1Max.get(0);
//					String d1MaxValue = row.getAs("p1");
//					trainData = trainData.na().fill(d1MaxValue, new String[] {"p1"});
//					StringIndexer p1Indexer = new StringIndexer().setInputCol("p1").setOutputCol("p1Indexer");
//					OneHotEncoder p1Vec = new OneHotEncoder().setInputCol("p1Indexer").setOutputCol("p1Vec");
//					indexers.add(p1Indexer);
//					indexers.add(p1Vec);
//				////	assemblers.add("p1");
//					}
//				}
//				if(ArrayUtils.contains(trainData.columns(),"p2"))
//				{		
//					List<Row> d1Max = sparkSession.sql("SELECT p2, COUNT(p2) as d1_ct from TrainingTable group by p2 order by d1_ct desc").takeAsList(2);
//					if(null!=d1Max && !d1Max.isEmpty() && d1Max.size()>1 && null!=d1Max.get(1).getAs("p2"))
//					{
//						Row row = d1Max.get(0);
//					String d1MaxValue = row.getAs("p2");
//					trainData = trainData.na().fill(d1MaxValue, new String[] {"p2"});
//					StringIndexer p2Indexer = new StringIndexer().setInputCol("p2").setOutputCol("p2Indexer");
//					OneHotEncoder p2Vec = new OneHotEncoder().setInputCol("p2Indexer").setOutputCol("p2Vec");
//					indexers.add(p2Indexer);
//					indexers.add(p2Vec);
//				//	assemblers.add("p2");
//					}
//				}
//				if(ArrayUtils.contains(trainData.columns(),"p3"))
//				{		
//					List<Row> d1Max = sparkSession.sql("SELECT p3, COUNT(p3) as d1_ct from TrainingTable group by p3 order by d1_ct desc").takeAsList(2);
//					if(null!=d1Max && !d1Max.isEmpty() && d1Max.size()>1 && null!=d1Max.get(1).getAs("p3"))
//					{
//						Row row = d1Max.get(0);
//					String d1MaxValue = row.getAs("p3");
//					trainData = trainData.na().fill(d1MaxValue, new String[] {"p3"});
//				StringIndexer p3Indexer = new StringIndexer().setInputCol("p3").setOutputCol("p3Indexer");
//					OneHotEncoder p3Vec = new OneHotEncoder().setInputCol("p3Indexer").setOutputCol("p3Vec");
//					indexers.add(p3Indexer);
//					indexers.add(p3Vec);
//				//	assemblers.add("p3");
//					}
//				}
//				if(ArrayUtils.contains(trainData.columns(),"p4"))
//				{		
//					List<Row> d1Max = sparkSession.sql("SELECT p4, COUNT(p4) as d1_ct from TrainingTable group by p4 order by d1_ct desc").takeAsList(2);
//					if(null!=d1Max && !d1Max.isEmpty() && d1Max.size()>1 && null!=d1Max.get(1).getAs("p4"))
//					{
//						Row row = d1Max.get(0);
//					String d1MaxValue = row.getAs("p4");
//					trainData = trainData.na().fill(d1MaxValue, new String[] {"p4"});
//					StringIndexer p4Indexer = new StringIndexer().setInputCol("p4").setOutputCol("p4Indexer");
//					OneHotEncoder p4Vec = new OneHotEncoder().setInputCol("p4Indexer").setOutputCol("p4Vec");
//					indexers.add(p4Indexer);
//					indexers.add(p4Vec);
//					//assemblers.add("p4");
//					}
//				}
//				if(ArrayUtils.contains(trainData.columns(),"p5"))
//				{		
//					List<Row> d1Max = sparkSession.sql("SELECT p5, COUNT(p5) as d1_ct from TrainingTable group by p5 order by d1_ct desc").takeAsList(2);
//					if(null!=d1Max && !d1Max.isEmpty() && d1Max.size()>1 && null!=d1Max.get(1).getAs("p5"))
//					{
//						Row row = d1Max.get(0);
//					String d1MaxValue = row.getAs("p5");
//					trainData = trainData.na().fill(d1MaxValue, new String[] {"p5"});
//					StringIndexer p5Indexer = new StringIndexer().setInputCol("p5").setOutputCol("p5Indexer");
//					OneHotEncoder p5Vec = new OneHotEncoder().setInputCol("p5Indexer").setOutputCol("p5Vec");
//					indexers.add(p5Indexer);
//					indexers.add(p5Vec);
//					//assemblers.add("p5");
//					}
//				}
//				if(ArrayUtils.contains(trainData.columns(),"p6"))
//				{		
//					List<Row> d1Max = sparkSession.sql("SELECT p6, COUNT(p6) as d1_ct from TrainingTable group by p6 order by d1_ct desc").takeAsList(2);
//					if(null!=d1Max && !d1Max.isEmpty() && d1Max.size()>1 && null!=d1Max.get(1).getAs("p6"))
//					{
//						Row row = d1Max.get(0);
//					String d1MaxValue = row.getAs("p6");
//					trainData = trainData.na().fill(d1MaxValue, new String[] {"p6"});
//					StringIndexer p6Indexer = new StringIndexer().setInputCol("p6").setOutputCol("p6Indexer");
//					OneHotEncoder p6Vec = new OneHotEncoder().setInputCol("p6Indexer").setOutputCol("p6Vec");
//					indexers.add(p6Indexer);
//					indexers.add(p6Vec);
//				//	assemblers.add("p6");
//					}
//				}
//				if(ArrayUtils.contains(trainData.columns(),"p7"))
//				{		
//					List<Row> d1Max = sparkSession.sql("SELECT p7, COUNT(p7) as d1_ct from TrainingTable group by p7 order by d1_ct desc").takeAsList(2);
//					if(null!=d1Max && !d1Max.isEmpty() && d1Max.size()>1 && null!=d1Max.get(1).getAs("p7"))
//					{
//						Row row = d1Max.get(0);
//					String d1MaxValue = row.getAs("p7");
//					trainData = trainData.na().fill(d1MaxValue, new String[] {"p7"});
//					StringIndexer p7Indexer = new StringIndexer().setInputCol("p7").setOutputCol("p7Indexer");
//					OneHotEncoder p7Vec = new OneHotEncoder().setInputCol("p7Indexer").setOutputCol("p7Vec");
//					indexers.add(p7Indexer);
//					indexers.add(p7Vec);
//				//	assemblers.add("p7");
//					}
//				}
//				if(ArrayUtils.contains(trainData.columns(),"p8"))
//				{		
//					List<Row> d1Max = sparkSession.sql("SELECT p8, COUNT(p8) as d1_ct from TrainingTable group by p8 order by d1_ct desc").takeAsList(2);
//					System.out.println("p8Indexer:"+ d1Max);
//					if(null!=d1Max && !d1Max.isEmpty() && d1Max.size()>1 && null!=d1Max.get(1).getAs("p8"))
//					{
//						Row row = d1Max.get(0);
//					String d1MaxValue = row.getAs("p8");
//					trainData = trainData.na().fill(d1MaxValue, new String[] {"p8"});
//					StringIndexer p8Indexer = new StringIndexer().setInputCol("p8").setOutputCol("p8Indexer");
//					OneHotEncoder p8Vec = new OneHotEncoder().setInputCol("p8Indexer").setOutputCol("p8Vec");
//					indexers.add(p8Indexer);
//					indexers.add(p8Vec);
//					//assemblers.add("p8");
//					}
//				}
//				if(ArrayUtils.contains(trainData.columns(),"p9"))
//				{		
//					List<Row> d1Max = sparkSession.sql("SELECT p9, COUNT(p9) as d1_ct from TrainingTable group by p9 order by d1_ct desc").takeAsList(2);
//					System.out.println("p9Indexer "+d1Max);
//					if(null!=d1Max && !d1Max.isEmpty() && d1Max.size()>1 && null!=d1Max.get(1).getAs("p9"))
//					{
//						Row row = d1Max.get(0);
//						String d1MaxValue = row.getAs("p9");
//						trainData = trainData = trainData.na().fill(d1MaxValue, new String[] {"p9"});
//						StringIndexer p9Indexer = new StringIndexer().setInputCol("p9").setOutputCol("p9Indexer");
//						OneHotEncoder p9Vec = new OneHotEncoder().setInputCol("p9Indexer").setOutputCol("p9Vec");
//						indexers.add(p9Indexer);
//						indexers.add(p9Vec);
//					//	assemblers.add("p9");
//					}
//					else
//					{
//						trainData = trainData.drop("p9");
//					}
//				}
//				if(ArrayUtils.contains(trainData.columns(),"p10"))
//				{		
//					List<Row> d1Max = sparkSession.sql("SELECT p10, COUNT(p10) as d1_ct from TrainingTable group by p10 order by d1_ct desc").takeAsList(2);
//					if(null!=d1Max && !d1Max.isEmpty() && d1Max.size()>1 && null!=d1Max.get(1).getAs("p10"))
//					{
//						Row row = d1Max.get(0);
//					String d1MaxValue = row.getAs("p10");
//					trainData = trainData.na().fill(d1MaxValue, new String[] {"p10"});
//					StringIndexer p10Indexer = new StringIndexer().setInputCol("p10").setOutputCol("p10Indexer");
//					OneHotEncoder p10Vec = new OneHotEncoder().setInputCol("p10Indexer").setOutputCol("p10Vec");
//					indexers.add(p10Indexer);
//					indexers.add(p10Vec);
//				//	assemblers.add("p10");
//					}
//					else
//					{
//						trainData = trainData.drop("p10");
//					}
//				}
//				if(ArrayUtils.contains(trainData.columns(),"p11"))
//				{		
//					List<Row> d1Max = sparkSession.sql("SELECT p11, COUNT(p11) as d1_ct from TrainingTable group by p11 order by d1_ct desc").takeAsList(2);
//					if(null!=d1Max && !d1Max.isEmpty() && d1Max.size()>1 && null!=d1Max.get(1).getAs("p11"))
//					{
//						Row row = d1Max.get(0);
//					String d1MaxValue = row.getAs("p11");
//					trainData = trainData.na().fill(d1MaxValue, new String[] {"p11"});
//					StringIndexer p11Indexer = new StringIndexer().setInputCol("p11").setOutputCol("p11Indexer");
//					OneHotEncoder p11Vec = new OneHotEncoder().setInputCol("p11Indexer").setOutputCol("p11Vec");
//					indexers.add(p11Indexer);
//					indexers.add(p11Vec);
//				//	assemblers.add("p11");
//					}
//					else
//					{
//						trainData = trainData.drop("p11");
//					}
//				}
//				if(ArrayUtils.contains(trainData.columns(),"p12"))
//				{		
//					List<Row> d1Max = sparkSession.sql("SELECT p12, COUNT(p12) as d1_ct from TrainingTable group by p12 order by d1_ct desc").takeAsList(2);
//					System.out.println("p12Indexer:"+d1Max);
//					if(null!=d1Max && !d1Max.isEmpty() && d1Max.size()>1 && null!=d1Max.get(1).getAs("p12"))
//					{
//						Row row = d1Max.get(0);
//					String d1MaxValue = row.getAs("p12");
//					trainData = trainData.na().fill(d1MaxValue, new String[] {"p12"});
//					StringIndexer p12Indexer = new StringIndexer().setInputCol("p12").setOutputCol("p12Indexer");
//					OneHotEncoder p12Vec = new OneHotEncoder().setInputCol("p12Indexer").setOutputCol("p12Vec");
//					indexers.add(p12Indexer);
//					indexers.add(p12Vec);
//					//assemblers.add("p12");
//					}
//					else
//					{
//						trainData = trainData.drop("p12");
//					}
//				}
//				if(ArrayUtils.contains(trainData.columns(),"p13"))
//				{		
//					List<Row> d1Max = sparkSession.sql("SELECT p13, COUNT(p13) as d1_ct from TrainingTable group by p13 order by d1_ct desc").takeAsList(2);
//					System.out.println("p13 indexser:"+d1Max);
//					if(null!=d1Max && !d1Max.isEmpty() && d1Max.size()>1 && null!=d1Max.get(1).getAs("p13"))
//					{
//						Row row = d1Max.get(0);
//					String d1MaxValue = row.getAs("p13");
//					trainData = trainData.na().fill(d1MaxValue, new String[] {"p13"});
//					StringIndexer p13Indexer = new StringIndexer().setInputCol("p13").setOutputCol("p13Indexer");
//					OneHotEncoder p13Vec = new OneHotEncoder().setInputCol("p13Indexer").setOutputCol("p13Vec");
//					indexers.add(p13Indexer);
//					indexers.add(p13Vec);
//				//	assemblers.add("p13");
//					}
//					else
//					{
//						trainData = trainData.drop("p13");
//					}
//				}
//				if(ArrayUtils.contains(trainData.columns(),"p14"))
//				{		
//					List<Row> d1Max = sparkSession.sql("SELECT p14, COUNT(p14) as d1_ct from TrainingTable group by p14 order by d1_ct desc").takeAsList(2);
//					if(null!=d1Max && !d1Max.isEmpty() && d1Max.size()>1 && null!=d1Max.get(1).getAs("p14"))
//					{
//						Row row = d1Max.get(0);
//					String d1MaxValue = row.getAs("p14");
//					trainData = trainData.na().fill(d1MaxValue, new String[] {"p14"});
//					StringIndexer p14Indexer = new StringIndexer().setInputCol("p14").setOutputCol("p14Indexer");
//					OneHotEncoder p14Vec = new OneHotEncoder().setInputCol("p14Indexer").setOutputCol("p14Vec");
//					indexers.add(p14Indexer);
//					indexers.add(p14Vec);
//			//		assemblers.add("p14");
//					}
//					else
//					{
//						trainData = trainData.drop("p14");
//					}
//				}
//				if(ArrayUtils.contains(trainData.columns(),"p15"))
//				{		
//					List<Row> d1Max = sparkSession.sql("SELECT p15, COUNT(p15) as d1_ct from TrainingTable group by p15 order by d1_ct desc").takeAsList(2);
//					System.out.println("d1Max List size:" + d1Max.size());
//					System.out.println("d1Max List size:" + d1Max);
//					if(null!=d1Max && !d1Max.isEmpty() && d1Max.size()>1 && null!=d1Max.get(1).getAs("p15"))
//					{
//						Row row = d1Max.get(0);
//						String d1MaxValue = row.getAs("p15");
//						System.out.println("p15Indexer va:" + d1MaxValue);
//						trainData = trainData.na().fill(d1MaxValue, new String[] {"p15"});
//						trainData.select("p15").show();
//						StringIndexer p15Indexer = new StringIndexer().setInputCol("p15").setOutputCol("p15Indexer");
//						OneHotEncoder p15Vec = new OneHotEncoder().setInputCol("p15Indexer").setOutputCol("p15Vec");
//						indexers.add(p15Indexer);
//						indexers.add(p15Vec);
//					//	assemblers.add("p15");
//					}
//					else
//					{
//						trainData = trainData.drop("p15");
//					}
//				}
//				if(ArrayUtils.contains(trainData.columns(),"p16"))
//				{		
//					List<Row> d1Max = sparkSession.sql("SELECT p16, COUNT(p16) as d1_ct from TrainingTable group by p16 order by d1_ct desc").takeAsList(2);
//					System.out.println("p16Indexer:"+d1Max);
//					if(null!=d1Max && !d1Max.isEmpty() && d1Max.size()>1 && null!=d1Max.get(1).getAs("p16"))
//					{
//						Row row = d1Max.get(0);
//					String d1MaxValue = row.getAs("p16");
//					trainData = trainData.na().fill(d1MaxValue, new String[] {"p16"});
//					StringIndexer p16Indexer = new StringIndexer().setInputCol("p16").setOutputCol("p16Indexer");
//					OneHotEncoder p16Vec = new OneHotEncoder().setInputCol("p16Indexer").setOutputCol("p16Vec");
//					indexers.add(p16Indexer);
//					indexers.add(p16Vec);
//				//	assemblers.add("p16");
//					}
//					else
//					{
//						trainData = trainData.drop("p16");
//					}
//				}
//				if(ArrayUtils.contains(trainData.columns(),"p17"))
//				{		
//					List<Row> d1Max = sparkSession.sql("SELECT p17, COUNT(p17) as d1_ct from TrainingTable group by p17 order by d1_ct desc").takeAsList(2);
//					System.out.println("p17Indexer:"+d1Max);
//					if(null!=d1Max && !d1Max.isEmpty() && d1Max.size()>1 && null!=d1Max.get(1).getAs("p17"))
//					{
//						Row row = d1Max.get(0);
//					String d1MaxValue = row.getAs("p17");
//					trainData = trainData.na().fill(d1MaxValue, new String[] {"p17"});
//					StringIndexer p17Indexer = new StringIndexer().setInputCol("p17").setOutputCol("p17Indexer");
//					OneHotEncoder p17Vec = new OneHotEncoder().setInputCol("p17Indexer").setOutputCol("p17Vec");
//					indexers.add(p17Indexer);
//					indexers.add(p17Vec);
//				//	assemblers.add("p17");
//					}
//					else
//					{
//						trainData = trainData.drop("p17");
//					}
//					
//				}
//				if(ArrayUtils.contains(trainData.columns(),"p18"))
//				{		
//					List<Row> d1Max = sparkSession.sql("SELECT p18, COUNT(p18) as d1_ct from TrainingTable group by p18 order by d1_ct desc").takeAsList(2);
//					System.out.println("p18Indexer:" + d1Max);
//					if(null!=d1Max && !d1Max.isEmpty() && d1Max.size()>1 && null!=d1Max.get(1).getAs("p18"))
//					{
//						Row row = d1Max.get(0);
//					String d1MaxValue = row.getAs("p18");
//					trainData = trainData.na().fill(d1MaxValue, new String[] {"p18"});
//					StringIndexer p18Indexer = new StringIndexer().setInputCol("p18").setOutputCol("p18Indexer");
//					OneHotEncoder p18Vec = new OneHotEncoder().setInputCol("p18Indexer").setOutputCol("p18Vec");
//					indexers.add(p18Indexer);
//					indexers.add(p18Vec);
//				//	assemblers.add("p18");
//					}
//					else
//					{
//						trainData = trainData.drop("p18");
//					}
//				}
//				if(ArrayUtils.contains(trainData.columns(),"p19"))
//				{		
//					List<Row> d1Max = sparkSession.sql("SELECT p19, COUNT(p19) as d1_ct from TrainingTable group by p19 order by d1_ct desc").takeAsList(2);
//					if(null!=d1Max && !d1Max.isEmpty() && d1Max.size()>1 && null!=d1Max.get(1).getAs("p19"))
//					{
//						Row row = d1Max.get(0);
//					String d1MaxValue = row.getAs("p19");
//					trainData = trainData.na().fill(d1MaxValue, new String[] {"p19"});
//					StringIndexer p19Indexer = new StringIndexer().setInputCol("p19").setOutputCol("p19Indexer");
//					OneHotEncoder p19Vec = new OneHotEncoder().setInputCol("p19Indexer").setOutputCol("p19Vec");
//					indexers.add(p19Indexer);
//					indexers.add(p19Vec);
//				//	assemblers.add("p19");
//					}
//					else
//					{
//						trainData = trainData.drop("p19");
//					}
//				}
//				if(ArrayUtils.contains(trainData.columns(),"p20"))
//				{		
//					List<Row> d1Max = sparkSession.sql("SELECT p20, COUNT(p20) as d1_ct from TrainingTable group by p20 order by d1_ct desc").takeAsList(2);
//					if(null!=d1Max && !d1Max.isEmpty() && d1Max.size()>1 && null!=d1Max.get(1).getAs("p20"))
//					{
//						Row row = d1Max.get(0);
//					String d1MaxValue = row.getAs("p20");
//					trainData = trainData.na().fill(d1MaxValue, new String[] {"p20"});
//					StringIndexer p20Indexer = new StringIndexer().setInputCol("p20").setOutputCol("p20Indexer");
//					OneHotEncoder p20Vec = new OneHotEncoder().setInputCol("p20Indexer").setOutputCol("p20Vec");
//					indexers.add(p20Indexer);
//					indexers.add(p20Vec);
//			//		assemblers.add("p20");
//					}
//					else
//					{
//						trainData = trainData.drop("p20");
//					}
//				}
//				if(ArrayUtils.contains(trainData.columns(),"p21"))
//				{		
//					List<Row> d1Max = sparkSession.sql("SELECT p21, COUNT(p21) as d1_ct from TrainingTable group by p21 order by d1_ct desc").takeAsList(2);
//					if(null!=d1Max && !d1Max.isEmpty() && d1Max.size()>1 && null!=d1Max.get(1).getAs("p21"))
//					{
//						Row row = d1Max.get(0);
//					String d1MaxValue = row.getAs("p21");
//					trainData = trainData.na().fill(d1MaxValue, new String[] {"p21"});
//					StringIndexer p21Indexer = new StringIndexer().setInputCol("p21").setOutputCol("p21Indexer");
//					OneHotEncoder p21Vec = new OneHotEncoder().setInputCol("p21Indexer").setOutputCol("p21Vec");
//					indexers.add(p21Indexer);
//					indexers.add(p21Vec);
//				//	assemblers.add("p21");
//					}
//					else
//					{
//						trainData = trainData.drop("p21");
//					}
//				}
//				if(ArrayUtils.contains(trainData.columns(),"p22"))
//				{		
//					List<Row> d1Max = sparkSession.sql("SELECT p22, COUNT(p22) as d1_ct from TrainingTable group by p22 order by d1_ct desc").takeAsList(2);
//					if(null!=d1Max && !d1Max.isEmpty() && d1Max.size()>1 && null!=d1Max.get(1).getAs("p22"))
//					{
//						Row row = d1Max.get(0);
//					String d1MaxValue = row.getAs("p22");
//					trainData = trainData.na().fill(d1MaxValue, new String[] {"p22"});
//					StringIndexer p22Indexer = new StringIndexer().setInputCol("p22").setOutputCol("p22Indexer");
//					OneHotEncoder p22Vec = new OneHotEncoder().setInputCol("p22Indexer").setOutputCol("p22Vec");
//					indexers.add(p22Indexer);
//					indexers.add(p22Vec);
//				//	assemblers.add("p22");
//					}
//					else
//					{
//						trainData = trainData.drop("p22");
//					}
//				}
//				if(ArrayUtils.contains(trainData.columns(),"p23"))
//				{		
//					List<Row> d1Max = sparkSession.sql("SELECT p23, COUNT(p23) as d1_ct from TrainingTable group by p23 order by d1_ct desc").takeAsList(2);
//					if(null!=d1Max && !d1Max.isEmpty() && d1Max.size()>1 && null!=d1Max.get(1).getAs("p23"))
//					{
//						Row row = d1Max.get(0);
//					String d1MaxValue = row.getAs("p23");
//					trainData = trainData.na().fill(d1MaxValue, new String[] {"p23"});
//					StringIndexer p23Indexer = new StringIndexer().setInputCol("p23").setOutputCol("p23Indexer");
//					OneHotEncoder p23Vec = new OneHotEncoder().setInputCol("p23Indexer").setOutputCol("p23Vec");
//					indexers.add(p23Indexer);
//					indexers.add(p23Vec);
//				//	assemblers.add("p23");
//					}
//					else
//					{
//						trainData = trainData.drop("p23");
//					}
//				}
//				if(ArrayUtils.contains(trainData.columns(),"p24"))
//				{		
//					List<Row> d1Max = sparkSession.sql("SELECT p24, COUNT(p24) as d1_ct from TrainingTable group by p24 order by d1_ct desc").takeAsList(2);
//					if(null!=d1Max && !d1Max.isEmpty() && d1Max.size()>1 && null!=d1Max.get(1).getAs("p24"))
//					{
//						Row row = d1Max.get(0);
//					String d1MaxValue = row.getAs("p24");
//					trainData = trainData.na().fill(d1MaxValue, new String[] {"p24"});
//					StringIndexer p24Indexer = new StringIndexer().setInputCol("p24").setOutputCol("p24Indexer");
//					OneHotEncoder p24Vec = new OneHotEncoder().setInputCol("p24Indexer").setOutputCol("p24Vec");
//					indexers.add(p24Indexer);
//					indexers.add(p24Vec);
//			//		assemblers.add("p24");
//					}
//					else
//					{
//						trainData = trainData.drop("p24");
//					}
//				}
				//Other Procedure codes - Ends
				
				if(ArrayUtils.contains(trainData.columns(),"admtDiagCd"))
				{		
					List<Row> d1Max = sparkSession.sql("SELECT case when admtDiagCd is NULL OR admtDiagCd='' then '1000' else admtDiagCd end as admtDiagCd, COUNT(admtDiagCd) as d1_ct from TrainingTable group by admtDiagCd order by d1_ct desc").takeAsList(2);
					System.out.println("TEST: admt" +d1Max );
					if(null!=d1Max && !d1Max.isEmpty() && d1Max.size()>1 && null!=d1Max.get(1).getAs("admtDiagCd"))
					{
						Row row = d1Max.get(0);
					String d1MaxValue = row.getAs("admtDiagCd");
					trainData = trainData.na().fill(d1MaxValue, new String[] {"admtDiagCd"});
					StringIndexer admtDiagCdIndexer = new StringIndexer().setInputCol("admtDiagCd").setOutputCol("admtDiagCdIndexer");			
					admtDiagCdIndexer.setHandleInvalid("keep");
					OneHotEncoder admtDiagCdVec = new OneHotEncoder().setInputCol("admtDiagCdIndexer").setOutputCol("admtDiagCdVec");
					indexers.add(admtDiagCdIndexer);
					indexers.add(admtDiagCdVec);
					assemblers.add("admtDiagCdIndexer");
					assemblers.add("admtDiagCdVec");
					}//	assemblers.add("admtDiagCd");
				}
				if(ArrayUtils.contains(trainData.columns(),"admtDiagCdPoa"))
				{		
					List<Row> d1Max = sparkSession.sql("SELECT case when admtDiagCdPoa is NULL OR admtDiagCdPoa='' then '1000' else admtDiagCdPoa end as admtDiagCdPoa, COUNT(admtDiagCdPoa) as d1_ct from TrainingTable group by admtDiagCdPoa order by d1_ct desc").takeAsList(2);
					System.out.println("TEST: admtp" +d1Max );
					if(null!=d1Max && !d1Max.isEmpty() && d1Max.size()>1 && null!=d1Max.get(1).getAs("admtDiagCdPoa"))
					{
						Row row = d1Max.get(0);
						String d1MaxValue = row.getAs("admtDiagCdPoa");
						trainData = trainData.na().fill(d1MaxValue, new String[] {"admtDiagCdPoa"});
						StringIndexer admtDiagCdPoaIndexer = new StringIndexer().setInputCol("admtDiagCdPoa").setOutputCol("admtDiagCdPoaIndexer");			
						admtDiagCdPoaIndexer.setHandleInvalid("keep");
						OneHotEncoder admtDiagCdPoaVec = new OneHotEncoder().setInputCol("admtDiagCdPoaIndexer").setOutputCol("admtDiagCdPoaVec");
						indexers.add(admtDiagCdPoaIndexer);
						indexers.add(admtDiagCdPoaVec);
						assemblers.add("admtDiagCdPoaIndexer");
						assemblers.add("admtDiagCdPoaVec");
					//	assemblers.add("admtDiagCdPoa");
					}
					else
					{
						trainData = trainData.drop("admtDiagCdPoa");
					}
				}
				if(ArrayUtils.contains(trainData.columns(),"prncplDgnsCd"))
				{		
					List<Row> d1Max = sparkSession.sql("SELECT case when prncplDgnsCd is NULL OR prncplDgnsCd='' then '1000' else prncplDgnsCd end as prncplDgnsCd, COUNT(prncplDgnsCd) as d1_ct from TrainingTable group by prncplDgnsCd order by d1_ct desc").takeAsList(2);
					System.out.println("TEST: pricp" +d1Max );
					if(null!=d1Max && !d1Max.isEmpty() && d1Max.size()>1 && null!=d1Max.get(1).getAs("prncplDgnsCd"))
					{
						Row row = d1Max.get(0);
						String d1MaxValue = row.getAs("prncplDgnsCd");
						trainData = trainData.na().fill(d1MaxValue, new String[] {"prncplDgnsCd"});
						StringIndexer prncplDgnsCdIndexer = new StringIndexer().setInputCol("prncplDgnsCd").setOutputCol("prncplDgnsCdIndexer");			
						prncplDgnsCdIndexer.setHandleInvalid("keep");
						OneHotEncoder prncplDgnsCdVec = new OneHotEncoder().setInputCol("prncplDgnsCdIndexer").setOutputCol("prncplDgnsCdVec");
						indexers.add(prncplDgnsCdIndexer);
						indexers.add(prncplDgnsCdVec);
						assemblers.add("prncplDgnsCdIndexer");
						assemblers.add("prncplDgnsCdVec");
				//		assemblers.add("prncplDgnsCd");
					}
					else
					{
						trainData = trainData.drop("prncplDgnsCd");
					}
				}
				
				if(ArrayUtils.contains(trainData.columns(),"prncplDgnsPoa"))
				{		
					List<Row> d1Max = sparkSession.sql("SELECT case when prncplDgnsPoa is NULL OR prncplDgnsPoa='' then '1000' else prncplDgnsPoa end as prncplDgnsPoa, COUNT(prncplDgnsPoa) as d1_ct from TrainingTable group by prncplDgnsPoa order by d1_ct desc").takeAsList(2);
					System.out.println("TEST: prnpdngsPOA" +d1Max );
					if(null!=d1Max && !d1Max.isEmpty() && d1Max.size()>1 && null!=d1Max.get(1).getAs("prncplDgnsPoa"))
					{
						Row row = d1Max.get(0);
					String d1MaxValue = row.getAs("prncplDgnsPoa");
						if(!StringUtils.isEmpty(d1MaxValue))
						{
							trainData = trainData.na().fill(d1MaxValue, new String[] {"prncplDgnsPoa"});
							StringIndexer prncplDgnsPoaIndexer = new StringIndexer().setInputCol("prncplDgnsPoa").setOutputCol("prncplDgnsPoaIndexer");			
							prncplDgnsPoaIndexer.setHandleInvalid("keep");
							OneHotEncoder prncplDgnsPoaVec = new OneHotEncoder().setInputCol("prncplDgnsPoaIndexer").setOutputCol("prncplDgnsPoaVec");
							indexers.add(prncplDgnsPoaIndexer);
							indexers.add(prncplDgnsPoaVec);
							assemblers.add("prncplDgnsPoaIndexer");
							assemblers.add("prncplDgnsPoaVec");
						//	assemblers.add("prncplDgnsPoa");
						}
						else
						{
							trainData = trainData.drop("prncplDgnsPoa");
						}
					}
				}
				if(ArrayUtils.contains(trainData.columns(),"prncplPrcdrCd"))
				{		
					List<Row> d1Max = sparkSession.sql("SELECT case when prncplPrcdrCd is NULL OR prncplPrcdrCd='' then '1000' else prncplPrcdrCd end as prncplPrcdrCd, COUNT(prncplPrcdrCd) as d1_ct from TrainingTable group by prncplPrcdrCd order by d1_ct desc").takeAsList(2);
					System.out.println("TEST prncplPrcdrCd:"+d1Max.toString());
					if(null!=d1Max && !d1Max.isEmpty() && d1Max.size()>1 &&  null!=d1Max.get(1).getAs("prncplPrcdrCd"))
					{
						Row row = d1Max.get(0);
					String d1MaxValue = row.getAs("prncplPrcdrCd");
					trainData = trainData.na().fill(d1MaxValue, new String[] {"prncplPrcdrCd"});
					StringIndexer prncplPrcdrCdIndexer = new StringIndexer().setInputCol("prncplPrcdrCd").setOutputCol("prncplPrcdrCdIndexer");			
					prncplPrcdrCdIndexer.setHandleInvalid("keep");
					OneHotEncoder prncplPrcdrCdVec = new OneHotEncoder().setInputCol("prncplPrcdrCdIndexer").setOutputCol("prncplPrcdrCdVec");
					indexers.add(prncplPrcdrCdIndexer);
					indexers.add(prncplPrcdrCdVec);
					assemblers.add("prncplPrcdrCdIndexer");
					assemblers.add("prncplPrcdrCdVec");
			//		assemblers.add("prncplPrcdrCd");
					}
				}
				if(ArrayUtils.contains(trainData.columns(),"patientStatusLkpcd"))
				{		
					List<Row> d1Max = sparkSession.sql("SELECT patientStatusLkpcd, COUNT(patientStatusLkpcd) as d1_ct from TrainingTable group by patientStatusLkpcd order by d1_ct desc").takeAsList(2);
					System.out.println("TEST patientStatusLkpcd:"+d1Max);
					if(null!=d1Max && !d1Max.isEmpty() && d1Max.size()>1 && null!=d1Max.get(1).getAs("patientStatusLkpcd"))
					{
						Row row = d1Max.get(0);
						String d1MaxValue = row.getAs("patientStatusLkpcd");
						trainData = trainData.na().fill(d1MaxValue, new String[] {"patientStatusLkpcd"});
						StringIndexer patientStatusLkpcdIndexer = new StringIndexer().setInputCol("patientStatusLkpcd").setOutputCol("patientStatusLkpcdIndexer");
						indexers.add(patientStatusLkpcdIndexer);			
						patientStatusLkpcdIndexer.setHandleInvalid("keep");
						OneHotEncoder patientStatusLkpcdVec = new OneHotEncoder().setInputCol("patientStatusLkpcdIndexer").setOutputCol("patientStatusLkpcdVec");
						indexers.add(patientStatusLkpcdVec);
						assemblers.add("patientStatusLkpcdIndexer");
						assemblers.add("patientStatusLkpcdVec");
					}
					else
					{
						Row row = d1Max.get(0);
						String d1MaxValue = row.getAs("patientStatusLkpcd");
						trainData = trainData.na().fill(d1MaxValue, new String[] {"patientStatusLkpcd"});
						StringIndexer patientStatusLkpcdIndexer = new StringIndexer().setInputCol("patientStatusLkpcd").setOutputCol("patientStatusLkpcdIndexer");
						indexers.add(patientStatusLkpcdIndexer);
						assemblers.add("patientStatusLkpcdIndexer");			
						patientStatusLkpcdIndexer.setHandleInvalid("keep");
					}
				}
				
				StringIndexer patientGenderIndexer = new StringIndexer().setInputCol("patientGender").setOutputCol("patientGenderIndexer");
				indexers.add(patientGenderIndexer);
				OneHotEncoder patientGenderVec = new OneHotEncoder().setInputCol("patientGenderIndexer").setOutputCol("patientGenderVec");
				indexers.add(patientGenderVec);			
				patientGenderIndexer.setHandleInvalid("keep");
				assemblers.add("patientGenderIndexer");
				assemblers.add("patientGenderVec");
				
				StringIndexer patientZipIndexer = new StringIndexer().setInputCol("patientZip").setOutputCol("patientZipIndexer");
				indexers.add(patientZipIndexer);
				OneHotEncoder patientZipVec = new OneHotEncoder().setInputCol("patientZipIndexer").setOutputCol("patientZipVec");
				indexers.add(patientZipVec);			
				patientZipIndexer.setHandleInvalid("keep");
				assemblers.add("patientZipIndexer");
				assemblers.add("patientZipVec");
				
				
				double[] splits = {001,020,113,129,163,215,326,405,453,573,614,652,707,734,765,789,799,820,853,876,894,901,927,939,955,969,981,999};
				Bucketizer drgCodeBucketizer = new Bucketizer().setInputCol("drgCode").setOutputCol("drgCodeBucketizer").setSplits(splits);
				indexers.add(drgCodeBucketizer);
				assemblers.add("drgCodeBucketizer");			
				drgCodeBucketizer.setHandleInvalid("keep");
				
				double[] mdcSplits = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27};
				Bucketizer mdcBucketizer = new Bucketizer().setInputCol("mdc").setOutputCol("mdcBucketizer").setSplits(mdcSplits);			
				mdcBucketizer.setHandleInvalid("keep");
				indexers.add(mdcBucketizer);
				assemblers.add("mdcBucketizer");
		assemblers.add("los");
		
		VectorAssembler assembler = new VectorAssembler().setInputCols(assemblers.toArray(new String[assemblers.size()])).setOutputCol("features_temp");
		
//		//Vector normalizer
		Normalizer normalizer = new Normalizer().setInputCol("features_temp").setOutputCol("features");

		
		indexers.add(assembler);
		indexers.add(normalizer);
		indexers.add(linearRegression);
		Pipeline pipeLine = new Pipeline().setStages(indexers.toArray(new PipelineStage[indexers.size()]));
		

		trainValidationSplit.setEstimator(pipeLine);
		return (T) trainData;
	}

	@SuppressWarnings("unchecked")
	@Override
	public <T, P> T buildModel(P trainInputData) throws Exception {

		Dataset<Row> trainData = (Dataset<Row>) trainInputData;
		
		System.out.println("*****************TRAINING SUMMARY STARTS*************");
		trainData.printSchema();
		trainData.show();
		System.out.println("*****************TRAINING SUMMARY ENDS*************");
		
		System.out.println("*****************FIT THE MODEL STARTS*************");
		trainValidationSplitModel = trainValidationSplit.fit(trainData);
		System.out.println("*****************FIT THE MODEL ENDS*************");
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
		Dataset<Row> testData = (Dataset<Row>) testingData;
		testData = testData.drop("totalBilledAmount");
		testData = testData.drop("label");
		Dataset<Row> predictedValues = trainValidationSplitModel.transform(testData).select("_id","los","patientStatusLkpcd","admtDiagCd","age","patientGender","patientZip","prncplDgnsCd","prncplPrcdrCd","drgCode","mdc","prediction");
		System.out.println("-------------------HOLDOUT----------------");
		predictedValues.printSchema();
		predictedValues.show();
		System.out.println("-------------------HOLDOUT----------------");
		predictedValues.createOrReplaceTempView("PredictedTable");
		Dataset<Row> dataForMetrics = sparkSession.sql("select prediction,CAST(mdc AS DOUBLE) AS mdc from PredictedTable ");
		RegressionMetrics metrics = new RegressionMetrics(dataForMetrics);
		System.out.println("Test Metrics");
		System.out.println("Test Explained Variance:");
		System.out.println(metrics.explainedVariance());
		System.out.println("Test R^2 Coef:");
		System.out.println(metrics.r2());
		System.out.println("Test MSE:");
		System.out.println(metrics.meanSquaredError());
		System.out.println("Test RMSE:");
		System.out.println(metrics.rootMeanSquaredError());
		return (T) predictedValues;
//		return null;
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

	@Override
	public <T, P> T savePrediction(P inpPredictedData) throws Exception {
		Dataset<Row> predictedData = (Dataset<Row>) inpPredictedData;
		System.out.println("In savePrediction 1");
		Dataset<Row> mdcData  = RepositoryFactory.getInpatientAggregationRepo().load(javaSparkContext,"MAJOR_DIAG_CATEGORY_MS");
		mdcData.createOrReplaceTempView("MDC");
		predictedData.createOrReplaceTempView("PREDICTION");
		Dataset<Row> dataForMetrics = sparkSession.sql("select P.los,P.patientStatusLkpcd,P.admtDiagCd,P.age, P.patientGender,P.patientZip, P.prncplDgnsCd,P.prncplPrcdrCd,P.drgCode,P.prediction,M.MDC_DESCRIPTION from PREDICTION P, MDC M WHERE P.mdc = M.MDC_ID");
		System.out.println("In savePrediction 2");
		dataForMetrics.show();
		dataForMetrics.cache();
		dataForMetrics.persist();
		System.out.println("In savePrediction 3");
		RepositoryFactory.getInpatientAggregationRepo().save(dataForMetrics, "INPATIENT_PREDICTION");
		return null;
	}

}
