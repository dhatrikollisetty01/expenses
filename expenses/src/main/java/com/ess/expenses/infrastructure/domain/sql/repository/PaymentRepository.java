package com.ess.expenses.infrastructure.domain.sql.repository;

import com.ess.expenses.infrastructure.domain.sql.model.PaymentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaymentRepository extends JpaRepository<PaymentEntity,Long> {

}
