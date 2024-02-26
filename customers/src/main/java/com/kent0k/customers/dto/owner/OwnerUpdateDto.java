package com.kent0k.customers.dto.owner;

import com.kent0k.customers.dto.ownercredentials.OwnerCredentialsUpdateDto;
import jakarta.validation.constraints.NotNull;

import java.util.Objects;

public class OwnerUpdateDto extends OwnerDto {

    @NotNull
    private Integer id;

    private OwnerCredentialsUpdateDto ownerCredentialsUpdateDto;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public OwnerCredentialsUpdateDto getOwnerCredentialsUpdateDto() {
        return ownerCredentialsUpdateDto;
    }

    public void setOwnerCredentialsUpdateDto(OwnerCredentialsUpdateDto ownerCredentialsUpdateDto) {
        this.ownerCredentialsUpdateDto = ownerCredentialsUpdateDto;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        OwnerUpdateDto that = (OwnerUpdateDto) o;
        return Objects.equals(id, that.id) && Objects.equals(ownerCredentialsUpdateDto, that.ownerCredentialsUpdateDto);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), id, ownerCredentialsUpdateDto);
    }

    @Override
    public String toString() {
        return "OwnerUpdateDto{" +
                "id=" + id +
                ", ownerCredentialsUpdateDto=" + ownerCredentialsUpdateDto +
                '}';
    }
}
