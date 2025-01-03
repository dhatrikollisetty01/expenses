package com.ess.expenses.infrastructure.domain.sql.service.impl;

import com.ess.expenses.core.dto.PaymentDto;
import com.ess.expenses.core.req.ExpensesReq;
import com.ess.expenses.core.resp.ApiResponse;
import com.ess.expenses.infrastructure.domain.sql.model.PaymentEntity;
import com.ess.expenses.infrastructure.domain.sql.repository.PaymentRepository;
import com.ess.expenses.infrastructure.domain.sql.service.handler.MapperConfig;
import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PaymentServiceImpl implements PaymentService {

    @Autowired
    private MapperConfig mapperConfig;

    @Autowired
    private PaymentRepository paymentRepository;

    @Transactional
    @Override
    public ApiResponse createPayment(@Valid ExpensesReq expensesReq) {
        try {
            PaymentEntity paymentEntity = mapperConfig.toPaymentEntity(expensesReq.getPayment());
            PaymentEntity savedEntity = paymentRepository.save(paymentEntity);
            PaymentDto paymentDto = mapperConfig.toPaymentDto(savedEntity);
            return new ApiResponse(true, "success", paymentDto);

        } catch (Exception e) {
            // Handle errors in Payment Creation
            return new ApiResponse(false, "Error in creating payment. Please try again!", null);
        }
    }

    @Override
    public ApiResponse getPaymentsById(Long id) {
        try {
            PaymentEntity paymentEntity = paymentRepository.findById(id)
                    .orElseThrow(() -> new EntityNotFoundException("Payment with ID " + id + " not found"));
            PaymentDto paymentDto = mapperConfig.toPaymentDto(paymentEntity);
            return new ApiResponse(true, "Payment details found", paymentDto);
        } catch (EntityNotFoundException e) {
            // Handle exception when Payment is not found
            return new ApiResponse(false, e.getMessage(), null);
        }
    }

    @Override
    public ApiResponse getAllPayments() {
        List<PaymentDto> paymentDto = paymentRepository.findAll().stream()
                .map(mapperConfig::toPaymentDto)
                .filter(payment -> payment.getDelFlag() == 1)
                .collect(Collectors.toList());
        return new ApiResponse(true, "All payments fetched successfully", paymentDto);
    }


    @Transactional
    @Override
    public ApiResponse softDeletePayments(Long id) {
        try {
            // Find Payment by ID
            PaymentEntity paymentEntity = paymentRepository.findById(id)
                    .orElseThrow(() -> new EntityNotFoundException("Payment with ID " + id + " not found"));


            paymentEntity.setDelFlag(0); // Assuming 1 indicates deletion
            // Save the Soft Deleted Payment Entity
            PaymentEntity updatedEntity = paymentRepository.save(paymentEntity);
            // Convert to DTO and return the deleted payment info
            PaymentDto deletedPaymentDto = mapperConfig.toPaymentDto(updatedEntity);

            // Return Success Response indicating Soft Delete
            return new ApiResponse(true, "Payment successfully marked as deleted", deletedPaymentDto);
        } catch (EntityNotFoundException e) {
            // Handle case where Payment was not found
            return new ApiResponse(false, e.getMessage(), null);
        }
    }


    @Override
    public ApiResponse updatePayments(Long id, PaymentDto paymentDto) {
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
//        if (paymentDto.getPurpose() != null) {
//            paymentEntity.setPurpose(paymentDto.getPurpose());
//        }
        if (paymentDto.getAmount() != null) {
            paymentEntity.setAmount(paymentDto.getAmount());
        }
        if (paymentDto.getDate() != null) {
            paymentEntity.setDate(paymentDto.getDate());
        }
        if (paymentDto.getTransactionMode() != null) {
            paymentEntity.setTransactionMode(paymentDto.getTransactionMode());
        }
//        if (paymentDto.getReferenceNo() != null) {
//            paymentEntity.setReferenceNo(paymentDto.getReferenceNo());
//        }
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
        PaymentEntity updatedEntity = paymentRepository.save(paymentEntity);
        PaymentDto updatedDto=mapperConfig.toPaymentDto(updatedEntity);
        // Map the updated entity to DTO and return

        return new ApiResponse(true,"Payment updated successfully",updatedDto,null);

    }
}