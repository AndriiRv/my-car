package com.kent0k.cars.dto.external;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Schema(
        name = "ServicePartnerDto",
        description = "Schema about holding ServicePartner information. Used by Feign."
)
public record ServicePartnerDto(
        @NotNull @Schema(description = "Service partner identifier as integer value", example = "123") Integer id,
        @NotBlank @Size(max = 20) @Schema(description = "Service partner title", example = "Motorcraft") String title,
        @NotBlank @Size(max = 50) @Schema(description = "Service partner address", example = "Bageterie Boulevard") String address,
        @NotNull @Schema(description = "Service partner identifier as integer value", example = "true") Boolean currentWorkStatus) {
}
