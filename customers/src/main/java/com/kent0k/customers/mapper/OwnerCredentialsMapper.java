package com.kent0k.customers.mapper;

import com.kent0k.customers.dto.ownercredentials.OwnerCredentialsSaveDto;
import com.kent0k.customers.dto.ownercredentials.OwnerCredentialsWithIdDto;
import com.kent0k.customers.entity.OwnerCredentials;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface OwnerCredentialsMapper {

    OwnerCredentials mapToOwnerCredentials(OwnerCredentialsSaveDto ownerCredentialsSaveDto);

    OwnerCredentials mapToOwnerCredentials(OwnerCredentialsWithIdDto ownerCredentialsWithIdDto);

    OwnerCredentialsWithIdDto mapToOwnerCredentialsWithIdDto(OwnerCredentials ownerCredentials);

    List<OwnerCredentialsWithIdDto> mapToOwnerCredentialsWithIdDtos(List<OwnerCredentials> ownerCredentials);
}
