package com.kent0k.servicepartners.dto;

import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

public record ErrorResponseDto(String apiPath, HttpStatus errorCode, String errorMessage, LocalDateTime errorDateTime) {
}
