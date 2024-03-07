package com.kent0k.customers.entity;

import com.kent0k.customers.enums.DbBoolean;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.util.Objects;

@Entity
@Table(name = "owner_credentials")
public class OwnerCredentials extends BaseEntity {

    @Id
    @NotNull
    @Column
    private Integer id;

    @NotNull
    @OneToOne(fetch = FetchType.LAZY, orphanRemoval = true)
    @MapsId
    @JoinColumn(name = "id", referencedColumnName = "id")
    private Owner owner;

    @NotBlank
    @Size(max = 765)
    @Column(name = "USERNAME")
    private String username;

    @NotBlank
    @Size(max = 765)
    @Column(name = "PASSWORD")
    private String password;

    @Enumerated(EnumType.STRING)
    @Column(name = "IS_ACTIVE")
    private DbBoolean isActive;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Owner getOwner() {
        return owner;
    }

    public void setOwner(Owner owner) {
        this.owner = owner;
    }

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
        OwnerCredentials that = (OwnerCredentials) o;
        return Objects.equals(id, that.id) && Objects.equals(owner, that.owner) && Objects.equals(username, that.username) && Objects.equals(password, that.password) && isActive == that.isActive;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, owner, username, password, isActive);
    }

    @Override
    public String toString() {
        return "OwnerCredentials{" +
                "id=" + id +
                ", owner=" + owner +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", isActive=" + isActive +
                '}';
    }
}
