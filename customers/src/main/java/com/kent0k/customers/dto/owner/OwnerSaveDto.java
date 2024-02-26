package com.kent0k.customers.dto.owner;

import com.kent0k.customers.dto.ownercredentials.OwnerCredentialsSaveDto;

import java.util.Objects;

public class OwnerSaveDto extends OwnerDto {

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
