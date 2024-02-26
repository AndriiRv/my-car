package com.kent0k.customers.mapper;

import com.kent0k.customers.dto.ownernotifications.OwnerNotificationsDto;
import com.kent0k.customers.dto.ownernotifications.OwnerNotificationsUpdateDto;
import com.kent0k.customers.entity.OwnerNotifications;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface OwnerNotificationsMapper {

    OwnerNotifications mapToOwnerNotifications(OwnerNotificationsDto ownerNotificationsDto);

    OwnerNotifications mapToOwnerNotifications(OwnerNotificationsUpdateDto ownerNotificationsUpdateDto);

    OwnerNotificationsDto mapToOwnerNotificationsDto(OwnerNotifications ownerNotifications);

    List<OwnerNotificationsDto> mapToOwnerNotificationsDtos(List<OwnerNotifications> ownerNotifications);
}
