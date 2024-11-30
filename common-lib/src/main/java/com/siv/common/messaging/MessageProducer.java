package com.siv.common.messaging;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import com.siv.common.Event;

@Component
public class MessageProducer {

	@Autowired
    private final KafkaTemplate<String, String> kafkaTemplate;
	
	@Autowired
    private final EventMapper eventMapper;

    public MessageProducer(KafkaTemplate<String, String> kafkaTemplate, EventMapper eventMapper) {
        this.kafkaTemplate = kafkaTemplate;
        this.eventMapper = eventMapper;
    }

    public void sendMessage(String topic, Event<?> event) {
 		kafkaTemplate.send(topic, this.eventMapper.toJson(event));
    }
}
