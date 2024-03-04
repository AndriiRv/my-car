package com.kent0k.servicepartners;

import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableMongoRepositories
@OpenAPIDefinition(
        info = @Info(
                title = "Service Partners microservice REST API Documentation",
                description = "'My car' Service Partners microservice REST API Documentation",
                version = "v1",
                contact = @Contact(
                        name = "Andrii Reva",
                        email = "rewa.andrei2010@gmail.com",
                        url = "https://github.com/AndriiRv"
                ),
                license = @License(
                        name = "Apache 2.0",
                        url = "https://www.apache.org/licenses/LICENSE-2.0"
                )
        ),
        externalDocs = @ExternalDocumentation(
                description = "'My car' Service Partners microservice REST API Documentation",
                url = "https://github.com/AndriiRv/my-car"
        )
)
public class ServicepartnersApplication {

    public static void main(String[] args) {
        SpringApplication.run(ServicepartnersApplication.class, args);
    }
}
