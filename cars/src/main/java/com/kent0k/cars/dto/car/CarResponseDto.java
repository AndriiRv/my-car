package com.kent0k.cars.dto.car;

import com.kent0k.cars.dto.external.OwnerDto;
import com.kent0k.cars.dto.external.ServicePartnerDto;
import com.kent0k.cars.entity.Car;
import jakarta.validation.constraints.NotNull;

import java.util.Objects;

/**
 * Dto mapper class for {@link Car} class.
 * <p>
 * NOTE: we should not use Lombok here because we use MapStruct library which require hardcoded getter and setter of fields.
 */
public class CarResponseDto {

    @NotNull
    private OwnerDto ownerDto;

    @NotNull
    private ServicePartnerDto servicePartnerDto;

    public OwnerDto getOwnerDto() {
        return ownerDto;
    }

    public void setOwnerDto(OwnerDto ownerDto) {
        this.ownerDto = ownerDto;
    }

    public ServicePartnerDto getServicePartnerDto() {
        return servicePartnerDto;
    }

    public void setServicePartnerDto(ServicePartnerDto servicePartnerDto) {
        this.servicePartnerDto = servicePartnerDto;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CarResponseDto that = (CarResponseDto) o;
        return Objects.equals(ownerDto, that.ownerDto) && Objects.equals(servicePartnerDto, that.servicePartnerDto);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ownerDto, servicePartnerDto);
    }

    @Override
    public String toString() {
        return "CarResponseDto{" +
                "ownerDto=" + ownerDto +
                ", servicePartnerDto=" + servicePartnerDto +
                '}';
    }
}
