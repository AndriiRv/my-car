package com.kent0k.cars.service.client;

import com.kent0k.cars.dto.external.OwnerDto;
import com.kent0k.cars.exception.ResourceNotFoundException;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "customers")
public interface OwnerFeignClient extends CommonFeign<ResponseEntity<OwnerDto>, ResourceNotFoundException> {

    @GetMapping(value = "/api/owners/raw", consumes = "application/json")
    ResponseEntity<OwnerDto> fetchRawBy(@RequestParam Integer id);

}
