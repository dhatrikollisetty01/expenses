package com.ess.expenses.infrastructure.domain.sql.service.impl;

import com.ess.expenses.core.dto.ReceivableDto;
import com.ess.expenses.core.req.ExpensesReq;
import com.ess.expenses.core.resp.ApiResponse;

import java.util.List;

public interface ReceivableService {
    ApiResponse createReceivable(ExpensesReq expensesReq);
    ApiResponse getReceivableById(Long id);
    ApiResponse getAllReceivable();
    ApiResponse updateReceivable(Long id, ReceivableDto receivableDto);
    ApiResponse softDeleteReceivable(Long id);

}