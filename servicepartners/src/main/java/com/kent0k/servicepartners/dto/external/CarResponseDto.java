package com.kent0k.servicepartners.dto.external;

import jakarta.validation.constraints.NotNull;

import java.util.Objects;

public class CarResponseDto {

    private Integer id;

    @NotNull
    private OwnerDto ownerDto;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public OwnerDto getOwnerDto() {
        return ownerDto;
    }

    public void setOwnerDto(OwnerDto ownerDto) {
        this.ownerDto = ownerDto;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CarResponseDto that = (CarResponseDto) o;
        return Objects.equals(id, that.id) && Objects.equals(ownerDto, that.ownerDto);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, ownerDto);
    }

    @Override
    public String toString() {
        return "CarResponseDto{" +
                "id=" + id +
                ", ownerDto=" + ownerDto +
                '}';
    }
}