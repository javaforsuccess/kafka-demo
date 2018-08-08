package com.example.kafkamsgconsumer.listener;

import com.example.kafkamsgconsumer.model.IUser;
import com.example.kafkamsgconsumer.model.User;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

/**
 * Created by singsate on 19-Jul-18.
 */
@Service
public class KafkaConsumer {

    public static final String TOPIC1 = "KAFKA_TOPIC_1";
    public static final String TOPIC2 = "KAFKA_TOPIC_2";
    public static final String TOPIC3 = "KAFKA_TOPIC_3";

    @KafkaListener (topics = TOPIC1, groupId = "group_id")
    public void consumeMsg(String message ){
        System.out.println(
                "Consumed MSG :  " + message
        );
    }


    @KafkaListener(topics = TOPIC3, groupId = "group_json", containerFactory = "kafkaListenerContainerFactoryForUser")
    public void consumeMsgOfTypeUser(User user){
        System.out.println(
                "Consumed JSON MSG : " + user
        );
    }


}
