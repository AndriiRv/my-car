package com.kent0k.customers.dto.ownernotifications;

import com.kent0k.customers.enums.DbBoolean;
import com.kent0k.customers.enums.OwnerNotificationMode;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.util.Objects;

@Schema(
        name = "OwnerNotificationsDto",
        description = "Schema about holding OwnerNotifications information"
)
public class OwnerNotificationsDto {

    @NotNull
    @Schema(description = "Owners id", example = "123")
    private Integer ownerId;

    @NotNull
    @Schema(description = "Owners notification mode. Different types of notify the customers/owners", example = "TELEGRAM")
    private OwnerNotificationMode ownerNotificationMode;

    @NotBlank
    @Size(max = 100)
    @Schema(description = "Owners notification message", example = "Notification is sent successfully")
    private String message;

    @NotNull
    @Schema(description = "Owners notification is sent status", example = "N")
    private DbBoolean isSent;

    public Integer getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(Integer ownerId) {
        this.ownerId = ownerId;
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
        OwnerNotificationsDto that = (OwnerNotificationsDto) o;
        return Objects.equals(ownerId, that.ownerId) && ownerNotificationMode == that.ownerNotificationMode && Objects.equals(message, that.message) && isSent == that.isSent;
    }

    @Override
    public int hashCode() {
        return Objects.hash(ownerId, ownerNotificationMode, message, isSent);
    }

    @Override
    public String toString() {
        return "OwnerNotificationsDto{" +
                "ownerId=" + ownerId +
                ", ownerNotificationMode=" + ownerNotificationMode +
                ", message='" + message + '\'' +
                ", isSent=" + isSent +
                '}';
    }
}
