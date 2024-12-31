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
        ReceivableEntity receivableEntity=receivableRepository.findById(id).get();
        receivableEntity.setId(receivableDto.getId());
        receivableEntity.setType(receivableDto.getType());
        receivableEntity.setBillingAddress(receivableDto.getBillingAddress());
        receivableEntity.setPrimaryContact(receivableDto.getPrimaryContact());
        receivableEntity.setReceivedAmount(receivableDto.getReceivedAmount());
        receivableEntity.setServices(receivableDto.getServices());
        receivableEntity.setDate(receivableDto.getDate());
        receivableEntity.setInvoiceNumber(receivableDto.getInvoiceNumber());
        receivableEntity.setInvoiceDate(receivableDto.getInviceDate());
        receivableEntity.setDueDate(receivableDto.getDueDate());
        receivableEntity.setInvoiceAmount(receivableDto.getInvoiceAmount());
        receivableEntity.setPaymentMode(receivableDto.getPaymentMode());
        receivableEntity.setReferenceNumber(receivableDto.getReferenceNumber());
        receivableEntity.setAdjustmentAmount(receivableDto.getAdjustmentAmount());
        receivableEntity.setNotes(receivableDto.getNotes());
        receivableEntity.setTotalReceivableAmount(receivableDto.getTotalReceivableAmount());
        receivableEntity.setReceivedAmountTillDate(receivableDto.getReceivedAmountTillDate());
        receivableEntity.setYetToReceivedAmount(receivableDto.getYetToReceivedAmount());

        ReceivableEntity updatedEntity = receivableRepository.save(receivableEntity);
        ReceivableDto updatedDto = mapperConfig.toReceivableDto(updatedEntity);
        return updatedDto;

    }

    @Override
    public ReceivableDto softDeleteReceivable(Long id) {
        ReceivableEntity receivableEntity = receivableRepository.findById(id).get();
        receivableEntity.setDelFlag(1);
        ReceivableEntity receivableEntity1=receivableRepository.save(receivableEntity);
        ReceivableDto receivableDto=mapperConfig.toReceivableDto(receivableEntity1);
        return receivableDto;

    }
}
