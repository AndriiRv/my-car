package com.kent0k.servicepartners.dto.servicepartner;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.v3.oas.annotations.media.Schema;

import java.util.Objects;

@Schema(
        name = "ServicePartnerSaveDto",
        description = "Schema about holding ServicePartner information to save"
)
public class ServicePartnerSaveDto extends ServicePartnerDto {

    /**
     * This id extra field should be used to set id manually on the backend side.
     */
    @JsonIgnore
    @Schema(description = "Service partner identifier as integer value", example = "123")
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
