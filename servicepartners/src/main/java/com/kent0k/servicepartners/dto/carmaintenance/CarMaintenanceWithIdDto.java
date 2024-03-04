package com.kent0k.servicepartners.dto.carmaintenance;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;

import java.util.Objects;

@Schema(
        name = "CarMaintenanceWithIdDto",
        description = "Schema about holding CarMaintenance"
)
public class CarMaintenanceWithIdDto extends CarMaintenanceDto {

    @NotNull
    @Schema(description = "Car maintenance identifier as integer value", example = "123")
    private Integer id;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CarMaintenanceWithIdDto that = (CarMaintenanceWithIdDto) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "CarMaintenanceWithIdDto{" +
                "id=" + id +
                '}';
    }
}
