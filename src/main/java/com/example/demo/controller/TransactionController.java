package com.example.demo.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import com.example.demo.model.TransactionLog;
import com.example.demo.service.TransactionService;

@RestController
@RequestMapping("/transactions")
public class TransactionController {

    private final TransactionService service;

    public TransactionController(TransactionService service) {
        this.service = service;
    }

    @PostMapping("/{userId}")
    @ResponseStatus(HttpStatus.CREATED)
    public TransactionLog addTransaction(
            @PathVariable Long userId,
            @RequestBody TransactionLog log) {

        return service.addTransaction(userId, log);
    }

    @GetMapping("/{userId}")
    public List<TransactionLog> getUserTransactions(
            @PathVariable Long userId) {

        return service.getUserTransactions(userId);
    }
}
