package com.kent0k.cars.dto.cardetails;

import jakarta.validation.constraints.NotNull;

import java.util.Objects;

public class CarDetailsWithIdDto extends CarDetailsDto {

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
