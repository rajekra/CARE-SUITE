package com.icare.ing.service.ingestion;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaPairRDD;
import org.apache.spark.api.java.function.VoidFunction;
import org.apache.spark.sql.streaming.StreamingQueryException;
import org.apache.spark.streaming.Durations;
import org.apache.spark.streaming.api.java.JavaInputDStream;
import org.apache.spark.streaming.api.java.JavaPairDStream;
import org.apache.spark.streaming.api.java.JavaStreamingContext;
import org.apache.spark.streaming.kafka010.ConsumerStrategies;
import org.apache.spark.streaming.kafka010.KafkaUtils;
import org.apache.spark.streaming.kafka010.LocationStrategies;

import scala.Tuple2;

import com.ecams.claim.bo.ClaimHeader;
import com.icare.ing.service_examples.PhoenixForwarder;
import com.icare.ing.util.JsonUtil;
import com.icare.ing.util.kafka.ClaimHeaderDeserializer;
import com.icare.ing.util.spark.CHBuilder;

public class ConsumeInpatientClaim {
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
        kafkaParams.put("value.deserializer", ClaimHeaderDeserializer.class);
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
				public void call(Tuple2<String, ClaimHeader> inboundClaim) throws Exception {
					System.out.println(inboundClaim._1() + "RAJ," + inboundClaim._2());
					CHBuilder cdBuilder = new CHBuilder();
					cdBuilder.buildAndIngest(inboundClaim._2());
				}
				
			});
		});
        	      
        streamingContext.start();
        streamingContext.awaitTermination();
    }
}
