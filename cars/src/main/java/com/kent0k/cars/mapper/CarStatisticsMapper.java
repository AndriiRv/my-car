package com.kent0k.cars.mapper;

import com.kent0k.cars.dto.carstatistics.CarStatisticsDto;
import com.kent0k.cars.dto.carstatistics.CarStatisticsUpdateDto;
import com.kent0k.cars.entity.CarStatistics;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CarStatisticsMapper {

    CarStatistics mapToCarStatistics(CarStatisticsDto carStatisticsDto);

    CarStatistics mapToCarStatistics(CarStatisticsUpdateDto carStatisticsUpdateDto);
}
