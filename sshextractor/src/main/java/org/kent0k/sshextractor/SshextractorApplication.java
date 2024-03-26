package org.kent0k.sshextractor;

import org.kent0k.sshextractor.dto.MyCarSshExtractorConfigDto;
import org.kent0k.sshextractor.helper.ApplicationContextHelper;
import org.kent0k.sshextractor.service.SshExtractorServiceImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties(MyCarSshExtractorConfigDto.class)
public class SshextractorApplication {

    private static ApplicationContextHelper applicationContextHelper;

    public SshextractorApplication(ApplicationContextHelper applicationContextHelper) {
        SshextractorApplication.applicationContextHelper = applicationContextHelper;
    }

    public static void main(String[] args) {
        SpringApplication.run(SshextractorApplication.class, args);

        applicationContextHelper.getBean(SshExtractorServiceImpl.class).addSshFilesToProjectDirectory();
    }

}
