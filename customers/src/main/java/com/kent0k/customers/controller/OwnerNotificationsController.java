package com.kent0k.customers.controller;

import com.kent0k.customers.dto.ErrorResponseDto;
import com.kent0k.customers.dto.ResponseDto;
import com.kent0k.customers.dto.ownernotifications.OwnerNotificationsDto;
import com.kent0k.customers.dto.ownernotifications.OwnerNotificationsWithIdDto;
import com.kent0k.customers.service.OwnerNotificationsService;
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
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/api/owner-notifications", produces = {MediaType.APPLICATION_JSON_VALUE})
@AllArgsConstructor
@Tag(
        name = "CRUD REST APIs for Owner Notifications in 'My-car'",
        description = "CRUD REST APIs in 'My-car' to CREATE, UPDATE, FETCH AND DELETE owner notification entities"
)
public class OwnerNotificationsController {

    private final OwnerNotificationsService ownerNotificationsService;
    private final OwnerService ownerService;

    @Operation(
            summary = "Create Owner notification entity REST API",
            description = "REST API to create new OwnerNotifications inside 'My-car'"
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
    public ResponseEntity<ResponseDto> save(@Validated @RequestBody OwnerNotificationsDto saveDto) {
        return ownerNotificationsService.save(saveDto)
                ? ResponseEntity.status(HttpStatus.CREATED).body(new ResponseDto("Owner notification is created"))
                : ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new ResponseDto("Exception thrown during saving an owner notification"));
    }

    @Operation(
            summary = "Fetch Owner notification entity REST API",
            description = "REST API to fetch OwnerNotifications entity based on an owner notifications id"
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
        return ResponseEntity.ok(new ResponseDto(ownerNotificationsService.fetch(id), null));
    }

    @Operation(
            summary = "Fetch all Owner Notifications entities REST API",
            description = "REST API to fetch all Owner Notifications entities"
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
        return ResponseEntity.ok(new ResponseDto(ownerNotificationsService.fetchAll(), null));
    }

    @Operation(
            summary = "Update Owner Notification entity REST API",
            description = "REST API to update OwnerNotifications entities based on a owner notifications id"
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
    public ResponseEntity<ResponseDto> update(@Validated @RequestBody OwnerNotificationsWithIdDto updateDto) {
        return ownerNotificationsService.update(updateDto)
                ? ResponseEntity.ok(new ResponseDto("Owner notification is updated"))
                : ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new ResponseDto("Exception thrown during update an owner notification"));
    }

    @PutMapping("/update-notification-is_sent-status")
    public ResponseEntity<ResponseDto> updateNotificationIsSentStatus() {
        return ownerService.updateNotificationIsSentStatus()
                ? ResponseEntity.ok(new ResponseDto("Missing notification is updated with 'is_sent' as Y"))
                : ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new ResponseDto("Exception thrown during update an owner notification"));
    }

    @Operation(
            summary = "Delete OwnerNotification entities REST API",
            description = "REST API to delete OwnerNotification based on a owner notifications id"
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
        return ownerNotificationsService.delete(id)
                ? ResponseEntity.ok(new ResponseDto("Owner notification is deleted"))
                : ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new ResponseDto("Exception thrown during delete an owner notification"));
    }
}
