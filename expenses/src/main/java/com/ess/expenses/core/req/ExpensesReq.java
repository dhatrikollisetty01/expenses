package com.ess.expenses.core.req;

import com.ess.expenses.core.dto.PaymentDto;
import com.ess.expenses.core.dto.ReceivableDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ExpensesReq {

    private PaymentDto payment=new PaymentDto();
    private ReceivableDto receivable=new ReceivableDto();

}