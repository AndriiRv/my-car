package com.kent0k.cars.service.impl;

import com.kent0k.cars.dto.car.CarDto;
import com.kent0k.cars.dto.car.CarSaveDto;
import com.kent0k.cars.dto.car.CarUpdateDto;
import com.kent0k.cars.entity.Car;
import com.kent0k.cars.entity.CarDetails;
import com.kent0k.cars.entity.CarStatistics;
import com.kent0k.cars.exception.ResourceNotFoundException;
import com.kent0k.cars.mapper.CarDetailsMapper;
import com.kent0k.cars.mapper.CarMapper;
import com.kent0k.cars.mapper.CarStatisticsMapper;
import com.kent0k.cars.repository.CarDetailsRepository;
import com.kent0k.cars.repository.CarRepository;
import com.kent0k.cars.repository.CarStatisticsRepository;
import com.kent0k.cars.service.CarService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@AllArgsConstructor
public class CarServiceImpl implements CarService {

    private final CarRepository carRepository;
    private final CarDetailsRepository carDetailsRepository;
    private final CarStatisticsRepository carStatisticsRepository;
    private final CarMapper carMapper;
    private final CarDetailsMapper carDetailsMapper;
    private final CarStatisticsMapper carStatisticsMapper;

    @Transactional
    @Override
    public boolean save(CarSaveDto carSaveDto) {
        Car car = carRepository.save(carMapper.mapToCar(carSaveDto));

        CarDetails carDetails = carDetailsMapper.mapToCarDetails(carSaveDto.getCarDetailsDto());
        carDetails.setCar(car);

        CarStatistics carStatistics = carStatisticsMapper.mapToCarStatistics(carSaveDto.getCarStatisticsDto());
        carStatistics.setCar(car);

        carDetailsRepository.save(carDetails);
        carStatisticsRepository.save(carStatistics);

        return true;
    }

    @Override
    public CarDto fetch(Integer id) {
        Car car = carRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(String.format("Car with id as %s cannot be found.", id)));
        return carMapper.mapToCarDto(car);
    }

    @Override
    public List<CarDto> fetchAll() {
        return carMapper.mapToCarDtos(carRepository.findAll());
    }

    @Override
    public boolean update(CarUpdateDto carUpdateDto) {
        carRepository.save(carMapper.mapToCar(carUpdateDto));
        return true;
    }

    @Transactional
    @Override
    public boolean delete(Integer id) {
        Car car = carRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(String.format("Car with id as %s cannot be found.", id)));
        carRepository.delete(car);
        return true;
    }
}
