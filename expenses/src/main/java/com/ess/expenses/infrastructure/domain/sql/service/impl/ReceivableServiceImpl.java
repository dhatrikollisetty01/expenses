package com.ess.expenses.infrastructure.domain.sql.service.impl;

import com.ess.expenses.core.dto.ReceivableDto;
import com.ess.expenses.core.req.ExpensesReq;
import com.ess.expenses.core.resp.ApiResponse;
import com.ess.expenses.core.utils.PurposeType;
import com.ess.expenses.core.utils.Type;
import com.ess.expenses.infrastructure.domain.sql.model.ReceivableEntity;
import com.ess.expenses.infrastructure.domain.sql.repository.ReceivableRepository;
import com.ess.expenses.infrastructure.domain.sql.service.handler.MapperConfig;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.Date;
import java.util.List;

import static java.util.stream.Collectors.toList;

@Service
public class ReceivableServiceImpl implements ReceivableService{
    @Autowired
    private MapperConfig mapperConfig;

    @Autowired
    private ReceivableRepository receivableRepository;

    @Override
    public ApiResponse createReceivable(ExpensesReq expensesReq) {
       ReceivableEntity  receivableEntity= mapperConfig.toReceivableEntity(expensesReq.getReceivableDetails());
       ReceivableEntity saveEntity =receivableRepository.save(receivableEntity);
       ReceivableDto receivableDto1= mapperConfig.toReceivableDto(saveEntity);

       return new ApiResponse("successfully created",receivableDto1);
    }

    @Override
    public ApiResponse getReceivableById(Long id) {
        ReceivableEntity receivableEntity = receivableRepository.findById(id).get();
        ReceivableDto receivableDto = mapperConfig.toReceivableDto(receivableEntity);

        return new ApiResponse("successfully get receivable", receivableDto);
    }

    @Override
    public ApiResponse getAllReceivable() {
        List<ReceivableDto> receivableDtos=receivableRepository.findAll().stream().
           map(mapperConfig::toReceivableDto).collect(toList());
return new ApiResponse("success", receivableDtos);
    }
    @Override
    public ApiResponse updateReceivable(Long id, ExpensesReq expensesReq) {
        // Fetch the existing entity
        ReceivableEntity receivableEntity = receivableRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Receivable with ID " + id + " not found"));

        // Map fields selectively
        if (expensesReq.getReceivableDetails() .getType() != null) {
            receivableEntity.setType(expensesReq.getReceivableDetails().getType());
        }
        if (expensesReq.getReceivableDetails().getBillingAddress() != null) {
            receivableEntity.setBillingAddress(expensesReq.getReceivableDetails().getBillingAddress());
        }
        if (expensesReq.getReceivableDetails().getPrimaryContact() != null) {
            receivableEntity.setPrimaryContact(expensesReq.getReceivableDetails().getPrimaryContact());
        }
        if (expensesReq.getReceivableDetails().getReceivedAmount() != null) {
            receivableEntity.setReceivedAmount(expensesReq.getReceivableDetails().getReceivedAmount());
        }
        if (expensesReq.getReceivableDetails().getServices() != null) {
            receivableEntity.setServices(expensesReq.getReceivableDetails().getServices());
        }
        if (expensesReq.getReceivableDetails().getDate() != null) {
            receivableEntity.setDate(expensesReq.getReceivableDetails().getDate());
        }
        if (expensesReq.getReceivableDetails().getInvoiceNumber() != null) {
            receivableEntity.setInvoiceNumber(expensesReq.getReceivableDetails().getInvoiceNumber());
        }
        if (expensesReq.getReceivableDetails().getInvoiceDate() != null) {
            receivableEntity.setInvoiceDate(expensesReq.getReceivableDetails().getInvoiceDate());
        }
        if (expensesReq.getReceivableDetails().getDueDate() != null) {
            receivableEntity.setDueDate(expensesReq.getReceivableDetails().getDueDate());
        }
        if (expensesReq.getReceivableDetails().getInvoiceAmount() != 0) {
            receivableEntity.setInvoiceAmount(expensesReq.getReceivableDetails().getInvoiceAmount());
        }
        if (expensesReq.getReceivableDetails().getPaymentMode() != null) {
            receivableEntity.setPaymentMode(expensesReq.getReceivableDetails().getPaymentMode());
        }
        if (expensesReq.getReceivableDetails().getReferenceNumber() != null) {
            receivableEntity.setReferenceNumber(expensesReq.getReceivableDetails().getReferenceNumber());
        }
        if (expensesReq.getReceivableDetails().getAdjustmentAmount() != 0) {
            receivableEntity.setAdjustmentAmount(expensesReq.getReceivableDetails().getAdjustmentAmount());
        }
        if (expensesReq.getReceivableDetails().getNotes() != null) {
            receivableEntity.setNotes(expensesReq.getReceivableDetails().getNotes());
        }
        if (expensesReq.getReceivableDetails().getTotalReceivableAmount() != 0) {
            receivableEntity.setTotalReceivableAmount(expensesReq.getReceivableDetails().getTotalReceivableAmount());
        }
        if (expensesReq.getReceivableDetails().getReceivedAmountTillDate() != 0) {
            receivableEntity.setReceivedAmountTillDate(expensesReq.getReceivableDetails().getReceivedAmountTillDate());
        }
        if (expensesReq.getReceivableDetails().getYetToReceivedAmount() != 0) {
            receivableEntity.setYetToReceivedAmount(expensesReq.getReceivableDetails().getYetToReceivedAmount());
        }

        ReceivableEntity updatedEntity = receivableRepository.save(receivableEntity);
        ReceivableDto updatedDto = mapperConfig.toReceivableDto(updatedEntity);
        return new ApiResponse("succesfully updated", updatedDto);

    }

    @Override
    public ApiResponse softDeleteReceivable(Long id) {
        // Validate the ID
        if (id == null) {
            throw new IllegalArgumentException("The given ID must not be null.");
        }

        // Retrieve the entity or throw an exception if not found
        ReceivableEntity receivableEntity = receivableRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Receivable with ID " + id + " not found"));

        // Perform the soft delete by setting the delFlag to 1
        receivableEntity.setDelFlag(0);

        // Save the updated entity
        ReceivableEntity updatedEntity = receivableRepository.save(receivableEntity);

        // Convert the entity to DTO
        return new ApiResponse("seccussfully deleted", updatedEntity);
    }

}
