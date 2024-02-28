package com.kent0k.servicepartners.entity;

import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.data.mongodb.core.mapping.FieldType;

import java.time.LocalDate;
import java.util.Objects;

@Document("workers")
public class Worker extends BaseEntity {

    @DBRef
    private ServicePartner servicePartner;

    @Field(name = "firstName", targetType = FieldType.STRING)
    private String firstName;

    @Field(name = "lastName", targetType = FieldType.STRING)
    private String lastName;

    @Field(name = "birthDate", targetType = FieldType.DATE_TIME)
    private LocalDate birthDate;

    @Field(name = "email", targetType = FieldType.STRING)
    private String email;

    @Field(name = "phoneNumber", targetType = FieldType.STRING)
    private String phoneNumber;

    @Field(name = "hasKids", targetType = FieldType.BOOLEAN)
    private Boolean hasKids;

    @Field(name = "isHired", targetType = FieldType.BOOLEAN)
    private Boolean isHired;

    public ServicePartner getServicePartner() {
        return servicePartner;
    }

    public void setServicePartner(ServicePartner servicePartner) {
        this.servicePartner = servicePartner;
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
        Worker worker = (Worker) o;
        return Objects.equals(servicePartner, worker.servicePartner) && Objects.equals(firstName, worker.firstName) && Objects.equals(lastName, worker.lastName) && Objects.equals(birthDate, worker.birthDate) && Objects.equals(email, worker.email) && Objects.equals(phoneNumber, worker.phoneNumber) && Objects.equals(hasKids, worker.hasKids) && Objects.equals(isHired, worker.isHired);
    }

    @Override
    public int hashCode() {
        return Objects.hash(servicePartner, firstName, lastName, birthDate, email, phoneNumber, hasKids, isHired);
    }

    @Override
    public String toString() {
        return "Worker{" +
                "servicePartner=" + servicePartner +
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
