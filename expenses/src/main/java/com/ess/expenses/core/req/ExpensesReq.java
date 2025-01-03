package com.ess.expenses.core.req;

import com.ess.expenses.core.dto.ReceivableDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ExpensesReq {
    ReceivableDto receivableDetails=new ReceivableDto();

}
