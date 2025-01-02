package com.ess.expenses.core.dto;

import com.ess.expenses.core.utils.Refundable;
import com.ess.expenses.core.utils.RefundableMode;
import com.ess.expenses.core.utils.Type;
import com.ess.expenses.infrastructure.domain.sql.audit.Auditable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PaymentDto extends Auditable {
    private Long id;
    private Type type;
    private String myCompany;
    private String department;
    private String primaryContact;
    private String purpose;
    private Double amount;
    private Date date;
    private String transactionMode;
    private String referenceNo;
    private String attachments;
    private String notes;
    private Refundable refundable;
    private RefundableMode refundableMode;



}
