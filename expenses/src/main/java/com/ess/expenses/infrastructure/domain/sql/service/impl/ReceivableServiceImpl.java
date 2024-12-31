package com.ess.expenses.infrastructure.domain.sql.service.impl;

import com.ess.expenses.core.dto.ReceivableDto;
import com.ess.expenses.infrastructure.domain.sql.model.ReceivableEntity;
import com.ess.expenses.infrastructure.domain.sql.repository.ReceivableRepository;
import com.ess.expenses.infrastructure.domain.sql.service.handler.MapperConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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



}
