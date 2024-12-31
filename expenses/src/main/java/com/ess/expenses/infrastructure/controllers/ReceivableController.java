package com.ess.expenses.infrastructure.controllers;

import com.ess.expenses.core.dto.ReceivableDto;
import com.ess.expenses.infrastructure.domain.sql.service.impl.ReceivableService;
import com.ess.expenses.infrastructure.domain.sql.service.impl.ReceivableServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/receivable")
public class ReceivableController {
    @Autowired
    private ReceivableServiceImpl receivableServiceImpl;

    @PostMapping
    public ResponseEntity<ReceivableDto> createReceivable(@RequestBody ReceivableDto receivableDto){
        ReceivableDto savedReceivable = receivableServiceImpl.createReceivable(receivableDto);
        return ResponseEntity.ok(savedReceivable);

    }

}
