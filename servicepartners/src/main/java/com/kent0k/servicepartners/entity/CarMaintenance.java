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

    @Field(name = "ownerId", targetType = FieldType.INT32)
    private Integer ownerId;

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

    @Field(name = "isDone", targetType = FieldType.BOOLEAN)
    private Boolean isDone;

    @Field(name = "isSent", targetType = FieldType.BOOLEAN)
    private Boolean isSent;

    public Integer getCarId() {
        return carId;
    }

    public void setCarId(Integer carId) {
        this.carId = carId;
    }

    public Integer getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(Integer ownerId) {
        this.ownerId = ownerId;
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

    public Boolean getDone() {
        return isDone;
    }

    public void setDone(Boolean done) {
        isDone = done;
    }

    public Boolean getSent() {
        return isSent;
    }

    public void setSent(Boolean sent) {
        isSent = sent;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        CarMaintenance that = (CarMaintenance) o;
        return Objects.equals(carId, that.carId) && Objects.equals(ownerId, that.ownerId) && Objects.equals(servicePartner, that.servicePartner) && Objects.equals(date, that.date) && maintenanceWork == that.maintenanceWork && Objects.equals(isDone, that.isDone) && Objects.equals(isSent, that.isSent);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), carId, ownerId, servicePartner, date, maintenanceWork, isDone, isSent);
    }

    @Override
    public String toString() {
        return "CarMaintenance{" +
                "carId=" + carId +
                ", ownerId=" + ownerId +
                ", servicePartner=" + servicePartner +
                ", date=" + date +
                ", maintenanceWork=" + maintenanceWork +
                ", isDone=" + isDone +
                ", isSent=" + isSent +
                '}';
    }
}
