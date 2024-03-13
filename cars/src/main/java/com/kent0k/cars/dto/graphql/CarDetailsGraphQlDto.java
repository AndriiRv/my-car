package com.kent0k.cars.dto.graphql;

public record CarDetailsGraphQlDto(Integer id,
                                   String title,
                                   String manufacturer,
                                   String releaseDate,
                                   String purchaseDate,
                                   String fuel,
                                   String transmission) {
}
