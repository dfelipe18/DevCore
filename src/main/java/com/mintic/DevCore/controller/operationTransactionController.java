package com.mintic.DevCore.controller;

import com.mintic.DevCore.model.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;
import java.util.Optional;

@Controller
public class operationTransactionController {

    @Autowired
    private TransactionController transactionRepo;

    @GetMapping("/get-transactions")
    public String getTransactions(Model model) {
        List<Transaction> transactions = transactionRepo.getAllTransactions();
        model.addAttribute("transactions", transactions);
        return "get-transactions";
    }
    @GetMapping("/create-transaction")
    public String createTransaction(Model model) {
        model.addAttribute("transaction", new Transaction());
        model.addAttribute("message", "Generar transacciones:");
        return "create-transaction";
    }

    @PostMapping("/save-transaction")
    public String saveTransaction(Transaction transaction) {
        ResponseEntity<Transaction> response = transactionRepo.createTransaction(transaction);
        if (response.getStatusCodeValue() == 200) {
            return "redirect:/get-transactions";
        } else {
            return "create-transaction";
        }
    }

    @GetMapping("/update-transaction/{id}")
    public String updateTransaction(@PathVariable Long id, Model model) {
        Optional<Transaction> transaction = transactionRepo.getTransactionById(id);
        model.addAttribute("transaction", transaction);
        model.addAttribute("message", "Actualizar transacciones:");
        return "create-transaction";
    }

    @GetMapping("/delete-transaction/{id}")
    public String deleteTransaction(Model model, @PathVariable Long id) {
        transactionRepo.deleteTransaction(id);
        return "redirect:/get-transactions";
    }
}
