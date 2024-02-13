package com.kent0k.cars.entity;

import com.kent0k.cars.enums.Fuel;
import com.kent0k.cars.enums.Transmission;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.MapsId;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;
import org.hibernate.annotations.JdbcType;
import org.hibernate.dialect.PostgreSQLEnumJdbcType;

import java.time.LocalDate;
import java.util.Objects;

@Entity
@Table(name = "car_details")
public class CarDetails extends BaseEntity {

    @Id
    @NotNull
    @Column
    private Integer id;

    @NotNull
    @OneToOne(fetch = FetchType.LAZY, orphanRemoval = true)
    @MapsId
    @JoinColumn(name = "id", referencedColumnName = "id")
    private Car car;

    @NotBlank
    @Size(max = 20)
    @Column
    private String title;

    @NotBlank
    @Size(max = 50)
    @Column
    private String manufacturer;

    @NotNull
    @Past
    @Column
    private LocalDate releaseDate;

    @NotNull
    @Past
    @Column
    private LocalDate purchaseDate;

    @NotNull
    @Column
    @Enumerated(EnumType.STRING)
    @JdbcType(PostgreSQLEnumJdbcType.class)
    private Fuel fuel;

    @NotNull
    @Column
    @Enumerated(EnumType.STRING)
    @JdbcType(PostgreSQLEnumJdbcType.class)
    private Transmission transmission;

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

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public LocalDate getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(LocalDate releaseDate) {
        this.releaseDate = releaseDate;
    }

    public LocalDate getPurchaseDate() {
        return purchaseDate;
    }

    public void setPurchaseDate(LocalDate purchaseDate) {
        this.purchaseDate = purchaseDate;
    }

    public Fuel getFuel() {
        return fuel;
    }

    public void setFuel(Fuel fuel) {
        this.fuel = fuel;
    }

    public Transmission getTransmission() {
        return transmission;
    }

    public void setTransmission(Transmission transmission) {
        this.transmission = transmission;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CarDetails that = (CarDetails) o;
        return Objects.equals(id, that.id) && Objects.equals(car, that.car) && Objects.equals(title, that.title) && Objects.equals(manufacturer, that.manufacturer) && Objects.equals(releaseDate, that.releaseDate) && Objects.equals(purchaseDate, that.purchaseDate) && fuel == that.fuel && transmission == that.transmission;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, car, title, manufacturer, releaseDate, purchaseDate, fuel, transmission);
    }

    @Override
    public String toString() {
        return "CarDetails{" +
                "id=" + id +
                ", car=" + car +
                ", title='" + title + '\'' +
                ", manufacturer='" + manufacturer + '\'' +
                ", releaseDate=" + releaseDate +
                ", purchaseDate=" + purchaseDate +
                ", fuel=" + fuel +
                ", transmission=" + transmission +
                '}';
    }
}
