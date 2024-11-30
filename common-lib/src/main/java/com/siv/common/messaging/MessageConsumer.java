package com.siv.common.messaging;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.config.KafkaListenerContainerFactory;
import org.springframework.kafka.listener.ConcurrentMessageListenerContainer;
import org.springframework.kafka.listener.MessageListener;
import org.springframework.stereotype.Component;

@Component
public class MessageConsumer {

    @Autowired
    private KafkaListenerContainerFactory<ConcurrentMessageListenerContainer<String, String>> kafkaListenerContainerFactory;

    public void startListening(String topic, MessageListener<String, String> listener) {

        ConcurrentMessageListenerContainer<String, String> container =
                kafkaListenerContainerFactory.createContainer(topic);
        
        container.setupMessageListener(listener);
 
        container.start();
    }
}