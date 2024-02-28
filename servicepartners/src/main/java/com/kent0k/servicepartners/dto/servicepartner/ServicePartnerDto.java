package com.kent0k.servicepartners.dto.servicepartner;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.util.Objects;

public class ServicePartnerDto {

    @NotBlank
    @Size(max = 20)
    private String title;

    @NotBlank
    @Size(max = 50)
    private String address;

    @NotNull
    private Boolean currentWorkStatus;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Boolean getCurrentWorkStatus() {
        return currentWorkStatus;
    }

    public void setCurrentWorkStatus(Boolean currentWorkStatus) {
        this.currentWorkStatus = currentWorkStatus;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ServicePartnerDto that = (ServicePartnerDto) o;
        return Objects.equals(title, that.title) && Objects.equals(address, that.address) && Objects.equals(currentWorkStatus, that.currentWorkStatus);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, address, currentWorkStatus);
    }

    @Override
    public String toString() {
        return "ServicePartnerDto{" +
                "title='" + title + '\'' +
                ", address='" + address + '\'' +
                ", currentWorkStatus=" + currentWorkStatus +
                '}';
    }
}
