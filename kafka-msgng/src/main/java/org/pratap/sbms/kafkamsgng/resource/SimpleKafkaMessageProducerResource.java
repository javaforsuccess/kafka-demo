package org.pratap.sbms.kafkamsgng.resource;

import org.pratap.sbms.kafkamsgng.model.SimpleMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.*;

/**
 * Created by singsate on 16-Aug-18.
 */
@RestController
@RequestMapping("kafka-sender")
public class SimpleKafkaMessageProducerResource {

    @Autowired
    KafkaTemplate<String,SimpleMessage> kafkaTemplateForSimpleMessage;

    @RequestMapping(
        value = "/publish/msg/{topic}",
        method = RequestMethod.POST,
        consumes = MediaType.APPLICATION_JSON_VALUE,
        produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity sendMessageToKafka(@PathVariable String topic, @RequestBody SimpleMessage simpleMessage){
        kafkaTemplateForSimpleMessage.send(topic,simpleMessage);
        return new ResponseEntity(HttpStatus.CREATED);
    }

}
