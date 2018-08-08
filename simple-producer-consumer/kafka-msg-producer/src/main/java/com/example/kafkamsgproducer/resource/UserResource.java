package com.example.kafkamsgproducer.resource;

import com.example.kafkamsgproducer.model.IUser;
import com.example.kafkamsgproducer.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.*;

/**
 * Created by singsate on 18-Jul-18.
 */
@RestController
@RequestMapping("kafka")
public class UserResource {

    public static final String TOPIC1 = "KAFKA_TOPIC_1";

    public static final String TOPIC2 = "KAFKA_TOPIC_2";

    public static final String TOPIC3 = "KAFKA_TOPIC_3";

    @Autowired
    KafkaTemplate<String,String> kafkaTemplate;

    @Autowired
    KafkaTemplate<String,IUser> kafkaTemplateForUser;

    @GetMapping("/publish/{message}")
    public String post(@PathVariable("message") final String message){


        kafkaTemplate.send(TOPIC1, message);

        return "Published successfully.....";
    }

    /*@GetMapping("/publish/user/{name}")
    public String postUser(@PathVariable("name") final String name){


        kafkaTemplateForUser.send(TOPIC2, new User(name,"Accounts",130000.00));

        return "User message Published successfully.....";
    }*/

    @RequestMapping(
            value = "/publish/user",
            method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<IUser> sendUserMsgToKafka(@RequestBody User user){
        kafkaTemplateForUser.send(TOPIC2,user);
        return new ResponseEntity<IUser>(user, HttpStatus.CREATED);
    }



}
