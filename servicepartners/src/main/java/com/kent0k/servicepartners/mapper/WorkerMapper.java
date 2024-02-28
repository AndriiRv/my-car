package com.kent0k.servicepartners.mapper;

import com.kent0k.servicepartners.dto.worker.WorkerSaveDto;
import com.kent0k.servicepartners.dto.worker.WorkerWithIdDto;
import com.kent0k.servicepartners.entity.Worker;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface WorkerMapper {

    Worker mapToWorker(WorkerSaveDto workerSaveDto);

    Worker mapToWorker(WorkerWithIdDto workerWithIdDto);

    WorkerWithIdDto mapToWorkerDto(Worker worker);

    List<WorkerWithIdDto> mapToWorkerDto(List<Worker> workers);
}
