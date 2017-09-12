package org.sparkexample;
import org.apache.kafka.clients.producer.Callback;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
import java.util.Random;

public class Producer {

   public static void main(String[] args){

       Properties props = new Properties();
       props.put("bootstrap.servers", "sandbox.hortonworks.com:6667");
       props.put("acks", "all");
       props.put("retries", 0);
       props.put("batch.size", 16384);
       props.put("linger.ms", 1);
       props.put("buffer.memory", 33554432);
       props.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
       props.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");

       KafkaProducer<String, String> producer = new KafkaProducer<String, String>(props);
       TestCallback callback = new TestCallback();
       Random rnd = new Random();
       for (long i = 0; i < 2 ; i++) {
    	   
    	   StringBuilder jsoncontent = new StringBuilder();
       	BufferedReader br = null;
   		FileReader fr = null;

   		try {

   			//br = new BufferedReader(new FileReader(FILENAME));
   			fr = new FileReader("C:\\Testing\\Output\\JSON\\CLAIM_5010_PROFESSIONAL_A1\\20170906\\16\\Output_Claim_1_20170906_160815546.json");
   			br = new BufferedReader(fr);

   			String sCurrentLine;

   			while ((sCurrentLine = br.readLine()) != null) {
   				jsoncontent.append(sCurrentLine);
   			}
           ProducerRecord<String, String> data = new ProducerRecord<String, String>(
                   "test", "key-" + i, jsoncontent.toString() );
           producer.send(data, callback);
           
           
           
      	 jsoncontent.setLength(0);

	} catch (IOException e) {

		e.printStackTrace();

	}
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