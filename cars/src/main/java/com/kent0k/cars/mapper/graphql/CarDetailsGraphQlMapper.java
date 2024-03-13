package com.kent0k.cars.mapper.graphql;

import com.kent0k.cars.dto.graphql.CarDetailsGraphQlDto;
import com.kent0k.cars.entity.CarDetails;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CarDetailsGraphQlMapper {

    CarDetailsGraphQlDto carDetailsToCarDetailsGraphQlDto(CarDetails carDetails);

}
