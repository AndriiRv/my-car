package com.kent0k.cars.service.client;

import com.kent0k.cars.dto.external.ServicePartnerDto;
import com.kent0k.cars.exception.ResourceNotFoundException;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "servicepartners")
public interface ServicePartnersFeignClient extends CommonFeign<ResponseEntity<ServicePartnerDto>, ResourceNotFoundException> {

    @GetMapping(value = "/api/service-partners/raw", consumes = "application/json")
    ResponseEntity<ServicePartnerDto> fetchRawBy(@RequestParam Integer id);

}
