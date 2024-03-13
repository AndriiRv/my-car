package com.kent0k.cars.service;

import com.kent0k.cars.dto.graphql.CarDetailsGraphQlDto;
import com.kent0k.cars.dto.graphql.CarGraphQlDto;
import com.kent0k.cars.dto.graphql.CarStatisticsGraphQlDto;

public interface CarGraphQlService {

    CarGraphQlDto findById(Integer id);

    CarDetailsGraphQlDto findCarDetailsByCarId(Integer id);

    CarStatisticsGraphQlDto findCarStatisticsByCarId(Integer id);

}
