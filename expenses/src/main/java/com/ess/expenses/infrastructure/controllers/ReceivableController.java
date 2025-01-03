package com.ess.expenses.infrastructure.controllers;

import com.ess.expenses.core.constants.ReceivableContants;
import com.ess.expenses.core.dto.ReceivableDto;
import com.ess.expenses.core.req.ExpensesReq;
import com.ess.expenses.core.resp.ApiResponse;
import com.ess.expenses.infrastructure.domain.sql.service.impl.ReceivableService;
import com.ess.expenses.infrastructure.domain.sql.service.impl.ReceivableServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController

@RequestMapping(ReceivableContants.RECEIVABLE_PATH_URL)
public class ReceivableController {
    @Autowired
    private ReceivableServiceImpl receivableServiceImpl;

    @PostMapping(ReceivableContants.create)
    public ResponseEntity<ApiResponse> createReceivable(@RequestBody ExpensesReq  expensesReq){
        ApiResponse response = receivableServiceImpl.createReceivable(expensesReq);
        return ResponseEntity.ok(response);

    }

    @GetMapping(ReceivableContants.GET_BY_ID)
    public ResponseEntity<ApiResponse> getReceivableById(@PathVariable Long Id){
        ApiResponse response = receivableServiceImpl.getReceivableById(Id);
        return ResponseEntity.ok(response);

    }

    @GetMapping(ReceivableContants.GET_ALL)
    public ResponseEntity<ApiResponse> getAllReceivable(){
        ApiResponse response = receivableServiceImpl.getAllReceivable();
        return ResponseEntity.ok(response);
    }

    @PutMapping(ReceivableContants.UPDATE)
    public ResponseEntity<ApiResponse> updateReceivable(@PathVariable Long id, @RequestBody ExpensesReq expensesReq) {
        ApiResponse response = receivableServiceImpl.updateReceivable(id, expensesReq);

        return ResponseEntity.ok(response);

    }

    @DeleteMapping(ReceivableContants.DELETE)
    public ResponseEntity<ApiResponse> softDeleteReceivable(@PathVariable Long id) {
        // Call the service to perform the soft delete
        ApiResponse response = receivableServiceImpl.softDeleteReceivable(id);

        // Return the deleted receivable details in the response
        return ResponseEntity.ok(response);
    }
}
