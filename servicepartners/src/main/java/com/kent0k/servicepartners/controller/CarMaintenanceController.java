package com.kent0k.servicepartners.controller;

import com.kent0k.servicepartners.dto.ErrorResponseDto;
import com.kent0k.servicepartners.dto.ResponseDto;
import com.kent0k.servicepartners.dto.carmaintenance.CarMaintenanceSaveDto;
import com.kent0k.servicepartners.dto.carmaintenance.CarMaintenanceWithIdDto;
import com.kent0k.servicepartners.service.CarMaintenanceService;
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
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/api/cars-maintenance", produces = {MediaType.APPLICATION_JSON_VALUE})
@AllArgsConstructor
@Tag(
        name = "CRUD REST APIs for Car maintenance in 'My-car'",
        description = "CRUD REST APIs in 'My-car' to CREATE, UPDATE, FETCH AND DELETE carMaintenance entities"
)
public class CarMaintenanceController {

    private final CarMaintenanceService carMaintenanceService;

    @Operation(
            summary = "Create Car maintenance entity REST API",
            description = "REST API to create new CarMaintenance inside 'My-car'"
    )
    @ApiResponses({
            @ApiResponse(
                    responseCode = "201",
                    description = "HTTP Status CREATED"
            ),
            @ApiResponse(
                    responseCode = "500",
                    description = "HTTP Status Internal Server Error",
                    content = @Content(
                            schema = @Schema(implementation = ErrorResponseDto.class)
                    )
            )
    })
    @PostMapping
    public ResponseEntity<ResponseDto> save(@Validated @RequestBody CarMaintenanceSaveDto saveDto) {
        return carMaintenanceService.save(saveDto)
                ? ResponseEntity.status(HttpStatus.CREATED).body(new ResponseDto("Car maintenance is created"))
                : ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new ResponseDto("Exception thrown during saving the car maintenance"));
    }

    @Operation(
            summary = "Fetch Car maintenance entity REST API",
            description = "REST API to fetch CarMaintenance entity based on an carMaintenance id"
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
        return ResponseEntity.ok(new ResponseDto(carMaintenanceService.fetch(id), null));
    }

    @Operation(
            summary = "Fetch all Car maintenance entities REST API",
            description = "REST API to fetch all CarMaintenance entities"
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
        return ResponseEntity.ok(new ResponseDto(carMaintenanceService.fetchAll(), null));
    }

    @Operation(
            summary = "Update Car maintenance entity REST API",
            description = "REST API to update CarMaintenance entities based on a carMaintenance id"
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
    public ResponseEntity<ResponseDto> update(@Validated @RequestBody CarMaintenanceWithIdDto updateDto) {
        return carMaintenanceService.update(updateDto)
                ? ResponseEntity.ok(new ResponseDto("Car maintenance is updated"))
                : ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new ResponseDto("Exception thrown during update the car maintenance"));
    }

    @Operation(
            summary = "Delete Car maintenance entity REST API",
            description = "REST API to delete CarMaintenance based on a carMaintenance id"
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
        return carMaintenanceService.delete(id)
                ? ResponseEntity.ok(new ResponseDto("Car maintenance is deleted"))
                : ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new ResponseDto("Exception thrown during delete the car maintenance"));
    }
}
