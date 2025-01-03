package com.ess.expenses.infrastructure.domain.sql.model;

import com.ess.expenses.core.utils.*;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "payments")
public class PaymentEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "TYPE")
    @Enumerated(EnumType.STRING)
    private Type type;

    @Column(name="PAID_TO")
    @Enumerated(EnumType.STRING)
    private PaidTo paidTo;
//    @Column(name = "MY_COMPANY")
//    private String myCompany;

    @Column(name = "DEPARTMENT")
    @Enumerated(EnumType.STRING)
    private Department department;

    @Column(name = "PRIMARY_CONTACT")
    private String primaryContact;

    @Column(name = "AMOUNT")
    private Double amount;

    @Column(name = "PAID_DATE")
    private Date paidDate;

    @Column(name = "PURPOSE")
    @Enumerated(EnumType.STRING)
    private PurposeType purpose;

    @Column(name = "TRANSACTION_MODE")
    @Enumerated(EnumType.STRING)
    private TransactionMode transactionMode;

    @Column(name = "TRANSACTION_NUMBER")
    private String transactionNumber;

    @Column(name = "ATTACHMENT")
    private String attachment;

    @Column(name = "NOTES")
    private String notes;

    @Column(name = "REFUNDABLE")
    private Refundable refundable;

    @Column(name = "REFUNDABLE_MODE")
    @Enumerated(EnumType.STRING)
    private RefundableMode refundableMode;

    private Integer delFlag=1;

}
