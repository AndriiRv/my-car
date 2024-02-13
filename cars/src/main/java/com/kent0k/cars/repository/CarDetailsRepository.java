package com.kent0k.cars.repository;

import com.kent0k.cars.entity.CarDetails;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarDetailsRepository extends JpaRepository<CarDetails, Integer> {
}
