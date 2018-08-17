package org.pratap.sbms.kafkamsgng.listener;

import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.common.PartitionInfo;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Properties;

/**
 * Created by singsate on 17-Aug-18.
 */
@Service
public class KafkaListener {

    @Bean
    public KafkaConsumer<String, String> getKafkaTopics(){
        //Map<String, List<PartitionInfo> > topics;

        Properties props = new Properties();
        props.put("bootstrap.servers", "192.168.110.133:9092");
        //props.put("group.id", "test-consumer-group");
        props.put("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
        props.put("value.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");

        return new KafkaConsumer<String, String>(props);
        //topics = consumer.listTopics();
    }

}
