package com.ess.expenses.infrastructure.domain.sql.audit;

import org.springframework.data.domain.AuditorAware;
import org.springframework.stereotype.Component;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Optional;

@Component
public class AuditImpl implements AuditorAware<String> {


    @Override
    public Optional<String> getCurrentAuditor() {
        return Optional.ofNullable(SecurityContextHolder.getContext().getAuthentication())
                .map(authentication -> authentication.getName());
    }


//    @Override
//    public Optional<String> getCurrentAuditor() {
//        // Fetching the username from SecurityContextHolder
//        return Optional.ofNullable(SecurityContextHolder.getContext().getAuthentication())
//                .map(authentication -> {
//                    if (authentication.getPrincipal() instanceof UserDetails) {
//                        return ((UserDetails) authentication.getPrincipal()).getUsername();
//                    } else {
//                        return authentication.getPrincipal().toString();
//                    }
//                });
//    }
}
