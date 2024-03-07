package com.kent0k.servicepartners.service.impl;

import com.kent0k.servicepartners.dto.carmaintenance.CarMaintenanceResponseDto;
import com.kent0k.servicepartners.dto.carmaintenance.CarMaintenanceSaveDto;
import com.kent0k.servicepartners.dto.carmaintenance.CarMaintenanceWithIdDto;
import com.kent0k.servicepartners.dto.external.CarResponseDto;
import com.kent0k.servicepartners.dto.rabbitmq.CarIdOwnerIdDto;
import com.kent0k.servicepartners.entity.CarMaintenance;
import com.kent0k.servicepartners.entity.ServicePartner;
import com.kent0k.servicepartners.exception.ResourceNotFoundException;
import com.kent0k.servicepartners.mapper.CarMaintenanceMapper;
import com.kent0k.servicepartners.mapper.ServicePartnerMapper;
import com.kent0k.servicepartners.repository.CarMaintenanceRepository;
import com.kent0k.servicepartners.repository.ServicePartnerRepository;
import com.kent0k.servicepartners.service.CarMaintenanceService;
import com.kent0k.servicepartners.service.client.CarsFeignClient;
import com.kent0k.servicepartners.service.client.OwnerFeignClient;
import com.kent0k.servicepartners.util.ServicePartnersLogFactory;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@AllArgsConstructor
public class CarMaintenanceServiceImpl implements CarMaintenanceService {

    private static final Logger LOG = ServicePartnersLogFactory.getLogger(CarMaintenanceServiceImpl.class);

    private final CarMaintenanceRepository carMaintenanceRepository;
    private final ServicePartnerRepository servicePartnerRepository;
    private final CarMaintenanceMapper carMaintenanceMapper;
    private final ServicePartnerMapper servicePartnerMapper;
    private final CarsFeignClient carsFeignClient;
    private final OwnerFeignClient ownerFeignClient;
    private final StreamBridge streamBridge;

    @Transactional
    @Override
    public boolean save(CarMaintenanceSaveDto saveDto) {
        Integer carId = saveDto.getCarId();
        carsFeignClient.isResourceAccessible(
                () -> carsFeignClient.fetchRawBy(carId),
                () -> new ResourceNotFoundException(String.format("Car with id as %s cannot be found.", carId))
        );

        Integer ownerId = saveDto.getOwnerId();
        ownerFeignClient.isResourceAccessible(
                () -> ownerFeignClient.fetchRawBy(ownerId),
                () -> new ResourceNotFoundException(String.format("Owner with id as %s cannot be found.", ownerId))
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

    @Transactional
    @Override
    public boolean update(CarMaintenanceWithIdDto updateDto) {
        CarMaintenance oldCarMaintenance = carMaintenanceRepository.findById(updateDto.getId())
                .orElseThrow(() -> new ResourceNotFoundException(String.format("Car maintenance with id as %s cannot be found.", updateDto.getId())));

        CarMaintenance carMaintenance = carMaintenanceMapper.mapToCarMaintenance(updateDto);
        carMaintenance.setCarId(oldCarMaintenance.getCarId());
        carMaintenance.setOwnerId(oldCarMaintenance.getOwnerId());
        carMaintenance.setServicePartner(oldCarMaintenance.getServicePartner());
        carMaintenanceRepository.save(carMaintenance);

        if (updateDto.getDone()) {
            CarResponseDto carResponseDto = carsFeignClient.fetchRawBy(carMaintenance.getCarId()).getBody();
            streamBridge.send("sendIsReadyCommunication-out-0", new CarIdOwnerIdDto(carMaintenance.getCarId(), carResponseDto.getOwnerDto().getId()));

            LOG.info(String.format("Sent carId: %s and ownerId: %s via RabbitMQ to 'customers' microservice",
                    carMaintenance.getCarId(), carResponseDto.getOwnerDto().getId()));
        }

        return true;
    }

    @Transactional
    @Override
    public boolean updateIsSent(Integer carId, Integer ownerId) {
        CarMaintenance carMaintenance = carMaintenanceRepository.findByCarIdAndOwnerId(carId, ownerId)
                .orElseThrow(() -> new ResourceNotFoundException(String.format("Car maintenance with carId as %s and ownerId as %s cannot be found.", carId, ownerId)));
        carMaintenance.setSent(true);
        carMaintenanceRepository.save(carMaintenance);

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
