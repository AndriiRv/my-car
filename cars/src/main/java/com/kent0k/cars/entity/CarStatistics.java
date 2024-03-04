package com.kent0k.cars.entity;

import jakarta.annotation.Nullable;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.MapsId;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

import java.util.Objects;

@Entity
@Table(name = "car_statistics")
public class CarStatistics extends BaseEntity {

    @Id
    @NotNull
    @Column
    private Integer id;

    @NotNull
    @OneToOne(fetch = FetchType.LAZY, orphanRemoval = true)
    @MapsId
    @JoinColumn(name = "id", referencedColumnName = "id")
    private Car car;

    @Nullable
    @Min(0)
    @Column
    private Double mileage;

    @Nullable
    @Min(0)
    @Column
    private Double averageSpeed;

    @Nullable
    @Min(0)
    @Column
    private Double averageFuelConsumption;

    @Nullable
    @Min(0)
    @Column
    private Integer lastTimeAfterEngineStartSeconds;

    @Nullable
    @Min(0)
    @Column
    private Integer averageRideTimeSeconds;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    @Nullable
    public Double getMileage() {
        return mileage;
    }

    public void setMileage(@Nullable Double mileage) {
        this.mileage = mileage;
    }

    @Nullable
    public Double getAverageSpeed() {
        return averageSpeed;
    }

    public void setAverageSpeed(@Nullable Double averageSpeed) {
        this.averageSpeed = averageSpeed;
    }

    @Nullable
    public Double getAverageFuelConsumption() {
        return averageFuelConsumption;
    }

    public void setAverageFuelConsumption(@Nullable Double averageFuelConsumption) {
        this.averageFuelConsumption = averageFuelConsumption;
    }

    @Nullable
    public Integer getLastTimeAfterEngineStartSeconds() {
        return lastTimeAfterEngineStartSeconds;
    }

    public void setLastTimeAfterEngineStartSeconds(@Nullable Integer lastTimeAfterEngineStartSeconds) {
        this.lastTimeAfterEngineStartSeconds = lastTimeAfterEngineStartSeconds;
    }

    @Nullable
    public Integer getAverageRideTimeSeconds() {
        return averageRideTimeSeconds;
    }

    public void setAverageRideTimeSeconds(@Nullable Integer averageRideTimeSeconds) {
        this.averageRideTimeSeconds = averageRideTimeSeconds;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CarStatistics that = (CarStatistics) o;
        return Objects.equals(id, that.id) && Objects.equals(car, that.car) && Objects.equals(mileage, that.mileage) && Objects.equals(averageSpeed, that.averageSpeed) && Objects.equals(averageFuelConsumption, that.averageFuelConsumption) && Objects.equals(lastTimeAfterEngineStartSeconds, that.lastTimeAfterEngineStartSeconds) && Objects.equals(averageRideTimeSeconds, that.averageRideTimeSeconds);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, car, mileage, averageSpeed, averageFuelConsumption, lastTimeAfterEngineStartSeconds, averageRideTimeSeconds);
    }

    @Override
    public String toString() {
        return "CarStatistics{" +
                "id=" + id +
                ", car=" + car +
                ", mileage=" + mileage +
                ", averageSpeed=" + averageSpeed +
                ", averageFuelConsumption=" + averageFuelConsumption +
                ", lastTimeAfterEngineStartSeconds=" + lastTimeAfterEngineStartSeconds +
                ", averageRideTimeSeconds=" + averageRideTimeSeconds +
                '}';
    }
}
