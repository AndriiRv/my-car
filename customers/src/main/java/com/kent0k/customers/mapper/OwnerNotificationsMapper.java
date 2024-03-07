package com.kent0k.customers.mapper;

import com.kent0k.customers.dto.ownernotifications.OwnerNotificationsDto;
import com.kent0k.customers.dto.ownernotifications.OwnerNotificationsWithIdDto;
import com.kent0k.customers.entity.OwnerNotifications;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface OwnerNotificationsMapper {

    OwnerNotifications mapToOwnerNotifications(OwnerNotificationsDto ownerNotificationsDto);

    OwnerNotifications mapToOwnerNotifications(OwnerNotificationsWithIdDto ownerNotificationsWithIdDto);

    OwnerNotificationsWithIdDto mapToOwnerNotificationsWithIdDto(OwnerNotifications ownerNotifications);

    List<OwnerNotificationsWithIdDto> mapToOwnerNotificationsWithIdDtos(List<OwnerNotifications> ownerNotifications);
}
