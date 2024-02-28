package com.kent0k.servicepartners.controller;

import com.kent0k.servicepartners.dto.ResponseDto;
import com.kent0k.servicepartners.dto.servicepartner.ServicePartnerSaveDto;
import com.kent0k.servicepartners.dto.servicepartner.ServicePartnerWithIdDto;
import com.kent0k.servicepartners.service.ServicePartnerService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/api/service-partners", produces = {MediaType.APPLICATION_JSON_VALUE})
@AllArgsConstructor
public class ServicePartnerController {

    private final ServicePartnerService servicePartnerService;

    @PostMapping
    public ResponseEntity<ResponseDto> save(@Validated @RequestBody ServicePartnerSaveDto saveDto) {
        return servicePartnerService.save(saveDto)
                ? ResponseEntity.status(HttpStatus.CREATED).body(new ResponseDto("Service partner is created"))
                : ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new ResponseDto("Exception thrown during saving the service partner"));
    }

    @GetMapping
    public ResponseEntity<ResponseDto> fetch(@RequestParam Integer id) {
        return ResponseEntity.ok(new ResponseDto(servicePartnerService.fetch(id), null));
    }

    @GetMapping("/all")
    public ResponseEntity<ResponseDto> fetchAll() {
        return ResponseEntity.ok(new ResponseDto(servicePartnerService.fetchAll(), null));
    }

    @PutMapping
    public ResponseEntity<ResponseDto> update(@Validated @RequestBody ServicePartnerWithIdDto updateDto) {
        return servicePartnerService.update(updateDto)
                ? ResponseEntity.ok(new ResponseDto("Service partner is updated"))
                : ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new ResponseDto("Exception thrown during update the service partner"));
    }

    @DeleteMapping
    public ResponseEntity<ResponseDto> delete(@RequestParam Integer id) {
        return servicePartnerService.delete(id)
                ? ResponseEntity.ok(new ResponseDto("Service partner is deleted"))
                : ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new ResponseDto("Exception thrown during delete the service partner"));
    }
}
