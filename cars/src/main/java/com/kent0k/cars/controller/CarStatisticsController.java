package com.kent0k.cars.controller;

import com.kent0k.cars.dto.ErrorResponseDto;
import com.kent0k.cars.dto.ResponseDto;
import com.kent0k.cars.dto.carstatistics.CarStatisticsWithIdDto;
import com.kent0k.cars.service.CarStatisticsService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/api/car-statistics", produces = {MediaType.APPLICATION_JSON_VALUE})
@AllArgsConstructor
@Tag(
        name = "CRUD REST APIs for Car Statistics in 'My-car'",
        description = "CRUD REST APIs in 'My-car' to CREATE, UPDATE, FETCH AND DELETE car statistics entities"
)
public class CarStatisticsController {

    private final CarStatisticsService carStatisticsService;

    @Operation(
            summary = "Fetch Car Statistics entity REST API",
            description = "REST API to fetch Car Statistics entity based on an car's id"
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
    public ResponseEntity<ResponseDto> fetch(@RequestParam Integer id) {
        return ResponseEntity.ok(new ResponseDto(carStatisticsService.fetch(id), null));
    }

    @Operation(
            summary = "Fetch all Car Statistics entities REST API",
            description = "REST API to fetch all Car Statistics entities"
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
    @GetMapping("/all")
    public ResponseEntity<ResponseDto> fetchAll() {
        return ResponseEntity.ok(new ResponseDto(carStatisticsService.fetchAll(), null));
    }

    @Operation(
            summary = "Update Car Details entity REST API",
            description = "REST API to update Car Details entity based on a car's id"
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
    @PutMapping
    public ResponseEntity<ResponseDto> update(@Validated @RequestBody CarStatisticsWithIdDto carUpdateDto) {
        return carStatisticsService.update(carUpdateDto)
                ? ResponseEntity.ok(new ResponseDto("Car statistics is updated"))
                : ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new ResponseDto("Exception thrown during update the car statistics"));
    }

    @Operation(
            summary = "Delete Car, Car Details and Car Statistics entity REST API",
            description = "REST API to delete Car, CarDetails and CarStatistics based on a car's id"
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
    @DeleteMapping
    public ResponseEntity<ResponseDto> delete(@RequestParam Integer id) {
        return carStatisticsService.delete(id)
                ? ResponseEntity.ok(new ResponseDto("Car statistics is deleted"))
                : ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new ResponseDto("Exception thrown during delete the car statistics"));
    }
}
