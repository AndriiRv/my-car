package com.kent0k.servicepartners.dto.carmaintenance;

import com.kent0k.servicepartners.enums.MaintenanceWork;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;

import java.time.LocalDate;
import java.util.Objects;

@Schema(
        name = "OwnerDto",
        description = "Schema about holding Owner information"
)
public class CarMaintenanceDto {

    @NotNull
    @PastOrPresent
    @Schema(description = "Car maintenance date", example = "2023-12-12")
    private LocalDate date;

    @NotNull
    @Schema(description = "Type of car maintenance", example = "TECHNICAL_SERVICE")
    private MaintenanceWork maintenanceWork;

    @Schema(description = "Whether car maintenance is done.", example = "false")
    private Boolean isDone;

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

    public Boolean getDone() {
        return isDone;
    }

    public void setDone(Boolean done) {
        isDone = done;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CarMaintenanceDto that = (CarMaintenanceDto) o;
        return Objects.equals(date, that.date) && maintenanceWork == that.maintenanceWork && Objects.equals(isDone, that.isDone);
    }

    @Override
    public int hashCode() {
        return Objects.hash(date, maintenanceWork, isDone);
    }

    @Override
    public String toString() {
        return "CarMaintenanceDto{" +
                "date=" + date +
                ", maintenanceWork=" + maintenanceWork +
                ", isDone=" + isDone +
                '}';
    }
}
