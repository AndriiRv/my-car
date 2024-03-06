package com.kent0k.servicepartners.dto.external;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;
import java.util.Objects;

@Schema(
        name = "OwnerDto",
        description = "Schema about holding Owner information"
)
public class OwnerDto {

    @NotBlank
    @Size(max = 20)
    @Schema(description = "Owners firstname", example = "John")
    private String firstName;

    @NotBlank
    @Size(max = 20)
    @Schema(description = "Owners lastName", example = "Smith")
    private String lastName;

    @NotNull
    @Past
    @Schema(description = "Owners birth date", example = "1988-12-12")
    private LocalDate birthDate;

    @NotBlank
    @Size(max = 50)
    @Email
    @Schema(description = "Owners email", example = "example@gmail.com")
    private String email;

    @NotBlank
    @Size(max = 20)
    @Schema(description = "Owners phone number", example = "+380971234567")
    private String phoneNumber;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OwnerDto ownerDto = (OwnerDto) o;
        return Objects.equals(firstName, ownerDto.firstName) && Objects.equals(lastName, ownerDto.lastName) && Objects.equals(birthDate, ownerDto.birthDate) && Objects.equals(email, ownerDto.email) && Objects.equals(phoneNumber, ownerDto.phoneNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, birthDate, email, phoneNumber);
    }

    @Override
    public String toString() {
        return "OwnerDto{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", birthDate=" + birthDate +
                ", email='" + email + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                '}';
    }
}
