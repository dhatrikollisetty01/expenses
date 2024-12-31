package com.ess.expenses.infrastructure.domain.sql.model;

import com.ess.expenses.core.utils.RefundableMode;
import com.ess.expenses.core.utils.RefundableType;
import com.ess.expenses.core.utils.Type;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table
public class PaymentEntity {

    private Long id;
    private Type type;
    private String myCompany;
    private String department;
    private String primaryContact;
    private String purpose;
    private Double amount;
    private Date date;
    private String transactionMode;
    private String referenceNumber;
    private String notes;
    private RefundableType refundableType=RefundableType.NO;
    private RefundableMode refundableMode;
}
