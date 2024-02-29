package com.kent0k.cars.service;

import com.kent0k.cars.dto.cardetails.CarDetailsWithIdDto;

import java.util.List;

public interface CarDetailsService {

    CarDetailsWithIdDto fetch(Integer id);

    List<CarDetailsWithIdDto> fetchAll();

    boolean update(CarDetailsWithIdDto carUpdateDto);

    boolean delete(Integer id);
}
