package com.kent0k.servicepartners.service.kafka;

import com.kent0k.servicepartners.configuration.KafkaConsumerConfig;
import com.kent0k.servicepartners.entity.CarMaintenance;
import com.kent0k.servicepartners.exception.ResourceNotFoundException;
import com.kent0k.servicepartners.repository.CarMaintenanceRepository;
import com.kent0k.servicepartners.service.CarMaintenanceService;
import com.kent0k.servicepartners.util.ServicePartnersLogFactory;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@AllArgsConstructor
public class KafkaServiceImpl {

    private static final Logger LOG = ServicePartnersLogFactory.getLogger(KafkaServiceImpl.class);

    private final CarMaintenanceService carMaintenanceService;

    @Transactional
    @KafkaListener(topics = KafkaConsumerConfig.TOPIC_NAME, groupId = KafkaConsumerConfig.GROUP_ID)
    public void myCarCustomerToServicePartnerListener(KafkaConsumerConfig.CustomerToServicePartnerDto customerToServicePartner) {
        LOG.info(String.format("%s came from 'customers' microservice via Kafka", customerToServicePartner));

        carMaintenanceService.updateIsSent(customerToServicePartner.carId(), customerToServicePartner.ownerId());
    }
}
