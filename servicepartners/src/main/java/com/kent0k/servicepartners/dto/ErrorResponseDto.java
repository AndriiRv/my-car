package com.kent0k.servicepartners.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

@Schema(
        name = "ErrorResponseDto",
        description = "Schema about holding error response data which intended to the client as part of the response"
)
public record ErrorResponseDto(
        @Schema(description = "REST api path", example = "uri=/api/service-partners") String apiPath,
        @Schema(description = "Http status string error literal", example = "NOT_FOUND") HttpStatus errorCode,
        @Schema(description = "Error message", example = "Entity cannot be found") String errorMessage,
        @Schema(description = "Current timestamp when error was thrown", example = "2024-03-02T20:16:05.9559751") LocalDateTime errorDateTime) {
}
