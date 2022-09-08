package com.mintic.DevCore.interfaceServices;

import com.mintic.DevCore.model.Transaction;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface ITransactionService {

    @GetMapping("/get-all-transactions")
    List<Transaction> getAllTransactions();

    @GetMapping("/get-transaction/{id}")
    ResponseEntity<Transaction> getTransactionById(@PathVariable Long id);

    @PostMapping("/save-transaction")
    ResponseEntity<Transaction> createTransaction(@RequestBody Transaction transaction);
}
