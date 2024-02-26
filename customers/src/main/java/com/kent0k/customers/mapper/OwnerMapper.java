package com.kent0k.customers.mapper;

import com.kent0k.customers.dto.owner.OwnerDto;
import com.kent0k.customers.dto.owner.OwnerSaveDto;
import com.kent0k.customers.dto.owner.OwnerUpdateDto;
import com.kent0k.customers.entity.Owner;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface OwnerMapper {

    Owner mapToOwner(OwnerSaveDto ownerSaveDto);

    Owner mapToOwner(OwnerUpdateDto ownerUpdateDto);

    OwnerDto mapToOwnerDto(Owner owner);

    List<OwnerDto> mapToOwnerDtos(List<Owner> owners);
}
