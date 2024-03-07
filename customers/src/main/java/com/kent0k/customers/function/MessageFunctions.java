package com.kent0k.customers.function;

import com.kent0k.customers.dto.ownernotifications.OwnerNotificationsDto;
import com.kent0k.customers.dto.rabbitmq.CarIdOwnerIdDto;
import com.kent0k.customers.enums.DbBoolean;
import com.kent0k.customers.enums.OwnerNotificationMode;
import com.kent0k.customers.exception.GlobalExceptionHandler;
import com.kent0k.customers.service.OwnerNotificationsService;
import com.kent0k.customers.util.CustomersLogFactory;
import org.slf4j.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.function.Consumer;

@Configuration
public class MessageFunctions {

    private static final Logger LOG = CustomersLogFactory.getLogger(MessageFunctions.class);

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
        };
    }
}
