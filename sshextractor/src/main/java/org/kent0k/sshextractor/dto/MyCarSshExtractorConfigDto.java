package org.kent0k.sshextractor.dto;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(value = "ssh-extractor")
public record MyCarSshExtractorConfigDto(String osSshFolderName, String projectSshFolderName, Short threadTimeout) {
}
