package com.kent0k.customers.service.kafka;

import com.kent0k.customers.configuration.KafkaProducerConfig;
import com.kent0k.customers.configuration.KafkaTopicConfig;
import com.kent0k.customers.exception.GlobalExceptionHandler;
import com.kent0k.customers.util.CustomersLogFactory;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
@AllArgsConstructor
public class KafkaServiceImpl {

    private static final Logger LOG = CustomersLogFactory.getLogger(GlobalExceptionHandler.class);

    private final KafkaTemplate<String, KafkaProducerConfig.CustomerToServicePartnerDto> kafkaTemplate;

    public void sendMessage(KafkaProducerConfig.CustomerToServicePartnerDto customerToServicePartner) {
        kafkaTemplate.send(KafkaTopicConfig.TOPIC_NAME, customerToServicePartner);

        LOG.info(String.format("Sent message: '%s' to Kafka topic", customerToServicePartner));
    }
}
