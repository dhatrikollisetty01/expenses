package com.ess.expenses.infrastructure.domain.sql.model;

import com.ess.expenses.core.utils.Type;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PaymentEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PROD_ID")
    private  Long id;

    @Column(name = "TYPE")
    private Type type;

}
