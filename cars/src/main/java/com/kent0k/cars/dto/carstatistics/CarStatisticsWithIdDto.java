package com.kent0k.cars.dto.carstatistics;

import jakarta.validation.constraints.NotNull;

import java.util.Objects;

public class CarStatisticsWithIdDto extends CarStatisticsDto {

    @NotNull
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