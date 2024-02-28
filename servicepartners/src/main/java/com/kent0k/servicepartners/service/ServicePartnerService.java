package com.kent0k.servicepartners.service;

import com.kent0k.servicepartners.dto.servicepartner.ServicePartnerSaveDto;
import com.kent0k.servicepartners.dto.servicepartner.ServicePartnerWithIdDto;

import java.util.List;

public interface ServicePartnerService {

    boolean save(ServicePartnerSaveDto saveDto);

    ServicePartnerWithIdDto fetch(Integer id);

    List<ServicePartnerWithIdDto> fetchAll();

    boolean update(ServicePartnerWithIdDto updateDto);

    boolean delete(Integer id);
}
