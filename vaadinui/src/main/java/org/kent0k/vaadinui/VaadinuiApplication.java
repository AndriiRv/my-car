package org.kent0k.vaadinui;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class VaadinuiApplication {

    public static void main(String[] args) {
        SpringApplication.run(VaadinuiApplication.class, args);
    }

}
