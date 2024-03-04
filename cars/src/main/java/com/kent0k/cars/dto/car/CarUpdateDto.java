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
        name = "CarUpdateDto",
        description = "Schema about holding Car information to update"
)
public class CarUpdateDto extends CarDto {

    @NotNull
    @Schema(description = "Car identifier as integer value", example = "123")
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
        if (!super.equals(o)) return false;
        CarUpdateDto that = (CarUpdateDto) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), id);
    }

    @Override
    public String toString() {
        return "CarUpdateDto{" +
                "id=" + id +
                '}';
    }
}
