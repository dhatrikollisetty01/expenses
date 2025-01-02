package com.ess.expenses.infrastructure.domain.sql.service.impl;

import com.ess.expenses.core.dto.PaymentDto;
import com.ess.expenses.core.dto.ReceivableDto;
import com.ess.expenses.core.req.ExpensesReq;
import com.ess.expenses.core.resp.ApiResponse;
import com.ess.expenses.infrastructure.domain.sql.model.ReceivableEntity;
import com.ess.expenses.infrastructure.domain.sql.repository.ReceivableRepository;
import com.ess.expenses.infrastructure.domain.sql.service.handler.MapperConfig;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;

@Service
public class ReceivableServiceImpl implements ReceivableService {
    @Autowired
    private MapperConfig mapperConfig;

    @Autowired
    private ReceivableRepository receivableRepository;

    @Override
    public ApiResponse createReceivable(ExpensesReq expensesReq) {
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
            List<ReceivableDto> receivableDtos = receivableRepository.findAll().stream()
                    .map(mapperConfig::toReceivableDto)
                    .collect(Collectors.toList());
            // Return Success Response with List of Payments
            return new ApiResponse(true, "All receivable fetched successfully", receivableDtos);
        }


    @Override
    public ApiResponse updateReceivable(Long id, ReceivableDto receivableDto) {
        // Fetch the existing entity
        ReceivableEntity receivableEntity = receivableRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Receivable with ID " + id + " not found"));

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
        if (receivableDto.getReceivedAmount() != null) {
            receivableEntity.setReceivedAmount(receivableDto.getReceivedAmount());
        }
        if (receivableDto.getServices() != null) {
            receivableEntity.setServices(receivableDto.getServices());
        }
        if (receivableDto.getDate() != null) {
            receivableEntity.setDate(receivableDto.getDate());
        }
        if (receivableDto.getInvoiceNumber() != null) {
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
        if (receivableDto.getPaymentMode() != null) {
            receivableEntity.setPaymentMode(receivableDto.getPaymentMode());
        }
        if (receivableDto.getReferenceNumber() != null) {
            receivableEntity.setReferenceNumber(receivableDto.getReferenceNumber());
        }
        if (receivableDto.getAdjustmentAmount() != 0) {
            receivableEntity.setAdjustmentAmount(receivableDto.getAdjustmentAmount());
        }
        if (receivableDto.getNotes() != null) {
            receivableEntity.setNotes(receivableDto.getNotes());
        }
        if (receivableDto.getTotalReceivableAmount() != 0) {
            receivableEntity.setTotalReceivableAmount(receivableDto.getTotalReceivableAmount());
        }
        if (receivableDto.getReceivedAmountTillDate() != 0) {
            receivableEntity.setReceivedAmountTillDate(receivableDto.getReceivedAmountTillDate());
        }
        if (receivableDto.getYetToReceivedAmount() != 0) {
            receivableEntity.setYetToReceivedAmount(receivableDto.getYetToReceivedAmount());
        }

        // Save the updated entity
        ReceivableEntity updatedEntity = receivableRepository.save(receivableEntity);
        ReceivableDto updatedDto = mapperConfig.toReceivableDto(updatedEntity);
        return new ApiResponse(true, "Receivable updated successfully", updatedDto, null);

    }

    @Override
    public ApiResponse softDeleteReceivable(Long id) {
        try {
            // Validate the ID
            if (id == null) {
                throw new IllegalArgumentException("The given ID must not be null.");
            }

            // Retrieve the entity or throw an exception if not found
            ReceivableEntity receivableEntity = receivableRepository.findById(id)
                    .orElseThrow(() -> new EntityNotFoundException("Receivable with ID " + id + " not found"));

            // Perform the soft delete by setting the delFlag to 1
            receivableEntity.setDelFlag(1);

            // Save the updated entity
            ReceivableEntity updatedEntity = receivableRepository.save(receivableEntity);
            ReceivableDto deletedReceivable = mapperConfig.toReceivableDto(updatedEntity);
            // Convert the entity to DTO
            return new ApiResponse(true, "Receivable successfully marked as deleted", deletedReceivable);
        } catch (EntityNotFoundException e) {
            // Handle case where Payment was not found
            return new ApiResponse(false, e.getMessage(), null);
        }
    }
}