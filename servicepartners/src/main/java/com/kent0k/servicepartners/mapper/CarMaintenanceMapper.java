package com.kent0k.servicepartners.mapper;

import com.kent0k.servicepartners.dto.carmaintenance.CarMaintenanceResponseDto;
import com.kent0k.servicepartners.dto.carmaintenance.CarMaintenanceSaveDto;
import com.kent0k.servicepartners.dto.carmaintenance.CarMaintenanceWithIdDto;
import com.kent0k.servicepartners.entity.CarMaintenance;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CarMaintenanceMapper {

    CarMaintenance mapToCarMaintenance(CarMaintenanceSaveDto carMaintenanceSaveDto);

    CarMaintenance mapToCarMaintenance(CarMaintenanceWithIdDto carMaintenanceSaveDto);

    CarMaintenanceWithIdDto mapToCarMaintenanceDto(CarMaintenance carMaintenance);

    CarMaintenanceResponseDto mapToCarMaintenanceResponseDto(CarMaintenance carMaintenance);

    List<CarMaintenanceWithIdDto> mapToCarMaintenanceDtos(List<CarMaintenance> carMaintenances);

}
