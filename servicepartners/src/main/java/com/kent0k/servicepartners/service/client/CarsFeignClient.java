package com.kent0k.servicepartners.service.client;

import com.kent0k.servicepartners.dto.external.CarResponseDto;
import com.kent0k.servicepartners.exception.ResourceNotFoundException;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "cars")
public interface CarsFeignClient extends CommonFeign<ResponseEntity<CarResponseDto>, ResourceNotFoundException> {

    @GetMapping(value = "/api/cars/raw", consumes = "application/json")
    ResponseEntity<CarResponseDto> fetchRawBy(@RequestParam Integer id);

}
