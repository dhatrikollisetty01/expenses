package com.ess.expenses.infrastructure.domain.sql.model;

import com.ess.expenses.core.utils.TransactionMode;
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

    @Column(name = "RECEIVED_AMOUNT")
    private String receivedAmount;

    @Column(name = "DESCRIPTION")
    private String description;

    @Temporal(TemporalType.DATE)
    private Date receivedDate;

    @Column(name = "PRIMARY_CONTACT")
    private String primaryContact;


    @Temporal(TemporalType.DATE)
    @Column(name = "INVOICE_DATE")
    private Date invoiceDate;

//    @Column(name = "PURPOSE")
//    private String purpose;
//

    @Column(name = "INVOICE_NUMBER")
    private String invoiceNumber;

    @Column(name = "INVOICE_AMOUNT")
    private double invoiceAmount;

    @Column(name = "TRANSACTION_MODE")
    @Enumerated(EnumType.STRING)
    private TransactionMode transactionMode;

    @Column(name = "TRANSACTION_NUMBER")
    private String transactionNumber;

    @Column(name = "RECEIVED_AMOUNT_TILL_DATE")
    private double receivedAmountTillDate;

    @Column(name="AMOUNT_DUE")
    private Double amountDue;

    @Temporal(TemporalType.DATE)
    @Column(name = "DUE_DATE")
    private Date dueDate;


    @Column(name = "ADJUSTMENT_AMOUNT")
    private double adjustmentAmount;


    @Column(name = "NOTES")
    private String notes;

//    @Column(name = "TOTAL_RECEIVABLE_AMOUNT")
//    private double totalReceivableAmount;
//
//
//    @Column(name = "YET_TO_RECEIVED_AMOUNT")
//    private double yetToReceivedAmount;

    @Column(name = "IS_ACTIVE")
    private Integer delFlag= 1;
}