package com.icare.ing.service_examples;
import java.util.*;

import org.apache.spark.SparkConf;
import org.apache.spark.TaskContext;
import org.apache.spark.api.java.*;
import org.apache.spark.api.java.function.*;
import org.apache.spark.streaming.api.java.*;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.common.TopicPartition;
import org.apache.kafka.common.serialization.StringDeserializer;

import scala.Tuple2;

import java.util.Arrays;

import org.apache.log4j.*;
import org.apache.spark.SparkConf;
import org.apache.spark.api.java.AbstractJavaRDDLike;
import org.apache.spark.api.java.JavaPairRDD;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.api.java.function.FlatMapFunction;
import org.apache.spark.api.java.function.VoidFunction;
import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Encoders;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.SparkSession;
import org.apache.spark.sql.streaming.StreamingQuery;
import org.apache.spark.sql.streaming.StreamingQueryException;
import org.apache.spark.streaming.Durations;
import org.apache.spark.streaming.api.java.*;
import org.apache.spark.streaming.kafka010.ConsumerStrategies;
import org.apache.spark.streaming.kafka010.KafkaUtils;
import org.apache.spark.streaming.kafka010.LocationStrategies;

import com.ecams.claim.bo.ClaimHeader;
import com.icare.ing.util.JsonUtil;

public class SparkKafkaConsumerOp1 {
    private static final String HOST = "localhost";
    private static final int PORT = 9999;

    public static void main(String[] args) throws InterruptedException, StreamingQueryException {
        // Configure and initialize the SparkStreamingContext
        SparkConf conf = new SparkConf()
                .setMaster("local")
                .setAppName("VerySimpleStreamingApp");
        JavaStreamingContext streamingContext =
                new JavaStreamingContext(conf, Durations.seconds(10));
        Map<String, Object> kafkaParams = new HashMap<>();
        kafkaParams.put("bootstrap.servers", "localhost:6667");
        kafkaParams.put("key.deserializer", StringDeserializer.class);
        kafkaParams.put("group.id", "use_a_separate_group_id_for_each_stream");
        kafkaParams.put("auto.offset.reset", "latest");
        kafkaParams.put("enable.auto.commit", false);

//        //StreamingContext with five execution threads, and a batch interval of 5 seconds.
//        int numThreads = 5;
//        Map<String, Integer> topicMap = new HashMap<String, Integer>();
//        String[] topics = args[2].split(",");
//        for (String topic: topics) {
//        	topicMap.put(topic, numThreads);
//        }
//       
        Collection<String> topics = Arrays.asList("test");

        JavaInputDStream<ConsumerRecord<String, ClaimHeader>> stream =
          KafkaUtils.createDirectStream(
            streamingContext,
            LocationStrategies.PreferConsistent(),
            ConsumerStrategies.<String, ClaimHeader>Subscribe(topics, kafkaParams)
          );

        JavaPairDStream<String,ClaimHeader> ds = stream.mapToPair(record -> new Tuple2<String, ClaimHeader>(record.key(), record.value()));  
        ds.print();
        
      
        ds.foreachRDD((VoidFunction<JavaPairRDD<String, ClaimHeader>>)pairRDD -> {
			pairRDD.foreach(new VoidFunction<Tuple2<String,ClaimHeader>>() {
				@Override
				public void call(Tuple2<String, ClaimHeader> t) throws Exception {
					System.out.println(t._1() + "RAJ," + t._2());
//					PropUtilityService.translateClaimHeaderToCD(t._2());
//					PhoenixForwarder phoenixConn = new PhoenixForwarder();
//					phoenixConn.sendSales(t._2());
				}
				
			});
		});
        	      
        streamingContext.start();
        streamingContext.awaitTermination();
    }
}
