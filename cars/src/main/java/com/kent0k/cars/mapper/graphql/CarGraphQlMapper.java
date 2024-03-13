package com.kent0k.cars.mapper.graphql;

import com.kent0k.cars.dto.graphql.CarGraphQlDto;
import com.kent0k.cars.entity.Car;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CarGraphQlMapper {

    CarGraphQlDto carToCarGraphQlDto(Car car);

}
