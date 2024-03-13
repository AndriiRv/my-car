package com.kent0k.cars.service.graphql;

import com.kent0k.cars.dto.graphql.CarGraphQlDto;
import com.kent0k.cars.dto.graphql.CarDetailsGraphQlDto;
import com.kent0k.cars.dto.graphql.CarStatisticsGraphQlDto;
import com.kent0k.cars.entity.Car;
import com.kent0k.cars.entity.CarDetails;
import com.kent0k.cars.entity.CarStatistics;
import com.kent0k.cars.exception.ResourceNotFoundException;
import com.kent0k.cars.mapper.graphql.CarDetailsGraphQlMapper;
import com.kent0k.cars.mapper.graphql.CarGraphQlMapper;
import com.kent0k.cars.mapper.graphql.CarStatisticsGraphQlMapper;
import com.kent0k.cars.repository.CarDetailsRepository;
import com.kent0k.cars.repository.CarRepository;
import com.kent0k.cars.repository.CarStatisticsRepository;
import com.kent0k.cars.service.CarGraphQlService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CarGraphQlServiceImpl implements CarGraphQlService {

    private final CarRepository carRepository;
    private final CarDetailsRepository carDetailsRepository;
    private final CarStatisticsRepository carStatisticsRepository;
    private final CarGraphQlMapper carGraphQlMapper;
    private final CarDetailsGraphQlMapper carDetailsGraphQlMapper;
    private final CarStatisticsGraphQlMapper carStatisticsGraphQlMapper;

    @Override
    public CarGraphQlDto findById(Integer id) {
        Car car = carRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(String.format("Car with id as %s cannot be found.", id)));
        return carGraphQlMapper.carToCarGraphQlDto(car);
    }

    @Override
    public CarDetailsGraphQlDto findCarDetailsByCarId(Integer id) {
        CarDetails carDetails = carDetailsRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(String.format("CarDetails with id as %s cannot be found.", id)));
        return carDetailsGraphQlMapper.carDetailsToCarDetailsGraphQlDto(carDetails);
    }

    @Override
    public CarStatisticsGraphQlDto findCarStatisticsByCarId(Integer id) {
        CarStatistics carStatistics = carStatisticsRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(String.format("CarStatistics with id as %s cannot be found.", id)));
        return carStatisticsGraphQlMapper.carStatisticsToCarStatisticsGraphQlDto(carStatistics);
    }
}
