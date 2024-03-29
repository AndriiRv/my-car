package com.kent0k.cars.dto.car;

import com.kent0k.cars.entity.Car;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;

import java.util.Objects;

/**
 * Dto mapper class for {@link Car} class.
 * <p>
 * NOTE: we should not use Lombok here because we use MapStruct library which require hardcoded getter and setter of fields.
 */

@Schema(
        name = "CarDto",
        description = "Schema about holding Car information"
)
public class CarDto {

    @NotNull
    @Schema(description = "Owner identifier as integer value", example = "123")
    private Integer ownerId;

    @NotNull
    @Schema(description = "Service partner identifier as integer value", example = "123")
    private Integer servicePartnersId;

    public Integer getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(Integer ownerId) {
        this.ownerId = ownerId;
    }

    public Integer getServicePartnersId() {
        return servicePartnersId;
    }

    public void setServicePartnersId(Integer servicePartnersId) {
        this.servicePartnersId = servicePartnersId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CarDto carDto = (CarDto) o;
        return Objects.equals(ownerId, carDto.ownerId) && Objects.equals(servicePartnersId, carDto.servicePartnersId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ownerId, servicePartnersId);
    }

    @Override
    public String toString() {
        return "CarDto{" +
                "ownerId=" + ownerId +
                ", servicePartnersId=" + servicePartnersId +
                '}';
    }
}
