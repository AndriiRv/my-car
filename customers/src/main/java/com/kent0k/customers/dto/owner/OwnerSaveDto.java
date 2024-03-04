package com.kent0k.customers.dto.owner;

import com.kent0k.customers.dto.ownercredentials.OwnerCredentialsSaveDto;
import io.swagger.v3.oas.annotations.media.Schema;

import java.util.Objects;

@Schema(
        name = "OwnerSaveDto",
        description = "Schema about holding Owner and OwnerCredentials information to save"
)
public class OwnerSaveDto extends OwnerDto {

    @Schema(description = "Owner credentials data to save")
    private OwnerCredentialsSaveDto ownerCredentialsSaveDto;

    public OwnerCredentialsSaveDto getOwnerCredentialsSaveDto() {
        return ownerCredentialsSaveDto;
    }

    public void setOwnerCredentialsSaveDto(OwnerCredentialsSaveDto ownerCredentialsSaveDto) {
        this.ownerCredentialsSaveDto = ownerCredentialsSaveDto;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        OwnerSaveDto that = (OwnerSaveDto) o;
        return Objects.equals(ownerCredentialsSaveDto, that.ownerCredentialsSaveDto);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), ownerCredentialsSaveDto);
    }

    @Override
    public String toString() {
        return "OwnerSaveDto{" +
                "ownerCredentialsSaveDto=" + ownerCredentialsSaveDto +
                '}';
    }
}
