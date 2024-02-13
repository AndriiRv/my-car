package com.kent0k.cars.repository;

import com.kent0k.cars.entity.CarStatistics;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarStatisticsRepository extends JpaRepository<CarStatistics, Integer> {
}
