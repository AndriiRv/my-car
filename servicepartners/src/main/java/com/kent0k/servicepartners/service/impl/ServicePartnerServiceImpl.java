package com.kent0k.servicepartners.service.impl;

import com.kent0k.servicepartners.dto.servicepartner.ServicePartnerSaveDto;
import com.kent0k.servicepartners.dto.servicepartner.ServicePartnerWithIdDto;
import com.kent0k.servicepartners.entity.ServicePartner;
import com.kent0k.servicepartners.exception.ResourceNotFoundException;
import com.kent0k.servicepartners.mapper.ServicePartnerMapper;
import com.kent0k.servicepartners.repository.CarMaintenanceRepository;
import com.kent0k.servicepartners.repository.ServicePartnerRepository;
import com.kent0k.servicepartners.repository.WorkerRepository;
import com.kent0k.servicepartners.service.ServicePartnerService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@AllArgsConstructor
public class ServicePartnerServiceImpl implements ServicePartnerService {

    private final ServicePartnerRepository servicePartnerRepository;
    private final WorkerRepository workerRepository;
    private final CarMaintenanceRepository carMaintenanceRepository;
    private final ServicePartnerMapper servicePartnerMapper;

    @Override
    public boolean save(ServicePartnerSaveDto saveDto) {
        saveDto.setId(servicePartnerRepository.incrementAndGet());

        servicePartnerRepository.save(servicePartnerMapper.mapToServicePartner(saveDto));
        return true;
    }

    @Override
    public ServicePartnerWithIdDto fetch(Integer id) {
        ServicePartner servicePartner = servicePartnerRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(String.format("Service partner with id as %s cannot be found.", id)));
        return servicePartnerMapper.mapToServicePartnerWithIdDto(servicePartner);
    }

    @Override
    public List<ServicePartnerWithIdDto> fetchAll() {
        return servicePartnerMapper.mapToServicePartnerWithIdDtos(servicePartnerRepository.findAll());
    }

    @Override
    public boolean update(ServicePartnerWithIdDto updateDto) {
        servicePartnerRepository.save(servicePartnerMapper.mapToServicePartner(updateDto));
        return true;
    }

    @Transactional
    @Override
    public boolean delete(Integer id) {
        ServicePartner servicePartner = servicePartnerRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(String.format("Service partner with id as %s cannot be found.", id)));

        workerRepository.deleteAllByServicePartnerId(id);
        carMaintenanceRepository.deleteAllByServicePartnerId(id);
        servicePartnerRepository.delete(servicePartner);
        return true;
    }
}
