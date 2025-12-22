package com.example.demo.controller;

import com.example.demo.model.TransactionLog;
import com.example.demo.service.TransactionService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/transactions")
public class TransactionController {

    private final TransactionService service;

    public TransactionController(TransactionService service) {
        this.service = service;
    }

    @GetMapping
    public Object getAll() {
        return service.getAll();
    }

    @PostMapping
    public TransactionLog create(@RequestBody TransactionLog transaction) {
        return service.create(transaction);
    }

    // ✅ PUT update transaction
    @PutMapping("/{id}")
    public TransactionLog update(
            @PathVariable Long id,
            @RequestBody TransactionLog transaction) {
        return service.update(id, transaction);
    }
}
