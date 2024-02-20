package com.kent0k.cars.controller;

import com.kent0k.cars.dto.car.CarSaveDto;
import com.kent0k.cars.dto.car.CarUpdateDto;
import com.kent0k.cars.dto.ResponseDto;
import com.kent0k.cars.service.CarService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/api", produces = {MediaType.APPLICATION_JSON_VALUE})
@AllArgsConstructor
public class CarController {

    private final CarService carService;

    @PostMapping
    public ResponseEntity<ResponseDto> save(@Validated @RequestBody CarSaveDto carSaveDto) {
        return carService.save(carSaveDto)
                ? ResponseEntity.status(HttpStatus.CREATED).body(new ResponseDto("Car is created"))
                : ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new ResponseDto("Exception thrown during saving a car"));
    }

    @GetMapping
    public ResponseEntity<ResponseDto> fetch(@RequestParam Integer id) {
        return ResponseEntity.ok(new ResponseDto(carService.fetch(id), null));
    }

    @GetMapping("/all")
    public ResponseEntity<ResponseDto> fetchAll() {
        return ResponseEntity.ok(new ResponseDto(carService.fetchAll(), null));
    }

    @PutMapping
    public ResponseEntity<ResponseDto> update(@Validated @RequestBody CarUpdateDto carUpdateDto) {
        return carService.update(carUpdateDto)
                ? ResponseEntity.ok(new ResponseDto("Car is updated"))
                : ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new ResponseDto("Exception thrown during update the car"));
    }

    @DeleteMapping
    public ResponseEntity<ResponseDto> delete(@RequestParam Integer id) {
        return carService.delete(id)
                ? ResponseEntity.ok(new ResponseDto("Car is deleted"))
                : ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new ResponseDto("Exception thrown during delete the car"));
    }
}
