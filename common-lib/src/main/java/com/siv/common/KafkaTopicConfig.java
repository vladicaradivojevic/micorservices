package com.siv.common;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class KafkaTopicConfig {

    @Bean
    public NewTopic createMovieTopic() {
        return TopicBuilder.name(EventTopic.MOVIE)
                .partitions(1)
                .replicas(1)
                .build();
    }
}
