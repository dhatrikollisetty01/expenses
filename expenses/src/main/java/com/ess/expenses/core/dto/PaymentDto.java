package com.ess.expenses.core.dto;

import com.ess.expenses.core.utils.Type;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PaymentDto {
    private Long id;
    private Type type;
    private String myCompany;
    private String department;
    private String primaryContact;
    private String purpose;
    private Double amount;
    private Date date;

}
