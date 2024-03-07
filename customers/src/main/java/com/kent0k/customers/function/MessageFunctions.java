package com.kent0k.customers.function;

import com.kent0k.customers.configuration.KafkaProducerConfig;
import com.kent0k.customers.dto.ownernotifications.OwnerNotificationsDto;
import com.kent0k.customers.dto.rabbitmq.CarIdOwnerIdDto;
import com.kent0k.customers.enums.DbBoolean;
import com.kent0k.customers.enums.OwnerNotificationMode;
import com.kent0k.customers.service.OwnerNotificationsService;
import com.kent0k.customers.service.kafka.KafkaServiceImpl;
import com.kent0k.customers.util.CustomersLogFactory;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.function.Consumer;

@Configuration
@AllArgsConstructor
public class MessageFunctions {

    private static final Logger LOG = CustomersLogFactory.getLogger(MessageFunctions.class);

    private final KafkaServiceImpl kafkaService;

    @Bean
    public Consumer<CarIdOwnerIdDto> saveNotification(OwnerNotificationsService ownerNotificationsService) {
        return carIdOwnerIdDto -> {
            OwnerNotificationsDto ownerNotificationsDto = new OwnerNotificationsDto();
            ownerNotificationsDto.setOwnerId(carIdOwnerIdDto.ownerId());
            ownerNotificationsDto.setMessage("Your car is ready.");
            ownerNotificationsDto.setOwnerNotificationMode(OwnerNotificationMode.TELEGRAM);
            ownerNotificationsDto.setIsSent(DbBoolean.Y);

            ownerNotificationsService.save(ownerNotificationsDto);

            LOG.info(String.format("Notification successfully saved after consume via RabbitMQ which came in from 'servicepartners' microservice. CarId: %s, OwnerId: %s",
                    carIdOwnerIdDto.carId(), carIdOwnerIdDto.ownerId()));

            kafkaService.sendMessage(new KafkaProducerConfig.CustomerToServicePartnerDto(carIdOwnerIdDto.carId(), carIdOwnerIdDto.ownerId()));

            LOG.info(String.format("Sent carId: %s and ownerId: %s via Kafka to 'servicepartners' microservice",
                    carIdOwnerIdDto.carId(), carIdOwnerIdDto.ownerId()));
        };
    }
}
