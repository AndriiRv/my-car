package com.kent0k.cars.dto.external;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.*;

import java.time.LocalDate;

@Schema(
        name = "OwnerDto",
        description = "Schema about holding Owner information. Used by Feign."
)
public record OwnerDto(@NotNull @Schema(description = "Owner identifier as integer value", example = "123") Integer id,
                       @NotBlank @Size(max = 20) @Schema(description = "Owners firstname", example = "John") String firstName,
                       @NotBlank @Size(max = 20) @Schema(description = "Owners lastName", example = "Smith") String lastName,
                       @NotNull @Past @Schema(description = "Owners birth date", example = "1988-12-12") LocalDate birthDate,
                       @NotBlank @Size(max = 50) @Email @Schema(description = "Owners email", example = "example@gmail.com") String email,
                       @NotBlank @Size(max = 20) @Schema(description = "Owners phone number", example = "+380971234567") String phoneNumber) {
}
