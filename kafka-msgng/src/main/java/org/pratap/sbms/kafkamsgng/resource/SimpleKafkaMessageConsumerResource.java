package org.pratap.sbms.kafkamsgng.resource;

import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.common.PartitionInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

/**
 * Created by singsate on 17-Aug-18.
 */
@RestController
@RequestMapping("kafka-receiver")
public class SimpleKafkaMessageConsumerResource {

    @Autowired
    KafkaConsumer<String, String> kafkaTopicConsumer;

    @RequestMapping(value="/list-topics-map", method= RequestMethod.GET, produces= MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Map<String,String>> getAllTopics(){

        Map<String,String> kafkaTopicsMap = new HashMap<>();
        Map<String, List<PartitionInfo> > topics;
        topics = kafkaTopicConsumer.listTopics();

        for (Map.Entry<String, List<PartitionInfo>> entry : topics.entrySet())
        {

            for(PartitionInfo eachPartitionInfo : entry.getValue()){
                    kafkaTopicsMap.put(entry.getKey(),eachPartitionInfo.topic());
            }
        }

        return new ResponseEntity<Map<String,String>>(kafkaTopicsMap, HttpStatus.OK);
    }

    @RequestMapping(value="/list-topics")
    public ResponseEntity<Collection<String>> getListOfTopics(){

        Collection listOfKafkaTopics = new ArrayList();
        Map<String, List<PartitionInfo> > topics;
        topics = kafkaTopicConsumer.listTopics();

        for (Map.Entry<String, List<PartitionInfo>> entry : topics.entrySet())
        {
            for(PartitionInfo eachPartitionInfo : entry.getValue()){
                listOfKafkaTopics.add(eachPartitionInfo.topic());
            }
        }

        return new ResponseEntity<Collection<String>>(listOfKafkaTopics, HttpStatus.OK);
    }

}
