package com.kent0k.servicepartners.dto.worker;

import jakarta.validation.constraints.NotNull;

import java.util.Objects;

public class WorkerWithIdDto extends WorkerDto {

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
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        WorkerWithIdDto that = (WorkerWithIdDto) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), id);
    }

    @Override
    public String toString() {
        return "WorkerWithIdDto{" +
                "id=" + id +
                '}';
    }
}
