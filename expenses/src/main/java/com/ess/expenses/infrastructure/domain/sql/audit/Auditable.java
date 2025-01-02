package com.ess.expenses.infrastructure.domain.sql.audit;

import jakarta.persistence.Column;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import lombok.Data;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@Data
    @MappedSuperclass
    @EntityListeners(AuditingEntityListener.class)
    public class Auditable {

        @CreatedBy
        @Column(name = "createdBy", updatable = false)
        private String createdBy;

        @CreatedDate
        @Column(name = "createdDate", updatable = false)
        private LocalDateTime createdDate;

        @LastModifiedBy
        @Column(name = "updatedBy")
        private String updatedBy;

        @LastModifiedDate
        @Column(name = "updatedDate")
        private LocalDateTime updatedDate;
    }

