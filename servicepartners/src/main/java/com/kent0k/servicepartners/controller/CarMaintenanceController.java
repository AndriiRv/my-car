package com.kent0k.servicepartners.controller;

import com.kent0k.servicepartners.dto.ResponseDto;
import com.kent0k.servicepartners.dto.carmaintenance.CarMaintenanceSaveDto;
import com.kent0k.servicepartners.dto.carmaintenance.CarMaintenanceWithIdDto;
import com.kent0k.servicepartners.service.CarMaintenanceService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/api/cars-maintenance", produces = {MediaType.APPLICATION_JSON_VALUE})
@AllArgsConstructor
public class CarMaintenanceController {

    private final CarMaintenanceService carMaintenanceService;

    @PostMapping
    public ResponseEntity<ResponseDto> save(CarMaintenanceSaveDto saveDto) {
        return carMaintenanceService.save(saveDto)
                ? ResponseEntity.status(HttpStatus.CREATED).body(new ResponseDto("Car maintenance is created"))
                : ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new ResponseDto("Exception thrown during saving the car maintenance"));
    }

    @GetMapping
    public ResponseEntity<ResponseDto> fetch(Integer id) {
        return ResponseEntity.ok(new ResponseDto(carMaintenanceService.fetch(id), null));
    }

    @GetMapping("/all")
    public ResponseEntity<ResponseDto> fetchAll() {
        return ResponseEntity.ok(new ResponseDto(carMaintenanceService.fetchAll(), null));
    }

    @PutMapping
    public ResponseEntity<ResponseDto> update(CarMaintenanceWithIdDto updateDto) {
        return carMaintenanceService.update(updateDto)
                ? ResponseEntity.ok(new ResponseDto("Car maintenance is updated"))
                : ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new ResponseDto("Exception thrown during update the car maintenance"));
    }

    @DeleteMapping
    public ResponseEntity<ResponseDto> delete(Integer id) {
        return carMaintenanceService.delete(id)
                ? ResponseEntity.ok(new ResponseDto("Car maintenance is deleted"))
                : ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new ResponseDto("Exception thrown during delete the car maintenance"));
    }
}
