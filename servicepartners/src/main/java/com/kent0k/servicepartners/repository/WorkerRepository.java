package com.kent0k.servicepartners.repository;

import com.kent0k.servicepartners.entity.Worker;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface WorkerRepository extends MongoRepository<Worker, Integer>, CommonRepository<Worker> {

    void deleteAllByServicePartnerId(Integer servicePartnerId);
}
