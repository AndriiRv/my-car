package com.kent0k.customers.dto.ownernotifications;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;

import java.util.Objects;

@Schema(
        name = "OwnerNotificationsWithIdDto",
        description = "Schema about holding OwnerNotifications information to update"
)
public class OwnerNotificationsWithIdDto extends OwnerNotificationsDto {

    @NotNull
    @Schema(description = "OwnerNotifications identifier as integer value", example = "123")
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
        OwnerNotificationsWithIdDto that = (OwnerNotificationsWithIdDto) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "OwnerNotificationsWithIdDto{" +
                "id=" + id +
                '}';
    }
}
