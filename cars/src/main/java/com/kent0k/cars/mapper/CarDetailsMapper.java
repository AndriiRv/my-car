package com.kent0k.cars.mapper;

import com.kent0k.cars.dto.cardetails.CarDetailsDto;
import com.kent0k.cars.dto.cardetails.CarDetailsWithIdDto;
import com.kent0k.cars.entity.CarDetails;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CarDetailsMapper {

    CarDetails mapToCarDetails(CarDetailsDto carDetailsDto);

    CarDetails mapToCarDetails(CarDetailsWithIdDto carDetailsWithIdDto);

    CarDetailsWithIdDto mapToCarDetailsWithIdDto(CarDetails carDetails);

    List<CarDetailsWithIdDto> mapToCarDetailsWithIdDtos(List<CarDetails> carDetails);
}
