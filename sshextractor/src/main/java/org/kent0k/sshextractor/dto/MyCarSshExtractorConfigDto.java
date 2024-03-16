package org.kent0k.sshextractor.dto;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(value = "ssh-extractor")
public class MyCarSshExtractorConfigDto {

    private String osSshFolderName;

    private String projectSshFolderName;

    public String getOsSshFolderName() {
        return osSshFolderName;
    }

    public void setOsSshFolderName(String osSshFolderName) {
        this.osSshFolderName = osSshFolderName;
    }

    public String getProjectSshFolderName() {
        return projectSshFolderName;
    }

    public void setProjectSshFolderName(String projectSshFolderName) {
        this.projectSshFolderName = projectSshFolderName;
    }

    @Override
    public String toString() {
        return "MyCarSshExtractorConfigDto{" +
                "osSshFolderName='" + osSshFolderName + '\'' +
                ", projectSshFolderName='" + projectSshFolderName + '\'' +
                '}';
    }
}
