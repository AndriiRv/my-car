package com.kent0k.servicepartners.dto.servicepartner;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.Objects;

public class ServicePartnerSaveDto extends ServicePartnerDto {

    @JsonIgnore
    private Integer id;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        ServicePartnerSaveDto that = (ServicePartnerSaveDto) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), id);
    }

    @Override
    public String toString() {
        return "ServicePartnerSaveDto{" +
                "id=" + id +
                '}';
    }
}
