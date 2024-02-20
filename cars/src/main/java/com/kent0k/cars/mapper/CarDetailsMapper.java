package com.kent0k.cars.mapper;

import com.kent0k.cars.dto.cardetails.CarDetailsDto;
import com.kent0k.cars.dto.cardetails.CarDetailsUpdateDto;
import com.kent0k.cars.entity.CarDetails;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CarDetailsMapper {

    CarDetails mapToCarDetails(CarDetailsDto carDetailsDto);

    CarDetails mapToCarDetails(CarDetailsUpdateDto carDetailsUpdateDto);
}
