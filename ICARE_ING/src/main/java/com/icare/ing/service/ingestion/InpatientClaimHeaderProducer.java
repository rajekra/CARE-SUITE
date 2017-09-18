package com.icare.ing.service.ingestion;
import org.apache.kafka.clients.producer.Callback;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;

import com.ecams.claim.bo.ClaimHeader;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.icare.ing.util.PropUtilityService;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
import java.util.Random;

public class InpatientClaimHeaderProducer {

   public static void main(String[] args) throws JsonParseException, JsonMappingException, IOException{

       Properties props = new Properties();
       props.put("bootstrap.servers", "sandbox.hortonworks.com:6667");
       props.put("acks", "all");
       props.put("retries", 0);
       props.put("batch.size", 16384);
       props.put("linger.ms", 1);
       props.put("buffer.memory", 33554432);
       props.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
       props.put("value.serializer", "com.icare.ing.util.kafka.ClaimHeaderSerializer");

       KafkaProducer<String, ClaimHeader> producer = new KafkaProducer<String, ClaimHeader>(props);
       TestCallback callback = new TestCallback();
       Random rnd = new Random();
       for (long i = 0; i < 2 ; i++) {
    	   System.out.println("1");
   		   ClaimHeader header = PropUtilityService.translateJsonToBusinessObject("C:\\Testing\\Output\\JSON\\CLAIM_5010_INSTITUIONAL_A2\\20170918\\15\\Output_Claim_1_20170918_150311338.json");
           ProducerRecord<String, ClaimHeader> data = new ProducerRecord<String, ClaimHeader>("test", "key-" + i, header );
           producer.send(data, callback);
       }
       producer.close();
   }


   private static class TestCallback implements Callback {
       @Override
       public void onCompletion(RecordMetadata recordMetadata, Exception e) {
           if (e != null) {
               System.out.println("Error while producing message to topic :" + recordMetadata);
               e.printStackTrace();
           } else {
               String message = String.format("sent message to topic:%s partition:%s  offset:%s", recordMetadata.topic(), recordMetadata.partition(), recordMetadata.offset());
               System.out.println(message);
           }
       }
   }

}