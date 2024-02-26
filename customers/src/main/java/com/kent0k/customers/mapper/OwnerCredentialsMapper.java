package com.kent0k.customers.mapper;

import com.kent0k.customers.dto.ownercredentials.OwnerCredentialsSaveDto;
import com.kent0k.customers.dto.ownercredentials.OwnerCredentialsUpdateDto;
import com.kent0k.customers.entity.OwnerCredentials;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface OwnerCredentialsMapper {

    OwnerCredentials mapToOwnerCredentials(OwnerCredentialsSaveDto ownerCredentialsSaveDto);

    OwnerCredentials mapToOwnerCredentials(OwnerCredentialsUpdateDto ownerCredentialsUpdateDto);
}
