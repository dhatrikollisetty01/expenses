package com.ess.expenses.core.dto;

import com.ess.expenses.core.resp.ApiResponse;
import com.ess.expenses.core.utils.*;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PaymentDto  {
        private Long id;
        private Type type;
        private PaidTo paidTo;
//    private String myCompany;
        private Department department;
        private String primaryContact;
        private Double amount;
        private Date paidDate;
        private PurposeType purpose;
        private TransactionMode transactionMode;
        private String transactionNumber;
        private String attachment;
        private String notes;
        private Refundable refundable;
        private RefundableMode refundableMode;
        private Integer delFlag=1;

    }