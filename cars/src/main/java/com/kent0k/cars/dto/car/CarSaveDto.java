package com.kent0k.cars.dto.car;

import com.kent0k.cars.dto.cardetails.CarDetailsDto;
import com.kent0k.cars.dto.carstatistics.CarStatisticsDto;
import com.kent0k.cars.entity.Car;
import io.swagger.v3.oas.annotations.media.Schema;

import java.util.Objects;

/**
 * Dto mapper class for {@link Car} class.
 * <p>
 * NOTE: we should not use Lombok here because we use MapStruct library which require hardcoded getter and setter of fields.
 */

@Schema(
        name = "CarSaveDto",
        description = "Schema about holding Car, CarDetails and CarStatistics information to save"
)
public class CarSaveDto extends CarDto {

    @Schema(description = "Car details data to save")
    private CarDetailsDto carDetailsDto;

    @Schema(description = "Car statistics data to save")
    private CarStatisticsDto carStatisticsDto;

    public CarDetailsDto getCarDetailsDto() {
        return carDetailsDto;
    }

    public void setCarDetailsDto(CarDetailsDto carDetailsDto) {
        this.carDetailsDto = carDetailsDto;
    }

    public CarStatisticsDto getCarStatisticsDto() {
        return carStatisticsDto;
    }

    public void setCarStatisticsDto(CarStatisticsDto carStatisticsDto) {
        this.carStatisticsDto = carStatisticsDto;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        CarSaveDto that = (CarSaveDto) o;
        return Objects.equals(carDetailsDto, that.carDetailsDto) && Objects.equals(carStatisticsDto, that.carStatisticsDto);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), carDetailsDto, carStatisticsDto);
    }

    @Override
    public String toString() {
        return "CarSaveDto{" +
                "carDetailsDto=" + carDetailsDto +
                ", carStatisticsDto=" + carStatisticsDto +
                '}';
    }
}
