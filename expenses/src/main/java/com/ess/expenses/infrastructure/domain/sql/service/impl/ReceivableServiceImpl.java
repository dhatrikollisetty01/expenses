package com.ess.expenses.infrastructure.domain.sql.service.impl;

import com.ess.expenses.core.dto.ReceivableDto;
import com.ess.expenses.core.req.ExpensesReq;
import com.ess.expenses.core.resp.ApiResponse;
import com.ess.expenses.infrastructure.domain.sql.model.ReceivableEntity;
import com.ess.expenses.infrastructure.domain.sql.repository.ReceivableRepository;
import com.ess.expenses.infrastructure.domain.sql.service.handler.MapperConfig;
import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ReceivableServiceImpl implements ReceivableService {
    @Autowired
    private MapperConfig mapperConfig;

    @Autowired
    private ReceivableRepository receivableRepository;

    @Override
    public ApiResponse createReceivable(@Valid ExpensesReq expensesReq) {
        try {
            ReceivableEntity receivableEntity = mapperConfig.toReceivableEntity(expensesReq.getReceivable());
            ReceivableEntity saveEntity = receivableRepository.save(receivableEntity);
            ReceivableDto receivableDto1 = mapperConfig.toReceivableDto(saveEntity);
            return new ApiResponse(true, "success", receivableDto1);
        } catch (Exception e) {
            // Handle errors in Payment Creation
            return new ApiResponse(false, "Error in creating receivable. Please try again!", null);
        }
    }

    @Override
    public ApiResponse getReceivableById(Long id) {
        try {
            ReceivableEntity receivableEntity = receivableRepository.findById(id).get();
            ReceivableDto receivableDto = mapperConfig.toReceivableDto(receivableEntity);
            return new ApiResponse(true, "Receivable details found", receivableDto);
        } catch (EntityNotFoundException e) {
            // Handle exception when Payment is not found
            return new ApiResponse(false, e.getMessage(), null);
        }
    }

    @Override
    public ApiResponse getAllReceivable() {
        List<ReceivableDto> receivableDto = receivableRepository.findAll().stream()
                .map(mapperConfig::toReceivableDto)
                .filter(receivable -> receivable.getDelFlag() == 1)
                .collect(Collectors.toList());
        return new ApiResponse(true, "All receivables fetched successfully", receivableDto);
    }


    @Override
    public ApiResponse updateReceivable(Long id, ReceivableDto receivableDto) {
        // Fetch the existing entity
        ReceivableEntity receivableEntity = receivableRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Receivable with ID " + id + " not found"));

        // Map fields selectively
        // Map fields selectively
        // Map fields selectively
        if (receivableDto.getType() != null) {
            receivableEntity.setType(receivableDto.getType());
        }
        if (receivableDto.getBillingAddress() != null) {
            receivableEntity.setBillingAddress(receivableDto.getBillingAddress());
        }
        if (receivableDto.getPrimaryContact() != null) {
            receivableEntity.setPrimaryContact(receivableDto.getPrimaryContact());
        }
        if (receivableDto.getReceivedAmount() != null && !receivableDto.getReceivedAmount().isEmpty()) {
            receivableEntity.setReceivedAmount(receivableDto.getReceivedAmount());
        }
        if (receivableDto.getDescription() != null && !receivableDto.getDescription().isEmpty()) {
            receivableEntity.setDescription(receivableDto.getDescription());
        }
        if (receivableDto.getReceivedDate() != null) {
            receivableEntity.setReceivedDate(receivableDto.getReceivedDate());
        }
        if (receivableDto.getInvoiceNumber() != null && !receivableDto.getInvoiceNumber().isEmpty()) {
            receivableEntity.setInvoiceNumber(receivableDto.getInvoiceNumber());
        }
        if (receivableDto.getInvoiceDate() != null) {
            receivableEntity.setInvoiceDate(receivableDto.getInvoiceDate());
        }
        if (receivableDto.getDueDate() != null) {
            receivableEntity.setDueDate(receivableDto.getDueDate());
        }
        if (receivableDto.getInvoiceAmount() != 0) {
            receivableEntity.setInvoiceAmount(receivableDto.getInvoiceAmount());
        }
        if (receivableDto.getTransactionMode() != null) {
            receivableEntity.setTransactionMode(receivableDto.getTransactionMode());
        }
        if (receivableDto.getTransactionNumber() != null && !receivableDto.getTransactionNumber().isEmpty()) {
            receivableEntity.setTransactionNumber(receivableDto.getTransactionNumber());
        }
        if (receivableDto.getAdjustmentAmount() != 0) {
            receivableEntity.setAdjustmentAmount(receivableDto.getAdjustmentAmount());
        }
        if (receivableDto.getNotes() != null && !receivableDto.getNotes().isEmpty()) {
            receivableEntity.setNotes(receivableDto.getNotes());
        }

        if (receivableDto.getReceivedAmountTillDate() != 0) {
            receivableEntity.setReceivedAmountTillDate(receivableDto.getReceivedAmountTillDate());
        }
        // Save the updated entity
        ReceivableEntity updatedEntity = receivableRepository.save(receivableEntity);
        ReceivableDto updatedDto = mapperConfig.toReceivableDto(updatedEntity);
        return new ApiResponse(true, "Receivable updated successfully", updatedDto, null);

    }

    @Override
    public ApiResponse softDeleteReceivable(Long id) {
        try {
            if (id == null) {
                throw new IllegalArgumentException("The given ID must not be null.");
            }
            ReceivableEntity receivableEntity = receivableRepository.findById(id)
                    .orElseThrow(() -> new EntityNotFoundException("Receivable with ID " + id + " not found"));
            receivableEntity.setDelFlag(0);
            ReceivableEntity updatedEntity = receivableRepository.save(receivableEntity);
            ReceivableDto deletedReceivable = mapperConfig.toReceivableDto(updatedEntity);
            return new ApiResponse(true, "Receivable successfully marked as deleted", deletedReceivable);
        } catch (EntityNotFoundException e) {
            return new ApiResponse(false, e.getMessage(), null);
        }
    }
}