package com.ess.expenses.infrastructure.domain.sql.service.handler;

import com.ess.expenses.core.dto.PaymentDto;
import com.ess.expenses.core.dto.ReceivableDto;
import com.ess.expenses.infrastructure.domain.sql.model.PaymentEntity;
import com.ess.expenses.infrastructure.domain.sql.model.ReceivableEntity;
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
        return paymentEntity;
    }

    @Override
    public ReceivableDto toReceivableDto(ReceivableEntity receivableEntity) {
        ReceivableDto  receivableDto = modelMapper.map(receivableEntity,ReceivableDto.class);
        return receivableDto;
    }

    @Override
    public ReceivableEntity toReceivableEntity(ReceivableDto receivableDto) {
        ReceivableEntity receivableEntity = modelMapper.map(receivableDto,ReceivableEntity.class);
        return receivableEntity;
    }
}
