package com.kent0k.customers.controller;

import com.kent0k.customers.dto.ErrorResponseDto;
import com.kent0k.customers.dto.ResponseDto;
import com.kent0k.customers.dto.ownercredentials.OwnerCredentialsDto;
import com.kent0k.customers.dto.ownercredentials.OwnerCredentialsSaveDto;
import com.kent0k.customers.dto.ownercredentials.OwnerCredentialsUpdateDto;
import com.kent0k.customers.service.OwnerService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/api/owner-credentials", produces = {MediaType.APPLICATION_JSON_VALUE})
@Tag(
        name = "CRUD REST APIs for Owner Credentials in 'My-car'",
        description = "CRUD REST APIs in 'My-car' to CREATE, UPDATE, FETCH AND DELETE owner credentials entities"
)
public class OwnerCredentialsController {

    private final OwnerService<OwnerCredentialsDto, OwnerCredentialsSaveDto, OwnerCredentialsUpdateDto> ownerService;

    public OwnerCredentialsController(@Qualifier(value = "ownerCredentialsServiceImpl") OwnerService<OwnerCredentialsDto, OwnerCredentialsSaveDto, OwnerCredentialsUpdateDto> ownerService) {
        this.ownerService = ownerService;
    }

    @Operation(
            summary = "Fetch Owner Credentials entity REST API",
            description = "REST API to fetch OwnerCredentials entity based on an owner credentials id"
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
    public ResponseEntity<ResponseDto> fetch(Integer id) {
        return ResponseEntity.ok(new ResponseDto(ownerService.fetch(id), null));
    }

    @Operation(
            summary = "Fetch all Owner Credentials entities REST API",
            description = "REST API to fetch all Owner Credentials entities"
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
        return ResponseEntity.ok(new ResponseDto(ownerService.fetchAll(), null));
    }

    @Operation(
            summary = "Update Owner Credentials entity REST API",
            description = "REST API to update OwnerCredentials entities based on a owner credentials id"
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
    public ResponseEntity<ResponseDto> update(OwnerCredentialsUpdateDto updateDto) {
        return ownerService.update(updateDto)
                ? ResponseEntity.ok(new ResponseDto("Owner credentials is updated"))
                : ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new ResponseDto("Exception thrown during update an owner credentials"));
    }

    @Operation(
            summary = "Delete Owner and OwnerCredentials and OwnerNotification entities REST API",
            description = "REST API to delete Owner, OwnerCredentials and OwnerNotification based on a owner credentials id"
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
    public ResponseEntity<ResponseDto> delete(Integer id) {
        return ownerService.delete(id)
                ? ResponseEntity.ok(new ResponseDto("Owner and Owner credentials is deleted"))
                : ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new ResponseDto("Exception thrown during delete an owner credentials"));
    }
}
