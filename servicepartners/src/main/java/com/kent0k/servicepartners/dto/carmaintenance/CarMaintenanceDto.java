package com.kent0k.servicepartners.dto.carmaintenance;

import com.kent0k.servicepartners.enums.MaintenanceWork;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;

import java.time.LocalDate;
import java.util.Objects;

public class CarMaintenanceDto {

    @NotNull
    @PastOrPresent
    private LocalDate date;

    @NotNull
    private MaintenanceWork maintenanceWork;

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
        CarMaintenanceDto that = (CarMaintenanceDto) o;
        return Objects.equals(date, that.date) && maintenanceWork == that.maintenanceWork;
    }

    @Override
    public int hashCode() {
        return Objects.hash(date, maintenanceWork);
    }

    @Override
    public String toString() {
        return "CarMaintenanceDto{" +
                "date=" + date +
                ", maintenanceWork=" + maintenanceWork +
                '}';
    }
}
