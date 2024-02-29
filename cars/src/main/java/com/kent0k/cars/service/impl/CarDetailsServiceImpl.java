package com.kent0k.cars.service.impl;

import com.kent0k.cars.dto.cardetails.CarDetailsWithIdDto;
import com.kent0k.cars.entity.Car;
import com.kent0k.cars.entity.CarDetails;
import com.kent0k.cars.exception.ResourceNotFoundException;
import com.kent0k.cars.mapper.CarDetailsMapper;
import com.kent0k.cars.repository.CarDetailsRepository;
import com.kent0k.cars.repository.CarRepository;
import com.kent0k.cars.service.CarDetailsService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@AllArgsConstructor
public class CarDetailsServiceImpl implements CarDetailsService {

    private final CarDetailsRepository carDetailsRepository;
    private final CarRepository carRepository;
    private final CarDetailsMapper carDetailsMapper;

    @Override
    public CarDetailsWithIdDto fetch(Integer id) {
        CarDetails carDetails = carDetailsRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(String.format("Car details with id as %s cannot be found.", id)));
        return carDetailsMapper.mapToCarDetailsWithIdDto(carDetails);
    }

    @Override
    public List<CarDetailsWithIdDto> fetchAll() {
        return carDetailsMapper.mapToCarDetailsWithIdDtos(carDetailsRepository.findAll());
    }

    @Transactional
    @Override
    public boolean update(CarDetailsWithIdDto carDetailsDto) {
        CarDetails carDetails = carDetailsMapper.mapToCarDetails(carDetailsDto);

        Car car = carRepository.findById(carDetailsDto.getId())
                .orElseThrow(() -> new ResourceNotFoundException(String.format("Car with id as %s cannot be found.", carDetailsDto.getId())));
        carDetails.setCar(car);

        carDetailsRepository.save(carDetails);
        return true;
    }

    @Transactional
    @Override
    public boolean delete(Integer id) {
        CarDetails carDetails = carDetailsRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(String.format("Car details with id as %s cannot be found.", id)));

        carDetailsRepository.delete(carDetails);
        return true;
    }
}
