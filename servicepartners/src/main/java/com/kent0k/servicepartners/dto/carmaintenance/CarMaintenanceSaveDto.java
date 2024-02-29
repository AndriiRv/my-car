package com.kent0k.servicepartners.dto.carmaintenance;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.validation.constraints.NotNull;

import java.util.Objects;

public class CarMaintenanceSaveDto extends CarMaintenanceDto {

    @JsonIgnore
    private Integer id;

    @NotNull
    private Integer carId;

    @NotNull
    private Integer servicePartnerId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCarId() {
        return carId;
    }

    public void setCarId(Integer carId) {
        this.carId = carId;
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
        return Objects.equals(id, that.id) && Objects.equals(carId, that.carId) && Objects.equals(servicePartnerId, that.servicePartnerId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), id, carId, servicePartnerId);
    }

    @Override
    public String toString() {
        return "CarMaintenanceSaveDto{" +
                "id=" + id +
                ", carId=" + carId +
                ", servicePartnerId=" + servicePartnerId +
                '}';
    }
}
