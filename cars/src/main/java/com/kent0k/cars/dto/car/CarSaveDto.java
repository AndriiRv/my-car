package com.kent0k.cars.dto.car;

import com.kent0k.cars.dto.cardetails.CarDetailsDto;
import com.kent0k.cars.dto.carstatistics.CarStatisticsDto;

import java.util.Objects;

public class CarSaveDto extends CarDto {

    private CarDetailsDto carDetailsDto;
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
