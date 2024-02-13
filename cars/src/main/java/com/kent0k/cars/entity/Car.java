package com.kent0k.cars.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

import java.util.Objects;

@Entity
@Table(name = "car")
public class Car extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Integer id;

    @NotNull
    @Column
    private Integer ownerId;

    @NotNull
    @Column
    private Integer servicePartnersId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(Integer ownerId) {
        this.ownerId = ownerId;
    }

    public Integer getServicePartnersId() {
        return servicePartnersId;
    }

    public void setServicePartnersId(Integer servicePartnersId) {
        this.servicePartnersId = servicePartnersId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return Objects.equals(id, car.id) && Objects.equals(ownerId, car.ownerId) && Objects.equals(servicePartnersId, car.servicePartnersId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, ownerId, servicePartnersId);
    }

    @Override
    public String toString() {
        return "Car{" +
                "id=" + id +
                ", ownerId=" + ownerId +
                ", servicePartnersId=" + servicePartnersId +
                '}';
    }
}
