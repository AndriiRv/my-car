package com.kent0k.cars.mapper.graphql;

import com.kent0k.cars.dto.graphql.CarStatisticsGraphQlDto;
import com.kent0k.cars.entity.CarStatistics;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CarStatisticsGraphQlMapper {

    CarStatisticsGraphQlDto carStatisticsToCarStatisticsGraphQlDto(CarStatistics carStatistics);

}
