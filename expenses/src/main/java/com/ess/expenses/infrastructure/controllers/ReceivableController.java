package com.ess.expenses.infrastructure.controllers;

import com.ess.expenses.core.constants.PaymentConstants;
import com.ess.expenses.core.constants.ReceivableContants;
import com.ess.expenses.core.dto.ReceivableDto;
import com.ess.expenses.core.exceptions.CustomException;
import com.ess.expenses.core.req.ExpensesReq;
import com.ess.expenses.core.resp.ApiResponse;
import com.ess.expenses.infrastructure.domain.sql.service.impl.ReceivableService;
import com.ess.expenses.infrastructure.domain.sql.service.impl.ReceivableServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping(ReceivableContants.RECEIVABLE_PATH_URL)
public class ReceivableController {
    @Autowired
    private ReceivableServiceImpl receivableServiceImpl;

    @PostMapping(ReceivableContants.create)

    public ResponseEntity<ApiResponse> createReceivable(@RequestBody ExpensesReq expensesReq){
        try{
            ApiResponse response = receivableServiceImpl.createReceivable(expensesReq);
            return ResponseEntity.ok(response);
        }
         catch(CustomException e){
            throw new CustomException(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping(ReceivableContants.GET_BY_ID)
    public ResponseEntity<ApiResponse> getReceivableById(@PathVariable Long Id){
        ApiResponse response  = receivableServiceImpl.getReceivableById(Id);
        return ResponseEntity.ok(response);
    }

    @GetMapping(ReceivableContants.GET_ALL)
    public ResponseEntity<List<ApiResponse>> getAllReceivable(){
        ApiResponse response = receivableServiceImpl.getAllReceivable();
        return ResponseEntity.ok((List<ApiResponse>) response);
    }

    @PutMapping(ReceivableContants.UPDATE)
    public ResponseEntity<ApiResponse> updateReceivable(@PathVariable Long id, @RequestBody ReceivableDto receivableDto) {
        ApiResponse response  = receivableServiceImpl.updateReceivable(id, receivableDto);
        return ResponseEntity.ok(response);

    }

    @DeleteMapping(ReceivableContants.DELETE)
    public ResponseEntity<ApiResponse> softDeleteReceivable(@PathVariable Long id) {
        ApiResponse response  = receivableServiceImpl.softDeleteReceivable(id);
        return ResponseEntity.ok(response);
    }
}