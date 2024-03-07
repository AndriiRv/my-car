package com.kent0k.customers.mapper;

import com.kent0k.customers.dto.owner.OwnerSaveDto;
import com.kent0k.customers.dto.owner.OwnerWithIdDto;
import com.kent0k.customers.entity.Owner;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface OwnerMapper {

    Owner mapToOwner(OwnerSaveDto ownerSaveDto);

    Owner mapToOwner(OwnerWithIdDto ownerWithIdDto);

    OwnerWithIdDto mapToOwnerWithIdDto(Owner owner);

    List<OwnerWithIdDto> mapToOwnerWithIdDtos(List<Owner> owners);
}
