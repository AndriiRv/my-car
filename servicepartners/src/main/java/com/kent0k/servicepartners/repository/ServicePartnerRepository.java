package com.kent0k.servicepartners.repository;

import com.kent0k.servicepartners.entity.ServicePartner;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ServicePartnerRepository extends MongoRepository<ServicePartner, Integer>, CommonRepository<ServicePartner> {
}
