package com.kent0k.customers.service.impl;

import com.kent0k.customers.dto.ownercredentials.OwnerCredentialsSaveDto;
import com.kent0k.customers.dto.ownercredentials.OwnerCredentialsWithIdDto;
import com.kent0k.customers.entity.Owner;
import com.kent0k.customers.entity.OwnerCredentials;
import com.kent0k.customers.exception.OperationForbiddenException;
import com.kent0k.customers.exception.ResourceNotFoundException;
import com.kent0k.customers.mapper.OwnerCredentialsMapper;
import com.kent0k.customers.repository.OwnerCredentialsRepository;
import com.kent0k.customers.repository.OwnerRepository;
import com.kent0k.customers.service.OwnerCredentialsService;
import com.kent0k.customers.helper.EncryptDecryptHelper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@AllArgsConstructor
public class OwnerCredentialsServiceImpl implements OwnerCredentialsService {

    private final OwnerRepository ownerRepository;
    private final OwnerCredentialsRepository ownerCredentialsRepository;
    private final OwnerCredentialsMapper ownerCredentialsMapper;
    private final EncryptDecryptHelper encryptDecryptHelper;

    @Override
    public boolean save(OwnerCredentialsSaveDto saveDto) {
        throw new OperationForbiddenException("Cannot to save OwnerCredentials without Owner");
    }

    @Override
    public OwnerCredentialsWithIdDto fetch(Integer id) {
        OwnerCredentials ownerCredentials = ownerCredentialsRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(String.format("Owner credentials with id as %s cannot be found.", id)));

        ownerCredentials.setUsername(encryptDecryptHelper.decrypt(ownerCredentials.getUsername()));
        ownerCredentials.setPassword(encryptDecryptHelper.decrypt(ownerCredentials.getPassword()));

        return ownerCredentialsMapper.mapToOwnerCredentialsWithIdDto(ownerCredentials);
    }

    @Override
    public List<OwnerCredentialsWithIdDto> fetchAll() {
        List<OwnerCredentials> ownerCredentials = ownerCredentialsRepository.findAll();
        ownerCredentials.forEach(e -> {
            e.setUsername(encryptDecryptHelper.decrypt(e.getUsername()));
            e.setPassword(encryptDecryptHelper.decrypt(e.getPassword()));
        });
        return ownerCredentialsMapper.mapToOwnerCredentialsWithIdDtos(ownerCredentials);
    }

    @Transactional
    @Override
    public boolean update(OwnerCredentialsWithIdDto updateDto) {
        final Integer ownerId = updateDto.getId();

        Owner owner = ownerRepository.findById(ownerId)
                .orElseThrow(() -> new ResourceNotFoundException(String.format("Owner with id as %s cannot be found.", ownerId)));

        OwnerCredentials ownerCredentials = ownerCredentialsMapper.mapToOwnerCredentials(updateDto);
        ownerCredentials.setOwner(owner);

        ownerCredentials.setUsername(encryptDecryptHelper.encrypt(ownerCredentials.getUsername()));
        ownerCredentials.setPassword(encryptDecryptHelper.encrypt(ownerCredentials.getPassword()));

        ownerCredentialsRepository.save(ownerCredentials);

        return true;
    }

    @Transactional
    @Override
    public boolean delete(Integer id) {
        OwnerCredentials ownerCredentials = ownerCredentialsRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(String.format("Owner credentials with id as %s cannot be found.", id)));
        ownerCredentialsRepository.delete(ownerCredentials);
        return true;
    }
}
