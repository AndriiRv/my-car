package com.kent0k.customers.dto.ownercredentials;

import com.kent0k.customers.enums.DbBoolean;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.util.Objects;

public class OwnerCredentialsDto {

    @NotBlank
    @Size(max = 20)
    private String username;

    @NotBlank
    @Size(max = 20)
    private String password;

    @NotNull
    private DbBoolean isActive;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public DbBoolean getIsActive() {
        return isActive;
    }

    public void setIsActive(DbBoolean isActive) {
        this.isActive = isActive;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OwnerCredentialsDto that = (OwnerCredentialsDto) o;
        return Objects.equals(username, that.username) && Objects.equals(password, that.password) && isActive == that.isActive;
    }

    @Override
    public int hashCode() {
        return Objects.hash(username, password, isActive);
    }

    @Override
    public String toString() {
        return "OwnerCredentialsDto{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", isActive=" + isActive +
                '}';
    }
}
