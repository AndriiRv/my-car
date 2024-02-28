package com.kent0k.servicepartners.service;

import com.kent0k.servicepartners.dto.worker.WorkerSaveDto;
import com.kent0k.servicepartners.dto.worker.WorkerWithIdDto;

import java.util.List;

public interface WorkerService {

    boolean save(WorkerSaveDto saveDto);

    WorkerWithIdDto fetch(Integer id);

    List<WorkerWithIdDto> fetchAll();

    boolean update(WorkerWithIdDto updateDto);

    boolean delete(Integer id);
}
