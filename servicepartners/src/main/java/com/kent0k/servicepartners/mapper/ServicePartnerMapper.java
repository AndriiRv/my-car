package com.kent0k.servicepartners.mapper;

import com.kent0k.servicepartners.dto.servicepartner.ServicePartnerSaveDto;
import com.kent0k.servicepartners.dto.servicepartner.ServicePartnerWithIdDto;
import com.kent0k.servicepartners.entity.ServicePartner;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ServicePartnerMapper {

    ServicePartner mapToServicePartner(ServicePartnerSaveDto servicePartnerDto);

    ServicePartner mapToServicePartner(ServicePartnerWithIdDto servicePartnerDto);

    ServicePartnerWithIdDto mapToServicePartnerWithIdDto(ServicePartner servicePartner);

    List<ServicePartnerWithIdDto> mapToServicePartnerWithIdDtos(List<ServicePartner> servicePartners);

}
