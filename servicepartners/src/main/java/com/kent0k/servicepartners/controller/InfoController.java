package com.kent0k.servicepartners.controller;

import com.kent0k.servicepartners.dto.ErrorResponseDto;
import com.kent0k.servicepartners.dto.MyCarConfigDto;
import com.kent0k.servicepartners.dto.ResponseDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/api/cars/info", produces = {MediaType.APPLICATION_JSON_VALUE})
@AllArgsConstructor
@Tag(
        name = "REST APIs with information data about ServicePartner",
        description = "REST APIs with information data about ServicePartner"
)
public class InfoController {

    private final MyCarConfigDto myCarConfigDto;

    @Operation(
            summary = "Fetch information data about ServicePartner REST API",
            description = "REST API to fetch information data about ServicePartner"
    )
    @ApiResponses({
            @ApiResponse(
                    responseCode = "200",
                    description = "HTTP Status OK"
            ),
            @ApiResponse(
                    responseCode = "500",
                    description = "HTTP Status Internal Server Error",
                    content = @Content(
                            schema = @Schema(implementation = ErrorResponseDto.class)
                    )
            )
    })
    @GetMapping
    public ResponseEntity<ResponseDto> fetchInfoData() {
        return ResponseEntity.ok(new ResponseDto(myCarConfigDto, null));
    }
}
