package com.kent0k.cars.dto;

import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

public record ErrorResponseDto(String apiPath, HttpStatus errorCode, String errorMessage, LocalDateTime errorDateTime) {
}
