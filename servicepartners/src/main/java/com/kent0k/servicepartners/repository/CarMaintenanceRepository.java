package com.kent0k.servicepartners.repository;

import com.kent0k.servicepartners.entity.CarMaintenance;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface CarMaintenanceRepository extends MongoRepository<CarMaintenance, Integer>, CommonRepository<CarMaintenance> {

    void deleteAllByServicePartnerId(Integer servicePartnerId);

    Optional<CarMaintenance> findByCarIdAndOwnerId(Integer carId, Integer ownerId);

}
