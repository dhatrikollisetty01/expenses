package com.ess.expenses.infrastructure.domain.sql.service.impl;

import com.ess.expenses.core.dto.ReceivableDto;
import com.ess.expenses.core.utils.PurposeType;
import com.ess.expenses.core.utils.Type;
import com.ess.expenses.infrastructure.domain.sql.model.ReceivableEntity;
import com.ess.expenses.infrastructure.domain.sql.repository.ReceivableRepository;
import com.ess.expenses.infrastructure.domain.sql.service.handler.MapperConfig;
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
    public ReceivableDto createReceivable(ReceivableDto receivableDto) {
       ReceivableEntity  receivableEntity= mapperConfig.toReceivableEntity(receivableDto);
       ReceivableEntity saveEntity =receivableRepository.save(receivableEntity);
       ReceivableDto receivableDto1= mapperConfig.toReceivableDto(saveEntity);

       return receivableDto1;
    }

    @Override
    public ReceivableDto getReceivableById(Long id) {
        ReceivableEntity receivableEntity = receivableRepository.findById(id).get();
        ReceivableDto receivableDto = mapperConfig.toReceivableDto(receivableEntity);

        return receivableDto;
    }

    @Override
    public List<ReceivableDto> getAllReceivable() {
        List<ReceivableDto> invoiceDtos=receivableRepository.findAll().stream().
           map(mapperConfig::toReceivableDto).collect(toList());
    return invoiceDtos ;

    }
    @Override
    public ReceivableDto updateReceivable(Long id, ReceivableDto receivableDto) {
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

        ReceivableEntity updatedEntity = receivableRepository.save(receivableEntity);
        ReceivableDto updatedDto = mapperConfig.toReceivableDto(updatedEntity);
        return updatedDto;

    }

    @Override
    public ReceivableDto softDeleteReceivable(Long id) {
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

        // Convert the entity to DTO
        return mapperConfig.toReceivableDto(updatedEntity);
    }

}
