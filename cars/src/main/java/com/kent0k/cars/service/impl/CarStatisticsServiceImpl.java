package com.kent0k.cars.service.impl;

import com.kent0k.cars.dto.carstatistics.CarStatisticsWithIdDto;
import com.kent0k.cars.entity.Car;
import com.kent0k.cars.entity.CarStatistics;
import com.kent0k.cars.exception.ResourceNotFoundException;
import com.kent0k.cars.mapper.CarStatisticsMapper;
import com.kent0k.cars.repository.CarRepository;
import com.kent0k.cars.repository.CarStatisticsRepository;
import com.kent0k.cars.service.CarStatisticsService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@AllArgsConstructor
public class CarStatisticsServiceImpl implements CarStatisticsService {

    private final CarStatisticsRepository carStatisticsRepository;
    private final CarRepository carRepository;
    private final CarStatisticsMapper carStatisticsMapper;

    @Override
    public CarStatisticsWithIdDto fetch(Integer id) {
        CarStatistics carStatistics = carStatisticsRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(String.format("Car statistics with id as %s cannot be found.", id)));
        return carStatisticsMapper.mapToCarStatisticsWithIdDto(carStatistics);
    }

    @Override
    public List<CarStatisticsWithIdDto> fetchAll() {
        return carStatisticsMapper.mapToCarStatisticsWithIdDtos(carStatisticsRepository.findAll());
    }

    @Transactional
    @Override
    public boolean update(CarStatisticsWithIdDto carStatisticsDto) {
        CarStatistics carStatistics = carStatisticsMapper.mapToCarStatistics(carStatisticsDto);

        Car car = carRepository.findById(carStatisticsDto.getId())
                .orElseThrow(() -> new ResourceNotFoundException(String.format("Car with id as %s cannot be found.", carStatisticsDto.getId())));
        carStatistics.setCar(car);

        carStatisticsRepository.save(carStatistics);
        return true;
    }

    @Transactional
    @Override
    public boolean delete(Integer id) {
        CarStatistics carStatistics = carStatisticsRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(String.format("Car statistics with id as %s cannot be found.", id)));

        carStatisticsRepository.delete(carStatistics);
        return true;
    }
}
