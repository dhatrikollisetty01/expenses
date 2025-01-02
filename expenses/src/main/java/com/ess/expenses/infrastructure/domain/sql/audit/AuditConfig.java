package com.ess.expenses.infrastructure.domain.sql.audit;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@Configuration
@EnableJpaAuditing(auditorAwareRef = "auditorAwareImpl")
public class AuditConfig {
//    @Bean
//    public AuditorAware<String> auditorProvider() {
//        return new AuditImpl();
//    }
}
