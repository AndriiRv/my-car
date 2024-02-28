package com.kent0k.servicepartners.dto.carmaintenance;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.validation.constraints.NotNull;

import java.util.Objects;

public class CarMaintenanceSaveDto extends CarMaintenanceDto {

    @JsonIgnore
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
        CarMaintenanceSaveDto that = (CarMaintenanceSaveDto) o;
        return Objects.equals(id, that.id) && Objects.equals(servicePartnerId, that.servicePartnerId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), id, servicePartnerId);
    }

    @Override
    public String toString() {
        return "CarMaintenanceSaveDto{" +
                "id=" + id +
                ", servicePartnerId=" + servicePartnerId +
                '}';
    }
}
