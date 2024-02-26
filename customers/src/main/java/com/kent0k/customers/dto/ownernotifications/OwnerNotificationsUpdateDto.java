package com.kent0k.customers.dto.ownernotifications;

import jakarta.validation.constraints.NotNull;

import java.util.Objects;

public class OwnerNotificationsUpdateDto extends OwnerNotificationsDto {

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
        OwnerNotificationsUpdateDto that = (OwnerNotificationsUpdateDto) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "OwnerNotificationsUpdateDto{" +
                "id=" + id +
                '}';
    }
}
