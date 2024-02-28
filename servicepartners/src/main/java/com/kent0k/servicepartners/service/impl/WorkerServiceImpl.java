package com.kent0k.servicepartners.service.impl;

import com.kent0k.servicepartners.dto.worker.WorkerSaveDto;
import com.kent0k.servicepartners.dto.worker.WorkerWithIdDto;
import com.kent0k.servicepartners.entity.ServicePartner;
import com.kent0k.servicepartners.entity.Worker;
import com.kent0k.servicepartners.exception.ResourceNotFoundException;
import com.kent0k.servicepartners.mapper.WorkerMapper;
import com.kent0k.servicepartners.repository.ServicePartnerRepository;
import com.kent0k.servicepartners.repository.WorkerRepository;
import com.kent0k.servicepartners.service.WorkerService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@AllArgsConstructor
public class WorkerServiceImpl implements WorkerService {

    private final WorkerRepository workerRepository;
    private final ServicePartnerRepository servicePartnerRepository;
    private final WorkerMapper workerMapper;

    @Transactional
    @Override
    public boolean save(WorkerSaveDto saveDto) {
        saveDto.setId(workerRepository.incrementAndGet());

        Worker worker = workerMapper.mapToWorker(saveDto);
        ServicePartner servicePartner = servicePartnerRepository.findById(saveDto.getServicePartnerId())
                .orElseThrow(() -> new ResourceNotFoundException(String.format("Service partner with id as %s cannot be found.", saveDto.getServicePartnerId())));
        worker.setServicePartner(servicePartner);

        workerRepository.save(worker);
        return true;
    }

    @Override
    public WorkerWithIdDto fetch(Integer id) {
        Worker worker = workerRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(String.format("Worker with id as %s cannot be found.", id)));
        return workerMapper.mapToWorkerDto(worker);
    }

    @Override
    public List<WorkerWithIdDto> fetchAll() {
        return workerMapper.mapToWorkerDto(workerRepository.findAll());
    }

    @Override
    public boolean update(WorkerWithIdDto updateDto) {
        workerRepository.save(workerMapper.mapToWorker(updateDto));
        return true;
    }

    @Transactional
    @Override
    public boolean delete(Integer id) {
        Worker worker = workerRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(String.format("Worker with id as %s cannot be found.", id)));
        workerRepository.delete(worker);
        return true;
    }
}
