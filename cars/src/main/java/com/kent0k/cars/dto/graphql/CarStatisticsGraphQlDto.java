package com.kent0k.cars.dto.graphql;

public record CarStatisticsGraphQlDto(Integer id,
                                      Double mileage,
                                      Double averageSpeed,
                                      Double averageFuelConsumption,
                                      Integer lastTimeAfterEngineStartSeconds,
                                      Integer averageRideTimeSeconds) {
}
