package com.kent0k.customers.repository;

import com.kent0k.customers.entity.OwnerCredentials;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OwnerCredentialsRepository extends JpaRepository<OwnerCredentials, Integer> {
}
