package com.ess.expenses.infrastructure.domain.sql.audit;

import com.ess.expenses.infrastructure.domain.sql.audit.AuditImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.AuditorAware;
import org.springframework.stereotype.Component;

@Component
public class AuditConfig {

    @Bean
    public AuditorAware<String> auditorProvider() {
        return new AuditImpl();
    }
}