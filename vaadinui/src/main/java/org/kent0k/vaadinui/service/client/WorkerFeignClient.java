package org.kent0k.vaadinui.service.client;

import org.kent0k.vaadinui.dto.external.WorkerDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(name = "servicepartners")
public interface WorkerFeignClient {

    @GetMapping(value = "/api/workers/raw")
    ResponseEntity<WorkerDto> fetchBy(@RequestParam Integer id);

    @GetMapping("/api/workers/all/raw")
    ResponseEntity<List<WorkerDto>> fetchAll();

}
