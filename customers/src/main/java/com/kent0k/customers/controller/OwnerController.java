package com.kent0k.customers.controller;

import com.kent0k.customers.dto.ErrorResponseDto;
import com.kent0k.customers.dto.ResponseDto;
import com.kent0k.customers.dto.owner.OwnerDto;
import com.kent0k.customers.dto.owner.OwnerSaveDto;
import com.kent0k.customers.dto.owner.OwnerWithIdDto;
import com.kent0k.customers.service.OwnerService;
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
@RequestMapping(path = "/api/owners", produces = {MediaType.APPLICATION_JSON_VALUE})
@AllArgsConstructor
@Tag(
        name = "CRUD REST APIs for Customers/Owners in 'My-car'",
        description = "CRUD REST APIs in 'My-car' to CREATE, UPDATE, FETCH AND DELETE owner entities"
)
public class OwnerController {

    private final OwnerService ownerService;

    @Operation(
            summary = "Create Owner entity REST API",
            description = "REST API to create new Owner and OwnerCredentials inside 'My-car'"
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
    public ResponseEntity<ResponseDto> save(@Validated @RequestBody OwnerSaveDto ownerSaveDto) {
        return ownerService.save(ownerSaveDto)
                ? ResponseEntity.status(HttpStatus.CREATED).body(new ResponseDto("Owner is created"))
                : ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new ResponseDto("Exception thrown during saving an owner"));
    }

    @Operation(
            summary = "Fetch Owner entity REST API",
            description = "REST API to fetch Owner entity based on an owners id"
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
        return ResponseEntity.ok(new ResponseDto(ownerService.fetch(id), null));
    }

    @GetMapping("/raw")
    public ResponseEntity<OwnerDto> fetchRaw(@RequestParam Integer id) {
        return ResponseEntity.ok(ownerService.fetch(id));
    }

    @Operation(
            summary = "Fetch all Owner entities REST API",
            description = "REST API to fetch all Owner entities"
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
            summary = "Update Owner entity REST API",
            description = "REST API to update Owner and OwnerCredentials entities based on a owners id"
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
    public ResponseEntity<ResponseDto> update(@Validated @RequestBody OwnerWithIdDto ownerUpdateDto) {
        return ownerService.update(ownerUpdateDto)
                ? ResponseEntity.ok(new ResponseDto("Owner is updated"))
                : ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new ResponseDto("Exception thrown during update an owner"));
    }

    @Operation(
            summary = "Delete Owner, OwnerCredentials and OwnerNotification entities REST API",
            description = "REST API to delete Owner, OwnerCredentials and OwnerNotification based on a owners id"
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
        return ownerService.delete(id)
                ? ResponseEntity.ok(new ResponseDto("Owner is deleted"))
                : ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new ResponseDto("Exception thrown during delete an owner"));
    }
}
