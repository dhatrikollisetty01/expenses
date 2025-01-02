package com.ess.expenses.infrastructure.controllers;

import com.ess.expenses.core.constants.PaymentConstants;
import com.ess.expenses.core.constants.ReceivableContants;
import com.ess.expenses.core.dto.PaymentDto;
import com.ess.expenses.core.dto.ReceivableDto;
import com.ess.expenses.infrastructure.domain.sql.service.impl.PaymentService;
import com.ess.expenses.infrastructure.domain.sql.service.impl.PaymentServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(PaymentConstants.PAYMENT_PATH_URL)
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    @PostMapping(PaymentConstants.create)
    public ResponseEntity<PaymentDto> createPayment(@RequestBody PaymentDto paymentDto){
     PaymentDto createPayment =  paymentService.createPayment(paymentDto);
     return ResponseEntity.ok(createPayment);
    }


    @GetMapping(PaymentConstants.GET_BY_ID)
    public ResponseEntity<PaymentDto> getPaymentsById(@PathVariable Long Id){
        PaymentDto savedPayments = paymentService.getPaymentsById(Id);
        return ResponseEntity.ok(savedPayments);

    }

    @GetMapping(PaymentConstants.GET_ALL)
    public ResponseEntity<List<PaymentDto>> getAllPayments(){
        List<PaymentDto> allPayments= paymentService.getAllPayments();
        return ResponseEntity.ok(allPayments);
    }
    @PutMapping(PaymentConstants.UPDATE)
    public ResponseEntity<PaymentDto> updatePayments(@PathVariable Long id, @RequestBody PaymentDto paymentDto) {
        PaymentDto updatedPayments = paymentService.updatePayments(id, paymentDto);
        return ResponseEntity.ok(updatedPayments);

    }

    @DeleteMapping(PaymentConstants.DELETE)
    public ResponseEntity<PaymentDto> softDeletePayments(@PathVariable Long id) {
        // Call the service to perform the soft delete
        PaymentDto deletedPayments = paymentService.softDeletePayments(id);
        // Return the deleted receivable details in the response
        return ResponseEntity.ok(deletedPayments);
    }
}
