package com.kent0k.servicepartners.entity;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.data.mongodb.core.mapping.FieldType;

import java.util.Objects;

@Document("servicePartners")
public class ServicePartner extends BaseEntity {

    /**
     * Service partner title.
     */
    @Field(name = "title", targetType = FieldType.STRING)
    private String title;

    /**
     * Service partner address.
     */
    @Field(name = "address", targetType = FieldType.STRING)
    private String address;

    /**
     * Current service partner working status.
     */
    @Field(name = "currentWorkStatus", targetType = FieldType.BOOLEAN)
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
        if (!super.equals(o)) return false;
        ServicePartner that = (ServicePartner) o;
        return Objects.equals(title, that.title) && Objects.equals(address, that.address) && Objects.equals(currentWorkStatus, that.currentWorkStatus);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), title, address, currentWorkStatus);
    }

    @Override
    public String toString() {
        return "ServicePartner{" +
                "title='" + title + '\'' +
                ", address='" + address + '\'' +
                ", currentWorkStatus=" + currentWorkStatus +
                '}';
    }
}
