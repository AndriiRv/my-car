package com.kent0k.servicepartners;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableMongoRepositories
public class ServicepartnersApplication {

    public static void main(String[] args) {
        SpringApplication.run(ServicepartnersApplication.class, args);
    }
}
