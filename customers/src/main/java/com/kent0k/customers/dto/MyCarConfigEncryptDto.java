package com.kent0k.customers.dto;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@EnableConfigurationProperties
@ConfigurationProperties(value = "my-car-config.encrypt")
@Data
public class MyCarConfigEncryptDto {

    private String password;
}
