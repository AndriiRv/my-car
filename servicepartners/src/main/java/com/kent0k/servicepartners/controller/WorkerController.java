package com.kent0k.servicepartners.controller;

import com.kent0k.servicepartners.dto.ResponseDto;
import com.kent0k.servicepartners.dto.worker.WorkerSaveDto;
import com.kent0k.servicepartners.dto.worker.WorkerWithIdDto;
import com.kent0k.servicepartners.service.WorkerService;
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
public class WorkerController {

    private final WorkerService workerService;

    @PostMapping
    public ResponseEntity<ResponseDto> save(@Validated @RequestBody WorkerSaveDto saveDto) {
        return workerService.save(saveDto)
                ? ResponseEntity.status(HttpStatus.CREATED).body(new ResponseDto("Worker is created"))
                : ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new ResponseDto("Exception thrown during saving the worker"));
    }

    @GetMapping
    public ResponseEntity<ResponseDto> fetch(@RequestParam Integer id) {
        return ResponseEntity.ok(new ResponseDto(workerService.fetch(id), null));
    }

    @GetMapping("/all")
    public ResponseEntity<ResponseDto> fetchAll() {
        return ResponseEntity.ok(new ResponseDto(workerService.fetchAll(), null));
    }

    @PutMapping
    public ResponseEntity<ResponseDto> update(@Validated @RequestBody WorkerWithIdDto updateDto) {
        return workerService.update(updateDto)
                ? ResponseEntity.ok(new ResponseDto("Worker is updated"))
                : ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new ResponseDto("Exception thrown during update the worker"));
    }

    @DeleteMapping
    public ResponseEntity<ResponseDto> delete(@RequestParam Integer id) {
        return workerService.delete(id)
                ? ResponseEntity.ok(new ResponseDto("Worker is deleted"))
                : ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new ResponseDto("Exception thrown during delete the worker"));
    }
}
