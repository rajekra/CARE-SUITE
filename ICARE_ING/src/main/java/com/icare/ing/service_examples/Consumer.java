package com.icare.ing.service_examples;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.ConsumerRebalanceListener;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.common.TopicPartition;

import java.util.Collection;
import java.util.Collections;
import java.util.Properties;

public class Consumer{

   public static void main(String[] args) {

       Properties props = new Properties();
       props.put("bootstrap.servers", "sandbox.hortonworks.com:6667");
       props.put("group.id", "test");
       props.put("enable.auto.commit", "true");
       props.put("auto.commit.interval.ms", "1000");
       props.put("session.timeout.ms", "30000");
       props.put("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
       props.put("value.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
       KafkaConsumer<byte[], byte[]> consumer = new KafkaConsumer<>(props);
       TestConsumerRebalanceListener rebalanceListener = new TestConsumerRebalanceListener();
       consumer.subscribe(Collections.singletonList("test"), rebalanceListener);

       while (true) {
           ConsumerRecords<byte[], byte[]> records = consumer.poll(1000);
           for (ConsumerRecord<byte[], byte[]> record : records) {
               System.out.printf("Received Message topic =%s, partition =%s, offset = %d, key = %s, value = %s\n", record.topic(), record.partition(), record.offset(), record.key(), record.value());
           }

           consumer.commitSync();
       }

   }

   private static class  TestConsumerRebalanceListener implements ConsumerRebalanceListener {
       @Override
       public void onPartitionsRevoked(Collection<TopicPartition> partitions) {
           System.out.println("Called onPartitionsRevoked with partitions:" + partitions);
       }

       @Override
       public void onPartitionsAssigned(Collection<TopicPartition> partitions) {
           System.out.println("Called onPartitionsAssigned with partitions:" + partitions);
       }
   }

}
