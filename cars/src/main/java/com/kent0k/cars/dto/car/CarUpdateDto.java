package com.kent0k.cars.dto.car;

import com.kent0k.cars.dto.cardetails.CarDetailsUpdateDto;
import com.kent0k.cars.dto.carstatistics.CarStatisticsUpdateDto;
import jakarta.validation.constraints.NotNull;

import java.util.Objects;

public class CarUpdateDto extends CarDto {

    @NotNull
    private Integer id;

    private CarDetailsUpdateDto carDetailsUpdateDto;
    private CarStatisticsUpdateDto carStatisticsUpdateDto;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public CarDetailsUpdateDto getCarDetailsUpdateDto() {
        return carDetailsUpdateDto;
    }

    public void setCarDetailsUpdateDto(CarDetailsUpdateDto carDetailsUpdateDto) {
        this.carDetailsUpdateDto = carDetailsUpdateDto;
    }

    public CarStatisticsUpdateDto getCarStatisticsUpdateDto() {
        return carStatisticsUpdateDto;
    }

    public void setCarStatisticsUpdateDto(CarStatisticsUpdateDto carStatisticsUpdateDto) {
        this.carStatisticsUpdateDto = carStatisticsUpdateDto;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        CarUpdateDto that = (CarUpdateDto) o;
        return Objects.equals(id, that.id) && Objects.equals(carDetailsUpdateDto, that.carDetailsUpdateDto) && Objects.equals(carStatisticsUpdateDto, that.carStatisticsUpdateDto);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), id, carDetailsUpdateDto, carStatisticsUpdateDto);
    }

    @Override
    public String toString() {
        return "CarUpdateDto{" +
                "id=" + id +
                ", carDetailsUpdateDto=" + carDetailsUpdateDto +
                ", carStatisticsUpdateDto=" + carStatisticsUpdateDto +
                '}';
    }
}
