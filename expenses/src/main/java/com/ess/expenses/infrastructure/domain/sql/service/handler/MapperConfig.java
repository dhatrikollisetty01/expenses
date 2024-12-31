package com.ess.expenses.infrastructure.domain.sql.service.handler;

import com.ess.expenses.core.dto.PaymentDto;
import com.ess.expenses.core.dto.ReceivableDto;
import com.ess.expenses.infrastructure.domain.sql.model.PaymentEntity;
import com.ess.expenses.infrastructure.domain.sql.model.ReceivableEntity;

public interface MapperConfig {

    PaymentDto toPaymentDto(PaymentEntity paymentEntity);
    PaymentEntity toPaymentEntity(PaymentDto paymentDto);


    ReceivableDto toReceivableDto(ReceivableEntity receivableEntity);
    ReceivableEntity toReceivableEntity(ReceivableDto receivableDto);
}
