package com.kent0k.servicepartners.service.impl;

import com.kent0k.servicepartners.dto.carmaintenance.CarMaintenanceResponseDto;
import com.kent0k.servicepartners.dto.carmaintenance.CarMaintenanceSaveDto;
import com.kent0k.servicepartners.dto.carmaintenance.CarMaintenanceWithIdDto;
import com.kent0k.servicepartners.entity.CarMaintenance;
import com.kent0k.servicepartners.entity.ServicePartner;
import com.kent0k.servicepartners.exception.ResourceNotFoundException;
import com.kent0k.servicepartners.mapper.CarMaintenanceMapper;
import com.kent0k.servicepartners.mapper.ServicePartnerMapper;
import com.kent0k.servicepartners.repository.CarMaintenanceRepository;
import com.kent0k.servicepartners.repository.ServicePartnerRepository;
import com.kent0k.servicepartners.service.CarMaintenanceService;
import com.kent0k.servicepartners.service.client.CarsFeignClient;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@AllArgsConstructor
public class CarMaintenanceServiceImpl implements CarMaintenanceService {

    private final CarMaintenanceRepository carMaintenanceRepository;
    private final ServicePartnerRepository servicePartnerRepository;
    private final CarMaintenanceMapper carMaintenanceMapper;
    private final ServicePartnerMapper servicePartnerMapper;
    private final CarsFeignClient carsFeignClient;

    @Transactional
    @Override
    public boolean save(CarMaintenanceSaveDto saveDto) {
        Integer carId = saveDto.getCarId();
        carsFeignClient.isResourceAccessible(
                () -> carsFeignClient.fetchRawBy(carId),
                () -> new ResourceNotFoundException(String.format("Car with id as %s cannot be found.", carId))
        );

        saveDto.setId(carMaintenanceRepository.incrementAndGet());

        CarMaintenance carMaintenance = carMaintenanceMapper.mapToCarMaintenance(saveDto);
        ServicePartner servicePartner = servicePartnerRepository.findById(saveDto.getServicePartnerId())
                .orElseThrow(() -> new ResourceNotFoundException(String.format("Service partner with id as %s cannot be found.", saveDto.getServicePartnerId())));
        carMaintenance.setServicePartner(servicePartner);

        carMaintenanceRepository.save(carMaintenance);
        return true;
    }

    @Override
    public CarMaintenanceResponseDto fetch(Integer id) {
        CarMaintenance carMaintenance = carMaintenanceRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(String.format("Car maintenance with id as %s cannot be found.", id)));
        CarMaintenanceResponseDto carMaintenanceResponseDto = carMaintenanceMapper.mapToCarMaintenanceResponseDto(carMaintenance);
        carMaintenanceResponseDto.setCarResponseDto(carsFeignClient.fetchRawBy(carMaintenance.getCarId()).getBody());
        carMaintenanceResponseDto.setServicePartnerWithIdDto(servicePartnerMapper.mapToServicePartnerWithIdDto(carMaintenance.getServicePartner()));

        return carMaintenanceResponseDto;
    }

    @Override
    public List<CarMaintenanceWithIdDto> fetchAll() {
        return carMaintenanceMapper.mapToCarMaintenanceDtos(carMaintenanceRepository.findAll());
    }

    @Override
    public boolean update(CarMaintenanceWithIdDto updateDto) {
        carMaintenanceRepository.save(carMaintenanceMapper.mapToCarMaintenance(updateDto));
        return true;
    }

    @Transactional
    @Override
    public boolean delete(Integer id) {
        CarMaintenance carMaintenance = carMaintenanceRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(String.format("Car maintenance with id as %s cannot be found.", id)));
        carMaintenanceRepository.delete(carMaintenance);
        return true;
    }
}
