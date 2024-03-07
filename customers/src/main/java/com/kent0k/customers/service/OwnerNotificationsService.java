package com.kent0k.customers.service;

import com.kent0k.customers.dto.ownernotifications.OwnerNotificationsDto;
import com.kent0k.customers.dto.ownernotifications.OwnerNotificationsWithIdDto;

import java.util.List;

public interface OwnerNotificationsService {

    boolean save(OwnerNotificationsDto saveDto);

    OwnerNotificationsWithIdDto fetch(Integer id);

    List<OwnerNotificationsWithIdDto> fetchAll();

    boolean update(OwnerNotificationsWithIdDto updateDto);

    boolean delete(Integer id);
}
