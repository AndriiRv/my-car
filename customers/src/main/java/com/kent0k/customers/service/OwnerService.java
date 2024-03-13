package com.kent0k.customers.service;

import com.kent0k.customers.dto.owner.OwnerSaveDto;
import com.kent0k.customers.dto.owner.OwnerWithIdDto;

import java.util.List;

public interface OwnerService {

    boolean save(OwnerSaveDto saveDto);

    OwnerWithIdDto fetch(Integer id);

    List<OwnerWithIdDto> fetchAll();

    boolean updateNotificationIsSentStatus();

    boolean update(OwnerWithIdDto updateDto);

    boolean delete(Integer id);
}
