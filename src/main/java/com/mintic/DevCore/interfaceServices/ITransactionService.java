package com.mintic.DevCore.interfaceServices;

import com.mintic.DevCore.model.Transaction;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public interface ITransactionService {

    @GetMapping("/get-all-transactions")
    List<Transaction> getAllTransactions();

    @GetMapping("/get-transaction/{id}")
    ResponseEntity<Transaction> getTransactionById(@PathVariable Long id);

    @PostMapping("/save-transaction")
    ResponseEntity<Transaction> createTransaction(@RequestBody Transaction transaction);

    @DeleteMapping("/delete-transaction/{id}")
    ResponseEntity<Void> deleteTransaction(@PathVariable("id") Long id);

    @PatchMapping("/update-transaction/{id}")
    ResponseEntity<Transaction> updateTransaction(@PathVariable("id") Long id, @RequestBody Transaction transaction);
}
