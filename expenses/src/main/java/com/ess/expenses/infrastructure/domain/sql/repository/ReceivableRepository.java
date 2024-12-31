package com.ess.expenses.infrastructure.domain.sql.repository;

import com.ess.expenses.infrastructure.domain.sql.model.ReceivableEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReceivableRepository extends JpaRepository<ReceivableEntity, Long> {
}
