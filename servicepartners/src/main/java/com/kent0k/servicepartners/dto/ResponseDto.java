package com.kent0k.servicepartners.dto;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(
        name = "ResponseDto",
        description = "Schema about holding response data which intended to the client as part of the response"
)
public record ResponseDto(
        @Schema(description = "Object which intended to be returned as part of response. Could be null") Object data,
        @Schema(description = "Status message. Could be as null", example = "Entity is created") String statusMsg) {

    public ResponseDto(String statusMsg) {
        this(null, statusMsg);
    }
}
