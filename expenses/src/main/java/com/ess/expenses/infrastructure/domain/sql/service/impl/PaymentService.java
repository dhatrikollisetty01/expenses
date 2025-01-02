package com.ess.expenses.infrastructure.domain.sql.service.impl;

import com.ess.expenses.core.dto.PaymentDto;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface PaymentService {

    PaymentDto createPayment(PaymentDto paymentDto);

     PaymentDto getPaymentsById(Long id);

     List<PaymentDto> getAllPayments();

    PaymentDto updatePayments(Long id, PaymentDto paymentDto);
     PaymentDto softDeletePayments(Long id);
}
