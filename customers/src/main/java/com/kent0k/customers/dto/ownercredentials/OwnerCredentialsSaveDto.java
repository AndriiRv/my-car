package com.kent0k.customers.dto.ownercredentials;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.kent0k.customers.enums.DbBoolean;
import io.swagger.v3.oas.annotations.media.Schema;

import java.util.Objects;

@Schema(
        name = "OwnerCredentialsSaveDto",
        description = "Schema about holding OwnerCredentials information to save"
)
public class OwnerCredentialsSaveDto extends OwnerCredentialsDto {

    @JsonIgnore
    @Schema(description = "Owners account status. Should be as Y")
    private final DbBoolean isActive = DbBoolean.Y;

    public DbBoolean getIsActive() {
        return isActive;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OwnerCredentialsSaveDto that = (OwnerCredentialsSaveDto) o;
        return isActive == that.isActive;
    }

    @Override
    public int hashCode() {
        return Objects.hash(isActive);
    }

    @Override
    public String toString() {
        return "OwnerCredentialsSaveDto{" +
                "isActive=" + isActive +
                '}';
    }
}
