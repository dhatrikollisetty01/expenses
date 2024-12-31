package com.ess.expenses.infrastructure.domain.sql.service.impl;

import com.ess.expenses.core.dto.ReceivableDto;

import java.util.List;

public interface ReceivableService {
    ReceivableDto createReceivable(ReceivableDto receivableDto);
    ReceivableDto getReceivableById(Long id);
    List<ReceivableDto> getAllReceivable();
    ReceivableDto updateReceivable(Long id, ReceivableDto receivableDto);
    ReceivableDto softDeleteReceivable(Long id);


}
