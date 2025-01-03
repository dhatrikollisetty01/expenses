package com.ess.expenses.infrastructure.controllers;

import com.ess.expenses.core.constants.ReceivableConstant;
import com.ess.expenses.core.dto.ReceivableDto;
import com.ess.expenses.core.exceptions.CustomException;
import com.ess.expenses.core.req.ExpensesReq;
import com.ess.expenses.core.resp.ApiResponse;
import com.ess.expenses.infrastructure.domain.sql.service.impl.ReceivableServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping(ReceivableConstant.RECEIVABLE_PATH_URL)
public class ReceivableController {
    @Autowired
    private ReceivableServiceImpl receivableServiceImpl;

    @PostMapping(ReceivableConstant.create)

    public ResponseEntity<ApiResponse> createReceivable(@RequestBody ExpensesReq expensesReq){
        try{
            ApiResponse response = receivableServiceImpl.createReceivable(expensesReq);
            return ResponseEntity.ok(response);
        }
         catch(CustomException e){
            throw new CustomException(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping(ReceivableConstant.GET_BY_ID)
    public ResponseEntity<ApiResponse> getReceivableById(@PathVariable Long id){
        ApiResponse response  = receivableServiceImpl.getReceivableById(id);
        return ResponseEntity.ok(response);
    }

    @GetMapping(ReceivableConstant.GET_ALL)
    public ResponseEntity<List<ApiResponse>> getAllReceivable(){
        ApiResponse response = receivableServiceImpl.getAllReceivable();
        return ResponseEntity.ok(Collections.singletonList(response));
    }

    @PutMapping(ReceivableConstant.UPDATE)
    public ResponseEntity<ApiResponse> updateReceivable(@PathVariable Long id, @RequestBody ReceivableDto receivableDto) {
        ApiResponse response  = receivableServiceImpl.updateReceivable(id, receivableDto);
        return ResponseEntity.ok(response);
    }

    @DeleteMapping(ReceivableConstant.DELETE)
    public ResponseEntity<ApiResponse> softDeleteReceivable(@PathVariable Long id) {
        ApiResponse response  = receivableServiceImpl.softDeleteReceivable(id);
        return ResponseEntity.ok(response);
    }
}