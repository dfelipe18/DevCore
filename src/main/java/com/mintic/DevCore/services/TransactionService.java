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

    /*
     * Método para listar todas las transacciones.
     * Creamos una lista de transacciones y luego realizamos la búsqueda
     * de todos los registros y los añadimos a la lista, luego retornamos la lista.
     */
    public List<Transaction> listAllTransactions() {
        List<Transaction> transactions = new ArrayList<>();
        transactions.addAll(repository.findAll());
        return transactions;
    }

    /*
    * Método para listar una transacción por el ID, primero buscamos
    * la transacción por su ID, luego valdiamos si está presente en la consulta
    * y por último retornamos el objeto encontrado.
    */
    public ResponseEntity<Transaction> listTransactionById(long id) {
        Optional<Transaction> transaction = repository.findById(id);
        if(transaction.isPresent()) {
            return ResponseEntity.ok(transaction.get());
        } else {
            return ResponseEntity.noContent().build();
        }
    }

    /*
     * Método para guardar una transacción.
     * Validamos que el objeto sea diferente de nulo, y luego pasamos
     * el objeto al método de guardar y retornamos el HTTP RESPONSE.
     */
    public ResponseEntity<Transaction> saveTransaction(Transaction transaction) {
        if (!transaction.equals(null)) {
            repository.save(transaction);
            return ResponseEntity.ok(transaction);
        } else {
            return ResponseEntity.noContent().build();
        }
    }

    /*
     * Método para actualizar una transacción.
     * Validamos la transacción que exista, luego vamos a setear los campos
     * de dicha transacción.
     */
    public ResponseEntity<Transaction> updateTransaction(Long id, Transaction transaction) {
        Optional<Transaction> rqsTransaction = repository.findById(id);
        if (rqsTransaction.isPresent()) {
            Transaction updateTransaction = rqsTransaction.get();
            updateTransaction.setAmount(transaction.getAmount());
            updateTransaction.setConcept(transaction.getConcept());
            updateTransaction.setUpdateAt(transaction.getUpdateAt());
            repository.save(updateTransaction);
            return ResponseEntity.ok(updateTransaction);
        } else {
            return ResponseEntity.noContent().build();
        }
    }


    /*
     * Método para eliminar una transacción.
     * Validamos que el objeto esté presente y luego le pasamos el ID,
     * para su eliminación, por último retornamos el HTTP RESPONSE.
     */
    public ResponseEntity<Void> deleteTransaction(Long id) {
        Optional<Transaction> transaction = repository.findById(id);
        if (transaction.isPresent()) {
            repository.deleteById(id);
        }
        return ResponseEntity.ok(null);
    }
}
