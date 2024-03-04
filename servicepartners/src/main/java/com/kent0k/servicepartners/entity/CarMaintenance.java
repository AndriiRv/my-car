package com.kent0k.servicepartners.entity;

import com.kent0k.servicepartners.enums.MaintenanceWork;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.data.mongodb.core.mapping.FieldType;

import java.time.LocalDate;
import java.util.Objects;

@Document("maintenances")
public class CarMaintenance extends BaseEntity {

    @Field(name = "carId", targetType = FieldType.INT32)
    private Integer carId; // should to be replaced with Car object which will come from 'cars' microservice

    /**
     * Link to the {@link ServicePartner}.
     * <p>
     * NOTE: Should be Many-To-One relation with ServicePartner entity.
     */
    @DBRef
    private ServicePartner servicePartner;

    /**
     * Car maintenance date.
     */
    @Field(name = "date", targetType = FieldType.DATE_TIME)
    private LocalDate date;

    /**
     * Type of car maintenance.
     */
    @Field(name = "maintenanceWork", targetType = FieldType.STRING)
    private MaintenanceWork maintenanceWork;

    public Integer getCarId() {
        return carId;
    }

    public void setCarId(Integer carId) {
        this.carId = carId;
    }

    public ServicePartner getServicePartner() {
        return servicePartner;
    }

    public void setServicePartner(ServicePartner servicePartner) {
        this.servicePartner = servicePartner;
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
        if (!super.equals(o)) return false;
        CarMaintenance that = (CarMaintenance) o;
        return Objects.equals(carId, that.carId) && Objects.equals(servicePartner, that.servicePartner) && Objects.equals(date, that.date) && maintenanceWork == that.maintenanceWork;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), carId, servicePartner, date, maintenanceWork);
    }

    @Override
    public String toString() {
        return "CarMaintenance{" +
                "carId=" + carId +
                ", servicePartner=" + servicePartner +
                ", date=" + date +
                ", maintenanceWork=" + maintenanceWork +
                '}';
    }
}
