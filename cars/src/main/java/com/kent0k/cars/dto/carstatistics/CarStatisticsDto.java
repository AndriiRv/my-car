package com.kent0k.cars.dto.carstatistics;

import com.kent0k.cars.entity.CarStatistics;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.annotation.Nullable;
import jakarta.validation.constraints.Min;

import java.util.Objects;

/**
 * Dto mapper class for {@link CarStatistics} class.
 * <p>
 * NOTE: we should not use Lombok here because we use MapStruct library which require hardcoded getter and setter of fields.
 */

@Schema(
        name = "CarStatisticsDto",
        description = "Schema about holding Car Statistics information"
)
public class CarStatisticsDto {

    @Nullable
    @Min(0)
    @Schema(description = "Car's mileage. Estimates in kilometers (km)", example = "80345.78")
    private Double mileage;

    @Nullable
    @Min(0)
    @Schema(description = "Car's average speed. Estimates in kilometers per hour (km/h)", example = "120.23")
    private Double averageSpeed;

    @Nullable
    @Min(0)
    @Schema(description = "Car's average fuel consumption. Estimates in liters per 100 kilometers (L/100km)", example = "8.9")
    private Double averageFuelConsumption;

    @Nullable
    @Min(0)
    @Schema(description = "Car's last time after engine start. Estimates in seconds (s)", example = "1740")
    private Integer lastTimeAfterEngineStartSeconds;

    @Nullable
    @Min(0)
    @Schema(description = "Car's average ride time. Estimates in seconds", example = "3600")
    private Integer averageRideTimeSeconds;

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
        CarStatisticsDto that = (CarStatisticsDto) o;
        return Objects.equals(mileage, that.mileage) && Objects.equals(averageSpeed, that.averageSpeed) && Objects.equals(averageFuelConsumption, that.averageFuelConsumption) && Objects.equals(lastTimeAfterEngineStartSeconds, that.lastTimeAfterEngineStartSeconds) && Objects.equals(averageRideTimeSeconds, that.averageRideTimeSeconds);
    }

    @Override
    public int hashCode() {
        return Objects.hash(mileage, averageSpeed, averageFuelConsumption, lastTimeAfterEngineStartSeconds, averageRideTimeSeconds);
    }

    @Override
    public String toString() {
        return "CarStatisticsDto{" +
                "mileage=" + mileage +
                ", averageSpeed=" + averageSpeed +
                ", averageFuelConsumption=" + averageFuelConsumption +
                ", lastTimeAfterEngineStartSeconds=" + lastTimeAfterEngineStartSeconds +
                ", averageRideTimeSeconds=" + averageRideTimeSeconds +
                '}';
    }
}
