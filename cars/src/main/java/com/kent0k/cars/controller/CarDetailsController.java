package com.kent0k.cars.controller;

import com.kent0k.cars.dto.ResponseDto;
import com.kent0k.cars.dto.cardetails.CarDetailsWithIdDto;
import com.kent0k.cars.service.CarDetailsService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/api/car-details", produces = {MediaType.APPLICATION_JSON_VALUE})
@AllArgsConstructor
public class CarDetailsController {

    private final CarDetailsService carDetailsService;

    @GetMapping
    public ResponseEntity<ResponseDto> fetch(@RequestParam Integer id) {
        return ResponseEntity.ok(new ResponseDto(carDetailsService.fetch(id), null));
    }

    @GetMapping("/all")
    public ResponseEntity<ResponseDto> fetchAll() {
        return ResponseEntity.ok(new ResponseDto(carDetailsService.fetchAll(), null));
    }

    @PutMapping
    public ResponseEntity<ResponseDto> update(@Validated @RequestBody CarDetailsWithIdDto carDetailsDto) {
        return carDetailsService.update(carDetailsDto)
                ? ResponseEntity.ok(new ResponseDto("Car details is updated"))
                : ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new ResponseDto("Exception thrown during update the car details"));
    }

    @DeleteMapping
    public ResponseEntity<ResponseDto> delete(@RequestParam Integer id) {
        return carDetailsService.delete(id)
                ? ResponseEntity.ok(new ResponseDto("Car details is deleted"))
                : ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new ResponseDto("Exception thrown during delete the car details"));
    }
}
