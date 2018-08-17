package org.pratap.sbms.kafkamsgng.config;

import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringSerializer;
import org.pratap.sbms.kafkamsgng.model.SimpleMessage;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;
import org.springframework.kafka.support.serializer.JsonSerializer;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by singsate on 16-Aug-18.
 */
@Configuration
public class KafkaConfig {

    @Bean
    public ProducerFactory<String, SimpleMessage> simpleMessageProducerFactory(){
        Map<String,Object> config = new HashMap<>();
        config.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "192.168.110.133:9092");
        config.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
        config.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, JsonSerializer.class);

        return new DefaultKafkaProducerFactory<String, SimpleMessage>(config);
    }

    @Bean
    public KafkaTemplate<String,SimpleMessage> kafkaTemplateForUser(){
        return new KafkaTemplate<String, SimpleMessage>(simpleMessageProducerFactory());
    }
}
