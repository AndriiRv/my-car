package com.kent0k.cars.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(value = "my-car-config")
@Getter
@AllArgsConstructor
public class MyCarConfigDto {

    private String version;
    private String microserviceName;
    private String profile;
    private String author;
    private String authorsSocialAccountUrl;
}
