package com.kent0k.customers.configuration;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class KafkaTopicConfig {

    public static final String TOPIC_NAME = "customers-to-servicepartners";

    @Bean
    public NewTopic topic1() {
        return new NewTopic(TOPIC_NAME, 1, (short) 1);
    }
}
