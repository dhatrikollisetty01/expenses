package com.ess.expenses.infrastructure.controllers;

import com.ess.expenses.core.dto.PaymentDto;
import com.ess.expenses.infrastructure.domain.sql.service.impl.PaymentServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/payment")
public class PaymentController {

    @Autowired
    private PaymentServiceImp paymentServiceImp;

    @PostMapping
    public ResponseEntity<PaymentDto> createPayment(@RequestBody PaymentDto paymentDto){
     PaymentDto createPayment =  paymentServiceImp.createPayment(paymentDto);
     return ResponseEntity.ok(createPayment);
    }
}
