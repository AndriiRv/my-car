package com.kent0k.cars.controller;

import com.kent0k.cars.dto.ResponseDto;
import com.kent0k.cars.dto.carstatistics.CarStatisticsWithIdDto;
import com.kent0k.cars.service.CarStatisticsService;
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
@RequestMapping(path = "/api/car-statistics", produces = {MediaType.APPLICATION_JSON_VALUE})
@AllArgsConstructor
public class CarStatisticsController {

    private final CarStatisticsService carStatisticsService;

    @GetMapping
    public ResponseEntity<ResponseDto> fetch(@RequestParam Integer id) {
        return ResponseEntity.ok(new ResponseDto(carStatisticsService.fetch(id), null));
    }

    @GetMapping("/all")
    public ResponseEntity<ResponseDto> fetchAll() {
        return ResponseEntity.ok(new ResponseDto(carStatisticsService.fetchAll(), null));
    }

    @PutMapping
    public ResponseEntity<ResponseDto> update(@Validated @RequestBody CarStatisticsWithIdDto carUpdateDto) {
        return carStatisticsService.update(carUpdateDto)
                ? ResponseEntity.ok(new ResponseDto("Car statistics is updated"))
                : ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new ResponseDto("Exception thrown during update the car statistics"));
    }

    @DeleteMapping
    public ResponseEntity<ResponseDto> delete(@RequestParam Integer id) {
        return carStatisticsService.delete(id)
                ? ResponseEntity.ok(new ResponseDto("Car statistics is deleted"))
                : ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new ResponseDto("Exception thrown during delete the car statistics"));
    }
}
