package org.kent0k.sshextractor;

import org.kent0k.sshextractor.dto.MyCarSshExtractorConfigDto;
import org.kent0k.sshextractor.service.SshExtractorServiceImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
@EnableConfigurationProperties(MyCarSshExtractorConfigDto.class)
public class SshextractorApplication {

    private static ApplicationContext applicationContext;

    public SshextractorApplication(ApplicationContext applicationContext) {
        SshextractorApplication.applicationContext = applicationContext;
    }

    public static void main(String[] args) {
        SpringApplication.run(SshextractorApplication.class, args);

        applicationContext.getBean("sshExtractorServiceImpl", SshExtractorServiceImpl.class)
                .addSshFilesToProjectDirectory();
    }

}
