package com.kent0k.cars.service;

import com.kent0k.cars.dto.carstatistics.CarStatisticsWithIdDto;

import java.util.List;

public interface CarStatisticsService {

    CarStatisticsWithIdDto fetch(Integer id);

    List<CarStatisticsWithIdDto> fetchAll();

    boolean update(CarStatisticsWithIdDto carUpdateDto);

    boolean delete(Integer id);
}
