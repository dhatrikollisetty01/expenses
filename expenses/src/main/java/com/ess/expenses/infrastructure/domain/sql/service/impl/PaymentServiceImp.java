package com.ess.expenses.infrastructure.domain.sql.service.impl;


import com.ess.expenses.core.constants.ReceivableContants;
import com.ess.expenses.core.dto.PaymentDto;
import com.ess.expenses.core.dto.ReceivableDto;
import com.ess.expenses.infrastructure.domain.sql.model.PaymentEntity;
import com.ess.expenses.infrastructure.domain.sql.model.ReceivableEntity;
import com.ess.expenses.infrastructure.domain.sql.repository.PaymentRepository;
import com.ess.expenses.infrastructure.domain.sql.service.handler.MapperConfig;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

import static java.util.stream.Collectors.toList;

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

    public PaymentDto getPaymentsById(Long id) {
        PaymentEntity paymentEntity = paymentRepository.findById(id).get();
        PaymentDto paymentDto = mapperConfig.toPaymentDto(paymentEntity);
        return paymentDto;
    }


    @Override
    public List<PaymentDto> getAllPayments() {
        List<PaymentDto> invoiceDtos=paymentRepository.findAll().stream().
                map(mapperConfig::toPaymentDto).collect(toList());
        return invoiceDtos ;
    }

    @Override
    public PaymentDto updatePayments(Long id, PaymentDto paymentDto) {
        // Fetch the existing entity
        PaymentEntity paymentEntity = paymentRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Payment with ID " + id + " not found"));

        if (paymentDto.getType() != null) {
            paymentEntity.setType(paymentDto.getType());
        }
        if (paymentDto.getMyCompany() != null) {
            paymentEntity.setMyCompany(paymentDto.getMyCompany());
        }
        if (paymentDto.getDepartment() != null) {
            paymentEntity.setDepartment(paymentDto.getDepartment());
        }
        if (paymentDto.getPrimaryContact() != null) {
            paymentEntity.setPrimaryContact(paymentDto.getPrimaryContact());
        }
        if (paymentDto.getPurpose() != null) {
            paymentEntity.setPurpose(paymentDto.getPurpose());
        }
        if (paymentDto.getAmount() != null) {
            paymentEntity.setAmount(paymentDto.getAmount());
        }
        if (paymentDto.getDate() != null) {
            paymentEntity.setDate(paymentDto.getDate());
        }
        if (paymentDto.getTransactionMode() != null) {
            paymentEntity.setTransactionMode(paymentDto.getTransactionMode());
        }
        if (paymentDto.getReferenceNo() != null) {
            paymentEntity.setReferenceNo(paymentDto.getReferenceNo());
        }
        if (paymentDto.getAttachments() != null) {
            paymentEntity.setAttachment(paymentDto.getAttachments());
        }
        if (paymentDto.getNotes() != null) {
            paymentEntity.setNotes(paymentDto.getNotes());
        }
        if (paymentDto.getRefundable() != null) {
            paymentEntity.setRefundable(paymentDto.getRefundable());
        }
        if (paymentDto.getRefundableMode() != null) {
            paymentEntity.setRefundableMode(paymentDto.getRefundableMode());
        }

        // Save the updated entity
        PaymentEntity updatedEntity = paymentRepository.save(paymentEntity);

        // Map the updated entity to DTO and return
        return mapperConfig.toPaymentDto(updatedEntity);
    }


    @Override
    public PaymentDto softDeletePayments(Long id) {
        // Validate the ID
        if (id == null) {
            throw new IllegalArgumentException("The given ID must not be null.");
        }

        // Retrieve the entity or throw an exception if not found
        PaymentEntity paymentEntity = paymentRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Payment with ID " + id + " not found"));

        // Perform the soft delete by setting the delFlag to 1
      //  PaymentEntity.setDelFlag(1);

        // Save the updated entity
        PaymentEntity updatedEntity = paymentRepository.save(paymentEntity);

        // Convert the entity to DTO
        return mapperConfig.toPaymentDto(updatedEntity);
    }

}