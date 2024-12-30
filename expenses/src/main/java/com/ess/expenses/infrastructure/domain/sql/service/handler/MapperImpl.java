package com.ess.expenses.infrastructure.domain.sql.service.handler;

import com.ess.expenses.core.dto.PaymentDto;
import com.ess.expenses.infrastructure.domain.sql.model.PaymentEntity;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MapperImpl implements MapperConfig {

    @Autowired
    private ModelMapper modelMapper;


    @Override
    public PaymentDto toPaymentDto(PaymentEntity paymentEntity) {
        PaymentDto paymentDto = modelMapper.map(paymentEntity,PaymentDto.class);
        return paymentDto;
    }

    @Override
    public PaymentEntity toPaymentEntity(PaymentDto paymentDto) {
        PaymentEntity paymentEntity = modelMapper.map(paymentDto,PaymentEntity.class);
        return null;
    }
}
