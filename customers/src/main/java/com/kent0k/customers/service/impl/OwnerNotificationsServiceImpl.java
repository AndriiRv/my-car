package com.kent0k.customers.service.impl;

import com.kent0k.customers.dto.ownernotifications.OwnerNotificationsDto;
import com.kent0k.customers.dto.ownernotifications.OwnerNotificationsUpdateDto;
import com.kent0k.customers.entity.Owner;
import com.kent0k.customers.entity.OwnerNotifications;
import com.kent0k.customers.exception.ResourceNotFoundException;
import com.kent0k.customers.mapper.OwnerNotificationsMapper;
import com.kent0k.customers.repository.OwnerNotificationsRepository;
import com.kent0k.customers.repository.OwnerRepository;
import com.kent0k.customers.service.OwnerService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@AllArgsConstructor
public class OwnerNotificationsServiceImpl implements OwnerService<OwnerNotificationsDto, OwnerNotificationsDto, OwnerNotificationsUpdateDto> {

    private final OwnerRepository ownerRepository;
    private final OwnerNotificationsRepository ownerNotificationsRepository;
    private final OwnerNotificationsMapper ownerNotificationsMapper;

    @Transactional
    @Override
    public boolean save(OwnerNotificationsDto saveDto) {
        Owner owner = ownerRepository.findById(saveDto.getOwnerId())
                .orElseThrow(() -> new ResourceNotFoundException(String.format("Owner with id as %s cannot be found.", saveDto.getOwnerId())));

        OwnerNotifications ownerNotifications = ownerNotificationsMapper.mapToOwnerNotifications(saveDto);
        ownerNotifications.setOwner(owner);
        ownerNotificationsRepository.save(ownerNotifications);

        return true;
    }

    @Override
    public OwnerNotificationsDto fetch(Integer id) {
        OwnerNotifications ownerNotifications = ownerNotificationsRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(String.format("Owner notification with id as %s cannot be found.", id)));
        return ownerNotificationsMapper.mapToOwnerNotificationsDto(ownerNotifications);
    }

    @Override
    public List<OwnerNotificationsDto> fetchAll() {
        return ownerNotificationsMapper.mapToOwnerNotificationsDtos(ownerNotificationsRepository.findAll());
    }

    @Transactional
    @Override
    public boolean update(OwnerNotificationsUpdateDto updateDto) {
        Owner owner = ownerRepository.findById(updateDto.getOwnerId())
                .orElseThrow(() -> new ResourceNotFoundException(String.format("Owner with id as %s cannot be found.", updateDto.getOwnerId())));

        OwnerNotifications ownerNotifications = ownerNotificationsMapper.mapToOwnerNotifications(updateDto);
        ownerNotifications.setOwner(owner);
        ownerNotificationsRepository.save(ownerNotifications);

        return true;
    }

    @Transactional
    @Override
    public boolean delete(Integer id) {
        OwnerNotifications ownerNotifications = ownerNotificationsRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(String.format("Owner notification with id as %s cannot be found.", id)));
        ownerNotificationsRepository.delete(ownerNotifications);
        return true;
    }
}
