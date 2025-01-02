package com.ess.expenses.infrastructure.controllers;

import com.ess.expenses.core.constants.ReceivableContants;
import com.ess.expenses.core.dto.ReceivableDto;
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
    public ResponseEntity<ReceivableDto> createReceivable(@RequestBody ReceivableDto receivableDto){
        ReceivableDto savedReceivable = receivableServiceImpl.createReceivable(receivableDto);
        return ResponseEntity.ok(savedReceivable);

    }

    @GetMapping(ReceivableContants.GET_BY_ID)
    public ResponseEntity<ReceivableDto> getReceivableById(@PathVariable Long Id){
        ReceivableDto savedReceivable = receivableServiceImpl.getReceivableById(Id);
        return ResponseEntity.ok(savedReceivable);

    }

    @GetMapping(ReceivableContants.GET_ALL)
    public ResponseEntity<List<ReceivableDto>> getAllReceivable(){
        List<ReceivableDto> allReceivables = receivableServiceImpl.getAllReceivable();
        return ResponseEntity.ok(allReceivables);
    }

    @PutMapping(ReceivableContants.UPDATE)
    public ResponseEntity<ReceivableDto> updateReceivable(@PathVariable Long id, @RequestBody ReceivableDto receivableDto) {
        ReceivableDto updatedReceivable = receivableServiceImpl.updateReceivable(id, receivableDto);

        return ResponseEntity.ok(updatedReceivable);

    }

    @DeleteMapping(ReceivableContants.DELETE)
    public ResponseEntity<ReceivableDto> softDeleteReceivable(@PathVariable Long id) {
        // Call the service to perform the soft delete
        ReceivableDto deletedReceivable = receivableServiceImpl.softDeleteReceivable(id);

        // Return the deleted receivable details in the response
        return ResponseEntity.ok(deletedReceivable);
    }
}
