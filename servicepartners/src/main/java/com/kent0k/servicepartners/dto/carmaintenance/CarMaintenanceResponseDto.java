package com.kent0k.servicepartners.dto.carmaintenance;

import com.kent0k.servicepartners.dto.external.CarResponseDto;
import com.kent0k.servicepartners.dto.servicepartner.ServicePartnerWithIdDto;
import com.kent0k.servicepartners.enums.MaintenanceWork;

import java.time.LocalDate;
import java.util.Objects;

public class CarMaintenanceResponseDto {

    private Integer id;

    private CarResponseDto carResponseDto;

    private ServicePartnerWithIdDto servicePartnerWithIdDto;

    private LocalDate date;

    private MaintenanceWork maintenanceWork;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public CarResponseDto getCarResponseDto() {
        return carResponseDto;
    }

    public void setCarResponseDto(CarResponseDto carResponseDto) {
        this.carResponseDto = carResponseDto;
    }

    public ServicePartnerWithIdDto getServicePartnerWithIdDto() {
        return servicePartnerWithIdDto;
    }

    public void setServicePartnerWithIdDto(ServicePartnerWithIdDto servicePartnerWithIdDto) {
        this.servicePartnerWithIdDto = servicePartnerWithIdDto;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public MaintenanceWork getMaintenanceWork() {
        return maintenanceWork;
    }

    public void setMaintenanceWork(MaintenanceWork maintenanceWork) {
        this.maintenanceWork = maintenanceWork;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CarMaintenanceResponseDto that = (CarMaintenanceResponseDto) o;
        return Objects.equals(id, that.id) && Objects.equals(carResponseDto, that.carResponseDto) && Objects.equals(servicePartnerWithIdDto, that.servicePartnerWithIdDto) && Objects.equals(date, that.date) && maintenanceWork == that.maintenanceWork;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, carResponseDto, servicePartnerWithIdDto, date, maintenanceWork);
    }

    @Override
    public String toString() {
        return "CarMaintenanceResponseDto{" +
                "id=" + id +
                ", carResponseDto=" + carResponseDto +
                ", servicePartnerWithIdDto=" + servicePartnerWithIdDto +
                ", date=" + date +
                ", maintenanceWork=" + maintenanceWork +
                '}';
    }
}
