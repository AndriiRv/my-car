package com.kent0k.servicepartners.controller;

import com.kent0k.servicepartners.dto.ErrorResponseDto;
import com.kent0k.servicepartners.dto.ResponseDto;
import com.kent0k.servicepartners.dto.servicepartner.ServicePartnerSaveDto;
import com.kent0k.servicepartners.dto.servicepartner.ServicePartnerWithIdDto;
import com.kent0k.servicepartners.service.ServicePartnerService;
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
@RequestMapping(path = "/api/service-partners", produces = {MediaType.APPLICATION_JSON_VALUE})
@AllArgsConstructor
@Tag(
        name = "CRUD REST APIs for Service Partners in 'My-car'",
        description = "CRUD REST APIs in 'My-car' to CREATE, UPDATE, FETCH AND DELETE servicepartners entities"
)
public class ServicePartnerController {

    private final ServicePartnerService servicePartnerService;

    @Operation(
            summary = "Create Service Partner entity REST API",
            description = "REST API to create new ServicePartner inside 'My-car'"
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
    public ResponseEntity<ResponseDto> save(@Validated @RequestBody ServicePartnerSaveDto saveDto) {
        return servicePartnerService.save(saveDto)
                ? ResponseEntity.status(HttpStatus.CREATED).body(new ResponseDto("Service partner is created"))
                : ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new ResponseDto("Exception thrown during saving the service partner"));
    }

    @Operation(
            summary = "Fetch Service Partner entity REST API",
            description = "REST API to fetch Owner entity based on a servicePartners id"
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
        return ResponseEntity.ok(new ResponseDto(servicePartnerService.fetch(id), null));
    }

    @Operation(
            summary = "Fetch all Service Partner entities REST API",
            description = "REST API to fetch all ServicePartner entities"
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
        return ResponseEntity.ok(new ResponseDto(servicePartnerService.fetchAll(), null));
    }

    @Operation(
            summary = "Update Service Partner entity REST API",
            description = "REST API to update ServicePartner entities based on a servicePartners id"
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
    public ResponseEntity<ResponseDto> update(@Validated @RequestBody ServicePartnerWithIdDto updateDto) {
        return servicePartnerService.update(updateDto)
                ? ResponseEntity.ok(new ResponseDto("Service partner is updated"))
                : ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new ResponseDto("Exception thrown during update the service partner"));
    }

    @Operation(
            summary = "Delete Service Partner, Worker and Car Maintenance entity REST API",
            description = "REST API to delete ServicePartner, Worker and CarMaintenance based on a servicePartners id"
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
        return servicePartnerService.delete(id)
                ? ResponseEntity.ok(new ResponseDto("Service partner is deleted"))
                : ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new ResponseDto("Exception thrown during delete the service partner"));
    }
}
