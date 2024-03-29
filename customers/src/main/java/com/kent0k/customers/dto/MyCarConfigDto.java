package com.kent0k.customers.dto;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@EnableConfigurationProperties
@ConfigurationProperties(value = "my-car-config")
@Data
public class MyCarConfigDto {

    private String version;
    private String microserviceName;
    private String profile;
    private String author;
    private String authorsSocialAccountUrl;
}
