package com.ess.expenses.infrastructure.domain.sql.service.impl;


import com.ess.expenses.core.dto.PaymentDto;
import com.ess.expenses.infrastructure.domain.sql.model.PaymentEntity;
import com.ess.expenses.infrastructure.domain.sql.repository.PaymentRepository;
import com.ess.expenses.infrastructure.domain.sql.service.handler.MapperConfig;
//import com.ess.expenses.infrastructure.domain.sql.service.handler.MapperImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaymentServiceImp implements PaymentService{

    @Autowired
    private MapperConfig mapperConfig;

    @Autowired
    PaymentRepository paymentRepository;
    @Override
    public PaymentDto createPayment(PaymentDto paymentDto) {
        PaymentEntity paymentEntity = mapperConfig.toPaymentEntity(paymentDto);
        PaymentEntity savedEntity = paymentRepository.save(paymentEntity);
        PaymentDto paymentDto1 = mapperConfig.toPaymentDto(savedEntity);

        return paymentDto1;
    }
}
