package com.ess.expenses.infrastructure.domain.sql.service.handler;

import com.ess.expenses.core.dto.ReceivableDto;
import com.ess.expenses.infrastructure.domain.sql.model.ReceivableEntity;
import org.springframework.stereotype.Component;

@Component
public interface MapperConfig {
    ReceivableDto toReceivableDto(ReceivableEntity receivableEntity);
    ReceivableEntity toReceivableEntity(ReceivableDto receivableDto);


}
