package com.ess.expenses.infrastructure.domain.sql.model;

import com.ess.expenses.core.utils.Type;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "receivables")
public class ReceivableEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private Type type;

    @Column(name = "BILLING_ADDRESS")
    private String billingAddress;

    @Column(name = "PRIMARY_CONTACT")
    private String primaryContact;

    @Column(name = "PURPOSE")
    private String purpose;

    @Column(name = "RECEIVED_AMOUNT")
    private String receivedAmount;

    @Column(name = "SERVICES")
    private String services;

    @Temporal(TemporalType.DATE)
    private Date date;

    @Column(name = "INVOICE_NUMBER")
    private String invoiceNumber;

    @Temporal(TemporalType.DATE)
    @Column(name = "INVOICE_DATE")
    private Date invoiceDate;

    @Temporal(TemporalType.DATE)
    @Column(name = "DUE_DATE")
    private Date dueDate;

    @Column(name = "INVOICE_AMOUNT")
    private double invoiceAmount;

    @Column(name = "PAYMENT_MODE")
    private String paymentMode;

    @Column(name = "REFERENCE_NUMBER")
    private String referenceNumber;

    @Column(name = "ADJUSTMENT_AMOUNT")
    private double adjustmentAmount;

    @Column(name = "NOTES")
    private String notes;

    @Column(name = "TOTAL_RECEIVABLE_AMOUNT")
    private double totalReceivableAmount;

    @Column(name = "RECEIVED_AMOUNT_TILL_DATE")
    private double receivedAmountTillDate;

    @Column(name = "YET_TO_RECEIVED_AMOUNT")
    private double yetToReceivedAmount;

    @Column(name = "IS_ACTIVE")
    private Integer delFlag = 1;
}
