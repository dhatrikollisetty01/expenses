package com.ess.expenses.infrastructure.domain.sql.service.handler;

import com.ess.expenses.core.dto.PaymentDto;
import com.ess.expenses.infrastructure.domain.sql.model.PaymentEntity;

public interface MapperConfig {

    PaymentDto toPaymentDto(PaymentEntity paymentEntity);
    PaymentEntity toPaymentEntity(PaymentDto paymentDto);
}
