package com.kent0k.customers.service;

import com.kent0k.customers.dto.ownercredentials.OwnerCredentialsSaveDto;
import com.kent0k.customers.dto.ownercredentials.OwnerCredentialsWithIdDto;

import java.util.List;

public interface OwnerCredentialsService {

    boolean save(OwnerCredentialsSaveDto saveDto);

    OwnerCredentialsWithIdDto fetch(Integer id);

    List<OwnerCredentialsWithIdDto> fetchAll();

    boolean update(OwnerCredentialsWithIdDto updateDto);

    boolean delete(Integer id);
}
