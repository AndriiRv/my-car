package com.kent0k.cars.dto.cardetails;

import com.kent0k.cars.entity.CarDetails;
import com.kent0k.cars.enums.Fuel;
import com.kent0k.cars.enums.Transmission;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;
import java.util.Objects;

/**
 * Dto mapper class for {@link CarDetails} class.
 * <p>
 * NOTE: we should not use Lombok here because we use MapStruct library which require hardcoded getter and setter of fields.
 */

@Schema(
        name = "CarDetailsDto",
        description = "Schema about holding Car Details information"
)
public class CarDetailsDto {

    @NotBlank
    @Size(max = 20)
    @Schema(description = "Car title", example = "Skoda")
    private String title;

    @NotBlank
    @Size(max = 50)
    @Schema(description = "Car manufacturer title", example = "Skoda Auto")
    private String manufacturer;

    @NotNull
    @Past
    @Schema(description = "Car release date", example = "2022-06-12", pattern = "yyyy-MM-dd")
    private LocalDate releaseDate;

    @NotNull
    @Past
    @Schema(description = "Car purchase date by the customer", example = "2022-06-12", pattern = "yyyy-MM-dd")
    private LocalDate purchaseDate;

    @NotNull
    @Schema(description = "Car fuel type", example = "PETROL")
    private Fuel fuel;

    @NotNull
    @Schema(description = "Car transmission type", example = "MANUAL")
    private Transmission transmission;

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
        CarDetailsDto that = (CarDetailsDto) o;
        return Objects.equals(title, that.title) && Objects.equals(manufacturer, that.manufacturer) && Objects.equals(releaseDate, that.releaseDate) && Objects.equals(purchaseDate, that.purchaseDate) && fuel == that.fuel && transmission == that.transmission;
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, manufacturer, releaseDate, purchaseDate, fuel, transmission);
    }

    @Override
    public String toString() {
        return "CarDetailsDto{" +
                "title='" + title + '\'' +
                ", manufacturer='" + manufacturer + '\'' +
                ", releaseDate=" + releaseDate +
                ", purchaseDate=" + purchaseDate +
                ", fuel=" + fuel +
                ", transmission=" + transmission +
                '}';
    }
}
