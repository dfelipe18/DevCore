package com.mintic.DevCore.controller;

import com.mintic.DevCore.interfaceServices.ITransactionService;
import com.mintic.DevCore.model.Transaction;
import com.mintic.DevCore.services.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.http.HttpResponse;
import java.util.List;

@RestController
@RequestMapping("/transactions")
public class TransactionController implements ITransactionService {

    @Autowired
    private TransactionService request;

    @Override
    public List<Transaction> getAllTransactions() {
        return request.listAllTransactions();
    }

    @Override
    public ResponseEntity<Transaction> getTransactionById(Long id) {
        return request.listTransactionById(id);
    }

    @Override
    public ResponseEntity<Transaction> createTransaction(Transaction transaction) {
        return request.saveTransaction(transaction);
    }
}
