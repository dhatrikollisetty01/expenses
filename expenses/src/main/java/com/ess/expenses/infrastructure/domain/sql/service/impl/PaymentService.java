package com.ess.expenses.infrastructure.domain.sql.service.impl;

import com.ess.expenses.core.dto.PaymentDto;

public interface PaymentService {

    PaymentDto createPayment(PaymentDto paymentDto);

}
