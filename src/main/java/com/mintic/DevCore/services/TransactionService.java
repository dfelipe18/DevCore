package com.mintic.DevCore.services;

import com.mintic.DevCore.interfaces.ITransaction;
import com.mintic.DevCore.model.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TransactionService {

    @Autowired
    private ITransaction repository;

    public List<Transaction> listAllTransactions() {
        List<Transaction> transactions = new ArrayList<>();
        transactions.addAll(repository.findAll());
        return transactions;
    }

    public ResponseEntity<Transaction> listTransactionById(long id) {
        Optional<Transaction> transaction = repository.findById(id);
        if(transaction.isPresent()) {
            return ResponseEntity.ok(transaction.get());
        } else {
            return ResponseEntity.noContent().build();
        }
    }

    public ResponseEntity<Transaction> saveTransaction(Transaction transaction) {
        if (!transaction.equals(null)) {
            repository.save(transaction);
            return ResponseEntity.ok(transaction);
        } else {
            return ResponseEntity.noContent().build();
        }
    }
}
