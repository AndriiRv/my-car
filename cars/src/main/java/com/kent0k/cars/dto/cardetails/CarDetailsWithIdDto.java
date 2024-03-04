package com.kent0k.cars.dto.cardetails;

import com.kent0k.cars.entity.CarDetails;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;

import java.util.Objects;

/**
 * Dto mapper class for {@link CarDetails} class.
 * <p>
 * NOTE: we should not use Lombok here because we use MapStruct library which require hardcoded getter and setter of fields.
 */

@Schema(
        name = "CarDetailsWithIdDto",
        description = "Schema about holding CarDetails information to update and to fetch using by car details id"
)
public class CarDetailsWithIdDto extends CarDetailsDto {

    @NotNull
    @Schema(description = "Car details identifier as integer value", example = "123")
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
        if (!(o instanceof CarDetailsWithIdDto that)) return false;
        if (!super.equals(o)) return false;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), id);
    }

    @Override
    public String toString() {
        return "CarDetailsWithIdDto{" +
                "id=" + id +
                '}';
    }
}
