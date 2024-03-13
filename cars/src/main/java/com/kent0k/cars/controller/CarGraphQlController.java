package com.kent0k.cars.controller;

import com.kent0k.cars.dto.graphql.CarGraphQlDto;
import com.kent0k.cars.dto.graphql.CarDetailsGraphQlDto;
import com.kent0k.cars.dto.graphql.CarStatisticsGraphQlDto;
import com.kent0k.cars.service.graphql.CarGraphQlServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.graphql.data.method.annotation.SchemaMapping;
import org.springframework.stereotype.Controller;

@Controller
@AllArgsConstructor
public class CarGraphQlController {

    private final CarGraphQlServiceImpl carGraphQlService;

    @QueryMapping
    public CarGraphQlDto carById(@Argument Integer id) {
        return carGraphQlService.findById(id);
    }

    @SchemaMapping
    public CarDetailsGraphQlDto carDetails(CarGraphQlDto carGraphQlDto) {
        return carGraphQlService.findCarDetailsByCarId(carGraphQlDto.getId());
    }

    @SchemaMapping
    public CarStatisticsGraphQlDto carStatistics(CarGraphQlDto carGraphQlDto) {
        return carGraphQlService.findCarStatisticsByCarId(carGraphQlDto.getId());
    }
}
