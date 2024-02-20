package com.kent0k.cars.service;

import com.kent0k.cars.dto.car.CarDto;
import com.kent0k.cars.dto.car.CarSaveDto;
import com.kent0k.cars.dto.car.CarUpdateDto;

import java.util.List;

public interface CarService {

    boolean save(CarSaveDto carSaveDto);

    CarDto fetch(Integer id);

    List<CarDto> fetchAll();

    boolean update(CarUpdateDto carUpdateDto);

    boolean delete(Integer id);
}
