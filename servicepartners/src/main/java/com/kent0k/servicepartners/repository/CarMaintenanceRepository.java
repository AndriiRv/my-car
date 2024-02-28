package com.kent0k.servicepartners.repository;

import com.kent0k.servicepartners.entity.CarMaintenance;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CarMaintenanceRepository extends MongoRepository<CarMaintenance, Integer>, CommonRepository<CarMaintenance> {
}
