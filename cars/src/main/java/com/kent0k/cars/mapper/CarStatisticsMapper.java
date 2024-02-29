package com.kent0k.cars.mapper;

import com.kent0k.cars.dto.carstatistics.CarStatisticsDto;
import com.kent0k.cars.dto.carstatistics.CarStatisticsWithIdDto;
import com.kent0k.cars.entity.CarStatistics;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CarStatisticsMapper {

    CarStatistics mapToCarStatistics(CarStatisticsDto carStatisticsDto);

    CarStatistics mapToCarStatistics(CarStatisticsWithIdDto carStatisticsWithIdDto);

    CarStatisticsWithIdDto mapToCarStatisticsWithIdDto(CarStatistics carStatistics);

    List<CarStatisticsWithIdDto> mapToCarStatisticsWithIdDtos(List<CarStatistics> carStatistics);
}
