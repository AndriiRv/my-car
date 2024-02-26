package com.kent0k.customers.controller;

import com.kent0k.customers.dto.ResponseDto;
import com.kent0k.customers.dto.owner.OwnerDto;
import com.kent0k.customers.dto.owner.OwnerSaveDto;
import com.kent0k.customers.dto.owner.OwnerUpdateDto;
import com.kent0k.customers.service.OwnerService;
import org.springframework.beans.factory.annotation.Qualifier;
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
public class OwnerController {

    private final OwnerService<OwnerDto, OwnerSaveDto, OwnerUpdateDto> ownerService;

    public OwnerController(@Qualifier(value = "ownerServiceImpl") OwnerService<OwnerDto, OwnerSaveDto, OwnerUpdateDto> ownerService) {
        this.ownerService = ownerService;
    }

    @PostMapping
    public ResponseEntity<ResponseDto> save(@Validated @RequestBody OwnerSaveDto ownerSaveDto) {
        return ownerService.save(ownerSaveDto)
                ? ResponseEntity.status(HttpStatus.CREATED).body(new ResponseDto("Owner is created"))
                : ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new ResponseDto("Exception thrown during saving an owner"));
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
    public ResponseEntity<ResponseDto> update(@Validated @RequestBody OwnerUpdateDto ownerUpdateDto) {
        return ownerService.update(ownerUpdateDto)
                ? ResponseEntity.ok(new ResponseDto("Owner is updated"))
                : ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new ResponseDto("Exception thrown during update an owner"));
    }

    @DeleteMapping
    public ResponseEntity<ResponseDto> delete(@RequestParam Integer id) {
        return ownerService.delete(id)
                ? ResponseEntity.ok(new ResponseDto("Owner is deleted"))
                : ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new ResponseDto("Exception thrown during delete an owner"));
    }
}
