package com.ess.expenses.core.dto;

import com.ess.expenses.core.utils.PurposeType;
import com.ess.expenses.core.utils.Type;
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
    private String primaryContact;
    private PurposeType purpose;
    private String receivedAmount;
    private String services;
    private Date date;
    private String invoiceNumber;
    private Date invoiceDate;
    private Date dueDate;
    private double invoiceAmount;
    private String paymentMode;
    private String referenceNumber;
    private double adjustmentAmount;
    private String notes;
    private double totalReceivableAmount;
    private double receivedAmountTillDate;
    private double yetToReceivedAmount;
    private Integer delFlag = 1;


}
