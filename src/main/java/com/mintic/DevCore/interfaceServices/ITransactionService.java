package com.mintic.DevCore.interfaceServices;

import com.mintic.DevCore.model.Transaction;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

public interface ITransactionService {

    @GetMapping("/get-all-transactions")
    List<Transaction> getAllTransactions();

    @GetMapping("/get-transaction/{id}")
    ResponseEntity<Transaction> getTransactionById(@PathVariable Long id);

    @PostMapping("/save-transaction")
    ResponseEntity<Transaction> createTransaction(@RequestBody Transaction transaction);

    @PatchMapping("/update-transaction/{id}")
    ResponseEntity<Transaction> updateTransaction(@PathVariable Long id, @RequestBody Map<Object, Object> fields);

    @DeleteMapping("/delete-transaction/{id}")
    ResponseEntity<Void> deleteTransaction(@PathVariable("id") Long id);

}
