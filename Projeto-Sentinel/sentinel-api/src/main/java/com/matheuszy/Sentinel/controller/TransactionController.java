package com.matheuszy.Sentinel.controller;

import com.matheuszy.Sentinel.domain.dto.TransactionRequest;
import com.matheuszy.Sentinel.domain.entities.Transaction;
import com.matheuszy.Sentinel.services.TransactionService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/transactions")
public class TransactionController {

    private final TransactionService service;

    public TransactionController(TransactionService service) {
        this.service = service;
    }

    @PostMapping()
    public ResponseEntity<Transaction> createTransaction(@RequestBody @Valid  TransactionRequest transactionRequest) {
        Transaction transaction = service.save(transactionRequest);
        return ResponseEntity.ok(transaction);
    }
}
