package com.ess.expenses.infrastructure.domain.sql.audit;

import org.springframework.data.domain.AuditorAware;

import java.util.Optional;

public class AuditImpl implements AuditorAware<String> {

    @Override
    public Optional<String> getCurrentAuditor() {
        // Return the system user as the default auditor (could be replaced with authenticated user)
        return Optional.of("System");
        // You could also return Optional.of("admin") or get the logged-in user dynamically
    }
}
