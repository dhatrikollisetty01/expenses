package com.ess.expenses.infrastructure.domain.sql.service.impl;

import com.ess.expenses.core.dto.PaymentDto;
import com.ess.expenses.core.req.ExpensesReq;
import com.ess.expenses.core.resp.ApiResponse;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface PaymentService {

    ApiResponse createPayment(ExpensesReq expensesReq);
    ApiResponse getPaymentsById(Long id);
    ApiResponse getAllPayments();
    ApiResponse updatePayments(Long id, PaymentDto paymentDto);
    ApiResponse softDeletePayments(Long id);

}