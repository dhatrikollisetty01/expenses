package com.ess.expenses.infrastructure.controllers;

import com.ess.expenses.core.constants.PaymentConstants;
import com.ess.expenses.core.dto.PaymentDto;
import com.ess.expenses.core.exceptions.CustomException;
import com.ess.expenses.core.req.ExpensesReq;
import com.ess.expenses.core.resp.ApiResponse;
import com.ess.expenses.infrastructure.domain.sql.service.impl.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(PaymentConstants.PAYMENT_PATH_URL)
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    @PostMapping(PaymentConstants.create)
    public ResponseEntity<ApiResponse> createPayment(@RequestBody ExpensesReq expensesReq) {
        try {
            ApiResponse response = paymentService.createPayment(expensesReq);
            return ResponseEntity.ok(response);
        }
        catch(CustomException e){
            throw new CustomException(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping(PaymentConstants.GET_BY_ID)
    public ResponseEntity<ApiResponse> getPaymentsById(@PathVariable Long Id){
        ApiResponse response = paymentService.getPaymentsById(Id);
        return ResponseEntity.ok(response);
    }

    @GetMapping(PaymentConstants.GET_ALL)
    public ResponseEntity<List<ApiResponse>> getAllPayments(){
        ApiResponse response= paymentService.getAllPayments();
        return ResponseEntity.ok((List<ApiResponse>) response);
    }
    @PutMapping(PaymentConstants.UPDATE)
    public ResponseEntity<ApiResponse> updatePayments(@PathVariable Long id, @RequestBody PaymentDto paymentDto) {
        ApiResponse response = paymentService.updatePayments(id, paymentDto);
        return ResponseEntity.ok(response);

    }

    @DeleteMapping(PaymentConstants.DELETE)
    public ResponseEntity<ApiResponse> softDeletePayments(@PathVariable Long id) {
        // Call the service to perform the soft delete
        ApiResponse response = paymentService.softDeletePayments(id);
        // Return the deleted receivable details in the response
        return ResponseEntity.ok(response);
    }
}