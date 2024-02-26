package com.kent0k.customers.entity;

import jakarta.persistence.Column;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
@Getter
@Setter
@ToString
public class BaseEntity {

    @CreatedDate
    @Column(name = "created_at_utc", updatable = false)
    private LocalDateTime createdAtUtc;

    @CreatedBy
    @Column(name = "created_by_id", updatable = false)
    private Integer createdById;

    @LastModifiedDate
    @Column(name = "updated_at_utc", insertable = false)
    private LocalDateTime updatedAtUtc;

    @LastModifiedBy
    @Column(name = "updated_by_id", insertable = false)
    private Integer updatedById;
}
