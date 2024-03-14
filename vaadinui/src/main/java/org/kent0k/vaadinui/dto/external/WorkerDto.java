package org.kent0k.vaadinui.dto.external;

import jakarta.validation.constraints.*;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.Objects;

@Component
public class WorkerDto {

    @NotNull
    private Integer id;

    @NotBlank
    @Size(max = 20)
    private String firstName;

    @NotBlank
    @Size(max = 20)
    private String lastName;

    @NotNull
    @Past
    private LocalDate birthDate;

    @NotBlank
    @Size(max = 50)
    @Email
    private String email;

    @NotBlank
    @Size(max = 20)
    private String phoneNumber;

    @NotNull
    private Boolean hasKids;

    @NotNull
    private Boolean isHired;

    public WorkerDto(Integer id, String firstName, String lastName, LocalDate birthDate, String email, String phoneNumber, Boolean hasKids, Boolean isHired) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = birthDate;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.hasKids = hasKids;
        this.isHired = isHired;
    }

    public WorkerDto(String firstName) {
        this.firstName = firstName;
    }

    public WorkerDto() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

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
        return Objects.equals(id, workerDto.id) && Objects.equals(firstName, workerDto.firstName) && Objects.equals(lastName, workerDto.lastName) && Objects.equals(birthDate, workerDto.birthDate) && Objects.equals(email, workerDto.email) && Objects.equals(phoneNumber, workerDto.phoneNumber) && Objects.equals(hasKids, workerDto.hasKids) && Objects.equals(isHired, workerDto.isHired);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstName, lastName, birthDate, email, phoneNumber, hasKids, isHired);
    }

    @Override
    public String toString() {
        return "WorkerDto{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", birthDate=" + birthDate +
                ", email='" + email + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", hasKids=" + hasKids +
                ", isHired=" + isHired +
                '}';
    }
}
