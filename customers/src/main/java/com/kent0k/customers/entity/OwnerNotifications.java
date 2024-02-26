package com.kent0k.customers.entity;

import com.kent0k.customers.enums.DbBoolean;
import com.kent0k.customers.enums.OwnerNotificationMode;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.util.Objects;

@Entity
@Table(name = "owner_notifications")
public class OwnerNotifications extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Integer id;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "owner_id")
    private Owner owner;

    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(name = "OWNERS_NOTIFICATION_MODE")
    private OwnerNotificationMode ownerNotificationMode;

    @NotBlank
    @Size(max = 100)
    @Column(name = "MESSAGE")
    private String message;

    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(name = "IS_SENT")
    private DbBoolean isSent;

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

    public OwnerNotificationMode getOwnerNotificationMode() {
        return ownerNotificationMode;
    }

    public void setOwnerNotificationMode(OwnerNotificationMode ownerNotificationMode) {
        this.ownerNotificationMode = ownerNotificationMode;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public DbBoolean getIsSent() {
        return isSent;
    }

    public void setIsSent(DbBoolean isSent) {
        this.isSent = isSent;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OwnerNotifications that = (OwnerNotifications) o;
        return Objects.equals(id, that.id) && Objects.equals(owner, that.owner) && ownerNotificationMode == that.ownerNotificationMode && Objects.equals(message, that.message) && isSent == that.isSent;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, owner, ownerNotificationMode, message, isSent);
    }

    @Override
    public String toString() {
        return "OwnerNotifications{" +
                "id=" + id +
                ", owner=" + owner +
                ", ownerNotificationMode=" + ownerNotificationMode +
                ", message='" + message + '\'' +
                ", isSent=" + isSent +
                '}';
    }
}
