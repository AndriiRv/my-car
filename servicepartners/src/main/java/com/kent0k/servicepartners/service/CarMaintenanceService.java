package com.kent0k.servicepartners.service;

import com.kent0k.servicepartners.dto.carmaintenance.CarMaintenanceSaveDto;
import com.kent0k.servicepartners.dto.carmaintenance.CarMaintenanceWithIdDto;

import java.util.List;

public interface CarMaintenanceService {

    boolean save(CarMaintenanceSaveDto saveDto);

    CarMaintenanceWithIdDto fetch(Integer id);

    List<CarMaintenanceWithIdDto> fetchAll();

    boolean update(CarMaintenanceWithIdDto updateDto);

    boolean delete(Integer id);
}
