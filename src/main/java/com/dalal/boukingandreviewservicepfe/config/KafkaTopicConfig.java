package com.dalal.boukingandreviewservicepfe.config;


import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;
@Configuration
public class KafkaTopicConfig {

    public static final String RESERVATION_CREATED_TOPIC = "reservation-created-topic";
    public static final String RESERVATION_STATUS_UPDATED_TOPIC = "reservation-status-updated-topic";
    public static final String REVIEW_CREATED_TOPIC = "review-created-topic";

    @Bean
    public NewTopic reservationCreatedTopic() {
        return TopicBuilder.name(RESERVATION_CREATED_TOPIC)
                .partitions(1)
                .replicas(1)
                .build();
    }

    @Bean
    public NewTopic reservationStatusUpdatedTopic() {
        return TopicBuilder.name(RESERVATION_STATUS_UPDATED_TOPIC)
                .partitions(1)
                .replicas(1)
                .build();
    }

    @Bean
    public NewTopic reviewCreatedTopic() {
        return TopicBuilder.name(REVIEW_CREATED_TOPIC)
                .partitions(1)
                .replicas(1)
                .build();
    }
}