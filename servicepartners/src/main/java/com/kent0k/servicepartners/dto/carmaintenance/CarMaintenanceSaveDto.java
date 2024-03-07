package com.kent0k.servicepartners.dto.carmaintenance;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;

import java.util.Objects;

@Schema(
        name = "CarMaintenanceSaveDto",
        description = "Schema about holding CarMaintenance information to save"
)
public class CarMaintenanceSaveDto extends CarMaintenanceDto {

    /**
     * This id extra field should be used to set id manually on the backend side.
     */
    @JsonIgnore
    @Schema(description = "Car maintenance identifier as integer value", example = "123")
    private Integer id;

    @NotNull
    @Schema(description = "Car id which connect CarMaintenance with Car", example = "123")
    private Integer carId;

    @NotNull
    @Schema(description = "Owner id which connect CarMaintenance with Owner", example = "123")
    private Integer ownerId;

    @NotNull
    @Schema(description = "Service partner id which connect CarMaintenance with ServicePartner", example = "123")
    private Integer servicePartnerId;

    @JsonIgnore
    @Schema(description = "Whether car maintenance is done. Should be as FALSE during create new CarMaintenance", example = "false")
    private final Boolean isDone = false;

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

    public Integer getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(Integer ownerId) {
        this.ownerId = ownerId;
    }

    public Integer getServicePartnerId() {
        return servicePartnerId;
    }

    public void setServicePartnerId(Integer servicePartnerId) {
        this.servicePartnerId = servicePartnerId;
    }

    @Override
    public Boolean getDone() {
        return isDone;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        CarMaintenanceSaveDto that = (CarMaintenanceSaveDto) o;
        return Objects.equals(id, that.id) && Objects.equals(carId, that.carId) && Objects.equals(ownerId, that.ownerId) && Objects.equals(servicePartnerId, that.servicePartnerId) && Objects.equals(isDone, that.isDone);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), id, carId, ownerId, servicePartnerId, isDone);
    }

    @Override
    public String toString() {
        return "CarMaintenanceSaveDto{" +
                "id=" + id +
                ", carId=" + carId +
                ", ownerId=" + ownerId +
                ", servicePartnerId=" + servicePartnerId +
                ", isDone=" + isDone +
                '}';
    }
}
