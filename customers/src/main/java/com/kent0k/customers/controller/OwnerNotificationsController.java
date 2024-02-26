package com.kent0k.customers.controller;

import com.kent0k.customers.dto.ResponseDto;
import com.kent0k.customers.dto.ownernotifications.OwnerNotificationsDto;
import com.kent0k.customers.dto.ownernotifications.OwnerNotificationsUpdateDto;
import com.kent0k.customers.service.OwnerService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/api/owner-notifications", produces = {MediaType.APPLICATION_JSON_VALUE})
public class OwnerNotificationsController {

    private final OwnerService<OwnerNotificationsDto, OwnerNotificationsDto, OwnerNotificationsUpdateDto> ownerService;

    public OwnerNotificationsController(@Qualifier(value = "ownerNotificationsServiceImpl") OwnerService<OwnerNotificationsDto, OwnerNotificationsDto, OwnerNotificationsUpdateDto> ownerService) {
        this.ownerService = ownerService;
    }

    @PostMapping
    public ResponseEntity<ResponseDto> save(@Validated @RequestBody OwnerNotificationsDto saveDto) {
        return ownerService.save(saveDto)
                ? ResponseEntity.status(HttpStatus.CREATED).body(new ResponseDto("Owner notification is created"))
                : ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new ResponseDto("Exception thrown during saving an owner notification"));
    }

    @GetMapping
    public ResponseEntity<ResponseDto> fetch(@RequestParam Integer id) {
        return ResponseEntity.ok(new ResponseDto(ownerService.fetch(id), null));
    }

    @GetMapping("/all")
    public ResponseEntity<ResponseDto> fetchAll() {
        return ResponseEntity.ok(new ResponseDto(ownerService.fetchAll(), null));
    }

    @PutMapping
    public ResponseEntity<ResponseDto> update(@Validated @RequestBody OwnerNotificationsUpdateDto updateDto) {
        return ownerService.update(updateDto)
                ? ResponseEntity.ok(new ResponseDto("Owner notification is updated"))
                : ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new ResponseDto("Exception thrown during update an owner notification"));
    }

    @DeleteMapping
    public ResponseEntity<ResponseDto> delete(@RequestParam Integer id) {
        return ownerService.delete(id)
                ? ResponseEntity.ok(new ResponseDto("Owner notification is deleted"))
                : ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new ResponseDto("Exception thrown during delete an owner notification"));
    }
}
