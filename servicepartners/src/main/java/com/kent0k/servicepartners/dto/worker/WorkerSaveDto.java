package com.kent0k.servicepartners.dto.worker;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;

import java.util.Objects;

@Schema(
        name = "WorkerSaveDto",
        description = "Schema about holding Worker information to save"
)
public class WorkerSaveDto extends WorkerDto {

    /**
     * This id extra field should be used to set id manually on the backend side.
     */
    @JsonIgnore
    @Schema(description = "Worker identifier as integer value", example = "123")
    private Integer id;

    @NotNull
    private Integer servicePartnerId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getServicePartnerId() {
        return servicePartnerId;
    }

    public void setServicePartnerId(Integer servicePartnerId) {
        this.servicePartnerId = servicePartnerId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        WorkerSaveDto that = (WorkerSaveDto) o;
        return Objects.equals(id, that.id) && Objects.equals(servicePartnerId, that.servicePartnerId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), id, servicePartnerId);
    }

    @Override
    public String toString() {
        return "WorkerSaveDto{" +
                "id=" + id +
                ", servicePartnerId=" + servicePartnerId +
                '}';
    }
}
