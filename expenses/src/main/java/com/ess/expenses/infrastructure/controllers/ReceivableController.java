package com.ess.expenses.infrastructure.controllers;

import com.ess.expenses.core.dto.ReceivableDto;
import com.ess.expenses.infrastructure.domain.sql.service.impl.ReceivableService;
import com.ess.expenses.infrastructure.domain.sql.service.impl.ReceivableServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/receivable")
public class ReceivableController {
    @Autowired
    private ReceivableServiceImpl receivableServiceImpl;

    @PostMapping("/create")
    public ResponseEntity<ReceivableDto> createReceivable(@RequestBody ReceivableDto receivableDto){
        ReceivableDto savedReceivable = receivableServiceImpl.createReceivable(receivableDto);
        return ResponseEntity.ok(savedReceivable);

    }

    @GetMapping("/{Id}")
    public ResponseEntity<ReceivableDto> getReceivableById(@PathVariable Long Id){
        ReceivableDto savedReceivable = receivableServiceImpl.getReceivableById(Id);
        return ResponseEntity.ok(savedReceivable);

    }

    @GetMapping
    public ResponseEntity<List<ReceivableDto>> getAllReceivable(){
        List<ReceivableDto> allReceivables = receivableServiceImpl.getAllReceivable();
        return ResponseEntity.ok(allReceivables);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ReceivableDto> updateReceivable(@PathVariable Long id, @RequestBody ReceivableDto receivableDto) {
        ReceivableDto updatedReceivable = receivableServiceImpl.updateReceivable(id, receivableDto);

        return ResponseEntity.ok(updatedReceivable);

    }

    @DeleteMapping("/{Id}")
    public ResponseEntity<ReceivableDto> deleteReceivable(@PathVariable Long Id) {
       ReceivableDto receivableDto= receivableServiceImpl.softDeleteReceivable(Id);
        return ResponseEntity.ok(receivableDto);
    }
}
