package com.kent0k.servicepartners.dto.worker;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;
import java.util.Objects;

@Schema(
        name = "WorkerDto",
        description = "Schema about holding Worker information"
)
public class WorkerDto {

    @NotBlank
    @Size(max = 20)
    @Schema(description = "Workers firstname", example = "Arthur")
    private String firstName;

    @NotBlank
    @Size(max = 20)
    @Schema(description = "Workers firstname", example = "Morgan")
    private String lastName;

    @NotNull
    @Past
    @Schema(description = "Workers birth date", example = "1987-12-12")
    private LocalDate birthDate;

    @NotBlank
    @Size(max = 50)
    @Schema(description = "Workers email", example = "example@gmail.com")
    private String email;

    @NotBlank
    @Size(max = 20)
    @Schema(description = "Workers phone number", example = "+380671234567")
    private String phoneNumber;

    @NotNull
    @Schema(description = "Whether worker has kids", example = "false")
    private Boolean hasKids;

    @NotNull
    @Schema(description = "Whether worker is hired", example = "true")
    private Boolean isHired;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Boolean getHasKids() {
        return hasKids;
    }

    public void setHasKids(Boolean hasKids) {
        this.hasKids = hasKids;
    }

    public Boolean getHired() {
        return isHired;
    }

    public void setHired(Boolean hired) {
        isHired = hired;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WorkerDto workerDto = (WorkerDto) o;
        return Objects.equals(firstName, workerDto.firstName) && Objects.equals(lastName, workerDto.lastName) && Objects.equals(birthDate, workerDto.birthDate) && Objects.equals(email, workerDto.email) && Objects.equals(phoneNumber, workerDto.phoneNumber) && Objects.equals(hasKids, workerDto.hasKids) && Objects.equals(isHired, workerDto.isHired);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, birthDate, email, phoneNumber, hasKids, isHired);
    }

    @Override
    public String toString() {
        return "WorkerDto{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", birthDate=" + birthDate +
                ", email='" + email + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", hasKids=" + hasKids +
                ", isHired=" + isHired +
                '}';
    }
}
