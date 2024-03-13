package com.kent0k.cars.dto.graphql;

import java.util.Objects;

public class CarGraphQlDto {

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
        CarGraphQlDto that = (CarGraphQlDto) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "CarGraphQlDto{" +
                "id=" + id +
                '}';
    }
}
