package com.kent0k.customers.dto.ownercredentials;

import com.kent0k.customers.enums.DbBoolean;
import jakarta.validation.constraints.NotNull;

import java.util.Objects;

public class OwnerCredentialsUpdateDto extends OwnerCredentialsDto {

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
        OwnerCredentialsUpdateDto that = (OwnerCredentialsUpdateDto) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), id);
    }

    @Override
    public String toString() {
        return "OwnerCredentialsUpdateDto{" +
                "id=" + id +
                '}';
    }
}
