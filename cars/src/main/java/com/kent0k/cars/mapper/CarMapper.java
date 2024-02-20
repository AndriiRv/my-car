package com.kent0k.cars.mapper;

import com.kent0k.cars.dto.car.CarDto;
import com.kent0k.cars.dto.car.CarSaveDto;
import com.kent0k.cars.dto.car.CarUpdateDto;
import com.kent0k.cars.entity.Car;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CarMapper {

    CarDto mapToCarDto(Car car);

    List<CarDto> mapToCarDtos(List<Car> cars);

    Car mapToCar(CarSaveDto carSaveDto);

    Car mapToCar(CarUpdateDto carUpdateDto);
}
