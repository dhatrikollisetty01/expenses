package com.ess.expenses.infrastructure.domain.sql.model;

import com.ess.expenses.core.utils.Refundable;
import com.ess.expenses.core.utils.RefundableMode;
import com.ess.expenses.core.utils.Type;
import jakarta.persistence.*;
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
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "TYPE")
    @Enumerated(EnumType.STRING)
    private Type type;

    @Column(name = "MY_COMPANY")
    private String myCompany;

    @Column(name = "DEPARTMENT")
    private String department;

    @Column(name = "PRIMARY_CONTACT")
    private String primaryContact;

    @Column(name = "PURPOSE")
    private String purpose;

    @Column(name = "AMOUNT")
    private Double amount;

    @Column(name = "DATE")
    private Date date;

    @Column(name = "TRANSACTION_MODE")
    private String transactionMode;

    @Column(name = "REFERENCE_NO")
    private String referenceNo;

    @Column(name = "ATTACHMENT")
    private String attachment;

    @Column(name = "NOTES")
    private String notes;

    @Column(name = "REFUNDABLE")
    private Refundable refundable;

    @Column(name = "REFUNDABLE_MODE")
    @Enumerated(EnumType.STRING)
    private RefundableMode refundableMode;

}
