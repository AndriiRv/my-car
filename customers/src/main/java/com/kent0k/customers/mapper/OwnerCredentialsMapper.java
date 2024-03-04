package com.kent0k.customers.mapper;

import com.kent0k.customers.dto.ownercredentials.OwnerCredentialsDto;
import com.kent0k.customers.dto.ownercredentials.OwnerCredentialsSaveDto;
import com.kent0k.customers.dto.ownercredentials.OwnerCredentialsUpdateDto;
import com.kent0k.customers.entity.OwnerCredentials;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface OwnerCredentialsMapper {

    OwnerCredentials mapToOwnerCredentials(OwnerCredentialsSaveDto ownerCredentialsSaveDto);

    OwnerCredentials mapToOwnerCredentials(OwnerCredentialsUpdateDto ownerCredentialsUpdateDto);

    OwnerCredentialsDto mapToOwnerCredentialsDto(OwnerCredentials ownerCredentials);

    List<OwnerCredentialsDto> mapToOwnerCredentialsDtos(List<OwnerCredentials> ownerCredentials);
}
