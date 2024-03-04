package com.kent0k.cars.dto.carstatistics;

import com.kent0k.cars.entity.CarStatistics;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;

import java.util.Objects;

/**
 * Dto mapper class for {@link CarStatistics} class.
 * <p>
 * NOTE: we should not use Lombok here because we use MapStruct library which require hardcoded getter and setter of fields.
 */

@Schema(
        name = "CarStatisticsWithIdDto",
        description = "Schema about holding CarStatistics information to update and to fetch using by car statistics id"
)
public class CarStatisticsWithIdDto extends CarStatisticsDto {

    @NotNull
    @Schema(description = "Car statistics identifier as integer value", example = "123")
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
        if (!(o instanceof CarStatisticsWithIdDto that)) return false;
        if (!super.equals(o)) return false;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), id);
    }

    @Override
    public String toString() {
        return "CarStatisticsWithIdDto{" +
                "id=" + id +
                '}';
    }
}
