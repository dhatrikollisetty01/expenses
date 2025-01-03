package com.ess.expenses.core.dto;

import com.ess.expenses.core.utils.PurposeType;
import com.ess.expenses.core.utils.TransactionMode;
import com.ess.expenses.core.utils.Type;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ReceivableDto {
        private Long id;
        private Type type;
        private String billingAddress;
        private String receivedAmount;
        private String description;
        private Date receivedDate;
        private String primaryContact;
        private Date invoiceDate;
//    private String purpose;
        private String invoiceNumber;
        private double invoiceAmount;
        private TransactionMode transactionMode;
        private String transactionNumber;
        private double receivedAmountTillDate;
        private double amountDue;
        private Date dueDate;
        private double adjustmentAmount;
        private String notes;
//    private double totalReceivableAmount;
//    private double yetToReceivedAmount;
        private Integer delFlag= 1;
    }