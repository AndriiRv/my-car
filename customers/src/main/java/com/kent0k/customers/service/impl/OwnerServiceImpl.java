package com.kent0k.customers.service.impl;

import com.kent0k.customers.dto.owner.OwnerSaveDto;
import com.kent0k.customers.dto.owner.OwnerWithIdDto;
import com.kent0k.customers.entity.Owner;
import com.kent0k.customers.entity.OwnerCredentials;
import com.kent0k.customers.exception.ResourceNotFoundException;
import com.kent0k.customers.mapper.OwnerCredentialsMapper;
import com.kent0k.customers.mapper.OwnerMapper;
import com.kent0k.customers.repository.OwnerCredentialsRepository;
import com.kent0k.customers.repository.OwnerRepository;
import com.kent0k.customers.service.OwnerService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@AllArgsConstructor
public class OwnerServiceImpl implements OwnerService {

    private final OwnerRepository ownerRepository;
    private final OwnerCredentialsRepository ownerCredentialsRepository;
    private final OwnerMapper ownerMapper;
    private final OwnerCredentialsMapper ownerCredentialsMapper;

    @Transactional
    @Override
    public boolean save(OwnerSaveDto ownerSaveDto) {
        Owner owner = ownerRepository.save(ownerMapper.mapToOwner(ownerSaveDto));

        OwnerCredentials ownerCredentials = ownerCredentialsMapper.mapToOwnerCredentials(ownerSaveDto.getOwnerCredentialsSaveDto());
        ownerCredentials.setOwner(owner);
        ownerCredentialsRepository.save(ownerCredentials);

        return true;
    }

    @Override
    public OwnerWithIdDto fetch(Integer id) {
        Owner owner = ownerRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(String.format("Owner with id as %s cannot be found.", id)));
        return ownerMapper.mapToOwnerWithIdDto(owner);
    }

    @Override
    public List<OwnerWithIdDto> fetchAll() {
        return ownerMapper.mapToOwnerWithIdDtos(ownerRepository.findAll());
    }

    @Transactional
    @Override
    public boolean update(OwnerWithIdDto ownerUpdateDto) {
        final Integer ownerId = ownerUpdateDto.getId();

        ownerRepository.findById(ownerId)
                .orElseThrow(() -> new ResourceNotFoundException(String.format("Owner with id as %s cannot be found.", ownerId)));

        Owner owner = ownerMapper.mapToOwner(ownerUpdateDto);
        ownerRepository.save(owner);

        return true;
    }

    @Transactional
    @Override
    public boolean delete(Integer id) {
        Owner owner = ownerRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(String.format("Owner with id as %s cannot be found.", id)));
        ownerRepository.delete(owner);
        return true;
    }
}
