package com.kent0k.servicepartners.controller;

import com.kent0k.servicepartners.dto.ErrorResponseDto;
import com.kent0k.servicepartners.dto.ResponseDto;
import com.kent0k.servicepartners.dto.worker.WorkerSaveDto;
import com.kent0k.servicepartners.dto.worker.WorkerWithIdDto;
import com.kent0k.servicepartners.service.WorkerService;
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
@RequestMapping(path = "/api/workers", produces = {MediaType.APPLICATION_JSON_VALUE})
@AllArgsConstructor
@Tag(
        name = "CRUD REST APIs for Workers in 'My-car'",
        description = "CRUD REST APIs in 'My-car' to CREATE, UPDATE, FETCH AND DELETE workers entities"
)
public class WorkerController {

    private final WorkerService workerService;

    @Operation(
            summary = "Create Worker entity REST API",
            description = "REST API to create new Worker inside 'My-car'"
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
    public ResponseEntity<ResponseDto> save(@Validated @RequestBody WorkerSaveDto saveDto) {
        return workerService.save(saveDto)
                ? ResponseEntity.status(HttpStatus.CREATED).body(new ResponseDto("Worker is created"))
                : ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new ResponseDto("Exception thrown during saving the worker"));
    }

    @Operation(
            summary = "Fetch Worker entity REST API",
            description = "REST API to fetch Worker entity based on an workers id"
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
        return ResponseEntity.ok(new ResponseDto(workerService.fetch(id), null));
    }

    @Operation(
            summary = "Fetch all Worker maintenance entities REST API",
            description = "REST API to fetch all Worker entities"
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
        return ResponseEntity.ok(new ResponseDto(workerService.fetchAll(), null));
    }

    @Operation(
            summary = "Update Worker entity REST API",
            description = "REST API to update Worker entities based on a workers id"
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
    public ResponseEntity<ResponseDto> update(@Validated @RequestBody WorkerWithIdDto updateDto) {
        return workerService.update(updateDto)
                ? ResponseEntity.ok(new ResponseDto("Worker is updated"))
                : ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new ResponseDto("Exception thrown during update the worker"));
    }

    @Operation(
            summary = "Delete Worker entity REST API",
            description = "REST API to delete Worker based on a workers id"
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
        return workerService.delete(id)
                ? ResponseEntity.ok(new ResponseDto("Worker is deleted"))
                : ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new ResponseDto("Exception thrown during delete the worker"));
    }
}
